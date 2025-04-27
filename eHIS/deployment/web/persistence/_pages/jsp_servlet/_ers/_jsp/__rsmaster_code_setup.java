package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __rsmaster_code_setup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/RSMaster_Code_Setup.jsp", 1709121649965L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n\t<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n\t<script language=JavaScript src=\"../../eCommon/js/menu.js\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t<script>\n\t\tvar temparr = new Array();\n\t\tvar count = 0;\n\t\tvar prev=0;\n\t\tvar prevcol=\'MENUSUBLEVELCOLOR\';\n\t\tvar sec_hdg_cd=new Array();\n\t\tvar logic_seq_no=new Array();\n\n\t\tfunction goHomePage(){\n\t\t\tparent.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t}\n\n\t\tfunction chcol(ro)\n\t\t{\n\t\t\t\tif (document.getElementById(\"t\").rows(prev).cells(0).className != \'ECMENUHIGHERLEVELCOLOR\') {\n\t\t\t\t\tdocument.getElementById(\"t\").rows(prev).cells(0).className=prevcol;\n\t\t\t\t}\n\t\t\t\tprevcol=ro.cells(0).className;\n\t\t\t\tro.cells(0).className=\"MENUSELECTEDCOLOR\";\n\t\t\t\tprev=ro.rowIndex;\n\t\t}\n\n\t\tfunction callJSPs(val)\n\t\t{\n\t\t\t/*\n\t\t\t\tAccess is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess\n\t\t\t*/\n\n\t\t\tif(val == \'Grade\'){\n\t\t\t\tparent.frames[1].location.href = \'Grade.jsp?module_id=RS&function_id=Grade&function_name=Grade&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'Reason\'){\n\t\t\t\tparent.frames[1].location.href = \'Reason.jsp?module_id=RS&function_id=Reason&function_name=Reason&function_type=F&access=YYYNN\';\n\t\t\t}\n\n\t\t\tif(val == \'Training\'){\n\t\t\t\tparent.frames[1].location.href = \'Training.jsp?module_id=RS&function_id=Training&function_name=Training&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'Access_ Rights\'){\n\t\t\t\tparent.frames[1].location.href = \'AccessRights.jsp?module_id=RS&function_id=AccessRights&function_name=Access Rights&function_type=F&access=YYYNN\';\n\t\t\t}\n\n\t\t\tif(val == \'workplace\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'Workplace.jsp?module_id=RS&function_id=Workplace&function_name=Workplace&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'staffprofile\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'StaffProfileSetup.jsp?module_id=RS&function_id=StaffProfile&function_name=Staff  Profile&function_type=F&access=NNNNY\';\n\t\t\t}\n\t\t\tif(val == \'staff_for_workplace\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'StaffForWorkplace.jsp?module_id=RS&function_id=Staff_For_Workplace&function_name=Staff For Workplace&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'shift_for_workplace\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'ShiftForWorkplace.jsp?module_id=RS&function_id=Shift_For_Workplace&function_name=Shift For Workplace&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'shift_pattern\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'ShiftPattern.jsp?module_id=RS&function_id=Shift_Pattern&function_name=Shift Pattern&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'shift_pattern_for_workplace\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'ShiftPatternForWorkplace.jsp?module_id=RS&function_id=Shift_Pattern_For_Workplace&function_name=Shift Pattern For Workplace&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'skill\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'Skill.jsp?module_id=RS&function_id=Skill&function_name=Skill&function_type=F&access=YYYNN\';\n\t\t\t}\n\t\t\tif(val == \'skillforposition\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'SkillForPosition.jsp?module_id=RS&function_id=SkillForPosition&function_name=Skill for Position&function_type=F&access=YYYNN\';\n\t\t\t}\n            if(val == \'licensure\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'Licensure.jsp?module_id=RS&function_id=Licensure&function_name=Licensure&function_type=F&access=YYYNN\';\n\t\t\t}\n            if(val == \'workplace_requirement\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'WorkplaceRequirement.jsp?module_id=RS&function_id=WorkplaceRequirement&function_name=Workplace Requirement&function_type=F&access=YYYNN\';\n\t\t\t}\n            if(val == \'locnforworkplace\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'LocnForWorkplace.jsp?module_id=RS&function_id=locnforworkplace&function_name=Locations For Workplace&function_type=F&access=YYYNN\';\n\t\t\t}\n            if(val == \'Parameter\')\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href = \'Parameter.jsp?module_id=RS&function_id=Parameter&function_name=Parameters&function_type=F&access=YYYYN\';\n\t\t\t}\n\t\t}\n\n\n\n\tfunction showFunctionality(){\n\t\tvar retVal = new Array();\n\n\t\tvar features\t= \'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1\';\n\t\tvar arguments\t= \'\' ;\n\n\t\tvar vals = parent.parent.header.document.header_form.menu_values.value;\n\t\tMPMasterMenu_form.menu_values.value = vals;\n\n\t\targuments = vals\n\n\t\tretVal\t= window.showModalDialog(\'change_functionality.jsp\',arguments,features);\n\n\n\t\tif(retVal != null)\n\t\t{\n\t\t\tretVal = retVal.replace(\"location\",\"parent.parent.frames[1].location\")\n\t\t\teval(retVal)\n\t\t}\n\t}\n\n\t</script>\n\n\t</head>\n\n\t<body style=\"background-color:dimgray;\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\"MPMasterMenu_form\" id=\"MPMasterMenu_form\">\n\t<input type=hidden name=\'menu_values\' id=\'menu_values\'>\n\n\t<table cellspacing=1 cellpadding=2 width=\'100%\' border=0 id=\'t\'>\n\t\t<tr>\n\t\t\t<td  class=\'ECMENUHIGHERLEVELCOLOR\' onClick=\"\">Code Setup</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'Grade\')\">Grade</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'Reason\')\">Reason</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'Training\')\">Training</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'skill\')\">Skill</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'skillforposition\')\">Skill for Position</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'licensure\')\">Licensure</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'workplace\')\">Workplace</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'locnforworkplace\')\">Locations for Workplace</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'staffprofile\')\">Staff Profile</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'staff_for_workplace\')\">Staff for Workplace</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'shift_for_workplace\')\">Shift for Workplace</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'workplace_requirement\')\">Workplace Requirement</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'shift_pattern\')\">Shift Pattern</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'shift_pattern_for_workplace\')\">Shift Pattern for Workplace</td>\n\t\t</tr>\n\t\t<!-- End -->\n\t\t<tr>\n\t\t\t<td  class=\'ECMENUHIGHERLEVELCOLOR\' onClick=\"\">Admin Setup</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'Parameter\')\">Parameters</td>\n\t\t</tr>\n\t\t<tr onclick=\'chcol(this)\'>\n\t\t\t<td  class=\'MENUSUBLEVELCOLOR\' onClick=\"javascript:callJSPs(\'Access_ Rights\')\">Access Rights</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'ECMENUHIGHERLEVELCOLOR\' ><a href=\"javascript:goHomePage()\" style=\'color:white;\'><b>HOME</b></a></td>\n\t\t</tr>\n\t</table>\n    </form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
