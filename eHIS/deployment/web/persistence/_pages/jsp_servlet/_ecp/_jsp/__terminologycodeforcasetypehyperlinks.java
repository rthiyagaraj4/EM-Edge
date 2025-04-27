package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __terminologycodeforcasetypehyperlinks extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/TerminologyCodeForCaseTypeHyperLinks.jsp", 1709116626355L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- TerminologyCodeForCaseTypeHyperLinks.jsp -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n      \t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n      \t<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n\t    <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCP/js/TerminologyCodeForCaseType.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body>\n<form name=\"form_hyperlinks\" id=\"form_hyperlinks\">\n\t\n<table  border=\'0\' cellspacing=\'0\' cellpadding=\'0\' align=\'center\' width=\'100%\'>\n\t<tr>\n\t\t<td ><label onClick=\"loadDetail(associated_lbl,\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'Associated\')\" style=\"color:blue;cursor:pointer\" id=\"associated_lbl\"><u><font color=\'maroon\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font></u></label></td>\n\t\t<td><label onClick=\"loadDetail(A_lbl,\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'A\')\" style=\"color:blue;cursor:pointer\" id=\"A_lbl\"><u>A</u></a></td>\n\t\t<td><label onClick=\"loadDetail(B_lbl,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'B\')\" style=\"color:blue;cursor:pointer\" id=\"B_lbl\"><u>B</u></label></td>\n\t\t<td><label onClick=\"loadDetail(C_lbl,\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'C\')\" style=\"color:blue;cursor:pointer\" id=\"C_lbl\"><u>C</u></label></td>\n\t\t<td><label onClick=\"loadDetail(D_lbl,\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'D\')\" style=\"color:blue;cursor:pointer\" id=\"D_lbl\"><u>D</u></label></td>\n\t\t<td><label onClick=\"loadDetail(E_lbl,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'E\')\" style=\"color:blue;cursor:pointer\" id=\"E_lbl\"><u>E</u></label></td>\n\t\t<td><label onClick=\"loadDetail(F_lbl,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'F\')\" style=\"color:blue;cursor:pointer\" id=\"F_lbl\"><u>F</u></label></td>\n\t\t<td><label onClick=\"loadDetail(G_lbl,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'G\')\" style=\"color:blue;cursor:pointer\" id=\"G_lbl\"><u>G</u></label></td>\n\t\t<td><label onClick=\"loadDetail(H_lbl,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'H\')\" style=\"color:blue;cursor:pointer\" id=\"H_lbl\"><u>H</u></label></td>\n\t\t<td><label onClick=\"loadDetail(I_lbl,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'I\')\" style=\"color:blue;cursor:pointer\" id=\"I_lbl\"><u>I</u></label></td>\n\t\t<td><label onClick=\"loadDetail(J_lbl,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'J\')\" style=\"color:blue;cursor:pointer\" id=\"J_lbl\"><u>J</u></label></td>\n\t\t<td><label onClick=\"loadDetail(K_lbl,\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'K\')\" style=\"color:blue;cursor:pointer\" id=\"K_lbl\"><u>K</u></label></td>\n\t\t<td><label onClick=\"loadDetail(L_lbl,\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'L\')\" style=\"color:blue;cursor:pointer\" id=\"L_lbl\"><u>L</u></label></td>\n\t\t<td><label onClick=\"loadDetail(M_lbl,\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'M\')\" style=\"color:blue;cursor:pointer\" id=\"M_lbl\"><u>M</u></label></td>\n\t\t<td><label onClick=\"loadDetail(N_lbl,\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'N\')\" style=\"color:blue;cursor:pointer\" id=\"N_lbl\"><u>N</u></label></td>\n\t\t<td><label onClick=\"loadDetail(O_lbl,\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'O\')\" style=\"color:blue;cursor:pointer\" id=\"O_lbl\"><u>O</u></label></td>\n\t\t<td><label onClick=\"loadDetail(P_lbl,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'P\')\" style=\"color:blue;cursor:pointer\" id=\"P_lbl\"><u>P</u></label></td>\n\t\t<td><label onClick=\"loadDetail(Q_lbl,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'Q\')\" style=\"color:blue;cursor:pointer\" id=\"Q_lbl\"><u>Q</u></label></td>\n\t\t<td><label onClick=\"loadDetail(R_lbl,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'R\')\" style=\"color:blue;cursor:pointer\" id=\"R_lbl\"><u>R</u></label></td>\n\t\t<td id=S_link><label onClick=\"loadDetail(S_lbl,\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'S\')\" style=\"color:blue;cursor:pointer\" id=\"S_lbl\"><u>S</u></label></td>\n\t\t<td><label onClick=\"loadDetail(T_lbl,\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'T\')\" style=\"color:blue;cursor:pointer\" id=\"T_lbl\"><u>T</u></label></td>\n\t\t<td><label onClick=\"loadDetail(U_lbl,\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'U\')\" style=\"color:blue;cursor:pointer\" id=\"U_lbl\"><u>U</u></label></td>\n\t\t<td><label onClick=\"loadDetail(V_lbl,\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'V\')\" style=\"color:blue;cursor:pointer\" id=\"V_lbl\"><u>V</u></label></td>\n\t\t<td><label onClick=\"loadDetail(W_lbl,\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'W\')\" style=\"color:blue;cursor:pointer\" id=\"W_lbl\"><u>W</u></label></td>\n\t\t<td><label onClick=\"loadDetail(X_lbl,\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'X\')\" style=\"color:blue;cursor:pointer\" id=\"X_lbl\"><u>X</u></label></td>\n\t\t<td><label onClick=\"loadDetail(Y_lbl,\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'Y\')\" style=\"color:blue;cursor:pointer\" id=\"Y_lbl\"><u>Y</u></label></td>\n\t\t<td><label onClick=\"loadDetail(Z_lbl,\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\',\'Z\')\" style=\"color:blue;cursor:pointer\" id=\"Z_lbl\"><u>Z</u></label></td>\n\t\t<td></td>\n\t\t<td><label onClick=\"loadDetail(other_lbl,\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'*\')\" style=\"color:blue;cursor:pointer\" id=\"other_lbl\"><u>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</u></label></td>\n\t</tr>\n</table>\n</form>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet TermCodeForCaseType= null;synchronized(session){
                TermCodeForCaseType=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TermCodeForCaseType",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TermCodeForCaseType==null){
                    TermCodeForCaseType=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TermCodeForCaseType",TermCodeForCaseType,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

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

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

//This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		Connection connection = null;
		//Statement stmt = null;
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String case_type_code = request.getParameter("case_type_code");
		String term_set_id = request.getParameter("term_set_id");
		String type = request.getParameter("type");
		String wellness_yn = request.getParameter("wellness_yn");
		String short_desc = request.getParameter("short_desc");
		String search_criteria = request.getParameter("search_criteria");
		String flag = request.getParameter("flag")==null?"":request.getParameter("flag");;
		//out.println(flag);
				
		ArrayList TabList = null;
		String code="";
		String mandatory_yn="";
		String actual_yn="";
		String potential_yn="";
		String select_val="";
	try{
		
		/*if(sessionList.size()>0)
		{
			TabList = (ArrayList)TermCodeForCaseType.getObject(0);
		}else{
			TabList=new ArrayList();
		}*/
		if(flag.equals("true")){
			TermCodeForCaseType.clearAll();
			TabList=new ArrayList();
		}
		//String sqlData="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,a.actual_yn actual_yn,a.potential_yn potential_yn,a.wellness_yn wellness_yn,a.mandatory_yn mandatory_yn,'U' db_action FROM cp_term_code_for_case_type a, mr_term_code b WHERE a.case_type_code='"+case_type_code+"' and b.term_set_id = '"+term_set_id+"' and b.term_set_id = a.term_set_id AND b.term_code = a.term_code and (( '"+type+"' = 'PR' and b.procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and b.diagnosis_yn = 'Y' ))ORDER BY 3";
		String sqlData="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,a.actual_yn actual_yn,a.potential_yn potential_yn,a.wellness_yn wellness_yn,a.mandatory_yn mandatory_yn,'U' db_action FROM cp_term_code_for_case_type a, mr_term_code b WHERE a.case_type_code=? and b.term_set_id = ? and b.term_set_id = a.term_set_id AND b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' ))ORDER BY 3";
		connection = ConnectionManager.getConnection(request);
		//stmt=connection.createStatement();
		pstmt = connection.prepareStatement( sqlData);
		pstmt.setString(1,case_type_code);
		pstmt.setString(2,term_set_id);
		pstmt.setString(3,type);
		pstmt.setString(4,type);
		//rs=stmt.executeQuery(sqlData);
		rs=pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				 code=rs.getString("term_code");
				 mandatory_yn=rs.getString("mandatory_yn");
				 actual_yn=rs.getString("actual_yn");
				 potential_yn=rs.getString("potential_yn");
				wellness_yn=rs.getString("wellness_yn");
				 select_val="N";
				if(actual_yn.equals("Y")){
					if(potential_yn.equals("Y"))
						select_val="B";
					else
						select_val="A";
				}
				else
					if(potential_yn.equals("Y"))
						select_val="P";
				if(wellness_yn.equals("Y"))
					select_val="W";

				TabList=new ArrayList();
				TabList.add(code);
				TabList.add(mandatory_yn);
				TabList.add(actual_yn);
				TabList.add(potential_yn);
				TabList.add(wellness_yn);
				TabList.add(select_val);

				TermCodeForCaseType.putObject(TabList);
				
			}
		}
	

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(case_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(wellness_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
		
	
		}catch(Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}finally{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			ConnectionManager.returnConnection(connection,request);

		}
	
            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Associated.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
