package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __currentencountermain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/CurrentEncounterMain.jsp", 1732286233841L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t\n\t<iframe name=\'pline\' id=\'pline\' \tsrc=\"../../eCommon/jsp/pline.jsp?P_MODULE_ID=IP&P_FUNCTION_ID=MODIFY_SERVICE_FOR_INPATIENT&EncounterId=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&Facility_Id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" frameborder=0 scrolling=no style=\'height:10vh;width:98vw\'></iframe>\n\t<iframe name=\'CurEnc\' id=\'CurEnc\' src=\'../jsp/CurrentEncounter.jsp?LastDet=1&patientId=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&encounterId=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' noresize  frameborder=no scrolling=\"auto\" style=\'height:31vh;width:98vw\'></iframe>\n\t<iframe name=\'LastAdmissionRes\' id=\'LastAdmissionRes\'  src=\'../jsp/LastAdmissionResult.jsp?function_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&LastDet=1&encounter_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&patientId=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' noresize  frameborder=no scrolling=\"auto\" style=\'height:80vh;width:98vw\'></iframe>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\n\t<iframe name=\'pline\' id=\'pline\' \tsrc=\"../../eCommon/jsp/pline.jsp?P_MODULE_ID=IP&P_FUNCTION_ID=MODIFY_SERVICE_FOR_INPATIENT&EncounterId=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' noresize  frameborder=no scrolling=\"auto\" style=\'height:36vh;width:98vw\'></iframe>\n\t<iframe name=\'LastAdmissionRes\' id=\'LastAdmissionRes\'  src=\'../jsp/LastAdmissionResult.jsp?function_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&Filename=CurrentEncounterMain&LastDet=1&encounter_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' noresize  frameborder=no scrolling=\"auto\" style=\'height:40vh;width:98vw\'></iframe>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<iframe name=\'pline\' id=\'pline\' \tsrc=\"../../eCommon/jsp/pline.jsp?P_MODULE_ID=IP&P_FUNCTION_ID=MODIFY_SERVICE_FOR_INPATIENT&EncounterId=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' noresize  frameborder=no scrolling=\"auto\" style=\'height:27vh;width:98vw\'></iframe>\n\t<iframe name=\'ChangeAdmisonDtlsFrame\' id=\'ChangeAdmisonDtlsFrame\'  src=\'../jsp/ChangedAdmissionResult.jsp?encounter_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' noresize  frameborder=no scrolling=\"auto\" style=\'height:27vh;width:98vw\'></iframe>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</head>\n</html>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
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
            _bw.write(_wl_block5Bytes, _wl_block5);

   request.setCharacterEncoding("UTF-8");
	String facilityId		= (String)session.getValue("facility_id");
	String patientId		= checkForNull(request.getParameter("patientId"));
	String encounter_id		= checkForNull(request.getParameter("encounterId"));
	String frfunction		= checkForNull(request.getParameter("p_fr_function"));
	String call_function	= checkForNull(request.getParameter("call_function"));
	String ENC_MODIFIED_YN	="N";
	String title			= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CurrentEncounterDetails.label","ip_labels");
	if(frfunction.equals("IP"))
	title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.staydetails.label","common_labels");

            _bw.write(_wl_block1Bytes, _wl_block1);

		//String url="../../eCommon/jsp/commonToolbar.jsp?";
		//String params = request.getQueryString() ;
		//String source = url + params ;
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
		Connection con					= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

	try{
	con = ConnectionManager.getConnection(request);
	String MODIFIED_YN_Qry		=	"Select ENC_MODIFIED_YN from ip_open_encounter where facility_id='"+facilityId+"' and encounter_id='"+encounter_id+"'";
	pstmt=con.prepareStatement(MODIFIED_YN_Qry);
	rs=pstmt.executeQuery();
	if(rs.next()&&rs!=null){
		ENC_MODIFIED_YN	=checkForNull(rs.getString("ENC_MODIFIED_YN"),"N");
	}else{
		ENC_MODIFIED_YN	="N";
	}
	}catch(Exception ex){
		
		ex.printStackTrace();
	}finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con,request); 
	}


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(title));
            _bw.write(_wl_block7Bytes, _wl_block7);
	if (call_function.equals("QueryDischarge")) {
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	else
	{	
		if(ENC_MODIFIED_YN.equals("N")){
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
	} 
            _bw.write(_wl_block23Bytes, _wl_block23);
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
