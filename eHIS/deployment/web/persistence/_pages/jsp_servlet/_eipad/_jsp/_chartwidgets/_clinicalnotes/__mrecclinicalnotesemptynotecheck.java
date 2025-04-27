package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.google.gson.Gson;
import java.util.Properties;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesSectionItem;
import java.util.List;
import com.ehis.persist.PersistenceHelper;
import eIPAD.chartsummary.common.response.ErrorInfo;
import java.util.ArrayList;
import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesSectionListResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import webbeans.eCA.RecClinicalNotesSectionBean;

public final class __mrecclinicalnotesemptynotecheck extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesEmptyNoteCheck.jsp", 1709116942239L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}
public String checkForNull(String inputString, String defaultValue)
{
	if(inputString==null)inputString ="";
	return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
PatContext patContext= (PatContext)session.getAttribute("PatientContext");  
String note_type = checkForNull(request.getParameter("note_type"));
String operation_mode = checkForNull(request.getParameter("operation_mode"));
String locale = (String)session.getAttribute("LOCALE");
Boolean isNoteEmpty = true;
Gson gson = new Gson();
String jsonFieldResponse = "";
if(patContext!=null){
	String strKey	=	"";
	String patient_id = patContext.getPatientId();
	String encounter_id = patContext.getEncounterId();
	strKey = patient_id + "~"+ encounter_id;
	strKey = strKey.trim();
	Properties patSections = sectionBean.getPatientSection(strKey);
	if(!operation_mode.equals("ModifySection")){
		ClinicalNotesBC bc = new ClinicalNotesBC();
		ClinicalNotesSectionListResponse sectResp =  bc.getSectionListForNoteType(note_type, locale);
		if(sectResp!=null){
			boolean isSuccessResponse = sectResp.isSuccessResponse();
			boolean isEmptyResponse = sectResp.isEmptyDataResponse();
			ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
			List<ClinicalNotesSectionItem> sectList = sectResp.getSectionList();
			errorList = sectResp.getErrorsList();
			if(sectList!=null  && !sectList.isEmpty())
				isEmptyResponse = false;
			if(isSuccessResponse && !isEmptyResponse){
				for(int i=0;i<sectList.size();i++){
					ClinicalNotesSectionItem currentSect = sectList.get(i);
					String sec_hdg_code = currentSect.getSectionCode();
					String subsec_hdg_code = currentSect.getChildSectionCode();
					if(operation_mode.equals("ModifyAddendum")){
						String edited_yn = checkForNull((String) sectionBean.getSectionEdited(sec_hdg_code, subsec_hdg_code),"");
						String ammend_text = (String) sectionBean.getAddendumText( sec_hdg_code, subsec_hdg_code);
						if(edited_yn.equals("Y") && ammend_text!=null && !ammend_text.equals("")){
							isNoteEmpty = false;
						}
					}else if(operation_mode.equals("UpdateRecord")){
						String edited_yn = checkForNull((String) sectionBean.getSectionEdited(sec_hdg_code, subsec_hdg_code),"");
						String notes_section_content = checkForNull((java.lang.String) sectionBean.getSectionContent ( sec_hdg_code,subsec_hdg_code ),"");	
						if(notes_section_content!=null && !notes_section_content.equals("")){
							isNoteEmpty = false;
						}
					}else{
						String edited_yn = checkForNull((String) sectionBean.getSectionEdited(sec_hdg_code, subsec_hdg_code),"");
						String notes_section_content = checkForNull((java.lang.String) sectionBean.getSectionContent ( sec_hdg_code,subsec_hdg_code ),"");	
						if(edited_yn.equals("Y") && notes_section_content!=null && !notes_section_content.equals("")){
							isNoteEmpty = false;
						}
					}
				}
				
			}
			if(operation_mode.equals("ModifyAddendum")){
				String commonAddendumTxt =  sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");
				if(!commonAddendumTxt.equals("")){
					isNoteEmpty = false;
				}
			}
		}
	}else{ //in case of modify section, we are not considering to check for empty
		isNoteEmpty = false;
	}
	
	
}
if(isNoteEmpty){
	jsonFieldResponse = gson.toJson("true");
}else{
	jsonFieldResponse = gson.toJson("false");
}

response.setContentType("application/json");
response.getWriter().write(jsonFieldResponse);

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
