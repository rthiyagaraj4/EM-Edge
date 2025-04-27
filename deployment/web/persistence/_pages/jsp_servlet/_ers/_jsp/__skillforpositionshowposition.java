package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eRS.*;

public final class __skillforpositionshowposition extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/SkillForPositionShowPosition.jsp", 1709121656933L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../js/SkillForPosition.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<body>\n\t<form name=\"form_positionList\" id=\"form_positionList\" action=\'../../servlet/eRS.SkillForPositionServlet\' method=\'POST\' target=\'messageFrame\'>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\"100%\" >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<tr>\n\t\t\t <td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' width=\'15%\'><font size=2>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<input type=\"hidden\" name=\"role_type";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" id=\"role_type";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" >\n\t\t\t<input type=\"hidden\" name=\"role_type_desc";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" id=\"role_type_desc";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" > </td>\t\n\t\t\t <td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' width=\'30%\'><font size=2>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<input type=\"hidden\" name=\"staff_type";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"staff_type";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t\t\t<input type=\"hidden\" name=\"staff_type_desc";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"staff_type_desc";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ></td>\n\t\t\t <td  Align=\'left\' class =\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\'35%\'><font size=2>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<input type=\"hidden\" name=\"position_code";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"position_code";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t\t\t<input type=\"hidden\" name=\"position_desc";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"position_desc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >  </td>\n\t\t\t<td  Align=\'center\' class =\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'10%\'><font size=2>\n\t\t\t<input type=checkbox name=\'mandatory_yn";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'mandatory_yn";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'   value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onclick=\'oncheck(this)\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">\n\t\t\t<input type=\"hidden\" name=\"db_action";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"db_action";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" ></td>\n\t\t\t<td class =\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' align=\'center\' width=\'15%\'>\n\t\t\t<input type=checkbox name=\"select";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"select";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"value=\"\" onclick=\'oncheck(this)\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =">   </td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t</table>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n<input type=\"hidden\" name=\"skill_code\" id=\"skill_code\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n<input type=\"hidden\" name=\"skill_desc\" id=\"skill_desc\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n<input type=\"hidden\" name=\"formName\" id=\"formName\" value=\"form_positionList\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

	String mode	   = request.getParameter( "mode" )==null?"":request.getParameter( "mode" );
	String skill_code			= request.getParameter("skill_code")==null?"":request.getParameter("skill_code");
	String skill_desc	 =request.getParameter("skill_desc")==null?"":request.getParameter("skill_desc");
	String staff_type	 =request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String role_type	 =request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String position_code="";
	String position_desc="";
	String role_type_desc="";
	String staff_type_desc="";
	String mandatory_yn="";
	String db_action="";
	ArrayList PositionData = new ArrayList();
	String[] record				= null;
	String slClassValue="";
	String skill_pos="";
	Connection con 	      = null;
	PreparedStatement pstmt	      = null;
	ResultSet rs		      = null;
	int totalRecords=0;
	staff_type=staff_type.equals("")?"%":staff_type;
	role_type=role_type.equals("")?"%":role_type;

	try{
		con = ConnectionManager.getConnection(request);

		skill_pos="SELECT A.SKILL_CODE SKILL_CODE, A.POSITION_CODE POSITION_CODE, B.POSITION_DESC 		POSITION_DESC, B.ROLE_TYPE ROLE_TYPE, DECODE(B.ROLE_TYPE,'P','Practitioner','O','Other Staff') ROLE_TYPE_DESC, B.STAFF_TYPE STAFF_TYPE, STAFF_TYPE_DESC, A.MANDATORY_YN MANDATORY_YN, 'U' DB_ACTION, A.EFF_STATUS ENABLED FROM RS_SKILL_FOR_POSITION A, AM_POSITION_VW B WHERE A.SKILL_CODE=? AND A.POSITION_CODE = B.POSITION_CODE AND UPPER(B.ROLE_TYPE) LIKE UPPER(?) AND UPPER(B.STAFF_TYPE) LIKE UPPER (?) UNION ALL SELECT ? SKILL_CODE, POSITION_CODE, POSITION_DESC, ROLE_TYPE, DECODE(ROLE_TYPE,'P','Practitioner','O','Other Staff') OLE_TYPE_DESC,	STAFF_TYPE, STAFF_TYPE_DESC, 'N' MANDATORY_YN, 'I' DB_ACTION, 'E' ENABLED FROM AM_POSITION_VW WHERE EFF_STATUS = 'E' AND POSITION_CODE NOT IN  (SELECT POSITION_CODE FROM RS_SKILL_FOR_POSITION  WHERE SKILL_CODE =?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) AND UPPER(STAFF_TYPE)LIKE (?) ORDER BY ROLE_TYPE_DESC, STAFF_TYPE_DESC,POSITION_DESC";
		
		pstmt = con.prepareStatement(skill_pos);
		pstmt.setString(1,skill_code);
		pstmt.setString(2,role_type);
		pstmt.setString(3,staff_type);
		pstmt.setString(4,skill_code);
		pstmt.setString(5,skill_code);
		pstmt.setString(6,role_type);
		pstmt.setString(7,staff_type);
		rs = pstmt.executeQuery() ;

		while (rs != null && rs.next()) {
			record = new String[14];
	
			record[0] = rs.getString( "skill_code");
			record[1] = rs.getString( "position_code");
			record[2] = rs.getString( "position_desc");
			record[3] = rs.getString( "role_type");
			record[4] = rs.getString( "role_type_desc");
			record[5] = rs.getString( "staff_type");
			record[6] = rs.getString( "staff_type_desc");
			record[7] = rs.getString( "mandatory_yn");
			record[8] = rs.getString( "db_action");
			record[9] = rs.getString( "enabled");

			PositionData.add(record) ;
		}
		totalRecords=PositionData.size();
		
		if( totalRecords== 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA')); location.href='../../eCommon/html/blank.html' </script>");
		}

            _bw.write(_wl_block6Bytes, _wl_block6);

		String role_desc="";
		String staff_desc="";
		for( int i=0 ; i<totalRecords ; i++ ) {
		if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}
		String[] record1 = (String[])PositionData.get(i);
		skill_code=record1[0];
		position_code=record1[1];
		position_desc=record1[2];
		role_type=record1[3];
		role_type_desc=record1[4];
		staff_type=record1[5];
		staff_type_desc=record1[6];
		mandatory_yn=record1[7];
		db_action=record1[8];
		String dbcheck="";
		String mandatory_ck="";
		String enable=record1[9]==null?"":record1[9];

		if((db_action.equalsIgnoreCase("U"))&&(enable.equalsIgnoreCase("E")))
			dbcheck="checked";
		else
			dbcheck="";

		if(mandatory_yn.equalsIgnoreCase("Y"))
			mandatory_ck="checked";
		else
			mandatory_ck="";
		if(role_type_desc.equals(role_desc))
			role_desc="";
		else 
			role_desc=role_type_desc;
	
			staff_desc=staff_type_desc;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(role_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(role_type_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(staff_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(staff_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(staff_type_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(mandatory_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mandatory_ck));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(db_action));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dbcheck));
            _bw.write(_wl_block37Bytes, _wl_block37);

			role_desc=role_type_desc;
			staff_desc=staff_type_desc;
	
		}

            _bw.write(_wl_block38Bytes, _wl_block38);

		}catch(Exception e){
			e.printStackTrace() ;
			throw e ;
		}
		finally{
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
			ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(skill_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(skill_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( totalRecords));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block43Bytes, _wl_block43);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
