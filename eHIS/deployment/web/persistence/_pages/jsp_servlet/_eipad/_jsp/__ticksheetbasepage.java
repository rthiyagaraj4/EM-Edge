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

public final class __ticksheetbasepage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/TickSheetBasePage.jsp", 1709118032615L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>Insert title here</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/iPadOrder.css\" />\n<link rel=\"stylesheet\" href=\"../css/iPadOrderTickSheet.css\" />\n</head>\n<script>\nfunction showTickSheetResults()\n{\n\tvar orderCategory = document.getElementById(\"cmbOrderCategory\").value;\n\tdocument.getElementById(\"tickSheetFrame\").src = \"TickSheet.jsp?ordercategory=\" + orderCategory;\n\tif(orderCategory!=null && orderCategory!=\"\")\n\t{\n\t\tvar headcontent = $(\"#cmbOrderCategory option:selected\").text();\n\t\ttickSheetHeader(headcontent,\"\");\n\t}\n\telse\n\t{\n\t\ttickSheetHeader(\"\",\"\");\n\t}\n\n}\nfunction showTicksheetSection(tickSheetId,tickSheetDesc)\n{\n\tvar orderCategory = document.getElementById(\"cmbOrderCategory\").value;\n\tvar patclass = document.getElementById(\"hdnPatClass\").value;\n\tvar url = \"TickSheetItems.jsp?ticksheetid=\" + tickSheetId + \"&patientclass=\" + patclass +\"&ordercategory=\"+ orderCategory;\n\tdocument.getElementById(\"tickSheetFrame\").src = url;\n\tvar headContent = $(\"#cmbOrderCategory option:selected\").text();\n\ttickSheetHeader(headContent,tickSheetDesc);\n}\n\nfunction tickSheetHeader(content, content01)\n{\n\tif(content==null || content==\"\")\n\t{\n\t\t$(\"#tickSheetHeaderContentarea01\").html(\"Tick Sheets\");\n\t\t$(\"#tickSheetHeaderContentcell\").css(\"display\",\"none\");\n\t\t$(\"#tickSheetHeaderRightarrowcelltree\").css(\"display\",\"none\");\n\t}\n\telse if(content01==null || content01==\"\")\n\t{\n\t\t$(\"#tickSheetHeaderContentarea01\").html(content);\n\t\t$(\"#tickSheetHeaderContentcell\").css(\"display\",\"none\");\n\t\t$(\"#tickSheetHeaderRightarrowcelltree\").css(\"display\",\"none\");\n\t}\n\telse\n\t{\n\t\t$(\"#tickSheetHeaderContentcell\").css(\"display\",\"table-cell\");\n\t\t$(\"#tickSheetHeaderRightarrowcelltree\").css(\"display\",\"table-cell\");\n\t\t$(\"#tickSheetHeaderContentarea01\").html(content01);\n\t\t$(\"#tickSheetHeaderContentarea\").html(content);\n\t}\n}\nfunction changeOrientation(orient)\n{\n\tif(orient == \"landscape\")\n\t  {\n\t\tdocument.getElementById(\"tickSheetFrame\").contentWindow.changeOrientation(orient);\n\t  }\n  else\n\t  {\n\t    document.getElementById(\"tickSheetFrame\").contentWindow.changeOrientation(orient);    \n\t  }\n}\nfunction deselectCheckBox(orderCatalogCode,orderId)\n{\n\t document.getElementById(\"tickSheetFrame\").contentWindow.deselectCheckBox(orderCatalogCode,orderId);\n}\n</script>\n<body >\n\t<section data-role = \"page\" style = \"padding:0px;background-color : #ffffff\">\n\t\t <form id = \"frmBaseTickSheet\" method = \"post\" >\n\t\t \t<div data-role = \"none\" class =\'divTickSheetmain\' id = \'dvmain\'  style=\"padding:0px\">\n\t\t \t\t<div id = \"dvCriteria\" class = \"dvCriteria\">\n\t\t \t\t  <table style=\"height:auto;width:100%\" >\n\t\t \t\t    <tr style = \"height:auto;width:100%\">\n\t\t \t\t      <td style = \"height:auto;width:90%\">\n\t\t \t\t        <table style=\"height:65px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t \t\t\t  <tr style=\"height:30px;width:100%\">\n\t\t \t\t\t    <td align = \"left\" style=\"width:33%\" valign = \"center\"><span class = \"spanPeriod\">Order Category</span></td>\n                        <td style=\"width:33%\"> &nbsp;</td>\n                        <td style=\"width:33%\"> &nbsp;</td>\n\t\t\t\t         \n\t\t \t\t\t  <tr>\n\t\t \t\t\t \n\t\t \t\t\t  \n\t\t \t\t\t  <tr style=\"height:35px;width:100%\">\n\t\t \t\t\t     <td align = \"left\" style=\"width:33%\">\n\t\t\t\t\t        <select  class=\"cmbPeriod\" data-role=\"none\" id=\"cmbOrderCategory\" name = \"cmbOrderCategory\" onchange=\"showTickSheetResults()\" > \n\t\t\t\t\t          <option value = \"\">Select</option>\n\t\t\t\t\t         ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t        \t\t\t\t\t\t   <option value = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" > ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</option>\n\t\t\t\t\t        \t\t\t\t\t\t  ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\t\t\t\t\t\t\t</select> \n\t\t\t            </td>\n\t\t\t            \n\t\t\t            <td style=\"width:33%\"> &nbsp;</td>\n                        <td style=\"width:33%\"> &nbsp;</td>\n\t\t\t            \n\t\t\t           \n\t\t \t\t\t  </tr>\n\t\t \t\t\t\n\t\t \t\t\t</table>\n\t\t \t\t      </td>\n\t\t \t\t     <td align = \"center\" style=\"width:10%\"  valign = \"bottom\" onclick = \"showTickSheetResults()\"><img src = \"../images/SearchOrder.PNG\"></img></td>\n\t\t \t\t    <tr>\n\t\t \t\t  </table>\n\t\t \t\t\t\n\t\t \t\t</div>\n\t\t \t \t<div id=\"resultPageHeaderTickSheet\"  class=\"resultPageHeaderTickSheet\">\n\t\t\t\t\t\n\t\t\t\t\t\t\t<div id=\"tickSheetHeaderContainer\" style=\"height:30px\">\n\t\t\t\t\t\t\t\t<div id=\"tickSheetHeaderRow\">\n\t\t\t\t\t\t\t        <div id=\"tickSheetHeaderContentcell\" style=\"display:none\" onclick=\"showTickSheetResults()\">\n\t\t\t\t\t\t\t        \t<div id=\"tickSheetHeaderContentarea\">\n\t\t\t\t\t\t\t           Tick Sheets\n\t\t\t\t\t\t\t            </div>\n\t\t\t\t\t\t\t        </div>\n\t\t\t\t\t\t\t        <div id=\"tickSheetHeaderRightarrowcelltree\" style=\"display:none\">\n\t\t\t\t\t\t\t            <div id=\"tickSheetHeaderArrow-right\">\n\t\t\t\t\t\t\t            </div>\n\t\t\t\t\t\t\t        </div>\n\t\t\t\t\t\t\t        <div id=\"tickSheetHeaderContentcell01\">\n\t\t\t\t\t\t\t        \t<div id=\"tickSheetHeaderContentarea01\">\n\t\t\t\t\t\t\t           Tick Sheets\n\t\t\t\t\t\t\t            </div>\n\t\t\t\t\t\t\t        </div>\n\t\t\t\t\t\t\t        <div id=\"tickSheetHeaderRightarrowcell01\">\n\t\t\t\t\t\t\t            <div id=\"tickSheetHeaderArrow-right01\">\n\t\t\t\t\t\t\t            </div>\n\t\t\t\t\t\t\t        </div>\n\t\t\t\t\t\t\t       \n\t\t\t\t\t\t\t       \n\t\t\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t<div id = \"serachResults\" data-role = \"none\" class = \"dvSearchResults\">\n\t\t\t\t  \n\t\t\t\t  <div style = \"height:auto;overflow:auto;padding:0px;data-role = \"none\">\n                      <iframe frameborder=\"0\" id=\"tickSheetFrame\"   src = \"TickSheet.jsp\" scrolling =\"yes\" style=\"padding:0px;display:block\" width = \"100%\" ></iframe>\n                  </div>   \n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t \t</div>\n\t\t \n         <input type = \"hidden\" id = \"hdnPatClass\" name = \"hdnPatClass\" value = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" />\n         <input type = \"hidden\" id = \"hdnArrowContentArea\" name = \"hdnArrowContentArea\" value = \"\" />\n         <input type = \"hidden\" id = \"hdnArrowContentArea01\" name = \"hdnArrowContentArea01\" value = \"\" />\n\t\t </form>\n\t  \n\t</section>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
String patientClass = "";
if(request.getParameter("patientclass") != null)
{
	 patientClass = request.getParameter("patientclass");
}

OrderCategoryRequest oCategoryReq = new OrderCategoryRequest();
oCategoryReq.setRequest(request);
oCategoryReq.setLanguageID(locale);
oCategoryReq.setCalledFrom("TickSheet");
OrderCategoryResponse oCategoryRes = null;
List<OrderCategoryHO> lstOrderCategory = new ArrayList<OrderCategoryHO>();

SelectOrderDetails oSelectOrderDetails = new SelectOrderDetails();


            _bw.write(_wl_block1Bytes, _wl_block1);

					          try
					         {
					        	  int nOrderCatCount = 0;
					        	  OrderCategoryHO oCategoryHO = null;
					        	  oCategoryRes = oSelectOrderDetails.getOrderCategory(oCategoryReq);
					        	  if(oCategoryRes != null)
					        	  {
					        		  lstOrderCategory = oCategoryRes.getLstOrderCategory();
					        		  if(lstOrderCategory != null)
					        		  {
					        			  nOrderCatCount = lstOrderCategory.size();
					        			  if(nOrderCatCount > 0)
					        			  {
					        				  int nLoopCount = 0;
					        				  for(nLoopCount = 0 ; nLoopCount < nOrderCatCount; nLoopCount ++)
					        				  {
					        					  oCategoryHO = lstOrderCategory.get(nLoopCount);
					        					  if(oCategoryHO != null)
					        					  {
					        						 
					        						  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(oCategoryHO.getOrderCategory() ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oCategoryHO.getShortDescription() ));
            _bw.write(_wl_block4Bytes, _wl_block4);
 
					        					  }
					        				  }
					        			  }
					        		  }
					        	  }
					         }
					         catch(Exception e)
					         {
					        	 e.printStackTrace();
					        	 out.println(e.toString());
					         }
					         
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( patientClass ));
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
