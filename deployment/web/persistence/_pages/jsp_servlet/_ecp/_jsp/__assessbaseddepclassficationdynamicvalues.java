package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;

public final class __assessbaseddepclassficationdynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/AssessBasedDepClassficationDynamicValues.jsp", 1724909773033L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n";
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

request.setCharacterEncoding("UTF-8");
Connection con = null;
String flag=request.getParameter("flag")==null ?"":request.getParameter("flag");
boolean min_flag=true;
boolean max_flag=true;
PreparedStatement pstmt_list_score=null;
PreparedStatement pstmt_num_score=null;
ResultSet rs_list_score=null;
ResultSet rs_num_score=null;
int min_list=0, max_list=0, min_num=0, max_num=0, min_score=0, max_score=0;
		  //This file is saved on 18/10/2005.
try
{
	con = ConnectionManager.getConnection(request);

	if(flag.equals("disp")){
		String assess_note_id	 =	 request.getParameter("assess_note_id")==null?"":request.getParameter("assess_note_id");

//		String sql_list_score="select sum(min(score)) min_l_score,sum(max(score)) max_l_score from cp_assess_list_crit_score where assess_note_id = ? and score is not null group by comp_id";
		String sql_list_score="SELECT NVL(SUM(MIN(score)),0) min_l_score,NVL(SUM(MAX(score)),0) max_l_score FROM cp_assess_list_crit_score WHERE assess_note_id = ? AND score IS NOT NULL GROUP BY comp_id";

//		String sql_num_score="select sum(normal_score) min_n_score,sum(critical_score) max_n_score from cp_assess_num_crit_score where assess_note_id = ? and normal_score is not null";
		String sql_num_score="SELECT NVL(SUM(normal_score),0) min_n_score, NVL(SUM(critical_score),0) max_n_score FROM cp_assess_num_crit_score WHERE assess_note_id = ? AND normal_score IS NOT NULL";

		pstmt_list_score = con.prepareStatement( sql_list_score);
		pstmt_list_score.setString(1, assess_note_id);


		rs_list_score = pstmt_list_score.executeQuery() ;


		while (rs_list_score != null && rs_list_score.next())
		{

				if(rs_list_score.getString("min_l_score") != null)
				{
					min_list= Integer.parseInt(rs_list_score.getString("min_l_score"));
					min_flag=true;
				}
				else
				{
					min_flag=false;
				}
				if(rs_list_score.getString("max_l_score") != null)
				{
					max_list = Integer.parseInt(rs_list_score.getString("max_l_score"));
					//min_flag=true;
					max_flag=true;
				}
				else
				{
					min_flag=false;
				}
		}
		if(rs_list_score !=null)
			rs_list_score.close();

		pstmt_num_score = con.prepareStatement( sql_num_score);
		pstmt_num_score.setString(1, assess_note_id);
		rs_num_score = pstmt_num_score.executeQuery() ;

		while (rs_num_score != null && rs_num_score.next()) {

				if(rs_num_score.getString("min_n_score") != null)
				{
					min_num= Integer.parseInt(rs_num_score.getString("min_n_score"));
					min_flag	=	true;
				}
				else
				{
					min_flag=false;
				}

				if(rs_num_score.getString("max_n_score") != null){
					max_num = Integer.parseInt(rs_num_score.getString("max_n_score") );
					max_flag	=	true;
				}
				else
				{
					max_flag=false;
				}
		}
		if(rs_num_score !=null)
			rs_num_score.close();
		min_score	=	min_list+min_num;
		max_score	=	max_list+max_num;
		if(min_flag && max_flag){
			out.println( "assignMinMax(\"" + min_score+ "\",\"" +max_score + "\");") ;	
		}
		else if(min_flag){
			out.println( "assignMinMax(\"" + min_score+ "\",\"\");") ;	
		}
		else if(max_flag){
			out.println( "assignMinMax(\"\",\"" +max_score + "\");") ;	
		}
		else{
			out.println( "assignMinMax(\"\",\"\");") ;	
		}

	}

            _bw.write(_wl_block1Bytes, _wl_block1);
}
catch(Exception e){
	//out.print(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
  finally
  {
	  if(rs_num_score !=null)
			rs_num_score.close();
		if(rs_list_score !=null)
			rs_num_score.close();
		if(pstmt_num_score !=null)
			pstmt_num_score.close();
		if(pstmt_list_score !=null)
			pstmt_list_score.close();

		if(con != null)	ConnectionManager.returnConnection(con,request);

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
