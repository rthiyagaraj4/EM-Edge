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

public final class __displaytabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/DisplayTabs.jsp", 1720434692254L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<Script src=\"../../eOA/js/Validate.js\" language=\"JavaScript\"></Script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n  <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>\t\t\n\n\tfunction tab_click2(id){\n\t\t\tselectTab(id);\n\t\t\ttab_click(id);\n\t}\n\tfunction tab_click(objName){\n\t\tif (objName == \'order_tab\' ){\n\t\t\tvar install_yn_val=document.forms[0].install_yn_val.value;\n\t\t\tvar url=\"../../eOA/jsp/DisplayPendingSchedule.jsp?install_yn_val=\"+install_yn_val;\n\t\t\tparent.parent.frames[1].location.href=url;\n\t\t}else if (objName == \'additional_tab\' || objName == \'additional_tab1\'){\n\t\t\tparent.patsearch.document.getElementById(\"pat_search\").rows=\"20,190,20,*\";\n\t\t\tmoveToTab(2);\n\t\t}else if(objName == \'pending_tab\'){\n\t\t//modified by N Munisekhar for[IN:048929] \n\t\t var callingMode = document.forms[0].callingMode.value;\n\t\t\tvar install_yn_val=document.forms[0].install_yn_val.value;\n\t\t\tvar url=\'../../eOA/jsp/DisplayPendingReferral.jsp?install_yn_val=\'+install_yn_val+\'&callingMode=\'+callingMode;\n\t\t    //var url=\'../../eOA/jsp/DisplayPendingReferral.jsp?install_yn_val=\'+install_yn_val;\n\t\t\t//parent.parent.frames[1].location.href=url;\n\t\t\tif (callingMode==\"MR\"   || callingMode==\"OP_RV\"){\n\t\t\tparent.parent.document.getElementById(\"dis_page\").rows=\'*\';\n\t\t\tparent.parent.frames[0].location.href=url;\n\t\t\t//parent.parent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t     }else{\n\t\t\tparent.parent.frames[1].location.href=url;\n\t\t      }\n\t\t}else if(objName == \'schedule_tab\' || objName == \'schedule_tab\'){\n\t\t\tvar callingMode = document.forms[0].callingMode.value;\n\t\t\tvar cmd=document.forms[0].caMod.value;\n\t\t\tvar qStr=document.forms[0].qStr.value;\n\t\t\tvar from_wait_list=document.forms[0].from_wait_list.value;\n\t\t\tvar speciality=document.forms[0].speciality.value;\n\t\t\tvar practitioner_old=document.forms[0].practitioner_old.value;\n\t\t\tvar clinic_old=document.forms[0].clinic_old.value;\n\t\t\tvar practitioner_type=document.forms[0].practitioner_type.value;\n\t\t\tvar or_catalogue_code=document.forms[0].or_catalogue_code.value;\n\t\t\tvar pref_start_date=document.forms[0].pref_start_date.value;\n\t\t\tvar pref_end_date=document.forms[0].pref_end_date.value;\n\t\t\tvar care_locn_ind=document.forms[0].care_locn_ind.value;\n\t\t\tvar no_dwm=document.forms[0].no_dwm.value;\n\t\t\tvar visittype=document.forms[0].visittype.value;\n\t\t\tvar dwm_desc=document.forms[0].dwm_desc.value;\n\t\t\tvar order_catalog_code=document.forms[0].order_catalog_code.value;\n\t\t\tvar order_id=document.forms[0].order_id.value;\n\t\t\tvar calledFrom=document.forms[0].calledFrom.value;\n\t\t\tvar from_OR=document.forms[0].from_OR.value;\n\t\t\tvar ca_patient_id=document.forms[0].ca_patient_id.value;\t\t\t\n\t\t\tvar position=document.forms[0].position.value;\t\t\t\n\t\t\tvar addtl_splty=document.forms[0].addtl_splty.value;\t\t\t\n\t\t\tvar rd_appt_yn=document.forms[0].rd_appt_yn.value;\t\t\n\t\t\tvar install_yn_val=document.forms[0].install_yn_val.value;//@UAT-3\t\t\t\n\t\t\tif (callingMode==\"\" || callingMode==\"CA\"  ){\n\t\t\t\tif(cmd==\'Y\'){\n\t\t\t\t\tvar qStr1=\'CA=Y&module_id=OA&loc_type=\'+care_locn_ind+\'&specialty_code=\'+speciality+\'&practitioner_id=\'+practitioner_old+\'&clinic_code=\'+clinic_old+\'&resource_class=\'+practitioner_type+\'&or_catalogue_code=\'+or_catalogue_code+\'&recall_date=\'+pref_start_date+\'&quer_date_end=\'+pref_end_date+\'&callingMode=\'+callingMode+\'&no_dwm=\'+no_dwm+\'&visittype=\'+visittype+\'&dwm_desc=\'+dwm_desc+\'&qStr=\'+qStr+\'&position=\'+position+\'&addtl_splty=\'+addtl_splty+\"&rd_appt_yn=\"+rd_appt_yn;\n\t\t\t\t\tparent.location.href=\'../../eOA/jsp/CAOAAppointment.jsp?\'+qStr1;\n\t\t\t\t}else{\n\t\t\t\t\tvar url=\'../../eOA/jsp/Appointment.jsp?CA=N&module_id=OA&care_locn_ind=\'+care_locn_ind+\'&specialty_code=\'+speciality+\'&practitioner_id=\'+practitioner_old+\'&clinic_code=\'+clinic_old+\'&resource_class=\'+practitioner_type+\'&or_catalogue_code=\'+or_catalogue_code+\'&recall_date=\'+pref_start_date+\'&quer_date_end=\'+pref_end_date+\'&callingMode=\'+callingMode+\"&no_dwm=\"+no_dwm+\"&visittype=\"+visittype+\"&dwm_desc=\"+dwm_desc+\"&position=\"+position+\"&addtl_splty=\"+addtl_splty+\"&install_yn_val=\"+install_yn_val+\"&rd_appt_yn=\"+rd_appt_yn;//+\"&install_yn_val=\"+install_yn_val added  @UAT-3\n\t\t\t\t\tparent.location.href=url;\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\t\tvar qrs=\'CA=N&module_id=OA&care_locn_ind=\'+care_locn_ind+\'&specialty_code=\'+speciality+\'&practitioner_id=\'+practitioner_old+\'&clinic_code=\'+clinic_old+\'&resource_class=\'+practitioner_type+\'&or_catalogue_code=\'+or_catalogue_code+\'&recall_date=\'+pref_start_date+\'&quer_date_end=\'+pref_end_date+\'&callingMode=\'+callingMode+\'&no_dwm=\'+no_dwm+\'&visittype=\'+visittype+\'&dwm_desc=\'+dwm_desc+\"&order_catalog_code=\"+order_catalog_code+\"&order_id=\"+order_id+\"&specialty_codema=\"+speciality+\"&calledFrom=\"+calledFrom+\"&from_OR=\"+from_OR+\"&patient_id=\"+ca_patient_id+\"&position=\"+position+\"&addtl_splty=\"+addtl_splty+\"&install_yn_val=\"+install_yn_val+\"&rd_appt_yn=\"+rd_appt_yn;//+\"&install_yn_val=\"+install_yn_val added  @UAT-3\n\t\t\t\t\tif(callingMode == \"OR\" && calledFrom == \"OR\"){ //Added by Sathish.S for IN020026 onMonday, March 22, 2010\n\t\t\t\t\t\tparent.location.href=\'../../eOA/jsp/Appointment.jsp?\'+qrs;\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\tparent.window.returnValue=\"1\"+\"^\"+qrs;\n\t\t\t\t\tparent.window.close();\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n</script>\n<html>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<Script src=\"../../eOA/js/ChangeDate.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t<form name=image>\n\t\t<a name=\'demo\'></a>\n\t\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t\t<li class=\"tablistitem\" title=\"Schedules\">\n\t\t\t\t\t<a onclick=\"tab_click2(\'schedule_tab\')\" class=\"tabA\" id=\'schedule_tab\' >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"schedule_tabspan\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\"Day Schedule\">\n\t\t\t\t\t<a onclick=\"tab_click2(\'day_tab\')\" class=\"tabClicked\" id=\'day_tab\' >\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"day_tabspan\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<li class=\"tablistitem\" title=\"Pending Referral\">\n\t\t\t\t\t<a onclick=\"tab_click2(\'pending_tab\')\" class=\"tabA\" id=\'pending_tab\' >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"pending_tabspan\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<li class=\"tablistitem\" title=\"Pending Order\">\n\t\t\t\t\t<a onclick=\"tab_click2(\'order_tab\')\" class=\"tabA\" id=\'order_tab\' >\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"order_tabspan\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t\t\t\t</a>\n\t\t\t\t</li>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\n\t\t</ul>\n        <br>\n\t\t\t<input type=\"hidden\" name=\"caMod\" id=\"caMod\" value =\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<input type=\"hidden\" name=\"qStr\" id=\"qStr\" value =\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t<input type=\"hidden\" name=\"from_wait_list\" id=\"from_wait_list\" value =\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t<input type=\"hidden\" name=\"callingMode\" id=\"callingMode\" value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ct_tab_name\' id=\'ct_tab_name\'>\n\t\t\t<input type=\'hidden\' name=\'install_yn_val\' id=\'install_yn_val\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<input type=\'hidden\' name=\'from_OR\' id=\'from_OR\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t<input type=\'hidden\' name=\'speciality\' id=\'speciality\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t<input type=\'hidden\' name=\'clinic_old\' id=\'clinic_old\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t<input type=\'hidden\' name=\'practitioner_old\' id=\'practitioner_old\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t<input type=\'hidden\' name=\'practitioner_type\' id=\'practitioner_type\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t<input type=\'hidden\' name=\'or_catalogue_code\' id=\'or_catalogue_code\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<input type=\'hidden\' name=\'pref_start_date\' id=\'pref_start_date\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t<input type=\'hidden\' name=\'pref_end_date\' id=\'pref_end_date\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t<input type=\'hidden\' name=\'care_locn_ind\' id=\'care_locn_ind\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t<input type=\'hidden\' name=\'no_dwm\' id=\'no_dwm\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t<input type=\'hidden\' name=\'visittype\' id=\'visittype\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t<input type=\'hidden\' name=\'dwm_desc\' id=\'dwm_desc\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<input type=\'hidden\' name=\'calledFrom\' id=\'calledFrom\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t<input type=\"hidden\" name=\'position\' id=\'position\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t<input type=\"hidden\" name=\'addtl_splty\' id=\'addtl_splty\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\"hidden\" name=\'rd_appt_yn\' id=\'rd_appt_yn\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t</body>\n\t</form>\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	Statement stmt=null;
	ResultSet rs=null;	
	request.setCharacterEncoding("UTF-8");	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");		
	String callingMode=request.getParameter("callingMode");
	if (callingMode==null) callingMode = "";
	String facilityid=(String)session.getValue("facility_id");
	String install_yn_val="";
	String frmCa=(String) session.getValue("ca_mode");
	if (frmCa==null) frmCa = "";
	String from_OR=request.getParameter("from_OR");
	if(from_OR ==null) from_OR="N";

	String speciality=request.getParameter("speciality");
	if(speciality ==null) speciality="";
	String clinic_old=request.getParameter("clinic_old");
	if(clinic_old ==null) clinic_old="";
	String practitioner_old=request.getParameter("practitioner_old");
	if(practitioner_old ==null) practitioner_old="";
	String practitioner_type=request.getParameter("practitioner_type");
	if(practitioner_type ==null) practitioner_type="";
	String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
	String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");//for pending orders
	String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
	String pref_start_date=request.getParameter("pref_start_date");
	if(pref_start_date ==null) pref_start_date="";
	String pref_end_date=request.getParameter("pref_end_date");
	if(pref_end_date ==null) pref_end_date="";
	String care_locn_ind=request.getParameter("clinic_type");
	if(care_locn_ind ==null) care_locn_ind="";
	String no_dwm=request.getParameter("no_dwm");
	if(no_dwm ==null) no_dwm="";
	String visittype=(String)request.getParameter("visittype");
	if(visittype == null || visittype.equals("null")) visittype ="";
	String dwm_desc=request.getParameter("dwm_desc");
	if(dwm_desc ==null) dwm_desc="";
	String calledFrom=request.getParameter("calledFrom");
	if(calledFrom ==null) calledFrom="";
	
	String ca_patient_id=request.getParameter("ca_patient_id");
	if(ca_patient_id ==null) ca_patient_id="";

 	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"":request.getParameter("rd_appt_yn");

	
	try{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		String sql="select Operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR' ";
		rs=stmt.executeQuery(sql);
		if(rs !=null ){
			while (rs.next()){
				install_yn_val=rs.getString("Operational_yn");
			}
		}	


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(callingMode.equals("")|| callingMode.equals("OP_RV")|| callingMode.equals("MR")) {
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if ((from_OR.equals("Y") || callingMode.equals("")) && install_yn_val.equals("Y")) {
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(frmCa));
            _bw.write(_wl_block19Bytes, _wl_block19);
String qStr=(String) session.getValue("qStr");
			String from_wait_list=(String) session.getValue("from_wait_list");
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(qStr));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_wait_list));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(clinic_old));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(practitioner_old));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pref_start_date));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(pref_end_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(care_locn_ind));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(no_dwm));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(visittype));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dwm_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(position));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(addtl_splty));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);

	if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
}
catch(Exception es)
{
	//out.println("Exception :"+es);
es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
	
            _bw.write(_wl_block45Bytes, _wl_block45);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Pendingreferral.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.PendingOrderSchedule.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
