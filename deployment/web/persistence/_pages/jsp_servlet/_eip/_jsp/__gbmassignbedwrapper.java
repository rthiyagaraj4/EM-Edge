package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIP.advbedmgmt.transaction.assignbed.AssignBedConstants;
import eIP.advbedmgmt.common.operatorstation.response.OsRetrieveResponse;
import eIP.advbedmgmt.common.operatorstation.OsRetrieveConstants;
import eIP.advbedmgmt.common.operatorstation.bc.OsRetrieveBC;
import eIP.advbedmgmt.GBMConstants;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import eIP.advbedmgmt.common.operatorstation.request.OsRetrieveRequest;
import eCommon.Common.CommonBean;

public final class __gbmassignbedwrapper extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/GBMAssignBedWrapper.jsp", 1709293411112L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE>\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Assign Bed</title>\n<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<body>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<!-- <div id=\"spaceComp\" name=\"spaceComp\" style=\"height:5px;\">\n</div> -->\n\n<div id=\"searchComp\" name=\"searchComp\" style=\"width:100%;height:130px;display:block;\">\n\t<iframe style=\"width:100%;height:100%;border-top: 0px;\" src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"></iframe>\n</div>\n\n<div id=\"resultComp\" name=\"resultComp\" style=\"width:100%;height:8vh0px;\" src=\"\">\n\t<iframe id=\"resultframe\" name=\"resultframe\" style=\"width:100%;height:100%;border:0 px;\" src=\"\"></iframe>\n</div>\n\n<div id=\"legendComp\" name=\"legendComp\" style=\"width:100%;height:30px;\" src=\"\">\n\t<!-- <object id=\"legendObj\" name=\"legendObj\" type=\"text/html\" data=\"\"></object> -->\n\t<iframe id=\"legendframe\" name=\"legendframe\" style=\"width:100%;height:100%;border:0 px;\" src=\"\"></iframe>\n</div>\n\n<div id=\"errorComp\" name=\"errorComp\" style=\"width:100%;\" src=\"../../eCommon/jsp/MstCodeError.jsp\">\n</div>\n\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);


String facilityId =	CommonBean.checkForNull((String)session.getValue("facility_id"));
String loginUser = CommonBean.checkForNull((String)session.getValue("login_user"));
// data from request parameter
String nuCode = CommonBean.checkForNull(request.getParameter(AssignBedConstants.NURSING_UNIT_REQ_PARAM));
String nuDesc = CommonBean.checkForNull(request.getParameter(AssignBedConstants.NURSING_UNIT_DESC_REQ_PARAM));
String specialtyCode = CommonBean.checkForNull(request.getParameter(AssignBedConstants.SPECIALTY_CODE_REQ_PARAM));
String specialtyDesc = CommonBean.checkForNull(request.getParameter(AssignBedConstants.SPECIALTY_DESC_REQ_PARAM));
String showNuPopup = CommonBean.checkForNull(request.getParameter
					(AssignBedConstants.SHOW_NU_POPUP_REQ_PARAM),
					AssignBedConstants.SHOW_NU_POPUP_DEFAULT_VALUE);
String showSpecialtyPopup = CommonBean.checkForNull(request.getParameter
					(AssignBedConstants.SHOW_SPECIALTY_POPUP_REQ_PARAM),
					AssignBedConstants.SHOW_SPECIALTY_POPUP_DEFAULT_VALUE);



// get operator station id
OsRetrieveRequest osRetrRequest = new OsRetrieveRequest();
osRetrRequest.setFacilityId(facilityId);
osRetrRequest.setUserId(loginUser);
ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
OsRetrieveBC bcInst = (OsRetrieveBC) context.getBean(OsRetrieveConstants.OS_RETR_BC_NAME);
OsRetrieveResponse osRetrResponse = bcInst.getOsIdForUser(osRetrRequest);

String osId = "";
if(osRetrResponse.isSuccessful()){
	osId = osRetrResponse.getOsId();
}

// constants to be used 
final String FUNCTION_ID = "ASSIGN_BED";
final String JSP_NAME = "AssignBedMain.jsp";
final String CALL_FUNCTION = "assign_bed";
final String WHERE_CONDN = "ASSIGN_BED_YN";
final String CHG_NU_IN_ASSIGN_BED_YN = "N";

StringBuilder searchPanelURL = new StringBuilder("GBMAssignBedSearchPanel.jsp?");
searchPanelURL.append("function_id=").append(FUNCTION_ID);
searchPanelURL.append("&jsp_name=").append(JSP_NAME);
searchPanelURL.append("&call_function=").append(CALL_FUNCTION);
searchPanelURL.append("&wherecondn=").append(WHERE_CONDN);
searchPanelURL.append("&oper_stn_id=").append(osId);
searchPanelURL.append("&chg_nurs_unit_in_assign_bed_yn=").append(CHG_NU_IN_ASSIGN_BED_YN);
searchPanelURL.append("&").append(AssignBedConstants.NURSING_UNIT_REQ_PARAM).append("=").append(nuCode);
searchPanelURL.append("&").append(AssignBedConstants.NURSING_UNIT_DESC_REQ_PARAM).append("=").append(nuDesc);
searchPanelURL.append("&").append(AssignBedConstants.SPECIALTY_CODE_REQ_PARAM).append("=").append(specialtyCode);
searchPanelURL.append("&").append(AssignBedConstants.SPECIALTY_DESC_REQ_PARAM).append("=").append(specialtyDesc);
searchPanelURL.append("&").append(AssignBedConstants.SHOW_NU_POPUP_REQ_PARAM).append("=").append(showNuPopup);
searchPanelURL.append("&").append(AssignBedConstants.SHOW_SPECIALTY_POPUP_REQ_PARAM).append("=").append(showSpecialtyPopup);



            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(searchPanelURL.toString()));
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
