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

public final class __periocomparegraphbuccaltableview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioCompareGraphBuccalTableView.jsp", 1709119357551L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eOH/js/OHCommon.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script>\nfunction assignValueToCell(td_id,val,cut_off){\n\t//document.getElementById(td_id).innerHTML=val;\n\n\tif(val>=cut_off){\n\t    document.getElementById(td_id).innerHTML=\"<font size=\'2.5\' color=\'red\'>\"+val+\"</font>\";;\n\n\t}else{\n\tdocument.getElementById(td_id).innerHTML=val;\n\t}\n }\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form name=\"PerioCompareChartDisplayForm\" id=\"PerioCompareChartDisplayForm\">\n<table width=\"83%\" cellpadding =0 cellspacing=2 border=1 id=\"myTable\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<td class=\"COLUMNHEADERCENTER\" width=\"5%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td class=\"COLUMNHEADERCENTER\" width=\"5%\">&nbsp;</td>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td class=\"COLUMNHEADERCENTER\" width=\"6%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<td id=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" class=\"COLUMNHEADERCENTER\" width=\"3%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t\t \n\n\t</tr>\n\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
 
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
	String chart_num=checkForNull(request.getParameter("chart_num1"));
	String chart_num2=checkForNull(request.getParameter("chart_num2"));
	String chart_num3=checkForNull(request.getParameter("chart_num3"));
	String chart_line_num="";
	String chart_line_num2="";
	String chart_line_num3="";
	String chart_code=checkForNull(request.getParameter("chart_code"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
	String component_code=checkForNull(request.getParameter("components"));
	String surfface_appl_yn=checkForNull(request.getParameter("surfface_appl_yn"));
	StringBuilder  sbr= new StringBuilder();
	String perio_arch=checkForNull(request.getParameter("perio_arch"));
	String eval_type=checkForNull(request.getParameter("eval_type"));
	String no_of_charts=checkForNull(request.getParameter("no_of_charts"));
	if(eval_type.equals("BB")){
		chart_line_num="1";
		chart_line_num2="1";
		chart_line_num3="1";
	}else{
		chart_line_num=checkForNull(request.getParameter("chart_line_num1"));	
		chart_line_num2=checkForNull(request.getParameter("chart_line_num2"));
		chart_line_num3=checkForNull(request.getParameter("chart_line_num3"));
	}
			String tooth_num			 =	 "";
			String S1					 =  "";
			String S2					 =  "";
			String S3					 =  "";
			String S4					 =  "";
			String S5					 =  "";
			String S6					 =  "";
			String comp_code		=  "";
			String component_desc		=  "";
			String chart_date			 =  "";
			String row_color			 =  "";
			String display_tooth_str	 =  "";
			String surfaces_appl_yn		=  "N";
			String tooth_str	 =  "";
			String[] tooth_str_arr	 = new String[8];
			String[] display_tooth_str_arr	 = new String[8];

			Connection con				= null;
			PreparedStatement pstmt  = null;
			PreparedStatement pstmt1  = null;
			ResultSet rs			        = null;
			ResultSet rs1			        = null;
			String next_row_flag		 =  "";
			String comp_str			 =  "";
			String td_id					 =	 "";
			String line_seq="";
			String cut_off="";

			String sql_tooth = "SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND A.PERMANENT_DECIDUOUS = ? AND A.ARCH_SNO = ?";


			con=ConnectionManager.getConnection(request);
			
			int tooth_cnt=0;
			try{
			pstmt = con.prepareStatement(sql_tooth);
			pstmt.setString(1,tooth_numbering_system);
			pstmt.setString(2,permanent_deciduous_flag);
			pstmt.setString(3,perio_arch);
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
				System.err.println("Err Mesg From PerioCompareBuccalGraphTableView.jsp");
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

		if(surfface_appl_yn.equals("Y")){
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
 }
		else{
	
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

				tooth_str_arr = tooth_str.split(",");
				display_tooth_str_arr = display_tooth_str.split(",");
				if(perio_arch.equals("L")){
				//for(int j=0;j<tooth_cnt;j++){
				for(int j=tooth_cnt-1;j>=0;j--){
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooth_str_arr[j]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(display_tooth_str_arr[j]));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
		}else{
				for(int j=0;j<tooth_cnt;j++){
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tooth_str_arr[j]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(display_tooth_str_arr[j]));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
		}
		
            _bw.write(_wl_block17Bytes, _wl_block17);

		try{
			String sql="";
			 String sql1="select COMPONENT_SHORT_DESC_USER_DEF from OH_PERDONTAL_CHRT_COMP_LANG_VW where COMPONENT_CODE=?  and language_id=?";
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,component_code);
			pstmt.setString(2,locale);
			rs=pstmt.executeQuery();
			while(rs.next()){
					component_desc	 =  rs.getString(1);//component code
			}

	if(surfface_appl_yn.equals("N")){
		if(no_of_charts.equals("2")){

			sql="SELECT COMPONENT_CODE,TOOTH_NO, VALUE ,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ 		FROM OH_PERIODONTAL_CHART_DTL A,		(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 			 FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y			 WHERE Z.CHART_CODE = ? 			 AND X.LANGUAGE_ID = ? 			 AND Y.PERMANENT_DECIDUOUS = 'P'	  			 AND Y.ARCH_SNO = ? 			 AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  		WHERE  A.PATIENT_ID(+) =?	   	  		AND A.CHART_CODE(+) =?	 		AND A.CHART_NUM(+)  =?	 		AND A.CHART_LINE_NUM(+) =?	  		AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	 		AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	  		UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ      		FROM OH_PERIODONTAL_CHART_DTL A,(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 		FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y    		WHERE Z.CHART_CODE = ?		  		AND X.LANGUAGE_ID =?		    		AND Y.PERMANENT_DECIDUOUS = 'P'		  		AND Y.ARCH_SNO =?		    		AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		  WHERE  A.PATIENT_ID(+) =?	   		  AND A.CHART_CODE(+) =?		  AND A.CHART_NUM(+)  =?		    AND A.CHART_LINE_NUM(+) =?		  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		    AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		  WHERE COMPONENT_CODE =?		    ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";
		}else if(no_of_charts.equals("3")){

			sql="SELECT COMPONENT_CODE,TOOTH_NO, VALUE ,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ 		FROM OH_PERIODONTAL_CHART_DTL A,		(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 			 FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y			 WHERE Z.CHART_CODE = ? 			 AND X.LANGUAGE_ID = ? 			 AND Y.PERMANENT_DECIDUOUS = 'P'	  			 AND Y.ARCH_SNO = ? 			 AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  		WHERE  A.PATIENT_ID(+) =?	   	  		AND A.CHART_CODE(+) =?	 		AND A.CHART_NUM(+)  =?	 		AND A.CHART_LINE_NUM(+) =?	  		AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	 		AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	  		UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ      		FROM OH_PERIODONTAL_CHART_DTL A,(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 		FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y    		WHERE Z.CHART_CODE = ?		  		AND X.LANGUAGE_ID =?		    		AND Y.PERMANENT_DECIDUOUS = 'P'		  		AND Y.ARCH_SNO =?		    		AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		  WHERE  A.PATIENT_ID(+) =?	   		  AND A.CHART_CODE(+) =?		  AND A.CHART_NUM(+)  =?		    AND A.CHART_LINE_NUM(+) =?		  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		    AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,3 LINE_SEQ      		FROM OH_PERIODONTAL_CHART_DTL A,(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 		FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y    		WHERE Z.CHART_CODE = ?		  		AND X.LANGUAGE_ID =?		    		AND Y.PERMANENT_DECIDUOUS = 'P'		  		AND Y.ARCH_SNO =?		    		AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		  WHERE  A.PATIENT_ID(+) =?	   		  AND A.CHART_CODE(+) =?		  AND A.CHART_NUM(+)  =?		    AND A.CHART_LINE_NUM(+) =?		  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		    AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE)  		  WHERE COMPONENT_CODE =?		    ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";
		}
		if(no_of_charts.equals("2")){
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,chart_code);
			pstmt.setString(2,locale);
			pstmt.setString(3,perio_arch);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,chart_code);
			pstmt.setString(6,chart_num);
			pstmt.setString(7,chart_line_num);
			pstmt.setString(8,chart_code);
			pstmt.setString(9,locale);
			pstmt.setString(10,perio_arch);
			pstmt.setString(11,patient_id);
			pstmt.setString(12,chart_code);
			pstmt.setString(13,chart_num2);
			pstmt.setString(14,chart_line_num2);
			pstmt.setString(15,component_code);
		}else if(no_of_charts.equals("3")){
						pstmt=con.prepareStatement(sql);
			pstmt.setString(1,chart_code);
			pstmt.setString(2,locale);
			pstmt.setString(3,perio_arch);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,chart_code);
			pstmt.setString(6,chart_num);
			pstmt.setString(7,chart_line_num);
			pstmt.setString(8,chart_code);
			pstmt.setString(9,locale);
			pstmt.setString(10,perio_arch);
			pstmt.setString(11,patient_id);
			pstmt.setString(12,chart_code);
			pstmt.setString(13,chart_num2);
			pstmt.setString(14,chart_line_num2);
			pstmt.setString(15,chart_code);
			pstmt.setString(16,locale);
			pstmt.setString(17,perio_arch);
			pstmt.setString(18,patient_id);
			pstmt.setString(19,chart_code);
			pstmt.setString(20,chart_num3);
			pstmt.setString(21,chart_line_num3);
			pstmt.setString(22,component_code);
		}
		rs=pstmt.executeQuery();

		int k=0;
		while(rs.next()){
						++k;
							next_row_flag = (comp_str.equals( rs.getString("COMPONENT_CODE")+"#"+rs.getString("LINE_SEQ")) )?"N":"Y";
							comp_code	 =  rs.getString("COMPONENT_CODE");//component code
							tooth_num			 =  rs.getString("TOOTH_NO");//tooth number
							S1				 =  checkForNull(rs.getString("VALUE"),"&nbsp;");//surface-1   
							//chart_line_num =  rs.getString(12);//val
							surfaces_appl_yn =  rs.getString("SURFACES_APPL_YN");//val
							row_color =  rs.getString("LINE_COLOR");//val 
							line_seq =  rs.getString("LINE_SEQ");//val
							if(no_of_charts.equals("2")){
						if("BE".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?"Baseline":"Evaluation";//chart_date
							}else if("EE".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?"Evaluation1":"Evaluation2";//chart_date
							}else if("BB".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?"Baseline1":"Baseline2";//chart_date
							}
				}else if(no_of_charts.equals("3")){
						if("BE".equals(eval_type)){
							if("1".equals(line_seq)){
								chart_date = "Baseline1";
							}else if("2".equals(line_seq)){
								chart_date = "Evaluation1";
							}else if("3".equals(line_seq)){
								chart_date = "Evaluation2";
							}
						}else if("EE".equals(eval_type)){
								if("1".equals(line_seq)){
									chart_date = "Evaluation1";
								}else if("2".equals(line_seq)){
									chart_date = "Evaluation2";
								}else if("3".equals(line_seq)){
									chart_date = "Evaluation3";
								}
							}else if("BB".equals(eval_type)){
								if("1".equals(line_seq)){
									chart_date = "Baseline1";
								}else if("2".equals(line_seq)){
									chart_date = "Baseline2";
								}else if("3".equals(line_seq)){
									chart_date = "Baseline3";
								}
							}
				}
							/*if("BE".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?eval_chart_date1+"(BL)":eval_chart_date1+"(EV)";//chart_date
							}else if("EE".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?eval_chart_date1+"(EV1)":eval_chart_date2+"(EV2)";//chart_date
							}else if("BB".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?eval_chart_date1+"(BL1)":eval_chart_date2+"(BL2)";//chart_date
							}*/
                         String SQL1="SELECT B.CUT_OFF FROM OH_PERIODONTAL_CHART_COMP A,OH_PERIODONTAL_CHART_DEF_DTL B WHERE  A.COMPONENT_CODE=B.COMPONENT_CODE AND  B.CHART_CODE = ? and B.COMPONENT_CODE=? ";
							pstmt1=con.prepareStatement(SQL1);
							pstmt1.setString(1,chart_code);
							pstmt1.setString(2,component_code);
							rs1 = pstmt1.executeQuery();
							while(rs1.next()){
							cut_off = checkForNull(rs1.getString("CUT_OFF"));
							}
							sbr.setLength(0);
							if("N".equals(surfaces_appl_yn)){
									sbr.append("<table width=100% cellpadding =0 cellspacing=1 border=1>");
									sbr.append("<tr>");
									//sbr.append("<td class="+row_color+" nowrap>").append(S1).append("</td>");
									//sbr.append("<td class="+row_color+" nowrap>").append(S2).append("</td>");
									//sbr.append("<td class="+row_color+" nowrap>").append(S3).append("</td>");
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
									sbr.append("</tr>");
									sbr.append("</table>");
								
							}	
							comp_str = component_code+"#"+ rs.getString("LINE_SEQ");
							if("Y".equals(next_row_flag) ) {
								out.println("<tr>");
								if("1".equals(line_seq) ){
										//out.println("<td  class='"+row_color+"' >"+component_code+"</td>");
										out.println("<td  class='"+row_color+"' >"+component_desc+"</td>");
								}else{
									out.println("<td  class='"+row_color+"' >&nbsp;</td>");
								}
									out.println("<td  class='"+row_color+"' nowrap>"+chart_date+"</td>");
									tooth_str_arr = tooth_str.split(",");
									for(int j=0;j<tooth_str_arr.length;j++){
										td_id =line_seq+component_code+tooth_str_arr[j] ;
										if(tooth_str_arr[j].equals(tooth_num) ){
											out.println("<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										}else{
											out.println("<td class='"+row_color+"' id="+td_id+" style=text-align:center>&nbsp;&nbsp;</td>");
										}
									}//for
								out.println("</tr>");
							}else{
							for(int j=0;j<tooth_str_arr.length;j++){
								td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) )
									out.println("<SCRIPT>assignValueToCell('"+td_id+"','"+sbr.toString()+"','"+cut_off+"');</SCRIPT>");
								}
						}
						sbr.setLength(0);
				}//end of while
	}else{
if(no_of_charts.equals("2")){
		sql="SELECT COMPONENT_CODE,TOOTH_NO, S1, S2, S3, S4, S5, S6,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6 ,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	   	(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	  	FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	  WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	  AND Y.PERMANENT_DECIDUOUS = 'P'	 AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D	 WHERE A.PATIENT_ID(+) =?	   	 AND A.CHART_CODE(+) =?	AND A.CHART_NUM(+)  =?	AND A.CHART_LINE_NUM(+) =?	 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	 UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		 WHERE COMPONENT_CODE =?		   ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";
	
}else{
			sql="SELECT COMPONENT_CODE,TOOTH_NO, S1, S2, S3, S4, S5, S6,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6 ,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	   	(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	  	FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	  WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	  AND Y.PERMANENT_DECIDUOUS = 'P'	 AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D	 WHERE A.PATIENT_ID(+) =?	   	 AND A.CHART_CODE(+) =?	AND A.CHART_NUM(+)  =?	AND A.CHART_LINE_NUM(+) =?	 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	 UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,3 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE)  		 WHERE COMPONENT_CODE =?		   ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";

}
if(no_of_charts.equals("3")){
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,chart_code);
		pstmt.setString(2,locale);
		pstmt.setString(3,perio_arch);
		pstmt.setString(4,patient_id);
		pstmt.setString(5,chart_code);
		pstmt.setString(6,chart_num);
		pstmt.setString(7,chart_line_num);
		pstmt.setString(8,chart_code);
		pstmt.setString(9,locale);
		pstmt.setString(10,perio_arch);
		pstmt.setString(11,patient_id);
		pstmt.setString(12,chart_code);
		pstmt.setString(13,chart_num2);
		pstmt.setString(14,chart_line_num2);
		pstmt.setString(15,chart_code);
		pstmt.setString(16,locale);
		pstmt.setString(17,perio_arch);
		pstmt.setString(18,patient_id);
		pstmt.setString(19,chart_code);
		pstmt.setString(20,chart_num3);
		pstmt.setString(21,chart_line_num3);
		pstmt.setString(22,component_code);
}else{
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,chart_code);
		pstmt.setString(2,locale);
		pstmt.setString(3,perio_arch);
		pstmt.setString(4,patient_id);
		pstmt.setString(5,chart_code);
		pstmt.setString(6,chart_num);
		pstmt.setString(7,chart_line_num);
		pstmt.setString(8,chart_code);
		pstmt.setString(9,locale);
		pstmt.setString(10,perio_arch);
		pstmt.setString(11,patient_id);
		pstmt.setString(12,chart_code);
		pstmt.setString(13,chart_num2);
		pstmt.setString(14,chart_line_num2);
		pstmt.setString(15,component_code);
}
		rs=pstmt.executeQuery();
					int k=0;
					while(rs.next()){
							++k;
							next_row_flag = (comp_str.equals( rs.getString(1)+"#"+rs.getString(11)) )?"N":"Y";
							comp_code	 =  rs.getString(1);//component code
							tooth_num			 =  rs.getString(2);//tooth number
							S1				 =  checkForNull(rs.getString(3),"&nbsp;");//surface-1   
							S2				 =  checkForNull(rs.getString(4),"&nbsp;");//surface-2     
							S3				 =  checkForNull(rs.getString(5),"&nbsp;");//surface-3     
							S4				 =  checkForNull(rs.getString(6),"&nbsp;");//surface-4     
							S5				 =  checkForNull(rs.getString(7),"&nbsp;");//surface-5     
							S6				 =  checkForNull(rs.getString(8),"&nbsp;");//surface-6    
							//chart_line_num =  rs.getString(12);//val
							surfaces_appl_yn =  rs.getString(9);//val
							row_color =  rs.getString(10);//val 
							line_seq =  rs.getString(11);//val
						//	component_desc=  rs.getString(12);//val
				if(no_of_charts.equals("2")){
						if("BE".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?"Baseline":"Evaluation";//chart_date
							}else if("EE".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?"Evaluation1":"Evaluation2";//chart_date
							}else if("BB".equals(eval_type)){
								chart_date			 = ("1".equals(line_seq))?"Baseline1":"Baseline2";//chart_date
							}
				}else if(no_of_charts.equals("3")){
						if("BE".equals(eval_type)){
							if("1".equals(line_seq)){
								chart_date = "Baseline1";
							}else if("2".equals(line_seq)){
								chart_date = "Evaluation1";
							}else if("3".equals(line_seq)){
								chart_date = "Evaluation2";
							}
						}else if("EE".equals(eval_type)){
								if("1".equals(line_seq)){
									chart_date = "Evaluation1";
								}else if("2".equals(line_seq)){
									chart_date = "Evaluation2";
								}else if("3".equals(line_seq)){
									chart_date = "Evaluation3";
								}
							}else if("BB".equals(eval_type)){
								if("1".equals(line_seq)){
									chart_date = "Baseline1";
								}else if("2".equals(line_seq)){
									chart_date = "Baseline2";
								}else if("3".equals(line_seq)){
									chart_date = "Baseline3";
								}
							}
				}


							 String SQL1="SELECT B.CUT_OFF FROM OH_PERIODONTAL_CHART_COMP A,OH_PERIODONTAL_CHART_DEF_DTL B WHERE  A.COMPONENT_CODE=B.COMPONENT_CODE AND  B.CHART_CODE = ? and B.COMPONENT_CODE=? ";
							pstmt1=con.prepareStatement(SQL1);
							pstmt1.setString(1,chart_code);
							pstmt1.setString(2,component_code);
							rs1 = pstmt1.executeQuery();
							while(rs1.next()){
							cut_off = checkForNull(rs1.getString("CUT_OFF"));
							}
							sbr.setLength(0);
							if("Y".equals(surfaces_appl_yn)){
									sbr.append("<table width=100% cellpadding =0 cellspacing=1 border=1>");
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
								
							}	
							comp_str = component_code+"#"+ rs.getString(11);
							if("Y".equals(next_row_flag) ) {
								out.println("<tr>");
								if("1".equals(line_seq) ){
									//	out.println("<td  class='"+row_color+"' >"+component_code+"</td>");
										out.println("<td  class='"+row_color+"' >"+component_desc+"</td>");
								}else{
									out.println("<td  class='"+row_color+"' >&nbsp;</td>");
								}
									out.println("<td  class='"+row_color+"' nowrap>"+chart_date+"</td>");
									tooth_str_arr = tooth_str.split(",");
							/*		if(chart_compare.equals("3")){
								if(chart_line_num.equals(eval_chart_line_num1) )
									out.println("<td  class='"+row_color+"' >"+component_desc+"</td>");
								else
									out.println("<td  class='"+row_color+"' >&nbsp;</td>");
									out.println("<td  class='"+row_color+"' nowrap>"+chart_date+"</td>");
									tooth_str_arr = tooth_str.split(",");
								}else  if(chart_compare.equals("2")){
								if(chart_line_num.equals(eval_chart_line_num2) )
									out.println("<td  class='"+row_color+"' >"+component_desc+"</td>");
								else
									out.println("<td  class='"+row_color+"' >&nbsp;</td>");
									out.println("<td  class='"+row_color+"' nowrap>"+chart_date+"</td>");
									tooth_str_arr = tooth_str.split(",");
								}*/
									for(int j=0;j<tooth_str_arr.length;j++){
										td_id =line_seq+component_code+tooth_str_arr[j] ;
										if(tooth_str_arr[j].equals(tooth_num) ){
											out.println("<td class='"+row_color+"' id="+td_id+" style=text-align:center >"+sbr.toString()+"</td>");
										}else{
											out.println("<td class='"+row_color+"' id="+td_id+" style=text-align:center>&nbsp;&nbsp;</td>");
										}
									}//for
								out.println("</tr>");
							}else{
							for(int j=0;j<tooth_str_arr.length;j++){
								td_id =line_seq+component_code+tooth_str_arr[j] ;
									if(tooth_str_arr[j].equals(tooth_num) )
									out.println("<SCRIPT>assignValueToCell('"+td_id+"','"+sbr.toString()+"','"+cut_off+"');</SCRIPT>");
								}
						}
						sbr.setLength(0);
				}//end of while 
			}//end of surface_appl_yn
			
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Mesg From PerioCompareBuccalGraphTableView.jsp"+e);
		}finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null)
				ConnectionManager.returnConnection(con,request); 
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Buccal.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
