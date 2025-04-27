package jsp_servlet._eipad._jsp._chartwidgets._pharmacy;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.OrderEntryBean;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ehis.persist.PersistenceHelper;
import ePH.IVPrescriptionBean;

public final class __ticksheetsection extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/pharmacy/TickSheetSection.jsp", 1709293412753L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<div id=\"subsectionScroller\" class=\"ticksheeDrugHeaderRowStyle\" style=\"width:100%;height:8vhpx;overflow:hidden;position:relative;\">\n\t<div  style=\"width:auto;height:100%;position:absolute;overflow:hidden;\">\n\t\t<ul style=\"white-space: nowrap;margin:0;padding-left:0px;padding-top:10px;\">\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<li id=\"tickSheet";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" class=\"ticksheetHeaderStyle\" data-code=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" onclick=\"ticksheetDrugTabSelection(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'tickSheet";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');\">\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</li>\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</ul>\n\t</div>\n</div>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t <input type=\"hidden\" name=\"NoRecordsSections\" id=\"NoRecordsSections\" id=\"NoRecordsSections\" value=\"NO\" />\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" />\n<script>\n$(document).ready(function() \n{\n\tsetTimeout(function() {\n       assignsubsectionScroll();\n    }, 200);\n\tif($(\'#tickSheet0\').data(\"code\")!=undefined)\n\t{\t\n\tticksheetDrugTabSelection($(\'#tickSheet0\').data(\"code\"));\n\t$(\"#tickSheet0\").addClass(\"ticksheetIsActive\");\t\t\n\t}\t\n\t\n});\n\nvar subsectScroll;\nfunction assignsubsectionScroll() {\n\t subsectScroll = new IScroll(\'#subsectionScroller\', { \n\t\tscrollX: true, \n\t\tscrollY: false, \n\t\tinteractiveScrollbars: true,\n\t\tclick: true,\n\t\tuseTransition: false,\n\t\thideScrollbar:true,\n\t\tscrollbars: true,\n\t\tbindToWrapper: true,\n\t\tfadeScrollbars :true\t\t\n\t});\n\t \n\tsubsectScroll.on(\'scrollStart\', function() {\n\t\t    var ifCartOpened = $(\"#cartOpened\").val();\n\t\t        if(ifCartOpened == \"Y\"){\n\t\t\t        $(\"#cartOpened\").val(\"N\");\n\t                $(\"#cartView\").hide();\n\t                $(\"#cartWrapper\").show();\n\t                $(\"#cart\").show();\n\t\t        }\n\t    \n    });\n\tsubsectScroll.on(\'scrollEnd\', function() {}); \n\t\n\tif (subsectScroll != null) {\n        subsectScroll.refresh();\n    }\n}\n</script>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
 
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String patient_id = patientContext.getPatientId();
String encounter_id	= patientContext.getEncounterId();
String patient_class = patientContext.getPatientClass();
String or_bean_name				= "eOR.OrderEntryBean";
String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
String tick_sheet_id = request.getParameter("tick_sheet_id");
ArrayList SectionDisplay = orbean.getSectionPopulate("PH",tick_sheet_id,"");
String[] record	 = null;
if(SectionDisplay !=null && SectionDisplay.size()>0){

            _bw.write(_wl_block3Bytes, _wl_block3);
 for(int j=0; j<SectionDisplay.size(); j++)
		{
			record = (String[])SectionDisplay.get(j);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(j));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( record[0]));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(j));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block9Bytes, _wl_block9);
 record = null;
		}
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
