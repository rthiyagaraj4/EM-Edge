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

public final class __recorddiagfortrmt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/RecordDiagForTrmt.jsp", 1709119365301L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script language=\'javascript\' src=\'../../eOH/js/RecordDiagForTrmt.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eOH/js/Hashtable.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onload=\"assignDBValue(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');\" OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t<form>\n\t\t\t<table align=\'center\' cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"25%\" class=\'CAGROUPHEADING\' colspan=\'4\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td> \n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"25%\" class=\'label\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td> \n\t\t\t\t\t\t<td width=\"25%\" class=\'label\' id=\'diagnosis_options\'>\n\t\t\t\t\t\t\t<select name=\'diag_select\' id=\'diag_select\' onchange=\'showDiagDetails(this);\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t\t\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="##";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"25%\">&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td width=\"25%\">&nbsp;&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td id=\"diag_details\" colspan=\'4\'></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<input type=\"hidden\" name=\"execute_flag\" id=\"execute_flag\" value=\"YES\" >\n\t\t\t<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t\t<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t\t\t<input type=\"hidden\" name=\"chart_num\" id=\"chart_num\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t\t<input type=\"hidden\" name=\"chart_line_num\" id=\"chart_line_num\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t\t\t<input type=\"hidden\" name=\"ind_chart_line_num\" id=\"ind_chart_line_num\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t\t\t<input type=\"hidden\" name=\"trmt_code\" id=\"trmt_code\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\t\t\t<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t\t<input type=\"hidden\" name=\"totalselected\" id=\"totalselected\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" > \n\t\t\t<input type=\"hidden\" name=\"permanent_deciduous_flag\" id=\"permanent_deciduous_flag\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" > \n\t\t\t<input type=\"hidden\" name=\"tooth_numbering_system\" id=\"tooth_numbering_system\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" > \n\t\t\t<input type=\"hidden\" name=\"site_type\" id=\"site_type\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" > \n\t\t\t<input type=\"hidden\" name=\"area_param\" id=\"area_param\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" > \n\t\t\t<input type=\"hidden\" name=\"thrng_nos_ref\" id=\"thrng_nos_ref\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" > \n\t\t\t<input type=\"hidden\" name=\"oh_chart_level\" id=\"oh_chart_level\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" > \n\t\t\t<input type=\"hidden\" name=\"other_chart_facility_id\" id=\"other_chart_facility_id\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" > \n\t\t\t<input type=\"hidden\" name=\"baseline_chart_yn\" id=\"baseline_chart_yn\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" > \n\t\t\t<input type=\"hidden\" name=\"date_diff_flag\" id=\"date_diff_flag\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" > \n\t\t</form>\n\t</body>\n</html>\n";
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
	StringBuffer strBuffer = new StringBuffer();

	String facility_id = (String)session.getValue("facility_id") ;
	String chart_num = checkForNull(request.getParameter("chart_num"));
	String chart_line_num = checkForNull(request.getParameter("chart_line_num"));
	String ind_chart_line_num = checkForNull(request.getParameter("ind_chart_line_num"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String practitioner_id = checkForNull(request.getParameter("practitioner_id"));
	String trmt_code = checkForNull(request.getParameter("trmt_code"));
	String totalselected = checkForNull(request.getParameter("totalselected"));
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String site_type = checkForNull(request.getParameter("site_type"));
	String area_param = checkForNull(request.getParameter("area_param"));
	String thrng_nos_ref = checkForNull(request.getParameter("thrng_nos_ref"));
	String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));//Added by Sridevi Joshi on 5/31/2010 for IN021668		
	String date_diff_flag = checkForNull(request.getParameter("date_diff_flag"));//Added by Sridevi Joshi on 5/31/2010 for IN021668		

	//Diagnosis Params
	String term_code = checkForNull(request.getParameter("term_code"));
	String accuracy = checkForNull(request.getParameter("accuracy"));
	String onset_date = checkForNull(request.getParameter("onset_date"));
	String term_code_desc = checkForNull(request.getParameter("term_code_desc"));
	String mode = checkForNull(request.getParameter("mode"));


	String from = checkForNull(request.getParameter( "from" )) ;
	String to =   checkForNull(request.getParameter( "to" ) ) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
	int end =  ( to.equals("") )?7:Integer.parseInt(to);

	String link_already_exists_yn = "";
	String term_set_id = "";
	String occur_srl_no = "";
	String accuracy_short_desc = "";
	String diag_status = "";
	String pract_type = "";

	String status_disabled =  checkForNull(request.getParameter("status_disabled"));
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	if(!other_chart_facility_id.equals(facility_id)|| baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/31/2010 for IN021668		
		status_disabled = "disabled";	
	}
	
	try{
		con=ConnectionManager.getConnection(request);

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(accuracy));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

					if(!mode.equals("modify")){
				
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

								int i=1;

								if(pstmt != null) pstmt.close();
								if(rs != null) rs.close();

								pstmt=con.prepareStatement("SELECT PRACT_TYPE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = ?");
								pstmt.setString(1,practitioner_id);
								rs = pstmt.executeQuery();
								while(rs.next()){
									pract_type = rs.getString("PRACT_TYPE");
								}

								if(pstmt != null) pstmt.close();
								if(rs != null) rs.close();

								
								//pstmt=con.prepareStatement("SELECT E.ENC_STAGE,A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE,A.CURR_ACCURACY_CODE,A.CURR_ACCURACY_IND , C.NOTIFIABLE_YN,C.SHORT_DESC,C.LONG_DESC TERM_CODE_DESC, (SELECT SHORT_DESC FROM MR_ACCURACY WHERE ACCURACY_CODE =A.CURR_ACCURACY_CODE ) ACCURACY_SHORT_DESC,DECODE(A.CURR_NATURE,'A','ACTUAL','P','POTENTIAL','W','WELLNESS') NATURE , TO_CHAR (A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE , DECODE(A.CURR_STATUS,'A','ACTIVE','R','RESOLVED','X','REVOKED','E','IN ERROR') STATUS  ,A.CURR_PRIORITY PRIORITY ,NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID   AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO  AND FACILITY_ID=? AND ENCOUNTER_ID=?  AND ROWNUM=1 ),'N')CURR_ENC_YN,A.OCCUR_SRL_NO,NVL((SELECT 'Y' FROM PR_SUPPORT_DIAGNOSIS WHERE PATIENT_ID =A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID  AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ROWNUM=1 ),'N') SUPPORT_EXISIST_YN_YN FROM PR_DIAGNOSIS A , MR_TERM_SET B , MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID=E.PATIENT_ID  AND A.TERM_SET_ID=E.TERM_SET_ID  AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO  AND A.TERM_CODE =E.TERM_CODE  AND A.ONSET_FACILITY_ID=E.FACILITY_ID AND A.ONSET_ENCOUNTER_ID=E.ENCOUNTER_ID AND EXISTS (SELECT  1 FROM MR_TERM_SET_FOR_FACILITY WHERE FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID ) AND EXISTS (   SELECT 1 FROM  MR_TERM_SET_FOR_PRACT_TYPE WHERE PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID  ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE  FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?) AND TERM_SET_ID=A.TERM_SET_ID   ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT IB WHERE PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID  OR NOT EXISTS ( SELECT 1 FROM MR_TERM_SET_FOR_PRACT  WHERE PRACTITIONER_ID=IB.PRACTITIONER_ID  ))AND (A.CURR_STATUS= 'A' OR EXISTS (SELECT 1 FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID  AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A. TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND FACILITY_ID=? AND ENCOUNTER_ID=? AND ROWNUM=1 )) AND B.TERM_SET_ID(+) = A.TERM_SET_ID AND C.TERM_SET_ID(+) =A.TERM_SET_ID  AND C.TERM_CODE(+)=A.TERM_CODE ORDER BY TERM_SET_ID , ONSET_DATE DESC");
								if(oh_chart_level.equals("E")){
									pstmt=con.prepareStatement("SELECT E.ENC_STAGE,A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE,A.CURR_ACCURACY_CODE,A.CURR_ACCURACY_IND , C.NOTIFIABLE_YN,C.SHORT_DESC,C.LONG_DESC TERM_CODE_DESC, (SELECT SHORT_DESC FROM MR_ACCURACY WHERE ACCURACY_CODE =A.CURR_ACCURACY_CODE ) ACCURACY_SHORT_DESC,DECODE(A.CURR_NATURE,'A','ACTUAL','P','POTENTIAL','W','WELLNESS') NATURE , TO_CHAR (A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE , DECODE(A.CURR_STATUS,'A','ACTIVE','R','RESOLVED','X','REVOKED','E','IN ERROR') STATUS, A.CURR_PRIORITY PRIORITY ,NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID   AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ENCOUNTER_ID=?  AND ROWNUM=1 ),'N')CURR_ENC_YN,A.OCCUR_SRL_NO,NVL((SELECT 'Y' FROM PR_SUPPORT_DIAGNOSIS WHERE PATIENT_ID =A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID  AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ROWNUM=1 ),'N') SUPPORT_EXISIST_YN_YN, (SELECT 'Y' FROM OH_RESTORATIVE_CHART_DIAG OH WHERE OH.PATIENT_ID=E.PATIENT_ID AND OH.TERM_SET_ID=E.TERM_SET_ID AND OH.TERM_CODE=E.TERM_CODE AND OH.TRMT_CHART_NUM=? AND OH.TRMT_CHART_LINE_NUM=? AND OH.TRMT_CODE=?) LINK_ALREADY_EXISTS_YN FROM PR_DIAGNOSIS A , MR_TERM_SET B , MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID=E.PATIENT_ID  AND A.TERM_SET_ID=E.TERM_SET_ID  AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO  AND A.TERM_CODE =E.TERM_CODE  AND A.ONSET_FACILITY_ID=E.FACILITY_ID AND A.ONSET_ENCOUNTER_ID=E.ENCOUNTER_ID AND EXISTS (SELECT  1 FROM MR_TERM_SET_FOR_FACILITY WHERE TERM_SET_ID=A.TERM_SET_ID ) AND EXISTS (   SELECT 1 FROM  MR_TERM_SET_FOR_PRACT_TYPE WHERE PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID  ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE  FROM PR_ENCOUNTER WHERE  ENCOUNTER_ID=?) AND TERM_SET_ID=A.TERM_SET_ID   ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT IB WHERE PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID  OR NOT EXISTS ( SELECT 1 FROM MR_TERM_SET_FOR_PRACT  WHERE PRACTITIONER_ID=IB.PRACTITIONER_ID  ))AND (A.CURR_STATUS= 'A' OR EXISTS (SELECT 1 FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID  AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A. TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ENCOUNTER_ID=? AND ROWNUM=1 )) AND B.TERM_SET_ID(+) = A.TERM_SET_ID AND C.TERM_SET_ID(+) =A.TERM_SET_ID  AND C.TERM_CODE(+)=A.TERM_CODE ORDER BY TERM_SET_ID , ONSET_DATE DESC");						
							//	pstmt.setString(1,facility_id);
								pstmt.setString(1,encounter_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,chart_line_num);
								pstmt.setString(4,trmt_code);
								pstmt.setString(5,patient_id);
								//pstmt.setString(6,facility_id);
								pstmt.setString(6,pract_type);
								//pstmt.setString(8,facility_id);
								pstmt.setString(7,encounter_id);
								pstmt.setString(8,practitioner_id);
								//pstmt.setString(11,facility_id);
								pstmt.setString(9,encounter_id);
								rs = pstmt.executeQuery();
								}else{
								pstmt=con.prepareStatement("SELECT E.ENC_STAGE,A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE,A.CURR_ACCURACY_CODE,A.CURR_ACCURACY_IND , C.NOTIFIABLE_YN,C.SHORT_DESC,C.LONG_DESC TERM_CODE_DESC, (SELECT SHORT_DESC FROM MR_ACCURACY WHERE ACCURACY_CODE =A.CURR_ACCURACY_CODE ) ACCURACY_SHORT_DESC,DECODE(A.CURR_NATURE,'A','ACTUAL','P','POTENTIAL','W','WELLNESS') NATURE , TO_CHAR (A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE , DECODE(A.CURR_STATUS,'A','ACTIVE','R','RESOLVED','X','REVOKED','E','IN ERROR') STATUS, A.CURR_PRIORITY PRIORITY ,NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID   AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO  AND FACILITY_ID=? AND ENCOUNTER_ID=?  AND ROWNUM=1 ),'N')CURR_ENC_YN,A.OCCUR_SRL_NO,NVL((SELECT 'Y' FROM PR_SUPPORT_DIAGNOSIS WHERE PATIENT_ID =A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID  AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ROWNUM=1 ),'N') SUPPORT_EXISIST_YN_YN, (SELECT 'Y' FROM OH_RESTORATIVE_CHART_DIAG OH WHERE OH.OPERATING_FACILITY_ID = E.FACILITY_ID AND OH.PATIENT_ID=E.PATIENT_ID AND OH.TERM_SET_ID=E.TERM_SET_ID AND OH.TERM_CODE=E.TERM_CODE AND OH.TRMT_CHART_NUM=? AND OH.TRMT_CHART_LINE_NUM=? AND OH.TRMT_CODE=?) LINK_ALREADY_EXISTS_YN FROM PR_DIAGNOSIS A , MR_TERM_SET B , MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID=E.PATIENT_ID  AND A.TERM_SET_ID=E.TERM_SET_ID  AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO  AND A.TERM_CODE =E.TERM_CODE  AND A.ONSET_FACILITY_ID=E.FACILITY_ID AND A.ONSET_ENCOUNTER_ID=E.ENCOUNTER_ID AND EXISTS (SELECT  1 FROM MR_TERM_SET_FOR_FACILITY WHERE FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID ) AND EXISTS (   SELECT 1 FROM  MR_TERM_SET_FOR_PRACT_TYPE WHERE PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID  ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE  FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?) AND TERM_SET_ID=A.TERM_SET_ID   ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT IB WHERE PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID  OR NOT EXISTS ( SELECT 1 FROM MR_TERM_SET_FOR_PRACT  WHERE PRACTITIONER_ID=IB.PRACTITIONER_ID  ))AND (A.CURR_STATUS= 'A' OR EXISTS (SELECT 1 FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID  AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A. TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND FACILITY_ID=? AND ENCOUNTER_ID=? AND ROWNUM=1 )) AND B.TERM_SET_ID(+) = A.TERM_SET_ID AND C.TERM_SET_ID(+) =A.TERM_SET_ID  AND C.TERM_CODE(+)=A.TERM_CODE ORDER BY TERM_SET_ID , ONSET_DATE DESC");
						
								pstmt.setString(1,facility_id);
								pstmt.setString(2,encounter_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,chart_line_num);
								pstmt.setString(5,trmt_code);
								pstmt.setString(6,patient_id);
								pstmt.setString(7,facility_id);
								pstmt.setString(8,pract_type);
								pstmt.setString(9,facility_id);
								pstmt.setString(10,encounter_id);
								pstmt.setString(11,practitioner_id);
								pstmt.setString(12,facility_id);
								pstmt.setString(13,encounter_id);
								//pstmt=con.prepareStatement("SELECT E.ENC_STAGE,A.TERM_SET_ID, B.TERM_SET_DESC, A.TERM_CODE,A.CURR_ACCURACY_CODE,A.CURR_ACCURACY_IND , C.NOTIFIABLE_YN,C.SHORT_DESC,C.LONG_DESC TERM_CODE_DESC, (SELECT SHORT_DESC FROM MR_ACCURACY WHERE ACCURACY_CODE =A.CURR_ACCURACY_CODE ) ACCURACY_SHORT_DESC,DECODE(A.CURR_NATURE,'A','ACTUAL','P','POTENTIAL','W','WELLNESS') NATURE , TO_CHAR (A.ONSET_DATE,'DD/MM/YYYY') ONSET_DATE , DECODE(A.CURR_STATUS,'A','ACTIVE','R','RESOLVED','X','REVOKED','E','IN ERROR') STATUS, A.CURR_PRIORITY PRIORITY ,NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID   AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO  AND FACILITY_ID=? AND ENCOUNTER_ID=?  AND ROWNUM=1 ),'N')CURR_ENC_YN,A.OCCUR_SRL_NO,NVL((SELECT 'Y' FROM PR_SUPPORT_DIAGNOSIS WHERE PATIENT_ID =A.PATIENT_ID AND TERM_SET_ID=A.TERM_SET_ID  AND TERM_CODE =A.TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND ROWNUM=1 ),'N') SUPPORT_EXISIST_YN_YN, (SELECT 'Y' FROM OH_RESTORATIVE_CHART_DIAG OH WHERE OH.OPERATING_FACILITY_ID = E.FACILITY_ID AND OH.PATIENT_ID=E.PATIENT_ID AND OH.TERM_SET_ID=E.TERM_SET_ID AND OH.TERM_CODE=E.TERM_CODE AND OH.TRMT_CHART_NUM=? AND OH.TRMT_CHART_LINE_NUM=? AND OH.TRMT_CODE=?) LINK_ALREADY_EXISTS_YN FROM PR_DIAGNOSIS A , MR_TERM_SET B , MR_TERM_CODE C, PR_DIAGNOSIS_ENC_DTL E WHERE A.PATIENT_ID = ? AND A.PATIENT_ID=E.PATIENT_ID  AND A.TERM_SET_ID=E.TERM_SET_ID  AND A.OCCUR_SRL_NO=E.OCCUR_SRL_NO  AND A.TERM_CODE =E.TERM_CODE  AND A.ONSET_FACILITY_ID=E.FACILITY_ID AND A.ONSET_ENCOUNTER_ID=E.ENCOUNTER_ID AND EXISTS (SELECT  1 FROM MR_TERM_SET_FOR_FACILITY WHERE FACILITY_ID=? AND TERM_SET_ID=A.TERM_SET_ID ) AND EXISTS (   SELECT 1 FROM  MR_TERM_SET_FOR_PRACT_TYPE WHERE PRACT_TYPE=? AND TERM_SET_ID=A.TERM_SET_ID  ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_SPECIALTY WHERE SPECIALTY_CODE IN (SELECT SPECIALTY_CODE  FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=?) AND TERM_SET_ID=A.TERM_SET_ID   ) AND EXISTS (SELECT 1 FROM MR_TERM_SET_FOR_PRACT IB WHERE PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID  OR NOT EXISTS ( SELECT 1 FROM MR_TERM_SET_FOR_PRACT  WHERE PRACTITIONER_ID=IB.PRACTITIONER_ID  ))AND (A.CURR_STATUS= 'A' OR EXISTS (SELECT 1 FROM PR_DIAGNOSIS_STATUS WHERE PATIENT_ID =A.PATIENT_ID  AND TERM_SET_ID=A.TERM_SET_ID AND TERM_CODE =A. TERM_CODE AND OCCUR_SRL_NO =A.OCCUR_SRL_NO AND FACILITY_ID=? AND ENCOUNTER_ID=? AND ROWNUM=1 )) AND B.TERM_SET_ID(+) = A.TERM_SET_ID AND C.TERM_SET_ID(+) =A.TERM_SET_ID  AND C.TERM_CODE(+)=A.TERM_CODE ORDER BY TERM_SET_ID , ONSET_DATE DESC");
								/*pstmt.setString(1,other_chart_facility_id);
								pstmt.setString(2,encounter_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,chart_line_num);
								pstmt.setString(5,trmt_code);
								pstmt.setString(6,patient_id);
								//pstmt.setString(7,facility_id);
								pstmt.setString(7,other_chart_facility_id);
								pstmt.setString(8,pract_type);
								//pstmt.setString(9,facility_id);
								pstmt.setString(9,other_chart_facility_id);
								pstmt.setString(10,encounter_id);
								pstmt.setString(11,practitioner_id);
								//pstmt.setString(12,facility_id);
								pstmt.setString(12,other_chart_facility_id);
								pstmt.setString(13,encounter_id); */
								rs = pstmt.executeQuery();
								}
								if ( start != 1 )
								for( int j=1; j<start; i++,j++ )
									rs.next() ;
								String classValue= " ";
								while ( rs.next() && i<=end  ){
									if ( i % 2 == 0 )
										classValue = "QRYEVEN" ;
									else
										classValue = "QRYODD" ;

									link_already_exists_yn = checkForNull(rs.getString("LINK_ALREADY_EXISTS_YN"));
									term_set_id = checkForNull(rs.getString("TERM_SET_ID"));
									occur_srl_no = checkForNull(rs.getString("OCCUR_SRL_NO"));
									term_code = checkForNull(rs.getString("TERM_CODE"));
									term_code_desc = checkForNull(rs.getString("TERM_CODE_DESC"));
									accuracy_short_desc = checkForNull(rs.getString("ACCURACY_SHORT_DESC"));
									diag_status = checkForNull(rs.getString("STATUS"));
									onset_date = checkForNull(rs.getString("ONSET_DATE"));
									if(!link_already_exists_yn.equals("Y")){
									
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(accuracy_short_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(diag_status));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

									}
									if(totalselected!=null && totalselected.length()>0){
										String tokens[] = totalselected.split(",");
										for(int p = 0;p<tokens.length;p++){
											if(Integer.parseInt(tokens[p])==i)
												strBuffer.append("<script>assingListItemValue("+tokens[p]+");</script>");
										}
									}
									
									
									i++;
								}

							
            _bw.write(_wl_block18Bytes, _wl_block18);

				}
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(start));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(end));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ind_chart_line_num));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(totalselected));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(permanent_deciduous_flag));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(site_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(area_param));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(thrng_nos_ref));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(baseline_chart_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(date_diff_flag));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.LinkDiagnosis.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DefaultSelect.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
