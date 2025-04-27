package jsp_servlet._ebt._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __managelisspecimenimageuploadlinks extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/ManageLISSpecimenImageUploadLinks.jsp", 1709115156681L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n\t<head>\t\n\t\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<link rel=\'StyleSheet\' href=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="eCommon/html/IeStyle.css\' type=\'text/css\' />\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\' />\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script src=\"../../eBT/js/ManageLISSpecimenImage.js\" language=\"javascript\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t</head>\n\t\t<body>\n\t\t\t<form name=\'uploadLinkForm\' id=\'uploadLinkForm\'>\n\t\t\t<table border=\'1\' width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'CAGROUP\' colspan=\'6\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\t\t\t\t\t\n\t\t\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\t\t\t\t\t\n\t\t\t\t\t<th align=\'left\' colspan=\'3\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t</table>\n\t\t\t<input type=\'hidden\' name=\'p_resp_id\' id=\'p_resp_id\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

		//System.out.println ("eBT ManageLISImageSpecimen  2 ");
		Connection con = null;
		PreparedStatement pstmtImgView = null;
		PreparedStatement pstmtImgViewOthers = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ResultSet resImgView = null;

		String test = "";
		String testCode = "";
		String sampleId = "";
		String anatomy = "";
		String anatomyCode = "";
		String tissueDesc = "";
		String anatomyInd = "";
		String section_ind = "";
		int count = 0;
		int recCount = 0;
		String classValue = "QRYEVEN";

	
		String accessionNum = request.getParameter("Accessionnum") == null ? "" : request.getParameter("Accessionnum");
		String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
		String p_resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
		String colSpan = "1";
		String applServerURL = "";

			//System.out.println ("eBT ManageLISImageSpecimen 3  "+accessionNum);

		if(facilityId.equals(""))
			facilityId = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");

		//String sqlSecInd = "SELECT section_ind, NVL(use_sample_anatomy_ind, '!!') anatomy_ind FROM RL_SECTION_CODE WHERE section_code = ?";
		String sqlSecInd = "SELECT section_ind, NVL(use_sample_anatomy_ind, '!!') anatomy_ind FROM RL_SECTION_CODE_LANG_VW WHERE section_code = ? AND LANGUAGE_ID = ?";

		//String sql = "SELECT A.specimen_no, A.test_code, NULL sample_id, A.anatomy_site_code, A.tissue_desc_code, 		B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SPECIMEN_ANATOMY_DTLS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ?   AND NVL(?, '!!') = 'AT'  AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND A.tissue_desc_code = D.tissue_desc_code(+) UNION SELECT A.specimen_no, A.test_code, A.sample_id, A.anatomy_site_code, A.tissue_desc_code, B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SAMPLE_DETAILS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND NVL(?, '!!') = 'SA' AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND A.tissue_desc_code = D.tissue_desc_code(+) ORDER BY 3, 4 ";

		String sql = "SELECT A.specimen_no, A.test_code, NULL sample_id, A.anatomy_site_code, A.tissue_desc_code, 		B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SPECIMEN_ANATOMY_DTLS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ?   AND NVL(?, '!!') = 'AT'  AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code  AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+) UNION SELECT A.specimen_no, A.test_code, A.sample_id, A.anatomy_site_code, A.tissue_desc_code, B.short_desc test_desc, C.short_desc anatomy_desc, D.short_desc tissue_desc FROM RL_SAMPLE_DETAILS A, RL_TEST_CODE B, RL_ANATOMY_SITE_CODE_LANG_VW C, RL_TISSUE_DESC_TYPE D WHERE A.specimen_no = ? AND NVL(?, '!!') = 'SA' AND A.test_code = B.test_code AND A.anatomy_site_code = C.anatomy_site_code AND C.LANGUAGE_ID = ? AND A.tissue_desc_code = D.tissue_desc_code(+) ORDER BY 3, 4";

		String sqlO = "select a.specimen_no, a.test_code, b.short_desc test_desc from rl_request_detail a, rl_test_code_lang_vw b where a.specimen_no = ? and a.operating_facility_id = ? and a.test_code = b.test_code and b.language_id = ? ";

		try
		{
				//System.out.println("eBT ManageLISImageSpecimen 4"); 
			if(!p_resp_id.equals("RL_MANAGER"))
				con = ConnectionManager.getConnection(request);
			else if(p_resp_id.equals("RL_MANAGER"))
						con = ConnectionManager.getConnection();
		//System.out.println("eBT ManageLISImageSpecimen 5");

			pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM CA_EXT_INT_PARAM ");
			//System.out.println("eBT ManageLISImageSpecimen 6");

			res = pstmt.executeQuery();
		
			while(res.next())
			{
				applServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
			}

			if(res != null) res.close();
			if(pstmt != null) pstmt.close();

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			String specNum = "";
			String eventCode = "";
			String contrSysEventCode = "";
			String secCode = "";

		//System.out.println( " Accession Num " + accessionNum);
			if(accessionNum.equals(""))
			{
				specNum = request.getParameter("specNum") == null ? "0" : request.getParameter("specNum");
				secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");
			}
			else
			{
				String sqlAccessionNum = "select event_code, CONTR_SYS_EVENT_CODE, SUBSTR (?, (INSTR (?, '#') + 1), ( (INSTR (?, '@') - 1) - INSTR (?, '#'))) spec_num from cr_encounter_detail where ACCESSION_NUM = ? ";
				String sqlTestCode = "select test_code from rl_test_code where ORDER_CATALOG_CODE = ? ";

				pstmt = con.prepareStatement(sqlAccessionNum);
				pstmt.setString(1,accessionNum);
				pstmt.setString(2,accessionNum);
				pstmt.setString(3,accessionNum);
				pstmt.setString(4,accessionNum);
				pstmt.setString(5,accessionNum);
				res = pstmt.executeQuery();

				while(res.next())
				{
					eventCode = res.getString("event_code") == null ? "" : res.getString("event_code");
					contrSysEventCode = res.getString("CONTR_SYS_EVENT_CODE") == null ? "" : res.getString("CONTR_SYS_EVENT_CODE");
					specNum = res.getString("spec_num") == null ? "" : res.getString("spec_num");
				}

				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
//System.out.println("eBT ManageLISImageSpecimen 7");
				pstmt = con.prepareStatement(sqlTestCode);
				pstmt.setString(1,eventCode);
				res = pstmt.executeQuery();

				while(res.next())
				{
					test = res.getString("test_code") == null ? "" : res.getString("test_code");
				}

				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
//System.out.println("eBT ManageLISImageSpecimen 8");
				if(!accessionNum.equals(""))
				{	
					pstmt = con.prepareStatement("select section_code from rl_test_code where TEST_CODE = ?");
					pstmt.setString(1,contrSysEventCode);
					res = pstmt.executeQuery();

					while(res.next())
					{
						secCode = res.getString("section_code") == null ? "" : res.getString("section_code");
					}

					if(res != null) res.close();
					if(pstmt != null) pstmt.close();
				}
			}
//System.out.println("eBT ManageLISImageSpecimen 9");
			if(p_resp_id.equals("RL_MANAGER"))
			{
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(applServerURL));
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
			else
			{
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			pstmt = con.prepareStatement(sqlSecInd);
			pstmt.setString(1,secCode);
			pstmt.setString(2,locale);
			res = pstmt.executeQuery();
			while(res.next())
			{
				anatomyInd = res.getString("anatomy_ind") == null ? "" : res.getString("anatomy_ind");
				section_ind = res.getString("section_ind") == null ? "" : res.getString("section_ind");
			}


			if(res != null) res.close();
			if(pstmt != null) pstmt.close();

//System.out.println("eBT ManageLISImageSpecimen 10");
			
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(specNum));
            _bw.write(_wl_block14Bytes, _wl_block14);

				if (section_ind.equals("HI") || section_ind.equals("CY")) //Sanjay
				{					
				
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

				}
				else 
				{
					anatomyInd = "";//Sanjay
					sampleId = "";//Sanjay
				
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

				}
				
            _bw.write(_wl_block21Bytes, _wl_block21);
			
			
			

			pstmtImgView = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ? and SAMPLE_ID = ? and ANATOMY_SITE_CODE = ?");

			pstmtImgViewOthers = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ? and SAMPLE_ID is null and ANATOMY_SITE_CODE is null");
//System.out.println("eBT ManageLISImageSpecimen 11");			
			if (section_ind.equals("HI") || section_ind.equals("CY")) //Sanjay
			{
				pstmt = con.prepareStatement(sql);
				//System.out.println( "sql - " + sql + " Spec Num " + specNum + " anatomyInd  " + anatomyInd);
				//System.out.println( "sql - " + sql + " Spec Num " + specNum + " anatomyInd  " + anatomyInd);//Sanjay
				pstmt.setString(1,specNum);
				pstmt.setString(2,anatomyInd);
				pstmt.setString(3,locale);
				pstmt.setString(4,specNum);
				pstmt.setString(5,anatomyInd);
				pstmt.setString(6,locale);
			}
			else {
				pstmt = con.prepareStatement(sqlO);
				//System.out.println( "sql - " + sql + " Spec Num " + specNum + " anatomyInd  " + anatomyInd);
				//System.out.println( "sql - " + sql + " Spec Num " + specNum + " anatomyInd  " + anatomyInd);//Sanjay
				pstmt.setInt(1,Integer.parseInt(specNum));
				pstmt.setString(2,facilityId);
				pstmt.setString(3,locale);				
			}

			res = pstmt.executeQuery();
//System.out.println("eBT ManageLISImageSpecimen 12");
			while(res.next())
			{
				if (section_ind.equals("HI") || section_ind.equals("CY")) //Sanjay
				{
					test = res.getString("test_desc") == null ? "" : res.getString("test_desc");
					testCode = res.getString("test_code") == null ? "" : res.getString("test_code");
					anatomy = res.getString("anatomy_desc") == null ? "" : res.getString("anatomy_desc");
					anatomyCode = res.getString("anatomy_site_code") == null ? "" : res.getString("anatomy_site_code");
					//out.println("Sample ID:"+res.getString("sample_id"));
					sampleId = res.getString("sample_id") == null ? "" : res.getString("sample_id");
					tissueDesc = res.getString("tissue_desc") == null ? "&nbsp;" : res.getString("tissue_desc");

					if(count % 2 == 0) classValue = "QRYEVEN";
					else classValue = "QRYODD";	
					
					if(p_resp_id.equals("RL_MANAGER"))
					{
						colSpan = "2";
					}
					else
					{
						colSpan = "1";				
					}
					
					out.println("<td class='"+classValue+"'>"+test+"</td>");
					out.println("<td class='"+classValue+"'>"+sampleId+"</td>");
					out.println("<td class='"+classValue+"'>"+anatomy+"</td>");
					out.println("<td class='"+classValue+"' colspan='"+colSpan+"'>"+tissueDesc+"</td>");
					
				} else
				{
					if(count % 2 == 0) classValue = "QRYEVEN";
					else classValue = "QRYODD";	
					
					if(p_resp_id.equals("RL_MANAGER"))
					{
						colSpan = "2";
					}
					else
					{
						colSpan = "1";				
					}

					test = res.getString("test_desc") == null ? "" : res.getString("test_desc");
					testCode = res.getString("test_code") == null ? "" : res.getString("test_code");					
					out.println("<td class='"+classValue+"'>"+test+"</td>");				
				}
				if(!p_resp_id.equals("RL_MANAGER") && accessionNum.equals(""))
				{
					out.println("<td class='"+classValue+"'><a href=\"javascript:showUploadPage('"+specNum+"','"+testCode+"','"+sampleId+"','"+anatomyCode+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UploadFile.label","common_labels")+"</a></td>");
				}
//System.out.println("eBT ManageLISImageSpecimen 13");
				if (section_ind.equals("HI") || section_ind.equals("CY")) //Sanjay
				{
					pstmtImgView.setString(1,facilityId);
					pstmtImgView.setString(2,specNum);
					pstmtImgView.setString(3,testCode);
					pstmtImgView.setString(4,sampleId);
					pstmtImgView.setString(5,anatomyCode);
					resImgView = pstmtImgView.executeQuery();
				}
				else
				{
					pstmtImgViewOthers.setString(1,facilityId);
					pstmtImgViewOthers.setString(2,specNum);
					pstmtImgViewOthers.setString(3,testCode);
					resImgView = pstmtImgViewOthers.executeQuery();
				}				
				while(resImgView.next())
				{
					recCount = resImgView.getInt(1);
				}

				if(resImgView != null) resImgView.close();				
//System.out.println("eBT ManageLISImageSpecimen 14");				
				if(recCount > 0)
				{
					out.println("<td class='"+classValue+"'><a href=\"javascript:viewUploadedImg('"+specNum+"','"+testCode+"','"+sampleId+"','"+anatomyCode+"','"+recCount+"','"+facilityId+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a></td>");
				}
				else
				{
					out.println("<td class='"+classValue+"'>&nbsp;</td>");
				}
				out.println("</tr>");
				count++;
			}
//System.out.println("eBT ManageLISImageSpecimen 15");
			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
			if(pstmtImgView != null) pstmtImgView.close();
		}
		catch(Exception e)
		{
			//out.println("Exception in try of ManageLISSpecimenImageUploadLinks.jsp --"+e.toString());
			//System.out.println("Exception in try of ManageLISSpecimenImageUploadLinks.jsp --"+e.toString());
			e.printStackTrace(System.err);
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_resp_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.SpecimenNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Test.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.SampleID.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.Anatomy.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.TissueDescription.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Test.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UploadFile.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
