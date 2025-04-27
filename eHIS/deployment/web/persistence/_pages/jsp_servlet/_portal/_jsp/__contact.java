package jsp_servlet._portal._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.common.model.ContactDetails;
import portalrefimpl.facility.FacilityHelper;
import portalrefimpl.common.model.Address;
import portalrefimpl.facility.facilityforcontact.response.FacilityDetails;
import java.util.List;
import portalrefimpl.facility.facilityforcontact.response.FacilityForContactResponse;
import portalrefimpl.facility.facilityforcontact.svc.FacilityForContactServiceInvoker;
import portalrefimpl.facility.FacilityConstants;
import portalrefimpl.PortalHelper;
import portalrefimpl.facility.facilityforcontact.request.FacilityForContactRequest;
import portalrefimpl.PortalConstants;

public final class __contact extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/Contact.jsp", 1669269355875L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Contact Us</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../css/style.css\" type=\"text/css\" />\r\n<link rel=\"stylesheet\" href=\"../css/style_ie.css\" type=\"text/css\" />\r\n</head>\r\n<body>\r\n\r\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n\t<div id=\"wrapper\">\r\n\t\t<div class=\"fixedheader\">\r\n\t\t\t<header id=\"header\">\r\n\t\t\t<div id=\"headerinfo\">\r\n\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t<div id=\"headervisitinfo\">Welcome back! Your last visit was\r\n\t\t\t\t\t\ton Wed, Dec 5, 2012 12:47:08 PM</div>\r\n\t\t\t\t\t<div id=\"headerloginas\">\r\n\t\t\t\t\t\t<strong>Welcome, ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =", ID:";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</strong>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div id=\"headerlogout\">\r\n\t\t\t\t\t\t<div>\r\n\t\t\t\t\t\t\t<a href=\"../servlet/LogoutServlet\" class=\"logout\"> Logout</a>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t</header>\r\n\r\n\t\t\t<!-- #header-->\r\n\r\n\t\t\t<!-- #logo And Menu -->\r\n\r\n\t\t\t<div id=\"logomenu\">\r\n\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t<div id=\"logo\">\r\n\t\t\t\t\t\t<img src=\"../images/logo.png\">\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div id=\"Menubox\">\r\n\t\t\t\t\t\t<ul class=\"menu\">\r\n\t\t\t\t\t\t\t<li class=\"menuselect\"><div class=\"menuicons\">\r\n\t\t\t\t\t\t\t\t\t<img src=\"../images/Contact.png\" />\r\n\t\t\t\t\t\t\t\t</div>Contact</li>\r\n\t\t\t\t\t\t\t<li><a href=\"./result/DetailedResult.jsp\"><div\r\n\t\t\t\t\t\t\t\t\t\tclass=\"menuicons\">\r\n\t\t\t\t\t\t\t\t\t\t<img src=\"../images/Results.png\" />\r\n\t\t\t\t\t\t\t\t\t</div>My Results</a></li>\r\n\t\t\t\t\t\t\t<li><a href=\"./schedule/UpcomingAppointments.jsp\"><div\r\n\t\t\t\t\t\t\t\t\t\tclass=\"menuicons\">\r\n\t\t\t\t\t\t\t\t\t\t<img src=\"../images/Appointment.png\" />\r\n\t\t\t\t\t\t\t\t\t</div>My Appointments</a></li>\r\n\t\t\t\t\t\t\t<li><a href=\"./PortalHome.jsp\"><div class=\"menuicons\">\r\n\t\t\t\t\t\t\t\t\t\t<img src=\"../images/Home.png\" />\r\n\t\t\t\t\t\t\t\t\t</div>Home</a></li>\r\n\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\r\n\t\t<!-- #logo And Menu -->\r\n\r\n\t\t<div class=\"line\"></div>\r\n\r\n\r\n\t\t<div id=\"content\">\r\n\r\n\r\n\t\t\t<!-- #Content Area-->\r\n\t\t\t<div id=\"contentbg\"></div>\r\n\r\n\t\t\t<div id=\"contentArea\">\r\n\r\n\t\t\t\t<div id=\"contentArearow\">\r\n\t\t\t\t\t<div style=\"min-height: 462px;\">\r\n\t\t\t\t\t\t<div id=\"ContactDiv\">\r\n\r\n\t\t\t\t\t\t\t<div id=\"Contactadd\" style=\"display: table;\">\r\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t\t\t\t\t\t\t\t<p class=\"ContactTitle\">Contact Us!</p>\r\n\t\t\t\t\t\t\t\t<div style=\"display: table-row;\">\r\n\t\t\t\t\t\t\t\t\t<!-- TODO this needs to be modified for getting the hospital details -->\r\n\t\t\t\t\t\t\t\t\t<div class=\"Facilityadd\" style=\"display: table-cell;\">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"Contactcontent\">\r\n\t\t\t\t\t\t\t\t\t\t\t<p class=\"contenboldregistered\">Registered office</p>\r\n\t\t\t\t\t\t\t\t\t\t\t<p class=\"Footeradd\">Envato Marketplace</p>\r\n\t\t\t\t\t\t\t\t\t\t\t<p class=\"Footeradd\">Melbourne St</p>\r\n\t\t\t\t\t\t\t\t\t\t\t<p class=\"Footeradd\">Sydney</p>\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div style=\"display: table-row;\">\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t\t\t\t\t\t\t\t<div class=\"Facilityadd\" style=\"display: table-cell;\">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"Contactcontent\" style=\"word-break: break-all;\">\r\n\t\t\t\t\t\t\t\t\t\t\t<p class=\"contenboldregistered\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</p>\r\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\t\t\t\t\t\t\t\t\t\t\t<p class=\"Footeradd\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<!-- <div style=\"display: table-row;\"> -->\r\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<div class=\"Footerbg\">\r\n\t\t\t<div id=\"poweredby\">\r\n\t\t\t\t<p class=\"poweredby\">\r\n\t\t\t\t\tPowered by <img src=\"../images/csc.png\" width=\"25\" height=\"14\">\r\n\t\t\t\t</p>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

		String patientId = "";
		patientId = (String) session
				.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);

		String patientName = "";
		patientName = (String) session
				.getAttribute(PortalConstants.PATIENTNAME_SESSION_KEY);
		if (patientName == null) {
			patientName = "";
		}
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block4Bytes, _wl_block4);

									int index = 0;
								
            _bw.write(_wl_block5Bytes, _wl_block5);

										// increment the index
										index++;

										FacilityForContactRequest facilityRequest = new FacilityForContactRequest();
										String considerAllFacilityValue = PortalHelper
												.getConfigPropertyValue(
														FacilityConstants.FACILITY_FORCONTACT_CONSIDER_ALL_PARAM,
														true);
										if (FacilityConstants.FACILITY_FORCONTACT_CONSIDER_NOT
												.equals(considerAllFacilityValue)) {
											String recordCntStr = PortalHelper
													.getConfigPropertyValue(FacilityConstants.FACILITY_FORCONTACT_COUNT_PARAM);
											int recordCnt = PortalHelper
													.getIntegerValue(
															recordCntStr,
															FacilityConstants.FACILITY_FORCONTACT_DEFAULT_COUNT_VALUE);
											/* recordCnt=15; */
											//recordCnt++;
											facilityRequest.setFacilityCount(recordCnt);
										}
										facilityRequest
												.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

										FacilityForContactServiceInvoker serviceInvoker = new FacilityForContactServiceInvoker();
										serviceInvoker.registerService(facilityRequest);
										FacilityForContactResponse facilityResponse = (FacilityForContactResponse) serviceInvoker
												.getDataThroughWebService(facilityRequest);

										if (facilityResponse.isSuccessful()) {
											List<FacilityDetails> facilitiesList = facilityResponse
													.getFacilitiesList();
											// no need to check for list null as list is non empty in success case
											for (FacilityDetails facilityDetails : facilitiesList) {
												if ((index % 2) == 0) {
													index = 0;
									
            _bw.write(_wl_block6Bytes, _wl_block6);

										}
									
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facilityDetails.getFacilityName()));
            _bw.write(_wl_block8Bytes, _wl_block8);

												Address address = facilityDetails.getFacilityAddress();
														List<String> addressContentList = FacilityHelper
																.getAddressContentsAsList(address);
														// no need to check for null - just iterate through and show
														for (String addressContent : addressContentList) {
											
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(addressContent));
            _bw.write(_wl_block8Bytes, _wl_block8);

												}

														ContactDetails contactDetails = facilityDetails
																.getFacilityContactDetails();
														List<String> contactDetailsList = FacilityHelper
																.getContactDetailsAsList(contactDetails);
														// no need to check for null - just iterate through and show
														for (String facilityContent : contactDetailsList) {
											
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facilityContent));
            _bw.write(_wl_block8Bytes, _wl_block8);

												}
											
            _bw.write(_wl_block10Bytes, _wl_block10);

										index++;
											}
										}
										if (index != 0) {
									
            _bw.write(_wl_block11Bytes, _wl_block11);

									}
								
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
