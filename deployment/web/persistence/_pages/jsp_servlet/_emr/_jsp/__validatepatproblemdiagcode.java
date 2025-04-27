package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __validatepatproblemdiagcode extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ValidatePatProblemDiagCode.jsp", 1709119132566L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n</head>\n<body CLASS=\'MESSAGE\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</script>\n</body>\n<html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con = null;  
PreparedStatement stmt=null;
ResultSet rs = null;
try
{
	String diag_code = request.getParameter("diag_code");
	String diag_scheme = request.getParameter("diag_scheme");
	String p_code_indicator = request.getParameter("p_code_indicator");
	String sex = request.getParameter("Sex");
	String dob = request.getParameter("Dob");
	String term_set_id = (request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id"));
	String sql = "";
	String isValid = "";
	con = ConnectionManager.getConnection(request);

	/*if(term_set_id.equals("ICD10"))
	{	
			sql = "select count(*) from mr_icd_code where diag_code=? and diag_code_scheme=?  and (gender_spec_ind is null or gender_spec_ind = ? ) and ( nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind IN (select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER )) ";
			
			if (!p_code_indicator.equals(""))
				sql = sql+ " and code_indicator=? ";
			else
				sql = sql+ " and (code_indicator in ('D','C') OR code_indicator IS NULL )";
			
			stmt=con.prepareStatement(sql);
			stmt.setString(1,diag_code);
			stmt.setString(2,diag_scheme);
			stmt.setString(3,sex);
			stmt.setString(4,dob);
			stmt.setString(5,dob);
			stmt.setString(6,dob);
			if (!p_code_indicator.equals(""))
				stmt.setString(7,p_code_indicator);
	}
	else
	{*/
		/*sql = "select count(*) from mr_d_"+term_set_id+"_vw a where a.term_set_id='"+term_set_id+"' and a.TERM_CODE='"+diag_code+"' and (a.gender_spec_ind is null or a.gender_spec_ind = '"+sex+"' ) and ( nvl(a.age_spec_ind,'O') NOT IN ('A','P','N') or a.age_spec_ind IN (SELECT CASE WHEN SYSDATE - TO_DATE ('"+dob+"', 'dd-mm-yyyy') BETWEEN   NVL (MIN_AGE, 0) * DECODE (AGE_UNIT, 'Y', 365,'M', 30, 'D', 1, 1 ) AND   NVL (MAX_AGE, 0) * DECODE (AGE_UNIT, 'Y', 365, 'M', 30, 'D', 1, 1 ) THEN 'Y' ELSE 'N'        END YYY FROM AM_AGE_GROUP A, MR_AGE_GRP_FOR_TERM_CODE B WHERE A.AGE_GROUP_CODE = B.AGE_GROUP_CODE AND B.TERM_SET_ID = '"+term_set_id+"' AND B.TERM_CODE =  '"+diag_code+"' ))";

		if (!p_code_indicator.equals(""))
			sql = sql+ " and a.code_indicator='"+p_code_indicator+"' ";
		else
			sql = sql+ " and (a.code_indicator in ('D','C') OR a.code_indicator IS NULL )";	*/
			

		sql = "SELECT CASE WHEN SYSDATE - TO_DATE ('"+dob+"', 'dd-mm-yyyy') BETWEEN   NVL (A.MIN_AGE, 0) * DECODE (A.AGE_UNIT, 'Y', 365,'M', 30, 'D', 1, 1 ) AND   NVL (A.MAX_AGE, 0) * DECODE (A.AGE_UNIT, 'Y', 365, 'M', 30, 'D', 1, 1 ) AND A.GENDER = '"+sex+"' THEN 'Y' ELSE 'N'   END ISVALID FROM AM_AGE_GROUP A, MR_AGE_GRP_FOR_TERM_CODE B WHERE  A.AGE_GROUP_CODE = B.AGE_GROUP_CODE AND B.TERM_SET_ID = '"+term_set_id+"' AND B.TERM_CODE =  '"+diag_code+"'";


		stmt=con.prepareStatement(sql);
	//}

	//out.println("<script>alert(\""+sql+"\");</script>");
	
	rs = stmt.executeQuery();
	//rs.next();

	if(rs!=null && rs.next())
	{	
		isValid = rs.getString("ISVALID");
	}

	//if(rs.getInt(1) == 0)
	if(isValid!=null && isValid.equals("Y"))
	{
		//out.println("alert(getCAMessage('INVALID_DIAG_CODE_FOR_PATIENT','CA'));");
		out.println("<script>alert(getMessage('MR_INVALID_DIAG_CODE_FOR_PATIENT','MR'));</script>");
	}
	else
	{
		out.println("<script>window.parent.parent.returnValue='" + diag_code + "';");	
		out.println("window.parent.parent.close();</script>");
	}

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();

}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
	
	if(con!=null)ConnectionManager.returnConnection(con, request);
}

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
