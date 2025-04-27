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

public final class __ticksheetsectionitems extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/TickSheetSectionItems.jsp", 1709118032802L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>Insert title here</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/iPadOrder.css\" />\n</head>\n<script>\nfunction getOrderContents()\n{\n\n}\nfunction Loading()\n{\n\tvar catalogCode = window.parent.parent.parent.returnCatalogCode();\n\t//alert(catalogCode);\n\tif(catalogCode != null)\n\t{\n\t\tvar arCount = catalogCode.length;\n\t\tvar i = 0;\n\t\tvar code = \"\";\n\t\tfor(i=0;i<arCount;i++)\n\t\t{\n\t\t\tcode = catalogCode[i];\n\t\t\t//data-orderCatalogCode\n\t\t\tif($(\"[data-orderCatalogCode = \'\" + code + \"\']\") != null)\n\t\t\t $(\"[data-orderCatalogCode = \'\" + code + \"\']\").attr(\'checked\',true);\n\t\t}\n\t}\n\t\n\tcatalogNature =document.getElementById(\"hdnCatalogNature\").value;\n\tif(catalogNature==\"P\")\n\t\t$(\"#panelButton\").removeClass(\'buttonStyle\').addClass(\'buttonHighlight\');\n\telse if(catalogNature==\"A\")\n\t\t$(\"#induvidualButton\").removeClass(\'buttonStyle\').addClass(\'buttonHighlight\');\n\telse if(catalogNature==\"S\")\n\t\t$(\"#orderSetButton\").removeClass(\'buttonStyle\').addClass(\'buttonHighlight\');\n}\nfunction filterOrderContents(catalogNature)\n{\n   document.getElementById(\"hdnPostBack\").value = \"true\";\n   document.getElementById(\"hdnCatalogNature\").value = catalogNature;\n   document.getElementById(\"frmSectionItems\").submit();\n}\nfunction addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId)\n{\n\tvar promptMsg = $(obj).attr(\'data-promptMsg\');\n\tif(promptMsg != null && promptMsg != \"\" && obj.checked)\n\t{\n\t\talert(promptMsg);\n\t}\n\twindow.parent.parent.parent.addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,obj,orderId);\n}\nfunction deselectCheckBox(orderCatalogCode,orderId)\n{\n\tif($(\"[data-orderCatalogCode = \'\" + orderCatalogCode + \"\']\") != null)\n\t{\n\t\t$(\"[data-orderCatalogCode = \'\" + orderCatalogCode + \"\']\").attr(\'checked\',false);\n\t}\n}\n</script>\n<body onload = \"Loading()\">\n\t<section data-role = \"page\" style = \"padding:0px;background-color : #ffffff\">\n\t\t <form id = \"frmSectionItems\" method = \"post\" >\n\t\t \t<div data-role = \"none\" class =\'divTickSheetmain\' id = \'dvmain\'  style=\"padding:0px\">\n\t\t \t    \n\t\t \t\t\n\t\t \t \t<div id=\"resultPageHeader\"  class=\"resultPageHeader\">\n\t\t\t\t\t<table style=\"height: 100%; width: 100%\" cellpadding=\"0\"\n\t\t\t\t\t\tcellspacing=\"0\" border=\"0\">\n\t\t\t\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t\t\t\t<td style=\"width: 38%\"><span class=\"resultTextStyle\">\n\t\t\t\t\t\t\t</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 20%\" align=\"right\" valign=\"center\"><input\n\t\t\t\t\t\t\t\ttype=\"button\" value=\"Panel\" data-role = \"none\" class=\"buttonStyle\" id=\"panelButton\" onclick = \"filterOrderContents(\'P\')\"/></td>\n\t\t\t\t\t\t\t<td style=\"width: 20%\" align=\"right\" valign=\"center\"><input\n\t\t\t\t\t\t\t\ttype=\"button\" value=\"Individual\" data-role = \"none\" class=\"buttonStyle\" id=\"induvidualButton\" onclick = \"filterOrderContents(\'A\')\"/></td>\n\t\t\t\t\t\t\t<td style=\"width: 20%\" align=\"right\" valign=\"center\"><input\n\t\t\t\t\t\t\t\ttype=\"button\" value=\"Order Set\" data-role = \"none\" class=\"buttonStyle\" id=\"orderSetButton\" onclick = \"filterOrderContents(\'S\')\"/></td>\n\t\t\t\t\t\t\t <td style=\"width: 2%\">&nbsp;</td>\n\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<div id = \"sectionItems\" data-role = \"none\" class = \"dvsecItems\">\n\t\t\t\t ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t\t\t\t  \t <table class = \"tbSearchResults\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <td align = \"center\" valign = \"center\" style = \"height : 100%;width:10%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t      <input type = \"checkbox\" data-role = \"none\" class = \"chkBox\" id = \"chkBox";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" data-promptMsg = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" data-catalogNature = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" data-currentCatlogNatue = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" data-orderId = \"\" data-orderCatalogCode = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" name = \"chkBox";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" onclick = \"addToSaveArea(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',this,\'\')\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    <td align = \"left\" valign = \"center\" style = \"height : 100%;width:90%;word-break:break-all\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t<span class = \"spanResultContent\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t  <tr>\n\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t    \t\t\t\t     ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t    \t\t\t\t  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t \t</div>\n\t\t \t<input type = \"hidden\" id = \"hdnPostBack\" name = \"hdnPostBack\" value = \"false\" />\n\t\t \t<input type = \"hidden\" id = \"hdnPatientClass\" name = \"hdnPatientClass\"  value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnOrderCategory\" name = \"hdnOrderCategory\" value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\t\t\n\t\t \t<input type = \"hidden\" id = \"hdnCatalogNature\" name = \"hdnCatalogNature\" value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnTickSheetId\" name = \"hdnTickSheetId\" value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnSectionCode\" name = \"hdnSectionCode\" value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/>\n\t\t \t<input type = \"hidden\" id = \"hdnEncounterId\" name = \"hdnEncounterId\" value = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>\n\t\t \t\n\t\t \t\n\t\t \t\n\t\t </form>\n\t  \n\t</section>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
String sectionCode = "";
String tickSheetId = "";
String orderCategory = "";
String orderCatalogNature = "P";
String encounterId = "";
boolean bPostBack = false;
if(request.getParameter("patientclass") != null)
{
	 patientClass = request.getParameter("patientclass");
}
if(request.getParameter("ordercategory") != null)
{
	orderCategory = request.getParameter("ordercategory");
}
if(request.getParameter("ticksheetid") != null)
{
	 tickSheetId = request.getParameter("ticksheetid");
}
if(request.getParameter("sectioncode") != null)
{
	sectionCode = request.getParameter("sectioncode");
}
if(request.getParameter("hdnPostBack") != null && request.getParameter("hdnPostBack").trim().equals("true"))
{
	bPostBack = true;
}

if(bPostBack)
{
	if(request.getParameter("hdnPatientClass") != null)
	{
		 patientClass = request.getParameter("hdnPatientClass");
	}
	if(request.getParameter("hdnOrderCategory") != null)
	{
		orderCategory = request.getParameter("hdnOrderCategory");
	}
	if(request.getParameter("hdnTickSheetId") != null)
	{
		 tickSheetId = request.getParameter("hdnTickSheetId");
	}
	if(request.getParameter("hdnSectionCode") != null)
	{
		sectionCode = request.getParameter("hdnSectionCode");
	}
	if(request.getParameter("hdnCatalogNature") != null)
	{
		orderCatalogNature = request.getParameter("hdnCatalogNature");
	}
}
TickSheetItemsReq oTckItmsReq = new TickSheetItemsReq();
oTckItmsReq.setRequest(request);
oTckItmsReq.setLanguageId(locale);
if(session.getValue("practitioner_type") != null )
{
	oTckItmsReq.setPracType((String)session.getValue("practitioner_type"));
}
if(session.getValue("facility_id") != null )
{
	oTckItmsReq.setFacilityID((String)session.getValue("facility_id"));
}
String locnType = (String)session.getValue("LocnType");
if(locnType != null && locnType.equalsIgnoreCase("W"))
{
	locnType = "N";
}
oTckItmsReq.setLocationType(locnType);
oTckItmsReq.setLocationCode((String)session.getValue("LocnCode")); 
oTckItmsReq.setPrivApplicabilityYN("");
if(session.getValue("ca_practitioner_id") != null)
{
	oTckItmsReq.setClinicianID((String)session.getValue("ca_practitioner_id"));
}
if(session.getValue("responsibility_id") != null )
{
	oTckItmsReq.setResponsibilityID((String)session.getValue("responsibility_id"));
}
oTckItmsReq.setTickSheetId(tickSheetId);
oTckItmsReq.setSectionCode(sectionCode);
oTckItmsReq.setPatientClass(patientClass);
oTckItmsReq.setOrderCatalogNature(orderCatalogNature);
oTckItmsReq.setOrderCategory(orderCategory);
if(session.getValue("EpisodeId") != null )
{
	oTckItmsReq.setEncounterID((String)session.getValue("EpisodeId"));
	encounterId = (String)session.getValue("EpisodeId");
}
if(session.getValue("Gender") != null )
{
	oTckItmsReq.setGender((String)session.getValue("Gender"));
}
if(session.getValue("DOB") != null )
{
	oTckItmsReq.setDOB((String)session.getValue("DOB"));
}
oTckItmsReq.setAdmitDate((String)session.getValue("AdmitDate")); 
oTckItmsReq.setDischargeDateTime((String)session.getValue("DischargeDateTime"));


            _bw.write(_wl_block1Bytes, _wl_block1);

				  TickSheetItemRes oTckSecItemRes = null;
				  List<TickSheetItemHO> lstTickSheetItem = null;
				  int nLoopCount = 0;
				  int nLstCount = 0;
				  TickSheetItemHO oTckItemHO = null;
				  String promptYN = "";
			      String promptMsg = "";
			      
				  SelectOrderDetails oSelectOrderDetails = new SelectOrderDetails();
				  try
				  {
					  oTckSecItemRes = oSelectOrderDetails.getTickSheetSectionItems(oTckItmsReq);
					  if(oTckSecItemRes != null)
					  {
						  lstTickSheetItem = oTckSecItemRes.getLstTickSheetItem();
					  }
					  if(lstTickSheetItem != null)
					  {
						  nLstCount = lstTickSheetItem.size();
					  }
					  if(nLstCount > 0)
					  {
						  for(nLoopCount = 0 ; nLoopCount < nLstCount; nLoopCount ++)
						  {
							  oTckItemHO = lstTickSheetItem.get(nLoopCount);
							  if(oTckItemHO != null)
							  {
								  	 promptYN = oTckItemHO.getPromptAlertYN();
	    							 if(promptYN != null && promptYN.equalsIgnoreCase("Y"))
	    							 {
	    								 promptMsg = oTckItemHO.getPromptMsg();
	    							 }
	    							 else
	    							 {
	    								 promptMsg = "";
	    							 }
								  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( promptMsg ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oTckItemHO.getOrderCatalogNature()));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(orderCatalogNature ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( oTckItemHO.getOrderCatalogCode()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(nLoopCount));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( oTckItemHO.getOrderCatalogCode()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oTckItemHO.getCatalogSynonym()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( oTckItemHO.getCatalogSynonym()));
            _bw.write(_wl_block11Bytes, _wl_block11);
 
							  }
						  }
					  }//lstcount > 0
					  else
	    			  {
	    				  
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block13Bytes, _wl_block13);
 
	    			  }
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
					  out.println(e.toString());
				  }
				 
						 
				 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(orderCategory));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orderCatalogNature));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tickSheetId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(encounterId));
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
