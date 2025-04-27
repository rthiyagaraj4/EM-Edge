package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __oatransferappointmentwrapper extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OATransferAppointmentWrapper.jsp", 1709119249537L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="  \n\n<html>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t<script>\n\t\twindow.name = \'myModal\';\n\t\tfunction loadPage(){\n\t\t\t//alert(\'loadPage:\'+document.getElementById(\"rule_transfer\").value);\n\t\t\t/*document.getElementById(\"rule_transfer\").value =\'N\';\n\t\t\talert(res_type)\n\t\t\talert(document.getElementById(\"res_type\").value)\n\t\t\tif(document.OATrnsfApptWarpperForm){\n\t\t\t\tdocument.OATrnsfApptWarpperForm.submit();\n\t\t\t}*/\n\t\t\tif(document.getElementById(\"rule_transfer\") && document.getElementById(\"rule_transfer\").value ==\'\'){\n\t\t\t\tif((document.getElementById(\"rule_appl_yn\") && document.getElementById(\"rule_appl_yn\").value==\'Y\') && (document.getElementById(\"res_type\") && document.getElementById(\"res_type\").value == \'P\')){\n\t\t\t\t\tif(window.confirm(getMessage(\"RESH_APPT_PRACT_UNKNOWN\",\"OA\"))){\n\t\t\t\t\t\tdocument.getElementById(\"rule_transfer\").value =\'Y\';\n\t\t\t\t\t\tdocument.OATrnsfApptWarpperForm.submit();\n\t\t\t\t\t}else{\n\t\t\t\t\t\tdocument.getElementById(\"rule_transfer\").value =\'N\';\n\t\t\t\t\t\tdocument.OATrnsfApptWarpperForm.submit();\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\tdocument.getElementById(\"rule_transfer\").value =\'N\';\n\t\t\t\t\tdocument.OATrnsfApptWarpperForm.submit();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<body onload=\'loadPage()\'>\n\t\t<form name=\'OATrnsfApptWarpperForm\' id=\'OATrnsfApptWarpperForm\' action=\"../../eOA/jsp/OATransferAppointmentWrapper.jsp\" target=\'myModal\'>\n\t\t\t<input type=\'hidden\' name=\'rule_transfer\' id=\'rule_transfer\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t\t\t<input type=\'hidden\' name=\'i_appt_ref_no\' id=\'i_appt_ref_no\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t<input type=\'hidden\' name=\'res_type\' id=\'res_type\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t<input type=\'hidden\' name=\'alcn_criteria\' id=\'alcn_criteria\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t<input type=\'hidden\' name=\'i_from_time\' id=\'i_from_time\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t<input type=\'hidden\' name=\'i_to_time\' id=\'i_to_time\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t<input type=\'hidden\' name=\'i_clinic_code\' id=\'i_clinic_code\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t<input type=\'hidden\' name=\'i_practitioner_id\' id=\'i_practitioner_id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t<input type=\'hidden\' name=\'new_appt_date\' id=\'new_appt_date\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t<input type=\'hidden\' name=\'i_appt_date\' id=\'i_appt_date\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t<input type=\'hidden\' name=\'appt_day1\' id=\'appt_day1\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t<input type=\'hidden\' name=\'visit_type_ind\' id=\'visit_type_ind\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t<input type=\'hidden\' name=\'i_team_id\' id=\'i_team_id\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t\t<input type=\'hidden\' name=\'over_booked\' id=\'over_booked\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\t\t\t\n\t\t\t<input type=\'hidden\' name=\'Forced\' id=\'Forced\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t<input type=\'hidden\' name=\'clinic_type\' id=\'clinic_type\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<input type=\'hidden\' name=\'rule_appl_yn\' id=\'rule_appl_yn\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t</form>\n\t</body>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<iframe name=\'trnaferFrame\' id=\'trnaferFrame\' src=\'../../eOA/jsp/TransferAppointmentFrame.jsp?";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' noresize frameborder=0 scrolling=\'no\' style=\'height:100vh;width:100vw\'></iframe>\t\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<iframe name=\'trnaferFrame\' id=\'trnaferFrame\' src=\'../../eOA/jsp/RuleBasedTransferFrame.jsp?";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		String rule_transfer	= request.getParameter("rule_transfer")==null?"":request.getParameter("rule_transfer");
		String i_appt_ref_no	= request.getParameter("i_appt_ref_no");
		String res_type			= request.getParameter("res_type");
		String alcn_criteria	= request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
		String i_from_time		= request.getParameter("i_from_time")==null?"":request.getParameter("i_from_time");
		String i_to_time 		= request.getParameter("i_to_time")==null?"":request.getParameter("i_to_time");
		String i_clinic_code	= request.getParameter("i_clinic_code")==null?"":request.getParameter("i_clinic_code");
		String i_practitioner_id= request.getParameter("i_practitioner_id")==null?"":request.getParameter("i_practitioner_id");
		String new_appt_date	= request.getParameter("new_appt_date")==null?"":request.getParameter("new_appt_date");
		String i_appt_date		= request.getParameter("i_appt_date")==null?"":request.getParameter("i_appt_date");
		String appt_day1		= request.getParameter("appt_day1")==null?"":request.getParameter("appt_day1");
		String visit_type_ind	= request.getParameter("visit_type_ind")==null?"":request.getParameter("visit_type_ind");
		String i_team_id		= request.getParameter("i_team_id")==null?"":request.getParameter("i_team_id");
		String over_booked		= request.getParameter("over_booked")==null?"":request.getParameter("over_booked");
		String Forced			= request.getParameter("Forced")==null?"":request.getParameter("Forced");
		String clinic_type		= request.getParameter("clinic_type")==null?"":request.getParameter("clinic_type");
		String order_id			= request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String s=request.getQueryString();
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String rule_appl_yn ="N";
		if(rule_transfer.equals("")){
			try{
				con=ConnectionManager.getConnection(request);
				String oa_paramSQL="select rule_appl_yn  from oa_param where module_id='OA' ";
				pstmt=con.prepareStatement(oa_paramSQL);
				rs = pstmt.executeQuery();
				if (rs !=null && rs.next()){
					rule_appl_yn= rs.getString("rule_appl_yn")==null?"N":rs.getString("rule_appl_yn");
				}			
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rule_transfer));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(i_appt_ref_no));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i_from_time));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i_to_time));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i_clinic_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i_practitioner_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(new_appt_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i_appt_date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(appt_day1));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i_team_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(over_booked));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rule_appl_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(con!=null) 	ConnectionManager.returnConnection(con,request);
			}
		}else if(rule_transfer.equals("N")){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(s));
            _bw.write(_wl_block27Bytes, _wl_block27);
}else if(rule_transfer.equals("Y")){
			String apptrefno = request.getParameter("i_appt_ref_no");
			s=s+"&apptrefno="+apptrefno;
		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(s));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
