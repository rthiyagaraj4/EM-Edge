package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __audittrialmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AuditTrialMain.jsp", 1742180792878L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n\n<!-- This file created by Jeyachitra for ML-MMOH-CRF 1742 -->\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\n\t<title> ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<link rel=\"stylesheet\" type=\"text/css             \" href=\"../../eCommon/html/CommonCalendar.css\">\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\'javascript\'></script>\n\t<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script>\n\t<script src=\'../js/RecDiagnosisMain.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\'  language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\t\n\t\n</head>\n\n<body>\n\t\t<table align=\'center\' cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'100%\' style=\"border-collapse: collapse;\">\n\t\t  \n\t\t  <tr></tr>\n\t\t  \n\t\t  <tr><td colspan=\'5\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =":&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td></tr>\n\n\t\t  <tr></tr>\n\t\t  \n\t\t  <tr>\n\t\t  <th align=\'center\' style=\'cursor:pointer\' nowrap class=\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </th>\n\t\t  <th align=\'center\' style=\'cursor:pointer\' nowrap class=\'CAGROUPHEADING\'> ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </th>\n\t\t  </tr>\n\t\t  \n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</table>\n\t\t\n\t\t<br>\n\n\t\t<center><input type=button name=\"Close\" id=\"Close\" class=\"button\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onclick=\"window.close();\"></center>\n\n\t\t<br>\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<script>\n\nfunction getDescriptionForAttrUpdated(attr_name, value)\n{\t\n\tvar returnValue =\"\";\n\tif(attr_name!=null)\n\t{\n\t\tif(attr_name==(\"Nature\"))\n\t\t{\n\t\t\tif(value==(\"A\"))\n\t\t\t\treturnValue = getLabel(\'Common.Actual.label\',\'Common\');\n\t\t\telse if(value==(\"P\"))\n\t\t\t\treturnValue = getLabel(\"Common.Potential.label\",\"Common\");\n\t\t\telse if(value==(\"W\"))\n\t\t\t\treturnValue = getLabel(\"Common.Wellness.label\",\"Common\");\n\t\t}\n\t\telse if(attr_name==(\"Severity\"))\n\t\t{\n\t\t\tif(value==(\"D\"))\n\t\t\t\treturnValue = getLabel(\"Common.Moderate.label\",\"Common\");\n\t\t\telse if(value==(\"L\"))\n\t\t\t\treturnValue = getLabel(\"Common.Mild.label\",\"Common\");\n\t\t\telse if(value==(\"S\"))\n\t\t\t\treturnValue = getLabel(\"Common.Severe.label\",\"Common\");\n\t\t\telse if(value==(\"E\"))\n\t\t\t\treturnValue = getLabel(\"Common.Extreme.label\",\"Common\");\n\t\t}\n\t\telse if(attr_name==(\"Priority\"))\n\t\t{\n\t\t\tif(value==(\"C\")) value = getLabel(\"Common.Critical.label\",\"Common\");\n\t\t\telse if(value==(\"H\")) value = getLabel(\"Common.High.label\",\"Common\");\n\t\t\telse if(value==(\"N\")) value = getLabel(\'Common.Normal.label\',\'Common\');\n\n\t\t}\n\t\telse if(attr_name==(\"Encounter_Stage\"))\n\t\t{\n\t\t\tif(value==(\"A\"))\n\t\t\t\treturnValue = getLabel(\"Common.admission.label\",\"Common\");\n\t\t\telse if(value==(\"I\"))\n\t\t\t\treturnValue = getLabel(\"Common.Intermediate.label\",\"Common\");\n\t\t\telse if(value==(\"D\"))\n\t\t\t\treturnValue = getLabel(\"Common.Discharge.label\",\"Common\");\t\n\t\t}\n\t\telse if(attr_name==(\"Status\"))\n\t\t{\n\t\t\tif(value==(\"A\"))\n\t\t\t\treturnValue = getLabel(\"Common.active.label\",\"Common\");\n\t\t\telse if(value==(\"R\"))\n\t\t\t\treturnValue = getLabel(\"Common.Resolved.label\",\"Common\");\n\t\t\telse if(value==(\"X\"))\n\t\t\t\treturnValue = getLabel(\"Common.Revoked.label\",\"Common\");\n\t\t\telse if(value==(\"E\"))\n\t\t\t\treturnValue = getLabel(\"Common.InError.label\",\"Common\");\n\t\t}\t\t\n\t}\t\n\t\n\treturn returnValue != \"\" ? returnValue : value;\n\t\n}\t\n\n$(document).ready(function() {\n\t \n\t$(\'td.audit-row\').each(function() {\t\n\t\tvar attrUpdated = $(this).data(\'attr-updated\');\n\t\tvar attrVal = $(this).data(\'attr-val\');\n\t\tvar attrName = $(this).data(\'attr-name\');\n\t\t\n\t\tvar updatedValue = getDescriptionForAttrUpdated(attrUpdated, attrVal);\n\n\t\tif(attrName == \'c\')\n\t\t\t$(this).html(updatedValue);\n\t\t\t\n\t\telse if (attrName == \'p\')\n\t\t\t$(this).html(updatedValue);\n\t\t\t\n\t});\n});\n\n</script>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
            _bw.write(_wl_block0Bytes, _wl_block0);

	Connection con = null;
	PreparedStatement pstmt=null;															
	ResultSet rs=null;
	PreparedStatement pstmt2=null;															
	ResultSet rs2=null;
	PreparedStatement pstmt3=null;															
	ResultSet rs3=null;
	
	String locale = (String)session.getAttribute("LOCALE"); 
	String login_user = (String)session.getAttribute("login_user"); 
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String term_set_id = checkForNull(request.getParameter("term_set_id"));
	String term_code = checkForNull(request.getParameter("term_code"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String occur_srl_no = checkForNull(request.getParameter("occur_srl_no"));
	String attr_updated = "";
	String attr_disp_name = "";
	String cur_attr_val = 	"";				
	String prev_attr_val = "";
	String modified_date = "";
	String modified_by_Id = "";


try{

            _bw.write(_wl_block6Bytes, _wl_block6);
	
	String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_code ));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			String getDesc_curr = "", getDesc_prev="";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement("select attr_updated, cur_attr_value, prev_attr_value, to_char(added_date,'dd/mm/yyyy hh24:mi:ss') added_date_odr, to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, added_by_id from mr_rec_diag_audit_trial where patient_id=? and term_Set_id=? and encounter_id=? and term_code=? and occur_srl_no=? and facility_id=? order by added_date_odr desc");
			pstmt.setString(1, patient_id);
			pstmt.setString(2, term_set_id);
			pstmt.setString(3, encounter_id);
			pstmt.setString(4, term_code);
			pstmt.setString(5, occur_srl_no);
			pstmt.setString(6, facility_id);
			rs= pstmt.executeQuery();
			if(rs!= null)
			{
				while(rs.next())
				{
					attr_updated = checkForNull(rs.getString("attr_updated"));
					cur_attr_val = checkForNull(rs.getString("cur_attr_value"));
					prev_attr_val = checkForNull(rs.getString("prev_attr_value"));
					modified_date = checkForNull(rs.getString("added_date"));
					modified_by_Id = checkForNull(rs.getString("added_by_id"));
					
					if ((attr_updated.equalsIgnoreCase("Diagnosis_Classification")) || (attr_updated.equalsIgnoreCase("Accuracy"))) 
					{
					    HashMap<String, String> prev_curr_value = new HashMap<String, String>();
					    prev_curr_value.put("cur_attr_val", cur_attr_val);
					    prev_curr_value.put("prev_attr_val", prev_attr_val);

					    for (Map.Entry<String, String> e : prev_curr_value.entrySet()) {
					        if (attr_updated.equalsIgnoreCase("Diagnosis_Classification")) {
					            pstmt2 = con.prepareStatement("SELECT mr_get_desc.mr_diag_class(diag_class_code, ?, '2') short_desc FROM mr_diag_class WHERE diag_class_code = ?");
					        } else if (attr_updated.equalsIgnoreCase("Accuracy")) {
					            pstmt2 = con.prepareStatement("SELECT short_desc FROM mr_accuracy_lang_vw WHERE language_id = ? AND accuracy_code = ?");
					        }

					        pstmt2.setString(1, locale);
					        pstmt2.setString(2, e.getValue());
					        rs2 = pstmt2.executeQuery();

					        if (rs2 != null && rs2.next()) {
					            if (e.getKey().equals("cur_attr_val")) {
					                cur_attr_val = rs2.getString("short_desc");
					            } else if (e.getKey().equals("prev_attr_val")) {
					                prev_attr_val = rs2.getString("short_desc");
					            }
					        }
					    }
					}

					attr_disp_name = attr_updated;
					
					if (attr_updated.equalsIgnoreCase("Encounter_Stage")) {
						attr_disp_name = "Encounter Stages";
					}else if (attr_updated.equalsIgnoreCase("Diagnosis_Classification")) {
						attr_disp_name = "Diagnosis Classification";
					}else if (attr_updated.equalsIgnoreCase("As_On_Date")) {
						attr_disp_name = "As on";
					}else if (attr_updated.equalsIgnoreCase("Onset_Date")) {
						attr_disp_name = "Onset Date";
					}else if (attr_updated.equalsIgnoreCase("Diagnosis_Remarks")) {
						attr_disp_name = "Diagnosis Remarks";
					}else if(attr_updated.equalsIgnoreCase("Chief_Complaint")) {
						attr_disp_name = "Chief Complaint";
					}
					
					out.println("<tr><td nowrap>"+attr_disp_name+"</td>");
	              	out.println("<td style='word-wrap: break-word;width:300px;' class='audit-row curr_attr' data-attr-updated='" + attr_updated + "' data-attr-val='" + cur_attr_val + "' data-attr-name='c'>&nbsp;</td>");
	                out.println("<td style='word-wrap: break-word;width:300px;' class='audit-row prev_attr' data-attr-updated='" + attr_updated + "' data-attr-val='" + prev_attr_val + "' data-attr-name='p'>&nbsp;</td>");
					out.println("<td nowrap>"+modified_date+"</td>");
					out.println("<td nowrap>"+modified_by_Id+"</td></tr>");					
				}
			}
			
			
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);

}catch ( Exception e ) 
{
	e.printStackTrace() ;
}
finally 
{
	try
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(rs2!=null) rs2.close();
		if(pstmt2!=null) pstmt2.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }
	catch(Exception es)
	{
		es.printStackTrace();
	}
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuditTrail.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AuditTrialTitle.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AuditTrialAttrUpdated.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AuditTrialCurrVal.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AuditTrialPrevVal.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AuditTrialModDate.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AuditTriallModBy.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
