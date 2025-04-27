package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import eBL.*;
import eBL.Common.*;
import eCommon.Common.*;
import org.apache.commons.codec.binary.Base64;

public final class __blchargepatientencounterframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargePatientEncounterFrame.jsp", 1738010579849L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n---------------------------------------------------------------------------------------------------------------\nSr No        Version           TFS/Incident        SCF/CRF            \t\t Developer Name\n--------------------------------------------------------------------------------------------------------\n1            V220412            30399          MMS-ME-SCF-0064-TF               Mohanapriya K\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<HTML>\n<HEAD>\n<script language=\'javascript\' src=\'../../eBL/js/BLChargeEncounterNewOrder.js\'></script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n    <title>Charge Patient</title>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\n\t<input type=\'hidden\' id=\'allFramesExisting\' name=\'allFramesExisting\'  value=\'7%,0%,0%,6%,25%,28%,28%,0%,4%\'>\n\t<input type=\'hidden\' id=\'allFramesNew\' \t\tname=\'allFramesNew\'  \t value=\'7%,0%,0%,6%,19%,30%,30%,0%,4%\'>\n\t<input type=\'hidden\' id=\'allFramesNewDtl\' \tname=\'allFramesNewDtl\' \t value=\'7%,0%,0%,6%,0%,51%,32%,0%,4%\'>\n\t<input type=\'hidden\' id=\'allFramesNewRcrd\' \tname=\'allFramesNewRcrd\'   value=\'7%,0%,0%,6%,0%,32%,52%,0%,4%\'>\n\t<input type=\'hidden\' id=\'allFramesMessage\' \tname=\'allFramesMessage\'   value=\'7%,0%,0%,6%,25%,6%,28%,23%,4%\'>\n\t<input type=\'hidden\' id=\'framesAltered\' \tname=\'framesAltered\'   value=\'no\'>\n\t<input type=\'hidden\' id=\'reqParam\' \tname=\'reqParam\' id=\'reqParam\'  value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'>\n\t<script>\n\tfunction refresh(){\n\t\tvar reqParam = BLChargePatientEncounterTabPage.document.forms[0].queryString.value;\n\t\tBLChargePatientEncounterTab.document.location.href = \'BLChargePatientEncounterTabs.jsp?selectedTab=ExistingOrder\';\n\t\tBLChargePatientEncounterTabPage.document.location.href = \"BLChargePatientEncounterExistingOrder.jsp?\"+reqParam;\n\t\tBLChargePatientExisOrderTraverse.document.location.href = \'../../eCommon/html/blank.html\';\n\t\tBLChargePatientExisOrderServDetails.document.location.href = \'../../eCommon/html/blank.html\';\n\t\tBLChargePatientExisOrderServEdit.document.location.href = \'../../eCommon/html/blank.html\';\n\t\tmessageFrame1.document.location.href = \'../../eCommon/jsp/error.jsp\';\n\t}\n\n\tfunction closeWindow(){\n\t\t//window.close();\n\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\tdialogTag.close(); \n\t}\n\t</script>\n</HEAD>\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\n\n\t\t    <iframe name=\'pline\' id=\'pline\' \tframeborder=\'0\'\tsrc=\'../../eCommon/jsp/pline.jsp?Patient_Id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&episode_type=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&episode_id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&visit_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&EncounterId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'  scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'BillingBanner\' id=\'BillingBanner\'\tsrc=\'../../eCommon/html/blank.html\'  frameborder=0  noresize style=\'height:0vh;width:100vw\'></iframe> \t\t\t\t\n\t\t\t<iframe name=\'BillingMenu\' id=\'BillingMenu\' \tframeborder=\'0\'\tsrc=\"../../eCommon/html/blank.html\"  scrolling=\'no\' noresize style=\'height:0vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'BLChargePatientEncounterTab\' id=\'BLChargePatientEncounterTab\'\t src=\'BLChargePatientEncounterTabs.jsp?selectedTab=ExistingOrder\'  frameborder=0 scrolling=\'no\' noresize style=\'height:5vh;width:100vw;margin-top: -15px;\'></iframe>\n\t\t\t<iframe name=\'BLChargePatientEncounterTabPage\' id=\'BLChargePatientEncounterTabPage\'\tsrc=\'BLChargePatientEncounterExistingOrder.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 noresize scrolling=\'no\' noresize style=\'height:22vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'BLChargePatientExisOrderTraverse\' id=\'BLChargePatientExisOrderTraverse\'\t\t\t\tsrc=\'../../eCommon/html/blank.html\'  frameborder=0  noresize style=\'height:25vh;width:100vw\'></iframe> \n\t\t\t<iframe name=\'BLChargePatientExisOrderServDetails\' id=\'BLChargePatientExisOrderServDetails\'\tsrc=\'../../eCommon/html/blank.html\'  frameborder=0 noresize style=\'height:26vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'BLChargePatientExisOrderServEdit\' id=\'BLChargePatientExisOrderServEdit\'\tsrc=\'../../eCommon/html/blank.html\'  frameborder=0 noresize style=\'height:0vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame1\' id=\'messageFrame1\'\t\tframeborder=\'0\' src=\'../../eCommon/jsp/error.jsp\'  scrolling=\'no\' noresize style=\'height:5vh;width:100vw\'></iframe>\n\t\t\t\n\t\t\t\n<!-- \t\t\t<iframe name=\'messageFrame1\' id=\'messageFrame1\'\t\tframeborder=\'0\' src=\'../../eCommon/jsp/error.jsp\'  scrolling=\'no\' noresize style=\'height:5vh;width:100vw\'></iframe>\n -->\t\t\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\n\t\t\n</HTML>\n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
 	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String FacilityId = (String)session.getAttribute("facility_id");
String call_from  = request.getParameter("call_from");
String encounter_date	= request.getParameter("encounter_date");
String patient_id	="";
String encounter_id	="";
//V220412
System.err.println("encounter_date-"+encounter_date);
System.err.println("compressed,BLChargePatientEncounterFrame.jsp-"+request.getParameter("encoded"));
if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
	patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
	encounter_id	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
}else{
	patient_id	= request.getParameter("patient_id");
	encounter_id	= request.getParameter("encounter_id");
}

System.err.println("BLChargePatientEncounterFrame.jsp-patient_id "+patient_id);
//V220412

String blng_grp_id	= request.getParameter("blng_grp_id");
String episode_id	= request.getParameter("episode_id");
String visit_id	= request.getParameter("visit_id");
String episode_type = request.getParameter("episode_type");
String payerGroup = request.getParameter("payerGroup");
String payer = request.getParameter("payer");

String userId = (String) session.getValue("login_user");
String reqParam = request.getQueryString();
call_from="IP";
//Encounter_Id="101044860001";
//patient_id=	"DU00002195";

System.out.println("BLChargePatientEncounterMainFrame.jsp1////////FacilityId/call_from/encounter_date/encounter_id/patient_id/blng_grp_id/episode_i/visit_idd"+FacilityId+"/"+call_from+"/"+encounter_date+"/"+encounter_id+"/"+patient_id+"/"+blng_grp_id+"/"+episode_id+"/"+visit_id);	


            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(reqParam));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(reqParam ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
