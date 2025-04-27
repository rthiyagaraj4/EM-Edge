package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkmultihisttoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkMultiHistToolbar.jsp", 1709116171888L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesLinkRep.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction returnDataSel()\n\t{\n\t\n\t\t//var returnValue=\'\';\n\t\tvar count=\'\';\n\t\tif(parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm!=null)\n\t\t\t{\tcount=parseInt(parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.count.value);\n\t\t//returnValue=parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.return_str.value ;\n\t\t\n\t\t//if(returnValue==\'\')\n\t\tif(count==0)\n\t\t  alert(getMessage(\"MIN_ONE_ITEM_SEL_REQ\",\"CA\"));\n\t\telse\n\t\t{\t\t\n\t\t  parent.window.returnValue =\"Y\";\n\t\t  parent.window.close();\n\t    }\n\t\t\t}\n\t}\n\tfunction winClose()\n\t{\n\t\t\n\t\tif(parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm)\n\t\t{\n\t\t\tparent.window.returnValue =\"Y\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.window.returnValue =\"N\";\n\t\t}\n\t\t\t\n\t\t/*\tvar patient_id = parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.patient_id.value;\n\t\t\tvar encounter_id = parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.encounter_id.value;\n\t\t\t\n\t\t\t\n\t\t\tvar mode =\"removeAll\";\n\t\t\tvar HTMLVal = \"<HTML><HEAD><link rel=\'StyleSheet\' href=\'../../eCommon/html/IeStyle.css\' type=\'text/css\' /></HEAD><BODY CLASS=\'MESSAGE\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'RecClinicalNotesLinkMultiHistIntermediate.jsp?patient_id=\"+patient_id+\"&encounter_id=\"+encounter_id+\"&mode=\"+mode+\"\'></form></BODY></HTML>\";\n\t\t\t//\t+\"&sec_hdg_code=\"+sec_hdg_code+\"&child_sec_hdg_code=\"+child_sec_hdg_code +\"&histdatatype=\"+histdatatype+\"&Histrectype=\"+histrectype+\"&Contrsysid=\"+contr_sys_id+\"&Contrsyseventcode=\"+contr_sys_event_code+\"&Accessionnum=\"+encodeURIComponent(accessionnum,\"UTF-8\")+\"&result_disp=\"+result_disp+\"&hist_rec_type_desc=\"+hist_rec_type_desc+\"&event_date_time=\"+event_date_time+\"&mode=\"+mode+\"\n\t\t\tparent.messageFrame.document.write(HTMLVal);\n\t\t\tparent.messageFrame.document.forms[0].submit();\n\t\t\n\t\t} */\n\t\t//parent.window.returnValue =\"Y\";\n\t\tparent.window.close();\n\n\t}\n\t\n\t</script>\n\t\n\t</head>\n\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  class=\'CONTENT\' >\n\t<center>\n\t<form name=\'RecClinicalNotesLinkMultiHistToolbarForm\' id=\'RecClinicalNotesLinkMultiHistToolbarForm\'  method=post>\n\t<p align=\'left\'>\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t<td align=\'right\'>\n\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'select\' id=\'select\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' onClick=\"returnDataSel();\" >\n\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' onClick=\'winClose();\' >\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t</p>\n\t</form>\n\t</center>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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

		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		//patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");

	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
