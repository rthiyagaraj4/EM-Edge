package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __commonpolicydetailsadd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/CommonPolicyDetailsAdd.jsp", 1709114631351L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eBL/js/CommonPolicyAddTable.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/CommonPolicyDefinition.js\"></script>\n\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction addRowNew(){\n\tvar frm = parent.PolicyDetailsPage.document.forms[0];\n\tvar pageInfo = frm.pageInfo.value;\n\t//alert(\'Befor Crash\')\n\tif(pageInfo == \'inclExclCoverage\'){\n\t\t//alert(\'InclExcl\')\n\t\taddRow(\'InclExcl\')\n\t}\n\telse if(pageInfo == \'preApproval\'){\n\t\t//alert(\'PreApproval\')\n\t\taddRow(\'PreApproval\')\n\t}\n\telse if(pageInfo == \'PreApprovalPopup\'){\n\t\taddRow(\'PreApprovalPopup\')\n\t}\n\t//alert(pageInfo);\n}\n\nfunction save(){\n\t\n\tvar pageFrom = parent.PolicyDetailsPage.document.forms[0].pageInfo.value;\n\tif(pageFrom == \'inclExclCoverage\'){\n\t\tvar table_id = parent.PolicyDetailsPage.document.getElementById(\'PolicyInclExcl\');\n\t\tvar totRows = table_id.rows.length;\n\t\ttotRows = totRows-2;\n\t\tfor(prevIndex=1;prevIndex<=totRows;prevIndex++){\n\t\t\tvar epsdEnc = parent.PolicyDetailsPage.document.getElementById(\"episode_\"+prevIndex).value;\n\t\t\tvar patClass = parent.PolicyDetailsPage.document.getElementById(\"ptClass_\"+prevIndex).value;\n\t\t\tvar ageGroup = parent.PolicyDetailsPage.document.getElementById(\"hdn_age_group_\"+prevIndex).value;\n\t\t\tvar genderCat = parent.PolicyDetailsPage.document.getElementById(\"gender_\"+prevIndex).value;\n\t\t\tvar clinicNurs = parent.PolicyDetailsPage.document.getElementById(\"clinic_\"+prevIndex).value;\n\t\t\tvar clnCode = parent.PolicyDetailsPage.document.getElementById(\"clinic_code_\"+prevIndex).value;\n\t\t\tvar incExcCriteria = parent.PolicyDetailsPage.document.getElementById(\"incExCriteria_\"+prevIndex).value;\n\t\t\tvar effFromDate = parent.PolicyDetailsPage.document.getElementById(\"effFrom_\"+prevIndex).value;\n\t\t\tvar specCode = parent.PolicyDetailsPage.document.getElementById(\"spec_code_\"+prevIndex).value;\n\t\t\tvar prevBillCode  = parent.PolicyDetailsPage.document.getElementById(\"bg_code_\"+prevIndex).value;\n\t\t\tvar delFlagC = parent.PolicyDetailsPage.document.getElementById(\"delFlag\"+prevIndex);\n\t\t\t\n\t\t\tif(!(delFlagC.checked)){\n\t\t\t\tif(epsdEnc.length<1 && patClass.length<1 && ageGroup.length<1 && genderCat.length<1 && clnCode.length<1 && specCode.length<1 && prevBillCode.length<1) {\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(epsdEnc.length<1 || patClass.length<1 || ageGroup.length<1 || genderCat.length<1 || clinicNurs.length<1 || clnCode.length<1 || incExcCriteria.length<1 || specCode.length<1 || prevBillCode.length<1 || effFromDate.length<1) {\n\t\t\t\t\talert(\"Please enter all mandatory fields for Row Number \"+prevIndex);\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\t\t\n\t\t}\n\t}\n\telse if(pageFrom == \'preApproval\'){\n\t\tvar table_id = parent.PolicyDetailsPage.document.getElementById(\'PolicyPreApproval\');\n\t\tvar totRows = table_id.rows.length;\n\t\ttotRows = totRows-1;\n\t\tfor(prevIndex=1;prevIndex<=totRows;prevIndex++){\n\t\t\tvar epsdEnc = parent.PolicyDetailsPage.document.getElementById(\"episode_\"+prevIndex).value;\n\t\t\tvar patClass = parent.PolicyDetailsPage.document.getElementById(\"ptClass_\"+prevIndex).value;\n\t\t\tvar ageGroup = parent.PolicyDetailsPage.document.getElementById(\"hdn_age_group_\"+prevIndex).value;\n\t\t\tvar genderCat = parent.PolicyDetailsPage.document.getElementById(\"gender_\"+prevIndex).value;\n\t\t\tvar clinicNurs = parent.PolicyDetailsPage.document.getElementById(\"clinic_\"+prevIndex).value;\n\t\t\tvar clnCode = parent.PolicyDetailsPage.document.getElementById(\"clinic_code_\"+prevIndex).value;\n\t\t\tvar incExcCriteria = parent.PolicyDetailsPage.document.getElementById(\"type_\"+prevIndex).value;\n\t\t\tvar effFromDate = parent.PolicyDetailsPage.document.getElementById(\"effFrom_\"+prevIndex).value;\n\t\t\tvar specCode = parent.PolicyDetailsPage.document.getElementById(\"spec_code_\"+prevIndex).value;\n\t\t\tvar prevBillCode  = parent.PolicyDetailsPage.document.getElementById(\"bg_code_\"+prevIndex).value;\n\t\t\tvar delFlag = parent.PolicyDetailsPage.document.getElementById(\"delFlag\"+prevIndex);\n\t\t\t\n\t\t\tif(!delFlag.checked){\n\t\t\t\tif(epsdEnc.length<1 && patClass.length<1 && ageGroup.length<1 && genderCat.length<1 && clnCode.length<1 && specCode.length<1 && prevBillCode.length<1) {\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(epsdEnc.length<1 || patClass.length<1 || ageGroup.length<1 || genderCat.length<1 || clinicNurs.length<1 || clnCode.length<1 || incExcCriteria.length<1 || specCode.length<1 || prevBillCode.length<1 || effFromDate.length<1) {\n\t\t\t\t\talert(\"Please enter all mandatory fields for Row Number \"+prevIndex);\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t}\n\t}\n\tvar frmObj = parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;\n\tvar key = frmObj.priorityKey.value;\n\tvar facility_id = frmObj.servFacilityId.value;\n\tvar payerGroup = frmObj.payerGroup.value;\n\tvar payer = frmObj.payer.value;\n\tvar policy = frmObj.policy.value;\n\txmlString=formXMLStringMain(frmObj);\n\tupdation=formValidation(xmlString,\"serviceCoverage\",key);\n\t\n\tfrmObj = parent.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails;\n\tvar prevtab = frmObj.prevTab.value;\n\txmlString=formXMLStringMain(frmObj);\n\tupdation=formValidation(xmlString,prevtab,key);\n\t\n\tfrmObj = parent.PolicyDetailsPage.document.forms[0];\n\tvar pageInfo = frmObj.pageInfo.value;\n\txmlString=formXMLStringMain(frmObj);\n\tupdation=formValidation(xmlString,pageInfo,key);\n\t\n\tvar xmlStr =\"<root><SEARCH \";\t\t\t\t\n\txmlStr +=\" /></root>\";\n\tvar temp_jsp=\"../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=compareBeans&facility_id=\"+facility_id+\"&payerGroup=\"+payerGroup+\n\t\t\t\t\t\"&payer=\"+payer+\"&policy=\"+policy+\"&key=\"+key;\t\t\n\t\n\tvar frmObj1 = parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;\n\tvar polcyOrEnc = frmObj1.prevEncValues.value;\n\tif(polcyOrEnc.length>0){\n\t\ttemp_jsp = temp_jsp+\"&hdnpatientId=\"+frmObj1.hdnpatientId.value+\n\t\t\"&hdnvisitId=\"+frmObj1.hdnvisitId.value+\n\t\t\"&hdnacctSeq=\"+frmObj1.hdnacctSeq.value+\n\t\t\"&hdnpriority=\"+frmObj1.hdnpriority.value+\n\t\t\"&hdnepisodeType=\"+frmObj1.hdnepisodeType.value+\n\t\t\"&hdnepisodeId=\"+frmObj1.hdnepisodeId.value+\n\t\t\"&hdnpolicyNo=\"+frmObj1.hdnpolicyNo.value+\n\t\t\"&plcyOrEnctr=encounter\";\n\t}\n\telse{\n\t\ttemp_jsp = temp_jsp+\"&plcyOrEnctr=policy\";\n\t}\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText);\n\t//alert(responseText);\n\twindow.close();\n}\n</script>\n</head>\n<body>\n<form>\n<table width=\'95%\'>\n<tr>\n<td width=\'75%\' align=\'left\'>\n\t\n</td>\n<td align=\'right\' width=\'9%\'>\n<input type=\'button\' class=\"BUTTON\" value=\'Lookup\' onClick=\'fnShowPolicyDetailReport();\'>\n</td>\n<td align=\'right\'  width=\'5%\'>\n<!-- <input type=\'button\' class=\'BUTTON\' value=\'Remove\' onclick=\'removeSelectedRow()\'> -->\n\n<input type=\'button\' class=\'BUTTON\' value=\'Add\' onclick=\'addRowNew()\'></td>\n\n<td align=\'left\' width=\'11%\'>\n<input type=\'button\' class=\'BUTTON\' value=\'Save All\' onclick=\'save()\'></td>\n</tr>\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
