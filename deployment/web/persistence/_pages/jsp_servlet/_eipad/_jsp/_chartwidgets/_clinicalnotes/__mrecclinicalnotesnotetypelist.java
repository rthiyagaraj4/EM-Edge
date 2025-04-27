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
import java.util.Locale;
import java.util.ResourceBundle;

public final class __mrecclinicalnotesnotetypelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesNoteTypeList.jsp", 1709118015084L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<style>\n.vscroller5{\n\twidth: 100%;\n\theight: auto;\n\tposition: absolute;\n\tz-index: 1;\n}\n\n</style>\n<script>\n$(document).ready(function(){\n\tassignNoteListContentsScroll()\n});\n\nvar ordItemContentsScroll;\n\nfunction assignNoteListContentsScroll () {\n\tordItemContentsScroll = new IScroll(\'#OrdItemContentsWrap\', { \n\t\tscrollX: false, \n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true,\n\t\tclick: true\n\t\t/* interactiveScrollbars: true,\n\t\tshrinkScrollbars: \'scale\',*/\n\t\t/* fadeScrollbars: true  */\n\t});\n}\nfunction clearTemplateFilterTxt(){\n\t$(\"#NoteTypeFilterTxt\").val(\"\");\n\t$(\"#NoteFilterTxtClearButton\").addClass(\"cstFieldDull\");\n\tfilterNoteTypes();\n\t\n}\nfunction filterNoteTypes(){\n\t$(\"#norecordsMatch\").hide();\n\tvar filterTxt = $(\"#NoteTypeFilterTxt\").val();\n\tvar hasTemplate = false;\n\tfilterTxt = filterTxt.toLowerCase();\n\t$(\".NoteTypeBlock .NoteTypeBlock-desc\").each(function(){\n\t\tvar thisNoteDesc = $(this).data(\"text\");\n\t\t$(this).html(thisNoteDesc); //reset text if already bolded\n\t});\n\t$(\".NoteTypeBlock .NoteTypeBlock-spec\").each(function(){\n\t\tvar thisNoteSpec = $(this).data(\"text\");\n\t\t$(this).html(thisNoteSpec); //reset text if already bolded\n\t});\n\tif(filterTxt.length<1){\n\t\t\n\t\t$(\'#NoteFilterTxtClearButton\').attr(\'src\', path+\'/eIPAD/images/SearchGray16x16.png\');\n\t\t$(\".NoteTypeBlock\").each(function(){\n\t\t\t//var thisNoteDesc = $(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-desc\").data(\"text\");\n\t\t\t//$(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-desc\").html(thisNoteDesc); //reset text if already bolded\n\t\t\t//var thisNoteSpec = $(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-spec\").data(\"text\");\n\t\t\t//$(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-spec\").html(thisNoteSpec); //reset text if already bolded\n\t\t\t$(this).show();\n\t\t});\n\t\t\n\t}else{\n\t\t $(\'#NoteFilterTxtClearButton\').attr(\'src\', path+\'/eIPAD/images/Close-small.png\');\n\t\t $(\"#removeSearchClass\").removeClass(\"dvSerarchIcon\").addClass(\"slSfsTextBoxCloseButton\");\n\t\t $(\"#removeSearchClass\").css(\"padding-left\",\"10px\");\n\t\t$(\".NoteTypeBlock\").each(function(){\n\t\t\t\n\t\t\tvar thisNoteDesc = $(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-desc\").data(\"text\");\n\t\t\t//$(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-desc\").html(thisNoteDesc); //reset text if already bolded\n\t\t\tthisNoteDesc = thisNoteDesc.toString().trim().toLowerCase();\n\t\t\tvar thisNoteSpec = $(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-spec\").data(\"text\");\n\t\t\t//$(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-spec\").html(thisNoteSpec); //reset text if already bolded\n\t\t\tthisNoteSpec = thisNoteSpec.toString().trim().toLowerCase();\n\t\t\tif(thisNoteDesc.indexOf(filterTxt)!=-1 || thisNoteSpec.indexOf(filterTxt)!=-1){\n\t\t\t\tif(thisNoteDesc.indexOf(filterTxt)!=-1){\n\t\t\t\t\tvar start_bold = thisNoteDesc.indexOf(filterTxt);\n\t\t\t\t\tvar end_bold = start_bold + filterTxt.length;\n\t\t\t\t\tthisNoteDesc = $(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-desc\").data(\"text\");\n\t\t\t\t\tthisNoteDesc = thisNoteDesc.substring(0,start_bold) + \'<b>\' + thisNoteDesc.substring(start_bold,end_bold) + \'</b>\' + thisNoteDesc.substring(end_bold,thisNoteDesc.length);\n\t\t\t\t\t$(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-desc\").html(thisNoteDesc);\n\t\t\t\t}\n\t\t\t\tif(thisNoteSpec.indexOf(filterTxt)!=-1){\n\t\t\t\t\tvar start_bold = thisNoteSpec.indexOf(filterTxt);\n\t\t\t\t\tvar end_bold = start_bold + filterTxt.length;\n\t\t\t\t\tthisNoteSpec = $(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-spec\").data(\"text\");\n\t\t\t\t\tthisNoteSpec = thisNoteSpec.substring(0,start_bold) + \'<b>\' + thisNoteSpec.substring(start_bold,end_bold) + \'</b>\' + thisNoteSpec.substring(end_bold,thisNoteSpec.length);\n\t\t\t\t\t$(\"#\"+$(this).attr(\'id\')+\" .NoteTypeBlock-spec\").html(thisNoteSpec);\n\t\t\t\t}\n\t\t\t\thasTemplate = true;\n\t\t\t\t$(this).show();\n\t\t\t\t\n\t\t\t}else{\n\t\t\t\t$(this).hide();\n\t\t\t}\n\t\t});\n\t\tif(!hasTemplate){\n\t\t\t$(\"#norecordsMatch\").show();\n\t\t}\n\t}\n\tordItemContentsScroll.refresh();\n}\n</script>\n<style>\n.norecords{\n    display: block;\n    height: 100%;\n    vertical-align: middle;\n    text-align: left;\n    padding-left: 10px;\n    color: #454a4b;\n    font-size: 13px;\n    font-family: arial;\n}\n.roundiconstyle{\n    background: #196986;\n    -moz-border-radius: 60px;\n    -webkit-border-radius: 60px;\n    border-radius: 60px;\n    -moz-box-shadow: 0px 0px 2px #196986;\n    -webkit-box-shadow: 0px 0px 2px #196986;\n    box-shadow: 0px 0px 2px #196986;\n}\n}\n</style>\n<div style=\"display:table;width:100%;height:100%\">\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<!-- filter text box row -->\n\t<div style=\"display:table-row\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<!-- Allergy search bar -->\n\t\t<div class=\"divEvent divEventTheme\" style=\"width: 96.5%;margin-top: 10px;margin-bottom: 10px;\">\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\"\n\t\t\t\tstyle=\"width: 100%; height: 100%\">\n\t\t\t\t<tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t<td style=\"width: 99%; height: 100%\" valign=\"middle\">\n\t\t\t\t\t<input type=\"text\" class=\"txtContent\" style=\"height:31px;width:98%\" onkeyup=\"filterNoteTypes()\" id=\"NoteTypeFilterTxt\" name=\"NoteTypeFilterTxt\" id=\"NoteTypeFilterTxt\"/>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td style=\"width: 1%; height: 100%\">\n\t\t\t\t\t\t<div class=\"cellDivider\">\n\t\t\t\t\t\t\t<div id=\"removeSearchClass\" class=\"dvSerarchIcon\" onclick=\"clearTemplateFilterTxt()\">\n\t\t\t\t\t\t\t    <img src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/SearchGray16x16.png\" id=\"NoteFilterTxtClearButton\">\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t</div>\n\t<!-- filter text box row -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<div style=\"display:table-row\">\n\t\t<div style=\"display:table-cell;width:100%;height:98%\">\n\t\t\t<div id=\"OrdItemContentsWrap\" style=\"position: relative;width: 100%;height:100%;overflow: hidden;background: #f7f7f7\">\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<div class=\"vscroller5\" id=\"\">\n\t\t\t\t\t<div style=\"display:block;margin: 5px 9px;\">\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<div id=\"NoteTypeBlock_";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="_";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" class=\"NoteTypeBlock\" style=\"display:inline-block;width:170px;height:63px;background:#fff;border:1px solid #cecfce;border-radius:5px;margin:1px\" onclick=\"loadNoteSections(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\">\n\t\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:100%;height:33px\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:32px;height:100%;vertical-align:middle;padding-top:5px;padding-left:5px;padding-bottom:0px;padding-right:0px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/images/Note24x31.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"NoteTypeBlock-desc\" style=\"display:table-cell;height:100%;vertical-align:middle;text-align:left;padding-left:3px;color:#454a4b;font-size:13px;font-family:arial\" data-text=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:100%;vertical-align:bottom;text-align:right;color:#989898;font-size:12px;font-family:arial;padding-right:5px;padding-bottom:5px;\" class=\"NoteTypeBlock-spec\" data-text=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<div id=\"\" class=\"norecords\" style=\"\"> No template matches the search criteria</div>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<div id=\"norecordsMatch\" class=\"norecords\" style=\"display:none\"> No template matches the search criteria</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n</div>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
String mode = request.getParameter("mode")==null?"FREQ":request.getParameter("mode");

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){
	ClinicalNotesBC bc = new ClinicalNotesBC();
	ClinicalNotesFieldResponse noteTypeListResp;
	if(mode.equals("FREQ")){
		noteTypeListResp = bc.getFrequentlyUsedNoteTypes(patientContext);
	}else{
		noteTypeListResp = bc.getAllFilterNoteTypes(patientContext);
	}
	
	List<ClinicalNotesFieldItem> noteTypeList = noteTypeListResp.getFieldList();




            _bw.write(_wl_block4Bytes, _wl_block4);
if(!mode.equals("FREQ")){ 
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);

	}

            _bw.write(_wl_block8Bytes, _wl_block8);
if(noteTypeList!= null && !noteTypeList.isEmpty()){ 
            _bw.write(_wl_block9Bytes, _wl_block9);

					for(int i=0;i<noteTypeList.size();i++) {
						ClinicalNotesFieldItem fieldItem = noteTypeList.get(i);
					
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fieldItem.getCode()));
if(fieldItem.getDetail2()!=null){
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(fieldItem.getDetail2()));
}
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(fieldItem.getCode()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fieldItem.getDesc() ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fieldItem.getDesc() ));
            _bw.write(_wl_block16Bytes, _wl_block16);
if(fieldItem.getDetail()!=null && !fieldItem.getDetail().equals("*ALL")){
            out.print( String.valueOf(fieldItem.getDetail()));
}
            _bw.write(_wl_block15Bytes, _wl_block15);
if(fieldItem.getDetail()!=null && !fieldItem.getDetail().equals("*ALL")){
            out.print( String.valueOf(fieldItem.getDetail()));
}
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block18Bytes, _wl_block18);
} else{  
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
