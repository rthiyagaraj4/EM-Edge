package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotesmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesMain.jsp", 1739431353103L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>RecClinicalNotesMain</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script language=\'javascript\'>\n\n\tfunction getMessageFrame()\n\t{\n\t\tif(undefined != top.content && top.content!=null)//IN037701\n\t\t\treturn top.content.messageFrame;\n\t\telse\n\t\t\treturn top.messageframe;\n\t}\n\t\n\tvar messageFrameReference = getMessageFrame();\n\t\n\tfunction clearMessageFrame()\n\t{\n\t\t//IN037701 Starts\n\t\t//messageFrameReference.location.href = \'../../eCommon/jsp/error.jsp\';\n\t\tif(undefined != messageFrameReference && null!=messageFrameReference.location)\n\t\t\tmessageFrameReference.location.href = \'../../eCommon/jsp/error.jsp\';\n\t\telse\n\t\t\ttop.messageframe.location.href = \'../../eCommon/jsp/error.jsp\';\n\t\t//IN037701 Ends\n\t}\n\t\n\tfunction clearBean()\n\t{\n\t\t//IN037701 Starts\n\t\t//messageFrameReference.location.href = \'../../eCA/jsp/RecClinicalNotesClearBean.jsp?patient_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\tif(undefined != messageFrameReference && null!=messageFrameReference.location)\n\t\t\tmessageFrameReference.location.href = \'../../eCA/jsp/RecClinicalNotesClearBean.jsp?patient_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\telse\n\t\t\ttop.messageframe.location.href = \'../../eCA/jsp/RecClinicalNotesClearBean.jsp?patient_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t//IN037701 Ends\t\n\n\t}\n</script>\n</head>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<frameset rows=\'20%,73%,7%,0%,5%\' framespacing=\'0\' frameborder=\'0\' onLoad=\'clearMessageFrame()\' onunLoad=\"clearBean()\" name=\'frameSetIdHeader\' id=\'frameSetIdHeader\'> \t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<frameset rows=\'20%,73%,7%,0%\' framespacing=\'0\' frameborder=\'0\' onLoad=\'clearMessageFrame()\' onunLoad=\"clearBean()\" id=\'frameSetIdHeader\' name=\'frameSetIdHeader\'> \n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<frameset rows=\'100%,0%\' framespacing=\'0\' frameborder=\'0\' onLoad=\'clearMessageFrame()\' onunLoad=\"clearBean()\" id=\'frameSetIdHeader\' name=\'frameSetIdHeader\'> \n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<frameset rows=\'40%,50%,10%,0%\' framespacing=\'0\' frameborder=\'0\' onLoad=\'clearMessageFrame()\' onunLoad=\"clearBean()\" id=\'frameSetIdHeader\' name=\'frameSetIdHeader\'>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t<frame name=\"RecClinicalNotesHeaderFrame\" id=\"RecClinicalNotesHeaderFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesHeader.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&srl_no=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" style=\"height:40%; width: 100vw;\"> <!-- [IN033677] -->\n\t</frame>\n\t<frameset cols=\'30%,70%,0%\' frameborder=1 id=\'frameSetIdSection\' name=\'frameSetIdSection\' >\n\t\t<frameset rows=\'*%,0%\' frameborder=0  id=\'frameSetIdMessage\' names=\'frameSetIdMessage\'>\n\t\t\t<frame name=\"RecClinicalNotesSectionFrame\" id=\"RecClinicalNotesSectionFrame\" frameborder=\"1\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesSection.jsp?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></frame>\n\t\t\t<frame name=\"processMsgframe\" id=\"processMsgframe\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesProcessControlMsg.jsp\"></frame>\n\t\t</frameset>\t\t\t\n\t\t<!-- <frameset rows=\'6%,42%,52%\' frameborder=1 id=frameSetIdAddendum>  [IN32064]-->\n\t\t<frameset rows=\'6%,42%,6%,46%\' frameborder=1 id=\'frameSetIdAddendum\' name=\'frameSetIdAddendum\'>\n\t\t\t<frame name=\"EditorTitleFrame\" id=\"EditorTitleFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t</frame>\n\t\t    <frame name=\"RecClinicalNotesContentViewFrame\" id=\"RecClinicalNotesContentViewFrame\" frameborder=\"1\" scrolling=\"auto\" noresize src=\"../../eCA/jsp/RecClinicalNotesContentView.jsp?";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t</frame>\n\t\t\t<frame name=\"RecClinicalNotesSecDetailsFrame\" id=\"RecClinicalNotesSecDetailsFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesAddendumHeader.jsp?";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t</frame>\n\t\t\t<!-- [IN033869] Start-->\n\t\t\t<!--<frame name=\"RecClinicalNotesRTEditorFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RTEditor.jsp?content_editable_yn=&editor_param=R\"> \n\t\t\t</frame>-->\n\t\t\t<frame name=\"RecClinicalNotesSecDetailsEditorFrame\" id=\"RecClinicalNotesSecDetailsEditorFrame\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n\t\t\t<!-- [IN033869] End-->\n\t\t</frameset>\n\t<frame name=\"RecClinicalNotesSecControlFrame\" id=\"RecClinicalNotesSecControlFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesSectionAddendumControl.jsp?";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t</frame>\n\t</frameset>\n\t<frame name=\"RecClinicalNotesToolbarFrame\" id=\"RecClinicalNotesToolbarFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesToolbar.jsp?";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t</frame>\n\t<frame name=\"RecClinicalNotesSecTempControlFrame\" id=\"RecClinicalNotesSecTempControlFrame\" frameborder=\"0\" scrolling=\"no\" noresize >\t</frame>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\n\t<frame name=\"messageframe\" id=\"messageframe\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/jsp/error.jsp\"></frame>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<!-- <frame name=\"RecClinicalNotesHeaderFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesHeader.jsp?";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"></frame>-->\n\t<frame name=\"RecClinicalNotesHeaderFrame\"  id=\"RecClinicalNotesHeaderFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesHeader.jsp?";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&display=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" marginheight=\"0\" marginwidth=\"0\" style=\"height:40%; width: 100vw;\"></frame>\n\t<frameset cols=\'30%,70%,0%\' frameborder=1 id=\'frameSetIdSection\' name=\'frameSetIdSection\'>\n\t\t<frameset rows=\'*%,0%\' frameborder=0  id=\'frameSetIdMessage\' name=\'frameSetIdMessage\'>\n\t\t\t<frame name=\"RecClinicalNotesSectionFrame\" id=\"RecClinicalNotesSectionFrame\" frameborder=\"1\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesSection.jsp?";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></frame>\n\t\t\t<frame name=\"processMsgframe\" id=\"processMsgframe\"  frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesProcessControlMsg.jsp\"></frame>\n\t\t</frameset>\t\t\t\t\t\n\t\t<frameset rows=\'10%,90%\' frameborder=1>\n\t\t\t<frame name=\"EditorTitleFrame\" id=\"EditorTitleFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></frame>\n\t\t\t<frame name=\"RecClinicalNotesSecDetailsFrame\" id=\"RecClinicalNotesSecDetailsFrame\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n\t\t</frameset>\n\t\t<frame name=\"RecClinicalNotesSecControlFrame\"  id=\"RecClinicalNotesSecControlFrame\"  frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesSectionControl.jsp?";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"></frame>\n\t</frameset>\n\t<frame name=\"RecClinicalNotesToolbarFrame\" id=\"RecClinicalNotesToolbarFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesToolbar.jsp?";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"></frame>\n\t<frame name=\"RecClinicalNotesSecTempControlFrame\" id=\"RecClinicalNotesSecTempControlFrame\" frameborder=\"0\" scrolling=\"no\" noresize ></frame>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<frameset rows=\'15%,*,0%\' frameborder=0>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<frameset rows=\'*%\' frameborder=0>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<frame name=\"RecClinicalNotesSearchToolbarFrame\" id=\"RecClinicalNotesSearchToolbarFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesSearchToolbar.jsp?";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"></frame>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<frame name=\"RecClinicalNotesSearchDetailsFrame\" id=\"RecClinicalNotesSearchDetailsFrame\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCA/jsp/RecClinicalNotesSearchDetails.jsp?";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></frame> \n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<frame name=\"messageframe\" id=\"messageframe\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/jsp/error.jsp\"></frame> \n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t</frameset>\n\t<!--IN038840 Ends-->\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"></frame>-->\n\t<frame name=\"RecClinicalNotesHeaderFrame\" id=\"RecClinicalNotesHeaderFrame\" frameborder=\"no\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesHeader.jsp?";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" style=\"height:40%; width: 100vw;\"></frame>\n\t<frameset cols=\'30%,70%,0%\' frameborder=1 id=\'frameSetIdSection\' name=\'frameSetIdSection\'>\n\t\t<frameset rows=\'*%,0%\' frameborder=0  id=\'frameSetIdMessage\' name=\'frameSetIdMessage\'>\n\t\t\t<frame name=\"RecClinicalNotesSectionFrame\"   id=\"RecClinicalNotesSectionFrame\" frameborder=\"1\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n\t\t\t<frame name=\"processMsgframe\" id=\"processMsgframe\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesProcessControlMsg.jsp\"></frame>\n\t\t</frameset>\t\t\n\t\t<frameset rows=\'10%,90%\' frameborder=1>\n\t\t\t<frame name=\"EditorTitleFrame\" id=\"EditorTitleFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"></frame>\n\t\t\t<frame name=\"RecClinicalNotesSecDetailsFrame\" id=\"RecClinicalNotesSecDetailsFrame\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n\t\t</frameset>\n\t\t<frame name=\"RecClinicalNotesSecControlFrame\" id=\"RecClinicalNotesSecControlFrame\" frameborder=\"0\" scrolling=\"yes\" noresize src=\"../../eCA/jsp/RecClinicalNotesSectionControl.jsp?";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"></frame>\n\t</frameset>\n\t<frame name=\"RecClinicalNotesToolbarFrame\" id=\"RecClinicalNotesToolbarFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCA/jsp/RecClinicalNotesToolbar.jsp?function_id=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&appl_task_id=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&doc_linked_note_yn=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></frame>\n\t\n\t<frame name=\"RecClinicalNotesSecTempControlFrame\" id=\"RecClinicalNotesSecTempControlFrame\" frameborder=\"0\" scrolling=\"no\" noresize ></frame>\n\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n</frameset>\n</html>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );
	
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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
23/03/2013		IN038840		Nijitha			CRF-CA- CHL-CRF-0011/05- Social History Widget->If the Role is modified after sign note we get script error   								 
02/06/2014		IN037701		Nijitha			SKR-CRF-0036   								 
15/02/2018	 	IN063799		Prakash C	15/02/2018		Ramesh		ML-MMOH-CRF-0808
27/05/2020		IN072879		SIVABAGYAM M		27/05/2020		RAMESH G		MMS-DM-SCF-0688
-------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	

            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	String operation_mode				=	"";
	String function_id					=	"";
	String doc_linked_note_yn			=	"";
	String patient_id					=	"";
	String encounter_id					=	"";
	String appl_task_id					=	"";
	String accessnum					= 	"";	//[IN033677]
	String facility_id					=	""; //[IN033677]
	String srl_no						=	"";
	String location_code="",speciality_name="";//IN072879
	//String rttext						=	"";commented for checkstyle

		String p_called_from_widget= request.getParameter("p_called_from_widget");//IN038840
		String p_soc_his= request.getParameter("p_soc_his");//IN038840
		String p_create_mode= request.getParameter("p_create_mode");//IN038840
	//StringBuffer traceBeanOBJ					=	new StringBuffer();

	operation_mode		= (request.getParameter("operation_mode")==null) ? "" : request.getParameter("operation_mode");
	String p_called_from = (request.getParameter("p_called_from")==null) ? "" : request.getParameter("p_called_from");//IN037701
	function_id			= request.getParameter("function_id")==null?"":request.getParameter("function_id");
	doc_linked_note_yn	= request.getParameter("doc_linked_note_yn")==null?"N":request.getParameter("doc_linked_note_yn");
	patient_id			= (request.getParameter("patient_id")==null) ? "" : request.getParameter("patient_id");
	encounter_id		= (request.getParameter("encounter_id")==null) ? "" : request.getParameter("encounter_id");
	
	appl_task_id			=	(request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");
	//[IN033677] Start
	facility_id			= (String)session.getValue("facility_id"); //[IN033677]
	accessnum			= (request.getParameter("accession_num")==null)?"":request.getParameter("accession_num");  //[IN033677]
	location_code=(request.getParameter("location_code")==null)?"":request.getParameter("location_code");  //IN072879
	speciality_name=(request.getParameter("speciality_name")==null)?"":request.getParameter("speciality_name"); //IN072879
	
	//[IN033677] End
	//IN063799 starts
	Connection con  = null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String display = "Y";
			try{
				
				String sql ="Select EMPTY_GRD_MAT_DISP_YN from CA_PARAM";
				con = ConnectionManager.getConnection() ;	
				pstmt = con.prepareStatement(sql);
				resultSet	= pstmt.executeQuery();

				while(resultSet.next())
					{
					 display  = resultSet.getString("EMPTY_GRD_MAT_DISP_YN")==null?"":resultSet.getString("EMPTY_GRD_MAT_DISP_YN");
					}
			}catch( Exception e )	
			{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;			
			} 
		finally 
			{
				
				if(pstmt !=null) pstmt.close();
				if(resultSet !=null)resultSet.close();
				if(con !=null) con.close();
			}
	//IN063799 ends

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);

	String strKey = "";

	strKey = patient_id + "~" + encounter_id;
	strKey = strKey.trim();

	//traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesMain.jsp at 8  ====>>>"+sectionBean+"   strKey   :    "+strKey+"   session   :   "+session);

	sectionBean.removePatientSection(strKey);	
	sectionBean.startPatientSection(strKey);	
	// Test Code
	
//	String resultKey = sectionBean.getpropPatientSection(strKey);	
	//traceBeanOBJ.append("patientKey Existance in Bean RecClinicalNotesMain.jsp at 70  ====>>>"+resultKey+"  sectionBean   :   "+sectionBean+"   session   :   "+session+"**encounter_id**"+encounter_id+"**patient_id**"+patient_id+"**Login User**"+(String)session.getValue("login_user"));
	//Test Code End
	
	putObjectInBean("sectionBean",sectionBean,session); 
	
//	traceBeanOBJ.append("patientKey Existance in Bean RecClinicalNotesMain.jsp at 70  ====>>>"+sectionBean.getpropPatientSection(strKey)+"  sectionBean   :   "+sectionBean+"   session   :   "+session+"**encounter_id**"+encounter_id+"**patient_id**"+patient_id+"**Login User**"+(String)session.getValue("login_user"));


System.out.println("RecClinicalNotesMain.jsp==================>"+request.getQueryString());
if(operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") )
{
  //IN037701 Starts	
  if("CA_SPC".equals(p_called_from)){
		
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
}
//IN037701 Ends
//IN038840 Starts
}else if(("CA_SOCIAL_HISTORY".equals(p_called_from_widget) || "Y".equals(p_soc_his) )  && operation_mode.equals("") && "N".equals(p_create_mode) )
{

            _bw.write(_wl_block14Bytes, _wl_block14);

//IN038840 Ends
}else {

            _bw.write(_wl_block15Bytes, _wl_block15);
}
if( operation_mode.equals("ModifyAddendum") )
{ 

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block24Bytes, _wl_block24);

	//IN037701 Starts
	if("CA_SPC".equals(p_called_from)){
	
            _bw.write(_wl_block25Bytes, _wl_block25);
}//IN037701 Ends
}
else if(operation_mode.equals("Update") || operation_mode.equals("ModifySection"))
{

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(display));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block33Bytes, _wl_block33);

	//IN037701 Starts
	if("CA_SPC".equals(p_called_from)){
	
            _bw.write(_wl_block25Bytes, _wl_block25);
}
	//IN037701 Ends
}
//IN038840 Starts
else if(("CA_SOCIAL_HISTORY".equals(p_called_from_widget) || "Y".equals(p_soc_his)) && null!=p_called_from_widget && operation_mode.equals("") && "N".equals(p_create_mode) )
{

            _bw.write(_wl_block34Bytes, _wl_block34);
if(!"Y".equals(p_soc_his))
				{
            _bw.write(_wl_block35Bytes, _wl_block35);

		}else{
            _bw.write(_wl_block36Bytes, _wl_block36);

		}
            _bw.write(_wl_block34Bytes, _wl_block34);
if(!"Y".equals(p_soc_his))
		{
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block38Bytes, _wl_block38);

		}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block40Bytes, _wl_block40);
if(!"Y".equals(p_soc_his))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);

		}
            _bw.write(_wl_block42Bytes, _wl_block42);
}
	
else
{
	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(display));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(doc_linked_note_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);

}

            _bw.write(_wl_block50Bytes, _wl_block50);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
