package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eCommon.Common.CommonBean;
import eIP.advbedmgmt.common.model.BedLegend;
import java.util.List;
import eIP.advbedmgmt.common.bedlegend.response.BedLegendResponse;
import eIP.advbedmgmt.common.bedlegend.bc.BedLegendBC;
import eIP.advbedmgmt.common.bedlegend.BedLegendConstants;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import eIP.advbedmgmt.GBMConstants;
import org.springframework.context.ApplicationContext;
import eIP.advbedmgmt.common.bedlegend.request.BedLegendRequest;
import eIP.advbedmgmt.common.model.BedStatusEnum;

public final class __ipadvbedmgmtlegendpanel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPAdvBedMgmtLegendPanel.jsp", 1709117769849L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="<!--Added By Dharma on 16th Mar 2016-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<!DOCTYPE>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\'\n\thref=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<link type=\"text/css\" rel=\"stylesheet\"\n\thref=\"../../eIP/html/IPAdvBedMgmtStyle.css\" />\n\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<body style=\"height:100%;background: #";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =";\">\n<form name=\'legendForm\' id=\'legendForm\'>\n<table id=\"legendDiv\" style=\"width:100%;height:100%;background: #";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =";\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<!-- <div id=\"tablediv\" style=\"width:100%;display:table;\"> -->\n\t\n\t<tr>\n\t\t<!-- <div style=\"display:table-row;\"> -->\n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</tr>\n\t\t<tr>\t\n\t\t<!-- </div>\n\t\t<div style=\"display:table-row;\"> -->\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<td style=\"background: #";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =";width:3%;\"></td>\n\t\t<td style=\"font-size: 8pt;\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<input type=\'hidden\' id=\"hid_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" />\t<!--Added By Dharma on 16th Mar 2016-->\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t\t</tr>\t\n\t\t<!-- </div>\n    </div> -->\n\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<tr>\n<td style=\"width:100%;\">\n<span style=\"color: #000000;\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </span>\n\n</td>\n</tr>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\n\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
 String sStyle = (String)session.getAttribute("PREFERRED_STYLE");
	sStyle = CommonBean.checkForNull(sStyle, "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

BedLegendRequest bedLegendRequest = new BedLegendRequest();
ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
BedLegendBC bcInst = (BedLegendBC)context.getBean(BedLegendConstants.LEGEND_BC_NAME);
BedLegendResponse bedLegendResponse = bcInst.getBedLegend(bedLegendRequest);

String errorMessage = bedLegendResponse.getErrorMessage();
String roomBackgndColor = bedLegendResponse.getRoomBackgroundColor();

/* String dischargeBillPrepMesg = BundleManager.getInstance().getMessageFromResourceBundle(
			BedLegendConstants.DISCHARGE_BILL_PREPARED_MESG_KEY, 
			BedLegendConstants.BEDLEGEND_LABELS_RESOURCE_CLASSNAME); */

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(roomBackgndColor));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(roomBackgndColor));
            _bw.write(_wl_block8Bytes, _wl_block8);

//response is successful - render the legend
if(bedLegendResponse.isSuccessful()){
	List<BedLegend> legends = bedLegendResponse.getLegends();
	
	final int ROW_COMP_COUNT = 7;
	int counter = 1;
	
	String innerDivStyle = "";
	

            _bw.write(_wl_block9Bytes, _wl_block9);
	
	String color = "";
	String desc = "";
	String txtColor = "";	//Added By Dharma on 16th Mar 2016
	BedStatusEnum legendIdentifier = null;	//Added By Dharma on 16th Mar 2016
	for(BedLegend bedLegend:legends){
		if(counter > ROW_COMP_COUNT){
			
            _bw.write(_wl_block10Bytes, _wl_block10);

			counter = 1;
		}
		
		color = bedLegend.getLegendColor();
		desc = bedLegend.getLegendDescription();
		txtColor = bedLegend.getTextColor();
		legendIdentifier	= (BedStatusEnum)bedLegend.getLegendIdentifier();
		
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(color));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(desc ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(legendIdentifier));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(txtColor));
            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block16Bytes, _wl_block16);

		counter++;
	}

            _bw.write(_wl_block17Bytes, _wl_block17);

}else{
	// failure response

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(errorMessage ));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
}

            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
