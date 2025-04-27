package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __interventionforpatientclassdynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/InterventionForPatientClassDynamicValues.jsp", 1709116591559L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<body CLASS=\'MESSAGE\'>\n<form name=Dynamic_form>\n<input type=hidden name=E value=\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'>\n<input type=hidden name=R value=\'\'>\n<input type=hidden name=S value=\'\'>\n<input type=hidden name=X value=\'\'>\n<input type=hidden name=Y value=\'\'>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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

String locale			= (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con = null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String clearAll="";
String clearOne="";
//This file is saved on 18/10/2005.
try
{
String patient_class=request.getParameter("patient_class");
if(patient_class == null) patient_class="";
clearAll = request.getParameter("clearAll");
if(clearAll == null) clearAll="";
clearOne = request.getParameter("clearOne");
if(clearOne == null) clearOne="";
RecordSet	InterventionPatient	=	null;
InterventionPatient	=	(webbeans.eCommon.RecordSet)	session.getAttribute("InterventionPatient");
if(clearAll.equals("clearAll"))
{
InterventionPatient.clearAll();
}
else if(clearAll.equals("notCleared"))
{
InterventionPatient.clearAll();

con = ConnectionManager.getConnection(request);
//String sql="select intervention_code,'I' db_action from ca_intervention where intervention_code not in (select intervention_code from ca_pat_class_intervention where patient_class =?) and eff_status = 'E' union all select a.intervention_code, 'U' db_action from ca_pat_class_intervention a, ca_intervention b where a.patient_class = ? and b.intervention_code  = a.intervention_code order by 2";
String sql="SELECT intervention_code,'I' db_action FROM ca_intervention_lang_vw WHERE intervention_code NOT IN (SELECT intervention_code FROM ca_pat_class_intervention WHERE patient_class =?) AND eff_status = 'E' AND language_id = ? UNION ALL SELECT a.intervention_code, 'U' db_action FROM ca_pat_class_intervention a, ca_intervention_lang_vw b WHERE a.patient_class = ? AND b.intervention_code  = a.intervention_code AND b.language_id = ? ORDER BY 2";
pstmt=con.prepareStatement(sql);
pstmt.setString(1,patient_class);
pstmt.setString(2,locale);
pstmt.setString(3,patient_class);
pstmt.setString(4,locale);
rs=pstmt.executeQuery();
while(rs.next())
{
InterventionPatient.putObject(rs.getString(1));
}

}
if(!clearOne.equals(""))
{

	if(InterventionPatient.containsObject(clearOne))
	{
		InterventionPatient.removeObject(InterventionPatient.indexOfObject(clearOne));		
	}
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block3Bytes, _wl_block3);
}
catch(Exception e){out.print(e);}
finally
{
	  if(rs!=null) rs.close();
	  if(pstmt!=null) pstmt.close();

	  if(con != null)
	  ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
