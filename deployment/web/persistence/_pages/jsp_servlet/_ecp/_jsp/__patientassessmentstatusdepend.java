package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patientassessmentstatusdepend extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/PatientAssessmentStatusDepend.jsp", 1709116603887L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head> \n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t<script src=\'../../eCP/js/PatientAssessment.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t</head>\n\t<body class=\'MESSAGE\'>\n\t\t<form name=\'patAssessIntermediateForm\' id=\'patAssessIntermediateForm\' action=\'\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\tsetTimeout(\"poulateStatus(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\",600);\n\t\t\t</script>\t\t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\tsetTimeout(\"poulateStatusForModify(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

			String accession_num = request.getParameter("accession_num") == null ? "" : request.getParameter("accession_num");
			out.println("accession_num = "+accession_num);
			String assess_ref_no = request.getParameter("assess_ref_no") == null ? "" : request.getParameter("assess_ref_no");
			String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");
			String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
			String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
			out.println("note_type = "+note_type);
			String note_desc = request.getParameter("note_desc") == null ? "" : request.getParameter("note_desc");
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			out.println("mode = "+mode);
			String locn_type = request.getParameter("locn_type") == null ? "" : request.getParameter("locn_type");
			String locn_code = request.getParameter("locn_code") == null ? "" : request.getParameter("locn_code");
			String dob = request.getParameter("dob") == null ? "" : request.getParameter("dob");
			String age = request.getParameter("age") == null ? "" : request.getParameter("age");
			String sex = request.getParameter("sex") == null ? "" : request.getParameter("sex");
			String reln_id = request.getParameter("reln_id") == null ? "" : request.getParameter("reln_id");

			String facility_id = (String) session.getAttribute("facility_id");
			out.println("facility_id = "+facility_id);
			//out.println("facility_id+++"+facility_id);

			String assessStatus = "";
			String assessStatus_flag = "";
			String assessDependency = "";
			String abnormalCateg = "";
			String assessDepCode = "";
			String sqlStatus = "";
			
			Connection con = null;
			ResultSet resAssessCode = null;
			PreparedStatement pstAssessCode = null;
			CallableStatement cs = null;

			try
			{
				con = ConnectionManager.getConnection(request);
				
				sqlStatus = "select decode(event_status,'1','In Progress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified'),event_status from ca_encntr_note where FACILITY_ID=? and accession_num=? ";
				pstAssessCode = con.prepareStatement(sqlStatus);
				pstAssessCode.setString(1,facility_id);
				pstAssessCode.setString(2,accession_num);
			
				resAssessCode = pstAssessCode.executeQuery();
				while(resAssessCode.next())
				{
					assessStatus = resAssessCode.getString(1);
					assessStatus_flag = resAssessCode.getString(2);
				}

				if(resAssessCode != null) resAssessCode.close();
				if(pstAssessCode != null) pstAssessCode.close();

				resAssessCode = null;
				pstAssessCode = null;

				cs = con.prepareCall("{call CP_GET_ASSESS_OUTPUT(?,?,?,?,?)}" );
				
				cs.setString(1,accession_num);
				cs.setString(2,facility_id);
				cs.setString(3,note_type);
				cs.registerOutParameter(4,Types.VARCHAR);
				cs.registerOutParameter(5,Types.VARCHAR);
								
				cs.execute();				

				assessDepCode = cs.getString(4) == null ? "" : cs.getString(4);
				abnormalCateg = cs.getString(5) == null ? "" : cs.getString(5);	
				

			}//end of try
			catch(Exception e)
			{
				e.printStackTrace(System.err);
				System.out.println("Exception in try of PatientAssessmentStatusDepend.jsp "+e.toString());
			}
			finally
			{
				if(con!=null)
					ConnectionManager.returnConnection(con,request);
				if(resAssessCode != null) resAssessCode.close();
				if(pstAssessCode != null) pstAssessCode.close();
				if(cs != null) cs.close();
			}
			if(!mode.equals("modify"))
			{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assessDepCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(assessStatus));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(assessDepCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(assessDependency));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(abnormalCateg));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(assessStatus_flag));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			else if(mode.equals("modify"))
			{
				out.println("mode ="+mode);
				out.println("assessStatus ="+assessStatus+"=");
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(assessDepCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(assessStatus));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(note_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(age));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(assess_ref_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(reln_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(assessStatus_flag));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			
            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.IntermediateStatusDependency.label", java.lang.String .class,"key"));
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
}
