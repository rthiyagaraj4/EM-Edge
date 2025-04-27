package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;

public final class __clinstudpatactivediagnosisdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinStudPatActiveDiagnosisDetails.jsp", 1709115767717L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<title>Active Diagnosis</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	java.sql.Connection		con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet		rs = null;
	
	

	String	patient_id		=	(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
	String	facility_id		=	(request.getParameter("facility_id")==null?"":request.getParameter("facility_id"));
	String	local			=	(request.getParameter("local")==null?"":request.getParameter("local"));
	String	term_set_id		=	(request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id"));
	String	diagnew1		=	(request.getParameter("diagnew1")==null?"":request.getParameter("diagnew1"));
	String	diagnew2		=	(request.getParameter("diagnew2")==null?"":request.getParameter("diagnew2"));
	String	diagnew3		=	(request.getParameter("diagnew3")==null?"":request.getParameter("diagnew3"));
	
	StringBuffer	outPutDetails	=	new StringBuffer();
	StringBuffer sql =new StringBuffer("SELECT DISTINCT   MTC.SHORT_DESC from MR_TERM_CODE_LANG_VW MTC,PR_DIAGNOSIS PD where MTC.TERM_CODE=PD.TERM_CODE and PD.PATIENT_ID= ? AND PD.ADDED_FACILITY_ID=? AND MTC.LANGUAGE_ID=?");
	/*if(!term_set_id.equals("")){			
		sql.append(" AND PD.TERM_SET_ID='"+term_set_id+"'");
	}
	if(!diagnew1.equals("") || !diagnew2.equals("") || !diagnew3.equals("")){
				
				sql.append(" AND PD.TERM_CODE IN(");
				
				int i=0;
				if (!diagnew1.equals("")){
					sql.append("'"+diagnew1+"'");
					i++;
				}  
				if (!diagnew2.equals("")){
					if(i>0)
						sql.append(",");
					sql.append("'"+diagnew2+"'");
					i++;
				}
				if (!diagnew3.equals("")){
				 if(i>0)
						sql.append(",");
					sql.append("'"+diagnew3+"'");
					i++;
				}		
				sql.append(")");	
	}*/
	try{
		con	= ConnectionManager.getConnection(request);
		pstmt	= con.prepareStatement(sql.toString());
		pstmt.setString(1, patient_id);
		pstmt.setString(2, facility_id);
		pstmt.setString(3, local);

		rs = pstmt.executeQuery();		
		while(rs.next()){
			  outPutDetails.append(rs.getString("SHORT_DESC")+"<br>");
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
	}catch(Exception e){
			e.printStackTrace();
			//out.println("Exception from ClinicalStudiesPatientListHistDetails.jsp " + e.toString());//COMMON-ICN-0181
	}finally{
			if(con != null) ConnectionManager.returnConnection(con, request);
	}	
	out.println(outPutDetails.toString());

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
