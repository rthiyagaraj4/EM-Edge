package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.net.*;
import java.util.*;
import java.lang.String;
import java.util.ArrayList;
import eXH.XHDBAdapter;
import eXH.*;

public final class __xhdisplayecbenefitstable extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/XHDisplayECBenefitsTable.jsp", 1741246409068L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n\r\n</head>\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\r\n<body>\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\r\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=left >\r\n<tr>\r\n<td class=\'label\' colspan=\"13\">Table Of Benefits (TOB)</td>\r\n</tr>\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="<tr>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>BENEFIT NAME</td>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<td  class=\'COLUMNHEADER\' width=\'25%\'>BENEFIT DESC</td>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>TERM CODE</td>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>BENEFIT ALLOWED</td>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>BENEFIT USED</td>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>CATEGORY CODE</td>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>CATEGORY DESC</td>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>NETWORK CODE</td>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>NETWORK DESC</td>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>UNIT CODE</td>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>UNIT DESC</td>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>TERM DESC</td>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<td class=\'COLUMNHEADER\'  width=\'25%\'>REQUEST DATE</td>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</tr>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<td  align=\"left\" ><font size=1 >&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</font></td>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<td nowrap align=\"left\" ><font size=1 >&nbsp;</font></td>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<td align=\"left\" ><font size=1 >&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<td align=\"left\" ><font size=1 >&nbsp;</font></td>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="<td  align=\"left\" ><font size=1 >&nbsp;</font></td>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<td  class=\"COLUMN\" align=\"left\" ><font size=1 >&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</tr>\r\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\r\n</table>\r\n\r\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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

/*
Sr No        Version            Incident          SCF/CRF             		Developer Name
1			 V240221		 	 56225 			NMC-JD-CRF-0102.9-US001		Kranthi Kumar
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
 
    String l_response_ref_id = request.getParameter("response_ref_id");
    String l_operating_facility_id = request.getParameter("operating_facility_id");
    String l_patient_id = request.getParameter("patient_id");
    String l_episode_type = request.getParameter("episode_type");
    String l_episode_id = request.getParameter("episode_id");
    String l_visit_id = request.getParameter("visit_id");
    boolean REQUEST_DATE = false,BENEFIT_NAME = false,BENEFIT_DESC = false,CATEGORY_CODE = false,
    		CATEGORY_DESC = false,NETWORK_CODE = false,NETWORK_DESC = false,UNIT_CODE = false,
    		UNIT_DESC = false,TERM_CODE = false,TERM_DESC = false,BENEFIT_ALLOWED = false,
    		BENEFIT_USED = false;
    String patientId = "", response_ref_id = "", request_date = "", seq_no = "", line_no = "", benefit_name = "", benefit_desc = "",
        category_code = "", category_desc = "", network_code = "", network_desc = "", unit_code = "", unit_desc = "", term_code = "",
        term_desc = "", benefit_allowed = "", benefit_used = "";
    
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    Connection dbConn = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    PreparedStatement pstmt1 = null;
    PreparedStatement pstmt2 = null;
    try {
        dbConn = ConnectionManager.getConnection();
        System.out.println("l_response_ref_id ::: " + l_response_ref_id +" l_patient_id ::: "+l_patient_id);
        if (l_response_ref_id != null && l_response_ref_id != "" && !l_response_ref_id.equals("null")) {
        	 System.out.println("first screen");
            String query = "SELECT * FROM bl_table_of_benefit WHERE PATIENT_ID = ? AND RESPONSE_REF_ID = ?";
            pstmt = dbConn.prepareStatement(query);
            pstmt.setString(1, l_patient_id);
            pstmt.setString(2, l_response_ref_id);
            rs = pstmt.executeQuery();
        } else {
            System.out.println(" second screen");
            String query1 = "SELECT A.OPERATING_FACILITY_ID, A.EPISODE_TYPE, A.EPISODE_ID, A.VISIT_ID,A.PATIENT_ID, A.ACCT_SEQ_NO, A.INT_ELGIBILITY_CODE " +
                " FROM BL_ENCOUNTER_PAYER_PRIORITY A " +
                "WHERE A.OPERATING_FACILITY_ID = ? " +
                " AND A.PATIENT_ID = ? " +
                " AND A.EPISODE_TYPE = ?" +
                " AND A.EPISODE_ID = ?" +
                " AND A.VISIT_ID = ?" +
                " AND A.INT_ELGIBILITY_CODE IS NOT NULL " +
                " AND ACCT_SEQ_NO IN ( " +
                "      SELECT MAX (ACCT_SEQ_NO) " +
                "   FROM BL_ENCOUNTER_PAYER_PRIORITY B " +
                "  WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID " +
                "   AND A.PATIENT_ID = B.PATIENT_ID " +
                "   AND A.EPISODE_TYPE = B.EPISODE_TYPE " +
                "   AND A.EPISODE_ID = B.EPISODE_ID " +
                "  AND A.VISIT_ID = B.VISIT_ID " +
                " AND INT_ELGIBILITY_CODE IS NOT NULL)";
            pstmt1 = dbConn.prepareStatement(query1);
            pstmt1.setString(1, l_operating_facility_id);
            pstmt1.setString(2, l_patient_id);
            pstmt1.setString(3, l_episode_type);
            pstmt1.setString(4, l_episode_id);
            pstmt1.setString(5, l_visit_id);
            rs1 = pstmt1.executeQuery();
            String int_elgibility_code = "";
            String patient_id = "";
            while (rs1.next()) {
                int_elgibility_code = rs1.getString("INT_ELGIBILITY_CODE");
                patient_id = rs1.getString("PATIENT_ID");
            }
            if (int_elgibility_code != "" && patient_id != "") {
            	System.out.println(int_elgibility_code+"  "+patient_id);
                String query2 = "SELECT * FROM bl_table_of_benefit WHERE PATIENT_ID = ? AND RESPONSE_REF_ID = ?";
                pstmt = dbConn.prepareStatement(query2);
                System.out.println("Executing second query...");
                pstmt.setString(1, patient_id);
                pstmt.setString(2, int_elgibility_code);
                rs = pstmt.executeQuery();
               

            }
        }
      
        if (rs != null && rs.isBeforeFirst()) {
        	 System.out.println("ResultSet is not empty.");
			
            _bw.write(_wl_block4Bytes, _wl_block4);

            while (rs.next()) {
            	
            	//patientId = rs.getString("PATIENT_ID");
				//response_ref_id = rs.getString("RESPONSE_REF_ID");
				request_date = rs.getString("REQUEST_DATE");
				//seq_no = rs.getString("SEQUENCE_NO");
				//line_no = rs.getString("LINE_NO");
				benefit_name = rs.getString("BENEFIT_NAME");
				benefit_desc = rs.getString("BENEFIT_DESC");
				category_code = rs.getString("CATEGORY_CODE");
				category_desc = rs.getString("CATEGORY_DESC");
				network_code = rs.getString("NETWORK_CODE");
				network_desc = rs.getString("NETWORK_DESC");
				unit_code = rs.getString("UNIT_CODE");
				unit_desc = rs.getString("UNIT_DESC");
				term_code = rs.getString("TERM_CODE");
				term_desc = rs.getString("TERM_DESC");
				benefit_allowed = rs.getString("BENEFIT_ALLOWED");
				benefit_used = rs.getString("BENEFIT_USED");
            	
				HashMap<String,String> obj = new HashMap<String,String>();
				obj.put("REQUEST_DATE",request_date);
				obj.put("BENEFIT_NAME",benefit_name);
				obj.put("BENEFIT_DESC",benefit_desc);
				obj.put("CATEGORY_CODE",category_code);
				obj.put("CATEGORY_DESC",category_desc);
				obj.put("NETWORK_CODE",network_code);
				obj.put("NETWORK_DESC",network_desc);
				obj.put("UNIT_CODE",unit_code);
				obj.put("UNIT_DESC",unit_desc);
				obj.put("TERM_CODE",term_code);
				obj.put("TERM_DESC",term_desc);
				obj.put("BENEFIT_ALLOWED",benefit_allowed);
				obj.put("BENEFIT_USED",benefit_used);
				list.add(obj);
				if(request_date!=null)REQUEST_DATE=true;
				if(benefit_name!=null)BENEFIT_NAME=true;
				if(benefit_desc!=null)BENEFIT_DESC=true;
				if(category_code!=null)CATEGORY_CODE=true;
				if(category_desc!=null)CATEGORY_DESC=true;
				if(network_code!=null)NETWORK_CODE=true;
				if(network_desc!=null)NETWORK_DESC=true;
				if(unit_code!=null)UNIT_CODE=true;
				if(unit_desc!=null)UNIT_DESC=true;
				if(term_code!=null)TERM_CODE=true;
				if(term_desc!=null)TERM_DESC=true;
				if(benefit_allowed!=null)BENEFIT_ALLOWED=true;
				if(benefit_used!=null)BENEFIT_USED=true;
            }
			if(list.size()>0){
            
            _bw.write(_wl_block5Bytes, _wl_block5);

            
            if (BENEFIT_NAME) {
				
            _bw.write(_wl_block6Bytes, _wl_block6);

			}
			if (BENEFIT_DESC) {
				
            _bw.write(_wl_block7Bytes, _wl_block7);

			}
            if (TERM_CODE) {
				
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
            if (BENEFIT_ALLOWED) {
				
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
			if (BENEFIT_USED) {
				
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
			
			if (CATEGORY_CODE) {
				
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			if (CATEGORY_DESC) {
				
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
			if (NETWORK_CODE) {
				
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
			if (NETWORK_DESC) {
				
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
			if (UNIT_CODE) {
				
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
			if (UNIT_DESC) {
				
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
			
			if (TERM_DESC) {
				
            _bw.write(_wl_block17Bytes, _wl_block17);

			}
			
			if (REQUEST_DATE) {
				
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			
            _bw.write(_wl_block19Bytes, _wl_block19);

			for(HashMap map: list){
				
            _bw.write(_wl_block5Bytes, _wl_block5);

				if (map.get("BENEFIT_NAME") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("BENEFIT_NAME") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(BENEFIT_NAME){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				if (map.get("BENEFIT_DESC") != null) {
					
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( map.get("BENEFIT_DESC") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(BENEFIT_DESC){
					
            _bw.write(_wl_block24Bytes, _wl_block24);

				}
				if (map.get("TERM_CODE") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("TERM_CODE") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(TERM_CODE){
					
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
				if (map.get("BENEFIT_ALLOWED") != null) {
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( map.get("BENEFIT_ALLOWED") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(BENEFIT_ALLOWED){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				if (map.get("BENEFIT_USED") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("BENEFIT_USED") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(BENEFIT_USED){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				
				if (map.get("CATEGORY_CODE") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("CATEGORY_CODE") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(CATEGORY_CODE){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				if (map.get("CATEGORY_DESC") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("CATEGORY_DESC") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(CATEGORY_DESC){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				if (map.get("NETWORK_CODE") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("NETWORK_CODE") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(NETWORK_CODE){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				if (map.get("NETWORK_DESC") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("NETWORK_DESC") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(NETWORK_DESC){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				if (map.get("UNIT_CODE") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("UNIT_CODE") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(UNIT_CODE){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				if (map.get("UNIT_DESC") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("UNIT_DESC") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(UNIT_DESC){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				
				if (map.get("TERM_DESC") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("TERM_DESC") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(TERM_DESC){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				
				if (map.get("REQUEST_DATE") != null) {
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( map.get("REQUEST_DATE") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else if(REQUEST_DATE){
					
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				
            _bw.write(_wl_block27Bytes, _wl_block27);
}} 
            _bw.write(_wl_block28Bytes, _wl_block28);

        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources
        try { if (rs != null) rs.close(); } catch (Exception e) { /* Ignored */ }
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) { /* Ignored */ }
        try { if (dbConn != null) dbConn.close(); } catch (Exception e) { /* Ignored */ }
        try { if (rs1 != null) rs1.close(); } catch (Exception e) { /* Ignored */ }
        try { if (pstmt1 != null) pstmt1.close(); } catch (Exception e) { /* Ignored */ }
        try { if (rs2 != null) rs2.close(); } catch (Exception e) { /* Ignored */ }
        try { if (pstmt2 != null) pstmt2.close(); } catch (Exception e) { /* Ignored */ }
    }

            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
