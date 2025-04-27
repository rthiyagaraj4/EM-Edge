package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesFieldItem;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesFieldResponse;
import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eOR.OrderEntryQueryBean;
import eOR.OrderEntryBean;
import java.util.ArrayList;
import java.util.List;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.clinicalnotes.dao.*;
import java.util.Locale;
import java.util.ResourceBundle;

public final class __mrecclinicalnotescannedtextlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesCannedTextList.jsp", 1709118014990L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<style>\n.vscroller5{\n\twidth: 100%;\n\theight: auto;\n\tposition: absolute;\n\tz-index: 1;\n}\n.cannedTextrow\n{\n\theight: 40px;\n\tborder-bottom: #e1e1e1 1px solid;\n\tbackground-color: #f7f7f7;\t\n}\n\n.cannedTextcode\n{\n\tfloat:left;\n\tcolor:#797b7c;\n\tfont-size: 12px;\n\tfont-family:Arial;\n\twidth: 100%;\n\tfont-weight:bold;\n\tpadding: 2px 10px;\n}\n\n.cannedTextdesc\n{\n\tfloat: left;\n\tcolor:#797b7c;\n\twhite-space: nowrap;\n\toverflow: hidden;\n\ttext-overflow: ellipsis;\n\twidth: 92%;\n\tpadding: 2px 10px;\n\tfont-family: arial;\n\tfont-size: 12px;\n}\n.cannedTextselect\n{\n\tposition: relative;\n\tright:17px;\n\tdisplay: inline-block;\n\twidth: 8px;\n\theight:17px;\n\ttop:10px;\n\tleft:12px;\n}\n.cannedTextContent\n{\n\tposition: relative;\n\twidth: 100%;\n\theight:100%;\n\toverflow: auto;\n}\n</style>\n<script>\n$(document).ready(function(){\n\tassignNoteListContentsScroll()\n\n});\n\n\n\n</script>\n\n<div style=\"display:table;width:100%;height:100%;table-layout: fixed;\">\n   <div style=\"display:table-row\">\n      <div style=\"display:table-cell;width:100%;height:98%\">\n         <div id=\"OrdItemContentsWrap\" class=\"cannedTextContent\" >\n            <div style=\"display:block\" >\n               ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n               <div class=\"cannedTextrow\"  onclick=\"selectCanText(this)\"  >\n                  <div style=\"width: 92%;\">\n                     <span  class=\"cannedTextcode\" >  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\n                     <span style=\"display:none\" id=\"CL";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" class=\"data\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span>\n                     <input type=\"hidden\" name=\"TL";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" id=\"TL";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  id=\"TL";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" value=\"\"/>\n                     <script>\n                        var temp_text=document.getElementById(\"CL";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\").innerText;\n                        if(temp_text.length>100)\n                        \ttemp_text= temp_text.substring(0, 100);\n                        \n                        document.getElementById(\"TL";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\").value=temp_text ;\n                     </script> \t\n                     <span id=\"Temp";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"  class=\"cannedTextdesc\"> ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </span>\n                     <script>\n\t\t\t\t\t\t//alert(document.getElementById(\"TL";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\").value )\n                        document.getElementById(\"Temp";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\").innerHTML=document.getElementById(\"TL";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\").value ;\n                     </script>\t\n                  </div>\n                  <div id=\"CL";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" class=\"cannedTextselect\"> \n                  </div >\n               </div>\n               ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n            </div>\n         </div>\n      </div>\n   </div>\n</div>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block3Bytes, _wl_block3);
 
String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
String service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");
String text_type = request.getParameter("text_type")==null?"":request.getParameter("text_type");
String sec_hdg_code=request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");

if(patientContext!=null){	
	ClinicalNotesBC ClinicalNotesbc = new ClinicalNotesBC();
	ClinicalNotesFieldResponse resClinicalNotes;	
	resClinicalNotes=ClinicalNotesbc.getCannedTextList(patientContext,note_type,sec_hdg_code,service_code,text_type);
	List<ClinicalNotesFieldItem> noteTypeList = resClinicalNotes.getFieldList(); 	

            _bw.write(_wl_block4Bytes, _wl_block4);
						
                  for(int i=0;i<noteTypeList.size();i++) {
                  	ClinicalNotesFieldItem fieldItem = noteTypeList.get(i);					
			String strDesc=fieldItem.getDesc();
			strDesc=strDesc.replace("<ADDRESS>","");
			strDesc=strDesc.replace("</ADDRESS>","");
                  
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(fieldItem.getCode()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(i));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strDesc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(i));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fieldItem.getDesc()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fieldItem.getCode()));
            _bw.write(_wl_block19Bytes, _wl_block19);
} 
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);
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
