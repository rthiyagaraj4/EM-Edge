package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesfileuploaderror extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesFileUploadError.jsp", 1709116127264L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<head>\n\n<script language=\"JavaScript\">\n\nfunction onsuccess(operation_mode,accession_num,called_from)\n{\n\n/*if ( operation_mode == \"SignOnModify\" )\n{\n\talert(getCAMessage(\"RECORD_INSERTED\"));\t\n\t//top.opener.location.reload();\n\t//top.opener.parent.frames[1].location.reload();\n\ttop.close();\n}\nelse\n{*/\n\t\n\n\tif(top.content!=null )\n\t{\n\t\t\n\t\tif(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame!=null)\n\t\t{\n\t\t\t\n\t\t\tif(called_from == \"NOTES_HEADER\")\n\t\t\t{\n\t\t\t\t//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.accession_num.value = accession_num;\n\t\t\t/*\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value = accession_num;\n\n\t\t\t\tpatient_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;\n\t\t\t\tnote_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;\n\t\t\t\tfacility_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sel_facility_id.value;\n\t\t\t\tencounter_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;\n\t\t\t\tpatient_class = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_class.value;\n\t\t\t\tappl_task_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.appl_task_id.value;\t\t*/\n\t\t\t\t\n\t\t\t\t//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href = \'../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?note_type=\'+note_type+\'&facility_id=\'+facility_id+\'&encounter_id=\'+encounter_id+\'&patient_id=\'+patient_id+\'&patient_class=\'+patient_class+\'&appl_task_id=\'+appl_task_id+\'&accession_num=\'+accession_num+\'&called_from=NOTES_HEADER\';\n\n\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = false;\n\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = false;\n\t\t\t}else{\n\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.accession_num.value = accession_num;\n\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value = accession_num;\n\n\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = false;\n\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = false;\n\t\t\t}\n\t\t}\n\t}\n\t\t\n\t\tif(operation_mode == \"Sign\")\n\t\t{\n\t\t\talert(getMessage(\"RECORD_INSERTED\",\"CA\"));\t\n\t\t\tif(top.content!=null)\n\t\t\t{\n\t\t\t\tvar fn_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.function_id.value;\n\t\t\t\t\n\t\t\t\tif(fn_id==\"TASK_LIST\")\n\t\t\t\t{\n\t\t\t\t\ttop.close();\n\t\t\t\t\tif (top.opener && !top.opener.closed)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\ttop.opener.location.reload();\n\t\t\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.location.reload();\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t\twindow.close();\n\n\t\t}\n\t\telse if(operation_mode == \"UpdateSign\"  || operation_mode == \"UpdateRecord\" )\n\t\t{\n\t\t\tvar patient_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.patient_id.value;\n\t\t\tvar encounter_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.encounter_id.value;\n\t\t\tvar episode_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.episode_type.value;\n\t\t\tvar function_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.function_id.value;\n\t\t\tvar from_date_time = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.from_date_time.value;\n\t\t\tvar to_date_time = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.to_date_time.value;\n\t\t\tvar appl_task_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.appl_task_id.value;\n\t\t\tvar note_group = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.note_group.value;\n\t\t\tvar patient_class = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.patient_class.value;\n\t\t\tvar note_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.note_type.value;\n\t\t\t\n\t\t\tvar query_str = \"patient_id=\"+patient_id+\"&encounter_id=\"+encounter_id+\"&episode_type=\"+episode_type+\"&function_id=\"+function_id+\"&from_date_time=\"+from_date_time+\"&to_date_time=\"+to_date_time+\"&appl_task_id=\"+appl_task_id+\"&note_group=\"+note_group+\"&note_type=\"+note_type;\n\n\t\t\tif(operation_mode == \"UpdateRecord\" )\n\t\t\t{\n\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesTabsFrame.document.forms[0].query_string.value = query_str;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\talert(getMessage(\"RECORD_INSERTED\",\"CA\"));\t\n\t\t\t\ttop.content.workAreaFrame.location.href  = \"../../eCA/jsp/RecClinicalNotes.jsp?patient_id=\"+patient_id+\"&encounter_id=\"+encounter_id+\"&episode_type=\"+episode_type+\"&function_id=\"+function_id+\"&from_date_time=\"+from_date_time+\"&to_date_time=\"+to_date_time+\"&appl_task_id=\"+appl_task_id+\"&patient_class=\"+patient_class;\n\t\t\t}\n\t\t}\n\t\telse if(operation_mode == \"Forward\" || operation_mode == \"MakeAsError\" || operation_mode == \"Delete\" || operation_mode == \"SignOnModify\")\n\t\t{\n\t\t\t\n\t\t\tif((operation_mode == \"SignOnModify\" || operation_mode == \"Delete\" ) && top.content==null)\n\t\t\t{\n\t\t\t\t\twindow.close();\n\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar query_string = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].query_string.value;\n\t\t\t\tvar note_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchCriteriaFrame.document.forms[0].note_type.value\n\t\t\t\talert(getMessage(\"RECORD_INSERTED\",\"CA\"));\t\n\t\t\t\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.location.href  = \"../../eCA/jsp/RecClinicalNotesSearchResult.jsp?\"+query_string+\"&note_type=\"+note_type;\n\t\t\t}\n\t\t}\n//}\t\n\t\n}\n\nfunction enable_buttons()\n{\n\nif(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame!=null)\n{\n\n\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = false;\n\ttop.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = false;\n}\n\n}\n</script>\n</head>\n\n<BODY CLASS=\"MESSAGE\" onKeyDown=\"lockKey()\">\n\n<p align=\"left\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</p>\n</BODY>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String error=request.getParameter( "err_num" );

	if ( error != null ) {
		
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");
		String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
		
		if(error.equals("FILE_SIZE_NOT_SUPPORTED") || error.equals("FILE_NOT_SUPPORTED"))
		{
			out.println("<script>alert(getMessage('"+error+"'))</script>");
		}
	else
		{
		//out.println("<script>alert('+error_value==="+error_value+"')</script>");
		if(operation_mode.equals("Record") || operation_mode.equals("UpdateRecord") || operation_mode.equals("Update") || operation_mode.equals("UpdateSign") ||  error_value.equals( "0" ) ||  error_value.equals("false"))
			out.println( error ) ;
		}
		if ( error_value.equals( "1" ) ||  error_value.equals("true")){
			out.println( "<script language='JavaScript'>onsuccess('"+operation_mode+"','"+accession_num+"','"+called_from+"');</script>" ) ;
		}

		if(!operation_mode.equals("Delete")){
				out.println( "<script language='JavaScript'>enable_buttons();</script>" ) ;
		}

	}


            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
