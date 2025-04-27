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

public final class __assessmentbasedterminologycodedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/AssessmentBasedTerminologyCodeDynamicValues.jsp", 1724909803061L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

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
            webbeans.eCommon.RecordSet TerminologyCode= null;synchronized(session){
                TerminologyCode=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologyCode",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologyCode==null){
                    TerminologyCode=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologyCode",TerminologyCode,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
Connection con						=		null;
PreparedStatement pstmt				=		null;
ResultSet rs						=		null;
String validate						=		request.getParameter("validate");
ArrayList TabList					=		null;
ArrayList sessionList				=		(ArrayList)TerminologyCode.getRecordSetHandle();
	 //This file is saved on 18/10/2005.
if(sessionList.size()>0)
{
	TabList=(ArrayList)TerminologyCode.getObject(0);
}else{
	TabList=new ArrayList();
	TerminologyCode.putObject(TabList);
}
try{
if(validate.equals("LEVEL")){

	String termSetId	=	request.getParameter("termSetid");
	String sqlData		=	"Select nature_appl_yn, proc_spec_yn, diag_spec_yn,DEFN_LEVELS,LEVEL_1_DESC,LEVEL_2_DESC,LEVEL_3_DESC,LEVEL_4_DESC,LEVEL_5_DESC,LEVEL_6_DESC,LEVEL_7_DESC,LEVEL_8_DESC,LEVEL_9_DESC,LEVEL_10_DESC from mr_term_set where term_set_id = ?";
	String levelData		=		"";
	con						=		ConnectionManager.getConnection(request);
	pstmt					=		con.prepareStatement(sqlData);
	pstmt.setString(1,termSetId);
	rs							=		pstmt.executeQuery();
	while (rs != null && rs.next()) {
		levelData			=		rs.getString("nature_appl_yn")+"||";
		levelData			=		levelData+rs.getString("diag_spec_yn")+"||";
		levelData			=		levelData+rs.getString("proc_spec_yn")+"||";
		levelData			=		levelData+rs.getString("DEFN_LEVELS")+"||";
		levelData			=		levelData+rs.getString("LEVEL_1_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_2_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_3_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_4_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_5_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_6_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_7_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_8_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_9_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_10_DESC")+"||";
	}
	rs.close();
	pstmt.close();
		out.println( "assignLevels(\"" + levelData + "\");") ;	


}else if(validate.equals("TERMINOLOGYCODE")){

	String code			=		request.getParameter("code");
	String flag				=		request.getParameter("flag");
	//String alphaLink		=		request.getParameter("alphaLink");
		
	if(flag.equals("1")){
		TabList.add(code);
	}else{
		if(TabList.contains(code)){
			TabList.remove(code);	
		}
	}

}else if(validate.equals("SELECTALL")){

	String classificationLevel1				=		request.getParameter("classificationLevel");
	int classificationLevel						=		Integer.parseInt(classificationLevel1);
	String assessmentCategoryCode		=		request.getParameter("assessmentCategoryCode");
	String terminologySetId					=		request.getParameter("terminologySetId");
	String type										=		request.getParameter("type");
	String flag										=		request.getParameter("flag");
	String alphalink								=		request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
	alphalink										=		alphalink.trim();
	String sqlData		="";
	con	=		ConnectionManager.getConnection(request);

	if(alphalink.equals("Associated")){
		sqlData="Select a.term_set_id, a.term_code, b.short_desc, 'U' db_action from      CP_TRGD_TERM_CODE_AT_ASSMT a, mr_term_code b where a.ASSESS_CATG_CODE = ? and  b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' )) and a.term_set_id = ? and b.code_level =? order by 3";

		pstmt	=  con.prepareStatement(sqlData);
		pstmt.setString(1,assessmentCategoryCode);
		pstmt.setString(2,type);
		pstmt.setString(3,type);
		pstmt.setString(4,terminologySetId);
		pstmt.setInt(5,classificationLevel);
	}else{
	 sqlData="select term_set_id, term_code, short_desc, 'I' db_action from mr_term_code where term_set_id = ? and code_level = ? and (( ? = 'PR' and procedure_yn = 'Y' ) or(? = 'DX' and diagnosis_yn = 'Y' )) and ((? is not null and upper(short_desc) like ?) or (? is null and substr(upper(short_desc),1,1) not between 'A' and 'Z')) and (term_set_id, term_code) not in (select term_set_id,term_code from CP_TRGD_TERM_CODE_AT_ASSMT where ASSESS_CATG_CODE = ?) union all select     a.term_set_id, a.term_code, b.short_desc, 'U' db_action from       CP_TRGD_TERM_CODE_AT_ASSMT a, mr_term_code b where a.ASSESS_CATG_CODE = ? and   b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' )) and ((? is not null and upper(b.short_desc) like ?) or ( ? is null and substr(b.short_desc,1,1) not between 'A' and 'Z')) and b.code_level = ? order by 3";
	

	
	pstmt	=	con.prepareStatement(sqlData);
	
	
		pstmt.setString(1,terminologySetId);
		pstmt.setInt(2,classificationLevel);
		pstmt.setString(3,type);
		pstmt.setString(4,type);
		pstmt.setString(5,alphalink);
		pstmt.setString(6,alphalink+"%");
		pstmt.setString(7,alphalink);
		pstmt.setString(8,assessmentCategoryCode);
		pstmt.setString(9,assessmentCategoryCode);
		pstmt.setString(10,type);
		pstmt.setString(11,type);
		pstmt.setString(12,alphalink);
		pstmt.setString(13,alphalink+"%");
		pstmt.setString(14,alphalink);
		pstmt.setInt(15,classificationLevel);
	}
	rs	=	pstmt.executeQuery();

	if(rs!=null)
	{
		while(rs.next()){
			String code	= rs.getString("term_code");
		if(flag.equals("1")){
			if(!(TabList.contains(code))){
				TabList.add(code);
			}
		}else
		{
			if(TabList.contains(code)){
				int index	=	TabList.indexOf(code);
				TabList.remove(index);
			}
		}
	}
			
	}
	rs.close();
	pstmt.close();
}
}catch(Exception e){
	out.print(e);
}finally{
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close(); }
			ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
