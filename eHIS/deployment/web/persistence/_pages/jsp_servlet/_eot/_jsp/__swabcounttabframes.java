package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.CommonBean;
import java.util.*;
import com.ehis.util.*;

public final class __swabcounttabframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SwabCountTabFrames.jsp", 1709120398000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<frameset rows=\"80,0,*\"> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<frameset rows=\"20%,0%,*,8%\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<frame name=\"f_swab_count_confirm_item\" frameborder=\"0\" scrolling=\"yes\" noresize src=\"../../eOT/jsp/SwabCountItemConfirm.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">  \n\t<frame name=\"f_swab_count_hdr\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eOT/jsp/SwabCountHeader.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">  \n\t<frame name=\"f_swab_count_dtls\" frameborder=\"0\"  noresize src=\"../../eOT/jsp/SwabCount.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"> \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<frame name=\"f_swab_count_record\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eOT/jsp/SwabCountRecordFrame.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</frameset>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<frameset rows=\"*\"> \n\t<frame name=\"f_verify_details\" frameborder=\"0\" scrolling=\"YES\" noresize src=\"../../eOT/jsp/SwabCountVerify.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">  \n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<frameset rows=\"*,25\"> \n\t<frame name=\"f_verify_details\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eOT/jsp/SwabCountVerify.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">  \n\t\t<frame name=\"f_swab_count_record\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eOT/jsp/SwabCountRecordFrame.jsp?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\n</frameset>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<FRAMESET rows=\'*,25\' border=\'0\'>\n\t\t<!--<FRAMESET rows=\'0,0\' border=\'0\'>\n\t\t\t<FRAME NAME=\'ObjectCollect\' SRC=\'../../eOT/jsp/NursingObjectCollect.jsp?";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'  scrolling=\'no\' noresize=\'no\'>\n\t\t\t\n\n\t\t\t<FRAME name=\"tab_frame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html?";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">    \t    \n\t\t</FRAMESET> -->\n\t\t<FRAME NAME=\'RecordFrame\' SRC=\'../../eOT/jsp/SwabCountPersonnelFrames.jsp?";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'  scrolling=\'no\' noresize=\'no\'></FRAME> \n\t<frame name=\"f_swab_count_record\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eOT/jsp/SwabCountRecordFrame.jsp?";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t</FRAMESET>\n\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n<input type=\'hidden\' name=\'locale\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input tpe=\"hidden\" name=\"allwdSwabCntsVal\" id=\"allwdSwabCntsVal\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\n<script>\n\t\tsetTimeout(\"assignRepId()\", 1000);\n\t\tfunction assignRepId()\n\t\t{\n\t\t\tvar locale = \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\n\t\t\tvar allwdSwabCntsVal = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\n\t\t\tvar qry_mode = \'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\n\t\t\tvar pReportId = \'\';\n\t\t\tif(allwdSwabCntsVal == 3)\n\t\t\t\tpReportId = \'OTRSWCNT\';\n\t\t\telse if(allwdSwabCntsVal > 3)\n\t\t\t\tpReportId = \'OTRSBSWC\';\n\t\t\tif(qry_mode != \'\') //Surgery History\n\t\t\t{\n\t\t\t\tif(parent.frames[0].document.forms[0] == null)\n\t\t\t\t{\n\t\t\t\t\tassignRepId();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[0].document.forms[0].p_report_id.value = pReportId;\n\t\t\t\t\tparent.frames[0].document.forms[0].P_NO_OF_SWAB_COUNT.value = allwdSwabCntsVal;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse if(qry_mode == \'\') // Swabcount Form from menu\n\t\t\t{\n\t\t\t\tif(parent.frames[1].document.forms[0] == null)\n\t\t\t\t{\n\t\t\t\t\tassignRepId();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].p_report_id.value = pReportId;\n\t\t\t\t\tparent.frames[1].document.forms[0].P_NO_OF_SWAB_COUNT.value = allwdSwabCntsVal;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n</script>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
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

	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultset =null;
	String params = request.getQueryString();
	String tab_name = request.getParameter("swab_tab_name") ;
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num")) ;
	String qry_mode = CommonBean.checkForNull(request.getParameter("qry_mode")) ;
	String facility_id = CommonBean.checkForNull((String) session.getValue("facility_id"));
	String params1 = "";
	String first_cnt_cmpl_yn = "N", add_during_op_cmpl_yn = "N", second_cnt_cmpl_yn = "N", add_aft_clcav_cmpl_yn = "N", final_cnt_cmpl_yn = "N";
	String third_cnt_cmpl_yn = "N", additions_after_3c_cmpl_yn = "N", fourth_cnt_cmpl_yn = "N", additions_after_4c_cmpl_yn = "N", fifth_cnt_cmpl_yn = "N", additions_after_5c_cmpl_yn = "N";
	String reviewedBy = "", practitionerName = "";
	String sql = "";
	String swab_serial_number	= request.getParameter("swab_serial_number");
	swab_serial_number = swab_serial_number == null ? "1" : swab_serial_number;
	swab_serial_number = swab_serial_number.equalsIgnoreCase("null") ? "1" : swab_serial_number;
	System.out.println("========swab_serial_number=============="+swab_serial_number);
	StringBuffer sqlBuffer = new StringBuffer();
	int allwdSwabCntsVal = 0;
	int setIndex = 0;
	if(tab_name==null)
		tab_name="SLATE";
	if(tab_name!=null && tab_name.equals("null"))
		tab_name="SLATE";
	if(tab_name.equals("SWABCOUNT"))
	{
		//sql="SELECT  NVL(FIRST_CNT_CMPL_YN,'N'),NVL(ADDITIONS_DURING_OP_CMPL_YN,'N'), NVL(SECOND_CNT_CMPL_YN,'N'), NVL(ADDITIONS_AFT_CLCAV_CMPL_YN,'N'), NVL(FINAL_CNT_CMPL_YN,'N') FROM OT_OPER_SWAB_INSTR_CNT_HDR WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM=? AND SWAB_SERIAL_NUMBER=?";

		sqlBuffer.append("		SELECT NVL (first_cnt_cmpl_yn, 'N') first_cnt_cmpl_yn,	");
		sqlBuffer.append("		NVL (additions_during_op_cmpl_yn, 'N') additions_during_op_cmpl_yn,	");
		sqlBuffer.append("		NVL (second_cnt_cmpl_yn, 'N') second_cnt_cmpl_yn,	");
		sqlBuffer.append("		NVL (additions_aft_clcav_cmpl_yn, 'N') additions_aft_clcav_cmpl_yn,	");
		sqlBuffer.append("		NVL (third_cnt_cmpl_yn, 'N') third_cnt_cmpl_yn,	");
		sqlBuffer.append("		NVL (additions_after_3c_cmpl_yn, 'N') additions_after_3c_cmpl_yn,	");
		sqlBuffer.append("		NVL (fourth_cnt_cmpl_yn, 'N') fourth_cnt_cmpl_yn,	");
		sqlBuffer.append("		NVL (additions_after_4c_cmpl_yn, 'N') additions_after_4c_cmpl_yn,	");
		sqlBuffer.append("		NVL (fifth_cnt_cmpl_yn, 'N') fifth_cnt_cmpl_yn,	");
		sqlBuffer.append("		NVL (additions_after_5c_cmpl_yn, 'N') additions_after_5c_cmpl_yn,	");
		sqlBuffer.append("		NVL (final_cnt_cmpl_yn, 'N') final_cnt_cmpl_yn,	");

		sqlBuffer.append("		reviewed_by, (SELECT practitioner_name	");
		sqlBuffer.append("		FROM am_practitioner b	");
		sqlBuffer.append("		WHERE b.practitioner_id = reviewed_by) practitioner_name,	");

		sqlBuffer.append("		nvl(no_of_swabs_to_disp, 0) allwd_swab_cnts	");
		sqlBuffer.append("		FROM ot_oper_swab_instr_cnt_hdr	");
		sqlBuffer.append("		WHERE operating_facility_id = ? AND oper_num = ? AND swab_serial_number = ?	");

		try
		{
		connection = ConnectionManager.getConnection(request);
		pstmt=connection.prepareStatement(sqlBuffer.toString());
		pstmt.setString(++setIndex, facility_id);
		pstmt.setString(++setIndex, oper_num);
		pstmt.setString(++setIndex, swab_serial_number);

		resultset = pstmt.executeQuery();
		if(resultset.isBeforeFirst())
		{
			while(resultset!=null && resultset.next())
			{
				first_cnt_cmpl_yn = resultset.getString("first_cnt_cmpl_yn");
				add_during_op_cmpl_yn	= resultset.getString("additions_during_op_cmpl_yn");

				second_cnt_cmpl_yn = resultset.getString("second_cnt_cmpl_yn");
				add_aft_clcav_cmpl_yn = resultset.getString("additions_aft_clcav_cmpl_yn");

				third_cnt_cmpl_yn = resultset.getString("third_cnt_cmpl_yn");
				additions_after_3c_cmpl_yn = resultset.getString("additions_after_3c_cmpl_yn");

				fourth_cnt_cmpl_yn = resultset.getString("fourth_cnt_cmpl_yn");
				additions_after_4c_cmpl_yn = resultset.getString("additions_after_4c_cmpl_yn");

				fifth_cnt_cmpl_yn = resultset.getString("fifth_cnt_cmpl_yn");
				additions_after_5c_cmpl_yn = resultset.getString("additions_after_5c_cmpl_yn");

				final_cnt_cmpl_yn = resultset.getString("final_cnt_cmpl_yn");
				
				reviewedBy = resultset.getString("reviewed_by");
				practitionerName = resultset.getString("practitioner_name");
				if(practitionerName != null && practitionerName.trim().length() > 0)
					practitionerName = java.net.URLEncoder.encode(resultset.getString("practitioner_name"), "UTF-8");

				allwdSwabCntsVal = Integer.parseInt(resultset.getString("allwd_swab_cnts"));
				System.out.println("========allwdSwabCntsVal==iff=====frames======="+allwdSwabCntsVal);
			}
		}
		System.out.println("========allwdSwabCntsVal==brfore iffff=====frames======="+allwdSwabCntsVal);
		if(allwdSwabCntsVal == 0)
		{
			if(resultset!=null)
				resultset.close();
			if(pstmt!=null)
				pstmt.close();
			setIndex = 0;
			sqlBuffer.delete(0, sqlBuffer.length());
			sqlBuffer.append("		SELECT NVL ((SELECT no_of_swabs_to_disp		");
			sqlBuffer.append("		FROM ot_oper_swab_instr_cnt_hdr	");
			sqlBuffer.append("		WHERE oper_num = ? AND swab_serial_number = '1'), NVL (allwd_swab_cnts, '3')) allwd_swab_cnts	");
			sqlBuffer.append("		FROM ot_param_for_facility	");
			sqlBuffer.append("		WHERE operating_facility_id = ?	");

			pstmt = connection.prepareStatement(sqlBuffer.toString());
			pstmt.setString(++setIndex, oper_num);
			pstmt.setString(++setIndex, facility_id);
			resultset = pstmt.executeQuery();
			while(resultset.next())
			{
				allwdSwabCntsVal = Integer.parseInt(resultset.getString("allwd_swab_cnts"));
				System.out.println("========allwdSwabCntsVal==elseeee=frames======="+allwdSwabCntsVal);
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("46: Caught Exception in Swab Count Tab Frames"+e);
	}finally{
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();	
		ConnectionManager.returnConnection(connection,request);
	}

	params = params+
					"&first_cnt_cmpl_yn="+first_cnt_cmpl_yn+
					"&add_during_op_cmpl_yn="+add_during_op_cmpl_yn+
					"&second_cnt_cmpl_yn="+second_cnt_cmpl_yn+
					"&add_aft_clcav_cmpl_yn="+add_aft_clcav_cmpl_yn+

					"&third_cnt_cmpl_yn="+third_cnt_cmpl_yn+
					"&additions_after_3c_cmpl_yn="+additions_after_3c_cmpl_yn+
					"&fourth_cnt_cmpl_yn="+fourth_cnt_cmpl_yn+
					"&additions_after_4c_cmpl_yn="+additions_after_4c_cmpl_yn+
					"&fifth_cnt_cmpl_yn="+fifth_cnt_cmpl_yn+
					"&additions_after_5c_cmpl_yn="+additions_after_5c_cmpl_yn+

					"&final_cnt_cmpl_yn="+final_cnt_cmpl_yn+
					"&reviewedBy="+reviewedBy+
					"&practitionerName="+practitionerName+
					"&swab_serial_number="+swab_serial_number+
					"&record_tab_name=SWABCOUNT"+
					"&qry_mode="+qry_mode+
					"&allwdSwabCntsVal="+allwdSwabCntsVal+
					"#scrollHere";

	params1 = "&oper_num="+oper_num+
	"&swab_serial_number="+swab_serial_number+
	"&facility_id="+facility_id+
	"&record_tab_name=SWABCOUNT"+
	"&qry_mode="+qry_mode+
	"&allwdSwabCntsVal="+allwdSwabCntsVal;

	System.out.println("========params=========="+params);
	System.out.println("========params1=========="+params1);
	if(CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES") )
	{

            _bw.write(_wl_block5Bytes, _wl_block5);

}
else
{

            _bw.write(_wl_block6Bytes, _wl_block6);

}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(params));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(params));
            _bw.write(_wl_block10Bytes, _wl_block10);
 
	if(!CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES") ) 
	{

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}

            _bw.write(_wl_block13Bytes, _wl_block13);

	}
	else if(tab_name.equals("VERIFY"))
	{
	params=params+"&record_tab_name=VERIFY";

            _bw.write(_wl_block14Bytes, _wl_block14);
 if(CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES") ) { 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(params));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(params));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

	}
	else if(tab_name.equals("PERSONNELDTLS"))
	{
	params=params+"&record_tab_name=PERSONNELDTLS";

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(params));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(params));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(params));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(params));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(allwdSwabCntsVal));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(allwdSwabCntsVal));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(qry_mode));
            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
