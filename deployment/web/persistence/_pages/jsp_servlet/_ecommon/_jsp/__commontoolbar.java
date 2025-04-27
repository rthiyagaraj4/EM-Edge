package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __commontoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/commonToolbar.jsp", 1732869250932L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/ecommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\' />\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\"JavaScript\">\n\t\t\tfunction activate( newimg ) {\n\t\t\t\tdocument.blankImage.src=\"../../eCommon/images/\" + newimg;\n\t\t\t\treturn true;\n\t\t\t}\n\n\t\t\tfunction disableMenuBtnFromCA(){\n\t\t\t\tif(parent.parent.frames[0].document.getElementById(\"toolbarQueryString\")){\n\t\t\t\t\tif(document.forms[0].home){\n\t\t\t\t\t\tdocument.forms[0].home.style.visibility\t\t= \'hidden\';\n\t\t\t\t\t\tdocument.getElementById(\"cmnToolBarFuncName\").innerHTML\t= \'\';\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\n\t\t\t//added by sri\n\t\t\tfunction onDelete(){\n\t\t\t  parent.deleterecord();\n\t\t\tparent.commontoolbarFrame.location.href=\'../../eCommon/jsp/process.jsp\';\n\t\t\t}\n\t\t\t//ends here sri\n\n\t\t\tfunction onApply() {\n\t\t\t\tparent.apply() ;\n\t\t\t\t//Commented by Sethu for the EDGE issue 65480 on 30/08/2024 \n\t\t\t\t//parent.commontoolbarFrame.location.href=\'../../eCommon/jsp/process.jsp\';\n\t\t\t}\n\n\t\t\t\n\t\t\tfunction reset_page()\n\t\t\t{\n\t\t\tvar expand;\n\t\t\tvar final_name=getLabel(\"Common.menu.label\",\"Common\");\n\t\t\tif(parent.commontoolbarFrame.document.forms[0].home)\n\t\t\t\t{\n\t\t\tif(parent.commontoolbarFrame.document.forms[0].home.value ==final_name )\n\t\t\t\t\t{\n\t\t\t\t\t\texpand=\"0\";\n\t\t\t\t\t}else\n\t\t\t\t\t{\n\t\t\t\t\t\texpand=\"1\";\n\t\t\t\t\t}\n\t\t\t\t\t\n\n\t\t\t\t\n\t\t\t\t\tvar error=\'R\';\n\t\t\t\t\tvar url=\"../../eCommon/jsp/error.jsp?err_num=\"+error;\n\t\t\t\t\tparent.messageFrame.location.href=url;\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\tparent.reset();\n\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t}\n\t\t\t\t\t\n\t\t\t}\n\t\t\t/* Below method added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-MAY-2013*/\n\t\t\tfunction menuHide()\n\t\t\t{ \n\t\t\tif(document.forms[0].function_id.value==\'MANAGE_PAT_QUEUE\'){parent.menuHide()}\n\t\t\t/* Below method added by Venkatesh.S  against  Bru-HIMS-CRF-362[39365] on 11-Nov-2013*/\n            if((document.forms[0].function_id.value==\'AE_MANAGE_PATIENT\')||(document.forms[0].function_id.value==\'AE_CHECK_OUT\')){\n\t\t\tparent.menuHide();\n\t\t\t}\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t</script>\n</head>\n\n<body onKeyDown = \'lockKey();\' class=\"COMMON_TOOLBAR\" bottommargin=0 leftmargin=0 topmargin=0 onload=\"disableMenuBtnFromCA();\">\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<form name=\"CommonToolbar_form\" id=\"CommonToolbar_form\">\n<table width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t<tr class=\"COMMONTOOLBARFUNCTION\">\n\t\t<td align=\"left\" class=\"COMMONTOOLBARFUNCTION\" id=\"cmnToolBarFuncName\">\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t</td>\n\t</tr>\n\t<tr class=\"COMMON_TOOLBAR\">\n\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t<table width=\"100%\" cellspacing=\'0\' cellpading=\'0\'>\n\t\t\t\t<tr class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t<td class=\"COMMON_TOOLBAR\" align=\"left\" width=\"50%\">\n\t\t\t\t\t\t<table cellspacing=\'0\' cellpading=\'0\'>\n\t\t\t\t\t\t\t<tr class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t\t <input type=\'button\' onclick=\"parent.create();parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\'\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' name=\'create\' id=\'create\' class=\'BUTTON\' ACCESSKEY=\'C\'></input>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t\t <input type=\'button\' onclick=\"parent.query();parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\'\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' name=\'query\' id=\'query\' class=\'BUTTON\' ACCESSKEY=\'Q\'></input>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t\t<input type=\'button\' onclick=\"onDelete();\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' class=\'BUTTON\' ACCESSKEY=\'D\'></input>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t\t<input type=\'button\' onclick=\"onApply();\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'apply\' name=\'apply\' class=\'BUTTON\' ACCESSKEY=\'A\'></input>\n\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t\t<input type=\'button\' onclick=\"parent.run();\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'id=\'run\' name=\'run\'  class=\'BUTTON\' ACCESSKEY=\'R\'></input>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\t\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t\t<input type=\'button\' onclick=\"reset_page();\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'reset\' name=\'reset\' class=\'BUTTON\' ACCESSKEY=\'R\'></input>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<input type=\'button\' onClick=\'parent.parent.parent.frames[1].expand(this);menuHide()\' onclick=\"\'\" value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'home\' name=\'home\' class=\'BUTTON\'></input>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td class=\"COMMON_TOOLBAR\" align=\"right\" width=\"50%\">\n\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n\t<!-- Below method added by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-MAY-2013 -->\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'> \n</form>\n</body>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);

	
	request.setCharacterEncoding("UTF-8");

	//response.setContentType("text/html;charset=UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		

		String locale = (String)session.getValue("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

	

	String queryString	= request.getQueryString() ;
	

	session.putValue( "queryString",queryString) ;
String expand="";

	String module_id		= request.getParameter( "module_id" ) ;
	String function_id	= request.getParameter( "function_id" ) ;
	String function_name 	= request.getParameter( "function_name" ) ;
	String function_type	= request.getParameter( "function_type" ) ;
	String access		= request.getParameter( "access" ) ;
		expand	= request.getParameter("expand") ;
		if(expand ==null) expand="";
	String home_required_yn =  request.getParameter("home_required_yn" ) ;
	if (home_required_yn ==null) home_required_yn ="";
	if ( module_id		== null ) module_id 	= "" ;
	if ( function_id		== null ) function_id 	= "" ;
	if ( function_name	== null ) function_name	= "" ;
	if ( function_type	== null ) function_type	= "F" ;
	if ( access			== null ) access		= "NNNNN" ;


	String insert_access	= access.substring( 0,1 ) ;
	String update_access	= access.substring( 1,2 ) ;
	String query_access	= access.substring( 2,3 ) ;
	String delete_access	= access.substring( 3,4 ) ;
	//String print_access	= access.substring( 4,5 ) ;


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( function_name ));
            _bw.write(_wl_block7Bytes, _wl_block7);

								if ( function_type.equals( "F" ) && insert_access.equals( "Y" ) ) {
							
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(common_labels.getString("Common.create.label")));
            _bw.write(_wl_block9Bytes, _wl_block9);

								}
							
            _bw.write(_wl_block10Bytes, _wl_block10);

								if ( function_type.equals( "F" ) && query_access.equals( "Y" ) ) {
							
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(common_labels.getString("Common.query.label")));
            _bw.write(_wl_block12Bytes, _wl_block12);

								}
							
            _bw.write(_wl_block10Bytes, _wl_block10);

								if ( function_type.equals( "F" ) && delete_access.equals( "Y" ) ) {
							
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(common_labels.getString("Common.delete.label")));
            _bw.write(_wl_block14Bytes, _wl_block14);

								}
							
            _bw.write(_wl_block10Bytes, _wl_block10);

								if 	( function_type.equals( "F" ) && ( insert_access.equals( "Y" ) || update_access.equals( "Y" ) ) ) {
							
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(common_labels.getString("Common.apply.label")));
            _bw.write(_wl_block16Bytes, _wl_block16);

								}
							
            _bw.write(_wl_block10Bytes, _wl_block10);

								if ( function_type.equals( "R" ) || function_type.equals( "P" ) ) {
							
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(common_labels.getString("Common.run.label")));
            _bw.write(_wl_block18Bytes, _wl_block18);

								}
							
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(common_labels.getString("Common.reset.label")));
            _bw.write(_wl_block20Bytes, _wl_block20);

								if(function_id!=null && function_id.equals("SWITCH_LANG")){
								}else{
								if(expand.equals("0") || expand.equals("")){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
if (!home_required_yn.equals("N")) {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(common_labels.getString("Common.menu.label")));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
if (!home_required_yn.equals("N")) {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(common_labels.getString("Common.hideMenu.label")));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
}
								}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
