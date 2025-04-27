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

public final class __searchorder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/SearchOrder.jsp", 1709118031974L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>Insert title here</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script type=\"text/javascript\" src=\"../jquery-1.5.2.min.js\"></script>  \n<script type=\"text/javascript\" src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/iPadOrder.css\" />\n</head>\n<script>\nfunction changeOrientation(orient)\n{\n\tif(orient == \"landscape\")\n\t  {\n\t//\t\n\t  }\n  else\n\t  {\n\n\t  }\n}\nfunction getOrderContents()\n{\n\tdocument.getElementById(\"hdnCriteriaCombo\").value = document.getElementById(\"cmbOrdCriteria\").value;\n\tdocument.getElementById(\"hdnPostBack\").value = \"true\";\n\tdocument.getElementById(\"hdnCatalogNature\").value = \"P\";\n\tdocument.getElementById(\"frmSearchOrder\").submit();\n}\nfunction deselectCheckBox(orderCatalogCode,orderId)\n{\n\tif($(\"[data-orderCatalogCode = \'\" + orderCatalogCode + \"\']\") != null)\n\t{\n\t\t$(\"[data-orderCatalogCode = \'\" + orderCatalogCode + \"\']\").attr(\'checked\',false);\n\t}\n\t\t// $(\"[data-orderCatalogCode = \'\" + orderCatalogCode + \"\']\").removeAttr(\'checked\');\n}\nfunction Loading()\n{\n\tdocument.getElementById(\"cmbOrderCategory\").value = document.getElementById(\"hdnOrderCategory\").value;\n\tdocument.getElementById(\"cmbOrdCriteria\").value = document.getElementById(\"hdnCriteriaCombo\").value;\n\tdocument.getElementById(\"cmbOrderType\").value = document.getElementById(\"hdnOrderType\").value;\n\tvar catalogCode = window.parent.returnCatalogCode();\n\t//alert(\"searchOrder\");\n\t//alert(catalogCode);\n\tif(catalogCode != null)\n\t{\n\t\tvar arCount = catalogCode.length;\n\t\t//alert(arCount);\n\t\tvar i = 0;\n\t\tvar code = \"\";\n\t\tfor(i=0;i<arCount;i++)\n\t\t{\n\t\t\tcode = catalogCode[i];\n\t\t\t//data-orderCatalogCode\n\t\t\tif($(\"[data-orderCatalogCode = \'\" + code + \"\']\") != null)\n\t\t\t $(\"[data-orderCatalogCode = \'\" + code + \"\']\").attr(\'checked\',true);\n\t\t}\n\t}\n\t\n\tcatalogNature = document.getElementById(\"hdnCatalogNature\").value;\n\tpostBack = document.getElementById(\"hdnPostBack\").value;\n\tif(catalogNature==\"P\")\n\t\t$(\"#panelButton\").removeClass(\'buttonStyle\').addClass(\'buttonHighlight\');\n\telse if(catalogNature==\"A\")\n\t\t$(\"#induvidualButton\").removeClass(\'buttonStyle\').addClass(\'buttonHighlight\');\n\telse if(catalogNature==\"S\")\n\t\t$(\"#orderSetButton\").removeClass(\'buttonStyle\').addClass(\'buttonHighlight\');\n\t\n}\nfunction filterOrderContents(catalogNature)\n{\n\tdocument.getElementById(\"hdnCatalogNature\").value = catalogNature;\n\tdocument.getElementById(\"hdnPostBack\").value = \"true\";\n\tdocument.getElementById(\"frmSearchOrder\").submit();\n}\nfunction populateOrderType()\n{\n\tdocument.getElementById(\"hdnPopOrderType\").value = \"true\";\n\tdocument.getElementById(\"hdnPostBack\").value = \"true\";\n\tdocument.getElementById(\"frmSearchOrder\").submit();\n}\nfunction addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId)\n{\n\tvar promptMsg = $(obj).attr(\'data-promptMsg\');\n\tif(promptMsg != null && promptMsg != \"\" && obj.checked)\n\t{\n\t\talert(promptMsg);\n\t}\n\twindow.parent.addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId);\n}\n$(document).ready(function () {\n\t//window.parent.setAlignment();\n});\n</script>\n<body onload = \"Loading()\">\n\t<section data-role = \"page\" style = \"padding:0px;background-color : #ffffff\">\n\t\t <form id = \"frmSearchOrder\" method = \"post\" >\n\t\t \t<div data-role = \"none\" class =\'divmain\' id = \'dvmain\'  style=\"padding:0px\">\n\t\t \t    <div id=\"searchPageHeader\"  class=\"resultPageHeader\">\n\t\t\t\t\t<table style=\"height: 100%; width: 100%\" cellpadding=\"0\"\n\t\t\t\t\t\tcellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t\t\t\t<td style=\"width: 90%\"><span class=\"resultTextStyle\">\n\t\t\t\t\t\t\tSearch</span></td>\n\t\t\t\t\t\t\t <td style=\"width: 10%\">&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t \t\t<div id = \"dvCriteria\" class = \"dvCriteria\">\n\t\t \t\t    <table style=\"height:auto;width:100%\" >\n\t\t\t\t \t\t <tr style = \"height:auto;width:100%\">\n\t\t\t\t \t\t   <td style = \"height:auto;width:90%\">\n\t\t\t\t \t\t     <table style=\"height:65px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t \t\t\t  <tr style=\"height:30px;width:100%\">\n\t\t \t\t\t    <td align = \"left\" style=\"width:33%\" valign = \"center\"><span class = \"spanPeriod\">Order Category</span></td>\n\t\t\t\t        <td align = \"left\" style=\"width:33%\" valign = \"center\"><span class = \"spanPeriod\">OrderType</span></td>  \n\t\t\t\t        <td align = \"left\" style=\"width:33%\" valign = \"center\" ><span class = \"spanPeriod\">Search Criteria</span></td> \n\t\t\t\t        \n\t\t \t\t\t  <tr>\n\t\t \t\t\t \n\t\t \t\t\t  \n\t\t \t\t\t  <tr style=\"height:35px;width:100%\">\n\t\t \t\t\t     <td align = \"left\" style=\"width:33%\">\n\t\t\t\t\t        <select  class=\"cmbPeriod\" data-role=\"none\" id=\"cmbOrderCategory\" name = \"cmbOrderCategory\" onchange = \"populateOrderType()\"> \n\t\t\t\t\t          <option value = \"\">Select</option>\n\t\t\t\t\t         ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t        \t\t\t\t\t\t   <option value = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" > ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</option>\n\t\t\t\t\t        \t\t\t\t\t\t  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\t\t\t\t\t\t\t</select> \n\t\t\t            </td>\n\t\t\t            <td align = \"left\" style=\"width:33%\">\n\t\t\t\t\t        <select  class=\"cmbPeriod\" data-role=\"none\" id=\"cmbOrderType\" name = \"cmbOrderType\"> \n\t\t\t\t\t        <option value = \"\">Select</option>\n\t\t\t\t\t         ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t        \t\t\t\t\t\t\t   <option value = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</option>\n\t\t\t\t\t        \t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t</select> \n\t\t\t            </td>\n\t\t\t            <td align = \"left\" style=\"width:33%\">\n\t\t\t              <table style = \"width:100%;height:100%;margin-left : 7%\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t                 <tr style = \"width:100%;height:100%\">\n\t\t\t                   <td style = \"width:50%;height:100%\" align = \"left\">\n\t\t\t                    <input type = \"text\" data-role = \"none\"  class = \"tbPatCriteria\" id = \"txtCriteria\" name = \"txtCriteria\" value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n\t\t\t                   </td>\n\t\t\t                   \n\t\t\t                   <td style = \"width:50%;height:100%\">\n\t\t\t                       <select  class=\"cmbOrdCriteria\" data-role=\"none\" id=\"cmbOrdCriteria\" name = \"cmbOrdCriteria\"> \n\t\t\t\t\t\t\t         <option value = \"S\">Starts</option> \n\t\t\t\t                     <option value = \"C\">Contains</option>  \n\t\t\t\t\t\t\t         <option value = \"E\">Ends</option> \n\t\t\t\t\t\t\t      </select>\n\t\t\t                   </td>\n\t\t\t                 </tr>\n\t\t\t              </table>\n\t\t\t                \n\t\t\t\t\t        \n\t\t\t            </td>\n\t\t\t           \n\t\t\t             \n\t\t \t\t\t  </tr>\n\t\t \t\t\t\n\t\t \t\t\t</table>\n\t\t\t\t \t\t   </td>\n\t\t\t\t \t\t   <td align = \"center\" vaalign = \"center\" style=\"width:10%\" onclick = \"getOrderContents()\" ><img src = \"../images/SearchOrder.PNG\"></img>\n\t\t\t\t \t\t   </td>\n\t\t\t\t \t\t </tr>\n\t\t\t \t\t </table>\n\t\t \t\t\t\n\t\t \t\t</div>\n\t\t \t \t<div id=\"resultPageHeader\"  class=\"resultPageHeader\">\n\t\t\t\t\t<table style=\"height: 100%; width: 100%\" cellpadding=\"0\"\n\t\t\t\t\t\tcellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t\t\t\t<td style=\"width: 50%\"><span class=\"resultTextStyle\">\n\t\t\t\t\t\t\tResults</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 16%\" align=\"right\" valign=\"center\"><input\n\t\t\t\t\t\t\t\ttype=\"button\" value=\"Panel\" data-role = \"none\" class=\"buttonStyle\" id=\"panelButton\" onclick = \"filterOrderContents(\'P\')\"/></td>\n\t\t\t\t\t\t\t<td style=\"width: 16%\" align=\"right\" valign=\"center\"><input\n\t\t\t\t\t\t\t\ttype=\"button\" value=\"Individual\" data-role = \"none\" class=\"buttonStyle\" id=\"induvidualButton\" onclick = \"filterOrderContents(\'A\')\"/></td>\n\t\t\t\t\t\t\t<td style=\"width: 16%\" align=\"right\" valign=\"center\"><input\n\t\t\t\t\t\t\t\ttype=\"button\" value=\"Order Set\" data-role = \"none\" class=\"buttonStyle\" id=\"orderSetButton\" onclick = \"filterOrderContents(\'S\')\"/></td>\n\t\t\t\t\t\t\t <td style=\"width: 2%\">&nbsp;</td>\n\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<div id = \"serachResults\" data-role = \"none\" class = \"dvSearchResults\">\n\t\t\t\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t    \t\t\t\t\t\t\t <table class = \"tbSearchResults\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <td align = \"center\" valign = \"center\" style = \"height : 100%;width:10%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t      <input type = \"checkbox\" data-role = \"none\" class = \"chkBox\" id = \"chkBox";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" data-promptMsg = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" data-catalogNature = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" data-currentCatlogNatue = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" data-orderId = \"\" data-orderCatalogCode = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" name = \"chkBox";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onclick = \"addToSaveArea(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',this,\'\')\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <td align = \"left\" valign = \"center\" style = \"height : 100%;width:90%;word-break:break-all\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t<span class = \"spanResultContent\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t    \t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t    \t\t\t\t     ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t    \t\t\t\t  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t \t</div>\n\t\t \t<input type = \"hidden\" id = \"hdnPostBack\" name = \"hdnPostBack\" value = \"false\" />\n\t\t \t<input type = \"hidden\" id = \"srchBotton\" name = \"srchButton\" value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnPatientClass\" name = \"hdnPatientClass\" value = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" />\n\t\t \t<input type = \"hidden\" id = \"hdnOrderCategory\" name = \"hdnOrderCategory\" value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnOrderType\" name = \"hdnOrderType\" value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnCriteriaText\" name = \"hdnCriteriaText\" />\n\t\t \t<input type = \"hidden\" id = \"hdnCriteriaCombo\" name = \"hdnCriteriaCombo\" value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnCatalogNature\" name = \"hdnCatalogNature\" value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnPopOrderType\" name = \"hdnPopOrderType\" value = \"false\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnEncounterId\" name = \"hdnEncounterId\" value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"/>\n\t\t </form>\n\t  \n\t</section>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
oCategoryReq.setCalledFrom("ALL");
OrderCategoryResponse oCategoryRes = null;
List<OrderCategoryHO> lstOrderCategory = new ArrayList<OrderCategoryHO>();
SearchOrderRequest oSrchOrderReq = new SearchOrderRequest();

/*
 Creating the request object to get the order contents based on the criteria selected.
*/
String postBack = "";
String criteria = "";
String orderCategory = "";
String orderType = "";
String orderText = "";
String catalogNature = "";
String encounterId = "";
boolean bPopOrderType = false;
if(request.getParameter("hdnPostBack") != null)
{
	postBack = request.getParameter("hdnPostBack");

}
if(session.getValue("EpisodeId") != null )
{
	
	encounterId = (String)session.getValue("EpisodeId");
}
if(request.getParameter("hdnPopOrderType") != null && request.getParameter("hdnPopOrderType").equals("true"))
{
	bPopOrderType = true;
	
	if(request.getParameter("cmbOrderCategory") != null)
	{
		orderCategory = request.getParameter("cmbOrderCategory");
	}
	if(request.getParameter("cmbOrderType") != null)
	{
		orderType = request.getParameter("cmbOrderType");
	}
	
	
}

if(postBack != null && postBack.equals("true") && !bPopOrderType)
{
	catalogNature = "P";
	oSrchOrderReq.setRequest(request);
	if(request.getParameter("hdnPatientClass") != null && !request.getParameter("hdnPatientClass").equals(""))
	{
		patientClass = request.getParameter("hdnPatientClass");
	}
	if(request.getParameter("txtCriteria") != null)
	{
		orderText = request.getParameter("txtCriteria");
	}
	if(request.getParameter("cmbOrderCategory") != null)
	{
		orderCategory = request.getParameter("cmbOrderCategory");
	}
	if(request.getParameter("cmbOrdCriteria") != null)
	{
		criteria = request.getParameter("cmbOrdCriteria");
	}
	if(request.getParameter("hdnCatalogNature") != null)
	{
		catalogNature = request.getParameter("hdnCatalogNature");
	}
	if(request.getParameter("cmbOrderType") != null)
	{
		orderType = request.getParameter("cmbOrderType");
	}
	if(session.getValue("PatientID") != null)
	{
		oSrchOrderReq.setPatientId((String)session.getValue("PatientID"));
	}
	if(session.getValue("EpisodeId") != null )
	{
		oSrchOrderReq.setEncounterId((String)session.getValue("EpisodeId"));
	}
	if(session.getValue("facility_id") != null )
	{
		oSrchOrderReq.setFacilityId((String)session.getValue("facility_id"));
	}
	oSrchOrderReq.setPatientClass(patientClass);
	if(session.getValue("ca_practitioner_id") != null)
	{
		oSrchOrderReq.setClinicianId((String)session.getValue("ca_practitioner_id"));
	}
	if(session.getValue("practitioner_type") != null )
	{
		oSrchOrderReq.setPractionerType((String)session.getValue("practitioner_type"));
	}
	if(session.getValue("responsibility_id") != null )
	{
		oSrchOrderReq.setResponisibilityId((String)session.getValue("responsibility_id"));
	}
	oSrchOrderReq.setLanguageId(locale);
	if(session.getValue("Gender") != null )
	{
		oSrchOrderReq.setGender((String)session.getValue("Gender"));
	}
	if(session.getValue("DOB") != null )
	{
		oSrchOrderReq.setDOB((String)session.getValue("DOB"));
	}
	oSrchOrderReq.setAdmitDate((String)session.getValue("AdmitDate")); 
	oSrchOrderReq.setServicecode((String)session.getValue("ServiceCode")); 
	oSrchOrderReq.setDischargeDateTime((String)session.getValue("DischargeDateTime")); 
	oSrchOrderReq.setLocationCode((String)session.getValue("LocnCode")); 
	String locnType = (String)session.getValue("LocnType");
	if(locnType != null && locnType.equalsIgnoreCase("W"))
	{
		locnType = "N";
	}
	oSrchOrderReq.setLocationType(locnType);
	oSrchOrderReq.setOrderType(orderType);
	oSrchOrderReq.setOrderCategory(orderCategory);
	oSrchOrderReq.setOrderText(orderText);
	oSrchOrderReq.setCriteria(criteria);
	oSrchOrderReq.setOrderCatalogNature(catalogNature);
	oSrchOrderReq.setRestrictBy("N");
	
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

					           if(postBack != null && postBack.equals("true") && orderCategory != null && !orderCategory.equals(""))
					           {
					        	   int nOrderTypeCount = 0;
					        	   OrderTypeResponse oRes = null;
					        	   int nLoopCount = 0;
					        	   List<OrderTypeHO> lstOrderType = null ;
					        	   OrderTypeHO oTypeHO = null;
					        	   try
					        	   {
					        		   oRes = oSelectOrderDetails.getOrderType(orderCategory, locale, request);
					        		   if(oRes != null)
					        		   {
					        			   lstOrderType = oRes.getLstOrderType();
					        			   if(lstOrderType != null)
					        			   {
					        				   nOrderTypeCount = lstOrderType.size();
					        				   if(nOrderTypeCount > 0)
					        				   {
					        					   for(nLoopCount = 0 ; nLoopCount < nOrderTypeCount; nLoopCount ++)
					        					   {
					        						   oTypeHO = lstOrderType.get(nLoopCount);
					        						   if(oTypeHO != null)
					        						   {
					        							   
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oTypeHO.getCode()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oTypeHO.getDescription()));
            _bw.write(_wl_block9Bytes, _wl_block9);
 
					        						   }
					        					   }
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
					         
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(orderText));
            _bw.write(_wl_block11Bytes, _wl_block11);

				     if(postBack != null && postBack.equals("true") && !bPopOrderType)
				     {
				    	 SearchOrderResponse oSrchOrderRes = null;
				    	 String dischargeAdviceTime = "";
				    	 List<SearchOrderHO> lstSrchOrderHO =  new ArrayList<SearchOrderHO>();
				    	 SearchOrderHO oSrchOrderHO = new SearchOrderHO();
				    	 int nOrderContentCount = 0;
				    	 int nLoopCount = 0;
				    	 String promptYN = "";
				    	 String promptMsg = "";
				    	 try{
				    		 if(oSrchOrderReq != null)
				    		 {
				    			 dischargeAdviceTime = oSelectOrderDetails.getDischargeAdvDateTime(oSrchOrderReq.getPatientId(), oSrchOrderReq.getEncounterId(), request);
				    			 oSrchOrderReq.setDischargeAdviceDateTime(dischargeAdviceTime);
				    			 oSrchOrderRes = oSelectOrderDetails.getSearchOrderDetails(oSrchOrderReq);
				    			 if( oSrchOrderRes != null)
				    			 {
				    				 lstSrchOrderHO = oSrchOrderRes.getLstSrchOrderHO();
				    			 }
				    			 if(lstSrchOrderHO != null)
				    			 {
				    				 nOrderContentCount = lstSrchOrderHO.size();
				    				 if(nOrderContentCount > 0)
				    				 {
				    					 for(nLoopCount = 0 ; nLoopCount < nOrderContentCount; nLoopCount ++)
				    					 {
				    						 oSrchOrderHO = lstSrchOrderHO.get(nLoopCount);
				    						 if(oSrchOrderHO != null)
				    						 {
				    							 promptYN = oSrchOrderHO.getPromptAlertYN();
				    							 if(promptYN != null && promptYN.equalsIgnoreCase("Y"))
				    							 {
				    								 promptMsg = oSrchOrderHO.getPromptMsg();
				    							 }
				    							 else
				    							 {
				    								 promptMsg = "";
				    							 }
				    							 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( promptMsg ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oSrchOrderHO.getGroupName()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(catalogNature ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( oSrchOrderHO.getOrderCatalogCode()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( oSrchOrderHO.getOrderCatalogCode()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( oSrchOrderHO.getCatalogSynonym()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( oSrchOrderHO.getCatalogSynonym()));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
				    						 }
				    					 }
				    				 }//if count > 0
				    				 else
					    			  {
					    				  
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
					    			  }
				    			 }//end if lstcount
				    			 
				    		 }
				    		 
				    	 }
				    	 catch(Exception e)
				    	 {
				    		 e.printStackTrace();
				    		 out.print(e.toString());
				    	 }
				     }
				  
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(catalogNature));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patientClass ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(orderCategory));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(orderType));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(criteria));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(catalogNature));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
