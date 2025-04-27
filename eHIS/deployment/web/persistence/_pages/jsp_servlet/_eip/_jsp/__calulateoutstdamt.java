package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.op.CurrencyFormat;

public final class __calulateoutstdamt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/CalulateOutStdAmt.jsp", 1741325082257L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<script language=\"JavaScript\">\n\tasync function crAuthorize(patId,outAmt) {\n\n\t\tvar retVal = new Array();\n\t\tvar dialogHeight= \"19\" ;\n\t\tvar dialogWidth\t= \"34\" ;\n\t\tvar dialogTop = \"170\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tretVal = await window.showModalDialog(\"../../eBL/jsp/dispCreditAuth.jsp?patient_id=\"+patId+\"&outst_amt=\"+outAmt,arguments,features);\n\t\tif(retVal[0]==\'N\') {\n\t\t\tparent.Select_frame.document.forms[0].patient_id.value=\'\';\n\t\t\tparent.Select_frame.document.forms[0].patient_id.focus();\n\t\t\tparent.Select_frame.document.forms[0].encounter_id.focus();\n\t\t\tparent.Select_frame.document.forms[0].patient_id.focus();\n\t\t}\n\t\telse { InsureChk(patId);}\n\t\t\n\t}\n\tfunction InsureChk(patId) {\n\t\tvar HTMLVal = new String();\n\t\tif( patId != \"\" || patId !=null ) {\n\t\t\tHTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'InsureChk\' id=\'InsureChk\' method=\'post\' action=\'../../eBL/jsp/IPAdmitInsureChk.jsp\'><input name=\'patientId\' id=\'patientId\' type=\'hidden\' value=\'\"+patId+\"\'></form></BODY></HTML>\";\n\t\t\tdocument.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\tdocument.InsureChk.submit();\n\t\t}\n\t}\n\n</script>\n<head><script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script></head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n</body>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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

	request.setCharacterEncoding("UTF-8"); 
	String patId = request.getParameter("patientId");
	String facilityId = (String)session.getValue("facility_id"); 

	boolean isBlInterfaced=false;
	Connection con = null;
	Statement stmt = null;
	CallableStatement cstmt = null;
	ResultSet rs1 = null;
	int retVal=0;
	int minOutstAmt = 0;
	String crAuth = "N";
	String strRetval="";
	
	try {
		con = (Connection) session.getValue("connection");
		stmt = con.createStatement();
		rs1 = stmt.executeQuery("Select BL_INTERFACED_YN,nvl(OUTST_AMT_LIMIT,0) OUTST_AMT_LIMIT,nvl(CREDIT_AUTH_REQD_YN,'N')CREDIT_AUTH_REQD_YN from ip_param where facility_id='"+facilityId+"'");
		if(rs1.next()) {
			minOutstAmt = rs1.getInt("OUTST_AMT_LIMIT");
			crAuth = rs1.getString("CREDIT_AUTH_REQD_YN");
			if(rs1.getString("BL_INTERFACED_YN").equals("Y")) isBlInterfaced=true;
			else isBlInterfaced=false;
		}
		
		if(isBlInterfaced) 
		{
			cstmt = con.prepareCall("{ call BL_CALCULATE_OUTST_AMT(?,?) }");
			cstmt.setString(1,patId);
			cstmt.registerOutParameter(2,2);
			cstmt.execute();
			retVal= cstmt.getInt(2);
			strRetval =""+retVal;

			CurrencyFormat cf1 = new CurrencyFormat();
			strRetval = cf1.formatCurrency(strRetval, 2);

			if(retVal>0){
				out.println("<script>parent.Pline_frame.document.getElementById('outstdAmt').innerText='Outstanding Amt.  "+strRetval+"    '</script>");
			}
			if( (retVal>minOutstAmt) && crAuth.equals("Y") ){
				out.println("<script>crAuthorize('"+patId+"','"+retVal+"');</script>");
			}
			else {
				out.println("<script>InsureChk('"+patId+"');</script>");	
			}
		}
		
	
		if(rs1!=null) rs1.close();
		if(cstmt!=null) cstmt.close();
		if(stmt!=null) stmt.close();
	
	}catch(Exception e) {
		out.println(e.toString());
	}
	finally {
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
