package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import eIPAD.selectorder.*;
import eIPAD.selectorder.healthobject.*;
import eIPAD.selectorder.request.*;
import eIPAD.selectorder.response.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __ticksheet extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/TickSheet.jsp", 1709118032521L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title></title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/iPadOrder.css\" />\n</head>\n<script>\nfunction showTickSheetSection(tickSheetId, tickSheetDesc)\n{\n\t//alert(tickSheetId);\n\twindow.parent.showTicksheetSection(tickSheetId, tickSheetDesc);\n}\nfunction changeOrientation(orient)\n{\n\tif(orient == \"landscape\")\n\t  {\n\t\t\n\t  }\n  else\n\t  {\n\t      \n\t  }\n}\nfunction deselectCheckBox(orderCatalogCode,orderId)\n{\n\t //document.getElementById(\"tickSheetFrame\").contentWindow.deselectCheckBox(orderCatalogCode,orderId);\n}\n$(document).ready(function () {\n\t//window.parent.parent.setAlignment();\n});\n</script>\n<body >\n\t<section data-role = \"page\" style = \"padding:0px;background-color : #ffffff\">\n\t\t <form id = \"frmTickSheet\" method = \"post\" >\n\t\t \t<div data-role = \"none\" class =\'divTickSheetmain\' id = \'dvmain\'  style=\"padding:0px\">\n\t\t \t\t\n\t\t \t \n\t\t\t\t<div id = \"serachResults\" data-role = \"none\" class = \"dvSearchResults\">\n\t\t\t\t  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t\t\t\t\t\t  <table class = \"tbSearchResults\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t\t    <td align = \"left\" valign = \"center\" style = \"height : 100%;width:100%\" onclick = \"showTickSheetSection(\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\', \'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t<span class = \"spanResultContent\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t    \t\t\t\t     ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t    \t\t\t\t  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t</div>\n\t\t \t</div>\n\t\t \n\n\t\t </form>\n\t  \n\t</section>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

request.setCharacterEncoding("UTF-8");
String locale = "en";
String orderCategory = "";
if(request.getParameter("ordercategory") != null)
{
	orderCategory = request.getParameter("ordercategory");
}
TickSheetRequest oTckSheetReq = new TickSheetRequest();

oTckSheetReq.setRequest(request);
oTckSheetReq.setLanguageID(locale);
oTckSheetReq.setOrderCategory(orderCategory);
if(session.getValue("ca_practitioner_id") != null)
{
	oTckSheetReq.setClinicianID((String)session.getValue("ca_practitioner_id"));
}
oTckSheetReq.setServiceCode((String)session.getValue("ServiceCode"));
if(session.getValue("facility_id") != null )
{
	oTckSheetReq.setFacilityId((String)session.getValue("facility_id"));
}
String locnType = (String)session.getValue("LocnType");
if(locnType != null && locnType.equalsIgnoreCase("W"))
{
	locnType = "N";
}
oTckSheetReq.setLocationType(locnType);
oTckSheetReq.setLocationCode((String)session.getValue("LocnCode"));


            _bw.write(_wl_block1Bytes, _wl_block1);

				  SelectOrderDetails oSelectOrderDetails = new SelectOrderDetails();
				  List<TickSheetHO> lstTickSheet = null;
				  TickSheetHO oTckSheetHO = null;
				  TickSheetResponse oTckRes = null;
				  int nTckCount = 0;
				  int nLoopCount = 0;
				  try{
					  oTckRes = oSelectOrderDetails.getTickSheet(oTckSheetReq);
					  if(oTckRes != null)
					  {
						  lstTickSheet = oTckRes.getLstTickSheet();
						  if(lstTickSheet != null)
						  {
							  nTckCount = lstTickSheet.size();
							  if(nTckCount > 0)
							  {
								  for(nLoopCount = 0 ; nLoopCount < nTckCount; nLoopCount ++)
								  {
									  oTckSheetHO =  lstTickSheet.get(nLoopCount);
									  if(oTckSheetHO != null)
									  {
										  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(oTckSheetHO.getTickSheetId()));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oTckSheetHO.getTickSheetDesc()));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oTckSheetHO.getTickSheetDesc() ));
            _bw.write(_wl_block5Bytes, _wl_block5);
 
									  }
								  }
							  }//ntck count
							  else
			    			  {
			    				  
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
			    			  }
						  }
					  }
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
					  out.println(e.toString());
				  }
				  
				  
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
