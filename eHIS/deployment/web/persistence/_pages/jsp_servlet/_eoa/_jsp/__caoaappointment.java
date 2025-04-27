package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __caoaappointment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/CAOAAppointment.jsp", 1720767914069L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n      \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\"NO_OPER_STN_FOR_USER\",\"Common\"));\t\n\t\t\t\t\tlocation.href=\'../../eCommon/jsp/home.jsp?called_from=CA\';\n\t\t\t\t</script>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>alert(getMessage(\'SCH_NOT_ALLOW\',\'OA\'));\n\t\t\t\t\tlocation.href=\'../../eCommon/jsp/home.jsp?called_from=CA\';\n\t\t\t\t</script>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\n\t\t\t<iframe name=\'image\' id=\'image\' src=\'../../eOA/jsp/DisplayImage.jsp?callingMode=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&from_OR=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&oper_stn_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&book_appt_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&create_wait_list_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&install_yn_val=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&rd_appt_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  scrolling=no noresize style=\"height:3vh;width:98vw;border=\'1\'\"></iframe>\n\t\t\t<iframe name=\'querying\' id=\'querying\' src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&specialty_codema=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&visit_flag_OP=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&from_facility_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&from_encounter_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&order_category=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&order_catalog_code=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'  scrolling=no style=\"height:27.6vh;width:98vw;border=\'1\'\"></iframe>\n\t\t\t<iframe name=\'dummy\' id=\'dummy\' src=\'../../eCommon/html/blank.html\'  noresize scrolling=no style=\'height:0vh;width:98vw\'></iframe>\n\t\t\t<iframe name=\'result\' id=\'result\' src=\'../../eCommon/html/blank.html\'  noresize scrolling=auto style=\"height:70vh;width:98vw;border=\'1\'\"></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/html/blank.html\'  noresize scrolling=\'auto\' style=\"height:0vh;width:98vw;border=\'1\'\"></iframe>\n\t\t\n\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<!--\t<frameset id=appt_page rows=\'3%,27%,0%,*,0\' border=\'1\'>\n\t\t\t\t\t\t<frame name=\'image\' src=\'../../eOA/jsp/DisplayImage.jsp?callingMode=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' frameborder=no scrolling=no noresize>\n\t\t\t\t\t\t<frame name=\'querying\'src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&locn_code=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&locnDesc=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&resourceId=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&resourceDesc=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'frameborder=no scrolling=no noresize>\n\t\t\t\t\t\t<frame name=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=no>\n\t\t\t\t\t\t<frame name=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=auto>\n\t\t\t\t\t\t<frame name=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\'>\n\t\t\t\t\t</frameset> -->\n\t\t\t\t\t\t<iframe name=\'image\' id=\'image\' src=\'../../eOA/jsp/DisplayImage.jsp?callingMode=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' frameborder=no scrolling=no noresize style=\"height:3vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t<iframe name=\'querying\' id=\'querying\' src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'frameborder=no scrolling=no noresize style=\"height:30vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t<iframe name=\'dummy\' id=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=no style=\"height:0vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t<iframe name=\'result\' id=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=auto style=\"height:70vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=\'0\' noresize scrolling=\'auto\' style=\"height:0vh;width:98vw;border:\'1\'\"></iframe>\n\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<!-- <frameset id=appt_page rows=\'3%,27%,0%,*,0\' border=\'1\'>\n\t\t\t\t\t\t\t<frame name=\'image\' src=\'../../eOA/jsp/DisplayImage.jsp?callingMode=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' frameborder=no scrolling=no noresize>\n\t\t\t\t\t\t\t<frame name=\'querying\' src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' frameborder=no scrolling=no noresize>\n\t\t\t\t\t\t\t<frame name=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=no>\n\t\t\t\t\t\t\t<frame name=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=auto>\n\t\t\t\t\t\t\t<frame name=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\'>\n\t\t\t\t\t\t</frameset> -->\n\t\t\t\t\t\t\t<iframe name=\'image\' id=\'image\' src=\'../../eOA/jsp/DisplayImage.jsp?callingMode=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' frameborder=no scrolling=no noresize style=\"height:3vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t<iframe name=\'querying\' id=\'querying\' src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' frameborder=no scrolling=no noresize style=\"height:27.4vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t<iframe name=\'dummy\' id=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=no style=\"height:0vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t<iframe name=\'result\' id=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=auto style=\"height:70vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=\'0\' noresize scrolling=\'auto\' style=\"height:0vh;width:98vw;border:\'1\'\"></iframe>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' frameborder=no scrolling=no noresize>\n\t\t\t\t\t\t\t<frame name=\'querying\'src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' frameborder=no scrolling=no noresize style=\"height:3vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t<iframe name=\'querying\' id=\'querying\'src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' frameborder=no scrolling=no noresize style=\"height:29vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t<iframe name=\'dummy\' id=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=no style=\"height:0vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t<iframe name=\'result\' id=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=auto style=\"height:64vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\"height:0vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<!-- <frameset rows=\'*,8%,0\' frameborder=0>\n\t\t\t\t\t\t\t<frameset cols=\'32.5%,*\'>\n\t\t\t\t\t\t\t\t<frame name=\'apptdairy\' src=\'../../eOA/jsp/CAOAApptDairy.jsp?";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' noresize frameborder=0 x-scroll=\'YES\'>\n\t\t\t\t\t\t\t\t<frame name=\'dummy\' src=\'../../eCommon/html/blank.html\' noresize frameborder=0 scrolling=\'yes\'>\n\t\t\t\t\t\t\t</frameset>\n\t\t\t\t\t\t\t<frame name=\'DispOAResultCB\' src=\'../../eOA/jsp/CheckBoxDisplay.jsp\' noresize frameborder=\'0\' scrolling=\'no\'>\n\t\t\t\t\t\t\t<frame name=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\'>\t\t\t\t\t\t\t\n\t\t\t\t\t\t</frameset> -->\n\t\t\t\t\t\t\t\t<iframe name=\'apptdairy\' id=\'apptdairy\' src=\'../../eOA/jsp/CAOAApptDairy.jsp?";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' noresize frameborder=0 x-scroll=\'YES\' style=\"height:100vh;width:32.5vw\"></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'dummy\' id=\'dummy\' src=\'../../eCommon/html/blank.html\' noresize frameborder=0 scrolling=\'yes\' style=\"height:100vh;width:67.5vw\"></iframe>\t\t<iframe name=\'DispOAResultCB\' id=\'DispOAResultCB\' src=\'../../eOA/jsp/CheckBoxDisplay.jsp\' noresize frameborder=\'0\' scrolling=\'no\' style=\"height:8vh;width:98vw\"></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\"height:0vh;width:98vw\"></iframe>\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t<!-- <frameset id=appt_page rows=\'3%,27%,0%,*,0\' border=\'1\'>\n\t\t\t\t\t\t\t\t<frame name=\'image\' src=\'../../eOA/jsp/DisplayImage.jsp?CA=Y&callingMode=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' frameborder=no scrolling=no noresize>\n\t\t\t\t\t\t\t\t<frame name=\'querying\'src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&CA=Y&specialty_codema=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' frameborder=no scrolling=no noresize>\n\t\t\t\t\t\t\t\t<frame name=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=no>\n\t\t\t\t\t\t\t\t<frame name=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=auto>\n\t\t\t\t\t\t\t\t<frame name=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\'>\n\t\t\t\t\t\t\t</frameset> -->\n\t\t\t\t\t\t\t\t<iframe name=\'image\' id=\'image\' src=\'../../eOA/jsp/DisplayImage.jsp?CA=Y&callingMode=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' frameborder=no scrolling=no noresize style=\"height:3vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'querying\' id=\'querying\' src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' frameborder=no scrolling=no noresize style=\"height:31vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'dummy\' id=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=no style=\"height:0vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'result\' id=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=auto style=\"height:60vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=\'0\' noresize scrolling=\'auto\' style=\"height:0vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t<!-- <frameset id=appt_page rows=\'3%,27%,0%,*,0\' border=\'1\'> -->\n\t\t\t\t\t<iframe name=\'image\' id=\'image\' src=\'../../eOA/jsp/DisplayImage.jsp?callingMode=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' frameborder=no scrolling=no noresize style=\"height:3vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t<iframe name=\'querying\' id=\'querying\' src=\'../../eOA/jsp/ScheduleAppointment.jsp?";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' frameborder=no scrolling=no noresize style=\"height:31vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t<iframe name=\'dummy\' id=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=no style=\"height:0vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t<iframe name=\'result\' id=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=no noresize scrolling=auto style=\"height:60vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\"height:0vh;width:98vw;border:\'1\'\"></iframe>\n\t\t\t\t<!-- </frameset> -->\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n</head>\n</html>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		boolean allow_inside=true;
		String facilityid=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
		String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user"));

		String s=request.getQueryString();
		String from_wait_list=request.getParameter("from_wait_list");

		String order_id=request.getParameter("order_id");
		if(order_id==null) order_id="";
		String order_line_num=request.getParameter("order_line_num");
		if(order_line_num==null) order_line_num="";
		//String web_request_yn=request.getParameter("web_request_yn")==null?"N":request.getParameter("web_request_yn");
		//String patientId1=request.getParameter("patientId1")==null?"":request.getParameter("patientId1");
		String order_catalog_code=request.getParameter("order_catalog_code");
		if(order_catalog_code==null) order_catalog_code="";
		String specialty_code1= request.getParameter("specialty_code");
		if(from_wait_list==null) from_wait_list="";
		String callingMode=request.getParameter("callingMode");

		if(callingMode==null || callingMode.equals("null") )
		callingMode="";
		String from_OR=request.getParameter("from_OR");
		if(from_OR ==null) from_OR="N";
		String visit_flag_OP=request.getParameter("visit_flag_OP");
		//String option_id=request.getParameter("option_id")==null?"":request.getParameter("option_id");
		if(visit_flag_OP==null) visit_flag_OP="N";	
		String loc_type_OP= request.getParameter("loc_type");

		//Added by S.Sathish for IN021901 on Friday, June 11, 2010 starts here
		String resourceId=request.getParameter("i_practitioner_id")==null?"":request.getParameter("i_practitioner_id");
		String resourceDesc=request.getParameter("resourceDesc")==null?"":request.getParameter("resourceDesc");
		String clinicDesc=request.getParameter("clinicDesc")==null?"":request.getParameter("clinicDesc");
		String clinic_code_new=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
		String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
		String order_category=request.getParameter("order_category")==null?"":request.getParameter("order_category");
		//Ends here		
		if(order_category.equals(""))order_category="";
		String oper_stn_id="";
		String book_appt_yn="";
		String create_wait_list_yn="";
		String install_yn_val="";
		String open_to_all_pract_yn="";
		//String order_category="";
		

		if(loc_type_OP ==null) loc_type_OP="";
		try{
			con = ConnectionManager.getConnection(request);
			stmt=con.createStatement();
			//Query modified by S.Sathish for IN021901 on Friday, June 11, 2010 
			//String sql2="SELECT (   select Operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR') or_oper_yn,nvl(CREATE_WAIT_LIST_YN,'N') creat_wt_lst_yn,a.oper_stn_id, nvl(canc_appt_yn,'N') canc_appt_yn, nvl(tfr_appt_yn,'N') tfr_appt_yn, nvl(book_appt_yn,'N') book_appt_yn, to_char(sysdate,'dd/mm/yyyy') dt, (select OPEN_TO_ALL_PRACT_YN from op_clinic WHERE facility_id='"+facilityid+"' and clinic_code='"+clinic_code_new+"') open_to_all_pract_yn FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"'	AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			String sql2="SELECT (   select Operational_yn from sm_modules_facility where facility_id = ? and module_id = 'OR') or_oper_yn,nvl(CREATE_WAIT_LIST_YN,'N') creat_wt_lst_yn,a.oper_stn_id, nvl(canc_appt_yn,'N') canc_appt_yn, nvl(tfr_appt_yn,'N') tfr_appt_yn, nvl(book_appt_yn,'N') book_appt_yn, to_char(sysdate,'dd/mm/yyyy') dt, (select OPEN_TO_ALL_PRACT_YN from op_clinic WHERE facility_id=? and clinic_code=?) open_to_all_pract_yn FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			if (rs!=null) rs.close();				
			//rs=stmt.executeQuery(sql2);
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,facilityid);
			pstmt.setString(3,clinic_code_new);
			pstmt.setString(4,facilityid);
			pstmt.setString(5,globaluser);
			rs = pstmt.executeQuery();
			if (rs!=null && rs.next()){
				oper_stn_id=rs.getString("oper_stn_id");
				book_appt_yn=rs.getString("book_appt_yn");
				create_wait_list_yn=rs.getString("creat_wt_lst_yn");
				install_yn_val=rs.getString("or_oper_yn");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"Y":rs.getString("open_to_all_pract_yn");
				

			}
			if(oper_stn_id.equals("")){
				allow_inside=false;
				
            _bw.write(_wl_block8Bytes, _wl_block8);

			}else if(book_appt_yn.equals("N")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}

//OPCheckout
		String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";
		//session.setAttribute("calledFromSchAppt","N");

	if(allow_inside){
	if(from_wait_list.equals("Y"))
	{
	/*Row size changed(52% to 27%) by Dharma on 11th Jan 2016 against ML-MMOH-SCF-0300 [IN:057970]*/
		
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(s));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialty_code1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block24Bytes, _wl_block24);


	}else{
			

			int no_record=0;
			String ref_id="N";
			String from_CA=request.getParameter("CA");
			

			if(from_CA==null || from_CA.equals("") || from_CA.equals("null") )
				from_CA="N";

			ref_id=request.getParameter("referral_id");
			if(ref_id==null || ref_id.equals("") || ref_id.equals("null") )
					ref_id="N"; 

			session.putValue("ref_id",ref_id);
			session.putValue("CallMode",callingMode);
			
			session.putValue("Pat_id","N");
			String practitioner_id = request.getParameter("practitioner_id");
			if (practitioner_id==null || practitioner_id.equals("") || practitioner_id.equals("null")) 	practitioner_id="";

			String clinic_code=request.getParameter("clinic_code");
			String recall_date=request.getParameter("recall_date");
			if (recall_date==null ) recall_date="";
			
			if(recall_date.length()==9) 
				recall_date="0"+recall_date;

			if(recall_date.length()>10) 
				recall_date=recall_date.substring(0,10);



			String direct_ip=request.getParameter("DirectIP");
			if(direct_ip==null) direct_ip="N";

		try
		{
				
			if(direct_ip.equals("N"))
			{

				if(! ref_id.equals("N"))
				{  // Referral 
					clinic_code_new=open_to_all_pract_yn+"$"+clinic_code_new;	

				
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(s));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialty_code1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(clinic_code_new));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(clinicDesc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(resourceId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(resourceDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(s));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialty_code1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(clinic_code_new));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(clinicDesc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(resourceId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(resourceDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{ // Recall or CA
				if(from_CA.equals("N") ){ // RECALL

					String pat_id=request.getParameter("patient_id");
						session.putValue("Pat_id",pat_id);
					if(practitioner_id.equals(""))
					{ // No pract ID
						if(!callingMode.equals("OR") && !callingMode.equals("MR"))
						{
							int i=s.indexOf("specialty_code");
							s=s.substring(0,i)+"cc"+s.substring(i);
						//	String speciality_code="select speciality_code from op_clinic where facility_id ='"+facilityid+"' and CLINIC_CODE='"+clinic_code+"'";
							String speciality_code="select speciality_code from op_clinic where facility_id =? and CLINIC_CODE=? ";

							//rs = stmt.executeQuery(speciality_code);
							pstmt = con.prepareStatement(speciality_code);
							pstmt.setString(1,facilityid);
							pstmt.setString(2,clinic_code);
							rs = pstmt.executeQuery();
							if(rs !=null)
							{
								while ( rs.next() )
								{
									speciality_code=rs.getString(1);	
								}
							}
								s=s+"&specialty_code="+ speciality_code;
						}
						if(rs !=null) rs.close();	

						
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(s));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialty_code1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(s));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialty_code1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{ // WITH pRACT id

//add this condition for speciality code in OP with pract Id

	  		if(callingMode.equals("OP"))
						{
							int i=s.indexOf("specialty_code");
							s=s.substring(0,i)+"cc"+s.substring(i);
							//String speciality_code="select speciality_code from op_clinic where facility_id ='"+facilityid+"' and CLINIC_CODE='"+clinic_code+"'";
							String speciality_code="select speciality_code from op_clinic where facility_id =? and CLINIC_CODE=?";

							//rs = stmt.executeQuery(speciality_code);
							pstmt = con.prepareStatement(speciality_code);
							pstmt.setString(1,facilityid);
							pstmt.setString(2,clinic_code);
							rs = pstmt.executeQuery();
							if(rs !=null)
							{
								while ( rs.next() )
								{
									speciality_code=rs.getString(1);	
								}
							}
								s=s+"&specialty_code="+ speciality_code;
						}


						
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(s));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialty_code1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(s));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialty_code1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block41Bytes, _wl_block41);

					}
					
				}else{  // From CA	
				
					practitioner_id =(String)session.getValue("ca_practitioner_id");
					String pract_str="select Count(*) from oa_clinic_schedule where facility_id ='"+facilityid+"' and PRACTITIONER_ID = '"+practitioner_id+"' and trunc(CLINIC_DATE) >= trunc(sysdate) and PRIMARY_RESOURCE_YN='Y'";
					rs = stmt.executeQuery(pract_str);
					if(rs !=null)
					{
						while ( rs.next() )
						{
							no_record=rs.getInt(1);	
						}
					}
						if(rs !=null) rs.close();
						if(callingMode.equals("OP_RV"))
					{
							no_record=0;
					}

					if(no_record!=0)
					{ // Schedule Aval. Show Diary

						 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(s));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(s));
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{ // show OA Book Appt

						session.putValue("qStr",s);
						
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(s));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(specialty_code1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(s));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(specialty_code1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block50Bytes, _wl_block50);

					}

					
				}// End CA
				

			}
		}else{ // Direct from IP 
		
			String pat_id=request.getParameter("patient_id");
			session.putValue("Pat_id",pat_id);

			
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(s));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialty_code1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block53Bytes, _wl_block53);

		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		
	}catch(Exception es){
		//out.println("Exception :"+es);
		es.printStackTrace();
	}

}
}
}catch(Exception e){
	e.printStackTrace();  
}finally{
		
		ConnectionManager.returnConnection(con,request);		 
	}

            _bw.write(_wl_block54Bytes, _wl_block54);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bookappointment.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
