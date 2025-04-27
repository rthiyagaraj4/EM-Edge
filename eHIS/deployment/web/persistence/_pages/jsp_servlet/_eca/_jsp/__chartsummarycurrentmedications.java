package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummarycurrentmedications extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryCurrentMedications.jsp", 1709115697668L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<head>\n\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<center>\n\t\t<form name=\'CAViewPatientAllergyForm\' id=\'CAViewPatientAllergyForm\' method=\'post\'>\n\t\t<table class=\'grid\' width=\'100%\'>\n\t\t\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'gridData\' width=\"60%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t<td class=\'gridData\' width=\"40%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>  <!-- 27788 -->\n\t\t</form>\n\t</center>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

			String patient_id = "", query_current_medications = "";
			String drug_name = "",	drug_duration = "";
			String classValue = "";
			int i=0;

			Connection con = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			ResultSet	rs = null;
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			
			String facilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");

			try
			{
				//27788 Start.
				String compressed =request.getParameter("compressed")==null?"N":(String)request.getParameter("compressed");				
				if("Y".equals(compressed)){
					patient_id = new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));					
				}else{
				//27788 End.
					patient_id = request.getParameter("patient_id");
				}				
				if(patient_id==null) patient_id = "";			
				
					
					
		query_current_medications =" SELECT e.form_code||' '||e.DRUG_DESC||' '||a.dosage ||' '||PH_GET_UOM_DISPLAY('"+facilityId+"',a.dosage_uom_code)||' '||a.FREQ_CODE||' * '||a.DURATION  ||' '||c.DURN_DESC   drug_name,to_char(a.start_date,'dd/mm/yy') start_date, to_char(a.end_date,'dd/mm/yy') end_date  FROM ph_patient_drug_profile a ,am_duration_type c,am_frequency d, ph_drug e ,ph_generic_name f WHERE a.patient_id = ? AND TRUNC(NVL(a.end_date,SYSDATE)) >= TRUNC(SYSDATE) AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND d.freq_code(+)=a.FREQ_CODE AND e.DRUG_CODE=a.DRUG_CODE  and f.GENERIC_ID=a.GENERIC_ID AND c.durn_type(+)=d.INTERVAL_DURN_TYPE ORDER BY start_date DESc ";
		
			 con = ConnectionManager.getConnection(request);
			 String phInstallYn="select 1 from  sm_module where module_id='PH' and INSTALL_YN='Y'";
			pstmt1 = con.prepareStatement(phInstallYn);

			if(rs != null) rs = null;
			rs = pstmt1.executeQuery();
			String strStDate ="";
			String strEdDate = "";

			if(rs.next())
			{

				if (rs!=null) rs.close();
				pstmt	=	con.prepareStatement(query_current_medications);

				pstmt.setString(1,patient_id);

				rs = pstmt.executeQuery();

				while(rs.next())
				{
					i++;

					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";

					drug_name	= rs.getString("drug_name");
					strStDate = ((rs.getString("start_date")==null)?"":rs.getString("start_date"));
					strEdDate = ((rs.getString("end_date")==null)?"":rs.getString("end_date"));

					drug_duration	= com.ehis.util.DateUtils.convertDate(strStDate,"DMY","en",locale) + " - " + com.ehis.util.DateUtils.convertDate(strEdDate,"DMY","en",locale) ;

					if(drug_name==null)		drug_name		= "&nbsp;";
				
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(drug_duration));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			} // module install
				if(rs!=null) rs.close();
				if(pstmt1!=null) pstmt1.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(Exception e)
			{
				//out.println("Exception@1 : "+e.getMessage());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChartSummaryCurrentMedications.label", java.lang.String .class,"key"));
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
}
