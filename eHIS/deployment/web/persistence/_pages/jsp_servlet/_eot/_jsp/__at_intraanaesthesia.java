package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.CommonBean;
import java.util.*;
import com.ehis.util.*;

public final class __at_intraanaesthesia extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_IntraAnaesthesia.jsp", 1709120154000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordIntraAnesthesia.js\"></script>\n\t<script>\n\t\tfunction reset(){\n\t\tvar formObj=parent.parent.frames[2].document.forms[0];\n\t\tif(formObj.weight.disabled==false ||formObj.height.disabled==false||formObj.bsa.disabled==false||formObj.bmi.disabled==false){\n\t\t\tformObj.weight.value=\"\";\n\t\t\tformObj.height.value=\"\";\n\t\t\tformObj.bsa.value=\"\";\n\t\t\tformObj.bmi.value=\"\";\n\t\t\tformObj.anaesthesia_desc.value=\"\";\n\t\t\tformObj.start_date.value=\"\";\n\t\t\tformObj.start_time.value=\"\";\n\t\t\tformObj.finish_date.value=\"\";\n\t\t\tformObj.finish_time.value=\"\";\n\t\t\tif(parent.parent.frames[5].document.forms[0].remarks_tab.value==\"personal_details\"){\n\t\t\t\tparent.parent.frames[5].frames[0].document.forms[0].pract_type.value=\"\";\n\t\t\t\tparent.parent.frames[5].frames[0].document.forms[0].practitioner_name.value=\"\";\n\t\t\t}\n\t\t\t if (parent.parent.frames[8].document.forms[0].intraop_done.checked==true){\n\t\t\t\t parent.parent.frames[8].document.forms[0].intraop_done.checked=false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<TITLE>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</TITLE>\n <frameset rows=\'3%,10%,35%,4%,*,0%,0%,10%,10%\'> \n\n\t<frame name=\"commontoolbarFrame\" frameborder=\"0\" src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" noresize scrolling=\'no\'>\n\t<frame name=\"OtPatientLineFrame\" frameborder=\"0\" src=\"../../eOT/jsp/OTPatLineFrame.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" noresize scrolling=\'auto\'>\n\t<frame name=\'intra_anesth_header_frame\' src=\"../../eOT/jsp/AT_IntraAnaesHeader.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" frameborder=\"0\" nowrap noresize scrolling=\'no\' >\n\t<frameset rows=\'0,*\'>\n\t\t<frame name=\'Intra_anesthesia_objectcollect_frame\' src=\'../../eOT/jsp/AT_IntraAnaesObjectCollect.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' frameborder=\"0\" nowrap noresize scrolling=\'no\' >\n\t\t<frame name=\'Intra_anesth_header_tabs_frame\' \tsrc=\"../../eOT/jsp/AT_IntraAnaesTabs.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" frameborder=\"0\" nowrap noresize scrolling=\'no\' >\n\t</frameset>\n\t<frame name=\'intra_anesth_tab_details_frame\'\t src=\'../../eOT/jsp/AT_IntraAnaesTabFrames.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=\"0\" nowrap noresize scrolling=\'auto\' > \n\t<frame name=\'dummy_frame\' src=\'../../eCommon/html/blank.html\' frameborder=\"0\" nowrap noresize >\n\t<frame name=\'dummy_frames\' src=\'../../eCommon/html/blank.html\' frameborder=\"0\" nowrap noresize > \n\t<frame name=\'intra_doc_status_frame\' src=\'../../eOT/jsp/AT_IntraAnaesDocStatus.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' nowrap noresize  > \n\t<frame name=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=\"0\" nowrap noresize scrolling=\'no\'>\n</frameset>\n</html>\n\n\n\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");	
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String source="";
	String title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,
	"eOT.IntraAnaesthesia.Label","ot_labels")+",";
	String param=request.getQueryString();
	String facility_id				=request.getParameter("facility_id");
	String anesthesia_srl_no		=request.getParameter("anesthesia_srl_no");
	String intraop_done_yn="",source_order_id = "";
	Connection connection   = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		  String sql_preop= "SELECT INTRAOP_DONE_YN INTRAOP_DONE_YN1, SOURCE_ORDER_ID FROM AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";
		  connection	= ConnectionManager.getConnection(request);
		  pstmt=connection.prepareStatement(sql_preop);
		  pstmt.setString(1,facility_id);
		  pstmt.setString(2,anesthesia_srl_no); 
		  rs=pstmt.executeQuery();
		  if(rs.next())
		  {
			intraop_done_yn=CommonBean.checkForNull(rs.getString("INTRAOP_DONE_YN1"));
			source_order_id=CommonBean.checkForNull(rs.getString("SOURCE_ORDER_ID"));
		  }
	}catch(Exception ee){
		System.err.println("Exception=="+ee);
	}
	finally{
		try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) ConnectionManager.returnConnection(connection,request);
             }catch(Exception es){es.printStackTrace();}
	}

	param=param+"&intraop_done_yn="+intraop_done_yn;

	if(intraop_done_yn.equals("Y")){	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NNNNY&home_required_yn=N";
	}else if(intraop_done_yn.equals("N") || intraop_done_yn.equals("")) {
	source="../../eCommon/jsp/commonToolbar.jsp?module_id=AT&function_type=F&menu_id=AT_JAVA_DFLT&access=NYNNY&home_required_yn=N";
	}
	param=param+"&source_order_id="+source_order_id;


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(title));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(param));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(param));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(param));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(param));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(param));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(param));
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
