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

public final class __widgetallergydetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/WidgetAllergyDetails.jsp", 1709118034068L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>jQuery Mobile Application</title>\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<link rel=\"stylesheet\" href=\"../css/ipadAllergyContent.css\" />\n<script>\n\nfunction expandAllergywidget()\n{\n\t\n\twindow.parent.expandwidget3();\n}\nfunction DisplayOrHideDetails(HeaderName,objImg)\n{\n\t\n\t\n\t var imgPath = objImg.src; \n\t if( imgPath.indexOf(\"Expanded\") != -1 )\n\t\t {\n\t\t objImg.src = \"../images/More group icon main.png\";\n\t\t\t$(\"[data-class = \'\" + HeaderName + \"\']\").css(\'display\',\'none\');\n\t\t }\n\t else\n\t\t {\n\t\t objImg.src = \"../images/Expanded Group Icon Main.png\";\n\t\t\t$(\"[data-class = \'\" + HeaderName + \"\']\").css(\'display\',\'block\');\n\t\t }\n\t var src = \"../images/Expanded group Icon.png\";\n\t// $(\"[data-image = \'\" + HeaderName + \"\']\").css(\'background\', \'url(\' + src + \')\'); \n\t$(\"[data-image = \'\" + HeaderName + \"\']\").attr(\"src\" , src);\n\t\n}\n</script>\n</head>\n<body>\n\n\t<section id=\"mainAllergy\" data-role=\"page\"\n\t\tstyle=\"background-color: white\">\n\n\t\t<div class=\"dvWidgetHeaderResults\">\n\t\t\t<table style=\"width: 100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t<tr style=\"width: 100%\">\n\t\t\t\t\t<td style=\"width: 95%\" valign=\"middle\"><span\n\t\t\t\t\t\tclass=\"spaDvHeaderResults\">Allergies</span></td>\n\n\t\t\t\t\t\n\t\t\t\t\t<td style=\"width: 5%\" align=\"center\" valign=\"middle\"\n\t\t\t\t\t\tonclick=\"expandAllergywidget()\"><img\n\t\t\t\t\t\tsrc=\"../images/Collapse icon.png\"></img></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t\n\t\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t<table class=\"tbWidgetContent\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n\t\t\t\n\n\t\t\t<tr class=\"trWidgetSummary12\">\n\t\t\t\t<td class=\"tdWidImgHeader\"></td>\n\t\t\t\t<td class=\"tdWidHeader\"><span class=\"spWidHeaderAllergy\"><b>Event\n\t\t\t\t\t\t\ttype</b></span></td>\n\t\t\t\t<td class=\"tdWidHeader\"><span class=\"spWidHeaderAllergy\"><b>Allergy</b></span>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"tdWidHeader\"><span class=\"spWidHeaderAllergy\"><b>Onset\n\t\t\t\t\t\t\tDate</b></span></td>\n\t\t\t\t<td class=\"tdWidHeader\"><span class=\"spWidHeaderAllergy\"><b>Status</b></span>\n\t\t\t\t</td>\n\n\t\t\t</tr>\n\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<table style=\"width: 100%; border: 1px solid #afb0b0\" border=\"0\"\n\t\t\tcellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr class=\'trResultsHeader\'>\n\t\t\t\t<td style=\'width: 4%\' align=\"center\" valign=\"middle\"><img\n\t\t\t\t\tsrc=\"../images/More group icon main.png\"\n\t\t\t\t\tonclick=\"DisplayOrHideDetails(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' , this)\"></img></td>\n\t\t\t\t<td style=\'width: 96%\' align=\'left\'>\n\t\t\t\t<table style=\"width: 100%;\" border=\"0\"\n\t\t\t\t\t\tcellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spWidHeaderAllergies\"><b>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</b></span></td>\n\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spWidHeaderAllergies\"><b>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</b></span></td>\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spWidHeaderAllergies\"><b>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</b></span></td>\n\n\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<div data-role = \"none\" data-class = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" style = \"display:none\" >\n\t\t<table style=\"width: 100%;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td class=\"trAllergySummary\" style=\'width: 3%\'></td>\n\t\t\t\t<td class=\"trAllergSummary\" style=\'width: 97%\'>\n\t\t\t\t\t<table style=\"width: 100%;\" border=\"0\"\n\t\t\t\t\t\tcellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spaDvContentAllergies\"><b>Reaction Date </b></span></td>\n\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spaDvContentAllergies\"><b>Reaction Description</b></span></td>\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spaDvContentAllergies\"><b>Severity</b></span></td>\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spaDvContentAllergies\"><b>Site Of Reaction</b></span></td>\n\n\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</div>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n      <div data-role = \"none\" data-class = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" style = \"display:none\" >\n\t\t\n\t\t\n\t\t<table style=\"width: 100%;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"trAllergySum\" style=\'width: 3%\'></td>\n\n\t\t\t\t<td class=\"trAllSummary";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" style=\'width: 97%\'>\n\t\t\t\t\t<table style=\"width: 100%;\" border=\"0\"\n\t\t\t\t\t\tcellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spaDvAllergyDetails\"><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span></td>\n\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spaDvAllergyDetails\"><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></span></td>\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spaDvAllergyDetails\"><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t</b></span></td>\n\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'><span\n\t\t\t\t\t\t\t\tclass=\"spaDvAllergyDetails\"><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></span></td>\n\n\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t </div>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t  \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\t</section>\n\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\n\n\n</body>\n</html>\n\n\n\n\n\n\n\n\n\n\n\n";
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

	String strDrug = "";
	

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

			eIPAD.AllergyDetails bean = new eIPAD.AllergyDetails();
			List<Allergy> objAllergyDetails = new ArrayList<Allergy>();
			int nRowCount = 1; //To hold the rowcount and to limit the row size to 6.		       			    
			int nCssCount = 1; // To display alternate Row Color.
			int nDummyRowcount = 1;
			int nListSize = 0;

			int nLoopCount = 0;
			Allergy oAllergy = null;

			try {

				objAllergyDetails = bean.getAllergyDetails(oPatientContext);
				nListSize = objAllergyDetails.size();

				if (nListSize > 0) {
				
            _bw.write(_wl_block2Bytes, _wl_block2);
 	
					for (nLoopCount = 0; nLoopCount < nListSize; nLoopCount++) {

						oAllergy = objAllergyDetails.get(nLoopCount);
						if (oAllergy != null) {
							
							 String	Drug = oAllergy.getsAllergyDesc()
									+ oAllergy.getsAllergenDesc()
									+ oAllergy.getsOnsetDate()
									+ oAllergy.getsStatus();
		
            _bw.write(_wl_block3Bytes, _wl_block3);
if(!strDrug.equals(Drug))
  {
  
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(Drug));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( oAllergy.getsAllergyDesc()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( oAllergy.getsAllergenDesc()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( oAllergy.getsOnsetDate()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( oAllergy.getsStatus()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Drug));
            _bw.write(_wl_block9Bytes, _wl_block9);

   }
		
     
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Drug));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nCssCount ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( oAllergy.getsReactiondate()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( oAllergy.getsReactionDesc()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( oAllergy.getsSevereityDesc()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( oAllergy.getsReactionSite()));
            _bw.write(_wl_block16Bytes, _wl_block16);

			
		strDrug = Drug;
						}//if oAllergy !=null
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
					 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block18Bytes, _wl_block18);
 
				 }	
		
            _bw.write(_wl_block19Bytes, _wl_block19);

	} catch (Exception e) {
		out.println("Exception " + e);
		//out.println(sqlStr.toString());
		e.printStackTrace();
	} finally {

	}

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
