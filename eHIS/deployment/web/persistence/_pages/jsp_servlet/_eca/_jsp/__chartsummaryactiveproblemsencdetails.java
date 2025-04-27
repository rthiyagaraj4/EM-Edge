package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummaryactiveproblemsencdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryActiveProblemsEncDetails.jsp", 1709115692058L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n05/03/2013\tIN038302, IN038306, IN038354  \tSystem is displaying the linked encounter two times in which the diagnosis is modified.\n\t\t\t\t\t\t\t\t\t\t\tSystem is displaying the non-associated  encounter ID in the linked encounter \n\t\t\t\t\t\t\t\t\t\t\tSystem is not displaying the linked encounter list for the recorded diagnosis in descending order.\n12/03/2013\t\t\tIN038463\t\tKarthi\tChart Summary->Encounter  2 is not listed in the ?Active Problems Linked Encounter details? dialog box. \t\t\t\t\t\t\n19/03/2013\t IN038718     \t\tKarthi L\tSystem is displaying the non-associated Encounter ID 1 and Encounter ID 2 in the linked encounter list for the Diagnosis which was recorded in Encounter ID 3\n--------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n  \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCA/js/ResearchPatient.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t\t<table class=\'grid\' align=\'center\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<td align=\'center\'  nowrap class=\'COLUMNHEADERCENTER\'><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></td> \t\n\t\t\t\t<td align=\'center\'  nowrap class=\'COLUMNHEADERCENTER\'><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font></td>\n\t\t\t\t<td align=\'center\'  nowrap class=\'COLUMNHEADERCENTER\'><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<tr>\t\n\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </td> \n\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </td> \n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>  <a class=\'gridLink\' href=\"javascript:showEncounterDialogList(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></td>\n\t\t\t\t</tr>\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</table>\t\t\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String title = "Active Problems Linked Encounter Details";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(title));
            _bw.write(_wl_block9Bytes, _wl_block9);

		String facility_id= (String) session.getValue("facility_id");
		java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) property.getProperty("LOCALE");
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		Connection conn= null;
		PreparedStatement stmt =null;
		ResultSet rs	 =null;
		String classValue="";
		String patientid = request.getParameter("patient_id") == null?"":request.getParameter("patient_id");
		String term_set_id = request.getParameter("term_set_id") == null?"":request.getParameter("term_set_id");
		String diag_code = request.getParameter("diag_code") == null?"":request.getParameter("diag_code");
		String contentId = request.getParameter("content_id") == null?"":request.getParameter("content_id"); 
		String encounter_id = "";
		String visitdate = ""; 
		String patient_class = ""; 
		String curr_status = "A"; // added for IN038306
		try
		{
			conn = ConnectionManager.getConnection(request);
			
			//String Sql= "select distinct a.ENCOUNTER_ID encounter_id, e.PATIENT_CLASS patient_class, to_char(e.visit_adm_date_time,'DD/MM/YYYY') visit_date from PR_DIAGNOSIS_STATUS A , pr_encounter e where A.patient_id = ? and A.patient_id=E.patient_id and a.ENCOUNTER_ID=e.ENCOUNTER_ID and a.term_set_id = ? and a.term_code = ? and a.facility_id = ?"; commented for IN038302, IN038306, IN038354	
			//String Sql= "SELECT   distinct a.ENCOUNTER_ID encounter_id, e.PATIENT_CLASS patient_class,TO_CHAR (e.visit_adm_date_time, 'DD/MM/YYYY') visit_date 	FROM   PR_DIAGNOSIS_STATUS A, pr_encounter e,PR_DIAGNOSIS b WHERE   A.patient_id = ? AND A.patient_id = E.patient_id AND A.patient_id = b.patient_id AND a.ENCOUNTER_ID = e.ENCOUNTER_ID AND a.ENCOUNTER_ID = b.ONSET_ENCOUNTER_ID AND a.term_set_id = ? AND a.term_code = ? AND a.facility_id= ? and b.curr_status = ?  order by visit_date desc" ;// modified for IN038302, IN038306, IN038354(for IN038354 reopened we removed order by encounder_id
			//String Sql = "SELECT DISTINCT a.ENCOUNTER_ID encounter_id, e.PATIENT_CLASS patient_class, TO_CHAR (e.visit_adm_date_time, 'DD/MM/YYYY') visit_date FROM PR_DIAGNOSIS_STATUS A, pr_encounter e WHERE A.patient_id = ? AND A.patient_id = E.patient_id AND a.ENCOUNTER_ID = e.ENCOUNTER_ID AND a.term_set_id = ? AND a.term_code = ? AND a.facility_id =? AND A.status = ? ORDER BY to_date(visit_date,'DD/MM/YYYY') desc "; // IN038463 //IN038354
			String Sql = " SELECT DISTINCT a.ENCOUNTER_ID encounter_id, e.PATIENT_CLASS patient_class, TO_CHAR (e.visit_adm_date_time, 'DD/MM/YYYY hh24:mi') visit_date FROM PR_DIAGNOSIS_STATUS A, pr_encounter e, PR_DIAGNOSIS b WHERE A.patient_id = ? AND a.patient_id = e.patient_id AND a.patient_id = b.patient_id AND a.ENCOUNTER_ID = e.ENCOUNTER_ID and a.term_set_id = b.term_set_id and a.term_code = b.term_code AND a.OCCUR_SRL_NO=b.OCCUR_SRL_NO AND a.term_set_id = ? AND a.term_code = ? AND a.facility_id =?      AND B.CURR_STATUS =? ORDER BY to_date(visit_date,'DD/MM/YYYY hh24:mi') desc"; // IN038718                                 
      
			stmt = conn.prepareStatement(Sql);
			stmt.setString(1,patientid);
			stmt.setString(2,term_set_id);
			stmt.setString(3,diag_code);
			stmt.setString(4,facility_id);
			stmt.setString(5,curr_status); //IN038302, IN038306, IN038354	 
			rs = stmt.executeQuery();
	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
 
			while(rs.next())
			{	
				classValue="gridData";
				encounter_id =rs.getString("encounter_id") == null?"":rs.getString("encounter_id");
				patient_class =rs.getString("patient_class") == null?"":rs.getString("patient_class");
				visitdate = rs.getString("visit_date") == null?"":rs.getString("visit_date");
				visitdate = com.ehis.util.DateUtils.convertDate(visitdate,"DMYHM","en",locale);	
				visitdate = visitdate.substring(0,10); //IN038718
				
				if(patient_class.equals("OP"))
					patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(patient_class.equals("IP"))
					patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(patient_class.equals("EM"))
					patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(patient_class.equals("DC"))
					patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(visitdate));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
		
            _bw.write(_wl_block24Bytes, _wl_block24);

		}	
		catch (Exception e){
			//	out.println("Errors have occured"+e);//COMMON-ICN-0181
				e.printStackTrace();
		}

		finally
		{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if (conn != null) ConnectionManager.returnConnection(conn,request);
		}
	
            _bw.write(_wl_block25Bytes, _wl_block25);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounter.label", java.lang.String .class,"key"));
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
}
