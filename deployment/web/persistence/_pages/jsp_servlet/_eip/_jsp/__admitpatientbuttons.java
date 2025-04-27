package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __admitpatientbuttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AdmitPatientButtons.jsp", 1718793146285L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="  \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../js/AdmitPatient.js\' language=\'javascript\'></script>\n\t<script src=\'../js/AdmitPatient1.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\"JavaScript\">\n\tasync function callLastAdmission()\n\t{\n\t\tvar patid=parent.frames[0].document.forms[0].patient_id.value;\n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"700px\";\n\t\tvar dialogWidth = \"1200px\";\n\t\tvar dialogTop\t= \"72\";\n\t\tvar center = \"1\" ;\n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tretVal = await window.showModalDialog(\"../../eMP/jsp/vwEncounterDetailFrames.jsp?patientid=\"+patid\n\t\t,arguments,features);\n\t}\n\n\tasync function showContactDetails()\n\t{\n\t\tvar booking_ref_no\t=\tparent.frames[0].document.forms[0].booking_ref_no;\n\t\tvar contact_details\t=\tparent.frames[2].document.forms[0].contact_details;\n\t\tvar retVal\t\t\t= \tnew String();\n\t\tvar dialogHeight\t=\t\"28\" ;\n\t\tvar dialogWidth\t\t=\t\"35\" ;\n\t\tvar status\t\t\t=\t\"no\";\n\t\tvar features\t\t=\t\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\tvar arguments\t\t=\tcontact_details;\n\t\tvar url\t\t\t\t=\t\"../../eIP/jsp/BookAppointmentContact.jsp?booking_ref_no=\"+escape(booking_ref_no.value)+\"&contactdetails=\"+escape(contact_details.value);\n\t\tretVal\t\t\t\t\t=\tawait window.showModalDialog(url,arguments,features);\t\t\n\n\t\tif(retVal != \"\")\t\n\t\t{\n\t\t\tcontact_details.value\t=\tretVal;\t\t\t\n\n\t\t\tvar contact_vals = retVal;\n\t\t\tvar contacts = contact_vals.split(\"||\");\n\n\t\t\tparent.frames[2].document.forms[0].res_tel_no.value = contacts[0];\n\t\t\tparent.frames[2].document.forms[0].oth_contact_no.value = contacts[1];\n\t\t\tparent.frames[2].document.forms[0].email_id.value = contacts[2];\n\t\t\tparent.frames[2].document.forms[0].postal_code.value = contacts[3];\n\t\t\tparent.frames[2].document.forms[0].country_code.value = contacts[4];\n\t\t\tparent.frames[2].document.forms[0].res_addr_line1.value = contacts[5];\n\t\t\tparent.frames[2].document.forms[0].res_addr_line2.value = contacts[6];\n\t\t\tparent.frames[2].document.forms[0].res_addr_line3.value = contacts[7];\n\t\t\tparent.frames[2].document.forms[0].res_addr_line4.value = contacts[8];\n\t\t}\n\t}\n\tasync function showValuables()\n\t{\n\t\t\tvar retVal =    new String();\n\t\t\tvar dialogTop   = \"130\";\n\t\t\tvar dialogHeight    = \"19.5\" ;\n\t\t\tvar dialogWidth = \"50\" ;\n\t\t\tvar features    =\"dialogTop:\"+dialogTop+\"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\t\tvar arguments =\"\";\n\t\t\tvar valubl = parent.frames[2].document.forms[0].valubles.value ;\n\n\t\t\tvalubl += checkForNull(parent.frames[2].document.forms[0].recorded_by.value);\n\t\t\tvalubl += \"||\"+checkForNull(parent.frames[2].document.forms[0].recorded_date.value);\n\t\t\tvalubl += \"||\"+checkForNull(parent.frames[2].document.forms[0].valuble_remakrs.value);\n\t\t\tvar url   = \"../../eMP/jsp/PatientValuablesMain.jsp?encounterId= patientId=\"+parent.frames[2].document.forms[0].patient_id.value +\"&valuble=\"+escape(valubl);\n\n\t\t\tretVal = await window.showModalDialog(url,arguments,features);\n\t\t\tif(retVal != null)\n\t\t\t{\n\t\t\t\tif(retVal != \"\")\n\t\t\t\t{\n\t\t\t\t\tvar contact_vals = new Array();\n\t\t\t\t\tcontact_vals = retVal;\n\t\t\t\t\tvar contacts = contact_vals.split(\"||\");\n\t\t\t\t\tparent.frames[2].document.forms[0].recorded_by.value = contacts[0];\n\t\t\t\t\tparent.frames[2].document.forms[0].recorded_date.value = contacts[1];\n\t\t\t\t\tparent.frames[2].document.forms[0].valuble_remakrs.value = contacts[2];\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t}\n\tfunction checkForNull(inString)\n\t{\n\t\treturn (trimCheck(inString))\t?\tinString\t:\t\"\";\n\t}\n\n\tasync function ViewRefDetails()\n\t{\n\t\trefid = parent.frames[0].document.Select_form.referral_id.value;\n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"700px\" ;\n\t\tvar dialogTop = \"72\" ;\n\t\tvar dialogWidth\t= \"1200px\" ;\n\t\tvar status = \"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status  + \"; dialogTop :\" + dialogTop ;\n\t\tvar retVal = await window.showModalDialog(\"../../eMP/jsp/ViewPatReferral.jsp?referral_id=\"+refid,arguments,features);\n\t}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\">\n<table cellpadding=0 cellspacing=0 align=\"right\" width=\"20%\" border=0>\n<tr>\n\t<td class=\'WHITE\'><input type=\"button\" name=\'valuables\' id=\'valuables\' class=\"button\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" onClick=\"showValuables(this);\" style=\"visibility:hidden\" disabled tabindex=\'21\'></td>\n\t<td class=\'WHITE\'><input type=\"button\" name=\'contact_details\' id=\'contact_details\' class=\"button\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" onClick=\"Modal_Contact_Details(this);\" disabled tabindex=\'21\'></td>\n\t<td class=\'WHITE\'><input type=\"button\" name=\'PrevIPVisit\' id=\'PrevIPVisit\' class=\"button\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" onClick=\"callLastAdmission()\" disabled tabindex=\'22\'></td>\n\t<td class=\'WHITE\'><input type=\"button\" name=\'referal_details\' id=\'referal_details\' class=\"button\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onClick=\"ViewRefDetails()\" disabled tabindex=\'23\'></td>\n</tr>\n</table>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientValuables.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactDetails.label","common_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreviousEncounters.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referraldetails.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
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
