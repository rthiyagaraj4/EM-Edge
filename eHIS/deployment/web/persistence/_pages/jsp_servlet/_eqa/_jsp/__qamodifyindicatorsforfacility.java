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

public final class __qamodifyindicatorsforfacility extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAModifyIndicatorsForFacility.jsp", 1742817545623L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script type=\'text/javascript\' src=\'../../eQA/js/QAIndicatorGroup.js\'></script>\n <script type=\'text/javascript\' src=\'../../eQA/js/QAValidate.js\'></script> \n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script src=\'../../eCommon/js/MstCodeCommon.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n/*functions moved to JS...*/\n\t</script>\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<body  onKeyDown = \'lockKey()\' >\n\t<form name=\'QA_fac_ind\' id=\'QA_fac_ind\' target=\'messageFrame\' method=\'post\' action = \'\'  >\n\t<BR><BR><BR><BR><BR><BR><BR><BR><BR>\n  <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n\n  <tr>\n  <td width=\'20%\' >&nbsp;</td>\n  \t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n\n  <tr>\n      <td width=\'20%\' align=\'right\' class=\'label\' >Facility</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>\n      &nbsp;&nbsp;\n\t\t\t<input type=\'text\' name=\'oper_name\' id=\'oper_name\' size=\'30\'  value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'  maxlength=\'30\' readonly >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t<input type=\'hidden\' name=\'operating_facility_id\' id=\'operating_facility_id\' size=\'2\'  value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>&nbsp;\n\t       </td>\n    </tr>\n  <tr>\n  <td width=\'20%\' >&nbsp;</td>\n  \t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n\t<tr>\n      <td width=\'20%\' align=\'right\' class=\'label\'>Indicator ID</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>\n      &nbsp;&nbsp;\n\t  \n\t\t\t<input type=\'text\' name=\'qind\' id=\'qind\' size=\'2\'  value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'  maxlength=\'2\' onBlur=\'ChangeUpperCase(this);\' readonly onKeyPress=\'return CheckForSpecChars(event)\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t       </td>\n    </tr>\n  <tr>\n           <td width=\'20%\' >&nbsp;</td>\n  \t     <td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  <tr>\n      <td width=\'20%\' align=\'right\' class=\'label\' nowrap>&nbsp;Indicator Description</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>\n      &nbsp;&nbsp;\n\t\t\t<input type=\'text\' name=\'qind\' id=\'qind\' size=\'60\'  value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'  maxlength=\'60\'  readonly onKeyPress=\'return CheckForSpecChars(event)\'>&nbsp;\n\t       </td>\n    </tr>\n  <tr>\n           <td width=\'20%\' >&nbsp;</td>\n  \t     <td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n  \t<tr>\n\t\t\t<td class=label align=right>Periodicity</td>\n\t\t\t<td align=left>&nbsp;&nbsp;&nbsp;<select  name=period >\n\t\t\t\t\t\t\t<option value=\'X\'>---------Select--------------&nbsp;&nbsp;&nbsp;\n\t\t\t    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<option value=\'M\'  selected>Monthly&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t    <option value=\'M\' >Monthly&nbsp;\n\t\t\t   ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t     ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<option value=\'Q\'  selected>Quarterly&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t    <option value=\'Q\' >Quarterly&nbsp;\n\t\t\t   ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<option value=\'B\'  selected>Bi-Annually&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t    <option value=\'B\' >Bi-Annually&nbsp;\n\t\t\t   ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<option value=\'A\'  selected>Annually &nbsp;\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t    <option value=\'A\' >Annually &nbsp;\n\t\t\t   ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t   </select></td>  \n\t\t\t   </tr>\n\t\t\t   <tr>\n  <td width=\'20%\' >&nbsp;</td>\n  \t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n  <tr>\n      <td width=\'20%\' align=\'right\' class=\'label\'>Age</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>\n      &nbsp;&nbsp;\n\t\t\t<input type=\'text\' name=\'age\' id=\'age\' size=\'4\'  value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  maxlength=\'4\' onBlur=\'ChangeUpperCase(this);\'   onKeyPress=\'return(ChkNumberInput(this,event,0))\'>&nbsp;\n\t       </td>\n    </tr>\n    <tr>\n  <td width=\'20%\' >&nbsp;</td>\n  \t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n\t\t\t<tr>\n\t\t\t<td class=label align=right>Gender</td>\n\t\t\t<td align=left>&nbsp;\n\t\t\t ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t   <input type=\'checkbox\'  checked name=gender id=gender value=\'Y\'  onclick=\"genYN(this)\">\n\t\t\t   ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t   <input type=\'checkbox\'  name=gender id=gender   value=\'N\'  onclick=\"genYN(this)\">\n\t\t\t   ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t   </td>\n\t\t</tr>\n  <td width=\'20%\' >&nbsp;</td>\n  \t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n\t<td width=\'20%\' >&nbsp;</td>\n    \t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n  </table>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
		PreparedStatement pstmt=null;
		ResultSet rs=null;
       String dflt_rep_periodicity1="";
	   String dflt_bd_age_range_id1="";
	   String dflt_bd_by_gender_yn1="";
	   String qind_clind_desc="";
	   String oper_name="";

	   String qind_clind_id=request.getParameter("qind_clind_id")==null ?"":request.getParameter("qind_clind_id");	
	   String operating_facility_id=request.getParameter("operating_facility_id")==null ?"":request.getParameter("operating_facility_id");	
	   //String dflt_rep_periodicity=request.getParameter("dflt_rep_periodicity")==null ?"":request.getParameter("dflt_rep_periodicity");
	
	   //String dflt_bd_by_gender_yn=request.getParameter("dflt_bd_by_gender_yn")==null ?"":request.getParameter("dflt_bd_by_gender_yn");
		  
	   //String dflt_bd_age_range_id=(request.getParameter("dflt_bd_age_range_id")==null||request.getParameter("dflt_bd_age_range_id").equals("null")) ?"":request.getParameter("dflt_bd_age_range_id");
		   
	   String mode="U";
	
       conn = ConnectionManager.getConnection(request);

       pstmt=conn.prepareCall("select   facility_name,qind_clind_id,qind_clind_desc,dflt_rep_periodicity,dflt_bd_by_gender_yn,dflt_bd_age_range_id from qa_qind_facility_clind_vw  where qind_clind_id=? and operating_facility_id=? ");
	   pstmt.setString(1,qind_clind_id);
	   pstmt.setString(2,operating_facility_id);
	   rs=pstmt.executeQuery();
	try
	{
		while(rs.next())
		{
		oper_name=rs.getString("facility_name");
		qind_clind_id=rs.getString("QIND_CLIND_ID");
		qind_clind_desc=rs.getString("qind_clind_desc");

		dflt_rep_periodicity1=rs.getString("dflt_rep_periodicity");
		if(dflt_rep_periodicity1==null)dflt_rep_periodicity1="";

		dflt_bd_age_range_id1=rs.getString("DFLT_BD_AGE_RANGE_ID");
		if(dflt_bd_age_range_id1==null)dflt_bd_age_range_id1="";
		dflt_bd_by_gender_yn1=rs.getString("dflt_bd_by_gender_yn");
		if(dflt_bd_by_gender_yn1==null)dflt_bd_by_gender_yn1="N";
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
	catch(Exception e)
	{
	out.println("Error"+e);
	}finally
	{
	    ConnectionManager.returnConnection(conn,request);
    }

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oper_name));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(operating_facility_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(qind_clind_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(qind_clind_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
if(dflt_rep_periodicity1.equals("M"))
			{
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);
if(dflt_rep_periodicity1.equals("Q"))
			{
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(dflt_rep_periodicity1.equals("B"))
			{
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(dflt_rep_periodicity1.equals("A"))
			{
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(dflt_bd_age_range_id1));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(dflt_bd_by_gender_yn1.equals("Y")){
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
