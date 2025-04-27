package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.*;

public final class __surgeryhistorycommonframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SurgeryHistoryCommonFrame.jsp", 1709117290000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<FRAMESET COLS=\'*,0%\' border=\'0\'>\t\n\t\t <FRAME NAME=\'RecordFrame\' SRC=\'../../eOT/jsp/SurgeryDetails.jsp?";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME>\n         <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n\t</FRAMESET>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n   <FRAMESET COLS=\'*,0%\' border=\'0\'>\t\n\t <FRAME NAME=\'RecordFrame\' SRC=\'../../eOT/jsp/SugeryHistoryPersonnel.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t  <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n </FRAMESET>\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n   <FRAMESET COLS=\'*,0%\' border=\'0\'>\t\n\t <FRAME NAME=\'RecordFrame\' SRC=\'../../eOT/jsp/SurgeryHistoryAllNotes.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'  scrolling=\'yes\' noresize=\'no\'></FRAME> \n\t <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n </FRAMESET>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n   <FRAMESET ROWS=\'22%,*\' border=\'0\'>\t\n\t<FRAME NAME=\'PostOperDiagFrame\' SRC=\'../../eOT/jsp/SurgeryHistoryDiagHdr.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t<FRAMESET COLS=\'0%,*\' border=\'0\'>\t\n\t    <FRAME NAME=\'RecordFrame\' SRC=\'../../eOT/jsp/PostOperDiagnosisRecord.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t    <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n  </FRAMESET>\n  </FRAMESET>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<!--<FRAMESET ROWS=\'4%,3%,*\' border=\'0\'>-->\n\t<FRAMESET ROWS=\'6%,*\' border=\'0\'>\n\t<FRAME name=\"euip_tab\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eOT/jsp/EquipmentTab.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"></FRAME>\n\t<!--<FRAME name=\"ChildTitleFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\"></FRAME>-->\n\t<FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n    </FRAMESET>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n   <FRAMESET COLS=\'0%,*\' border=\'0\'>\t\n\t <FRAME NAME=\'RecordFrame\' SRC=\'../../eOT/jsp/SpecimenRecord.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n </FRAMESET>\n\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n   <FRAMESET COLS=\'0%,*\' border=\'0\'>\t\n\t <FRAME NAME=\'RecordFrame\' SRC=\'../../eOT/jsp/NursingDisposalRecord.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'yes\' noresize=\'no\'></FRAME>\n </FRAMESET>\n\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n   <FRAMESET COLS=\'*,0%\' border=\'0\'>\t\n\t <FRAME NAME=\'RecordFrame\' SRC=\'SurgeryHistoryUnusualOccur.jsp?";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n </FRAMESET>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n   <FRAMESET COLS=\'*,0%\' border=\'0\'>\t\n\t <FRAME NAME=\'RecordFrame\' SRC=\'../../eOT/jsp/SurgeryHistoryPreOperChkList.jsp?";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n </FRAMESET>\n ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n </FRAMESET>\n <!--Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013-->\n <!--Start-->\n ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n </FRAMESET>\n <!--End-->\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n   <FRAMESET COLS=\'*,0%\' border=\'0\'>\t\n\t <FRAME NAME=\'RecordFrame\' SRC=\'../../eOT/jsp/SwabCountMain.jsp?";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t <FRAME NAME=\'DetailFrame\' SRC=\'../../eCommon/html/blank.html\'   scrolling=\'no\' noresize=\'no\'></FRAME>\n </FRAMESET>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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

//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.*" 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	String params = request.getQueryString(); 
	String tab_id = CommonBean.checkForNull(request.getParameter("parent_tab_id"));


            _bw.write(_wl_block3Bytes, _wl_block3);
 if(tab_id.equals("details_tab")){ 	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(params));
            _bw.write(_wl_block5Bytes, _wl_block5);
 } else if(tab_id.equals("personnel_tab")) {  
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(params));
            _bw.write(_wl_block7Bytes, _wl_block7);
 } else if(tab_id.equals("operative_record_tab")) { 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);
 } else if(tab_id.equals("post_oper_diagnosis_tab")) { 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);
 } else if(tab_id.equals("consumable_tab")) { 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
} else if(tab_id.equals("specimen_tab")) { 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);
} else if(tab_id.equals("disposal_tab")) { 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(params));
            _bw.write(_wl_block18Bytes, _wl_block18);
} else if(tab_id.equals("unusal_tab")) { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(params));
            _bw.write(_wl_block20Bytes, _wl_block20);
} else if(tab_id.equals("pre_oper_checklist_tab")) { 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(params));
            _bw.write(_wl_block22Bytes, _wl_block22);
} else if(tab_id.equals("post_oper_checklist_tab")) { 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(params));
            _bw.write(_wl_block23Bytes, _wl_block23);
} else if(tab_id.equals("intra_oper_checklist_tab")) { 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(params));
            _bw.write(_wl_block24Bytes, _wl_block24);
} else if(tab_id.equals("swab_count_tab")) { 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(params));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
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
