package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __periocomparechartdisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioCompareChartDisplay.jsp", 1709119356817L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<HTML>\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eOH/js/PerioCompareChart.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eOH/js/OHCommon.js\"></script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form name=\"PerioCompareChartDisplayForm\" id=\"PerioCompareChartDisplayForm\">\n<table width=\"100%\" cellpadding =0 cellspacing=1 border=1 id=\"myTable\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<tr>\n\t\t<td class=\"COLUMNHEADERCENTER\" width=\"15%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td class=\"COLUMNHEADERCENTER\" width=\"12%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<td id=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" class=\"COLUMNHEADERCENTER\" width=\"3%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</tr>\n\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
 
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
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
			String patient_id=checkForNull(request.getParameter("patient_id"));
			String chart_code=checkForNull(request.getParameter("chart_code"));
			String quadrant=checkForNull(request.getParameter("quadrant"));
			String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
			String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
			String components=checkForNull(request.getParameter("components"));
			String eval_type=checkForNull(request.getParameter("eval_type"));
			String chart_compare=checkForNull(request.getParameter("chart_compare"));
			String qry_str = (components.length()>0)?"WHERE COMPONENT_CODE IN ("+components+")":"";
			String eval_chart_num1=checkForNull(request.getParameter("eval_chart_num1"));
			String eval_chart_num2=checkForNull(request.getParameter("eval_chart_num2"));
			String eval_chart_num3=checkForNull(request.getParameter("eval_chart_num3"));
			String selected_val1=checkForNull(request.getParameter("selected_val1"));
			String selected_val2=checkForNull(request.getParameter("selected_val2"));
			String selected_val3=checkForNull(request.getParameter("selected_val3"));
			String eval_chart_line_num1="";
			String eval_chart_line_num2="";
			String eval_chart_line_num3="";
			if(eval_type.equals("BB")){
					eval_chart_line_num1="1";
					eval_chart_line_num2="1";
					eval_chart_line_num3="1";
			}else{
				eval_chart_line_num1=checkForNull(request.getParameter("eval_chart_line_num1"));
				eval_chart_line_num2=checkForNull(request.getParameter("eval_chart_line_num2"));
				eval_chart_line_num3=checkForNull(request.getParameter("eval_chart_line_num3"));
			}
			//String qry_str1 = (components.length()>0)?"AND X.COMPONENT_CODE IN ("+components+")":"";
			StringBuilder  sbr= new StringBuilder();
			//sbr.append("'").append(eval_chart_line_num1).append("'").append(",");
			//sbr.append("'").append(eval_chart_line_num2).append("'");
			String cond="";
			String eval_chart_type1="";
			String eval_chart_type2="";
			String eval_chart_type3="";
			switch(quadrant.charAt(0)){
				case '1':
				case '2': cond = "U"; break;
				case '3':
				case '4':cond = "L"; break;
			}
			if(chart_compare.equals(2)){
				if("BE".equals(eval_type)){
					eval_chart_type1="BL";
					eval_chart_type2="EV";
				}else if("EE".equals(eval_type)){
					eval_chart_type1="EV1";
					eval_chart_type2="EV2";
				}else if("BB".equals(eval_type)){
					eval_chart_type1="BL1";
					eval_chart_type2="BL2";
				}
			}else if(chart_compare.equals(3)){
				if("BE".equals(eval_type)){
					eval_chart_type1="BL";
					eval_chart_type2="EV1";
					eval_chart_type3="EV2";
				}else if("EE".equals(eval_type)){
					eval_chart_type1="EV1";
					eval_chart_type2="EV2";
					eval_chart_type3="EV3";
				}else if("BB".equals(eval_type)){
					eval_chart_type1="BL1";
					eval_chart_type2="BL2";
					eval_chart_type3="BL3";
				}
			}
					
			String tooth_num			 =	 "";
			String S1					 =  "";
			String S2					 =  "";
			String S3					 =  "";
			String S4					 =  "";
			String S5					 =  "";
			String S6					 =  "";
			String val					 =  "";
			String component_code	 =  "";
			String component_desc	 =  "";
			String chart_date			 =  "";
			String row_color			 =  "";
			String display_tooth_str	 =  "";
			String surfaces_appl_yn	 =  "N";
			
			
			String tooth_str	 =  "";
			String[] tooth_str_arr	 = new String[8];
			String[] display_tooth_str_arr	 = new String[8];

			Connection con				= null;
			PreparedStatement pstmt  = null;
			PreparedStatement pstmt1  = null;
			ResultSet rs			        = null;
			ResultSet rs1		        = null;
			String next_row_flag		 =  "";
			String chart_line_num	 =  "";
			String comp_str			 =  "";
			String td_id					 =	 "";
			String line_seq="";
			String cut_off="";
			String SQL="";
			String sql_tooth = "SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND A.PERMANENT_DECIDUOUS = ? AND A.ARCH_SNO = ?";


			/*String SQL="SELECT A.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,TO_CHAR(C.CHART_COMPLETED_DATE,'DD/MM')||DECODE(C.CHART_LINE_NUM,'"+eval_chart_line_num1+"','("+eval_chart_type1+")','"+eval_chart_line_num2+"','("+eval_chart_type2+")'),A.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,C.CHART_LINE_NUM, D.SURFACES_APPL_YN,DECODE(C.CHART_LINE_NUM,'"+eval_chart_line_num1+"','CAGREENSMALL','"+eval_chart_line_num2+"','QRYEVENSMALL')   FROM OH_PERIODONTAL_CHART_DTL A, OH_PERIODONTAL_CHART_HDR B, OH_PERIODONTAL_CHART_HDR_LINE C, OH_PERDONTAL_CHRT_COMP_LANG_VW D, OH_TOOTH_BY_NUMBERING_SYSTEM E WHERE A.OPERATING_FACILITY_ID =B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.CHART_NUM = B.CHART_NUM AND A.CHART_CODE = B.CHART_CODE AND A.OPERATING_FACILITY_ID =C.OPERATING_FACILITY_ID AND A.PATIENT_ID = C.PATIENT_ID AND A.CHART_NUM =  C.CHART_NUM AND A.CHART_CODE = C.CHART_CODE  AND A.CHART_LINE_NUM = C.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID =? AND A.PATIENT_ID = ? AND A.CHART_CODE = ?  AND A.CHART_NUM = ? AND C.CHART_LINE_NUM IN("+sbr.toString()+") AND D.LANGUAGE_ID=? AND  E.QUADRANT_SNO IN ("+cond+") AND E.NUMBERING_SYSTEM = ? AND E.TOOTH_NO = A.TOOTH_NO AND D.COMPONENT_CODE=A.COMPONENT_CODE AND D.FORMULA_YN='N' AND B.CHART_STATUS NOT IN ('ME') "+qry_str+" ORDER BY NVL(D.SURFACES_APPL_YN,'N') ASC, D.COMPONENT_SHORT_DESC_USER_DEF,C.CHART_LINE_NUM";*/
			
			//SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ FROM

			//String SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ FROM ( SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'CAGREENSMALL' LINE_COLOR, 1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO FROM OH_PERDONTAL_CHRT_COMP_LANG_VW X,OH_TOOTH Y WHERE X.FORMULA_YN = 'N' AND X.LANGUAGE_ID	 =? AND Y.PERMANENT_DECIDUOUS = ? AND Y.ARCH_SNO = ? "+qry_str1+") D  WHERE A.OPERATING_FACILITY_ID(+)=?  AND A.PATIENT_ID(+) =?  AND A.CHART_CODE(+) =?  AND A.CHART_NUM(+)	=? AND A.CHART_LINE_NUM(+) =? 	AND A.TOOTH_NO (+)  = D.TOOTH_NO AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION  SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'QRYEVENSMALL' LINE_COLOR, 2 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO FROM OH_PERDONTAL_CHRT_COMP_LANG_VW X,OH_TOOTH Y WHERE X.FORMULA_YN = 'N' AND X.LANGUAGE_ID	 = ? AND Y.PERMANENT_DECIDUOUS = ? AND Y.ARCH_SNO = ? "+qry_str1+") D  WHERE A.OPERATING_FACILITY_ID(+)=?  AND A.PATIENT_ID(+) =?  AND A.CHART_CODE(+) =?  AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	AND A.TOOTH_NO (+)  = D.TOOTH_NO AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ";

			//String SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'CAGREENSMALL' LINE_COLOR, 1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.OPERATING_FACILITY_ID(+)=?  AND A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'DISPDATE' LINE_COLOR, 2 LINE_SEQ 	   FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.OPERATING_FACILITY_ID(+)=? AND A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ";
			
			//Commented by Parul for CRf #0423
			//String SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ, EVAL_CHART_LINE_NUM FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'CAGREENSMALL' LINE_COLOR, 1 LINE_SEQ, ? EVAL_CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.OPERATING_FACILITY_ID(+)=?  AND A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'DISPDATE' LINE_COLOR, 2 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.OPERATING_FACILITY_ID(+)=? AND A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ DESC";
			//String SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ, EVAL_CHART_LINE_NUM FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'CAGREENSMALL' LINE_COLOR, 1 LINE_SEQ, ? EVAL_CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.OPERATING_FACILITY_ID(+)=?  AND A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'DISPDATE' LINE_COLOR, 2 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ DESC";
			//String SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ, EVAL_CHART_LINE_NUM FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'CAGREENSMALL' LINE_COLOR, 1 LINE_SEQ, ? EVAL_CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'DISPDATE' LINE_COLOR, 2 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ DESC";
			if(chart_compare.equals("2")){
				SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ, EVAL_CHART_LINE_NUM FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'OHCOMPAREBASE' LINE_COLOR, 1 LINE_SEQ, ? EVAL_CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'OHCOMPAREEVAL1' LINE_COLOR, 2 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE ) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ DESC";
			}else if(chart_compare.equals("3")){
				SQL="SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, TOOTH_NO, S1, S2, S3, S4, S5, S6, VALUE, SURFACES_APPL_YN, LINE_COLOR, LINE_SEQ, EVAL_CHART_LINE_NUM FROM ( 	   SELECT D.COMPONENT_CODE, D.COMPONENT_SHORT_DESC_USER_DEF,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'OHCOMPAREBASE' LINE_COLOR, 1 LINE_SEQ, ? EVAL_CHART_LINE_NUM FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? 	   AND A.CHART_CODE(+) =?   AND A.CHART_NUM(+)	=?  AND A.CHART_LINE_NUM(+) =?  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE  UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'OHCOMPAREEVAL1' LINE_COLOR, 2 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE UNION SELECT D.COMPONENT_CODE,D.COMPONENT_SHORT_DESC_USER_DEF,	   D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,A.VALUE,D.SURFACES_APPL_YN, 'OHCOMPAREEVAL2' LINE_COLOR, 3 LINE_SEQ, ? EVAL_CHART_LINE_NUM  FROM OH_PERIODONTAL_CHART_DTL A, 	   (SELECT X.COMPONENT_CODE, X.COMPONENT_SHORT_DESC_USER_DEF, X.SURFACES_APPL_YN, TOOTH_NO 	   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	   WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	   AND Y.PERMANENT_DECIDUOUS = 'P' 	   AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  	   WHERE A.PATIENT_ID(+) =? AND A.CHART_CODE(+) =? AND A.CHART_NUM(+)=? AND A.CHART_LINE_NUM(+) =? 	   AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE) 	   "+qry_str+" ORDER BY SURFACES_APPL_YN ASC, COMPONENT_SHORT_DESC_USER_DEF, LINE_SEQ ";
			}
			
			con=ConnectionManager.getConnection(request);
			int tooth_cnt=0;
			try{
			pstmt = con.prepareStatement(sql_tooth);
			pstmt.setString(1,tooth_numbering_system);
			pstmt.setString(2,permanent_deciduous_flag);
			pstmt.setString(3,cond);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(tooth_cnt == 0){
					tooth_str = rs.getString("TOOTH_NO");
					display_tooth_str = rs.getString("DISPLAY_TOOTH_NO");
				}else{
					tooth_str = tooth_str + "," +rs.getString("TOOTH_NO");
					display_tooth_str = display_tooth_str + "," +rs.getString("DISPLAY_TOOTH_NO");
				}
			tooth_cnt++;
			}

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			}catch(Exception e){
				System.err.println("Err Mesg From perioCompareChartDisplay"+e.getMessage());
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				tooth_str_arr = tooth_str.split(",");
				display_tooth_str_arr = display_tooth_str.split(",");
		
			if(cond.equals("U")){
				for(int j=0;j<tooth_cnt;j++){
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tooth_str_arr[j]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(display_tooth_str_arr[j]));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
		}else
		{
		for(int j=tooth_cnt-1;j>=0;j--){
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tooth_str_arr[j]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(display_tooth_str_arr[j]));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
		}
		
            _bw.write(_wl_block13Bytes, _wl_block13);

		try{

					pstmt=con.prepareStatement(SQL);
					if(chart_compare.equals("2")){
						pstmt.setString(1,eval_chart_line_num1);
						pstmt.setString(2,chart_code);
						pstmt.setString(3,locale);
						pstmt.setString(4,cond );
						pstmt.setString(5,patient_id);
						pstmt.setString(6,chart_code);
						pstmt.setString(7,eval_chart_num1);
						pstmt.setString(8,eval_chart_line_num1);
						pstmt.setString(9,eval_chart_line_num2);
						pstmt.setString(10,chart_code);
						pstmt.setString(11,locale);
						pstmt.setString(12,cond );
						pstmt.setString(13,patient_id);
						pstmt.setString(14,chart_code);
						pstmt.setString(15,eval_chart_num2);
						pstmt.setString(16,eval_chart_line_num2);
					}else if(chart_compare.equals("3")){
						pstmt.setString(1,eval_chart_line_num1);
						pstmt.setString(2,chart_code);
						pstmt.setString(3,locale);
						pstmt.setString(4,cond );
						pstmt.setString(5,patient_id);
						pstmt.setString(6,chart_code);
						pstmt.setString(7,eval_chart_num1);
						pstmt.setString(8,eval_chart_line_num1);
						pstmt.setString(9,eval_chart_line_num2);
						pstmt.setString(10,chart_code);
						pstmt.setString(11,locale);
						pstmt.setString(12,cond );
						pstmt.setString(13,patient_id);
						pstmt.setString(14,chart_code);
						pstmt.setString(15,eval_chart_num2);
						pstmt.setString(16,eval_chart_line_num2);
						pstmt.setString(17,eval_chart_line_num3);
						pstmt.setString(18,chart_code);
						pstmt.setString(19,locale);
						pstmt.setString(20,cond );
						pstmt.setString(21,patient_id);
						pstmt.setString(22,chart_code);
						pstmt.setString(23,eval_chart_num3);
						pstmt.setString(24,eval_chart_line_num3);
					}
					rs=pstmt.executeQuery();
					int k=0;
					while(rs.next()){
							++k;
							next_row_flag = (comp_str.equals( rs.getString(1)+"#"+rs.getString(13)) )?"N":"Y";
							component_code	 =  rs.getString(1);//component code
							component_desc	 =  rs.getString(2);//component desc
							tooth_num			 =  rs.getString(3);//tooth number
							S1				 =  checkForNull(rs.getString(4),"&nbsp;");//surface-1     
							S2				 =  checkForNull(rs.getString(5),"&nbsp;");//surface-2     
							S3				 =  checkForNull(rs.getString(6),"&nbsp;");//surface-3     
							S4				 =  checkForNull(rs.getString(7),"&nbsp;");//surface-4     
							S5				 =  checkForNull(rs.getString(8),"&nbsp;");//surface-5     
							S6				 =  checkForNull(rs.getString(9),"&nbsp;");//surface-6     
							val				 =  checkForNull(rs.getString(10));//val
							surfaces_appl_yn =  rs.getString(11);//val
							row_color =  rs.getString(12);//val
							line_seq =  rs.getString(13);//val
							chart_line_num =  rs.getString(14);//chart_line_num
							if(chart_compare.equals("2")){
								if("BE".equals(eval_type)){
									chart_date	= ("1".equals(line_seq))?selected_val1:selected_val2;//chart_date
								}else if("EE".equals(eval_type)){
									chart_date	= ("1".equals(line_seq))?selected_val1:selected_val2;//chart_date
								}else if("BB".equals(eval_type)){
									chart_date	= ("1".equals(line_seq))?selected_val1:selected_val2;//chart_date
								}
							}else if(chart_compare.equals("3")){
								if("BE".equals(eval_type)){
									//chart_date= ("1".equals(line_seq))?eval_chart_date1+"(BL)":eval_chart_date2+"(EV)";//chart_date
									if("1".equals(line_seq)){
										chart_date = selected_val1;
									}else if("2".equals(line_seq)){
										chart_date = selected_val2;
									}else if("3".equals(line_seq)){
										chart_date = selected_val3;
									}
								}else if("EE".equals(eval_type)){
									//chart_date= ("1".equals(line_seq))?eval_chart_date1+"(EV1)":eval_chart_date2+"(EV2)";//chart_date
									if("1".equals(line_seq)){
										chart_date = selected_val1;
									}else if("2".equals(line_seq)){
										chart_date = selected_val2;
									}else if("3".equals(line_seq)){
										chart_date = selected_val3;
									}
								}else if("BB".equals(eval_type)){
									//chart_date = ("1".equals(line_seq))?eval_chart_date1+"(BL1)":eval_chart_date2+"(BL2)";//chart_date
									if("1".equals(line_seq)){
										chart_date = selected_val1;
									}else if("2".equals(line_seq)){
										chart_date = selected_val2;
									}else if("3".equals(line_seq)){
										chart_date = selected_val3;
									}
								}
							}
							sbr.setLength(0);

							String SQL1="SELECT B.CUT_OFF FROM OH_PERIODONTAL_CHART_COMP A,OH_PERIODONTAL_CHART_DEF_DTL B WHERE  A.COMPONENT_CODE=B.COMPONENT_CODE AND  B.CHART_CODE = ? and B.COMPONENT_CODE=? ";
							pstmt1=con.prepareStatement(SQL1);
							pstmt1.setString(1,chart_code);
							pstmt1.setString(2,component_code);
							rs1 = pstmt1.executeQuery();
							while(rs1.next()){
							cut_off = checkForNull(rs1.getString("CUT_OFF"));
							}
						if("Y".equals(surfaces_appl_yn)){
							if("1".equals(quadrant) || "4".equals(quadrant)){
									sbr.append("<table width=100% cellpadding =1 cellspacing=1 border=0>");
											sbr.append("<tr>");
									if(S1.equals("&nbsp;")){
										if(S1.compareTo(cut_off) >= 0){
												sbr.append("<td class="+row_color+" nowrap>").append(S1).append("</td>");
											}
										}else{
											if(Integer.parseInt(S1) >= Integer.parseInt(cut_off)) {										
												sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S1+"</font>").append("</td>");
											}else{
												sbr.append("<td class="+row_color+" nowrap>").append(S1).append("</td>");
											}								
										}

									if(S2.equals("&nbsp;")){
										if(S2.compareTo(cut_off) >= 0){
												sbr.append("<td class="+row_color+" nowrap>").append(S2).append("</td>");
											}
										}else{
											if(Integer.parseInt(S2) >= Integer.parseInt(cut_off)) {										
												sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S2+"</font>").append("</td>");
											}else{
												sbr.append("<td class="+row_color+" nowrap>").append(S2).append("</td>");
											}								
										}
								  if(S3.equals("&nbsp;")){
										if(S3.compareTo(cut_off) >= 0){
											sbr.append("<td class="+row_color+" nowrap>").append(S3).append("</td>");
											}
										}else{
											if(Integer.parseInt(S3) >= Integer.parseInt(cut_off)) {										
												sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S3+"</font>").append("</td>");
											}else{
												sbr.append("<td class="+row_color+" nowrap>").append(S3).append("</td>");
											}								
										}
								sbr.append("</tr>");
								sbr.append("</table>");
						}else{
							sbr.append("<table width=100% cellpadding =1 cellspacing=1 border=0>");
							sbr.append("<tr>");
							 if(S4.equals("&nbsp;")){
								if(S4.compareTo(cut_off) >= 0){
									sbr.append("<td class="+row_color+" nowrap>").append(S4).append("</td>");
									}
								}else{
									if(Integer.parseInt(S4) >= Integer.parseInt(cut_off)) {										
										sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S4+"</font>").append("</td>");
									}else{
										sbr.append("<td class="+row_color+" nowrap>").append(S4).append("</td>");
									}								
								}
							if(S5.equals("&nbsp;")){
								if(S5.compareTo(cut_off) >= 0){
									sbr.append("<td class="+row_color+" nowrap>").append(S5).append("</td>");
									}
								}else{
									if(Integer.parseInt(S5) >= Integer.parseInt(cut_off)) {										
										sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S5+"</font>").append("</td>");
									}else{
										sbr.append("<td class="+row_color+" nowrap>").append(S5).append("</td>");
									}								
								}
							if(S6.equals("&nbsp;")){
								if(S6.compareTo(cut_off) >= 0){
									sbr.append("<td class="+row_color+" nowrap>").append(S6).append("</td>");
									}
								}else{
									if(Integer.parseInt(S6) >= Integer.parseInt(cut_off)) {										
										sbr.append("<td class="+row_color+" nowrap>").append("<font color=red>"+S6+"</font>").append("</td>");
									}else{
										sbr.append("<td class="+row_color+" nowrap>").append(S6).append("</td>");
									}								
								}

									/*sbr.append("<td class="+row_color+" nowrap color>").append(S4).append("</td>");
									sbr.append("<td class="+row_color+" nowrap>").append(S5).append("</td>");
									sbr.append("<td class="+row_color+" nowrap>").append(S6).append("</td>");*/
						
									sbr.append("</tr>");
									sbr.append("</table>");
								}

							}	

							sbr.append(val);
							comp_str = component_code+"#"+ rs.getString(13);
							if("Y".equals(next_row_flag) ) {
								out.println("<tr>");
								//if("1".equals(line_seq) )
								if(chart_compare.equals("3")){
								if(chart_line_num.equals(eval_chart_line_num1) ){
									out.println("<td  class='"+row_color+"' >"+component_desc+"</td>");
								}else{
									out.println("<td  class='"+row_color+"' >&nbsp;</td>");
								}
									out.println("<td  class='"+row_color+"' nowrap>"+chart_date+"</td>");
									tooth_str_arr = tooth_str.split(",");
								}else  if(chart_compare.equals("2")){
								if(chart_line_num.equals(eval_chart_line_num2) ){
									out.println("<td  class='"+row_color+"' >"+component_desc+"</td>");
								}else{
									out.println("<td  class='"+row_color+"' >&nbsp;</td>");
								}
									out.println("<td  class='"+row_color+"' nowrap>"+chart_date+"</td>");
									tooth_str_arr = tooth_str.split(",");
								}
							
								if(cond.equals("U")){
								for(int j=0;j<tooth_str_arr.length;j++){
										td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) ){
										//out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										if(surfaces_appl_yn.equals("N")){
											if(val.compareTo(cut_off)>=0){
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center ><font color=red>"+val+"</font></td>");
											}else{
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+val+"</td>");
											}
										}else{
											out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										}
									}else{
										out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center>&nbsp;</td>");
									}
							}
							}else if(cond.equals("L"))
								{
					
								for(int j=tooth_str_arr.length-1;j>=0;j--){
								
										td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) ){
										//out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										if(surfaces_appl_yn.equals("N")){
											if(val.compareTo(cut_off)>=0){
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center ><font color=red>"+val+"</font></td>");
											}else{
												out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+val+"</td>");
											}
										}else{
											out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										}
									}else{
										out.println("	<td class='"+row_color+"' id="+td_id+" style=text-align:center>&nbsp;</td>");
									}
							}
							}
								out.println("</tr>");
								if(line_seq.equals("3")){
									out.println("<tr></tr><tr></tr>");
								}

						}else{
								
								if(cond.equals("U")){
								for(int j=0;j<tooth_str_arr.length;j++){
									td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) )
										out.println("<SCRIPT>assignValueToCell('"+td_id+"','"+sbr.toString()+"','"+cut_off+"');</SCRIPT>");
								}
								}
								else if(cond.equals("L"))
								{
									for(int j=tooth_str_arr.length-1;j>=0;j--){
									td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) )
										out.println("<SCRIPT>assignValueToCell('"+td_id+"','"+sbr.toString()+"','"+cut_off+"');</SCRIPT>");
								}
								}
								
					}
						sbr.setLength(0);
				}//end of while 
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Mesg From PerioCompareChartDisplay.jsp"+e);
		}finally{
			try{
				if(rs!=null) rs.close();
				if(rs1!=null) rs1.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				if(con!=null) con.close();
			}catch(Exception es){}
		}
		

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Component.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Chart.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
