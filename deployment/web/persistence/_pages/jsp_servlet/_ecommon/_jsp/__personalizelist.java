package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __personalizelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/PersonalizeList.jsp", 1742203303217L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE> New Document </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<SCRIPT LANGUAGE=\"JavaScript\">\n\n\tasync\tfunction toolFunction(opt) {  \n\t\t\tif(opt ==1) {\n\t\t\t\tvar retVal = new Array();\n\t\t\tvar features\t= \'dialogHeight:20; dialogWidth:28;dialogTop:150;status=no;scroll=no\';\n\t\t\tvar arguments\t= \'\' ;\n\t\t\tretVal =await window.showModalDialog(\'../../eSM/jsp/change_password_frames.jsp\',arguments,features);\n\t\t\t//window.location.href=\'../../eSM/jsp/change_password.jsp\'\n\t\t\t}\n\t\t\tif(opt ==2 ){\n\t\t\t\t//color theme\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'==\'HomeSummary\'){ \n\t\t\t\t\tparent.workAreaFrame.location.href=\"../../eCommon/jsp/personoliseTheme.jsp?mode=view&persFrom=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\tparent.CommonToolbar.document.getElementById(\"dispname\").innerHTML = \'\';\n\t\t\t\t}else{ \n\t\t\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/personoliseTheme.jsp?mode=view\"\n\t\t\t\t} \n\t\t\t}\n\t\t\tif(opt ==3 ){\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'==\'HomeSummary\'){\n\t\t\t\t\t//parent.workAreaFrame.location.href=\'../../eSM/jsp/FreqAccessFunc.jsp?module_id=SM&function_id=FREQ_ACCESS_FUNC&function_name=\'+encodeURIComponent(getLabel(\"Common.frequentlyAccessedFunctions.label\",\"common\"))+\'&function_type=F&access=YYNNY&persFrom=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\t\t\t\t\tparent.workAreaFrame.location.href=\'../../eSM/jsp/FreqAccessFunc.jsp?module_id=SM&function_id=FREQ_ACCESS_FUNC&function_name=\'+encodeURIComponent(getLabel(\"Common.frequentlyAccessedFunctions.label\",\"common\"))+\'&function_type=F&access=YYNNY&persFrom=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\t\t\t\t\tparent.CommonToolbar.document.getElementById(\"dispname\").innerHTML = \'\';\n\t\t\t\t}else{\n\t\t\t\t\tparent.parent.frames[2].location.href=\'../../eSM/jsp/FreqAccessFunc.jsp?module_id=SM&function_id=FREQ_ACCESS_FUNC&function_name=\'+encodeURIComponent(getLabel(\"Common.frequentlyAccessedFunctions.label\",\"common\"))+\'&function_type=F&access=YYNNY\'\n\t\t\t\t}\n\t\t//parent.parent.frames[1].expand()\n\t\t\t}\n\t\tif(opt ==4 ){\t\t\t\n\t\t\tif(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'==\'HomeSummary\'){\n\t\t\t\t\n\t\t\t\tif (\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  == \"CA\")\n\t\t\t\t{\n\t\t\t\t\tif (top.window.top.content.CommonToolbar.pat_info != null ){\n\t\t\t\t\t\tvar pat_info_temp = new Array();\t\t\t\t\t\t\n\t\t\t\t\t\tpat_info_backup = top.window.top.content.CommonToolbar.pat_info;\n\t\t\t\t\t\tvar j=0 ;\n\t\t\t\t\t\tvar pat_info_len;\n\t\t\t\t\t\tif( top.window.top.content.CommonToolbar.pat_info != null)\n\t\t\t\t\t\t\tpat_info_len = top.window.top.content.CommonToolbar.pat_info.length;\n\n\t\t\t\t\t\tif(top.window.top.content.CommonToolbar.pat_info != null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t  for(var i=0;i<pat_info_len;i++)\n\t\t\t\t\t\t  {\n\t\t\t\t\t\t\t if(!top.window.top.content.CommonToolbar.pat_info[i].window_obj.closed  )\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t  pat_info_temp[j] = top.window.top.content.CommonToolbar.pat_info[i]\n\t\t\t\t\t\t\t\t  j++\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttop.window.top.content.CommonToolbar.pat_info = pat_info_temp;\t\t\t\t\t\t\n\t\t\t\t\t\tif (top.window.top.content.CommonToolbar.pat_info.length >0){\t\t\t\t\t\t\t\n\t\t\t\t\t\t\talert(getMessage(\"CANNOT_SWITCH_LANG\",\"COMMON\"));\t\t\t\t\t\t\t\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tparent.workAreaFrame.location.href=\'../../eCommon/jsp/SwitchLanguage.jsp?module_id=SM&function_id=SWITCH_LANG&function_name=\'+encodeURIComponent(getLabel(\"Common.switchlanguage.label\",\"common\"))+\'&function_type=F&access=NYNNY&persFrom=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t}else\t{\t\n\t\t\t\t\tparent.workAreaFrame.location.href=\'../../eCommon/jsp/SwitchLanguage.jsp?module_id=SM&function_id=SWITCH_LANG&function_name=\'+encodeURIComponent(getLabel(\"Common.switchlanguage.label\",\"common\"))+\'&function_type=F&access=NYNNY&persFrom=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t\t}\n\t\t\t\t\t\tparent.CommonToolbar.document.getElementById(\"dispname\").innerHTML = \'\';\n\t\t\t}else{\n\t\t\t\t\n\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/SwitchLanguage.jsp?module_id=SM&function_id=SWITCH_LANG&function_name=\'+encodeURIComponent(getLabel(\"Common.switchlanguage.label\",\"common\"))+\'&function_type=F&access=NYNNY\'\n\t\t\t}\n\t\t//parent.parent.frames[1].expand()\n\t\t\t}\n\t\t}\n\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' type=\'text/css\' ></link>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/dtree.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n</HEAD>\n\n<BODY class=\'NavigIconsBorderTop\' onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t\t<script>\n\t\td = new dTree(\'freqd\');\n\t\td.config.useStatusText=true;\n\t\td.add(0,-1,\"<b>\"+getLabel(\'Common.personalizeoptions.label\',\'common\')+\"</b>\");\n\t\td.add(1,0,getLabel(\'Common.changepassword.label\',\'common\'),\"javascript:toolFunction(1)\",\'\',\'\');\n\t\t//d.add(2,0,\'Color Theme\',\"javascript:toolFunction(2)\",\'\',\'\');\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\td.add(2,0,getLabel(\'Common.frequentlyAccessedFunctions.label\',\'common\'),\"javascript:toolFunction(3)\",\'\',\'\');\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\td.add(3,0,getLabel(\'Common.colortheme.label\',\'common\'),\"javascript:toolFunction(2)\",\'Personalize look and feel, choose your favorite theme\',\'\');\n\t\td.add(4,0,getLabel(\'Common.switchlanguage.label\',\'common\'),\"javascript:toolFunction(4)\",\'Switch Language\',\'\'); \nconsole.log(d);\nconsole.log(dTree);\ndocument.write(d);\n</script>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String persFrom=request.getParameter("persFrom")==null?"":request.getParameter("persFrom");
	String called_from=request.getParameter("persFrom")==null?"":request.getParameter("called_from");
	

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(persFrom));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(persFrom));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(persFrom));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(persFrom));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(persFrom));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(persFrom));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(persFrom));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(persFrom));
            _bw.write(_wl_block12Bytes, _wl_block12);

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";		
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(persFrom.equals("HomeSummary")){
		}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
