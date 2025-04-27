package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eMR.*;
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

public final class __agegroupfortermcodehyperlinks extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AgeGroupForTermCodeHyperLinks.jsp", 1709118875876L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- AgeGroupForTermCodeHyperLinks.jsp -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n      \t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n      \t<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n\t\t\t\t\n\t\t\n\t\t \n\t\t<script language=\"JavaScript\" src=\"../js/AgeGroupForTermCode.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onKeyDown=\"lockKey()\">\n<form name=\"form_hyperlinks\" id=\"form_hyperlinks\">\n<table  border=\'0\' cellspacing=\'0\' cellpadding=\'5\' align=\'center\' width=\'100%\'>\n\t<tr>\n\t\t<td><label onClick=\"loadDetail(associated_lb,\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'Associated\')\" style=\"color:blue;cursor:pointer\" id=\'associated_lb\'><u><font color=\'maroon\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font></u></label></td>\n\t\t<td><label onClick=\"loadDetail(A_lb,\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'A\')\" style=\"color:blue;cursor:pointer\" id=\'A_lb\'><u>A</u></label></td>\n\t\t<td><label onClick=\"loadDetail(B_lb,\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'B\')\" style=\"color:blue;cursor:pointer\" id=\'B_lb\'><u>B</u></label></td>\n\t\t<td><label onClick=\"loadDetail(C_lb,\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'C\')\" style=\"color:blue;cursor:pointer\" id=\'C_lb\'><u>C</u></label></td>\n\t\t<td><label onClick=\"loadDetail(D_lb,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'D\')\" style=\"color:blue;cursor:pointer\" id=\'D_lb\'><u>D</u></label></td>\n\t\t<td><label onClick=\"loadDetail(E_lb,\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'E\')\" style=\"color:blue;cursor:pointer\" id=\'E_lb\'><u>E</u></label></td>\n\t\t<td><label onClick=\"loadDetail(F_lb,\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'F\')\" style=\"color:blue;cursor:pointer\" id=\'F_lb\'><u>F</u></label></td>\n\t\t<td><label onClick=\"loadDetail(G_lb,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'G\')\" style=\"color:blue;cursor:pointer\" id=\'G_lb\'><u>G</u></label></td>\n\t\t<td><label onClick=\"loadDetail(H_lb,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'H\')\" style=\"color:blue;cursor:pointer\" id=\'H_lb\'><u>H</u></label></td>\n\t\t<td><label onClick=\"loadDetail(I_lb,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'I\')\" style=\"color:blue;cursor:pointer\" id=\'I_lb\'><u>I</u></label></td>\n\t\t<td><label onClick=\"loadDetail(J_lb,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'J\')\" style=\"color:blue;cursor:pointer\" id=\'J_lb\'><u>J</u></label></td>\n\t\t<td><label onClick=\"loadDetail(K_lb,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'K\')\" style=\"color:blue;cursor:pointer\" id=\'K_lb\'><u>K</u></label></td>\n\t\t<td><label onClick=\"loadDetail(L_lb,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'L\')\" style=\"color:blue;cursor:pointer\" id=\'L_lb\'><u>L</u></label></td>\n\t\t<td><label onClick=\"loadDetail(M_lb,\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'M\')\" style=\"color:blue;cursor:pointer\" id=\'M_lb\'><u>M</u></label></td>\n\t\t<td><label onClick=\"loadDetail(N_lb,\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'N\')\" style=\"color:blue;cursor:pointer\" id=\'N_lb\'><u>N</u></label></td>\n\t\t<td><label onClick=\"loadDetail(O_lb,\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'O\')\" style=\"color:blue;cursor:pointer\" id=\'O_lb\'><u>O</u></label></td>\n\t\t<td><label onClick=\"loadDetail(P_lb,\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'P\')\" style=\"color:blue;cursor:pointer\" id=\'P_lb\'><u>P</u></label></td>\n\t\t<td><label onClick=\"loadDetail(Q_lb,\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'Q\')\" style=\"color:blue;cursor:pointer\" id=\'Q_lb\'><u>Q</u></label></td>\n\t\t<td><label onClick=\"loadDetail(R_lb,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'R\')\" style=\"color:blue;cursor:pointer\" id=\'R_lb\'><u>R</u></label></td>\n\t\t<td><label onClick=\"loadDetail(S_lb,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'S\')\" style=\"color:blue;cursor:pointer\" id=\'S_lb\'><u>S</u></label></td>\n\t\t<td><label onClick=\"loadDetail(T_lb,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'T\')\" style=\"color:blue;cursor:pointer\" id=\'T_lb\'><u>T</u></label></td>\n\t\t<td><label onClick=\"loadDetail(U_lb,\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'U\')\" style=\"color:blue;cursor:pointer\" id=\'U_lb\'><u>U</u></label></td>\n\t\t<td><label onClick=\"loadDetail(V_lb,\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'V\')\" style=\"color:blue;cursor:pointer\" id=\'V_lb\'><u>V</u></label></td>\n\t\t<td><label onClick=\"loadDetail(W_lb,\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'W\')\" style=\"color:blue;cursor:pointer\" id=\'W_lb\'><u>W</u></label></td>\n\t\t<td><label onClick=\"loadDetail(X_lb,\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'X\')\" style=\"color:blue;cursor:pointer\" id=\'X_lb\'><u>X</u></label></td>\n\t\t<td><label onClick=\"loadDetail(Y_lb,\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'Y\')\" style=\"color:blue;cursor:pointer\" id=\'Y_lb\'><u>Y</u></label></td>\n\t\t<td><label onClick=\"loadDetail(Z_lb,\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'Z\')\" style=\"color:blue;cursor:pointer\" id=\'Z_lb\'><u>Z</u></label></td>\n\t\t<td></td>\n\t\t<td><label onClick=\"loadDetail(Other_lb,\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'*\')\" style=\"color:blue;cursor:pointer\" id=\'Other_lb\'><u>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</u></label></td>\n\t</tr>\n</table>\n</form>\n\t\t\t<script>\n\t\t\tvar frmobj=parent.frames[0].document.forms[0];\n\t\t\t\t\tparent.frames[2].location.href=\'../../eMR/jsp/AgeGroupForTermCodeDetail.jsp?term_set_id=\'+frmobj.term_set_id.value+\'&type=\'+frmobj.type.value+\'&age_group_code=\'+frmobj.age_group_code.value+\'&term_code_desc=\'+frmobj.term_code_desc.value+\'&search_criteria=\'+frmobj.search_criteria.value+\'&alphalink=Associated\';\n\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet AgeGroupForTermCode= null;synchronized(session){
                AgeGroupForTermCode=(webbeans.eCommon.RecordSet)pageContext.getAttribute("AgeGroupForTermCode",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(AgeGroupForTermCode==null){
                    AgeGroupForTermCode=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("AgeGroupForTermCode",AgeGroupForTermCode,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		AgeGroupForTermCode.clearAll();

	Connection con = null;
	try{
		String age_group_code = request.getParameter("age_group_code");
		String term_set_id = request.getParameter("term_set_id");
		String type = request.getParameter("type");
		String search_criteria = request.getParameter("search_criteria");
		String term_code_desc = request.getParameter("term_code_desc");
		//Statement stmt = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;		
		ArrayList TabList = null;

		ArrayList sessionList = (ArrayList)AgeGroupForTermCode.getRecordSetHandle();
		if(sessionList.size()>0)
		{
			TabList = (ArrayList)AgeGroupForTermCode.getObject(0);
		}else{
			TabList=new ArrayList();
		}

		String sqlData="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,'U' db_action FROM mr_age_grp_for_term_code a, mr_term_code b WHERE a.age_group_code=? and b.term_set_id =? AND b.term_set_id = a.term_set_id and  b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' ))ORDER BY 3";
		con= ConnectionManager.getConnection(request);
		//stmt=con.createStatement();
		stmt = con.prepareStatement(sqlData);
		stmt.setString(1,age_group_code);
		stmt.setString(2,term_set_id);
		stmt.setString(3,type);
		stmt.setString(4,type);
		rs=stmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				String code=rs.getString("term_code");
				
				TabList.add(code);
			}
						
		}
		AgeGroupForTermCode.putObject(TabList);


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
				session.setAttribute("AgeGroupForTermCode", AgeGroupForTermCode);
			}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if ( con!=null ) ConnectionManager.returnConnection(con,request);
		}
            _bw.write(_wl_block40Bytes, _wl_block40);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Associated.label", java.lang.String .class,"key"));
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
