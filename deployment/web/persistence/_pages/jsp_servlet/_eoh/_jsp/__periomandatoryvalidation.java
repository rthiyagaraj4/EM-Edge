package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;

public final class __periomandatoryvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioMandatoryValidation.jsp", 1742885099759L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst = null;
	ResultSet rst1 = null;
	String locale = (String)session.getAttribute("LOCALE"); 
	String tooth_numering_system = request.getParameter( "tooth_numering_system" ) ;
	String chart_code = request.getParameter( "chart_code" ) ;
	String chart_num = request.getParameter( "chart_num" ) ;
	String chart_line_num = request.getParameter( "chart_line_num" ) ;
	String patient_id = request.getParameter( "patient_id" ) ;

	String tooth_num="";
	String disp_tooth_num="";
	String component_desc="";
	String component_code="";
	
	
	//String SQL="SELECT DECODE(A.TOOTH_NO,'*ALL','All',(SELECT NS_TOOTH_NO FROM OH_PERIODONTAL_CHART_DEF_DTL2 A,OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE NUMBERING_SYSTEM=? AND A.TOOTH_NO=C.TOOTH_NO ) ) DISPLAY_TOOTH_NO, A.TOOTH_NO, A.COMPONENT_CODE,  B.COMPONENT_SHORT_DESC_USER_DEF FROM OH_PERIODONTAL_CHART_DEF_DTL2 A ,  OH_PERDONTAL_CHRT_COMP_LANG_VW B WHERE  B.LANGUAGE_ID = ? AND A.CHART_CODE = ? AND NVL(A.REQUIRED_YN,'N') = 'Y' AND A.COMPONENT_CODE = B.COMPONENT_CODE";
	
	//String SQL="SELECT X.TOOTH_NO, X.COMPONENT_CODE, Y.NS_TOOTH_NO DISPLAY_TOOTH_NO, Z.COMPONENT_SHORT_DESC_USER_DEF FROM (SELECT A.TOOTH_NO, A.COMPONENT_CODE   FROM OH_PERIODONTAL_CHART_DEF_DTL2 A   WHERE CHART_CODE = ?    AND REQUIRED_YN = 'Y'    AND TOOTH_NO <> '*A'  UNION SELECT TO_CHAR(B.TOOTH_NO) TOOTH_NO, A.COMPONENT_CODE   FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_TOOTH B  WHERE A.CHART_CODE = ?    AND A.TOOTH_NO   = '*A'    AND A.REQUIRED_YN = 'Y'  AND B.PERMANENT_DECIDUOUS = 'P') X, OH_TOOTH_BY_NUMBERING_SYSTEM Y, OH_PERDONTAL_CHRT_COMP_LANG_VW Z  WHERE X.TOOTH_NO  = Y.TOOTH_NO    AND Y.NUMBERING_SYSTEM  = ?  AND X.COMPONENT_CODE	  	 = Z.COMPONENT_CODE   AND Z.LANGUAGE_ID  = ?";

	String SQL="SELECT X.TOOTH_NO, X.COMPONENT_CODE, Y.NS_TOOTH_NO DISPLAY_TOOTH_NO, Z.COMPONENT_SHORT_DESC_USER_DEF FROM (SELECT A.TOOTH_NO, A.COMPONENT_CODE   FROM OH_PERIODONTAL_CHART_DEF_DTL2 A   WHERE CHART_CODE = ?    AND REQUIRED_YN = 'Y'    AND TOOTH_NO <> '*A'  UNION SELECT TO_CHAR(B.TOOTH_NO) TOOTH_NO, A.COMPONENT_CODE   FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_TOOTH B  WHERE A.CHART_CODE = ?    AND A.TOOTH_NO   = '*A'    AND A.REQUIRED_YN = 'Y'  AND B.PERMANENT_DECIDUOUS = 'P') X, OH_TOOTH_BY_NUMBERING_SYSTEM Y, OH_PERDONTAL_CHRT_COMP_LANG_VW Z  WHERE X.TOOTH_NO  = Y.TOOTH_NO    AND Y.NUMBERING_SYSTEM  = ?  AND X.COMPONENT_CODE	  	 = Z.COMPONENT_CODE   AND Z.LANGUAGE_ID  = ? ORDER BY X.COMPONENT_CODE";

	//String SQL1="SELECT TOOTH_NO, COMPONENT_CODE FROM OH_PERIODONTAL_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_CODE=? AND CHART_LINE_NUM =? AND TOOTH_NO=? AND COMPONENT_CODE=?";
	String SQL1="SELECT TOOTH_NO, COMPONENT_CODE FROM OH_PERIODONTAL_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_CODE=? AND CHART_LINE_NUM =? AND TOOTH_NO=? AND COMPONENT_CODE=?";

	StringBuilder sbr = new StringBuilder();
	int row_count=0;
	try{
		con = ConnectionManager.getConnection();
		pstmt = con.prepareStatement(SQL);
		pstmt1 = con.prepareStatement(SQL1);
		pstmt.setString(1,chart_code);
		pstmt.setString(2,chart_code);
		pstmt.setString(3,tooth_numering_system);
		pstmt.setString(4,locale);
		rst = pstmt.executeQuery();
		while(rst!= null && rst.next()){
			tooth_num =rst.getString(1);//"TOOTH_NO"
			component_code=rst.getString(2);//COMPONENT_CODE
			disp_tooth_num =rst.getString(3);//"DISPLAY_TOOTH_NO 
			component_desc=rst.getString(4);//COMPONENT_SHORT_DESC_USER_DEF
		
			pstmt1.setString(1, patient_id);
			pstmt1.setString(2, chart_num);
			pstmt1.setString(3, chart_code);
			pstmt1.setString(4, chart_line_num);
			pstmt1.setString(5, tooth_num);
			pstmt1.setString(6, component_code);
			rst1 = pstmt1.executeQuery();
			int i=0;
			while(rst1!= null && rst1.next()){
				i++;
			}
			if(i==0){
				if(row_count==0){
					sbr.append(component_desc).append(" - #").append(disp_tooth_num);
				}else{
					sbr.append(",");
					sbr.append(component_desc).append(" - #").append(disp_tooth_num);
				}
				row_count++;
			}
		}
		out.println(sbr.toString());
	}catch(Exception e){
		con.rollback();
		out.println("Err Msg from PerioMandatoryValidation.jsp "+e.getMessage());
	}
	finally{
		sbr.setLength(0);
		if(rst!=null) rst.close();
		if(rst1!=null) rst1.close();
		if(pstmt!=null)pstmt.close();
		if(pstmt1!=null)pstmt1.close();
		if(con!=null)
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
