package jsp_servlet._eqa._jsp;

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

public final class __addmodifydiagprocforindicator extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/addModifyDiagProcForIndicator.jsp", 1742454078000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script type=\'text/javascript\' src=\'../../eQA/js/QADiagProcForIndicator.js\'></script>\n<!-- <script type=\'text/javascript\' src=\'../../eQA/js/QAValidate.js\'></script> -->\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<!-- <script src=\'../../eCommon/js/MstCodeCommon.js\' language=\'javascript\'></script> -->\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<body OnMouseDown=\'CodeArrest()\'; onLoad=\'populateValues()\' onKeyDown = \'lockKey()\'>\n\t<form name=\'QA_QIND_CLIND_DIAG_PROC\' id=\'QA_QIND_CLIND_DIAG_PROC\' target=\'messageFrame\' method=\'post\' action = \'../../servlet/eQA.QADiagProcForIndicator\' >\n\t<BR><BR><BR><BR><BR><BR><BR><BR><BR>\n  <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n\n  <tr>\n  <td width=\'40%\' >&nbsp;</td>\n  \t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n\n  <tr>\n      <td width=\'40%\' align=\'right\' class=\'label\'>Indicator ID</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>\n      &nbsp;&nbsp;\n\t  ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\n    <Input type=text value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' name=qind_indicator \' readonly>\n\t  \n\t  \n\t  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\n\t  <select name=qind_indicator id=qind_indicator onChange=\'populateValues();\' onblur=\' popScheme()\'>\n\t <option value=\'\'>-----Select------</option>\n\t   ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t   \n\t  <option value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t  </option>\n\t    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t </select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\t  \n     </td>\n\t  </tr>\n\t  <tr><B><td colspan=4 class=label id=\'indicator\' align=center></td></B></tr>\n\t  <tr><td colspan=4>&nbsp;</td></tr>\n\t  <tr>\n\t  <td width=\'40%\' align=\'right\' class=\'label\' >&nbsp;Diag/Procedure</td>\n      <td width=\'60%\' align=\'left\' >&nbsp;&nbsp;\n\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n           \n\t <Input type=text value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' id=\'diagdesc\' name=diagdesc readonly>  \n\t\t   <Input type=hidden value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' name=\'diag_proc_ind\' id=\'diag_proc_ind\'>\n\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t   \n\t <select name=\'diag_proc_ind\'  id=\'diag_proc_ind\' onChange=\' popScheme()\' >\n   \t <option value=\'\'>-----Select------</option>\n\t \t<!-- <option value=\'D\' >Diagnosis</option>\n\t\t<option value=\'P\' >Procedure</option>\n\t\t<option value=\'O\' >Orderable</option>\n -->\n\t\n\t </select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' id=\'mandatorydiag\'></img>\t  \n\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t </td>\n</tr>\n\t   \n\t <tr><td colspan=4>&nbsp;</td></tr>\n\t  <tr>\n      <td width=\'40%\' align=\'right\' class=\'label\'>&nbsp;Scheme Type</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>&nbsp;&nbsp;\n\t\t\t<select name=\'schema_type\' id=\'schema_type\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t\t\t<option value=\'\'>------Select-------</option>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<option value=\'1\' selected>ICD10</option>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<option value=\'1\'>ICD10</option>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<option value=\'2\' selected>ICD9-CM</option>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<option value=\'2\'>ICD9-CM</option>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<option value=\'3\' selected>CPT4</option>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<option value=\'3\'>CPT4</option>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<option value=\'4\' selected>ICD9-CM</option>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<option value=\'4\'>ICD9-CM</option>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<option value=\'6\' selected>ICD10-PCS</option>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<option value=\'6\'>ICD10-PCS</option>\n             ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n<!-- added by Shashi against SCR 3067 -->\n\t\t\t</select> ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" &nbsp;<img src=\'../../eCommon/images/mandatory.gif\' id=\'Schemetype\'></img> ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t  </td>\n</tr>\n\n\t <tr><td colspan=4>&nbsp;</td></tr>\n\t  <tr>\n      <td width=\'40%\' align=\'right\' class=\'label\' nowrap id=\'diag\'>&nbsp;Diag/Procedure Code</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>&nbsp;&nbsp;\n\t \n\t <Input type=text name=\'diagproccode\' id=\'diagproccode\'value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'size=10 maxlength=10 ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="></input>\n    <img src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t  </td>\n</tr>\n\t<tr><td colspan=4>&nbsp;</td></tr>  \n\t\n      </td>\n    </tr>\n<input type=hidden name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<!-- CLIND_CLASS hidden field is required used in intermediate jsp  -->\n<input type=hidden name=\'CLIND_CLASS\' id=\'CLIND_CLASS\' value=\'\'>\n  </table>\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

		Connection conn=null;
		String mode="";
        String schemetypedisable=""; 
		String diagreadonly=""; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
        String diag_proc_ind1="";
		String qind_clind_id=request.getParameter("qind_clind_id")==null ?"":request.getParameter("qind_clind_id");	
		String diag_proc_ind=request.getParameter("diag_proc_ind_code")==null ?"":request.getParameter("diag_proc_ind_code");	
		String scheme_type_code=request.getParameter("scheme_type_code")==null ?"":request.getParameter("scheme_type_code");	
		String diag_proc_code=request.getParameter("diag_proc_code")==null ?"":request.getParameter("diag_proc_code");	
	   mode=request.getParameter("mode")==null ?"":request.getParameter("mode");	

       conn = ConnectionManager.getConnection(request);
try
{
	
	if(!qind_clind_id.equals(""))
	{  
		
		pstmt=conn.prepareStatement("select QIND_CLIND_ID,DIAG_PROC_IND,SCHEME_TYPE,DIAG_PROC_CODE From QA_QIND_CLIND_DIAG_PROC  where QIND_CLIND_ID=? and DIAG_PROC_IND=? and SCHEME_TYPE=? and DIAG_PROC_CODE=?");
		pstmt.setString(1,qind_clind_id);
		pstmt.setString(2,diag_proc_ind);
		pstmt.setString(3,scheme_type_code);
		pstmt.setString(4,diag_proc_code);
		rs=pstmt.executeQuery();
		if(rs.next())			
		{
		 mode="U";
		 qind_clind_id=rs.getString("QIND_CLIND_ID");
System.err.println(rs.getString("DIAG_PROC_IND"));
		 diag_proc_ind=rs.getString("DIAG_PROC_IND");
		 scheme_type_code=rs.getString("SCHEME_TYPE");
		 diag_proc_code=rs.getString("DIAG_PROC_CODE");
		 
		schemetypedisable="disabled"; 
		diagreadonly="readonly"; 
	   }
	 }
	else
	 	 mode="I";

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
    }
catch(Exception ee)
{
	out.println("Error"+ee);
}

            _bw.write(_wl_block4Bytes, _wl_block4);
if(mode.equalsIgnoreCase("U")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(qind_clind_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
} else {	
		try
		  {
		  pstmt=conn.prepareStatement("select QIND_CLIND_ID,QIND_CLIND_DESC QADES,CLIND_CLASS From QA_QIND_CLIND where eff_status='E' and NVL(CLIND_CLASS,'*') NOT IN ('*','R','I') ORDER BY TO_NUMBER(QIND_CLIND_ID)");
		rs=pstmt.executeQuery();
	
            _bw.write(_wl_block7Bytes, _wl_block7);
while(rs.next())
		  {
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rs.getString("qind_clind_id")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rs.getString("qind_clind_id")));
            _bw.write(_wl_block10Bytes, _wl_block10);
}	
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
			}catch(Exception e)
	  {
	  out.println(e);
	  }finally
		  {
			ConnectionManager.returnConnection(conn,request);
		  }
	  }
	  
            _bw.write(_wl_block11Bytes, _wl_block11);
if(mode.equals("U"))
	 {
	 if(diag_proc_ind.equals("D"))
		 {
	  diag_proc_ind1="Diagnosis";
		 }
		 else if(diag_proc_ind.equals("P"))
		 {
			 diag_proc_ind1="Procedure";
		 }else if(diag_proc_ind.equals("O"))
		 {
			 diag_proc_ind1="Orderable";
		 }
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(diag_proc_ind1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(diag_proc_ind));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(schemetypedisable));
            _bw.write(_wl_block17Bytes, _wl_block17);
if(diag_proc_ind.equals("D"))
		 {
            _bw.write(_wl_block18Bytes, _wl_block18);
if(scheme_type_code.equals("1")){
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
            _bw.write(_wl_block20Bytes, _wl_block20);
} if(scheme_type_code.equals("2")){
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
		 }
			else if(diag_proc_ind.equals("P"))
			 {
			
			if(scheme_type_code.equals("3")){
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
} if(scheme_type_code.equals("4")){
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
} if(scheme_type_code.equals("6")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
            _bw.write(_wl_block28Bytes, _wl_block28);
}}
            _bw.write(_wl_block29Bytes, _wl_block29);
 if (mode.equalsIgnoreCase("I")){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
 } 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(diag_proc_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(diagreadonly));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block34Bytes, _wl_block34);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
