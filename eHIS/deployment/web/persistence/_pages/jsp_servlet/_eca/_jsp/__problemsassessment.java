package jsp_servlet._eca._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __problemsassessment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ProblemsAssessment.jsp", 1709116066122L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\'../../eCA/js/PatProblem.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table width=\'100%\' height=\'100%\' align=center cellpadding=\'3\' cellspacing=\'0\' border=\'0\'>\n\t\t\t\t<!-- <th colspan=2 align=left height=10%>Close Details</th> -->\n\t\t\t\n\t\t\t<td class=\'columnHeader\' align=left height=\"7%\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\'columnHeader\' align=\'left\' height=\'7%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<table width=\'100%\' cellpadding=3 height=\'100%\' border=\'0\'>\n\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t<tr>\n\t\t\t\t<td width=\'100%\' valign=\"top\"><font size=\'1\' color=\"BLACK\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t<table width=\'100%\' height=\'100%\' border=\'0\'>\n\t\t\t&nbsp;&nbsp;\n\t\t\t<tr>\n\t\t\t<td width=\'100%\' valign=\"top\"><font size=\'1\' color=\"BLACK\">\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</font></td>\n\t\t\t</tr>\n\t\t\t<!-- <tr><td>&nbsp;</td><tr><tr><td>&nbsp;</td><tr><tr><td>&nbsp;</td><tr> -->\n\t\t\t</table>\n\t\t\t</td>\n\n\t\t\t</tr>\n\t\t\t</table>\n\n\t\t\t<!-- Assessments ends -->\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\n\t\t\t</body>\n\t\t\t</html>\n\t\t";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection conn= null;
	PreparedStatement stmt		=null;
	PreparedStatement stmt_1		=null;
	ResultSet rs		=null;
	ResultSet rs_1		=null;
	PreparedStatement pstmt = null;
	ResultSet rs1 	= null;
	HashMap hmap = new HashMap();
	int remarksCount = 0;
	try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		conn = ConnectionManager.getConnection(request);
		StringBuffer strBuff_pr_problem_assessment = new StringBuffer();
		String srl_no       = request.getParameter("srl_no");
		String onset_date="";
		String onset_practitioner_name="";
		String onset_facility_name="";
		String onset_locn_desc="";
		String onset_recorded_date="";
		String close_date="";
		String close_practitioner_name="";
		String close_facility_name="";
		String close_locn_desc="";
		String close_recorded_date="";
		//String pr_problem_assessment="";
		String pr_problem_assessment_remarks="";
		String onset_facility_id = "";
		String onset_encounter_id = "";
		String close_facility_id = "";
		String close_encounter_id = "";
		String onset_service = "";
		String close_service = "";
		String recorded_by  = "";
		String closed_by   = "";
		String patientid=request.getParameter("Patient_Id");

		if (!(srl_no ==null))
		{
			try
			{
				StringBuffer strBuff_sql = new StringBuffer();
				//strBuff_sql.append("Select to_char(onset_date,'dd/mm/yyyy') onset_date,onset_practitioner_name,onset_facility_name, onset_locn_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date,to_char(close_date,'dd/mm/yyyy') close_date,close_practitioner_name,close_facility_name,close_locn_desc,to_char(close_recorded_date ,'dd/mm/yyyy') close_recorded_date,onset_facility_id, onset_encounter_id,close_facility_id, close_encounter_id,recorded_by,closed_by from pr_problem_vw where patient_id=? and srl_no=?");

				
				strBuff_sql.append("Select to_char(onset_date,'dd/mm/yyyy') onset_date,AM_GET_DESC.AM_PRACTITIONER(onset_practitioner_id,?,'1')  onset_practitioner_name,SM_GET_DESC.SM_FACILITY_PARAM(onset_facility_id,?,'1')onset_facility_name,nvl(OP_GET_DESC.OP_CLINIC(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(ONSET_FACILITY_ID,ONSET_LOCN_CODE,?,'1') ) onset_locn_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date,to_char(close_date,'dd/mm/yyyy') close_date,AM_GET_DESC.AM_PRACTITIONER(CLOSE_PRACTITIONER_ID,?,'1') close_practitioner_name,SM_GET_DESC.SM_FACILITY_PARAM(close_facility_id,?,'1')close_facility_name,nvl(OP_GET_DESC.OP_CLINIC(CLOSE_FACILITY_ID,CLOSE_LOCN_CODE,?,'1'),IP_GET_DESC.IP_NURSING_UNIT(CLOSE_FACILITY_ID,CLOSE_LOCN_CODE,?,'1') ) close_locn_desc,to_char(close_recorded_date ,'dd/mm/yyyy') close_recorded_date,onset_facility_id,onset_encounter_id,close_facility_id,close_encounter_id,recorded_by,closed_by from pr_problem_vw where patient_id=? and srl_no=?");

				

				String StrSql1="Select log_text log_text , problem_remarks from pr_problem_assessment where patient_id=? and srl_no=?";

				stmt = conn.prepareStatement(strBuff_sql.toString());
				//stmt = conn.prepareStatement(StrSql);
				stmt.setString(1,locale);
				stmt.setString(2,locale);
				stmt.setString(3,locale);
				stmt.setString(4,locale);
				stmt.setString(5,locale);
				stmt.setString(6,locale);
				stmt.setString(7,locale);
				stmt.setString(8,locale);
				stmt.setString(9,patientid);
				stmt.setString(10,srl_no);
				rs = stmt.executeQuery();

				while(rs.next())
				{
					onset_date=rs.getString("onset_date");
					onset_practitioner_name= rs.getString("onset_practitioner_name");
					onset_facility_name=rs.getString("onset_facility_name");
					onset_locn_desc=rs.getString("onset_locn_desc");
					onset_recorded_date=rs.getString("onset_recorded_date");
					close_date=rs.getString("close_date");
					close_practitioner_name=rs.getString("close_practitioner_name");
					close_facility_name=rs.getString("close_facility_name");
					close_locn_desc=rs.getString("close_locn_desc");
					close_recorded_date=rs.getString("close_recorded_date");
					onset_facility_id = rs.getString("onset_facility_id");
					onset_encounter_id = rs.getString("onset_encounter_id");
					close_facility_id = rs.getString("close_facility_id");
					close_encounter_id = rs.getString("close_encounter_id");
					recorded_by = rs.getString("recorded_by");
					closed_by = rs.getString("closed_By") ;

				}
					
					if(rs!=null) rs.close();
					
					//out.println(onset_date);
				stmt_1 = conn.prepareStatement(StrSql1);
				stmt_1.setString(1,patientid);
				stmt_1.setString(2,srl_no);
				rs_1 = stmt_1.executeQuery();
				while(rs_1.next())
				{
					strBuff_pr_problem_assessment.append(rs_1.getString("log_text"));
					strBuff_pr_problem_assessment.append("<br>");
					pr_problem_assessment_remarks   = rs_1.getString("problem_remarks");

					if(pr_problem_assessment_remarks == null)pr_problem_assessment_remarks ="";
					if(!pr_problem_assessment_remarks.equals("")){

						hmap.put("rmk"+remarksCount++, pr_problem_assessment_remarks);
					}
				}
					if(rs_1!=null) rs_1.close();
					if(stmt_1!=null) stmt_1.close();
				//Added newly
				//pstmt = conn.prepareStatement("select b.short_desc from pr_encounter a, am_service b where a.facility_id = ? and a.encounter_id = ? and b.service_code = a.service_code");

				pstmt = conn.prepareStatement("select AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') short_desc from pr_encounter a where a.facility_id = ? and a.encounter_id = ? ");
				pstmt.setString(1,locale);
				pstmt.setString(2,onset_facility_id);
				pstmt.setString(3,onset_encounter_id);
				rs1 = pstmt.executeQuery();
				while(rs1!=null && rs1.next())
				{
				  onset_service = rs1.getString(1);
				}

				if(rs1!=null) rs1.close();
				pstmt.setString(1,close_facility_id);
				pstmt.setString(2,close_encounter_id);
				rs1 = pstmt.executeQuery();
				while(rs1!=null && rs1.next())
				{
				  close_service = rs1.getString(1);
				}
			}
			catch (Exception e)
			{
				//out.println("HERE AFTER :"+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181		
			}			
			if	(onset_date== null)
					onset_date="&nbsp";
			if	(onset_practitioner_name== null)
					onset_practitioner_name ="&nbsp";
			if 	(onset_facility_name== null)
					onset_facility_name="&nbsp";
			if 	(onset_locn_desc== null)
					onset_locn_desc="&nbsp";
			if 	(onset_recorded_date== null)
					onset_recorded_date="&nbsp";
			if 	(close_date== null)
					close_date="&nbsp";
			if 	(close_practitioner_name== null)
					close_practitioner_name="&nbsp";
			if 	(close_facility_name== null)
					close_facility_name="&nbsp";
			if	(close_locn_desc== null)
					close_locn_desc="&nbsp";
			if 	(close_recorded_date== null)
					close_recorded_date="&nbsp";
			/*if 	(pr_problem_assessment== null)
					pr_problem_assessment="&nbsp";*/
			if(strBuff_pr_problem_assessment.length() == 0)
			{
				strBuff_pr_problem_assessment.append("&nbsp");
			}

			if(pr_problem_assessment_remarks == null)
				pr_problem_assessment_remarks = "&nbsp";

			if(onset_service ==null)
				   onset_service="&nbsp;";
			if(close_service ==null)
				   close_service="&nbsp;";
			if(recorded_by ==null)
				   recorded_by="&nbsp;";
			if(closed_by ==null)
				   closed_by="&nbsp;";
/*
			if(!onset_date.equals("&nbsp;"))
				onset_date			= com.ehis.util.DateUtils.convertDate(onset_date,"DMY","en",locale);
		
			if(!onset_recorded_date.equals("&nbsp;"))
				onset_recorded_date	= com.ehis.util.DateUtils.convertDate(onset_recorded_date,"DMY","en",locale);
			
			if(!close_date.equals("&nbsp;"))
				close_date			= com.ehis.util.DateUtils.convertDate(close_date,"DMY","en",locale);
			
			if(!close_recorded_date.equals("&nbsp;"))
				close_recorded_date	= com.ehis.util.DateUtils.convertDate(close_recorded_date,"DMY","en",locale);

				

*/		}
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strBuff_pr_problem_assessment.toString()));
            _bw.write(_wl_block12Bytes, _wl_block12);

			//=pr_problem_assessment_remarks
			String disp_rmks = "", prev_disp_rmks="";
			StringBuffer concatRmks = new StringBuffer();
			for(int i=0; i<hmap.size(); i++)
			{
				disp_rmks = (String)hmap.get("rmk"+i);

				if(!prev_disp_rmks.equalsIgnoreCase(disp_rmks))
				{
					if(!disp_rmks.equals(""))
					{
						if(disp_rmks.length() > 20)
						{
							concatRmks.append(disp_rmks.substring(0,15));
							concatRmks.append("...<br>");
							disp_rmks = disp_rmks.replace('\n','`');
							disp_rmks = disp_rmks.replace('\'','~');
							out.println("<a href=\"javascript:showLongDesc('"+disp_rmks+"')\">"+concatRmks.toString()+"</a>");

						}
						else
						{
							out.println(disp_rmks+"<br>");
						}
					}
				}
				else
				{
					out.println("&nbsp;"+"<br>");
				}
				prev_disp_rmks = disp_rmks;
			}
            _bw.write(_wl_block13Bytes, _wl_block13);

			
			if(stmt!=null) stmt.close();
			
			
			if(rs1!=null) rs1.close();
			if(pstmt!=null) pstmt.close();	
			}
		catch(Exception e)
		{
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally 
		{
			hmap.clear();
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
