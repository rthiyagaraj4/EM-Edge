package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.proceduredetails.response.*;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.proceduredetails.healthobject.*;
import java.util.ResourceBundle;
import java.util.*;

public final class __proceduredetailview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ProcedureDetailView.jsp", 1709118022771L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<style>\n\n</style>\n\t<div class=\"procWidgetParent widgetParentTheme\" data-role = \"none\">\n\t\t<div class=\"widgetTable\" data-role = \"none\">\n\t\t\t<div class=\"widgetHeaderRow widgetHeaderRowTheme\" data-role = \"none\">\n\t\t\t\t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderMarginExtn widgetHeaderMarginExtnTheme\" data-role = \"none\"></div>\n\t\t\t\t\t<div class=\"widgetHeaderIcontriangle\" data-role = \"none\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"widgetHeaderCell widgetHeaderCellTheme\" data-role = \"none\">\n\t\t\t\t\t<div class=\"widgetHeaderSubTable\" data-role = \"none\">\n\t\t\t\t\t\t<div class=\"widgetHeaderSubRow\" data-role = \"none\">\n\t\t\t\t\t\t\t<div class=\"widgetHeaderIconCol1\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"widgetHeaderIconButton widgetHeaderIconButtonTheme\"  data-role = \"none\"><img src= \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/images/CS_Procedures_Details.PNG\" class=\"widgetHeaderButtonImage\" ></div>\n\t\t\t\t\t\t\t</div>\n<!-- \t\t\t\t\t\t\t<div class=\"widgetHeaderIconCol2\"  data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"widgetHeaderArrowRightTheme\" data-role = \"none\"></div>\n\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t<div class=\"widgetHeaderHeadingTextCol\" data-role = \"none\"><span class=\"widgetHeaderHeadingTextTheme\" data-role = \"none\">Procedure Details</span> <input type=\"button\" class=\"widgetHeaderCountButtonTheme\" id=\"procedureDetailsViewCount\" value=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"></div>\n\t\t\t\t\t\t\t<div class=\"widgetHeaderPlusButtonCell\" data-role = \"none\">\n\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" data-role = \"none\" ><img src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/images/CS_add16x16.png\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\t<div class=\"widgetTable\" data-role = \"none\">\t\n\t\t\t<!-- content starts here -->\n\t\t\t<div class=\"procWidgetContentRow\" data-role = \"none\">\n\t\t\t  \t<div class=\"widgetHeaderMarginCell\" data-role = \"none\">\n\t\t\t\t</div>\n\t\t\t\t<div class=\"widgetContentCell widgetContentCellTheme\" data-role = \"none\">\n\t\t\t\t\t\n\t\t\t\t\t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t  \t\t\t\t<div class=\"AllergyContentTable WidgetContentStripTheme\"  data-role = \"none\"> <!--  content table starts -->\n\t\t\t\t\t  \t\t\t\t\t<div class=\"ProcContentRow\" data-role = \"none\"> <!-- content row starts -->\n\t\t\t\t\t\t\t\t\t\t\t<div class = \"procContentCell\" data-role = \"none\"><!-- contentCell starts here -->\n\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"procItemTable\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"procItemRow1\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"procItemCell1\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"procDesc\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t<div class=\"SfsHeaderButtonTheme procMButton\" data-role = \"none\">Modify</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"procItemRow2\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"procItemCell2\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"procDateTable\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"procDateRow\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"procDateCell1\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class = \"dvProcCode\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t                                \t<span class = \"spanProcCode\" data-role = \"none\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span> <span class = \"spanName\" data-role = \"none\">by ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t                              </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"procDateCell2\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"procWidgetDateTextTheme\"  data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div class = \"editProc\" data-role = \"none\"></div>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div data-role = \"none\" class = \"spanProcDate\" ><span >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div><!-- contentCell ends here -->\t\n\t\t\t\t\t\t\t\t\t\t</div><!-- content row ends -->\n\t\t\t\t\t\t\t\t\t</div><!--  content table ends -->\n\t\t\t\t\t  \t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t  \t\t\n\t\t\t\t\t <div class=\"WidgetVwErrContainer\">\n\t\t\t\t\t\t<div class=\"WidgetErrorResponse WidgetErrorResponseTheme\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div>\n\t\t\t\t\t</div>\n\n\t\t\t\t\t  \t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<!-- content ends here -->\n\t\t</div><!-- widget table ends  -->\n\t</div>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

int nListSize = 0; 
ProcedureDetailsResponse oProcRes = null;
List<ProcedureDetailsHO> lstProcedureDetails = null;
if(request.getAttribute("ProcedureDetailsResponse") != null)
{
	oProcRes = (ProcedureDetailsResponse)request.getAttribute("ProcedureDetailsResponse");
	lstProcedureDetails = oProcRes.getLstProcedureDetails();
	if(lstProcedureDetails != null)
	{
		nListSize = lstProcedureDetails.size();
	}
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(nListSize));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);

					    int nLoopCount = 0;
					    
					    ProcedureDetailsHO oProcHO = null;
					  	if(oProcRes != null && oProcRes.isSuccessResponse() && !oProcRes.isEmptyDataResponse())
					  	{
					  		
					  		 if(nListSize > 0)
					  		 {
					  			 for(nLoopCount = 0; nLoopCount < nListSize;nLoopCount ++)
					  			 {
					  				oProcHO = lstProcedureDetails.get(nLoopCount);
					  				if(oProcHO != null)
					  				{
					  					
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oProcHO.getProcedureDescription() ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oProcHO.getProcedureCode()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oProcHO.getPractitionerName() ));
            _bw.write(_wl_block9Bytes, _wl_block9);

																				if(oProcHO.getStatus() != null && oProcHO.getStatus().equalsIgnoreCase("Modified")) 
																				{
																			 
            _bw.write(_wl_block10Bytes, _wl_block10);

																				}
																			 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(oProcHO.getProcedureDateTime() ));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
					  				}
					  			 }
					  		 }
					  		 
					  	}
					  	else
					  	{
					  		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(oProcRes.getErrorsList().get(0).getErrorMessage() ));
            _bw.write(_wl_block14Bytes, _wl_block14);
 
					  	}
					  		
					  	
            _bw.write(_wl_block15Bytes, _wl_block15);
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
