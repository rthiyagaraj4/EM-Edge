package jsp_servlet._elc._receiveloanedlinen._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.cache.pojo.business.Cache;
import com.iba.framework.cache.pojo.business.CacheManager;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.core.util.IBADateValidation;
import com.iba.ehis.lc.core.util.LcDateFormat;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.framework.core.util.Constants;
import com.iba.ehis.lc.core.vo.SourceBean;
import com.iba.framework.core.util.Constants;

public final class __receiveloanedlinencud extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/elc/ReceiveLoanedLinen/jsp/ReceiveLoanedLinenCUD.jsp", 1709118355057L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/framework/html/Tag.text", 1669269889579L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\r\n<script>\r\n\tvar loadMethod=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"\r\n\tvar applyMethod=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"\r\n\tvar queryMethod=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\r\n\tvar updateMethod=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"\r\n\tvar deleteMethod=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"\r\n\tvar contextPath=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"\r\n\tvar dwrMessage=\"\";\r\n\t\r\n</script>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<head>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eCommon/html/";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'></link>\n\t<script src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/dwrcore/interface/MessageReader.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/dwrcore/engine.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/dwrcore/util.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/dwrcore/interface/IBADateValidator.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/framework/js/Ajax_DWR.js\'></script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/framework/js/validations.js\"></script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/framework/js/common.js\"></script>\n\t<script type=\"text/javascript\" src=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/eLC/ReceiveLoanedLinen/js/ReceiveLoanedLinenCUD.js\'>\n\t</script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/dwrlc/interface/LinenIssue.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/dwrcore/interface/IBADateValidator.js\'></script>\n\t\t\t\t\t\n<script>\nfunction setStatus(){\n\nvar val=document.getElementById(\"vo.receiveLoanedLinenVO.receivedWriteOff\").value;\nif(val==\"R\")\n\tdocument.getElementById(\"vo.receiveLoanedLinenVO.loanStatus\").value=\"RE\";\nelse \n\tdocument.getElementById(\"vo.receiveLoanedLinenVO.loanStatus\").value=\"WO\";\n}\nfunction checkQty(arg){\n\t\tobj =  String.fromCharCode(window.event.keyCode);\n   \t\tvar alphaFilter =/^[0-9]+$/;\n   \t\tif (!(alphaFilter.test(obj))) { \n\t   \tgetServerMessage(\"message.Numbers.Allowed\");\n\t\talert(dwrMessage);\n\t   \twindow.event.keyCode = 27;\n\t\targ.value=\"\";\n\t   }\n\t}\n\nfunction convertDate(){\n\t\tvar rdate= document.getElementById(\"vo.receiveLoanedLinenVO.loanDate\");\tIBADateValidator.convertDateJS(rdate.value,\"en\",\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\",\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\",RDFromcallbackMethod);\n\t\t\t\t\tfunction  RDFromcallbackMethod(fdate){\n\t\t\t\t\t\tdocument.getElementById(\"loanDate\").value=fdate;\n\t\t\t\t\t}\n}\n\n</script>\n</head>\n<title>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</title>\n<body onload=\"assignVal();convertDate()\">\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<table border=\'0 \' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td><td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td><td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td><td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\' nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t</td>\n\t\t\t\t<td align=\"left\" class=\'label\' nowrap=\"nowrap\" colspan=\"3\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t&nbsp&nbsp\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"text\" name=\"loanDate\" id=\"loanDate\" maxlength=\"16\" size=\"16\" readonly=\"true\" />\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\'label\'  nowrap=\"nowrap\">\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\"left\" class=\'label\'  nowrap=\"nowrap\">\n\t\t\t\t\t\t<input type=text name=\"sourceType\" id=\"sourceType\" maxlength=\"10\" size=\"10\" readonly=\"true\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t&nbsp&nbsp&nbsp&nbsp&nbsp\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<!--\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="-->\n\t\t\t\t\t<input type=text name=\"sourceCode\" id=\"sourceCode\" maxlength=\"30\" size=\"30\" readonly=\"true\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"/>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t</td>\n\t\t\t\t<td></td>\n\t\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'  nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t</td>\n\t\t\t\t<td align=\"left\" class=\'label\'  nowrap=\"nowrap\">\n\t\t\t\t\t\n\t\t\t\t\t<input type=text name=\"loanedToSourceType\" id=\"loanedToSourceType\" maxlength=\"10\" size=\"10\" readonly=\"true\"/>\n\t\t\t\t\t&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<!--";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t<input type=text name=\"loanSourceCode\" id=\"loanSourceCode\" maxlength=\"30\" size=\"30\" readonly=\"true\"/> -->\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\n\t\t\t\t\t<input type=text name=\"sourceDesc\" id=\"sourceDesc\" maxlength=\"30\" size=\"30\" readonly=\"true\" value=\" \" />\n\t\t\t\t\t<script>\t\n\t\t\t\t\tvar stype=document.getElementById(\"vo.receiveLoanedLinenVO.loanedToSourceType\").value;\n\t\t\t\t\tstype=trimString(stype);\n\t\t\t\t\tvar scode=document.getElementById(\"vo.receiveLoanedLinenVO.loanedToSourceCode\").value;\n\t\t\t\t\tscode=trimString(scode);\n\t\t\t\t\t\n\t\t\t\t\tLinenIssue.getSourceDesc(\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\",stype,scode,callBackSource1);\n\t\t\t\t\t\tfunction callBackSource1(data){\n\t\t\t\t\t\t\tfor(prop in data){\t\t   \t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.getElementById(\"sourceDesc\").value=data[prop];\n\t\t\t\t\t\t\t\t\t\t  }\n\t\t\t\t\t\t\t}\n\t\t\t\t\t</script>\t\n\t\t\t\t</td>\n\t\t\t\t<td></td>\n\t\t\t\t<td></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr >\n\t\t\t\t\t<td  align=\"right\" class=\'label\'  nowrap=\"nowrap\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t</td><td>\n\t\t\t\t</td><td>\n\t\t\t\t</td>\n\t\t\t</tr>\t\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'  nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t</td>\n\t\t\t\t<td >\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t</td><td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'  nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t<td>\n\t\t\t\t</td>\n\t\t\t\t<td></td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'  nowrap=\"nowrap\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t</td>\n\t\t\t\t\t<td >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t</td>\n\t\t\t<td></td>\n\t\t\t<td></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table border=\'0 \' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<th align=\"left\" colspan=\'4\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t</th>\n\t\t\t\t\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t</td>\n\t\t\t\t<td></td>\n\t\t\t</tr>\t\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t</td><td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t<img src=\"framework/images/mandatory.gif\" id=\"hide\" ></img>\n\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t</td><td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t</td><td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t</td><td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t<img src=\"framework/images/mandatory.gif\"></img>\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t</td><td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td><td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td><td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td><td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"4\" align=\'center\'>\n\t\t\t\t\t\t<input class=\"BUTTON\" type=\"button\" name=\"Submit1\" id=\"Submit1\" value=\"Submit\" onmouseover=\"setStatus()\" onclick=\"submitFormNullCheck();\"/>\n\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td><td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td><td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td><td>\n\t\t\t\t\t&nbsp;\n\t\t\t\t</td>\n\t\t</tr>\t\n\t\t</table>\n\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t<input type=\"hidden\" name=\"languageId\" id=\"languageId\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"/>\n\t\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n</body>\n<script>\ndocument.getElementById(\"vo.receiveLoanedLinenVO.loanQty\").value=dialogArguments[16];\nvar source=document.getElementById(\"vo.receiveLoanedLinenVO.sourceType\").value;\nsource=trimString(source);\nvar obj=document.getElementById(\"sourceType\");\nif(source==\"W\")\n{getServerMessage(\"com.iba.ehis.lc.ward\");\nvar msg=dwrMessage;\nobj.value=msg;}\nelse if(source==\"D\")\n{getServerMessage(\"com.iba.ehis.lc.department\");\nvar msg=dwrMessage;\nobj.value=msg;}\nelse if(source==\"C\")\n{getServerMessage(\"com.iba.ehis.lc.clinic\");\nvar msg=dwrMessage;\nobj.value=msg;}\n\nvar sourceTo=document.getElementById(\"vo.receiveLoanedLinenVO.loanedToSourceType\").value;\nsourceTo=trimString(sourceTo);\nvar obj1=document.getElementById(\"loanedToSourceType\");\nif(sourceTo==\"W\")\n{getServerMessage(\"com.iba.ehis.lc.ward\");\nvar msg=dwrMessage;\nobj1.value=msg;}\nelse if(sourceTo==\"D\")\n{getServerMessage(\"com.iba.ehis.lc.department\");\nvar msg=dwrMessage;\nobj1.value=msg;}\nelse if(sourceTo==\"C\")\n{getServerMessage(\"com.iba.ehis.lc.clinic\");\nvar msg=dwrMessage;\nobj1.value=msg;}\n\n\n</script>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(Constants.LOAD));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Constants.CREATE));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Constants.QUERY));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Constants.UPDATE));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Constants.DELETE));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block2Bytes, _wl_block2);
             org.apache.struts.taglib.html.HtmlTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.struts.taglib.html.HtmlTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            __tag0.setLocale(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.html.HtmlTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block12Bytes, _wl_block12);
 	
		String title=(String)request.getParameter("title");
		String facilityId=(String)session.getAttribute("facility_id");
		String functionId = (String) session.getAttribute("functionId");
		String moduleId = (String) session.getAttribute("moduleId");
		String addedById = (String) session.getAttribute("login_user");
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
				.getAttribute("PREFERRED_STYLE")
				: "IeStyle.css";
				if (sStyle == null)
					sStyle = "IeStyle.css";

		
		UserPreferences userPrefs =new UserPreferences();
		/* Cache cache = CacheManager.getCache();
		userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
			
		String timepattrn=userPrefs.getTimeFormat();
		String sb=userPrefs.getDateFormat();
		String pattern=sb+" "+timepattrn;
		
		SourceBean obj=new SourceBean();
		try
		{
			/* obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey"); */
									

		}catch(Exception e){} 
	
		String src=obj.getSource();
		String srcType=obj.getSourceType();
		String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode();

		
                    _bw.write(_wl_block13Bytes, _wl_block13);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block14Bytes, _wl_block14);
                    out.print( String.valueOf(sStyle));
                    _bw.write(_wl_block15Bytes, _wl_block15);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block16Bytes, _wl_block16);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block20Bytes, _wl_block20);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block21Bytes, _wl_block21);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block22Bytes, _wl_block22);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block23Bytes, _wl_block23);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block24Bytes, _wl_block24);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block25Bytes, _wl_block25);
                    out.print( String.valueOf(request.getContextPath()));
                    _bw.write(_wl_block26Bytes, _wl_block26);
                    out.print( String.valueOf(locale));
                    _bw.write(_wl_block27Bytes, _wl_block27);
                    out.print( String.valueOf(pattern));
                    _bw.write(_wl_block28Bytes, _wl_block28);
                    out.print( String.valueOf(title));
                    _bw.write(_wl_block29Bytes, _wl_block29);
                     org.apache.struts.taglib.html.FormTag __tag1 = null ;
                    int __result__tag1 = 0 ;

                    if (__tag1 == null ){
                        __tag1 = new  org.apache.struts.taglib.html.FormTag ();
                        weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
                    }
                    __tag1.setPageContext(pageContext);
                    __tag1.setParent(__tag0);
                    __tag1.setAction(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("/ReceiveLoanedLinenAction.do", java.lang.String .class,"action"));
                    __tag1.setTarget(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("messageFrame", java.lang.String .class,"target"));
                    _activeTag=__tag1;
                    __result__tag1 = __tag1.doStartTag();

                    if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                        if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                             throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.html.FormTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                        }
                        do {
                            _bw.write(_wl_block30Bytes, _wl_block30);

                            if (_jsp__tag2(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block31Bytes, _wl_block31);

                            if (_jsp__tag3(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block32Bytes, _wl_block32);

                            if (_jsp__tag4(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block33Bytes, _wl_block33);

                            if (_jsp__tag5(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block34Bytes, _wl_block34);

                            if (_jsp__tag6(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block35Bytes, _wl_block35);

                            if (_jsp__tag7(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block36Bytes, _wl_block36);

                            if (_jsp__tag8(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block37Bytes, _wl_block37);

                            if (_jsp__tag9(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block38Bytes, _wl_block38);
                             org.apache.struts.taglib.html.TextTag __tag10 = null ;
                            int __result__tag10 = 0 ;

                            if (__tag10 == null ){
                                __tag10 = new  org.apache.struts.taglib.html.TextTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
                            }
                            __tag10.setPageContext(pageContext);
                            __tag10.setParent(__tag1);
                            __tag10.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.sourceCode", java.lang.String .class,"property"));
                            __tag10.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"maxlength"));
                            __tag10.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"size"));
                            __tag10.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
                            __tag10.setValue(src
);
                            _activeTag=__tag10;
                            __result__tag10 = __tag10.doStartTag();

                            if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag10);
                                return;
                            }
                            _activeTag=__tag10.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
                            __tag10.release();
                            _bw.write(_wl_block39Bytes, _wl_block39);
                            out.print( String.valueOf(src));
                            _bw.write(_wl_block40Bytes, _wl_block40);

                            if (_jsp__tag11(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block41Bytes, _wl_block41);

                            if (_jsp__tag12(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block42Bytes, _wl_block42);

                            if (_jsp__tag13(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block43Bytes, _wl_block43);

                            if (_jsp__tag14(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block34Bytes, _wl_block34);

                            if (_jsp__tag15(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block44Bytes, _wl_block44);

                            if (_jsp__tag16(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block34Bytes, _wl_block34);

                            if (_jsp__tag17(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block45Bytes, _wl_block45);
                            out.print( String.valueOf(locale));
                            _bw.write(_wl_block27Bytes, _wl_block27);
                            out.print( String.valueOf(facilityId));
                            _bw.write(_wl_block46Bytes, _wl_block46);

                            if (_jsp__tag18(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block47Bytes, _wl_block47);

                            if (_jsp__tag19(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block48Bytes, _wl_block48);

                            if (_jsp__tag20(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block49Bytes, _wl_block49);

                            if (_jsp__tag21(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block50Bytes, _wl_block50);

                            if (_jsp__tag22(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block49Bytes, _wl_block49);

                            if (_jsp__tag23(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block51Bytes, _wl_block51);

                            if (_jsp__tag24(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block52Bytes, _wl_block52);

                            if (_jsp__tag25(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block53Bytes, _wl_block53);

                            if (_jsp__tag26(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block54Bytes, _wl_block54);

                            if (_jsp__tag27(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block55Bytes, _wl_block55);

                            if (_jsp__tag28(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block56Bytes, _wl_block56);

                            if (_jsp__tag29(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block59Bytes, _wl_block59);

                            if (_jsp__tag34(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block60Bytes, _wl_block60);

                            if (_jsp__tag35(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block61Bytes, _wl_block61);

                            if (_jsp__tag36(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block60Bytes, _wl_block60);

                            if (_jsp__tag37(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block62Bytes, _wl_block62);

                            if (_jsp__tag38(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block63Bytes, _wl_block63);
                             org.apache.struts.taglib.html.TextTag __tag39 = null ;
                            int __result__tag39 = 0 ;

                            if (__tag39 == null ){
                                __tag39 = new  org.apache.struts.taglib.html.TextTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
                            }
                            __tag39.setPageContext(pageContext);
                            __tag39.setParent(__tag1);
                            __tag39.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.receivedBackBy", java.lang.String .class,"property"));
                            __tag39.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"maxlength"));
                            __tag39.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"size"));
                            __tag39.setValue(addedById
);
                            _activeTag=__tag39;
                            __result__tag39 = __tag39.doStartTag();

                            if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag39);
                                return;
                            }
                            _activeTag=__tag39.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
                            __tag39.release();
                            _bw.write(_wl_block64Bytes, _wl_block64);

                            if (_jsp__tag40(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block63Bytes, _wl_block63);

                            if (_jsp__tag41(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block34Bytes, _wl_block34);

                            if (_jsp__tag42(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block34Bytes, _wl_block34);

                            if (_jsp__tag43(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block65Bytes, _wl_block65);
                             org.apache.struts.taglib.html.HiddenTag __tag44 = null ;
                            int __result__tag44 = 0 ;

                            if (__tag44 == null ){
                                __tag44 = new  org.apache.struts.taglib.html.HiddenTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
                            }
                            __tag44.setPageContext(pageContext);
                            __tag44.setParent(__tag1);
                            __tag44.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.operatingFacilityId", java.lang.String .class,"property"));
                            __tag44.setValue(facilityId
);
                            _activeTag=__tag44;
                            __result__tag44 = __tag44.doStartTag();

                            if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                                if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                                }
                            }
                            if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                                _activeTag = null;
                                _releaseTags(pageContext, __tag44);
                                return;
                            }
                            _activeTag=__tag44.getParent();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
                            __tag44.release();
                            _bw.write(_wl_block66Bytes, _wl_block66);

                            if (_jsp__tag45(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block66Bytes, _wl_block66);

                            if (_jsp__tag46(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block66Bytes, _wl_block66);

                            if (_jsp__tag47(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block66Bytes, _wl_block66);

                            if (_jsp__tag48(request, response, pageContext, _activeTag, __tag1))
                             return;
                            _bw.write(_wl_block67Bytes, _wl_block67);
                            out.print( String.valueOf(locale));
                            _bw.write(_wl_block68Bytes, _wl_block68);
                        } while (__tag1.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
                    }
                    if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                        _activeTag = null;
                        _releaseTags(pageContext, __tag1);
                        return;
                    }
                    _activeTag=__tag1.getParent();
                    weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
                    __tag1.release();
                    _bw.write(_wl_block69Bytes, _wl_block69);
                } while (__tag0.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(parent);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.ref.Num", java.lang.String .class,"key"));
        __tag2.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(parent);
        __tag3.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.loanRefNum", java.lang.String .class,"property"));
        __tag3.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("10", java.lang.String .class,"maxlength"));
        __tag3.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("10", java.lang.String .class,"size"));
        __tag3.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(parent);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.loanDate", java.lang.String .class,"key"));
        __tag4.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(parent);
        __tag5.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.loanDate", java.lang.String .class,"property"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(parent);
        __tag6.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.loanDate.pattern", java.lang.String .class,"property"));
        __tag6.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("dd/MM/yyyy HH:mm", java.lang.String .class,"value"));
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(parent);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.standardStock.sourceType", java.lang.String .class,"key"));
        __tag7.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(parent);
        __tag8.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.sourceType", java.lang.String .class,"property"));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(parent);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.source", java.lang.String .class,"key"));
        __tag9.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(parent);
        __tag11.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.sourceCode", java.lang.String .class,"property"));
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

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(parent);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.loanedTo", java.lang.String .class,"key"));
        __tag12.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(parent);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.source", java.lang.String .class,"key"));
        __tag13.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(parent);
        __tag14.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.loanedToSourceCode", java.lang.String .class,"property"));
        __tag14.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"maxlength"));
        __tag14.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"size"));
        __tag14.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
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

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(parent);
        __tag15.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.loanedToSourceCode", java.lang.String .class,"property"));
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

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(parent);
        __tag16.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.loanedToSourceType", java.lang.String .class,"property"));
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

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(parent);
        __tag17.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.loanedToSourceCode", java.lang.String .class,"property"));
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

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(parent);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.givenBy", java.lang.String .class,"key"));
        __tag18.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(parent);
        __tag19.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.givenBy", java.lang.String .class,"property"));
        __tag19.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"maxlength"));
        __tag19.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"size"));
        __tag19.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
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

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(parent);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.receivedBy", java.lang.String .class,"key"));
        __tag20.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(parent);
        __tag21.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.receivedBy", java.lang.String .class,"property"));
        __tag21.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"maxlength"));
        __tag21.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"size"));
        __tag21.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
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

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(parent);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.reasonForLoan", java.lang.String .class,"key"));
        __tag22.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(parent);
        __tag23.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.reasonforLoan", java.lang.String .class,"property"));
        __tag23.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("100", java.lang.String .class,"maxlength"));
        __tag23.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"size"));
        __tag23.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
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

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(parent);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.remark", java.lang.String .class,"key"));
        __tag24.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(parent);
        __tag25.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.remarks", java.lang.String .class,"property"));
        __tag25.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("100", java.lang.String .class,"maxlength"));
        __tag25.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"size"));
        __tag25.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
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

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(parent);
        __tag26.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.remarks", java.lang.String .class,"property"));
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

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(parent);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.loanReceiptDetails", java.lang.String .class,"key"));
        __tag27.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(parent);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receive/writeOff", java.lang.String .class,"key"));
        __tag28.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.SelectTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.struts.taglib.html.SelectTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(parent);
        __tag29.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.receivedWriteOff", java.lang.String .class,"property"));
        __tag29.setOnchange(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("receivedQtyStatus();", java.lang.String .class,"onchange"));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            try {
                if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                    out = pageContext.pushBody();
                    _bw = (weblogic.servlet.jsp.ByteWriter)out;
                    __tag29.setBodyContent(( javax.servlet.jsp.tagext.BodyContent)out);
                    __tag29.doInitBody();
                }
                do {
                    _bw.write(_wl_block57Bytes, _wl_block57);

                    if (_jsp__tag30(request, response, pageContext, _activeTag, __tag29))
                     return true;
                    _bw.write(_wl_block57Bytes, _wl_block57);

                    if (_jsp__tag32(request, response, pageContext, _activeTag, __tag29))
                     return true;
                    _bw.write(_wl_block58Bytes, _wl_block58);
                } while (__tag29.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            } finally {
                if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                    out = pageContext.popBody();
                    _bw = (weblogic.servlet.jsp.ByteWriter)out;
                }
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

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.SelectTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.OptionTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.struts.taglib.html.OptionTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(parent);
        __tag30.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("R", java.lang.String .class,"value"));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            try {
                if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                    out = pageContext.pushBody();
                    _bw = (weblogic.servlet.jsp.ByteWriter)out;
                    __tag30.setBodyContent(( javax.servlet.jsp.tagext.BodyContent)out);
                    __tag30.doInitBody();
                }
                do {

                    if (_jsp__tag31(request, response, pageContext, _activeTag, __tag30))
                     return true;
                    _bw.write(_wl_block57Bytes, _wl_block57);
                } while (__tag30.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            } finally {
                if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                    out = pageContext.popBody();
                    _bw = (weblogic.servlet.jsp.ByteWriter)out;
                }
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

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.OptionTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(parent);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.received", java.lang.String .class,"key"));
        __tag31.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.SelectTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.OptionTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.struts.taglib.html.OptionTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(parent);
        __tag32.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("W", java.lang.String .class,"value"));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            try {
                if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                    out = pageContext.pushBody();
                    _bw = (weblogic.servlet.jsp.ByteWriter)out;
                    __tag32.setBodyContent(( javax.servlet.jsp.tagext.BodyContent)out);
                    __tag32.doInitBody();
                }
                do {

                    if (_jsp__tag33(request, response, pageContext, _activeTag, __tag32))
                     return true;
                    _bw.write(_wl_block57Bytes, _wl_block57);
                } while (__tag32.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            } finally {
                if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                    out = pageContext.popBody();
                    _bw = (weblogic.servlet.jsp.ByteWriter)out;
                }
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

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.OptionTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(parent);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.writeOff", java.lang.String .class,"key"));
        __tag33.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(parent);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.loanedQty", java.lang.String .class,"key"));
        __tag34.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(parent);
        __tag35.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.loanQty", java.lang.String .class,"property"));
        __tag35.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("5", java.lang.String .class,"maxlength"));
        __tag35.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("5", java.lang.String .class,"size"));
        __tag35.setReadonly(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
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

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(parent);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.receivedQty", java.lang.String .class,"key"));
        __tag36.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(parent);
        __tag37.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("", java.lang.String .class,"value"));
        __tag37.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.receivedQty", java.lang.String .class,"property"));
        __tag37.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("5", java.lang.String .class,"maxlength"));
        __tag37.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("5", java.lang.String .class,"size"));
        __tag37.setOnkeypress(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("checkQty(this);", java.lang.String .class,"onkeypress"));
        __tag37.setOnblur(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("setStatus();checkReceivedQty();", java.lang.String .class,"onblur"));
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

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(parent);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.receivedBackBy", java.lang.String .class,"key"));
        __tag38.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.bean.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.struts.taglib.bean.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(parent);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("com.iba.ehis.lc.receiveloanedlinen.givenBackBy", java.lang.String .class,"key"));
        __tag40.setBundle(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lcLabels", java.lang.String .class,"bundle"));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.bean.MessageTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.TextTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.struts.taglib.html.TextTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(parent);
        __tag41.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.givenBackBy", java.lang.String .class,"property"));
        __tag41.setMaxlength(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"maxlength"));
        __tag41.setSize(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("30", java.lang.String .class,"size"));
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

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(parent);
        __tag42.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.loanQty", java.lang.String .class,"property"));
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

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(parent);
        __tag43.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.receiveLoanedLinenVO.loanStatus", java.lang.String .class,"property"));
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

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(parent);
        __tag45.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.functionId", java.lang.String .class,"property"));
        __tag45.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("LC_LOAN_LINEN", java.lang.String .class,"value"));
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

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(parent);
        __tag46.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.moduleId", java.lang.String .class,"property"));
        __tag46.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("LC", java.lang.String .class,"value"));
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

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(parent);
        __tag47.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("vo.mode", java.lang.String .class,"property"));
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

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.struts.taglib.html.FormTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.struts.taglib.html.HiddenTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.struts.taglib.html.HiddenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(parent);
        __tag48.setProperty(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("method", java.lang.String .class,"property"));
        __tag48.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("2", java.lang.String .class,"value"));
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
}
