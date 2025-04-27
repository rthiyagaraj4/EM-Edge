package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;

public final class __operativerecords extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperativeRecords.jsp", 1743149322892L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eOT/js/SurgeryHistory.js\"></Script>\n<script language=\"javascript\">\nasync function callOperativeNotes(facility_id,patient_id,episode_id,patient_class,encounter_id,slate_user_id,accession_num){\n\t//alert(\"U N D E R C O N S T R U C T I O N\");\n\t//var title=\"Nursing Notes\";\n\tvar title=getlabel(\"eOT.NursingNotes.Label\",\"OT\");;\n\t//var called_from = \"OPERATIVE_NOTES\";//6\n\tvar called_from = \"OPERATIVE_NOTES\";\n\tvar speciality_code=\"\";\n\tvar locn_type = \"\";\n\tvar params=\"facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&patient_class=\"+patient_class+\"&encounter_id=\"+encounter_id+\"&called_from=\"+called_from+\"&accession_num=\"+accession_num+\"&speciality_code=\"+speciality_code+\"&locn_type=\"+locn_type+\"qurey_flag_yn=Y&slate_user_id=\"+slate_user_id;\n\tvar url = \"../../eOT/jsp/SelectNoteTypeFrames.jsp?\"+params; \n\t//document.location.href=url;\n\t\n\tvar retVal;\n\tvar dialogHeight = \"5\";\n    var dialogWidth  = \"20\";\n    var dialogTop    = \"200\";\n    var dialogLeft   = \"200\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" + dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" ;\n\tvar arguments    = \"\" ;\n\tretVal \t   = await window.showModalDialog(url, arguments, features);\n}\n</script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'OperativeRecordsForm\' id=\'OperativeRecordsForm\'>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
//@include file="../../eCommon/jsp/Common.jsp" 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
 
	String accession_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	String patient_class = CommonBean.checkForNull(request.getParameter("patient_class"));
	String encounter_id = CommonBean.checkForNull(request.getParameter("encounter_id"));
	String episode_id = CommonBean.checkForNull(request.getParameter("episode_id"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));
out.println("<script>callOperativeNotes('"+facility_id+"','"+patient_id+"','"+episode_id+"','"+patient_class+"','"+encounter_id+"','"+slate_user_id+"','"+accession_num+"')"+"</script>");
	

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
