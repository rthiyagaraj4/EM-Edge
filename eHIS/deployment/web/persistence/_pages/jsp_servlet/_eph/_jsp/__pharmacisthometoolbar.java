package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.PharmacistHomeBean;
import ePH.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pharmacisthometoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PharmacistHomeToolbar.jsp", 1743137901993L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<STYLE TYPE=\"text/css\">\n\t\t\tA.imageClass1 \n\t\t\t{\n\t\t\t\twidth:30px;\n\t\t\t\theight:28px;\n\t\t\t\tmargin-left:0;\n\t\t\t\tmargin-right:0;\n\t\t\t\tmargin-top:0;\n\t\t\t\tmargin-bottom:0;\n\t\t\t\tpadding-left:3px;\n\t\t\t\tpadding-right:3px;\n\t\t\t\tpadding-top:2px;\n\t\t\t\tpadding-bottom:1px;\n\t\t\t\tborder-top:0px;\n\t\t\t}\n\t\t\tA.imageClass2 \n\t\t\t{\n\t\t\t\tbackground-color:#FFFFFF;\n\t\t\t\twidth:30px;\n\t\t\t\theight:28px;\n\t\t\t\tmargin-left:0;\n\t\t\t\tmargin-right:0;\n\t\t\t\tmargin-top:0;\n\t\t\t\tmargin-bottom:0;\n\t\t\t\tpadding-left:2px;\n\t\t\t\tpadding-right:2px;\n\t\t\t\tpadding-top:2px;\n\t\t\t\tpadding-bottom:1px;\n\t\t\t\tborder-left:1px solid;\n\t\t\t\tborder-right:1px solid;\n\t\t\t\tBORDER-COLOR: #75768B;\n\t\t\t}\n\t\t\timg\n\t\t\t{\n\t\t\t\tborder:0;\n\t\t\t}\n\n\t\t\tTR.iconBarRow\n\t\t\t{\n\t\t\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBG.jpg\');\n\t\t\t\twidth:1024;\n\t\t\t\theight:28px;\n\t\t\t\tborder-bottom:none;\n\t\t\t}\n\t\t\tTR.iconBarRowBlue\n\t\t\t{\n\t\t\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGBlue.jpg\');\n\t\t\t\twidth:1024;\n\t\t\t\theight:28px;\n\t\t\t\tborder-bottom:none;\n\t\t\t}\n\t\t\tTR.iconBarRowLime\n\t\t\t{\n\t\t\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGLime.jpg\');\n\t\t\t\twidth:1024;\n\t\t\t\theight:28px;\n\t\t\t\tborder-bottom:none;\n\t\t\t}\n\t\t\tTR.iconBarRowOrange\n\t\t\t{\n\t\t\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGOrange.jpg\');\n\t\t\t\twidth:1024;\n\t\t\t\theight:28px;\n\t\t\t\tborder-bottom:none;\n\t\t\t}\n\t\t\tTR.iconBarRowViolet\n\t\t\t{\n\t\t\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGViolet.jpg\');\n\t\t\t\twidth:1024;\n\t\t\t\theight:28px;\n\t\t\t\tborder-bottom:none;\n\t\t\t}\n\t\t\tIMG.imageClass\n\t\t\t{\n\t\t\t\tvertical-align: middle;\n\t\t\t}\n\n\t\t</STYLE>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../ePH/js/PharmacistHome.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCA/js/CACalculator.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<script>\n\t\tfunction MM_preloadImages(){ \n\t\t\tvar d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();\n\t\t\tvar i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)\n\t\t\tif (a[i].indexOf(\"#\")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}\n\t\t}\n\n\t\tfunction MM_swapImgRestore(){ \n\t\t\tvar i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;\n\t\t}\n\n\t\tfunction MM_findObj(n, d){\n\t\t\tvar p,i,x;  if(!d) d=document; if((p=n.indexOf(\"?\"))>0&&parent.frames.length) {\n\t\t\td=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}\n\t\t\tif(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];\n\t\t\t for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);\n\t\t\tif(!x && d.getElementById) x=d.getElementById(n); return x;\n\t\t}\n\n\t\tfunction MM_swapImage(){\n\t\t\tvar i,j=0,x,a=MM_swapImage.arguments;\n\t\t\tdocument.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)\n\t\t\tif ((x=MM_findObj(a[i]))!=null){\n\t\t\t  document.MM_sr[j++]=x; \n\t\t\t  if(!x.oSrc) x.oSrc=x.src; \n\t\t\t  x.src=a[i+2];\n\t\t\t}\n\t\t}\n\n\t\tfunction closeFunction(childyn,wname,flag){\n\t\t\twindow.location.href = \'../../eCommon/jsp/dmenu.jsp\';\n\t\t\tparent.location.href =\"../../eCommon/jsp/maindisplay.jsp\";\n\t\t}\n\t</script>\n\t</head>\n\t<body class=\"COMMON_TOOLBAR\" leftmargin=0 topmargin=0 onKeyDown=\"lockKey()\" OnMouseDown=\'CodeArrest()\' >\n\t\t<table width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t\t\t<tr class=\'iconBarRow";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<td width=\'5%\'>\n\t\t\t\t<input type=\'button\' name=\'clipTxtBtn\' id=\'clipTxtBtn\' style=\'display:none\' value=\'Clip Text\'>\n\t\t\t\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t\t<tr class=\'iconBarRow";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<td><a href=\"#\" name=\'Menu\' class=\"imageClass1\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'><img align=\'center\' src=\'../../eCA/images/MI_Show.gif\' name=\'ShowMenu\' style=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onclick=\"loadOrUnloadMenus(this)\" accesskey=\'M\' alt=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'></img>\n\t\t\t\t\t\t<img align=\'center\' src=\'../../eCA/images/MI_Hide.gif\' name=\'HideMenu\' style=\'display:none\'  onclick=\"loadOrUnloadMenus(this)\" accesskey=\'M\' alt=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'></img></a></td>\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\n\t\t\t\t\t\t\t<td id=\"home\" class=\'iconBarRow";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'><a href=\"#\" name=\'Home\' class=\"imageClass1\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'><img onclick=\"loadHomePage(\'\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' ,loadOrUnloadMenus(document.ShowMenu))\" id=\'searchPatHome\' src=\'../../eCA/images/MI_Home.gif\' align=\'center\' alt= \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'></img></a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<td class=\'iconBarRow";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'><a href=\"#\" name=\'ClinicalCalc\' class=\"imageClass1\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'><img align=\'center\' src=\'../../eCA/images/MI_ClinicalCalc.gif\' onclick=\"callCalculator()\" alt=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<td ><img align=\'center\' name=\'divider\' id=\'divider\' src=\'../../eCA/images/MI_htStrip";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =".gif\' alt=\'\' ></img></td>\t\n\t\t\t\t\t\n\t\t\t\t\t</tr></table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'\' align=\'right\' width=\'40%\'><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr class=\'iconBarRow";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\t\t\t\t<td class=\'iconBarRow";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' align=\'right\' id=\'quick\' >\n\t\t\t\t\t\t<select name=\'quick_links\' id=\'quick_links\'  onchange=\'loadFunction(this)\' style=\'FONT-SIZE:8pt\'>\n\t\t\t\t\t\t<option value = \'\'>-----";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="-----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t<td><a href=\"#\" name=\'RightStripQL\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'RightStrip1\',\'\',\'../../eCA/images/MI_RightStrip1";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =".gif\',1)\"><img src=\"../../eCA/images/MI_RightStrip2";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =".gif\" alt=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' name=\"RightStrip1\"  border=\"0\" id=\"RightStrip1\" onclick=\'UpdateResp()\' style=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' /></a>&nbsp;&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n      \t\n\t\t<td align=\'right\' width=\'3%\'><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\'right\'>\n\t\t<tr class=\'iconBarRow";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<td>\n\t\t<img class=\'imageClass\' id=\'seperator\' src=\'../../eCA/images/MI_htStrip";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =".gif\' alt=\'\'></img><td>\n\n\t\t<td><img class = \'imageClass\' align=\'center\' src=\'../../eCA/images/MI_SwitchT1.gif\' onclick=\"switchToLogin()\" alt=\'Switch Store\' id=\'switch_store\' name=\'switch_store\' style=\"margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;\"></img></td>\n\n\t\n\t\t<td><img class = \'imageClass\' align=\'center\' src=\'../../eCA/images/MI_CloseT1.gif\' onclick=\"closeFunction(\'\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'Y\')\" alt=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'close\' name=\'close\' style=\"margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;\"></img></td>\n\n\t\t</tr></table>\n\t\t</td>\n\n    </tr>\n</table>\n<table width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t<tr>\n\t\t<td class=\'iconBarRow";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'dispname\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t<td class=\'iconBarRow";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'filter_by\' style=\'display:none\' align=\'right\'><img src=\"../../eCA/images/filter.gif\" name=\'filterImg\' alt=\'Filter\' /> : <select name=\'filter\' id=\'filter\' onchange=\'loadFilterFunction(this)\'><option value=\'\'>---";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="---</option></select><a href=\"#\"><img src=\"../../eCA/images/customize.gif\" alt=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' name=\"RightStrip1\"  border=\"0\" id=\"RightStrip1\" onclick=\'UpdateFilter()\' /></a>&nbsp;&nbsp;\n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'\'><input type=\'hidden\' name=\'executable_path\' id=\'executable_path\' value=\'\'></td>\n\t\t<td class =\'LABELRIGHT\' id=\'myTask\' style=\'display:none\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href=\'javascript:refresh();\'><u>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</u></A></td>\n\t</tr>\n</table>\n\n<form name=\'homePageParam\' id=\'homePageParam\' >\n    <input type=\'hidden\' name=\'desktop_id\' id=\'desktop_id\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n    <input type=\'hidden\' name=\'dfltFunctionId\' id=\'dfltFunctionId\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t <input type=\'hidden\' name=\'menuId\' id=\'menuId\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>  \n</form>\n\n\n</body>\n<script>\n\nasync function customizeIcons()\n{\t\n\tvar dialogHeight= \"420px\" ;\n\tvar dialogWidth\t= \"380px\" ;\n\tvar dialogTop\t= \"105\";\n\tvar dialogLeft\t= \"350\";\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\"+dialogTop+\" ;dialogLeft=\"+dialogLeft+\";scroll=no; status:no;help:no \";\n\n\tvar ret = await window.showModalDialog(\"../../eCA/jsp/CAMainCustomizeToolbar.jsp?";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&menuId=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&patientclass=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\",arguments,features);\n\t\n\tif(ret != \'\' && ret != undefined)\n\t{\n\t\tdisplayIcons(ret);\n\t}\n}\nfunction displayIcons(tableVal)\n{\n\ttableVal = tableVal.replace(/~/g,\'\"\');\n\t//refreshIcons.innerHTML = tableVal;\n\n}\nasync function UpdateResp()\n{\t\n\tvar dialogHeight= \"50vh\" ;\n\tvar dialogWidth\t= \"60vw\" ;\n\tvar dialogTop\t= \"150\";\n\tvar dialogLeft\t= \"200\";\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\"+dialogTop+\" ;dialogLeft=\"+dialogLeft+\";scroll=no; status:no \";\n\n\tvar ret = await window.showModalDialog(\"../../eCA/jsp/QuickLinksForRespCustomize.jsp?";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&link_type=Q&patientclass=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\",arguments,features);\n\t\n\tif(ret != \'\' && ret != undefined)\n\t{\n\n\t\tif(parent.CommonToolbar.quick_links != null)\n\t\t{\n\t\t\tvar optlength = parent.CommonToolbar.quick_links.options.length;\n\t\t\tfor (var i=0; i<optlength; i++)\n\t\t\t{\n\t\t\t\tparent.CommonToolbar.quick_links.options.remove(\"quick_links\");\n\t\t\t}\n\t\t\tvar HTMLVal=\"<html><body><form name=\'QuickLinksUpdateDescForm\' id=\'QuickLinksUpdateDescForm\' method=\'post\' action=\'../../eCA/jsp/QuickLinksForRespUpdateDesc.jsp?";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\"+\n\t\t\t\"</form></body></html>\";\n\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\t\tparent.messageFrame.document.QuickLinksUpdateDescForm.submit();\n\t\t}\n\t}\n}\nasync function UpdateFilter()\n{\n\tvar function_id = parent.CommonToolbar.function_id.value;\n\tvar dialogHeight= \"40vh\" ;\n\tvar dialogWidth\t= \"60vw\" ;\n\tvar dialogTop\t= \"150\";\n\tvar dialogLeft\t= \"200\";\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\"+dialogTop+\" ;dialogLeft=\"+dialogLeft+\";scroll=no; status:no \";\n\n\tvar ret = await window.showModalDialog(\"../../eCA/jsp/QuickLinksForRespCustomize.jsp?function_id=\"+function_id+\"&";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&link_type=F\",arguments,features);\n\t\n\tif(ret != \'\' && ret != undefined)\n\t{\n\t\tif(parent.CommonToolbar.filter != null)\n\t\t{\n\t\t\tvar optlength = parent.CommonToolbar.filter.options.length;\n\t\t\tfor (var i=0; i<optlength; i++)\n\t\t\t{\n\t\t\t\tparent.CommonToolbar.filter.options.remove(\"filter\");\n\t\t\t}\n\n\t\t\tvar HTMLVal=\"<html><body><form name=\'QuickLinksUpdateDescForm\' id=\'QuickLinksUpdateDescForm\' method=\'post\' action=\'../../eCA/jsp/QuickLinksForRespUpdateFilter.jsp\'>\"+\n\t\t\t\"<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'\"+function_id+\"\'>\"+\n\t\t\t\"</form></body></html>\";\n\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\t\tparent.messageFrame.document.QuickLinksUpdateDescForm.submit();\n\t\t}\n\t}\n}\n</script>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t<script>\n\t\t\t\t\tloadOrUnloadMenus(document.ShowMenu);\n\t\t\t\t\tparent.menuFrame.location.href=\'../../ePH/jsp/PharmacistHomeMenu.jsp?locale=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&limit_function_id=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="&dfltFunctionId=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&deskTopID=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&userdef_desktop_desc=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\';\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );
	
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
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		try{
			String bean_id   = "PharmacistHomeBean" ;
			String bean_name = "ePH.PharmacistHomeBean";
			PharmacistHomeBean bean = (PharmacistHomeBean)getBeanObject( bean_id, bean_name, request ) ;

			StringBuffer strBuffPatientInfo = new StringBuffer();
			String respid= request.getParameter("responsibility_id");
			String lookup_window_name = request.getParameter("lookup_window_name")==null?"":request.getParameter("lookup_window_name");			
			String function_display_name = request.getParameter("function_display_name")==null?"":request.getParameter("function_display_name");
			String window_name = request.getParameter("window_name")==null?"":request.getParameter("window_name");
			String lookupFileName = request.getParameter("lookupFileName")==null?"":request.getParameter("lookupFileName");
			String from_service_yn = request.getParameter("from_service_yn")==null?"N":request.getParameter("from_service_yn");
			String strRelnYn		= request.getParameter("RelnYn")==null?"Y":request.getParameter("RelnYn");

			if (from_service_yn.equals("") )
				from_service_yn="N";
			
			String limit_function_id = request.getParameter("limit_function_id")==null?"":request.getParameter("limit_function_id");
			String chartTitle = request.getParameter("chartTitle")== null?"":request.getParameter("chartTitle");
            String name=(String)session.getValue("practitioner_name");
			String practitioner_id	= (String) session.getValue("ca_practitioner_id"); 
			String pract_type =(String) session.getValue("practitioner_type");
			String menu_Active = "N";

			String dektop_params="";
			String desktop_id="",userdef_desktop_desc="";
			String dfltFunctionId="";			
			String altText="", wname="";
			
			//ArrayList dfltDesktopDtl = bean.getDesktopDtl(respid);THIS NEED TO UNCOMMENT
			ArrayList dfltDesktopDtl = bean.getDesktopDtl();

			if(dfltDesktopDtl!=null && dfltDesktopDtl.size()>0){
				desktop_id			 = (String)dfltDesktopDtl.get(0);
				userdef_desktop_desc = (String)dfltDesktopDtl.get(1);
				dfltFunctionId		 =(String)dfltDesktopDtl.get(2);
			}

             String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
             String queryString = request.getQueryString()== null?"":request.getQueryString() ;
             String defmode = mode;
			
			 String facility_id      = (String)session.getValue( "facility_id" ) ;
			 String menu_id="MED_DFLT",patientclass="",speciality_code="";

			 String styleMap = "";
			 if(sStyle.equals("IeStyleBlue.css"))
				styleMap = "Blue";
			 else if(sStyle.equals("IeStyleLime.css"))
				styleMap = "Lime";
			 else if(sStyle.equals("IeStyleOrange.css"))
				styleMap = "Orange";
			 else if(sStyle.equals("IeStyleVoilet.css"))
				styleMap = "Violet";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(lookupFileName.equals("") && limit_function_id.equals("")){
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block11Bytes, _wl_block11);

					if(menu_Active.equals("N") && lookupFileName.equals("")){
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(limit_function_id.equals("")?"display:inline":"display:none"));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
					if(lookupFileName.equals("") && from_service_yn.equals("N"))
					{
												
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dfltFunctionId));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
				
					}	
					
					if(from_service_yn.equals("N") && lookupFileName.equals("")&& limit_function_id.equals(""))
					{
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

					}
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block24Bytes, _wl_block24);

					if(lookupFileName.equals("") && limit_function_id.equals(""))
						{
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

						/*if(detl_sql.length() > 0)
							detl_sql.delete(0,detl_sql.length());

						detl_sql.append("select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, A.OPTION_ID,  B.EXECUTABLE_NAME EXECUTABLE_NAME, B.LONG_DESC,A.QUERY_STRING,a.QUICK_LINK_REF from sm_quick_link_list_lang_vw A, CA_OPTION B,sm_quick_link_resp d,");//IN036367
						if(Existance_Count>0)
							detl_sql.append(" SM_QUICK_LINK_FOR_USER C where C.APPL_USER_ID = ? ");
						else
							detl_sql.append(" SM_QUICK_LINK_RESP C where C.RESP_ID = ? ");

						detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' and a.added_facility_id = '"+facility_id+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND B.OPTION_ID(+)=A.OPTION_ID AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND B.EXECUTABLE_NAME IS NOT NULL AND a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? AND d.link_type = 'Q'");
							detl_sql.append(" and B.DESKTOP_YN(+) = 'N' ");
							if(mode.equals("V"))
								detl_sql.append(" and b.HIST_OR_RECORD = 'H' ");
						detl_sql.append(" and exists (select 1 from ca_appl_task ia where OPTION_ID(+) = a.OPTION_ID and  GET_TASK_APPLICABILITY(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) = 'A' and (ia.BASE_MODULE_ID = 'CA' or exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ");
						
						detl_sql.append(" ))) UNION ALL select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, '' OPTION_ID, A.EXTERNAL_URL_APPL EXECUTABLE_NAME, '' LONG_DESC,A.QUERY_STRING,a.QUICK_LINK_REF  from sm_quick_link_list_lang_vw A,sm_quick_link_resp d, ");//IN036367
						if(Existance_Count>0)
							detl_sql.append(" SM_QUICK_LINK_FOR_USER C where C.APPL_USER_ID = ? ");
						else
							detl_sql.append(" SM_QUICK_LINK_RESP C where C.RESP_ID = ? ");

						//detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND A.EXTERNAL_URL_APPL  IS NOT NULL AND QUICK_LINK_TYPE = 'EX' order by 2");//IN29822
						detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' and a.added_facility_id = '"+facility_id+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND A.EXTERNAL_URL_APPL  IS NOT NULL AND QUICK_LINK_TYPE = 'EX' AND a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? order by 2");//IN29822 //IN035499
						

						pstmt = con.prepareStatement(detl_sql.toString());
						int val = 0;
						if(Existance_Count>0){
							pstmt.setString(++val,login_user);

						}
						else
							{
							pstmt.setString(++val,resp_id);

							}
						pstmt.setString(++val,resp_id);//IN29822
						pstmt.setString(++val,resp_id);
						pstmt.setString(++val,reln_id);
						pstmt.setString(++val,facility_id);
						pstmt.setString(++val,episode_id);
						

						if(!patient_id.equals(""))
						{
							pstmt.setString(++val,splty_code);

						}

						if(Existance_Count>0)
							pstmt.setString(++val,login_user);
						else
							pstmt.setString(++val,resp_id);
						pstmt.setString(++val,resp_id);//IN29822
						
						rs = pstmt.executeQuery();

						while(rs.next())
						{
							
							executable_name = rs.getString("EXECUTABLE_NAME")==null?"":rs.getString("EXECUTABLE_NAME");
							if(!executable_name.equals("")){
								if (executable_name.indexOf("~PATIENT_ID`") >= 0){
										executable_name = executable_name.replaceAll("~PATIENT_ID`",patient_id);
								}
								if (executable_name.indexOf("~ENCOUNTER_ID`")>=0){
										executable_name = executable_name.replaceAll("~ENCOUNTER_ID`",episode_id);	
								}if (executable_name.indexOf("~FACILITY_ID`")>= 0){
										executable_name = executable_name.replaceAll("~FACILITY_ID`",facility_id);
								}
								if (executable_name.indexOf("~NRIC`")>= 0){
										executable_name = executable_name.replaceAll("~NRIC`",nric_code);
								}
							}
							v_query_string = rs.getString("QUERY_STRING")==null?"":rs.getString("QUERY_STRING");
							if(!v_query_string.equals("")){
								
								if (v_query_string.indexOf("~PATIENT_ID`") >= 0){
										v_query_string = v_query_string.replaceAll("~PATIENT_ID`",patient_id);
								}
								if (v_query_string.indexOf("~ENCOUNTER_ID`")>=0){
										v_query_string = v_query_string.replaceAll("~ENCOUNTER_ID`",episode_id);	
								}if (v_query_string.indexOf("~FACILITY_ID`")>= 0){
										v_query_string = v_query_string.replaceAll("~FACILITY_ID`",facility_id);
								}
								if (v_query_string.indexOf("~NRIC`")>= 0){
										v_query_string = v_query_string.replaceAll("~NRIC`",nric_code);
								}
							} 							
							option_id.delete(0,option_id.length());
							option_id.append(rs.getString("OPTION_ID"));
							option_id.append("|");
							option_id.append(rs.getString("QUICK_LINK_TYPE"));
							option_id.append("|");
							option_id.append(rs.getString("LONG_DESC"));
							
							option_id.append("|");							
							option_id.append(executable_name);
							option_id.append("|");//IN036367
							option_id.append(rs.getString("QUICK_LINK_REF"));//IN036367
							if(!v_query_string.equals("")){ 
								option_id.append("?");							
								option_id.append(v_query_string);
							}
						}*/
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(limit_function_id.equals("")?"display:inline":"display:none"));
            _bw.write(_wl_block32Bytes, _wl_block32);

						}
				
            _bw.write(_wl_block33Bytes, _wl_block33);

				}
			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(wname));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(altText));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(function_display_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMYHMS",locale)));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(desktop_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(dfltFunctionId));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block56Bytes, _wl_block56);

			if(menu_Active.equals("N") && lookupFileName.equals("")){

            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(dfltFunctionId));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(desktop_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(userdef_desktop_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
			}
		}
		catch(Exception e){
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ShowMenu.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.HideMenu.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.HOMEPAGE.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClinicalCalculator.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.QuickLinks.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomiseLinks.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomiseFilter.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MyTaskList.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Detailsason.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Refresh.label", java.lang.String .class,"key"));
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
