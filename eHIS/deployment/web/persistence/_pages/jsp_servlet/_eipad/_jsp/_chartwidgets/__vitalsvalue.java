package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ResourceBundle;
import java.util.*;
import eIPAD.chartsummary.vitals.response.*;
import eIPAD.chartsummary.vitals.healthobject.*;

public final class __vitalsvalue extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/VitalsValue.jsp", 1709116951379L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<div data-role = \"none\" class = \"dvResultsTable\">\n\t\t\t\t   \t\t<div data-role = \"none\" class = \"dvReslutsRow1\">\n\t\t\t\t   \t\t\t<div data-role = \"none\" class = \"dvResultsCol1\">\n\t\t\t\t   \t\t\t\t<div data-role = \"none\" class = \"dvVitalsResultHeader dvVitalsResultHeaderTheme dvResultsHeaderBorder\">\n\t\t\t\t   \t\t\t\t\t<div data-role = \"none\" style = \"position:relative;width:100%;height:100%\">\n\t\t\t\t   \t\t\t\t\t\t<div data-role = \"none\" class = \"dvHeaderFont\">Vitals</div>\n\t\t\t\t   \t\t\t\t\t</div>\n\t\t\t\t   \t\t\t\t</div>\n\t\t\t\t   \t\t\t\t<!-- discree measure starts for loop usin the configuration-->\n\t\t\t\t   \t\t\t\t  <!--  \n\t\t\t\t   \t\t\t\t\t<div data-role = \"none\" class = \"dvVitals dvVitalsTheme\">\n\t\t\t\t   \t\t\t\t\t\t<div data-role = \"none\" class = \"dvMeasureContainer\">\n\t\t\t\t   \t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvMeasureFont\">Systolic BP</div>\n\t\t\t\t   \t\t\t\t\t\t</div>\n\t\t\t\t   \t\t\t\t\t\t<div data-role = \"none\" class = \"dvMeasureUnits\">\n\t\t\t\t   \t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvUnitsFont\"> Deg C</div>\n\t\t\t\t   \t\t\t\t\t\t</div>\n\t\t\t\t   \t\t\t\t\t</div>\n\t\t\t\t   \t\t\t\t\t-->\n\t\t\t\t   \t\t\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t   \t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvVitals dvVitalsTheme\">\n\t\t\t\t\t\t\t   \t\t\t\t\t\t<div data-role = \"none\" class = \"dvMeasureContainer\">\n\t\t\t\t\t\t\t   \t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvMeasureFont\">";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</div>\n\t\t\t\t\t\t\t   \t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t   \t\t\t\t\t\t<div data-role = \"none\" class = \"dvMeasureUnits\">\n\t\t\t\t\t\t\t   \t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvUnitsFont\"> ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</div>\n\t\t\t\t\t\t\t   \t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t   \t\t\t\t\t</div>\n\t\t\t\t   \t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t   \t\t\t\t\t\n\t\t\t\t   \t\t\t\t\t\n\t\t\t\t   \t\t\t\t\t<!-- 7 row end -->\n\t\t\t\t   \t\t\t\t<!--  For loop ends discree measure ends -->\n\t\t\t\t   \t\t\t\t\n\t\t\t\t   \t\t\t</div><!-- col1 ends -->\n\t\t\t\t   \t\t\t<div data-role = \"none\" class = \"dvResultsCol2\" id = \"dvResultsCol2\">\n\t\t\t\t   \t\t\t\t<div data-role = \"none\" class = \"vitalsSwipeWrapper\" id = \"vitalsSwipeWrapper\">\n\t\t\t\t   \t\t\t\t\t<div data-role = \"none\" class = \"vitalsScroller\" id = \"vitalsScroller\">\n\t\t\t\t   \t\t\t\t\t<!-- check if dates are present -->\n\t\t\t\t   \t\t\t\t\t\n\t\t\t\t   \t\t\t\t\t\t<div data-role = \"none\" class = \"dvResultsHeaderTable dvVitalsResultHeaderTheme dvResultsValueBorder\">\n\t\t\t\t   \t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvResultsHeaderRow\">\n\t\t\t\t   \t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvResultsHeaderCol\">\n\t\t\t\t   \t\t\t\t\t\t\t\t\n\t\t\t\t   \t\t\t\t\t\t\t\t    <!-- for loop for dates -->\n\t\t\t\t   \t\t\t\t\t\t\t\t \n\t\t\t\t   \t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t   \t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvHeaderDate\">\n\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvDateFont\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</div>\n\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t   \t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t   \t\t\t\t\t\t\t\t\t\n\t\t\t\t   \t\t\t\t\t\t\t\t\t<!-- end  loop for dates -->\n\t\t\t\t   \t\t\t\t\t\t\t\t</div>\n\t\t\t\t   \t\t\t\t\t\t\t\t\n\t\t\t\t   \t\t\t\t\t\t\t</div>\n\t\t\t\t   \t\t\t\t\t\t</div>\n\t\t\t\t   \t\t\t\t\t\t\n\t\t\t\t   \t\t\t\t\t\t\n\t\t\t\t   \t\t\t\t\t\t\n\t\t\t\t   \t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t   \t\t\t\t\t\t<div data-role = \"none\" class = \"dvResultsValueTable dvVitalsTheme1 dvVitalsBorderTheme\">\n\t\t\t\t\t   \t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvResultsValueRow\">\n\t\t\t\t\t   \t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvResultsValueCol\">\n\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t   \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t\t\t\t  <div data-role = \"none\" class = \"dvValueContainer\">\n\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvVitalsIconContainer\" style = \"overflow:hidden\">\n\t\t\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/images/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" style = \"position:relative;margin-top :18px\"></img>\n\t\t\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t<div data-role = \"none\" class = \"dvVitalsValue\" style = \"overflow:hidden\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\t\t\t  </div>\n\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="    \n\t\t\t\t\t   \t\t\t\t\t\t\t\t\n\t\t\t\t\t   \t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t   \t\t\t\t\t\t\t</div>\n\t\t\t\t\t   \t\t\t\t\t\t</div>\t\n\t\t\t\t\t   \t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t   \t\t\t\t\t\t\t\t\t\t   \t\t\t\t\t\t\n\t\t\t\t   \t\t\t\t                <!-- discree value ends -->\n\t\t\t\t   \t\t\t\t\t</div><!-- scroller -->\n\t\t\t\t   \t\t\t\t</div><!-- wrapper -->\n\t\t\t\t   \t\t\t</div><!-- col2 ends -->\n\t\t\t\t   \t\t</div>\n\t\t\t\t   \t</div>\n\t\t\t\t   \t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
if (session.getAttribute("LOCALE") != null
		&& !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle(
		"eIPAD.chartsummary.common.resourcebundle.cslabels",
		appLocale);
VitalsConfigResponse oVitalsConfigResponse = null;
CurrentAndHistoryResponse oCurrentAndHistoryResponse = null;
if(request.getAttribute("VitalsConfigResponse") != null)
{
	oVitalsConfigResponse = (VitalsConfigResponse)request.getAttribute("VitalsConfigResponse");
	
}
if(request.getAttribute("CurrentAndHistoryResponse") != null)
{
	oCurrentAndHistoryResponse = (CurrentAndHistoryResponse)request.getAttribute("CurrentAndHistoryResponse");
}
int nVitalsConfigList = 0;
List<VitalsConfig> listVitalConfig = null;
int nVitalsConfigLoopCount = 0;
DateContainer oDateContainer = null;
if(oVitalsConfigResponse != null && oVitalsConfigResponse.isSuccessResponse() && !oVitalsConfigResponse.isEmptyDataResponse())
{
	   if(oVitalsConfigResponse.getListVitalConfig() != null)
	   {
		   listVitalConfig = oVitalsConfigResponse.getListVitalConfig();
		   if(oVitalsConfigResponse.getListVitalConfig() != null)
		   		nVitalsConfigList = listVitalConfig.size();
	   }
}
if(nVitalsConfigList > 0)
{

            _bw.write(_wl_block2Bytes, _wl_block2);

				   					   
				   					   for(nVitalsConfigLoopCount = 0; nVitalsConfigLoopCount < nVitalsConfigList; nVitalsConfigLoopCount++)
				   					   {
				   						String eventCode = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureId();
				   						String DiscreteMeasureDescription = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc();
				   						String UOM = listVitalConfig.get(nVitalsConfigLoopCount).getUnits();
				   							
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(DiscreteMeasureDescription ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(UOM));
            _bw.write(_wl_block5Bytes, _wl_block5);
 
				   							
				   					   }
				   					nVitalsConfigLoopCount = 0;
				   					
            _bw.write(_wl_block6Bytes, _wl_block6);

				   										if(oCurrentAndHistoryResponse != null && oCurrentAndHistoryResponse.isSuccessResponse() && !oCurrentAndHistoryResponse.isEmptyDataResponse())
				   										{
				   											String dateFormat = "dd/MM/yyyy HH:mm";
				   											oDateContainer = oCurrentAndHistoryResponse.getDateContainer();
				   											if(oDateContainer != null && oDateContainer.getDateList() != null && oDateContainer.getDateList().size() > 0)
				   											{
				   												List<Date> dateList = oDateContainer.getDateList();
				   												for(Date oDate : dateList)
				   												{
				   													String strDate = oCurrentAndHistoryResponse.formatDate(oDate, dateFormat);
				   													
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( strDate));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
				   												}
				   											}
				   										}//if
				   									
            _bw.write(_wl_block9Bytes, _wl_block9);

				   						for(nVitalsConfigLoopCount = 0; nVitalsConfigLoopCount < nVitalsConfigList; nVitalsConfigLoopCount++)
				   						{
				   							String eventCode = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureId();
					   						String DiscreteMeasureDescription = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc();
					   						CurrentAndHistoryDM oCurrentAndHistoryDM = null;
					   						CurrentAndHistoryDM objcurrentHistoryDM = null;
					   						if(oCurrentAndHistoryResponse != null && oCurrentAndHistoryResponse.isSuccessResponse() && !oCurrentAndHistoryResponse.isEmptyDataResponse())
					   						{
					   							oCurrentAndHistoryDM = oCurrentAndHistoryResponse.getDiscreteMeasure(eventCode);
					   						}
					   						
            _bw.write(_wl_block10Bytes, _wl_block10);

					   										if(oCurrentAndHistoryDM != null)
					   										{
					   											objcurrentHistoryDM = oCurrentAndHistoryResponse.getDiscreteValueForAllDates(oCurrentAndHistoryDM ,oDateContainer);
					   											if(objcurrentHistoryDM != null && objcurrentHistoryDM.getDiscreteValuesList() != null && objcurrentHistoryDM.getDiscreteValuesList().size() > 0)
					   											{
					   												int nListSize = objcurrentHistoryDM.getDiscreteValuesList().size();
					   												int loopCount = 0;
					   												for(loopCount = 0;loopCount < nListSize;loopCount++)
					   												{
					   													DiscreteValue oCurrentDiscreteValue = objcurrentHistoryDM.getDiscreteValuesList().get(loopCount);
					   													
            _bw.write(_wl_block11Bytes, _wl_block11);

									   											if(oCurrentDiscreteValue != null)
									   											{
									   												NormalcyIndicator oNormalcyIndicator = objcurrentHistoryDM.getNormalcyIndicator(oCurrentDiscreteValue, "S");
																					String iConName = oNormalcyIndicator.getSymbolIndicator();
																					if(iConName != null && !iConName.equals(""))
																					{
																						iConName = "S" + iConName;
																					}
																					String resultNum = "";
																					if(oCurrentDiscreteValue.getResultNum() != null && oCurrentDiscreteValue.getResultString() != null)
																		    		{
																		    			resultNum  = oCurrentDiscreteValue.getResultNum().trim() + oCurrentDiscreteValue.getResultString().trim();
																		    			
																		    		}
																					
																					if(resultNum != null && resultNum.length() > 19)
																			    	{
																			    		resultNum = resultNum.substring(0, 17) ;
																			    	}
																					
																					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(iConName));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(resultNum ));
            _bw.write(_wl_block15Bytes, _wl_block15);
 
																					
									   											}
									   										
            _bw.write(_wl_block16Bytes, _wl_block16);
 
					   												}
					   											}
					   										}//else no rec found
					   										
					   								
            _bw.write(_wl_block17Bytes, _wl_block17);
 
					   						
				   						}
				   						
            _bw.write(_wl_block18Bytes, _wl_block18);

}
				   	
            _bw.write(_wl_block1Bytes, _wl_block1);
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
