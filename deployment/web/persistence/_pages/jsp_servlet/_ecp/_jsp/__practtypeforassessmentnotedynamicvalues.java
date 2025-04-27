package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __practtypeforassessmentnotedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/PractTypeForAssessmentNoteDynamicValues.jsp", 1726036419531L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n</head>\n<body CLASS=\'MESSAGE\'>\n\t<form name=Dynamic_form>\n\t\t<input type=hidden name=E value=\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'>\n\t\t<input type=hidden name=R value=\'\'>\n\t\t<input type=hidden name=S value=\'\'>\n\t\t<input type=hidden name=X value=\'\'>\n\t\t<input type=hidden name=Y value=\'\'>\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*  File Name		:	PractTypeForAssessmentNoteDyanamicValues.jsp
*	Purpose 			:	to Store the selected practitioner type into the RecordSet
*	Created By		:	Subbulakshmy. K
*	Created On		:	30-12-2004
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

//This file is saved on 18/10/2005.
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locale=(String)session.getAttribute("LOCALE");
	Connection con = null;
	PreparedStatement pstmt_practType=null;
	ResultSet rs_practType=null;
	String clearAll="";
	String assess_note_id="";
	try{
		assess_note_id=request.getParameter("assess_note_id")==null?"":request.getParameter("assess_note_id");
		clearAll = request.getParameter("clearAll")==null?"":request.getParameter("clearAll");

		RecordSet	PractTypeForAssessmentNote	=	null;
		PractTypeForAssessmentNote	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractTypeForAssessmentNote");

		if(clearAll.equals("clearAll")){
			PractTypeForAssessmentNote.clearAll();
		}
		else if(clearAll.equals("notCleared")){
			con = ConnectionManager.getConnection(request);
//			String sql_practType="select  pract_type, desc_userdef pract_type_desc,'I' db_action from am_pract_type where pract_type not in(select pract_type from cp_assess_note_pract_type where assess_note_id = ?) union all select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from cp_assess_note_pract_type a, am_pract_type b where a.assess_note_id = ? and b.pract_type = a. pract_type order by 2";
			String sql_practType="select  pract_type, desc_userdef pract_type_desc,'I' db_action from am_pract_type_lang_vw where pract_type not in(select pract_type from cp_assess_note_pract_type where assess_note_id = ?) and language_id=? union all select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from cp_assess_note_pract_type a, am_pract_type_lang_vw b where a.assess_note_id = ? and b.pract_type = a. pract_type and language_id=? order by 2";

			pstmt_practType=con.prepareStatement(sql_practType);
			pstmt_practType.setString(1,assess_note_id);
			pstmt_practType.setString(2,locale);
			pstmt_practType.setString(3,assess_note_id);
			pstmt_practType.setString(4,locale);
			rs_practType=pstmt_practType.executeQuery();
			while(rs_practType.next()){
				if(!(PractTypeForAssessmentNote.containsObject(rs_practType.getString(1))))
					PractTypeForAssessmentNote.putObject(rs_practType.getString(1));
			}
		}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block3Bytes, _wl_block3);

	}
	catch(Exception e){out.print(e);}
		finally{

		if(rs_practType!=null)
			  rs_practType.close();
		if(pstmt_practType!=null)
			  pstmt_practType.close();
		ConnectionManager.returnConnection(con,request);

	  }

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
