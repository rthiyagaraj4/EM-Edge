package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __mrecclinicalnotessectionaddendumcontrol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionAddendumControl.jsp", 1709116942458L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?                          100                        ?             created\n23/07/2012           IN034160             Dinesh T             Printpreview function clears the contents in the addendum editor\n19/09/2012           IN033677             Dinesh T             CRF-Recording and signing the addendum with new free text editor and uncommented                                                                                  \n                                                                                  some part of the code\n03/06/2013           IN040265             Ramesh G             Issue 1: At print preview the addendum details displayed as \"Addendum Created by\"  instead of \"Addendum Recorded by\"\n                                                                                  Issue 2: Addendum details  displayed twice.\n03/06/2013           IN040266             Ramesh G             Issue 1: Record Clinical Notes->Search Tab->Update->System is displaying the updated text in different font in Print Preview and Print.\n                                                                                  Issue 2: Chart Summary->Lab Results->Note Type text data is displayed in different font.\n                                                                                  Issue 3: OT Surgeon Notes->System is displaying the text in different font in Print Preview and Print.\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

       request.setCharacterEncoding("UTF-8");
       webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean) getObjectFromBean(
                     "sectionBean", "webbeans.eCA.RecClinicalNotesSectionBean",
                     session);

       //sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code)





       String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
                     || (session.getAttribute("PREFERRED_STYLE") != "")
                     ? (String) session.getAttribute("PREFERRED_STYLE")
                     : "IeStyle.css";



       
              String section_content = "";
              String curr_sec_hdg_code = "";
              String curr_child_sec_hdg_code = "";
              String dummyValue = "";
              String patient_id = "";
              String note_type = "";
              String prev_sec_hdg_code = "";
              String prev_child_sec_hdg_code = "";
              String prev_sec_content_type = "";
              String editor_title = "";
              String accession_num = "";
              String operation_mode = "";
              String strAmMode = "";
              String strRecordMode = "";
              String curr_section_type = "";
              String encounter_id = "";
              String episode_type = "";
              String patient_class = "";
              String strKey = "";

              curr_sec_hdg_code = request.getParameter("curr_sec_hdg_code") == null
                           ? ""
                           : request.getParameter("curr_sec_hdg_code");
              curr_child_sec_hdg_code = request
                           .getParameter("curr_child_sec_hdg_code") == null
                           ? curr_sec_hdg_code
                           : request.getParameter("curr_child_sec_hdg_code");
              prev_sec_hdg_code = request.getParameter("curr_sec_hdg_code") == null
                      ? ""
                      : request.getParameter("curr_sec_hdg_code");
              prev_child_sec_hdg_code = request
                      .getParameter("curr_child_sec_hdg_code") == null
                      ? curr_sec_hdg_code
                      : request.getParameter("curr_child_sec_hdg_code");
              patient_id = request.getParameter("patient_id") == null
                           ? ""
                           : request.getParameter("patient_id");
              section_content = request.getParameter("section_content") == null
                           ? ""
                           : request.getParameter("section_content");

              note_type = request.getParameter("note_type") == null
                           ? ""
                           : request.getParameter("note_type");
              editor_title = request.getParameter("editor_title") == null
                           ? "Addendum To Note"
                           : request.getParameter("editor_title");
              accession_num = request.getParameter("accession_num") == null
                           ? ""
                           : request.getParameter("accession_num");
              operation_mode = request.getParameter("operation_mode") == null
                           ? ""
                           : request.getParameter("operation_mode");
              strAmMode = request.getParameter("ammend_mode") == null
                           ? ""
                           : request.getParameter("ammend_mode");
              strRecordMode = request.getParameter("record_mode") == null
                           ? ""
                           : request.getParameter("record_mode");
              encounter_id = request.getParameter("encounter_id") == null
                           ? ""
                           : request.getParameter("encounter_id");
              episode_type = request.getParameter("episode_type") == null
                           ? ""
                           : request.getParameter("episode_type");
              patient_class = request.getParameter("patient_class") == null
                           ? ""
                           : request.getParameter("patient_class");

              try {

                     if (prev_sec_hdg_code.equals("*AmmendNotes*")) 
                     { //[IN033869]
                           prev_sec_hdg_code = "*AmmendNotes*";
                           prev_child_sec_hdg_code = prev_sec_hdg_code;
                     } //[IN033869]//IN033677

                     // NOTE :- Get the patient section and set it as a current section reference.
                     // It is very much important when the practitioner selects more than one patient for
                     // recording clinical notes. please be careful if you are going to change this jsp.

                     strKey = patient_id + "~" + encounter_id;
                     strKey = strKey.trim();

                     sectionBean.getPatientSection(strKey);

                     
     

                     
                     
                     if (!prev_sec_hdg_code.equals("*AmmendNotes*")
                                  && !prev_sec_hdg_code.equals("*AmmendNotes*")) {
                           prev_sec_content_type = sectionBean.getSectionType(
                                         prev_sec_hdg_code, prev_child_sec_hdg_code);
                           

                           
                           

                     }
                     if (!curr_sec_hdg_code.equals("")
                                  && !curr_sec_hdg_code.equals("*AmmendNotes*")) {
                           curr_section_type = sectionBean.getSectionType(
                                         curr_sec_hdg_code, curr_child_sec_hdg_code);

                     }

                     try {
                    	                    
                                  section_content = section_content.replace(
                                                "<ADDRESS>&nbsp;</ADDRESS><BR>",
                                                "<ADDRESS>&nbsp;</ADDRESS>"); //IN040265,IN040266
                                  section_content = section_content.replace("<P>",
                                                "<ADDRESS><P>"); //IN040265,IN040266
                                  section_content = section_content.replace("</P>",
                                                "</P></ADDRESS>"); //IN040265,IN040266
                                  if ("".equals(strRecordMode)) { //IN040265,IN040266                                
                                         sectionBean.setAddendumText(prev_sec_hdg_code,
                                                       prev_child_sec_hdg_code, section_content);
                                   } else {
                                         if ((!"".equals(curr_sec_hdg_code))
                                                       && (!"".equals(curr_child_sec_hdg_code))) {                                                
                                                sectionBean.setAddendumText(curr_sec_hdg_code,
                                                              curr_child_sec_hdg_code,
                                                              section_content);
                                         } else {                                        
                                                sectionBean.setAddendumText(prev_sec_hdg_code,
                                                              prev_child_sec_hdg_code,
                                                              section_content);
                                                }
                                  } //IN040265,IN040266

                                  
                                  if (!curr_child_sec_hdg_code.equals("*AmmendNotes*")) {
                                	  

                                         if (prev_sec_content_type.equals("T"))
                                                dummyValue = "<USER-TEMPLATE></USER-TEMPLATE>";
                                         else
                                                dummyValue = "<ADDRESS> </ADDRESS>";
                                         String strExistingContent = "";
                                         strExistingContent = (String) sectionBean
                                                       .getSectionContent(curr_sec_hdg_code,
                                                    		   curr_child_sec_hdg_code);
                                         

                                         
                                         if (strExistingContent == null
                                                       || strExistingContent.equals("")) {                                 
                                                sectionBean.setSectionContent(
                                                		curr_sec_hdg_code,
                                                		curr_child_sec_hdg_code, dummyValue);
                                                
                                                
                                         }
                                  }
                                  putObjectInBean("sectionBean", sectionBean, session);
                                  String getas=sectionBean.getAddendumText(prev_sec_hdg_code, prev_child_sec_hdg_code);
                                  

                           if (!(curr_sec_hdg_code.equals(""))) {
                                  section_content = (String) sectionBean.getAddendumText(
                                                curr_sec_hdg_code, curr_child_sec_hdg_code);
                           }
                           if (section_content == null)
                                  section_content = "";
                             section_content = java.net.URLEncoder.encode(
                                  section_content, "UTF-8");
                     } catch (Exception e) {
                           out.println("Exception @ NewRecClinicalNotesSectionAddendumControl.jsp "
                                         + e.toString());
                           e.printStackTrace();
                     }
              } catch (Exception eMain) {
                     out.println("Exception @ Main Addnendum Control"
                                  + eMain.toString());
                     eMain.printStackTrace();
              }

       
              
                  
                     
                           try {

                                  if (strAmMode.equals("*AmmendNotes*")) {
              
                     
                     
                           } else if (strAmMode.equals("SectionAmmend")) {
                     
                     
                     
                           } else if (strAmMode.equals("sectionView")) {
              
                     
              
                           } else if (strAmMode.equals("Preview")) {
              
                     
                     
                           }
                                  //if (strRecordMode.equals("RecordAddendum") )    [IN033677]
                                  if (strRecordMode.equals("RecordAddendum")
                                                || strRecordMode.equals("SignAddendum")) //[IN033677]
                                  {
                     
                     
                     
                           }
                                  //[IN033869] Start

                                  if (strRecordMode.equals("") && !strAmMode.equals("Preview")
                                                && operation_mode.equals("ModifyAddendum")) {//IN034160
       
                     
                     
                           }
                                 
                           } catch (Exception eSub) {
                                  out.println("Exception @ Addnencum Control" + eSub.toString());
                                  eSub.printStackTrace();
                           }
              
                           
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
