package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __recdiagnosisevidencedtladdmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisEvidenceDtlAddModify.jsp", 1709119020473L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisGetValidation.jsp", 1730014091638L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\n<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n</html>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n    ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCA/html/CAStyle.css\"></link>\n<script src=\'../../eMR/js/RecDiagnosisMain.js\' language=\'javascript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'100%\'  align=center>\n\t<form name=\'recDiagnosisEvidenceForm\' id=\'recDiagnosisEvidenceForm\' >\n\t<TH>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th> \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</form>\n</table>\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale						= checkForNull((String)session.getAttribute("LOCALE"));
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	PreparedStatement pstmt = null;
	ResultSet rs		= null;
	String factorcode="",factordesc="",flag_yn="";
	String slClassValue = "";
	String checked = "";
	int ilCount = 0;
	int srl_num	=0;
	String p_factor_type="";
	String as_evidenced_by_fact		= checkForNull(request.getParameter("as_evidenced_by_fact"));

	StringTokenizer st_as_evidenced_by_fact = new StringTokenizer(as_evidenced_by_fact,"~");
	String Patient_Id				= checkForNull(request.getParameter("Patient_Id"));
	String term_set_id				= checkForNull(request.getParameter("term_set_id"));
	String term_code				= checkForNull(request.getParameter("term_code"));
	String occur_srl_no_hid			=request.getParameter("occur_srl_no_hid");
	String factor_type="";
	String header = "";
	int flag = 0;
	String nature= request.getParameter("nature")==null?"":request.getParameter("nature");
	//nature="";
	if(nature.equals("A")){
		p_factor_type="related";
		factor_type="RL";
		header = "Related factors";
	}
	else if(nature.equals("P")){
		p_factor_type="risk";
		factor_type="RS";
		header = "Risk factors";
	}


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(header));
            _bw.write(_wl_block8Bytes, _wl_block8);

	con = ConnectionManager.getConnection(request);
	StringBuffer sql = new StringBuffer();

try
{
	if(!nature.equals("W")&& !nature.equals(""))
	{
		if( occur_srl_no_hid != null)
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select max(STATUS_SRL_NO) srl_num from PR_DIAGNOSIS_EVIDENCE ");
			sql.append("where patient_id=? and term_set_id=? and term_code=? and occur_srl_no=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,Patient_Id);
			pstmt.setString(2,term_set_id);
			pstmt.setString(3,term_code);
			pstmt.setString(4,occur_srl_no_hid);
			rs= pstmt.executeQuery();
			if(rs.next())
			srl_num=rs.getInt("srl_num");
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" select decode(a.FACTOR_CODE,'','N','Y') flag_YN,b.FACTOR_CODE,b.SHORT_DESC	from "); 
		sql.append("PR_DIAGNOSIS_EVIDENCE a,mr_factor_lang_vw b where b.factor_code =a.FACTOR_CODE(+) and "); 
		sql.append(" a.PATIENT_ID(+) =? and a.term_set_id(+) =? and a.term_code(+) =? ");
		sql.append(" and b.EFF_STATUS='E' and a.status_srl_no(+) =? and language_id=? and (exists (select 1 from mr_factor_for_term_code where TERM_SET_ID=? and TERM_CODE=? and FACTOR_CODE=b.FACTOR_CODE ) or NOT EXISTS (SELECT 1 FROM MR_FACTOR_FOR_TERM_CODE WHERE TERM_SET_ID=? AND TERM_CODE =?)) ");
		
		
		if(p_factor_type.equals("related"))
		{
			sql.append("and related_factor_yn='Y' order by 2,3");
		}
		else if(p_factor_type.equals("risk"))
		{
			sql.append(" and risk_factor_yn='Y' order by 2,3");
		}
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,Patient_Id);
		pstmt.setString(2,term_set_id);
		pstmt.setString(3,term_code);
		pstmt.setInt(4,srl_num);
		pstmt.setString(5,locale);
		pstmt.setString(6,term_set_id);
		pstmt.setString(7,term_code);
		pstmt.setString(8,term_set_id);
		pstmt.setString(9,term_code);
		rs= pstmt.executeQuery();
		while(rs.next())
		{
			flag = 1;
			st_as_evidenced_by_fact = new StringTokenizer(as_evidenced_by_fact, "~");
			factorcode	= rs.getString("FACTOR_CODE");
			factordesc		= rs.getString("SHORT_DESC");
			flag_yn		= rs.getString("FLAG_YN");
			if(flag_yn.equals("Y"))
			{
				checked="checked";
			}
			else
			{
				checked="";
			}
			while(st_as_evidenced_by_fact.hasMoreTokens())
			{
				String fact_code = (String) st_as_evidenced_by_fact.nextToken();
				if(factorcode.equals(fact_code))
				{
					checked = "checked";
				}
			}
			out.println("<tr>");
			slClassValue= ((ilCount % 2) == 0) ? "QRYEVEN" : "QRYODD";
			
			out.println("<td class='"+slClassValue+"'><input type='checkbox' name= 'evidence"+ilCount+"' value='"+factorcode+"' "+checked +" onclick='checkforOK(this);'> &nbsp;&nbsp;"+factordesc+"</td>");
			ilCount++;
			out.println("</tr>");
		}
		if(flag == 0)
		{
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
			out.println("<script>parent.rec_evidence_cols.cols='0%,*';</script>");
		}
		out.println("<input type='hidden' name='ilCount' id='ilCount' value='"+ilCount+"'>");
		out.println("<input type='hidden' name='Eve_factor_type' id='Eve_factor_type' value='"+factor_type+"'>");
	
	}
		out.println("<input type='hidden' name='flag' id='flag' value='"+flag+"'>");
		if(flag ==0)
		{
			out.println("<script>parent.rec_evidence_cols.cols='0%,*';</script>");
		}
}
catch(Exception e)
{
	//out.println("Exception in RecDiagnosisEvidenceDtlAddModify.jsp :"+e.toString());
	e.printStackTrace();
}
finally
{
	
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(con != null)ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
