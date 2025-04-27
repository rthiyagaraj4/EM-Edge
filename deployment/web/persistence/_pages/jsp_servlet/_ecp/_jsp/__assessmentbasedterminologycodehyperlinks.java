package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import java.lang.*;
import webbeans.eCommon.*;
import eOR.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.HashMap;
import com.ehis.eslp.*;
import java.net.*;
import java.util.*;
import com.ehis.util.*;

public final class __assessmentbasedterminologycodehyperlinks extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/AssessmentBasedTerminologyCodeHyperLinks.jsp", 1724909833285L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!-- AssessmentBasedTerminologyCodeHyperLinks.jsp -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<HTML>\n<HEAD>\n\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></SCRIPT>\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\' ></SCRIPT>\n\t    <SCRIPT language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></SCRIPT>\n\t\t<SCRIPT language=\"JavaScript\" src=\"../../eCP/js/AssessmentBasedTerminologyCode.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<BODY>\n<FORM name=\"form_hyperlinks\" id=\"form_hyperlinks\">\n<TABLE  border=\'0\' cellspacing=\'0\' cellpadding=\'0\' align=\'center\' width=\'100%\'>\n\t<TR>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=Associated&assessmentCategoryCode=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&terminologySetId=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&type=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&classificationLevel=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' target=\"f_query_detail\"><u>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=A&assessmentCategoryCode=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' target=\"f_query_detail\"><u>A</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=B&assessmentCategoryCode=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' target=\"f_query_detail\"><u>B</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=C&assessmentCategoryCode=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' target=\"f_query_detail\"><u>C</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=D&assessmentCategoryCode=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' target=\"f_query_detail\"><u>D</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=E&assessmentCategoryCode=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' target=\"f_query_detail\"><u>E</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=F&assessmentCategoryCode=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' target=\"f_query_detail\"><u>F</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=G&assessmentCategoryCode=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' target=\"f_query_detail\"><u>G</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=H&assessmentCategoryCode=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' target=\"f_query_detail\"><u>H</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=I&assessmentCategoryCode=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' target=\"f_query_detail\"><u>I</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=J&assessmentCategoryCode=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' target=\"f_query_detail\"><u>J</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=K&assessmentCategoryCode=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' target=\"f_query_detail\"><u>K</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=L&assessmentCategoryCode=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' target=\"f_query_detail\"><u>L</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=M&assessmentCategoryCode=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' target=\"f_query_detail\"><u>M</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=N&assessmentCategoryCode=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' target=\"f_query_detail\"><u>N</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=O&assessmentCategoryCode=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' target=\"f_query_detail\"><u>O</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=P&assessmentCategoryCode=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' target=\"f_query_detail\"><u>P</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=Q&assessmentCategoryCode=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' target=\"f_query_detail\"><u>Q</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=R&assessmentCategoryCode=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' target=\"f_query_detail\"><u>R</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=S&assessmentCategoryCode=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' target=\"f_query_detail\"><u>S</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=T&assessmentCategoryCode=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' target=\"f_query_detail\"><u>T</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=U&assessmentCategoryCode=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' target=\"f_query_detail\"><u>U</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=V&assessmentCategoryCode=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' target=\"f_query_detail\"><u>V</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=W&assessmentCategoryCode=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' target=\"f_query_detail\"><u>W</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=X&assessmentCategoryCode=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' target=\"f_query_detail\"><u>X</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=Y&assessmentCategoryCode=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' target=\"f_query_detail\"><u>Y</u></a></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=Z&assessmentCategoryCode=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' target=\"f_query_detail\"><u>Z</u></a></TD>\n\t\t<TD></TD>\n\t\t<TD><a href=\'../../eCP/jsp/AssessmentBasedTerminologyCodeDetail.jsp?alphalink=&assessmentCategoryCode=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</u></a></TD>\n\t</TR>\n</TABLE>\n</FORM>\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.RecordSet TerminologyCode= null;synchronized(session){
                TerminologyCode=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologyCode",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologyCode==null){
                    TerminologyCode=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologyCode",TerminologyCode,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block7Bytes, _wl_block7);

 //This file is saved on 18/10/2005.
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

//out.println("entering into hyperlinks.jsp");
		Connection connection=null; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;		
	try{
		
		ArrayList TabList		= null;
		ArrayList sessionList			=  (ArrayList)TerminologyCode.getRecordSetHandle();
		if(sessionList.size()>0)
		{
			TabList=(ArrayList)TerminologyCode.getObject(0);
		}else{
			TabList=new ArrayList();
		}

		String assessmentCategoryCode=request.getParameter("assessmentCategoryCode");
		String terminologySet=request.getParameter("terminologySetId");
		String type=request.getParameter("type");
		String classificationLevel1=request.getParameter("classificationLevel");
		int classificationLevel=Integer.parseInt(classificationLevel1);
		String sqlData="Select a.term_set_id, a.term_code, b.short_desc, 'U' db_action from      CP_TRGD_TERM_CODE_AT_ASSMT a, mr_term_code b where a.ASSESS_CATG_CODE = ? and  b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' )) and a.term_set_id = ? and b.code_level =? order by 3";
		connection = ConnectionManager.getConnection(request);
		pstmt=connection.prepareStatement(sqlData);
		pstmt.setString(1,assessmentCategoryCode);
		pstmt.setString(2,type);
		pstmt.setString(3,type);
		pstmt.setString(4,terminologySet);
		pstmt.setInt(5,classificationLevel);
		//out.println("assessmentCategoryCode--|" +assessmentCategoryCode+ "|----type---|" +type+ "|---type----|" +type+ "|--classificationLevel---|" +classificationLevel+ "|--");
		rs=pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				String code=rs.getString("term_code");
				TabList.add(code);
			}
		}
		TerminologyCode.putObject(TabList);
	

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(assessmentCategoryCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(terminologySet));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classificationLevel));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close(); }
		  ConnectionManager.returnConnection(connection,request);
		}
            _bw.write(_wl_block43Bytes, _wl_block43);
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
