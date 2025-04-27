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

public final class __existingorders extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/ExistingOrders.jsp", 1709118026349L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>Existing Orders</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />\n<script src=\"../jquery-1.5.2.min.js\"></script>\n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<link rel=\"stylesheet\" href=\"../css/iPadOrder.css\" />\n\n<script type=\"text/javascript\">\nfunction changeOrientation(orient)\n{\n\n}\nfunction getOrderContents()\n{\n\tdocument.getElementById(\"hdnOrderPeriod\").value = document.getElementById(\"cmbPeriod\").value;\n\tdocument.getElementById(\"hdnViewEncounter\").value = document.getElementById(\"cmbCurrentEncounter\").value;\n\tdocument.getElementById(\"hdnPostBack\").value = \"true\";\n\tdocument.getElementById(\"frmExistingOrder\").submit();\n}\n\n\nfunction deselectCheckBox(orderCatalogCode,orderId)\n{\n\tif($(\"[data-orderId = \'\" + orderId + \"\']\") != null)\n\t{\n\t\t$(\"[data-orderId = \'\" + orderId + \"\']\").attr(\'checked\',false);\n\t}\n\t\t// $(\"[data-orderCatalogCode = \'\" + orderCatalogCode + \"\']\").removeAttr(\'checked\');\n}\n\nfunction Loading()\n{\n\t//document.getElementById(\"cmbOrderCategory\").value = document.getElementById(\"hdnOrderCategory\").value;\n\t//document.getElementById(\"cmbOrdCriteria\").value = document.getElementById(\"hdnCriteriaCombo\").value;\n\t//document.getElementById(\"cmbOrderType\").value = document.getElementById(\"hdnOrderType\").value;\n\t//var catalogCode = window.parent.returnCatalogCode();\n\t//alert(catalogCode);\n\tdocument.getElementById(\"cmbPeriod\").value = document.getElementById(\"hdnOrderPeriod\").value;\n\tdocument.getElementById(\"cmbCurrentEncounter\").value = document.getElementById(\"hdnViewEncounter\").value;\n\tvar arOrderId = window.parent.returnOrderId();\n\tif(arOrderId != null)\n\t{\n\t\tvar arCount = arOrderId.length;\n\t\t//alert(arCount);\n\t\tvar i = 0;\n\t\tvar code = \"\";\n\t\tfor(i=0;i<arCount;i++)\n\t\t{\n\t\t\tcode = arOrderId[i];\n\t\t\t//data-orderCatalogCode\n\t\t\tif($(\"[data-orderId = \'\" + code + \"\']\") != null)\n\t\t\t $(\"[data-orderId = \'\" + code + \"\']\").attr(\'checked\',true);\n\t\t}\n\t}\n\t\n}\n\n function showCriteria()\n {\n\t $(\'#divSrchCriteria\').slideToggle(\'fast\');\n\t if(bShCriteria)\n\t   {\n\t\t        bShCriteria = true;\n\t\t\t   document.getElementById(\"imgCriteria\").src = \"../images/Heading-Panel-down-Arrow.png\" ;\n\t   }\n\t   else\n\t   {\n\t\t       bShCriteria = false;\n\t\t\t   document.getElementById(\"imgCriteria\").src = \"../images/Heading-Panel-Up-Arrow.png\" ;\n\t   }\n }\n function addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId)\n {\n \twindow.parent.addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId);\n }\n $(document).ready(function () {\n \t//window.parent.setAlignment();\n });\n </script>\n </head>\n <body onload = \"Loading()\" >\n  <section  data-role=\"page\"  style=\"padding:0px;\" background-color : #ffffff\">\n  <form name=\'frmExistingOrder\' id=\'frmExistingOrder\' method=\'post\' id=\"frmExistingOrder\" >\n  <div data-role = \"none\" class =\'divmain\' id = \'dvmain\'  style=\"padding:0px\">\n\t  <div id = \"searchPageHeader\"   class=\"resultPageHeader\" >\n\t\t <table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  <tr style = \"height:100%;width:100%\">\n\t\t\t    <td style = \"width:95%\">\n\t\t\t         <span class = \"resultTextStyle\">Search</span>\n\t\t\t    </td>\n\t\t\t    <td style = \"width:5%\" align = \"center\" valign = \"center\">\n\t\t\t       \n\t\t\t    </td>\n\n\n\t\t\t  </tr>\n\t\t    </table>\n\n\t  </div>\n\t   <div class = \"dvStroke\" data-role =\"none\"></div>\n\n\t  <div id=\"divSrchCriteria\"  data-role =\"none\" class = \"dvCriteria\">\n\t   \t\t \t\t    <table style=\"height:auto;width:100%\" >\n\t\t\t\t \t\t <tr style = \"height:auto;width:100%\">\n\t\t\t\t \t\t   <td style = \"height:auto;width:90%\">\n\t\t   <table style=\"height:65px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\n\t\t\t     <tr style=\"height:30px;width:100%\">\n\t\t\t      <td align = \"left\" style=\"width:25%\"><span class = \"spanPeriod\">View</span></td>\n\t\t\t      <td align = \"left\" style=\"width:25%\"><span class = \"spanPeriod\">Order Category</span></td>\n\t\t\t      <td align = \"left\" style=\"width:25%\"><span class = \"spanPeriod\">Period</span></td>\n\t\t\t      <td style=\"width:1%\">&nbsp;</td>\n\t\t\t     </tr>\n\t\t\t     <tr style=\"height:35px;width:100%\">\n\t\t\t      <td align = \"left\" style=\"width:25%\">\n\t\t\t\t\t<select  class=\"cmbPeriod\" data-role=\"none\" id=\"cmbCurrentEncounter\" name = \"cmbCurrentEncounter\">\n\t\t\t\t\t  <option value = \"CUR\">Current Encounter Orders</option>\n\t\t\t\t\t  <option value = \"ALL\">All Encounter Orders</option>\n\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t      <td align = \"left\" style=\"width:25%\">\n\t\t\t\t  <select  class=\"cmbPeriod\" data-role=\"none\" id=\"cmbOrderCategory\" name = \"cmbOrderCategory\">\n\t\t\t\t\t  <option value=\"\">Select</option>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t        \t\t\t\t\t\t   <option value = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" > ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</option>\n\t\t\t\t\t        \t\t\t\t\t\t  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t      <td align = \"left\" style=\"width:25%\">\n\t\t\t\t\t<select  class=\"cmbPeriod\" data-role=\"none\" id=\"cmbPeriod\" name = \"cmbPeriod\">\n\t\t\t\t\t  <option value = \"OD\">Last One Day</option>\n\t\t\t\t\t  <option value = \"TD\">Last Three Days</option>\n\t\t\t\t\t  <option value = \"OW\">Last One Week</option>\n\t\t\t\t\t  <option value = \"OM\">Last One Month</option>\n\t\t\t\t\t  <option value = \"OY\">Last One Year</option>\n\t\t\t\t\t</select>\n\t\t\t\t  </td>\n\n\n\t\t\t            </tr>\n\n\n\t\t\t\t\t  </table>\n\n\t\t\t\t\t</td>\n\t\t\t\t \t\t   <td align = \"center\" vaalign = \"center\" style=\"width:10%\" onclick = \"getOrderContents()\" ><img src = \"../images/SearchOrder.PNG\"></img>\n\t\t\t\t \t\t   </td>\n\t\t\t\t \t\t </tr>\n\t\t\t \t\t </table>\n\t   </div>\n\n\t\t\t\t<div id=\"resultPageHeader\"  class=\"resultPageHeader\">\n\t\t\t\t\t<table style=\"height: 100%; width: 100%\" cellpadding=\"0\"\n\t\t\t\t\t\tcellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t\t\t\t<td style=\"width: 7%\" align = \"center\" valign = \"center\"></td>\n\t\t\t\t\t\t\t<td style=\"width: 24%\" align = \"left\" valign = \"center\"><span class=\"resultTextStyleExisting\">\n\t\t\t\t\t\t\tOrder Catalog</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 17%\" align = \"center\" valign = \"center\"><span class=\"resultTextStyleExisting\">\n\t\t\t\t\t\t\tStart Date</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 19%\" align = \"center\" valign = \"center\"><span class=\"resultTextStyleExisting\">\n\t\t\t\t\t\t\tEnd Date</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 16%\" align = \"center\" valign = \"center\"><span class=\"resultTextStyleExisting\">\n\t\t\t\t\t\t\tOrder Type</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 17%\" align = \"center\" valign = \"center\"><span class=\"resultTextStyleExisting\">\n\t\t\t\t\t\t\tStatus</span></td>\n\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t\t\t<div id = \"searchResults\" data-role = \"none\" class = \"dvSearchResults\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t    \t\t\t\t\t\t\t <table class = \"tbSearchResults\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <td align = \"center\" valign = \"center\" style = \"height : 100%;width:7%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t      <input type = \"checkbox\" data-role = \"none\" class = \"chkBox\" id = \"chkBox";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" data-catalogNature = \"\" data-currentCatlogNatue = \"\" data-orderId = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  data-orderCatalogCode = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  \n\t\t\t\t\t\t\t\t\t\t\t\t\t      onclick = \"addToSaveArea(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',this,\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\" name = \"chkBox";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <td align = \"left\" valign = \"center\" style = \"height : 100%;width:24%;word-break:break-all\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t<span class = \"spanResultContentExisting\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align = \"center\" valign = \"center\" style = \"height : 100%;width:17%\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class = \"spanResultContentExisting\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align = \"center\" valign = \"center\" style = \"height : 100%;width:19%\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class = \"spanResultContentExisting\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align = \"center\" valign = \"center\" style = \"height : 100%;width:16%;word-break:break-all\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class = \"spanResultContentExisting\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align = \"center\" valign = \"center\" style = \"height : 100%;width:17%;word-break:break-all\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class = \"spanResultContentExisting\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t    \t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t    \t\t\t\t     ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t    \t\t\t\t  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<input type = \"hidden\" id = \"hdnPostBack\" name = \"hdnPostBack\" value = \"false\" />\n\t\t\t<input type = \"hidden\" id = \"hdnViewEncounter\" name = \"hdnViewEncounter\" value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnOrderCategory\" name = \"hdnOrderCategory\" value = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n\t\t\t<input type = \"hidden\" id = \"hdnOrderPeriod\" name = \"hdnOrderPeriod\" value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n\n\n\n\t   </form>\n\t   </section>\n\t   </body>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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
String orderPeriod = "";
int dayValue = 1;

OrderCategoryRequest oCategoryReq = new OrderCategoryRequest();
oCategoryReq.setRequest(request);
oCategoryReq.setLanguageID(locale);
oCategoryReq.setCalledFrom("ALL");
OrderCategoryResponse oCategoryRes = null;
List<OrderCategoryHO> lstOrderCategory = new ArrayList<OrderCategoryHO>();
ExistingOrderRequest existingOrderReq = new ExistingOrderRequest();

/*
 Creating the request object to get the order contents based on the criteria selected.
*/
String postBack = "";
String orderCategory = "";
String currentEncounterId = "";
String viewEncounter = "";
String toDate = DateUtils.getCurrentDate("DMY", "en");
String fromDate;
String strInterval = "d";


if(request.getParameter("hdnPostBack") != null)
{
	postBack = request.getParameter("hdnPostBack");

}

if(postBack != null && postBack.equals("true"))
{
	existingOrderReq.setRequest(request);
	existingOrderReq.setSession(session);
	existingOrderReq.setLanguageId(locale);
	if(session.getValue("practitioner_type") != null )
	{
		existingOrderReq.setPracType((String)session.getValue("practitioner_type"));
	}
	if(session.getValue("PatientID") != null)
	{
		existingOrderReq.setPatientId((String)session.getValue("PatientID"));
	}
	

	if(request.getParameter("cmbCurrentEncounter") != null)
	{
		viewEncounter = request.getParameter("cmbCurrentEncounter");
	}
	
	if(session.getValue("EpisodeId") != null && viewEncounter.equals("CUR"))
	{
		existingOrderReq.setEncounterId((String)session.getValue("EpisodeId"));
	}
	
	if(request.getParameter("cmbOrderCategory") != null)
	{
		orderCategory = request.getParameter("cmbOrderCategory");
	}
	if(session.getValue("EpisodeId") != null)
	{
		currentEncounterId = (String)session.getValue("EpisodeId");
	}
	if(request.getParameter("cmbPeriod") != null)
	{
		orderPeriod = request.getParameter("cmbPeriod");
	}

	if(orderPeriod.equals("OW") )
	{
		strInterval = "w";
	}
	if(orderPeriod.equals("OM") )
	{
		strInterval = "M";
	}
	if(orderPeriod.equals("OY") )
	{
		strInterval = "Y";
	}
	if(orderPeriod.equals("OD") )
	{
		strInterval = "d";
	}
	if(orderPeriod.equals("TD") )
	{
		strInterval = "d";
		dayValue = 3;
	}

	fromDate = DateUtils.minusDate(toDate, "DMY", "en", dayValue, strInterval);
	existingOrderReq.setFromDate(fromDate);
	existingOrderReq.setToDate(toDate);
	existingOrderReq.setOrderCategory(orderCategory);

	
}
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
					        						  String selected = "";
					        						  if(oCategoryHO.getOrderCategory() != null && orderCategory != null && oCategoryHO.getOrderCategory().equals(orderCategory))
					        						  {
					        							  selected = "selected";
					        						  }
					        						  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(oCategoryHO.getOrderCategory() ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(selected ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oCategoryHO.getShortDescription() ));
            _bw.write(_wl_block5Bytes, _wl_block5);

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
					         
            _bw.write(_wl_block6Bytes, _wl_block6);

				     if(postBack != null && postBack.equals("true"))
				     {
					 ExistingOrderResponse existingOrderRes = null;

				    	 List<ExistingOrderHO> lstExistingOrderHO =  new ArrayList<ExistingOrderHO>();
				    	 ExistingOrderHO existingOrderHO = new ExistingOrderHO();
				    	 int nOrderContentCount = 0;
				    	 int nLoopCount = 0;
				    	 try{
				    		 if(existingOrderReq != null)
				    		 {

				    			 existingOrderRes = oSelectOrderDetails.getExistingOrder(existingOrderReq);
				    			 if( existingOrderRes != null)
				    			 {
				    				 lstExistingOrderHO = existingOrderRes.getLstExtOrderHO();
				    			 }
				    			 if(lstExistingOrderHO != null)
				    			 {
				    				 nOrderContentCount = lstExistingOrderHO.size();
				    				 if(nOrderContentCount > 0)
				    				 {
				    					 for(nLoopCount = 0 ; nLoopCount < nOrderContentCount; nLoopCount ++)
				    					 {
				    						 existingOrderHO = lstExistingOrderHO.get(nLoopCount);
				    						 if(existingOrderHO != null)
				    						 {
				    							 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( existingOrderHO.getOrderID()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( existingOrderHO.getOrderCatalogCode()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( existingOrderHO.getOrderCatalogCode()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(currentEncounterId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(existingOrderHO.getOrderDetail()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( existingOrderHO.getOrderID()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( existingOrderHO.getOrderDetail()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( existingOrderHO.getStartDate()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( existingOrderHO.getEndDate()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( existingOrderHO.getOrderTypeDesc()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( existingOrderHO.getOrderStatusDesc()));
            _bw.write(_wl_block19Bytes, _wl_block19);

				    						 }
				    					 }
				    				 }
				    				 else
					    			  {
					    				  
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
					    			  }
				    			 }
				    		 }

				    	 }
				    	 catch(Exception e)
				    	 {
				    		 e.printStackTrace();
				    		 out.print(e.toString());
				    	 }
				     }
				  
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(viewEncounter));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(orderCategory));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(orderPeriod));
            _bw.write(_wl_block25Bytes, _wl_block25);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
