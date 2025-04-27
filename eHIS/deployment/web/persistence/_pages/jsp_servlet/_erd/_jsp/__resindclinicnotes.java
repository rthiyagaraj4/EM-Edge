package jsp_servlet._erd._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import eOR.*;
import eOR.Common.*;
import eAE.resources.*;
import eCA.resources.*;
import eCA.*;
import eRD.*;
import eRD.Common.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __resindclinicnotes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eRD/jsp/ResIndClinicNotes.jsp", 1658294514853L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1658294068441L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1658294067208L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<html>\r\n<head>\r\n\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Report Text</title>\r\n \r\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\r\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\r\n \t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\r\n\t<script language=\"javascript\" src=\"../js/RadiologyExam.js\"></script>\r\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\r\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\r\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\r\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery.js\'></script>\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\r\n<body>\r\n\t<form id=\"reportText\" name=\"reportText\" target=\'messageFrame\' action=\"\" method=\"post\">\r\n\t\t<table>\r\n\t\t\r\n\t\t\r\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\'3\'>\r\n\t\t\t\t\t<textarea name=\"clinCom\" id=\"clinCom\" rows=28 cols=130 readonly>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</textarea>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\'3\'>\r\n\t\t\t\t\t<textarea name=\"clinComm1\" id=\"clinComm1\" rows=18 cols=130 ></textarea>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\'3\'>\r\n\t\t\t\t\t<textarea name=\"clinComm1\" id=\"clinComm1\" rows=46 cols=130 >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</textarea>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\t\t\t\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\t\t\r\n\t\t\t\t<input type=\'button\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' class=\'button\' onclick=\"insertNotes(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =");\" />\t\t\t\r\n\t\t\t\t<input name=\"close\" id=\"close\" type=\"button\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' class=\"button\" onClick=\"window.close();\" />\r\n\t\t\t</td>\r\n  \t\t</tr>\r\n\t</table> \r\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" name=\"operating_facility_id";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"operating_facility_id";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" /> \r\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" name=\"retrivedtext\" id=\"retrivedtext\" /> \r\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" name=\"prevComm\" id=\"prevComm\" /> \r\n\t\t\t<input type=\"hidden\" value=\"\" name=\"updatedText\" id=\"updatedText\" /> \r\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" name=\"patientid";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"patientid";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" /> \r\n\t\t\t <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" name=\"enc_id";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"enc_id";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" /> \r\n\t\t\t <input type=\"hidden\" name=\"User\" id=\"User\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" />\r\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" name=\"responsibility_id\" id=\"responsibility_id\" /> \r\n\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" name=\"req_no";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"req_no";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" name=\"REQUEST_LINE_NUM";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"REQUEST_LINE_NUM";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" /> <input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" name=\"indicator";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"indicator";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" name=\"radiologist";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"radiologist";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" name=\"ext_appl_accession";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"ext_appl_accession";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" /> \r\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
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

/*
Sr No        Version              TFS              SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735      PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String params =checkForNull(request.getParameter("params"));
	String P_FACILITY_ID = checkForNull(request.getParameter("P_FACILITY_ID"));
	String P_PATIENT_ID = checkForNull(request.getParameter("P_PATIENT_ID"));
	String P_ENCOUNTER_ID = checkForNull(request.getParameter("P_ENCOUNTER_ID"));
	String P_LOGIN_USER = checkForNull(request.getParameter("P_LOGIN_USER"));
	String P_LANGUAGE_ID = checkForNull(request.getParameter("P_LANGUAGE_ID"));
	String P_RESP_ID = checkForNull(request.getParameter("P_RESP_ID"));
	String P_REQUEST_NUM = checkForNull(request.getParameter("P_REQUEST_NUM"));
	String P_REQUEST_LINE_NUM = checkForNull(request.getParameter("P_REQUEST_LINE_NUM"));
	String P_EXT_APPL_ACCESSION_NUM = checkForNull(request.getParameter("P_EXT_APPL_ACCESSION_NUM"));
	String indicator = checkForNull(request.getParameter("indicator"));
	String index = checkForNull(request.getParameter("index"));
	String radiologist = checkForNull(request.getParameter("radiologist"));
	Connection con = ConnectionManager.getConnection();
	String report_text="";
	System.err.println("clinic note indicator"+indicator);
	try
		{
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		
			System.err.println("P_FACILITY_ID--"+P_FACILITY_ID);
			System.err.println("P_REQUEST_NUM--"+P_REQUEST_NUM);
			System.err.println("P_REQUEST_LINE_NUM--"+P_REQUEST_LINE_NUM);
			System.err.println("P_LANGUAGE_ID--"+P_LANGUAGE_ID);
			
				pstmt1=con.prepareStatement("select report_text from rd_exam_view_requested WHERE operating_facility_id = ? and request_num=?  and REQUEST_LINE_NUM=?");			
				
				pstmt1.setString(1,P_FACILITY_ID);
				pstmt1.setString(2,P_REQUEST_NUM);
				pstmt1.setString(3,P_REQUEST_LINE_NUM);
				
				rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					report_text =checkForNull(rs1.getString(1));
					System.err.println("report_text--"+report_text);
				}
				



            _bw.write(_wl_block4Bytes, _wl_block4);
 if(indicator.equals("M")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(report_text));
            _bw.write(_wl_block6Bytes, _wl_block6);
}else{
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(report_text));
            _bw.write(_wl_block8Bytes, _wl_block8);
	}
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(index));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(P_FACILITY_ID));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(index));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(index));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(report_text));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(report_text));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(P_PATIENT_ID));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(index));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_ENCOUNTER_ID));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(index));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_LOGIN_USER));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_RESP_ID));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(P_REQUEST_NUM));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(index));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_REQUEST_LINE_NUM));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(index));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(P_LANGUAGE_ID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_FACILITY_ID));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(index));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(index));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(indicator));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(index));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(index));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(radiologist));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(index));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_EXT_APPL_ACCESSION_NUM));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(index));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(index));
            _bw.write(_wl_block37Bytes, _wl_block37);

			}catch(Exception e)
		{
			System.out.println("Exception while retriving clinical notes :"+e);
		}finally{
			ConnectionManager.returnConnection(con, request);
		}
		
            _bw.write(_wl_block0Bytes, _wl_block0);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
