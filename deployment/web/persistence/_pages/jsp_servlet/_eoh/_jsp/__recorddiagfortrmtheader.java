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
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __recorddiagfortrmtheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/RecordDiagForTrmtHeader.jsp", 1709119366083L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eOH/js/RecordDiagForTrmt.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eOH/js/Hashtable.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t<form>\n\t\t\t<table align=\'center\' cellpadding=\'4\' cellspacing=\'\' border=\'1\' width=\'98%\'>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"20%\" >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t\t\t\t\t<td width=\"20%\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t\t\t\t<td width=\"20%\"><a href=\"javascript:showDiagAndLinkedCond(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a></td>\n\t\t\t\t\t\t\t\t<td width=\"20%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t\t\t<td width=\"20%\" >&nbsp;&nbsp;<input type=\"checkbox\" name=\"chk_select";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"chk_select";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" diag_code=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' term_set_id=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' trmt_code=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' diag_chart_line_num = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onclick=\'validateDeleteCheckBox(this);\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t<!-- <td width=\"20%\" >&nbsp;&nbsp;<input type=\"checkbox\" name=\"chk_select";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' onclick=\'validateDeleteCheckBox(this);\'>&nbsp;&nbsp;</td> -->\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"button\" colspan=\"6\"><input type=\"button\" class=\"button\" name=\"record\" id=\"record\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' onclick=\"deleteOptions();\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="></td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t</table>\n\n\t\t\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t<input type=\"hidden\" name=\"execute_flag\" id=\"execute_flag\" value=\"YES\" >\n\t\t\t<!-- <input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" > -->\n\t\t\t<!-- <input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" > -->\n\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n\t\t\t<input type=\"hidden\" name=\"chart_num\" id=\"chart_num\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t\t\t<input type=\"hidden\" name=\"chart_line_num\" id=\"chart_line_num\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t\t\t<input type=\"hidden\" name=\"ind_chart_line_num\" id=\"ind_chart_line_num\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n\t\t\t<input type=\"hidden\" name=\"trmt_code\" id=\"trmt_code\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\t\t\t<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n\t\t\t<input type=\"hidden\" name=\"tooth_no\" id=\"tooth_no\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t\t\t<input type=\"hidden\" name=\"tooth_count\" id=\"tooth_count\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t\t\t<input type=\"hidden\" name=\"other_chart_facility_id\" id=\"other_chart_facility_id\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t\t\t<input type=\"hidden\" name=\"oh_chart_level\" id=\"oh_chart_level\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t\t\t\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );
 
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
 request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String term_code = "";
	String onset_date = "";
	String accuracy = "";
	String term_code_desc = "";
	String term_set_id = "";
	String occur_srl_no = "";

	String facility_id = (String)session.getValue("facility_id") ;
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
	String ind_chart_line_num = checkForNull(request.getParameter("ind_chart_line_num"));//Indivisual chart_line_num of a tooth in case of Tooth Range
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String practitioner_id = checkForNull(request.getParameter("practitioner_id"));
	String trmt_code = checkForNull(request.getParameter("trmt_code"));
	String tooth_no = checkForNull(request.getParameter("tooth_no"));
	String tooth_count = checkForNull(request.getParameter("tooth_count"));

	String status_disabled =  checkForNull(request.getParameter("status_disabled"));
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
	String baseline_chart_yn  = checkForNull(request.getParameter( "baseline_chart_yn" )) ;	//Added by Sridevi Joshi on 5/31/2010 for IN021668		
	String date_diff_flag  = checkForNull(request.getParameter( "date_diff_flag" )) ;	//Added by Sridevi Joshi on 5/31/2010 for IN021668		

	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	if(!other_chart_facility_id.equals(facility_id) || baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/31/2010 for IN021668		
		status_disabled = "disabled";	
	}
		
	try{
		con=ConnectionManager.getConnection(request);

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

						int i=1;
						if(pstmt != null) pstmt.close();
						if(rs != null) rs.close();
						//pstmt=con.prepareStatement("SELECT A.DIAG_CODE,A.TRMT_CODE, A.CHART_LINE_NUM, DECODE(B.SITE_TYPE,'TOOTH',TOOTH_NO,'THRNG',TOOTH_NO,'ARCH',ARCH_SNO,'QUAD',QUADRANT_SNO) AREA,(SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.DIAG_CODE ) DIAG_DESC,(SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ONSET_FACILITY_ID = A.OPERATING_FACILITY_ID AND D.ONSET_ENCOUNTER_ID = A.ENCOUNTER_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.DIAG_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND A.CHART_NUM = ? ORDER BY A.DIAG_CODE");
						//pstmt=con.prepareStatement("SELECT A.DIAG_CODE,A.TRMT_CODE, (SELECT C.TRMT_DESC FROM OH_TREATMENT C WHERE C.TRMT_CODE = A.TRMT_CODE) TRMT_DESC, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') DIAG_DATE, A.CHART_LINE_NUM, (SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.DIAG_CODE ) DIAG_DESC,(SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ONSET_FACILITY_ID = A.OPERATING_FACILITY_ID AND D.ONSET_ENCOUNTER_ID = A.ENCOUNTER_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.DIAG_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.CHART_NUM = B.CHART_NUM AND A.CHART_LINE_NUM = B.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? ORDER BY A.DIAG_CODE");
						if(oh_chart_level.equals("E")){
						pstmt=con.prepareStatement("SELECT A.TERM_SET_ID, A.OCCUR_SRL_NO, A.TERM_CODE, A.TRMT_CHART_NUM, A.TRMT_CHART_LINE_NUM, A.TRMT_CODE, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') DIAG_DATE,(SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.TERM_CODE) TERM_CODE_DESC,(SELECT SHORT_DESC FROM MR_ACCURACY, PR_DIAGNOSIS K WHERE ACCURACY_CODE =K.CURR_ACCURACY_CODE AND K.TERM_SET_ID = A.TERM_SET_ID AND K.TERM_CODE = A.TERM_CODE AND K.PATIENT_ID = A.PATIENT_ID AND A.OCCUR_SRL_NO=K.OCCUR_SRL_NO) ACCURACY_SHORT_DESC, (SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.TRMT_CHART_NUM = B.CHART_NUM AND A.TRMT_CHART_LINE_NUM = B.CHART_LINE_NUM  AND A.PATIENT_ID = ?  AND A.TRMT_CHART_NUM = ? AND A.TRMT_CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND NVL(B.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TERM_CODE ");

						//pstmt.setString(1,facility_id);
						pstmt.setString(1,patient_id);
						pstmt.setString(2,chart_num);
						pstmt.setString(3,ind_chart_line_num);//Indivisual chart_line_num of a tooth in case of Tooth Range
						pstmt.setString(4,trmt_code);
						rs = pstmt.executeQuery();
						}else{
						pstmt=con.prepareStatement("SELECT A.TERM_SET_ID, A.OCCUR_SRL_NO, A.TERM_CODE, A.TRMT_CHART_NUM, A.TRMT_CHART_LINE_NUM, A.TRMT_CODE, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') DIAG_DATE,(SELECT C.LONG_DESC FROM MR_TERM_CODE C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND C.TERM_CODE = A.TERM_CODE) TERM_CODE_DESC,(SELECT SHORT_DESC FROM MR_ACCURACY, PR_DIAGNOSIS K WHERE ACCURACY_CODE =K.CURR_ACCURACY_CODE AND K.TERM_SET_ID = A.TERM_SET_ID AND K.TERM_CODE = A.TERM_CODE AND K.PATIENT_ID = A.PATIENT_ID AND A.OCCUR_SRL_NO=K.OCCUR_SRL_NO) ACCURACY_SHORT_DESC, (SELECT TO_CHAR (D.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE FROM PR_DIAGNOSIS D WHERE D.PATIENT_ID = A.PATIENT_ID AND D.ONSET_FACILITY_ID = A.OPERATING_FACILITY_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND D.OCCUR_SRL_NO = A.OCCUR_SRL_NO) ONSET_DATE FROM OH_RESTORATIVE_CHART_DIAG A, OH_RESTORATIVE_CHART_DTL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.PATIENT_ID = B.PATIENT_ID AND A.TRMT_CODE = B.TRMT_CODE AND A.TRMT_CHART_NUM = B.CHART_NUM AND A.TRMT_CHART_LINE_NUM = B.CHART_LINE_NUM AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND A.TRMT_CHART_NUM = ? AND A.TRMT_CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND NVL(B.COND_CLOSED_YN,'N') = 'N' ORDER BY A.TERM_CODE ");

						pstmt.setString(1,other_chart_facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_num);
						pstmt.setString(4,ind_chart_line_num);//Indivisual chart_line_num of a tooth in case of Tooth Range
						pstmt.setString(5,trmt_code);
						rs = pstmt.executeQuery();
						
						
						}
						/*
						if ( start != 1 ){
							for( int j=1; j<start; i++,j++ ){
								rs.next() ;
							}
						}
						*/
				
						
						//while(rs.next() && i<=end ){
						while(rs.next()){
							
							term_code = checkForNull(rs.getString("TERM_CODE"));
							onset_date = checkForNull(rs.getString("ONSET_DATE"));
							accuracy = checkForNull(rs.getString("ACCURACY_SHORT_DESC"));
							term_code_desc = checkForNull(rs.getString("TERM_CODE_DESC"));
							term_set_id = checkForNull(rs.getString("TERM_SET_ID"));
							occur_srl_no = checkForNull(rs.getString("OCCUR_SRL_NO"));
				
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(checkForNull(rs.getString("DIAG_DATE"))));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(checkForNull(rs.getString("ONSET_DATE"))));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(checkForNull(rs.getString("TERM_SET_ID"))));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(accuracy));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(checkForNull(rs.getString("TERM_CODE"))));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(checkForNull(rs.getString("TERM_CODE_DESC"))));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(checkForNull(rs.getString("TERM_CODE"))));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(rs.getString("TERM_SET_ID"))));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checkForNull(rs.getString("TRMT_CODE"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rs.getString("TRMT_CHART_LINE_NUM"))));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(checkForNull(rs.getString("TERM_CODE"))));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checkForNull(rs.getString("TRMT_CODE"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rs.getString("TRMT_CHART_LINE_NUM"))));
            _bw.write(_wl_block21Bytes, _wl_block21);
				/*
								if(totalSelected!=null && totalSelected.length()>0){
									String tokens[] = totalSelected.split(",");
									for(int p = 0;p<tokens.length;p++){
										if(Integer.parseInt(tokens[p])==i){
											out.println("<script>assignDeleteListValue("+tokens[p]+");</script>");
										}
									}
								}
								*/
				
            _bw.write(_wl_block22Bytes, _wl_block22);

							i++;
						}
				
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block26Bytes, _wl_block26);
//=start
            _bw.write(_wl_block27Bytes, _wl_block27);
//=end
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ind_chart_line_num));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tooth_no));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tooth_count));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block39Bytes, _wl_block39);

}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}

            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
}
