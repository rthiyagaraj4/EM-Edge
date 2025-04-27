package jsp_servlet._eae._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aeregisterpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AERegisterPopulate.jsp", 1742461198112L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n  <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n\t<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<!--Added by Dharma on Aug 22nd 2017 against ML-MMOH-CRF-0631 [IN:062148] Start-->\n\t<script  language=\'javascript\'>\n\t\tvar frameRef\t= eval(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\");\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<!--Added by Dharma on Aug 22nd 2017 against ML-MMOH-CRF-0631 [IN:062148] End-->\n\t</head>\n\t<BODY class=\'message\' onKeyDown = \'lockKey()\'>\n\t<form>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t        <script>\n\n\t\t\t\t   //\tvar opt1\t= top.content.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t   \tvar opt1\t= frameRef.frames[1].document.createElement(\"OPTION\");//Modified by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t\t\t\t\topt1.text\t= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t     \topt1.value\t= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t//top.content.frames[1].document.forms[0].ae_pat_history_service.add(opt1);\n\t\t\t\t\tframeRef.frames[1].document.forms[0].ae_pat_history_service.add(opt1);//Modified by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t  \t        </script>\t\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t          <script>\n\t\t          \tvar opt\t\t= parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t     \topt.text\t= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t   \topt.value\t= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"==1)\n                      opt.selected = true;\n\t\t\t\t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t  \n\t\t\t\t  \n\t\t\t\t ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t  opt.selected = true;\n\t\t\t\t ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\n\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].visit_type.add(opt);\n\t\t\t\t\n\t              </script>\t\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t        <script>\t\t\t\t  \n\t\t\t\t   \t//var opt1\t= top.content.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t   \tvar opt1\t= frameRef.frames[1].frames[2].document.createElement(\"OPTION\");//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t\t\t     \topt1.text\t= \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\topt1.selected=true;\n\t\t\t\t\t//top.content.frames[1].frames[2].document.forms[0].service.add(opt1);\n\t\t\t\t\tframeRef.frames[1].frames[2].document.forms[0].service.add(opt1);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t//top.content.frames[1].frames[2].document.forms[0].service.add(opt1);\n\t\t\t\t\tframeRef.frames[1].frames[2].document.forms[0].service.add(opt1);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\n\t  \t        </script>\t\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t   <script>\n\t\t\t\t   /*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014*/\n\t\t\t\t  // if(top.content.frames[1].frames[2].document.forms[0].priority11!=null){//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t\t\t\t   if(frameRef.frames[1].frames[2].document.forms[0].priority11!=null){//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t\t\t\t\t   //\tvar optp\t= top.content.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t   \tvar optp\t= frameRef.frames[1].frames[2].document.createElement(\"OPTION\");//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t\t\t\t     \toptp.text\t= \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t     \toptp.value\t= \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\t\t//top.content.frames[1].frames[2].document.forms[0].priority11.add(optp);\n\t\t\t\t\t\t frameRef.frames[1].frames[2].document.forms[0].priority11.add(optp);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t\t\t\t   }\n\t  \t        </script>\t\n   \t   \t\t\t\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t       <script>\n\t\t          //  var opt2 = top.content.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t            var opt2 =  frameRef.frames[1].frames[2].document.createElement(\"OPTION\");//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t\t\t     \topt2.text\t= \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t     \topt2.value\t= \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\t//top.content.frames[1].frames[2].document.forms[0].sub_service.add(opt2);\n\t\t\t\t\t frameRef.frames[1].frames[2].document.forms[0].sub_service.add(opt2);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t    \t   </script>\t\n\t       ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t    \t   <script>\n\t\t           // var opt3 = top.content.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t            var opt3 = frameRef.frames[1].frames[2].document.createElement(\"OPTION\");//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t\t\t     \topt3.text\t= \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t     \topt3.value\t= \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\t\t//top.content.frames[1].frames[2].document.forms[0].mode_of_arrival.add(opt3);\n\t\t\t\t\tframeRef.frames[1].frames[2].document.forms[0].mode_of_arrival.add(opt3);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] \n\t  \t       </script>\t\n\t     ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t            <script>\n\t\t            /*Below Condition Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014*/\n\t\t            //if(top.content.frames[1].frames[2].document.forms[0].treat_area!=null){\n\t\t            if(frameRef.frames[1].frames[2].document.forms[0].treat_area!=null){//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148]\n\t\t\t             // var opt4 = top.content.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t              var opt4 = frameRef.frames[1].frames[2].document.createElement(\"OPTION\");//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148]\n\t\t\t\t     \t      opt4.text\t    = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t     \t      opt4.value\t= \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\t\t\t  if(\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"==1)\n\t\t\t\t\t      {\n\t                        opt4.selected = true;\n\t\t\t\t\t\t\t/*top.content.frames[1].frames[2].document.forms[0].bed_bay_no.value = \"\";\n\t\t\t\t            top.content.frames[1].frames[2].document.forms[0].bed_bay_no.disabled = false;\n\t\t\t\t            top.content.frames[1].frames[2].document.forms[0].bed_button.disabled = false;*/\n\t\t\t\t\t\t\tframeRef.frames[1].frames[2].document.forms[0].bed_bay_no.value = \"\";\n\t\t\t\t            frameRef.frames[1].frames[2].document.forms[0].bed_bay_no.disabled = false;\n\t\t\t\t            frameRef.frames[1].frames[2].document.forms[0].bed_button.disabled = false;\n\n\t\t\t\t\t\t\t/*Added by Rameswar on 10-Feb-16 for GDOH-CRF-081*/\n\t\t\t\t\t\t\t//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] Start\n\t\t\t\t\t\t\t/*if(top.content.frames[1].frames[2].document.forms[0].isPracApplicable.value==\"true\"){\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[2].document.forms[0].pract_button.disabled = false;\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[2].document.forms[0].practitioner_desc.disabled = false;\n\t\t\t\t\t\t\t\ttop.content.frames[1].frames[2].document.forms[0].pract_mand_img.style.visibility\t=\t\'visible\';\n\t\t\t\t\t\t\t}*/\n\n\t\t\t\t\t\t\tif(frameRef.frames[1].frames[2].document.forms[0].isPracApplicable.value==\"true\"){\n\t\t\t\t\t\t\t\tframeRef.frames[1].frames[2].document.forms[0].pract_button.disabled = false;\n\t\t\t\t\t\t\t\tframeRef.frames[1].frames[2].document.forms[0].practitioner_desc.disabled = false;\n\t\t\t\t\t\t\t\tframeRef.frames[1].frames[2].document.forms[0].pract_mand_img.style.visibility\t=\t\'visible\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148] End\n\t\t\t\t\t\t\t/*Added by Rameswar on 10-Feb-16 for GDOH-CRF-081*/\n\t\t\t\t\t\t  }\n\t\t\t\t\t\t  //top.content.frames[1].frames[2].document.forms[0].treat_area.add(opt4);\n\t\t\t\t\t\t  frameRef.frames[1].frames[2].document.forms[0].treat_area.add(opt4);//Modified by Dharma on Aug 21st 2017 against ML-MMOH-CRF-0631 [IN:062148]\n\t\t            }\n\t\t\t\t\t  \n\t  \t            </script>\t\n    ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t            <script>\n\t\t\t\t\t\t\n\t\t              var opt9= parent.frames[2].document.createElement(\"OPTION\");\n\t\t\t     \t      opt9.text\t= \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t     \t      opt9.value\t= \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"==\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\")\n\n\t\t\t\t\t\t   opt9.selected\t=true;\n\t\t\t\t\t\t  parent.frames[2].document.forms[0].treat_area.add(opt9);\n\t  \t            </script>\t\n    ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t            <script>\n\t\t\t\t\t\t\n\t\t              var opt99= parent.frames[2].document.createElement(\"OPTION\");\n\t\t\t     \t      opt99.text\t= \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\t     \t      opt99.value\t= \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\n\t\t\t\t\t\t   if(\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\")\n\t\t\t\t\t\t   opt99.selected\t=true;\n\n\t\t\t\t\t\t   parent.frames[2].document.forms[0].priority11.add(opt99);\n\t  \t            </script>\t\n\t\t\t  ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t    <script>\t\n\t\t\t\t      //top.content.frames[1].frames[2].document.forms[0].visit_within_24hrs.disabled = true;\n\t\t\t\t      frameRef.frames[1].frames[2].document.forms[0].visit_within_24hrs.disabled = true;\n                    </script>\n\t\t\t\t   ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t    <script>\n                      //top.content.frames[1].frames[2].document.forms[0].visit_within_24hrs.disabled = false;\n                      frameRef.frames[1].frames[2].document.forms[0].visit_within_24hrs.disabled = false;\n               \t    </script>\n\t\t\t\t   ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t var msg = getMessage(\"INVALID_NAT_ID\",\"MP\");\n\t\t\t\t\t\t msg = msg.replace(\'#\',\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =".focus();\n\t\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =".value=\'\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t parent.frames[3].document.forms[0].";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =".focus();\n\t\t\t\t\t\t\t parent.frames[3].document.forms[0].";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t                 <script>\n\t\t                  //var opt6 = top.content.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t                  var opt6 = frameRef.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t     \t      opt6.text \t= \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\t\t     \t      opt6.value\t= \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\t\t\t     // top.content.frames[1].frames[2].document.forms[0].occ_of_per.add(opt6);\n\t\t\t\t\t     frameRef.frames[1].frames[2].document.forms[0].occ_of_per.add(opt6);\n\t  \t          </script>\t\n                 ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t          <script>\n\t\t             // var opt6 = top.content.frames[3].document.createElement(\"OPTION\");\n\t\t              var opt6 = frameRef.frames[3].document.createElement(\"OPTION\");\n\t\t\t     \t      opt6.text \t= \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\t\t\t\t     // top.content.frames[3].document.forms[0].occ_of_per.add(opt6);\n\t\t\t\t\t      frameRef.frames[3].document.forms[0].occ_of_per.add(opt6);\n\t  \t          </script>\t\n    ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n       \t\t\t <script> \n\t\t            var opt5 = parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t     \topt5.text\t= \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\t\t     \topt5.value\t= \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" == \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" )\n\t\t\t\t\t\topt5.selected = true;\n\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].injury.add(opt5);\n\t  \t         </script>\n\t        \t\n\n        \t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t        \t  <script> \n\t\t            var opt5 = parent.frames[2].document.createElement(\"OPTION\");\n\t\t\t     \topt5.text\t= \"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" )\n\t\t\t\t\t\topt5.selected = true;\n\t\t\t\t\tparent.frames[2].document.forms[0].injury.add(opt5);\n\t  \t         </script>\t\n\t    ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\t\n\t        \t  <script>\n\t\t            var opt5 = parent.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t     \topt5.text\t= \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\t\t\t\t\tparent.frames[1].frames[2].document.forms[0].mechan_injury.add(opt5);\n\t  \t         </script>\t\n\t    ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t    \t\t <script>\n\t\t            var opt5 = parent.frames[2].document.createElement(\"OPTION\");\n\t\t\t     \topt5.text\t= \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\t\t\t\tparent.frames[2].document.forms[0].mechan_injury.add(opt5);\n\t  \t         </script>\n\n\t    ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t<script>\t\t\t\t\t\t\t\n\t\t\t\t\t\t/*var selLength = top.content.frames[1].frames[2].document.forms[0].location.options.length;\n\t\t\t\t\t\tvar selObj = top.content.frames[1].frames[2].document.forms[0].location;*/\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar selLength = frameRef.frames[1].frames[2].document.forms[0].location.options.length;\n\t\t\t\t\t\tvar selObj = frameRef.frames[1].frames[2].document.forms[0].location;\n\t\t\t\t\t\tselObj.remove(0);\n\t\t\t\t\t\t//var opt5 = top.content.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\tvar opt5 = frameRef.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt5.text\t= \'------------------\' +getLabel(\"Common.defaultSelect.label\",\"Common\")+ \'----------------\';\n\t\t\t\t\t\topt5.value\t= \'\';\n\n\t\t\t\t\t\tvar cnt = 0;\n\t\t\t\t\t\tfor(var t=0;t<parseInt(selLength-1);t++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(selObj.options[t].value == \'\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tcnt++;\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(cnt == 0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//top.content.frames[1].frames[2].document.forms[0].location.add(opt5,0);\n\t\t\t\t\t\t\tframeRef.frames[1].frames[2].document.forms[0].location.add(opt5,0);\n\t\t\t\t\t\t}\n\n                    \t//var service\t= top.content.frames[1].frames[2].document.forms[0].service;\n                    \tvar service\t= frameRef.frames[1].frames[2].document.forms[0].service;\n\t\t\t\t\t\twhile(service.options.length >= 1)\n\t\t\t\t\t\tservice.remove(0);\n\n\t\t\t\t\t\t//var opt = top.content.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\tvar opt = frameRef.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text\t= \'----\' +getLabel(\"Common.defaultSelect.label\",\"Common\")+ \'----\';\n\t\t\t\t\t\topt.value\t= \'\';\n\t\t\t\t\t\t//top.content.frames[1].frames[2].document.forms[0].service.add(opt);\n\t\t\t\t\t\tframeRef.frames[1].frames[2].document.forms[0].service.add(opt);\n\n                    \t//var visit_type\t= top.content.frames[1].frames[2].document.forms[0].visit_type;\n                    \tvar visit_type\t= frameRef.frames[1].frames[2].document.forms[0].visit_type;\n\t\t\t\t\t\twhile(visit_type.options.length >= 1)\n\t\t\t\t\t\tvisit_type.remove(0);\n\n\t\t\t\t\t\t//var opt1 = top.content.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\tvar opt1 = frameRef.frames[1].frames[2].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt1.text\t= \'----\' +getLabel(\"Common.defaultSelect.label\",\"Common\")+ \'----\';\n\t\t\t\t\t\topt1.value\t= \'\';\n\t\t\t\t\t\t//top.content.frames[1].frames[2].document.forms[0].visit_type.add(opt1);        \n\t\t\t\t\t\tframeRef.frames[1].frames[2].document.forms[0].visit_type.add(opt1);        \n\t\t\t\t\t </script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t  <script>\n\n\t\t\t  parent.frames[2].document.getElementById(\'tab1\').scrollIntoView();\n\t\t\t  parent.frames[2].document.forms[0].referral_id.select();\n\t\t\t  parent.frames[2].document.forms[0].referral_id.value=\"\";\n\t\t\t  parent.frames[2].document.forms[0].referral_id.focus();\n\n\t\t\t  </script>\n\t\t\t ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t    \t   <script> \t   \n\t\t            var optsec= parent.frames[2].document.createElement(\"OPTION\");\t\t\t\t\t\n\t\t\t     \toptsec.text\t= \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\t\t\t\t\t\n\t\t\t     \toptsec.value\t= \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\t\t\t\t\t\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" ){\n\n\t\t\t\t\t\toptsec.selected = true; \n\t\t\t\t\t\t\n\t\t\t\t\t\t//Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" == \"Y\")\n\t\t\t\t\t\t\tparent.frames[2].document.forms[0].mode_of_arrival.disabled=true;\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tparent.frames[2].document.forms[0].mode_of_arrival.disabled=false;\n                    }\t\t\t\t\t\n\t\t\t\t\t   parent.frames[2].document.forms[0].mode_of_arrival.add(optsec);\t\t\t\t\t\n\t  \t       </script>\t\n\t     ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t<script>\n\tparent.frames[0].document.forms[0].apply.disabled=false;\n\tparent.frames[1].frames[2].document.forms[0].location.disabled=false;\n\t</script>\t\t\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t</form>\n\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\n\t</body>\n\t</html>\t \n\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
	public static String checkForNull(String inputString,String dftVlaue){
		return ( ((inputString == null) || (inputString.equals(""))) ? dftVlaue : inputString );
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

		Connection con		      =  null;
		ResultSet rs 		      = null;
		ResultSet rs1 		      = null;
		PreparedStatement pstmt   = null; 
		PreparedStatement pstmt1   = null;
		ResultSet rset				= null; 
	    java.sql.Statement stmt		= null; 

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    String locale			= (String)session.getAttribute("LOCALE");

		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String RepDb		= checkForNull(request.getParameter("repDb"));
		String facilityId	= checkForNull(request.getParameter("facility_id"));
		String sqlFinal		= "";
		/*End*/

		int chkflag = 0;  
        if(facilityId.equals(""))//Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			facilityId 	     = checkForNull((String) session.getValue( "facility_id" )) ;
		String clinic_code	     = checkForNull(request.getParameter("clinic_code"));
		String service_code      = checkForNull(request.getParameter("service_code"));
		String transport_mode    = checkForNull(request.getParameter("transport_mode"));
		String serviceflag       = checkForNull(request.getParameter("serviceflag"));
		String visitflag         = checkForNull(request.getParameter("visitflag"));
		String subserviceflag    = checkForNull(request.getParameter("subserviceflag"));
		String transportflag     = checkForNull(request.getParameter("transportflag"));
		String treatmentflag     = checkForNull(request.getParameter("treatmentflag"));
		String gender			 = checkForNull(request.getParameter("gender"));	
        String treatmentflag1    = checkForNull(request.getParameter("treatmentflag1"));
		String patient_id        = checkForNull(request.getParameter("patient_id"));
		String preVisitFlag      = checkForNull(request.getParameter("preVisitFlag"));
		String priority          = checkForNull(request.getParameter("priority"));
		String occ_classFlag     = checkForNull(request.getParameter("occ_classFlag"));
		String occ_class         = checkForNull(request.getParameter("occ_class"));
		String mechaInjflag      = checkForNull(request.getParameter("mechaInjflag"));
		String mech_injr_subcat_code      = checkForNull(request.getParameter("mech_injr_subcat_code"));
        String category          = checkForNull(request.getParameter("category"));
		String mechaInjflagNew   =checkForNull(request.getParameter("mechaInjflagNew"));
		
		String called_function   =checkForNull(request.getParameter("called_function"));	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
		
		String oscc_yn			 =checkForNull(request.getParameter("oscc_yn"));
		String treat_code        = checkForNull(request.getParameter("treat_code"));
		String pat_priority      = checkForNull(request.getParameter("pat_priority"));
		String patValidflag      = checkForNull(request.getParameter("patValidflag"));
        String from_rev          = checkForNull(request.getParameter("from_rev"));
		String func_source       = checkForNull(request.getParameter("func_source"));
		String to_service_code       = checkForNull(request.getParameter("referal_service"));
		session.putValue("queryString",func_source);
		String serviceflag1      = checkForNull(request.getParameter("serviceflag1"));
		String priorityzone = checkForNull(request.getParameter("priorityzone"));
		
		String NatIdFlag                 = checkForNull(request.getParameter("NatIdFlag"));
		String Nat_Id                    = checkForNull(request.getParameter("Nat_Id"));
		String nat_id_check_digit_id     = checkForNull(request.getParameter("nat_id_check_digit_id"));
		String nat_id_prompt             = checkForNull(request.getParameter("nat_id_prompt"));
		String Nat_IdName                = checkForNull(request.getParameter("Nat_IdName"));
		String CalledFrom                = checkForNull(request.getParameter("CalledFrom"));
		/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 Start*/
		String five_level_triage_appl_yn = checkForNull(request.getParameter("five_level_triage_appl_yn"),"N");
		String p_zone_order_no_new		 = checkForNull(request.getParameter("p_zone_order_no_new"),"1");
		/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 End*/
		
		//Below line added for this CRF ML-MMOH-CRF-0654
		String mode_of_arrival = checkForNull(request.getParameter("mode_of_arrival"));
		String modify_flag     = checkForNull(request.getParameter("modify_flag"),"N");
		String transportmodeflag  = checkForNull(request.getParameter("transportmodeflag")); //Added by Sangeetha for ML-MMOH-CRF-0654 on 17/may/17

		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		String frameRef				= checkForNull(request.getParameter("frameRef"),"top.content");
		String invoke_from			= checkForNull(request.getParameter("invoke_from"));
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/

		//End this CRF ML-MMOH-CRF-0654	
		
		String isAERegisterTypeAutoUpdateAppl = checkForNull(request.getParameter("isAERegisterTypeAutoUpdateAppl")); // added by mujafar for KDAH-CRF-0526
		String dflt_emer_follow_type_code = checkForNull(request.getParameter("dflt_emer_follow_type_code"));
		String dflt_time_reg_auto_update = checkForNull(request.getParameter("dflt_time_reg_auto_update"));
	
		double prev_visit_hrs =0d;
		String shortDesc		 = "";
	    String arrival_code      = "",			priority_no		 = "";
		String area_code         = "",			code 		     = "";
		String inj_sub			 = "";	
		String secondaryTriFlag  = checkForNull(request.getParameter("secondaryTriFlag"));
		String referral_id       = checkForNull(request.getParameter("referral_id"));		
		int    count			 = 0;	
		int countRec1			 = 0,			countRecTreat    = 0;
        int countRef = 0;
		StringBuffer sqlVisit         = null;
		StringBuffer sqlVisit1        = null;
		StringBuffer sqlService       = null;
		StringBuffer sqlSubServ       = null;
		StringBuffer sqlTreat		  = null;
		StringBuffer sqlTrans		  = null;
		StringBuffer sqlTreatF1       = null;
		StringBuffer sqlTreatF2       = null;
		StringBuffer sqlOcc           = null;
		StringBuffer sqlMechInj       = null;
		StringBuffer sqlMechInj1      = null;
		StringBuffer sqlPatValid      = null;
		StringBuffer sqlService1      = null;
		StringBuffer sqlServiceP      = null;
		String visit_status			   ="";
if(CalledFrom.equals("register_atten"))
{
	visit_status                 = checkForNull(request.getParameter("visit_status"));
	String prev_visit_hr                = checkForNull(request.getParameter("prev_visit_hrs"),"0.0");
	//String prev_visit_hr                = checkForNull(request.getParameter("prev_visit_hrs"));
	prev_visit_hrs = Double.parseDouble(prev_visit_hr);
}



	
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(frameRef));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try
	{
	   con					      = ConnectionManager.getConnection(request);
	


	   if(serviceflag1!=null)
		{		  
		    if(serviceflag1.equals("Y"))
			{
			  String func ="&../../eCommon/jsp/commonToolbar.jsp?menu_id=AE&module_id=AE&function_id=AE_QRY_PAT_HISTORY&function_name=Patient AE History&function_type=F&access=NNNNN";
			  session.putValue("queryString",func);
			  sqlService1 = new StringBuffer();
              sqlService1.append("SELECT B.SERVICE_CODE, AM_GET_DESC.AM_SERVICE ##REPDB##(A.SERVICE_CODE,'"+locale+"','2') SHORT_DESC FROM   AM_FACILITY_SERVICE ##REPDB## A,   OP_CLINIC_FOR_SERVICE ##REPDB## B WHERE   B.FACILITY_ID= ?  AND B.CLINIC_CODE =  ?   AND A.OPERATING_FACILITY_ID = B.FACILITY_ID   AND A.SERVICE_CODE = B.SERVICE_CODE UNION   SELECT SERVICE_CODE, AM_GET_DESC.AM_SERVICE ##REPDB##(SERVICE_CODE,'"+locale+"','2') SHORT_DESC FROM OP_CLINIC ##REPDB## WHERE FACILITY_ID= ? AND CLINIC_CODE= ? ORDER BY 2  ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			  /*Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1 Start*/
		      sqlFinal = sqlService1.toString();
			  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/
			  pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, clinic_code);
			  pstmt.setString(3, facilityId);
			  pstmt.setString(4, clinic_code);

		      rs		 = pstmt.executeQuery();
	 	      while(rs!=null && rs.next())
			  {		
				code			= rs.getString(1);
				shortDesc		= rs.getString(2);
			  
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(code));
            _bw.write(_wl_block12Bytes, _wl_block12);
	      }//End of while	
              if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlService1 != null) && (sqlService1.length() > 0))
			  {
				sqlService1.delete(0,sqlService1.length());
			  } 
		  }
		} 

       if(visitflag!=null)
		{		   
		  if(visitflag.equals("Y"))
			{	
			 try{
				    sqlVisit = new StringBuffer();
                    sqlVisit.append("SELECT COUNT(*) FROM OP_VISIT_TYPE_FOR_CLINIC ##REPDB## ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
					sqlVisit.append("WHERE  FACILITY_ID = ?  AND CLINIC_CODE= ? ");
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				    sqlFinal = sqlVisit.toString();
				    sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				    /*End*/
					pstmt1   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
                    pstmt1.setString(1, facilityId);
					pstmt1.setString(2, clinic_code);
					rs1		 = pstmt1.executeQuery(); 
					if(rs1!=null)
					{
						while(rs1.next())
							{
								count=rs1.getInt(1);
							}
					}
					if(pstmt1!=null) pstmt1.close();
		            if(rs1!=null) rs1.close(); 
					if((sqlVisit != null) && (sqlVisit.length() > 0))
					  {
						sqlVisit.delete(0,sqlVisit.length());
					  } 
                 if (count >= 1)
                 {
					String temp_val1="";
					sqlVisit1 = new StringBuffer();
                    sqlVisit1.append("select a.VISIT_TYPE_CODE, OP_GET_DESC.OP_VISIT_TYPE ##REPDB##(a.FACILITY_ID,a.VISIT_TYPE_CODE,'"+locale+"','2') VISIT_TYPE_SHORT_DESC  from     OP_VISIT_TYPE_FOR_CLINIC ##REPDB## A, OP_VISIT_TYPE ##REPDB## B where A.FACILITY_ID=B.FACILITY_ID AND A.VISIT_TYPE_CODE=B.VISIT_TYPE_CODE AND B.visit_type_ind=?  and A.eff_status='E' and a.clinic_code= ?  AND A.facility_id=? ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
					
					/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				    sqlFinal = sqlVisit1.toString();
				    sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				    /*End*/
					pstmt=con.prepareStatement(sqlFinal,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
					
					
					
					if(isAERegisterTypeAutoUpdateAppl.equals("true") && !dflt_time_reg_auto_update.equals("0") && !dflt_emer_follow_type_code.equals(""))
					{ //added by mujafar for KDAH-CRF-0526
						String temp_val = eAE.AECommonBean.getAEfollowupType(con,facilityId,patient_id,dflt_time_reg_auto_update,clinic_code);
						temp_val1 = temp_val;
						if(temp_val.equals("W")){
						pstmt.setString(1, "W");
						}
						else
						{
						pstmt.setString(1, "E");
						}
					}
					else
					{ 
					pstmt.setString(1, "E");
					}
					
				
				    pstmt.setString(2, clinic_code);
				    pstmt.setString(3, facilityId);
					rs		 = pstmt.executeQuery(); 
					
                    if(rs != null)
				           {
				              rs.last();
			                  countRec1 = rs.getRow();
                              rs.beforeFirst();
					       }
				   while(rs!=null && rs.next())
			           {
				          code			= rs.getString(1);
				          shortDesc		= rs.getString(2);
				 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(countRec1));
            _bw.write(_wl_block16Bytes, _wl_block16);
if(countRec1 == 1 )
				  {
					if(isAERegisterTypeAutoUpdateAppl.equals("true"))
					{
						
						if(!temp_val1.equals("W"))
						{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
						
					}
					else
					{
            _bw.write(_wl_block18Bytes, _wl_block18);
}

						
				  }
				  
            _bw.write(_wl_block19Bytes, _wl_block19);
 if(code.equals(dflt_emer_follow_type_code)&& isAERegisterTypeAutoUpdateAppl.equals("true")){ //added by mujafar for KDAH-CRF-0526
					 
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
	        } //End of while	    
			 }
           if(pstmt!=null) pstmt.close();
	       if(rs!=null) rs.close(); 
		   if((sqlVisit1 != null) && (sqlVisit1.length() > 0))
			  {
				sqlVisit1.delete(0,sqlVisit1.length());
			  } 
		 }catch(Exception e){e.printStackTrace();}
	  }
	}
	if(serviceflag!=null)
		{
		  if(serviceflag.equals("Y"))
			{	
			  sqlService = new StringBuffer();
			  

              sqlService.append("SELECT B.SERVICE_CODE, AM_GET_DESC.AM_SERVICE ##REPDB##(A.SERVICE_CODE,'"+locale+"','2') SHORT_DESC FROM   AM_FACILITY_SERVICE ##REPDB## A,   OP_CLINIC_FOR_SERVICE ##REPDB## B WHERE   B.FACILITY_ID= ?  AND B.CLINIC_CODE =  ?   AND A.OPERATING_FACILITY_ID = B.FACILITY_ID   AND A.SERVICE_CODE = B.SERVICE_CODE UNION   SELECT SERVICE_CODE, AM_GET_DESC.AM_SERVICE ##REPDB##(SERVICE_CODE,'"+locale+"','2') SHORT_DESC FROM OP_CLINIC ##REPDB## WHERE FACILITY_ID= ? AND CLINIC_CODE= ? ORDER BY 2 ");

			  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			  sqlFinal = sqlService.toString();
		      sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/

			  
			  pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, clinic_code);
			  pstmt.setString(3, facilityId);
			  pstmt.setString(4, clinic_code);

		      rs		 = pstmt.executeQuery();
			  int countSub = 1;
	 	      while(rs!=null && rs.next())
			  {		
				if (countSub==1)
                  service_code = rs.getString(1);

				code			= rs.getString(1);
				shortDesc		= rs.getString(2);
				countSub++ ;
		       
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(code));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(!to_service_code.equals("")){if(to_service_code.equals(code)){
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
					}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
	      }//End of while	
              subserviceflag = "Y"; 
              if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlService != null) && (sqlService.length() > 0))
			  {
				sqlService.delete(0,sqlService.length());
			  } 
		  }
			
		} 
				//Priority populate start
	   if(priorityzone != null)
		{
		  	  sqlServiceP = new StringBuffer();
			 
              sqlServiceP.append( "select PRIORITY_CODE,SHORT_DESC  from ae_pat_priority_lang_vw ##REPDB## where language_id='"+locale+"' and PRIORITY_ZONE=? and EFF_STATUS='E'"); //Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			   
			  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			  sqlFinal = sqlServiceP.toString();
			  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/
			  
			  pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, priorityzone);
		      rs		 = pstmt.executeQuery();
	 	      while(rs!=null && rs.next())
			  {		
				code			= rs.getString(1);
				shortDesc		= rs.getString(2);
			    
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(code));
            _bw.write(_wl_block29Bytes, _wl_block29);
	 }//End of while	
              if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlServiceP != null) && (sqlServiceP.length() > 0))
			  {
				sqlServiceP.delete(0,sqlServiceP.length());
			  } 
		  } 
		//Priority populate start
		if(subserviceflag!=null)
		{
		  if(subserviceflag.equals("Y"))
			{
              sqlSubServ    = new StringBuffer ();
			  
			  sqlSubServ.append("SELECT AM_GET_DESC.AM_SUBSERVICE ##REPDB##(service_code,subservice_code,'"+locale+"','2') short_desc, SUBSERVICE_CODE FROM  am_facility_subsrvc ##REPDB##  WHERE  operating_facility_id = ? AND service_code = ? ORDER BY 1 ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			  sqlFinal = sqlSubServ.toString();
			  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/
			  pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, service_code);

			  rs	  = pstmt.executeQuery(); 
              
		      while(rs!=null && rs.next())
			  {	
				code			= rs.getString(2);
				shortDesc		= rs.getString(1);
	          
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(code));
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlSubServ != null) && (sqlSubServ.length() > 0))
			  {
				sqlSubServ.delete(0,sqlSubServ.length());
			  } 
		  }
		}
		if(transportflag!=null)
		{
		 if(transportflag.equals("Y"))
			{
			  sqlTrans    = new StringBuffer();
			  
              sqlTrans.append("SELECT ARRIVAL_CODE,SHORT_DESC FROM  AM_ARRIVAL_LANG_VW ##REPDB## WHERE language_id='"+locale+"' and EFF_STATUS='E'  AND FACILITY_ID= ?  AND TRANSPORT_MODE = ? ORDER BY 2  ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			  sqlFinal = sqlTrans.toString();
			  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/
			  pstmt  = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, transport_mode);

			  rs	 = pstmt.executeQuery(); 
		      while(rs!=null && rs.next())
		      {	
			    arrival_code    = rs.getString(1);
				shortDesc		= rs.getString(2);
			   
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(arrival_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
	  } 
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlTrans != null) && (sqlTrans.length() > 0))
			  {
				sqlTrans.delete(0,sqlTrans.length());
			  } 
		   }
		}
	if(treatmentflag!=null)
		{
		 if(treatmentflag.equals("Y"))
			{
			 sqlTreat   = new StringBuffer();
			 
             sqlTreat.append("select treatment_area_code, short_desc treatment_area_desc from ae_tmt_area_for_clinic_lang_vw ##REPDB## where language_id='"+locale+"' and facility_id = ?  and CLINIC_CODE = ? AND PRIORITY_ZONE=  ? and (gender = ?  OR gender IS NULL)   and eff_status = 'E'  order by 2 ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			 /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		     sqlFinal = sqlTreat.toString();
			 sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			 /*End*/
			 
			 pstmt      = con.prepareStatement(sqlFinal,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
             pstmt.setString(1, facilityId);
			 pstmt.setString(2, clinic_code);
             pstmt.setString(3, priority);
			 pstmt.setString(4, gender);

			 rs		 = pstmt.executeQuery();
			    if(rs != null)
				  {
				              rs.last();
			                  countRecTreat = rs.getRow();
                              rs.beforeFirst();
				  }

		      while(rs!=null && rs.next())
			  {	
					area_code        = rs.getString(1); 
				    shortDesc		 = rs.getString(2);
                    
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(countRecTreat));
            _bw.write(_wl_block39Bytes, _wl_block39);
        } 
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlTreat != null) && (sqlTreat.length() > 0))
			  {
				sqlTreat.delete(0,sqlTreat.length());
			  } 
		  }
	 }

/** Code Added For Populating Values In TreatmentArea And Priority List Boxes Based On The PRIORITY-ZONE Value In Secondary Triage Function **/

if(treatmentflag1!=null)
		{
		
		 if(treatmentflag1.equals("Y"))
			{  
			 
			 /*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 Start*/
			 if(!five_level_triage_appl_yn.equals("Y")){
			    if(priority.equals("R"))
				         priority_no="1";
			   if(priority.equals("Y"))
				         priority_no="3";
			    if(priority.equals("G"))
				         priority_no="2";
				if(priority.equals("U"))
				         priority_no="4";
			 }else{
				 priority_no	= p_zone_order_no_new;
			 }
				/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 3rd 2014 End*/
				sqlTreatF1       = new StringBuffer();
				  
                  sqlTreatF1.append("select treatment_area_code, short_desc,OPEN_TO_ALL_PRAC_FOR_CLINIC_YN from ae_tmt_area_for_clinic_lang_vw ##REPDB## where language_id='"+locale+"' and facility_id = ?  and CLINIC_CODE = ? AND PRIORITY_ZONE=  ? and (gender = ?  OR gender IS NULL)   and eff_status = 'E' ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

				  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				  sqlFinal = sqlTreatF1.toString();
				  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				  /*End*/
			  pstmt      = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, clinic_code);
              pstmt.setString(3, priority);
			  pstmt.setString(4, gender);

			  rs		 = pstmt.executeQuery();
			  while(rs!=null && rs.next())
			  {	
			        area_code        = rs.getString(1);
				    shortDesc		= rs.getString(2);
					//Senthil added AAKH-CRF-0010 [IN:038535]
					String open_allclinicyn=rs.getString(3);
					String tempcode="";
					tempcode=area_code+"$$"+open_allclinicyn;
                    
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(tempcode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(treat_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
        } 
              if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlTreatF1 != null) && (sqlTreatF1.length() > 0))
			  {
				sqlTreatF1.delete(0,sqlTreatF1.length());
			  } 
            sqlTreatF2       = new   StringBuffer();
	 //Modified By Shanmukh for MMS-DM-CRF-0147		
            sqlTreatF2.append("select PRIORITY_CODE,SHORT_DESC  from ae_pat_priority_lang_vw ##REPDB## where language_id='"+locale+"' and PRIORITY_ZONE=? and EFF_STATUS='E' ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		    sqlFinal = sqlTreatF2.toString();
			sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			/*End*/
            pstmt      = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			pstmt.setString(1, priority);

            rs		 = pstmt.executeQuery();
			while(rs!=null && rs.next())
			  {	
			        area_code        = rs.getString(1);
				    shortDesc		= rs.getString(2);
				
                    
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(pat_priority));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block47Bytes, _wl_block47);

              }
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlTreatF2 != null) && (sqlTreatF2.length() > 0))
			  { 
				sqlTreatF2.delete(0,sqlTreatF2.length());
			  } 
		  }
	 }
/*END'S HERE*/
	if(preVisitFlag!=null)
		{
		 if(preVisitFlag.equals("Y"))
			{     
				// Start (venkat s) for PE_EXE ae regn attn function 
				   if( (prev_visit_hrs > 24) && (visit_status.equals("07") || visit_status.equals("09"))) {
            _bw.write(_wl_block48Bytes, _wl_block48);
}else if(prev_visit_hrs > 0 && prev_visit_hrs <= 24 && (visit_status.equals("07") || visit_status.equals("09"))) {
            _bw.write(_wl_block49Bytes, _wl_block49);
} 
			  } 
		}  
        if(NatIdFlag!=null)
		{
		 if(NatIdFlag.equals("Y"))
			{
			        stmt = con.createStatement();
			        String sql = "";
					String result ="";
			 		if(nat_id_check_digit_id != null)
					{
						sql = "SELECT program_name FROM mp_check_digit_scheme ##REPDB## WHERE scheme_id = '"+nat_id_check_digit_id+"' ";//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

					    sql = sql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
				        rset = stmt.executeQuery(sql);
				        if( rset !=null && rset.next())
				        {
				            nat_id_check_digit_id = rset.getString("program_name");
				            if(rset != null)  rset.close();
							sql	= "select "+nat_id_check_digit_id+"('"+Nat_Id+"') ##REPDB## from dual";//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

							sql = sql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
					        rset = stmt.executeQuery(sql);
				            if(rset.next())
								result = rset.getString(1);
				            if(rset != null)  rset.close();
						}
					}
				    if(rset != null)  rset.close();
                    if(stmt != null)  stmt.close();
					if (result.equals("N"))
					{
						
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block51Bytes, _wl_block51);
if(CalledFrom.equals("Reg")){
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(Nat_IdName));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Nat_IdName));
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Nat_IdName));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Nat_IdName));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
					}  

			} 
	    }
	   if(occ_classFlag!=null)
		{
		 if(occ_classFlag.equals("Y"))
			{
       		sqlOcc             = new StringBuffer();
            sqlOcc.append("select ocpn_code,short_desc from  mp_occupation_lang_vw ##REPDB## where language_id='"+locale+"' and ocpn_class_code = ?  and eff_status='E' order by 2  ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		    sqlFinal = sqlOcc.toString();
			sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			/*End*/
			pstmt = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			pstmt.setString(1, occ_class);

			rs		 = pstmt.executeQuery();
		    
			while(rs!=null && rs.next())
			  {	
					   code				= rs.getString("ocpn_code");
				       shortDesc		= rs.getString("short_desc");
					   if(from_rev.equals(""))
				       {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(code));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
				  else
				  {
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(code));
            _bw.write(_wl_block61Bytes, _wl_block61);
        } 
				  }
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close();
			  if((sqlOcc != null) && (sqlOcc.length() > 0))
			  {
				sqlOcc.delete(0,sqlOcc.length());
			  } 
			} 
	    }
		if(mechaInjflag!=null)
		{
		 if(mechaInjflag.equals("Y"))
			{ 
			    sqlMechInj      = new StringBuffer();
				
                sqlMechInj.append(" SELECT INJ_SUBCATEGORY_CODE,SHORT_DESC FROM AE_INJURY_SUBCATEGORY_LANG_VW ##REPDB##  WHERE language_id='"+locale+"' AND EFF_STATUS='E' AND INJ_CATEGORY_CODE = ? ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlMechInj.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/

				pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1, category);

				rs		 = pstmt.executeQuery();
		        while(rs!=null && rs.next())
			     {	
			        inj_sub         = rs.getString(1);
				    shortDesc		= rs.getString(2);
				    if(called_function.equals("REGISTER_ATTEN")){	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
        
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(inj_sub));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mech_injr_subcat_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(inj_sub));
            _bw.write(_wl_block65Bytes, _wl_block65);
}else{
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(inj_sub));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mech_injr_subcat_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(inj_sub));
            _bw.write(_wl_block67Bytes, _wl_block67);
	} 

	       } 
				 if(rs!=null) { rs.close(); rs = null; }   
 				 if(pstmt!=null) { pstmt.close(); pstmt = null;}
				 if((sqlMechInj != null) && (sqlMechInj.length() > 0))
				  {
					sqlMechInj.delete(0,sqlMechInj.length());
				  } 
			}
		}
    

	if(mechaInjflagNew!=null)
		{
		 if(mechaInjflagNew.equals("Y"))
			{
			    sqlMechInj1    = new StringBuffer();
				sqlMechInj1.append("SELECT INJ_CATEGORY_CODE,SHORT_DESC FROM AE_INJURY_CATEGORY_LANG_VW ##REPDB## WHERE language_id='"+locale+"'  AND EFF_STATUS='E' and oscc_yn=  ?  ORDER BY 2  ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlMechInj1.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1, oscc_yn);

				rs		 = pstmt.executeQuery();
		        while(rs!=null && rs.next())
			     {	
			        inj_sub         = rs.getString(1);
				    shortDesc		= rs.getString(2);
				    if(called_function.equals("REGISTER_ATTEN")){ 	/*Added by Rameswar on 04-Oct-16 for GDOH-CRF-0004.2*/
        
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(inj_sub));
            _bw.write(_wl_block69Bytes, _wl_block69);
}else{
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(inj_sub));
            _bw.write(_wl_block71Bytes, _wl_block71);
}

	     } 
				 if(rs!=null) { rs.close(); rs = null; }   
 				 if(pstmt!=null) { pstmt.close(); pstmt = null;}
				 if((sqlMechInj1 != null) && (sqlMechInj1.length() > 0))
				  {
					sqlMechInj1.delete(0,sqlMechInj1.length());
				  } 
			}
		}



     if(patValidflag!=null)
		{
		 
		 if(patValidflag.equals("Y"))
			{
			    // Tuesday, April 20, 2010 for PE_EXC venkat s (changed pr_encounter into oae_current_patient table , condition remain same )
				sqlPatValid    = new StringBuffer();
                sqlPatValid.append("select patient_id from ae_current_patient ##REPDB## where "); //Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
				sqlPatValid.append(" patient_id= ? and QUEUE_STATUS < '07' "); 
				sqlPatValid.append(" and locn_code= ?  ");
				sqlPatValid.append(" and facility_id = ? ");

				/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
				sqlFinal = sqlPatValid.toString();
				sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
				/*End*/
				pstmt   = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
				pstmt.setString(1, patient_id);
				pstmt.setString(2, clinic_code);
				pstmt.setString(3, facilityId);

				rs		 = pstmt.executeQuery();
		       if (rs!=null && rs.next()) 
			     {	
                  chkflag=1; 
	             } 
				 
				 if(rs!=null) { rs.close(); rs = null; }   
 				 if(pstmt!=null) { pstmt.close(); pstmt = null;}
				 if((sqlPatValid != null) && (sqlPatValid.length() > 0))
				  {
					sqlPatValid.delete(0,sqlPatValid.length());
				  } 
			}
		} 
		if(chkflag==1)
					{				          

					      // out.println("<script>parent.frames[0].document.forms[0].apply.disabled=false;     parent.frames[1].frames[2].document.forms[0].location.disabled=false;alert(getMessage('OPEN_VST_STATUS_FOR_AE_CLINIC','AE'));top.content.frames[1].frames[2].document.forms[0].location.value=''; var loc = top.content.frames[1].frames[2].document.forms[0].location; if(top.content.frames[1].frames[2].document.forms[0].location.value==''){ 					 var opt1 = top.content.frames[1].frames[2].document.createElement('OPTION'); opt1.text	= '----' +getLabel('Common.defaultSelect.label','Common')+ '----';  opt1.value	= ''; top.content.frames[1].frames[2].document.forms[0].location.add(opt1,0)};</script>");
					       out.println("<script> parent.frames[0].document.forms[0].apply.disabled=false;     parent.frames[1].frames[2].document.forms[0].location.disabled=false;alert(getMessage('OPEN_VST_STATUS_FOR_AE_CLINIC','AE'));"+frameRef+".frames[1].frames[2].document.forms[0].location.value=''; var loc = "+frameRef+".frames[1].frames[2].document.forms[0].location; if("+frameRef+".frames[1].frames[2].document.forms[0].location.value==''){ 					 var opt1 = "+frameRef+".frames[1].frames[2].document.createElement('OPTION'); opt1.text	= '----' +getLabel('Common.defaultSelect.label','Common')+ '----';  opt1.value	= ''; "+frameRef+".frames[1].frames[2].document.forms[0].location.add(opt1,0)};</script>");
						
            _bw.write(_wl_block72Bytes, _wl_block72);

						//out.println("<script>top.content.frames[1].frames[2].document.forms[0].location.value='';top.content.frames[1].frames[2].document.forms[0].location.text='';</script>");						
						out.println("<script>"+frameRef+".frames[1].frames[2].document.forms[0].location.value='';"+frameRef+".frames[1].frames[2].document.forms[0].location.text='';</script>");						
					}
	if(secondaryTriFlag!=null) 
			{
	  if(secondaryTriFlag.equals("Y"))
		{
		   StringBuffer PRRef = new StringBuffer();
		   PRRef.append("select count(*) count from PR_REFERRAL_REGISTER ##REPDB## where ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
		   PRRef.append(" REFERRAL_ID= ?  and PATIENT_ID= ? ");

		   /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		   sqlFinal = PRRef.toString();
		   sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
		   /*End*/
		   pstmt  = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
		   pstmt.setString(1, referral_id);
		   pstmt.setString(2, patient_id);
		   rs = pstmt.executeQuery();
		   if(rs != null && rs.next())
			 {
				countRef = rs.getInt("count");
			 }if(rs != null) rs.close();
			 if(countRef == 0)
			 {
			 out.println("<script>alert(getMessage('INV_REF_ID','IP'));</script>");
			  
            _bw.write(_wl_block73Bytes, _wl_block73);

			  }
			  if(pstmt!=null)pstmt.close();
			  if((PRRef != null) && (PRRef.length() > 0))
				{
					PRRef.delete(0,PRRef.length());
				}
		}
	}
	/*Below line added for this CRF ML-MMOH-CRF-0654*/
	if(transportmodeflag!=null)
		{

		 if(transportmodeflag.equals("ModeOfTransfer"))
			{
			  sqlTrans    = new StringBuffer();
			  
              sqlTrans.append("SELECT ARRIVAL_CODE,SHORT_DESC FROM  AM_ARRIVAL_LANG_VW ##REPDB## WHERE language_id='"+locale+"' and EFF_STATUS='E'  AND FACILITY_ID= ?  AND TRANSPORT_MODE = ? ORDER BY 2  ");//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1

			  /*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			  sqlFinal = sqlTrans.toString();
			  sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			  /*End*/
			  			  			  			  
			  pstmt  = con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 2nd July 2018 against MMS-DM-CRF-0115.1
			  pstmt.setString(1, facilityId);
			  pstmt.setString(2, transport_mode);

			  rs	 = pstmt.executeQuery(); 
		      while(rs!=null && rs.next())
		      {	
			    arrival_code    = rs.getString(1);
				shortDesc		= rs.getString(2);
			   
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(arrival_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(mode_of_arrival));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(arrival_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(modify_flag));
            _bw.write(_wl_block78Bytes, _wl_block78);
	  } 
			  if(pstmt!=null) pstmt.close();
		      if(rs!=null) rs.close(); 
			  if((sqlTrans != null) && (sqlTrans.length() > 0))
			  {
				sqlTrans.delete(0,sqlTrans.length());
			  } 
		   }
		}
	//End this CRF ML-MMOH-CRF-0654	
	
            _bw.write(_wl_block79Bytes, _wl_block79);

	if(CalledFrom.equals("register_atten") ){
		out.println("<script> parent.frames[0].document.forms[0].apply.disabled=false;parent.frames[1].frames[2].document.forms[0].location.disabled=false;</script>");
		
            _bw.write(_wl_block80Bytes, _wl_block80);
}
}
catch(Exception e){ e.toString(); e.printStackTrace();}
	finally {
		           ConnectionManager.returnConnection(con,request);  
		    }
	
            _bw.write(_wl_block81Bytes, _wl_block81);
            _bw.write(_wl_block82Bytes, _wl_block82);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
