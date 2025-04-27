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

public final class __ticksheetitems extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/TickSheetItems.jsp", 1709118032708L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title></title> \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/iPadOrder.css\" />\n</head>\n<script>\nfunction showTickSheetSectionItems(sectionCode,tickSheetId,currentObj)\n{\n\tvar patclass = document.getElementById(\"hdnPatClass\").value;\n\tvar orderCategory = document.getElementById(\"hdnOrderCategory\").value\n\tvar url = \"TickSheetSectionItems.jsp?sectioncode=\" + sectionCode+ \"&ticksheetid=\" + tickSheetId+ \"&patientclass=\" + patclass+\"&ordercategory=\"+ orderCategory;;\n\tdocument.getElementById(\"tickSheetSectionFrame\").src = url;\n\t//tbSearchResultsActive\n\t $(\"[data-class = \'normal\']\").each(function(index, value) { \n\t    $(this).attr(\"class\" , \"tbSearchResults\");\n\t });\n\tcurrentObj.setAttribute(\"class\",\"tbSearchResultsActive\");\n}\nfunction changeOrientation(orient)\n{\n\tif(orient == \"landscape\")\n\t  {\n\t     $(\"#dvTickSection\").css(\'min-height\',\'342px\');\n\t     $(\"#dvSectionItems\").css(\'min-height\',\'342px\');\n\t    \n\t     $(\"#tickSheetSectionFrame\").css(\'min-height\',\'342px\');\n\t  }\n  else\n\t  {\n\t     $(\"#dvTickSection\").css(\'min-height\',\'599px\');\n\t     $(\"#dvSectionItems\").css(\'min-height\',\'599px\');\n\t     $(\"#tickSheetSectionFrame\").css(\'min-height\',\'599px\');\n\t  }\n}\nfunction deselectCheckBox(orderCatalogCode,orderId)\n{\n\tvar obj = document.getElementById(\"tickSheetSectionFrame\");\n\tif(obj != null && obj.contentWindow != null)\n\t{\n\t\tobj.contentWindow.deselectCheckBox(orderCatalogCode,orderId);\n\t}\n\t// document.getElementById(\"tickSheetSectionFrame\").contentWindow.deselectCheckBox(orderCatalogCode);\n}\n$(document).ready(function () {\n\t//window.parent.parent.setAlignment();\n});\n</script>\n\n<body  style = \"background-color : #ffffff\" >\n\t<section data-role = \"page\" style = \"padding:0px;background-color : #ffffff\">\n\t\t <form id = \"frmTickSheetItem\" method = \"post\" >\n\t\t\t <div data-role = \"none\" class =\'divTickSheetmain\' id = \'dvmain\'  style=\"padding:0px\" >\n\t\t\t  \n\t\t\t   \n\t\t\t   <div id = \"dvTickSection\" class = \"dvTickSections\" data-role = \"none\">\n\t\t\t   \n\t\t\t     ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t\t\t\t\t\t  <table class = \"tbSearchResults\" cellpadding = \"0\" cellspacing = \"0\" data-class = \"normal\" onclick = \"showTickSheetSectionItems(\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\',\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\',this)\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr style = \"width:90%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t\t    <td align = \"left\" valign = \"center\" style = \"height : 100%;width:88%\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t<span class = \"spanResultContent\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <td align = \"center\" valign = \"center\" style = \"width:12%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t      <img src = \"../images/Ticksheetarrow.PNG\"></img>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t    \t\t\t\t     ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t    \t\t\t\t  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t        \n\t\t\t   </div> \n\t\t\t   <div id = \"dvSectionItems\" class = \"dvSectionItems\" data-role = \"none\">\n\t\t\t     <div style = \"height:auto;overflow:auto;padding:0px;\" data-role = \"none\">\n                      <iframe frameborder=\"0\" id=\"tickSheetSectionFrame\"   class= \"tickSheetFrame\" scrolling =\"yes\" style=\"padding:0px;display:block\" width = \"100%\" ></iframe>\n                  </div> \n\t\t\t    \n\t\t\t   </div>\n\t\t\t</div>\n\t\t\t<input type = \"hidden\" id = \"hdnPatClass\" name = \"hdnPatClass\" value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" />\n\t\t\t<input type = \"hidden\" id = \"hdnOrderCategory\" name = \"hdnOrderCategory\" value = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" />\n\t\t </form> \n\t</section>  \n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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

 String locale = "en";
 String tickSheetId = "";
 String orderCategory = "";
 if(request.getParameter("ordercategory") != null)
 {
 	orderCategory = request.getParameter("ordercategory");
 }
 if(request.getParameter("ticksheetid") != null)
 {
	 tickSheetId = request.getParameter("ticksheetid");
 }
 String patientClass = "";
 if(request.getParameter("patientclass") != null)
 {
 	 patientClass = request.getParameter("patientclass");
 }
 TickSheetRequest oTckSheetReq = new TickSheetRequest();
 oTckSheetReq.setRequest(request);
 oTckSheetReq.setLanguageID(locale);
 oTckSheetReq.setOrderCategory(orderCategory);
 oTckSheetReq.setTickSheetId(tickSheetId);
 
 

            _bw.write(_wl_block1Bytes, _wl_block1);

				  SelectOrderDetails oSelectOrderDetails = new SelectOrderDetails();
				  List<TickSheetHO> lstTickSheet = null;
				  TickSheetHO oTckSheetHO = null;
				  TickSheetResponse oTckRes = null;
				  int nTckCount = 0;
				  int nLoopCount = 0;
				  try{
					  oTckRes = oSelectOrderDetails.getTickSheetSection(oTckSheetReq);
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
            out.print( String.valueOf(oTckSheetHO.getSectionCode()));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(tickSheetId));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oTckSheetHO.getSectionDesc() ));
            _bw.write(_wl_block5Bytes, _wl_block5);
 
									  }
								  }
							  }
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
            out.print( String.valueOf( patientClass ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(orderCategory ));
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
