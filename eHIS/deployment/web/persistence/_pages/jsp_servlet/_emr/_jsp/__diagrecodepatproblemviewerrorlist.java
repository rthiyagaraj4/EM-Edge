package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __diagrecodepatproblemviewerrorlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DiagRecodePatProblemViewErrorList.jsp", 1709118905235L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- DisDataViewErrorList.jsp -->\n\n<!-- \n\t\t*     Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n\t\t*\t   Application     : eCA\n\t\t*     Purpose        : Responsible for Displaying All Error Messages for the Particular Paient and their Remarks for Error Messages\n\t\t*     Created By    : Chitra\n\t\t*     Modified By   : Suresh Babu .C\n\t\t*     Modified On  : 25 Feb 2004\n\t\t*\t   Note\t\t: See this Prg. with WordWrap UnChecked to see the correct flow of the Prg. \n-->\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html> \n\t<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\n\t\t<script src=\'../../eCA/js/DisDataCharting.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<title>Marked as Error List</title>\n\t</head>\n\n\t<body  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onScroll=\'scrollTitle()\' >\n<center>\n\t\t\t<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t\t\t\t<table border=\'1\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' >\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th align =\'left\'>Diag Type</th>\n\t\t\t\t\t\t<th align =\'left\'>Diag Desc</th>\n\t\t\t\t\t\t<th align =\'left\'>Diag Code</th>\n\t\t\t\t\t\t<th align =\'left\'>Marked by</th>\n\t\t\t\t\t\t<th align =\'left\'>Marked Date</th>\n\t\t\t\t\t\t<th align =\'left\'>Remarks</th>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n<table border=\'1\' width=\'100%\' id=\'dataTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#ffffff\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td align =\'left\' class=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td>\n\t\t\t\t\t\t\t\t\t<td align =\'left\' class=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td align =\'left\' class=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<tr style=\'visibility:hidden\'>\n\t\t\t\t\t\t<th align =\'left\'>Diag Type</th>\n\t\t\t\t\t\t<th align =\'left\'>Diag Desc</th>\n\t\t\t\t\t\t<th align =\'left\'>Diag Code</th>\n\t\t\t\t\t\t<th align =\'left\'>Error Marked by</th>\n\t\t\t\t\t\t<th align =\'left\'>Marked Date</th>\n\t\t\t\t\t\t<th align =\'left\'>Remarks</th>\n\t\t\t\t\t</tr>\n\t\t        </table>\n\t    </center>\n\t</body>\n</html>\n<script>setTimeout(\"alignWidth()\",100);</script>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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

	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

				Connection con	=null;
				PreparedStatement stmt=null;
				ResultSet  rs	=null;

				try{
					String classValue="";
					String patient_id = request.getParameter("patient_id");
					int i=1;
					
					String query="select decode(b.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, b.DIAG_CODE,  b.DIAG_DESC,  DECODE(B.DIAG_CODE_SCHEME,'1','ICD 1O','2','ICD 9CM') DIAG_CODE_SCHEME_DESC, j.PRACTITIONER_NAME      ERROR_MARKED_BY_ID, to_char(a.error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date_1, A.error_Remarks||'<br><br>Encounter:'||A.FACILITY_ID||'/'||A.ENCOUNTER_ID remarks from pr_problem_enc_err_log a, pr_problem b, AM_PRACTITIONER j where  a.patient_id=?  and b.patient_id=a.patient_id and b.SRL_NO=a.SRL_NO and j.PRACTITIONER_ID=A.ERROR_MARKED_BY_ID order by A.	error_marked_date desc ";
					con=ConnectionManager.getConnection(request);
					stmt=con.prepareStatement(query);					
					
					stmt.setString(1,patient_id);		
					
					rs=stmt.executeQuery();
			
            _bw.write(_wl_block4Bytes, _wl_block4);


							while(rs.next())	{
								if(i%2==0) classValue = "QRYEVEN";
									else classValue = "QRYODD";	
						
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("diagtype")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("DIAG_DESC")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("DIAG_CODE")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("ERROR_MARKED_BY_ID")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("ERROR_MARKED_DATE_1")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rs.getString("remarks")==null?" ":rs.getString("remarks")));
            _bw.write(_wl_block10Bytes, _wl_block10);

									i++;
							}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}catch(Exception e){
					//out.println("Exception "+e.toString());
					e.printStackTrace();
				}finally {
							if(con!=null)ConnectionManager.returnConnection(con,request);
					
				} 
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
