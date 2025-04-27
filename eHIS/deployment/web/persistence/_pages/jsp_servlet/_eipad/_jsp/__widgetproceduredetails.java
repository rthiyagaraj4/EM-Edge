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
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __widgetproceduredetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/WidgetProcedureDetails.jsp", 1709118034708L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>jQuery Mobile Application</title>\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/ipadAllergyContent.css\" />\n<script>\n\nfunction expandProcedureDetailwidget()\n{\n\twindow.parent.expandwidgetsecond();\n}\n</script>\n</head>\n<body>\n\n\t<section id=\"mainSchedule\" data-role=\"page\"\n\t\tstyle=\"background-color: white\">\n\n\t\t<div class=\"dvWidgetHeaderResults\">\n\t\t\t<table style=\"width: 100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t<tr style=\"width: 100%\">\n\t\t\t\t\t<td style=\"width: 95%\" valign=\"middle\"><span\n\t\t\t\t\t\tclass=\"spaDvHeaderResults\">Procedure Details</span></td>\n\n\t\t\t\t\t\n\t\t\t\t\t<td style=\"width: 5%\" align=\"center\" valign=\"middle\"\n\t\t\t\t\t\tonclick=\"expandProcedureDetailwidget()\"><img\n\t\t\t\t\t\tsrc=\"../images/Collapse icon.png\"></img></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t\n\t\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t  <div data-role=\"none\" class=\"dvSelectOrderSearchResults\">\n\t\t\t\t\t<table style=\"width: 100%; height: 100%\" border=\"0\" cellpadding=\"0\"\n\t\t\t\t\t\tcellspacing=\"0\">\n\t\t\t\t\t\t<tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t    <td style=\"width: 2%\" align=\"left\" valign=\"center\">&nbsp;</td>\n\t\t\t\t\t\t\t<td style=\"width: 8%\" align=\"left\" valign=\"center\"><span\n\t\t\t\t\t\t\t\tclass=\"spanSelectOrderSearchResults12\">Code</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 25%\" align=\"left\" valign=\"center\"><span\n\t\t\t\t\t\t\t\tclass=\"spanSelectOrderSearchResults12\">Description</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 11%\" align=\"left\" valign=\"center\"><span\n\t\t\t\t\t\t\t\tclass=\"spanSelectOrderSearchResults12\">Starting Time</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 11%\" align=\"left\" valign=\"center\"><span\n\t\t\t\t\t\t\t\tclass=\"spanSelectOrderSearchResults12\">Ending Time</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 10%\" align=\"left\" valign=\"center\"><span\n\t\t\t\t\t\t\t\tclass=\"spanSelectOrderSearchResults12\">Status</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 15%\" align=\"left\" valign=\"center\"><span\n\t\t\t\t\t\t\t\tclass=\"spanSelectOrderSearchResults12\">Practitioner</span></td>\n\t\t\t\t\t\t\t<td style=\"width: 9%\" align=\"left\" valign=\"center\"><span\n\t\t\t\t\t\t\t\tclass=\"spanSelectOrderSearchResults12\">Anaesthetist</span></td>\n\t\t                    <td style=\"width: 9%\" align=\"left\" valign=\"center\"><span\n\t\t\t\t\t\t\t\tclass=\"spanSelectOrderSearchResults12\">Anaesthesia</span></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<table class=\"tbIpContent2\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n\t\t\tstyle=\"height: 30px\">\n\t\t\t<tr class=\"dvSelectOrderRow";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n\t\t\t<td style=\"width: 2%\" align=\"left\" valign=\"center\">&nbsp;</td>\n\t\t\t\t<td style=\"width: 8%; height: 100%\" align=\"left\" valign=\"center\" >\n\t\t\t\t\t<span class=\"spanSelectOrderRows1\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span>\n\n\t\t\t\t</td>\n\t\t\t\t<td style=\"width: 25%; height: 100%\" align=\"left\" valign=\"center\" >\n\t\t\t\t\t<span class=\"spanSelectOrderRows1\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\n\t\t\t\t\n\n\t\t\t\t</td>\n\t\t\t\t<td style=\"width: 11%; height: 100%\" align=\"left\" valign=\"center\" >\n\n\t\t\t\t\t<span class=\"spanSelectOrderRows1\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span>\n\n\t\t\t\t</td>\n\t\t\t\t<td style=\"width: 11%; height: 100%\" align=\"left\" valign=\"center\" >\n\t\t\t\t\t<span class=\"spanSelectOrderRows1\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span>\n\n\t\t\t\t</td>\n\t\t\t\t<td style=\"width: 10%; height: 100%\" align=\"left\" valign=\"center\" >\n\t\t\t\t\t<span class=\"spanSelectOrderRows1\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</span>\n\n\t\t\t\t</td>\n\t\t\t\t<td style=\"width: 15%; height: 100%\" align=\"left\" valign=\"center\" >\n\t\t\t\t\t<span class=\"spanSelectOrderRows1\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span>\n\n\t\t\t\t</td>\n\t\t\t\t\n                <td style=\"width: 9%; height: 100%\" align=\"left\" valign=\"center\" >\n\t\t\t\t\t<span class=\"spanSelectOrderRows1\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span>\n\n\t\t\t\t</td>\n\t\t\t\t<td style=\"width: 9%; height: 100%\" align=\"left\" valign=\"center\" >\n\t\t\t\t\t<span class=\"spanSelectOrderRows1\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span>\n\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t  \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t</section>\n\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\n\n\n</body>\n</html>\n\t\t\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

	

	PatientContext oPatientContext = new PatientContext();
	oPatientContext.request = request;

	if (session.getValue("facility_id") != null) {
		oPatientContext.sFacilityId = (String) session
				.getValue("facility_id");
	}
	if (session.getValue("ca_practitioner_id") != null) {
		oPatientContext.sClinicianId = (String) session
				.getValue("ca_practitioner_id");
	}
	if (session.getValue("practitioner_type") != null) {
		oPatientContext.sPracType = (String) session
				.getValue("practitioner_type");
	}
	if (session.getValue("PatientID") != null) {
		oPatientContext.sPatientId = (String) session
				.getValue("PatientID");
	}
	if (session.getValue("EpisodeId") != null) {
		oPatientContext.sEncounterId = (String) session
				.getValue("EpisodeId");
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

			eIPAD.ProcedureDetails  bean = new eIPAD.ProcedureDetails ();
			List<ProcedureDet> objProcedureDet = new ArrayList<ProcedureDet>();
			int nRowCount = 1; //To hold the rowcount and to limit the row size to 6.		       			    
			int nCssCount = 1; // To display alternate Row Color.
			int nDummyRowcount = 1;
			int nListSize = 0;

			int nLoopCount = 0;
			ProcedureDet oProcedureDet = null;

			try {

				objProcedureDet = bean
						.getProcedureDetails(oPatientContext);
				nListSize = objProcedureDet.size();

				if (nListSize > 0) {
					
            _bw.write(_wl_block2Bytes, _wl_block2);
 
					for (nLoopCount = 0; nLoopCount < nListSize; nLoopCount++) {

						oProcedureDet = objProcedureDet.get(nLoopCount);
								
						if (oProcedureDet != null) {
		
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(nCssCount));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oProcedureDet.getsProcCode()));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(oProcedureDet.getsProcDesc()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oProcedureDet.getsProcDate()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oProcedureDet.getsEndDate()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oProcedureDet.getsStatus()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oProcedureDet.getsPracName()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(oProcedureDet.getsAnaesthetist()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(oProcedureDet.getsAnaesthesia()));
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
						nRowCount = nRowCount + 1;
						if (nCssCount == 1) {
							nCssCount = nCssCount + 1;
						} else {
							nCssCount = nCssCount - 1;
						}

					}//for
				}//if listsize
				 else
				 {
					 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block14Bytes, _wl_block14);
 
				 }
		
            _bw.write(_wl_block15Bytes, _wl_block15);

		} catch (Exception e) {
			out.println("Exception " + e);
			//out.println(sqlStr.toString());
			e.printStackTrace();
		} finally {

		}
	
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
