package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __revisevisitframeset1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ReviseVisitFrameset1.jsp", 1743070144020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n<head>\n    <meta http-equiv=\"Expires\" content=\"0\">\n   <!--  <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n    <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n    <Script src=\"../../eOP/js/CancelVisit.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eOP/js/ReviseVisit.js\" language=\"JavaScript\"></Script>\n    <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n    <script>\n\tasync function revist()\n\t{\n        var retVal  =  new String();\n        var encounter_id = \"\";\n        var queue_date   = \"\";\n\t\tvar queue_date1=\"\";\n\t\tvar patientid    =\"\";\n\t\tvar patientid1=\"\";\n\t\t\n\t\tvar QStatus=\"\";\n\t\tvar ArriveDTime=\"\";\n\t\tvar QStatus1=\"\";\n\t\tvar ArriveDTime1=\"\";\n\t\tvar VitalDTime=\"\";\n\t\tvar VitalDTime1=\"\";\n\t\tvar queue_num=\"\";\n\n        var dialogHeight = \"42vh\" ;\n        var dialogWidth  = \"70vw\" ;\n        var dialogTop    = \"0\";\n        var features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no;\"+\"dialogTop:\" + dialogTop ;\n        var arguments    = \"\";\n        retVal = await window.showModalDialog(\"../../eOP/jsp/PaintSearchVisit.jsp?p_mode=REVISEVISIT\",arguments,features);\n        \n\t\tif (retVal==\"\" || retVal == null)\n            parent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n        else\n        {\n            encounter_id    = retVal.substring(0,retVal.indexOf(\"|\"));\n\n            queue_date1  = retVal.substring(retVal.indexOf(\"|\")+1);\n\t\t\tqueue_date=queue_date1.substring(0,queue_date1.indexOf(\"|\"));\n\t\t\tpatientid1=queue_date1.substring(queue_date1.indexOf(\"|\")+1);\n            patientid=patientid1.substring(0,patientid1.indexOf(\"|\"));\n\t\t\tQStatus1=patientid1.substring(patientid1.indexOf(\"|\")+1);\n\t\t\tQStatus=QStatus1.substring(0,QStatus1.indexOf(\"|\"));\n\t\t\tArriveDTime1=QStatus1.substring(QStatus1.indexOf(\"|\")+1);\n\t\t\tArriveDTime=ArriveDTime1.substring(0,ArriveDTime1.indexOf(\"|\"));\n\t\t\tVitalDTime1=ArriveDTime1.substring(ArriveDTime1.indexOf(\"|\")+1);\n\t\t\tVitalDTime=VitalDTime1.substring(0,VitalDTime1.indexOf(\"|\"));\n\t\t\tqueue_num=VitalDTime1.substring(VitalDTime1.lastIndexOf(\"|\")+1);\n            \n\t\t\tdocument.write(\"<iframe name=\'PatientLine\' id=\'PatientLine\' src=\'../../eCommon/jsp/pline.jsp?P_MODULE_ID=OP&P_FUNCTION_ID=REVISE_VISIT&EncounterId=\"+encounter_id+\"&Facility_Id=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' frameborder=no scrolling=\'no\' noresize style=\'height:10vh;width:100vw\'></iframe>\"+\n                       \"<iframe name=\'ReviseVisitFrame2\' id=\'ReviseVisitFrame2\' src=\'../../eOP/jsp/ReviseVisitMain.jsp?encounter_id=\"+encounter_id+\"&queue_date=\"+queue_date+\"&Patient=\"+patientid+\"&QStatus=\"+QStatus+\"&ArriveDTime=\"+ArriveDTime+\"&VitalDTime=\"+VitalDTime+\"&queue_num=\"+queue_num+\"\' frameborder=no scrolling=\'no\' noresize style=\'height:90vh;width:100vw\'></iframe>\"+\n                   \"\"\n                   );\n         }\n}\t\t \n     revist();   \n    </script>\n   </head>\n   </html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);

		request.setCharacterEncoding("UTF-8");
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

      String facility_id      = (String) session.getValue("facility_id");

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facility_id));
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
