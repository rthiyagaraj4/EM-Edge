package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __patproblemencdtlresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatProblemEncDtlResult.jsp", 1709116012904L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onKeyDown=\'lockKey()\'>\n<form name=\'PatEncounterDetailsForm\' id=\'PatEncounterDetailsForm\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<table border=1 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\">\n\t\t<tr>\n\t\t\t<td class=\'columnheader\'  >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\'columnheader\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t</tr>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String Patient_Id = request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");
	String srl_no = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String diag_code = request.getParameter("diag_code")==null?"":request.getParameter("diag_code");
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	Properties p = (Properties)session.getValue("jdbc");
	String locale= (String) p.getProperty("LOCALE");	
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;

	
	
	String Patient_class_desc = "";
	String facility_name = "";
	String visit_adm_datetime = "";
	String locn_desc = "";
	String pract_name = "";
	
	String sql = "";
//	String classValue = "";
	int i = 0;
	try
	{
		con = ConnectionManager.getConnection(request);

		//sql = "select (select short_desc from am_patient_class where patient_class=c.patient_class) Patient_class_desc,(select facility_name from sm_facility_param where facility_id=c.facility_id) facility_name      ,to_char(c.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_datetime      ,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN (SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=C.FACILITY_ID  AND NURSING_UNIT_CODE=c.ASSIGN_CARE_LOCN_CODE ) ELSE (SELECT SHORT_DESC FROM OP_CLINIC WHERE FACILITY_ID=C.FACILITY_ID  AND CLINIC_CODE=c.ASSIGN_CARE_LOCN_CODE )	END LOCN_DESC ,(select short_name from am_practitioner where practitioner_id=c.ATTEND_PRACTITIONER_ID) pract_name from pr_problem a    ,pr_problem_enc_dtl b  ,pr_encounter c where a.patient_id= ? and a.srl_no= ? and b.patient_id=a.patient_id and b.SRL_NO = a.SRL_NO and c.facility_id=b.facility_id and c.encounter_id=b.encounter_id  order by visit_adm_datetime ";

		//sql="select AM_GET_DESC.AM_PATIENT_CLASS(c.patient_class,?,'2') Patient_class_desc,SM_GET_DESC.SM_FACILITY_PARAM(c.facility_id,?,'1') facility_name      ,to_char(c.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_datetime ,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(c.facility_id,c.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(C.FACILITY_ID,c.ASSIGN_CARE_LOCN_CODE,?,'1') 	END LOCN_DESC ,AM_GET_DESC.AM_PRACTITIONER(C.ATTEND_PRACTITIONER_ID,?,'2')  pract_name from pr_problem a    ,pr_problem_enc_dtl b  ,pr_encounter c where a.patient_id= ? and a.srl_no= ? and b.patient_id=a.patient_id and b.SRL_NO = a.SRL_NO and c.facility_id=b.facility_id and c.encounter_id=b.encounter_id  order by visit_adm_datetime";


		
	/*sql = "SELECT  A.ENCOUNTER_ID,TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME,A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE,A.ASSIGN_CARE_LOCN_TYPE,A.ASSIGN_CARE_LOCN_CODE,DECODE (A.ASSIGN_CARE_LOCN_TYPE,'C', OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'),'N', IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'))||'/'||AM_GET_DESC.AM_CARE_LOCN_TYPE(A.ASSIGN_CARE_LOCN_TYPE,?,'2') ASSIGN_CARE_LOCN_DESC,A.ASSIGN_ROOM_NUM ,A.ASSIGN_BED_NUM , A.ATTEND_PRACTITIONER_ID ,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,'1') PRACTITIONER_NAME ,a.patient_class PATIENT_CLASS_DESC ,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'1') SERVICE_DESC  FROM PR_ENCOUNTER A  WHERE  A.FACILITY_ID = ?  AND A.ENCOUNTER_ID = NVL (NULL, A.ENCOUNTER_ID)  AND A.PATIENT_ID = ?  ORDER BY ENCOUNTER_DATE DESC";
	
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(7,p_facility_id);
		pstmt.setString(6,Patient_Id); */

		//sql = "SELECT  A.ENCOUNTER_ID,(select facility_name from sm_facility_param where facility_id=A.facility_id) facility_name,TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME, A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE,A.ASSIGN_CARE_LOCN_TYPE,A.ASSIGN_CARE_LOCN_CODE,DECODE (A.ASSIGN_CARE_LOCN_TYPE,'C', OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'),'N', IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'))||'/'||AM_GET_DESC.AM_CARE_LOCN_TYPE(A.ASSIGN_CARE_LOCN_TYPE,?,'2') ASSIGN_CARE_LOCN_DESC,A.ASSIGN_ROOM_NUM ,A.ASSIGN_BED_NUM , A.ATTEND_PRACTITIONER_ID ,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,'1') PRACTITIONER_NAME ,a.patient_class PATIENT_CLASS_DESC ,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'1') SERVICE_DESC  FROM PR_ENCOUNTER A  WHERE  A.FACILITY_ID = ?  AND A.ENCOUNTER_ID = NVL (NULL, A.ENCOUNTER_ID)  AND A.PATIENT_ID = ?  ORDER BY ENCOUNTER_DATE DESC";
		sql = "SELECT distinct A.ENCOUNTER_ID,(select facility_name from sm_facility_param where facility_id=A.facility_id) facility_name, TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME, A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE, A.ASSIGN_CARE_LOCN_TYPE,A.ASSIGN_CARE_LOCN_CODE, DECODE (A.ASSIGN_CARE_LOCN_TYPE,'C', OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'2'), 'N', IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1'))||'/'|| AM_GET_DESC.AM_CARE_LOCN_TYPE(A.ASSIGN_CARE_LOCN_TYPE,?,'2') ASSIGN_CARE_LOCN_DESC, A.ASSIGN_ROOM_NUM ,A.ASSIGN_BED_NUM , A.ATTEND_PRACTITIONER_ID , AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,'2') PRACTITIONER_NAME , a.patient_class PATIENT_CLASS_DESC ,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'1') SERVICE_DESC   FROM PR_ENCOUNTER A , PR_DIAGNOSIS_ENC_DTL B  WHERE  A.FACILITY_ID = ?   AND A.PATIENT_ID = ?  AND A.ENCOUNTER_ID = B.ENCOUNTER_ID  AND A.FACILITY_ID = B.FACILITY_ID  AND A.PATIENT_ID = B.PATIENT_ID AND  B.TERM_SET_ID = ? and TERM_CODE=? and OCCUR_SRL_NO=? ORDER BY ENCOUNTER_DATE DESC";
	
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(6,p_facility_id);
		pstmt.setString(7,Patient_Id);		
		pstmt.setString(8,term_set_id);		
		pstmt.setString(9,diag_code);		
		pstmt.setString(10,srl_no);		
		rs = pstmt.executeQuery();

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);


		/*while(rs.next())
		{
			Patient_class_desc = rs.getString("Patient_class_desc");
			
			facility_name = rs.getString("facility_name");
			visit_adm_datetime = rs.getString("visit_adm_datetime");
			locn_desc = rs.getString("locn_desc");
			pract_name = rs.getString("pract_name");
			if(i%2 == 0)
				classValue = "QRYODD";
			else
				classValue = "QRYEVEN";
			
			out.println("<tr><td class='label'  font='2'>"+visit_adm_datetime+"</td>");	
			out.println("<td class='label'  class="+classValue+" font='2'>"+Patient_class_desc+"</td>");	
			out.println("<td class='label'  class="+classValue+" font='2'>"+facility_name+"</td>");
			out.println("<td class='label'  class="+classValue+" font='2'>"+locn_desc+"</td>");		
			out.println("<td class='label'  class="+classValue+" font='2'>"+pract_name+"</td></tr");		
			
			i++;
			*/
			while(rs.next())
		{
			//Patient_class_desc = rs.getString("service_desc");
			Patient_class_desc = rs.getString("PATIENT_CLASS_DESC") == null ? "&nbsp;" : rs.getString("PATIENT_CLASS_DESC");
			
			facility_name = rs.getString("facility_name") == null ? "&nbsp;" : rs.getString("facility_name");
			visit_adm_datetime = rs.getString("VISIT_ADM_DATE_TIME") == null ? "&nbsp;" : rs.getString("VISIT_ADM_DATE_TIME");
			locn_desc = rs.getString("ASSIGN_CARE_LOCN_DESC") == null ? "&nbsp;" : rs.getString("ASSIGN_CARE_LOCN_DESC");
			pract_name = rs.getString("practitioner_name") == null ? "&nbsp;" : rs.getString("practitioner_name");			
			
			out.println("<tr><td  font='2' class='gridData'>"+visit_adm_datetime+"</td>");	
			out.println("<td   font='2' class='gridData'>"+Patient_class_desc+"</td>");	
			out.println("<td   font='2' class='gridData'>"+facility_name+"</td>");
			out.println("<td   font='2' class='gridData'>"+locn_desc+"</td>");		
			out.println("<td  font='2' class='gridData'>"+pract_name+"</td></tr");		
			
			i++;
	}
	if(i == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));top.window.close()</script>");
	}
	
	if(rs!=null)
		rs.close();
	if(pstmt!=null)
		pstmt.close();


            _bw.write(_wl_block12Bytes, _wl_block12);

}
catch(Exception e)
{
	//out.println("Exception @ PatEncounterDetails.jsp "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDateTime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityName.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionername.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
