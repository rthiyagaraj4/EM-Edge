package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __calulateipdeposit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/CalulateIPDeposit.jsp", 1709114627867L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<head>\n<!--\n\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>\n-->\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<script>\n\n\t\t\tif(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' != \'0\')\n            {\n\t\t\t\n                var chk_code=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'.indexOf(\"**\");\n\t\t\t\tif(chk_code != -1)\n                {\n\t\t\t\t\talert(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'));\n\t\t\t\t\tparent.Main_frame.document.forms[0].dly_charge.value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t\tparent.Main_frame.document.forms[0].dep_amt.value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t\t\tparent.Main_frame.document.forms[0].pay_amt.value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'==\'Y\'){\n\t\t\t\t\t\tparent.Main_frame.document.forms[0].addDepReq.value=\'Y\'\n\t\t\t\t\t\tparent.Main_frame.document.forms[0].addDepReq.checked=true;\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tparent.Main_frame.document.forms[0].addDepReq.value=\'N\'\n\t\t\t\t\t\tparent.Main_frame.document.forms[0].addDepReq.checked=false;\n\t\t\t\t\t}\n\t\t\t\t</script>\");\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
	String patId = request.getParameter("patientId");
	String p_bed_class_code = request.getParameter("p_bed_class_code");
	String p_nursing_unit_code = request.getParameter("p_nursing_unit_code");
	String p_bed_no = request.getParameter("p_bed_no");
	//String facilityId = (String)session.getValue("facility_id"); 
	String setlmt_ind = request.getParameter("setlmt_ind");

	Connection con = null;
	CallableStatement cstmt = null;

	try 
	{
		con = ConnectionManager.getConnection(request);
		
			cstmt = con.prepareCall("{ call BL_CALCULATE_TOT_DEP_AMT(?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			cstmt.setString(1,patId);
			cstmt.setString(2,p_bed_class_code);
			cstmt.setString(3,p_nursing_unit_code);
			cstmt.setString(4,p_bed_no);
			cstmt.setString(5,setlmt_ind);

			cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7,java.sql.Types.INTEGER);
			cstmt.registerOutParameter(8,java.sql.Types.INTEGER);
			cstmt.registerOutParameter(9,java.sql.Types.INTEGER);
			cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);

			cstmt.execute();
			
			String dailyCharge = "";
			if(cstmt.getString(7)==null) dailyCharge= "";
			else dailyCharge = cstmt.getString(7);

			String addlDepReq = "";
			if(cstmt.getString(6)==null) addlDepReq= "" ;
			else addlDepReq =cstmt.getString(6);

			String depAmt = "";
			if(cstmt.getString(8)==null) depAmt= "";
			else depAmt =cstmt.getString(8);

			String totDepAmt = "";
			if(cstmt.getString(9)==null) totDepAmt= "";
			else totDepAmt = cstmt.getString(9);

			String errValue = cstmt.getString(13);

		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(errValue));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(errValue));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(errValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(errValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dailyCharge));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(depAmt));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(totDepAmt));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(addlDepReq));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	catch(Exception e) {
		out.println(e.toString());
	}
	finally {
		if (cstmt != null) cstmt.close();
		ConnectionManager.returnConnection(con, request);
	}


            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
