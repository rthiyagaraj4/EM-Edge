package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotessectionaddendumcontrol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesSectionAddendumControl.jsp", 1709116191309L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t?           \tcreated\n23/07/2012\t\tIN034160\t\tDinesh T\t\tPrintpreview function clears the contents in the addendum editor\n19/09/2012\t\tIN033677\t\tDinesh T\t\tCRF-Recording and signing the addendum with new free text editor and uncommented \t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\tsome part of the code\n03/06/2013\t\tIN040265\t\tRamesh G\t\tIssue 1: At print preview the addendum details displayed as \"Addendum Created by\"  instead of \"Addendum Recorded by\"\n\t\t\t\t\t\t\t\t\t\t\t\tIssue 2: Addendum details  displayed twice.\n03/06/2013\t\tIN040266\t\tRamesh G\t\tIssue 1: Record Clinical Notes->Search Tab->Update->System is displaying the updated text in different font in Print Preview and Print.\n\t\t\t\t\t\t\t\t\t\t\t\tIssue 2: Chart Summary->Lab Results->Note Type text data is displayed in different font.\n\t\t\t\t\t\t\t\t\t\t\t\tIssue 3: OT Surgeon Notes->System is displaying the text in different font in Print Preview and Print.\n------------------------------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\t\tRev.Date\tRev.Name\t\tDescription\n------------------------------------------------------------------------------------------------------------------------------\n27/07/2018\tIN068105\tRaja S\t\t\t27/07/2018\t    Ramesh G\t\tMMS-DM-CRF-0143\n18/03/2020\tIN071264\tNijitha S\t    18/03/2020\t\tRamesh G\t    GHL-CRF-0604\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="<!--IN071264-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<script>\nfunction recordSectionDetails()\n{\n\tparent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.target =\tmessageFrameReference.name;\n\tparent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action\t=\t\'../../servlet/eCA.RecClinicalNotesServlet\';\n\tparent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.method\t=\t\'post\';\n\tparent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.submit();\n\n\t/*\n\tparent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.target =\tmessageFrameReference.name;\n\tparent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.action\t=\t\'../../servlet/eCA.NewRecClinicalNotesServlet\';\n\tparent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.method\t=\t\'post\';\n\tparent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.submit();\n\t*/\n}\n\nfunction callMeToGetTextAreaValue()\n{\n\t fnEnableLinks();\n\tdocument.GetTextAreaForm.target = parent.RecClinicalNotesSecDetailsFrame.name;\n\tdocument.GetTextAreaForm.submit();\n}\nfunction fnEnableLinks(){\t\n\t\tparent.frameSetIdMessage.rows=\'*%,0%\'\n\t\tcompressSectionFrames();\n\t}\n//[IN033869] Start\nfunction callMeToGetEditorValue(){\n\tdocument.GetEditorForm.target = parent.RecClinicalNotesSecDetailsEditorFrame.name;\n\tdocument.GetEditorForm.submit();\n}\n//[IN033869] End\n</script>\n<BODY  style=\"background-color:\'#D8D8ED\'\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'RecClinicalNotesSecControlForm\' id=\'RecClinicalNotesSecControlForm\' method=\'post\' >\n\t<table align=\'center\' cellspacing=2 cellpadding=3 border=1 width=\'100%\' height=\'100%\'>\n\t<input type= hidden name = note_type value = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t<input type= hidden name = accession_num value = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t<input type= hidden name = operation_mode value = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t<input type= hidden name = section_content value = \'\'>\n</form>\n<form name=\'GetTextAreaForm\' id=\'GetTextAreaForm\' method=\'post\' action=\'../../eCA/jsp/RecClinicalNotesAddendumHeader.jsp\' >\n\t<input type=\'hidden\' name=\'txtAreaValue\' id=\'txtAreaValue\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n</form>\n<!-- [IN033869] Start -->\n<form name=\'GetEditorForm\' id=\'GetEditorForm\' method=\'post\' action=\'../../eCA/jsp/RecClinicalNotesAddendumEditorsFrame.jsp\'>\n\t<input type= hidden name =\'accession_num\' value = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t<input type= hidden name =\'curr_sec_hdg_code\' value = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'><!--IN033677-->\n\t<input type= hidden name =\'curr_child_sec_hdg_code\' value = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'><!--IN033677-->\n\t<input type= hidden name = note_type value = \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'><!--IN071264-->\n\t<input type= hidden name = patient_id value = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'><!--IN071264-->\n\t<input type= hidden name = encounter_id value = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'><!--IN071264-->\n</form>\n<!-- [IN033869] End. -->\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<script>\n\t\t\t\t//alert(\"ammend notes..content view...\"+\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\");\n\t\t\t\tchangeEditorTitle(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\");\n\t\t\t\tparent.RecClinicalNotesContentViewFrame.location.href = \'../../eCA/jsp/RecClinicalNotesContentView.jsp?accession_num=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&operation_mode=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&note_type=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\';\n\t\t\t\tcallMeToGetTextAreaValue();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<script>\n\t\t\t\t//alert(\"section ammend ..SectionAddendumView...\"+\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\");\n\t\t\t\tparent.RecClinicalNotesContentViewFrame.location.href = \"../../eCA/jsp/RecClinicalNotesSectionAddendumView.jsp?sec_hdg_code=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&sec_content_type=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&child_sec_hdg_code=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&patient_id=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&encounter_id=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\tcallMeToGetTextAreaValue();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<script>\n\t\t\t\tparent.frameSetIdMessage.rows=\'*%,0%\';\n\t\t\t\t//alert(\'curr_sec_hdg_code...\'+\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'+\'...editor_title...\'+\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'+\'....note_type....\'+\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'+\'.....accession_num....\'+\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');\n\t\t\t\tparent.RecClinicalNotesContentViewFrame.location.href = \'../../eCA/jsp/RecClinicalNotesSectionView.jsp?sec_hdg_code=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&editor_title=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&accession_num=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&addendum=Y&patient_id=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<script>\n\t\t\t\tparent.frameSetIdMessage.rows=\'*%,0%\';\n//\t\t\tparent.RecClinicalNotesSecDetailsFrame.location.href = \'../../eCA/jsp/NewRecClinicalNotesSectionAddendumView.jsp?note_type=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\';\n\t\t\t//IN037701 Starts\n\t\t\t//var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;\t\n\t\t\tvar Obj =  \"\"\n\t\t\tif(undefined!= top.content && undefined!= top.content.workAreaFrame && undefined!= top.content.workAreaFrame.RecClinicalNotesFrame )\n\t\t\t{\n\t\t\t\tObj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;\t\n\t\t\t}\t\n\t\t\telse\n\t\t\t{\n\t\t\t\tObj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;\t\n\t\t\t}\n\t\t\t//IN037701 Ends\n\t\t\tvar note_title\t\t\t= \"\";\n\t\t\tvar med_service\t\t\t= \"\";\n\t\t\tvar event_date_time\t\t= \"\";\n\t\t\tvar performed_by_name\t= \"\";\n\n\t\t\tevent_date_time\t\t= Obj.event_date_time.value;\n\t\t\tperformed_by_name\t= Obj.performing_phy_name.value;\n\t\t\tnote_title\t\t\t= Obj.event_title_desc.value;\n\n\t\t\tif(Obj.serv_disp != null)\n\t\t\t\tmed_service\t\t\t= Obj.serv_disp.value;\n\t\t\t//IN068105\n\t\t\tvar noteCopiedYN = \"\";\n\t\t\tif(parent.RecClinicalNotesToolbarFrame!=undefined)\n\t\t\t\tnoteCopiedYN=parent.RecClinicalNotesToolbarFrame.document.getElementById(\"noteCopiedYN\").value\n\t\t\t//IN068105\n\t\t\tvar url =\'../../eCA/jsp/RecClinicalNotesPrintPreview.jsp?note_type=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&episode_type=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&patient_class=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&note_title=\'+encodeURIComponent(note_title)+\'&med_service=\'+encodeURIComponent(med_service)+\'&event_date_time=\'+event_date_time+\'&performed_by_name=\'+encodeURIComponent(performed_by_name);\n\t\t\turl=url+\'&noteCopiedYN=\'+noteCopiedYN; //IN068105\n\t\t\twindow.open(url,\'Document\',\'height=570,width=790,top=0,left=0,resizable=yes,scrollbars=yes\' ); \t\t\t\t\t\t\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<script>recordSectionDetails()</script>\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<script>\n\t\t\tcallMeToGetEditorValue();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	//IN071264 Starts
	String addendum_text_temp = "";
	String auto_save_yn ="N";
	CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
	auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
	//IN071264 Ends
	
	//sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code)

            _bw.write(_wl_block6Bytes, _wl_block6);

	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String		section_content						  = "";
String		curr_sec_hdg_code					  = "";
String		curr_child_sec_hdg_code				  = "";
String		dummyValue							  = "";
String		patient_id 							  = "";
String		note_type							  = "";
String		prev_sec_hdg_code					  = "";
String		prev_child_sec_hdg_code				  = "";
String		prev_sec_content_type	 			  = "";
String		editor_title					 	  = "";
String		accession_num						  = "";
String		operation_mode						  = "";
String		strAmMode							  = "";
String		strRecordMode						  = "";
String		curr_section_type					  = "";
String		encounter_id							  = "";
String		episode_type							  = "";
String		patient_class							  = "";
String	    strKey									  =	"";

curr_sec_hdg_code			= request.getParameter("curr_sec_hdg_code")==null?"":request.getParameter("curr_sec_hdg_code");
curr_child_sec_hdg_code		= request.getParameter("curr_child_sec_hdg_code")==null?curr_sec_hdg_code:request.getParameter("curr_child_sec_hdg_code");
prev_sec_hdg_code			= request.getParameter("prev_sec_hdg_code")==null?"":request.getParameter("prev_sec_hdg_code");
prev_child_sec_hdg_code		= request.getParameter("prev_child_sec_hdg_code")==null?prev_sec_hdg_code:request.getParameter("prev_child_sec_hdg_code");
patient_id					= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
section_content				= request.getParameter("section_content")==null?"":request.getParameter("section_content");

note_type					= request.getParameter("note_type")==null?"":request.getParameter("note_type");
editor_title				= request.getParameter("editor_title")==null?"Addendum To Note":request.getParameter("editor_title");
accession_num				= request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
operation_mode				= request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");
strAmMode					= request.getParameter("ammend_mode")==null?"":request.getParameter("ammend_mode");
strRecordMode				= request.getParameter("record_mode")==null?"":request.getParameter("record_mode");
encounter_id				= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
episode_type				= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
patient_class				= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");

try
{

		if(prev_sec_hdg_code.equals("") )  //[IN033869]
		{									//[IN033869]
			prev_sec_hdg_code		= "*AmmendNotes*";
			prev_child_sec_hdg_code = prev_sec_hdg_code;
		}		//[IN033869]//IN033677

		


		// NOTE :- Get the patient section and set it as a current section reference.
		// It is very much important when the practitioner selects more than one patient for
		// recording clinical notes. please be careful if you are going to change this jsp.

		strKey	= patient_id + "~"+encounter_id;
		strKey = strKey.trim();

		sectionBean.getPatientSection(strKey);

		if(!prev_sec_hdg_code.equals("") && !prev_sec_hdg_code.equals("*AmmendNotes*")  )
	{
			prev_sec_content_type	= sectionBean.getSectionType(prev_sec_hdg_code,prev_child_sec_hdg_code);
		
	}
		if(!curr_sec_hdg_code.equals("") && !curr_sec_hdg_code.equals("*AmmendNotes*") )
	{	curr_section_type		= sectionBean.getSectionType(curr_sec_hdg_code,curr_child_sec_hdg_code);
		
	}
		
		try
		{
			if(!section_content.equals("") )
			{				
				section_content = section_content.replace("<ADDRESS>&nbsp;</ADDRESS><BR>","<ADDRESS>&nbsp;</ADDRESS>");  //IN040265,IN040266
				section_content = section_content.replace("<P>","<ADDRESS><P>"); //IN040265,IN040266
				section_content = section_content.replace("</P>","</P></ADDRESS>"); //IN040265,IN040266
				if("".equals(strRecordMode)){	//IN040265,IN040266
					//IN071264 Starts
					sectionBean.setAddendumText(prev_sec_hdg_code,prev_child_sec_hdg_code, section_content);
					if("Y".equals(auto_save_yn)){
						 if(prev_sec_hdg_code.equals("*AmmendNotes*"))
						{
							//addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("*tempAmmendNotes*","*tempAmmendNotes*");
							sectionBean.setAddendumText("*tempAmmendNotes*","*tempAmmendNotes*", section_content);
							//sectionBean.setAddendumText("*AmmendNotes*","*AmmendNotes*", section_content);
						} 
						 else
							sectionBean.setAddendumText("temp"+prev_sec_hdg_code,"temp"+prev_child_sec_hdg_code, section_content);
						
					
					}
					
					
					//IN071264 Ends
				}else{
					if((!"".equals(curr_sec_hdg_code)) && (!"".equals(curr_child_sec_hdg_code))){
						sectionBean.setAddendumText(curr_sec_hdg_code,curr_child_sec_hdg_code, section_content);
					}else{
						sectionBean.setAddendumText(prev_sec_hdg_code,prev_child_sec_hdg_code, section_content);
					}					
				}	//IN040265,IN040266
				if(!prev_sec_hdg_code.equals("*AmmendNotes*"))
				{	
					if(prev_sec_content_type.equals("T"))
						dummyValue="<USER-TEMPLATE></USER-TEMPLATE>";
					else
						dummyValue="<ADDRESS> </ADDRESS>";

					String strExistingContent = "";
					
					strExistingContent = (String) sectionBean.getSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code);

					
					if( strExistingContent == null || strExistingContent.equals("") ){	
						sectionBean.setSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code, dummyValue);
					}
				}

						
				putObjectInBean("sectionBean",sectionBean,session);
			}
			

			if( !(curr_sec_hdg_code.equals("")) ){
				//IN071264 Starts
				//section_content = (String) sectionBean.getAddendumText(curr_sec_hdg_code,curr_child_sec_hdg_code);
				  if("Y".equals(auto_save_yn) &&  operation_mode.equals("ModifyAddendum")){
					 if(curr_sec_hdg_code.equals("*AmmendNotes*"))
						addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("*tempAmmendNotes*","*tempAmmendNotes*");
					 else
					 	addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("temp"+curr_sec_hdg_code,"temp"+curr_child_sec_hdg_code);
				 }
				 if(null!=addendum_text_temp && !"".equals(addendum_text_temp)){
					 section_content = addendum_text_temp;
				 }
				 else{
					 section_content = (String) sectionBean.getAddendumText(curr_sec_hdg_code,curr_child_sec_hdg_code);
				 }
				//IN071264 Ends
			}
			
			if(section_content == null)
				section_content = "";

			section_content			=	java.net.URLEncoder.encode(section_content,"UTF-8");
		}
		catch(Exception e)
		{
			//out.println("Exception @ NewRecClinicalNotesSectionAddendumControl.jsp "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
}
catch (Exception eMain)
{
		//out.println("Exception @ Main Addnendum Control"+eMain.toString());//COMMON-ICN-0181
		eMain.printStackTrace();
}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(section_content));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

try
	{
		
		if(strAmMode.equals("*AmmendNotes*"))
		{
			
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strAmMode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(editor_title));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block25Bytes, _wl_block25);

		}
		else if(strAmMode.equals("SectionAmmend"))
		{
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strAmMode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(editor_title));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(curr_section_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block32Bytes, _wl_block32);

		}
		else if( strAmMode.equals("sectionView") )
		{
			
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(editor_title));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(editor_title));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block41Bytes, _wl_block41);

		}
	else if(strAmMode.equals("Preview"))
	{
		
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block46Bytes, _wl_block46);

	}
		//if (strRecordMode.equals("RecordAddendum") )    [IN033677]
		if (strRecordMode.equals("RecordAddendum") || strRecordMode.equals("SignAddendum") )   //[IN033677]
		{
			
            _bw.write(_wl_block47Bytes, _wl_block47);

		}
		//[IN033869] Start
		if(strRecordMode.equals("") && !strAmMode.equals("Preview") && operation_mode.equals("ModifyAddendum")){//IN034160
			
            _bw.write(_wl_block48Bytes, _wl_block48);

		}
		//[IN033869] End.
	}
	catch (Exception eSub)
	{
		//out.println("Exception @ Addnencum Control"+eSub.toString());//common-icn-0181
		eSub.printStackTrace();
	}



            _bw.write(_wl_block49Bytes, _wl_block49);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
