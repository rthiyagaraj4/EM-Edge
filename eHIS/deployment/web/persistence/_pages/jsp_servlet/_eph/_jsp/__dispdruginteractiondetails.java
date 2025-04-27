package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dispdruginteractiondetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispDrugInteractionDetails.jsp", 1709117310462L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- /* \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\t     Description\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?                created\n05/07/2019      [IN:067952]     Devindra             MMS-KH-CRF-0013 [IN:067952] \n30/11/2019      [IN070606]     Manickavasagam J             MMS-KH-CRF-0029 [IN070606] \n---------------------------------------------------------------------------------------------------------------\n*/ -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t</head>\n<body>\n \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t<TABLE   name=\"DrugInteractionList\" cellspacing=\"0\" cellpadding=\"3\" border=\"1\" width = \"100%\" style=\"BACKGROUND-COLOR:#FFFFCC\">   \n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'2\' align=\'center\'>&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;-&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td >\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">    \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;</td >\n\t\t\t\t\t\t\t\t\t</tr> <!-- MMS-KH-CRF-0029[IN070606] end-->\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td width=\'15%\' style=\"color:red;BACKGROUND-COLOR:#FFFFCC\">\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<!--  //MMS-KH-CRF-0029[IN070606] - start-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t \n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t\tDrug Name\n\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tGeneric Name\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t<td width=\'*\' style=\"color:red;BACKGROUND-COLOR:#FFFFCC\"><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</b></td >\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr> <!-- added for MMS-KH-CRF-0029 [IN070606]-->\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC;display:";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >Dosage Form\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;</td >\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">Severity&nbsp;Level\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tMajor\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tModerate\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tMinor\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">Significant&nbsp;Level\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td >\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">Documentation\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</td >  \n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tEstablished\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tProbable\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tSuspected\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tPossible\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\tUnlikely\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">RestrictTransaction\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\t\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/enabled.gif\'>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/disabled.gif\'>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">Interaction&nbsp;Description\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td > \n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\"><textarea readonly=\"false\"  style=\"BACKGROUND-COLOR:#FFFFCC;border: none;overflow: auto;\" cols=\"80\" >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</textarea></td> <!-- added for FD-RUT-CRF-0066.1 [IN036975] -->\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t<tr> <td style=\"BACKGROUND-COLOR:#FFFFCC\">Lab Result(s)&nbsp;</td><!-- MMS-KH-CRF-0034.4-->\n\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#ffcc00\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t<tr> <td colspan=\'2\' style=\"BACKGROUND-COLOR:#FFFFCC\">&nbsp;</td>\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t</TABLE>\n\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
                              
                                 String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
                                 String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
             				     String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
                                 String bean_name		= "ePH.PrescriptionBean_1"; 
                                 PrescriptionBean_1 bean =  (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
                                 bean.setLanguageId(locale);
                                 String drug_code		        = request.getParameter( "drug_code" )==null?"":request.getParameter("drug_code");
                                 String form_code = request.getParameter("form_code")==null?"":request.getParameter("form_code");
                                 String generic_id = request.getParameter("generic_id")==null?"":request.getParameter("generic_id");
                                 String start_date = request.getParameter("start_date")==null?"":request.getParameter("start_date");
                                 String end_date = request.getParameter("end_date")==null?"":request.getParameter("end_date");                                                             
                                 ArrayList hmDrugIntList = bean.getDrugInteractionDtls(drug_code, form_code, generic_id, start_date, end_date, patient_id);                                                                 
                                 HashMap DrugInteractionDtl=null;  
                                 String drug_desc = request.getParameter("drug_name")==null?"":request.getParameter("drug_name");                                                                 
									
                                 String intr_option,intr_name, severity_level, significant_level, probability, interaction_desc, restrict_transaction,form_desc="";
                                                         																																	
                    form_desc = request.getParameter("form_desc")==null?"":request.getParameter("form_desc");
					String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id"); //MMS-KH-CRF-0034.4
					String order_line_no = request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");//MMS-KH-CRF-0034.4
                                 String interaction_type=""; //MMS-KH-CRF-0029

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
                                  
								if(hmDrugIntList!=null){
									String intr_desc = "";  //MMS-KH-CRF-0029
								String drug_dosage_display = "inline"; //MMS-KH-CRF-0029
							//MMS-KH-CRF-0034.4 - start
								String intr_code = "";
								String test_result_value = "";
								StringBuffer test_result_content = null; 
								//MMS-KH-CRF-0034.4 - end
                                 for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
									DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
									test_result_value = "";//MMS-KH-CRF-0034.4
									intr_option = (String)DrugInteractionDtl.get("INTR_TYPE1");
									intr_name = (String)DrugInteractionDtl.get("intr_name");
									severity_level = (String)DrugInteractionDtl.get("severity_level");
									significant_level = (String)DrugInteractionDtl.get("significant_level");
									probability = (String)DrugInteractionDtl.get("probability");
									restrict_transaction = (String)DrugInteractionDtl.get("restrict_transaction");
									interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
									form_desc = (String)DrugInteractionDtl.get("form_desc")==null?"":(String)DrugInteractionDtl.get("form_desc");
									intr_code = (String)DrugInteractionDtl.get("intr_code")==null?"":(String)DrugInteractionDtl.get("intr_code"); //MMS-KH-CRF-0034.4
									interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2");  
									//MMS-KH-CRF-0029[IN070606] - start//MMS-KH-CRF-0034.4
									if(interaction_type.equals("F")){
										intr_desc = "Drug-Food";
										drug_dosage_display	="none";
									}
									else if(interaction_type.equals("L")){
										intr_desc = "Drug-Lab";
										drug_dosage_display	="none";
									}else if(interaction_type.equals("I")){//Added for MMS-DM-CRF-0229
										intr_desc = "Drug-Disease";
										drug_dosage_display	="none";
									}
									else{
										intr_desc = "Drug-Drug";
										drug_dosage_display	="inline";
									}
						//MMS-KH-CRF-0034.4 - start
									if(interaction_type.equals("L")){
										test_result_content = new StringBuffer();
									 test_result_value= bean.getLabTestResult(order_id,order_line_no,drug_code,intr_code);

									if(!test_result_value.equals("") ){ 
										String lab_test_result_grp = "";
										StringTokenizer strToken = null;
										String prev_token = "";
										String token_value = "";
										String test_result[] = test_result_value.split("##");
//										test_result_content.append("<label style='color:black;font-size:9'>");
										if(test_result.length>1){
										 for(int j=0;j<test_result.length;j++){
										    lab_test_result_grp= test_result[j];
											strToken = new StringTokenizer(lab_test_result_grp,"$$");
											token_value = "";
											prev_token  = "";
											while(strToken.hasMoreTokens())
											{
												//test_result_content.append(strToken.nextToken()+"&nbsp;&nbsp;");
											token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:12'>");
											}else if(token_value.equals("High")){
											test_result_content.append("<label style='color:red;font-size:12'>");
											}else if(prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("<label style='color:#9900ff;font-size:12'>");
											}

											if(!token_value.equals("A") && !token_value.equals("N"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");

											if(token_value.equals("Low") || token_value.equals("High") || prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("</label>");
											}
											prev_token =token_value;
											//	test_result_content.append(strToken.nextToken()+"&nbsp;&nbsp;");

											}
											test_result_content.append("<br><br>");
										 }
										}else{

											lab_test_result_grp= test_result[0];
										
										strToken = new StringTokenizer(lab_test_result_grp,"$$");
										token_value = "";
										prev_token  = "";
										while(strToken.hasMoreTokens())
											{
											 /*token_value = strToken.nextToken();
											 test_result_content.append(token_value+"&nbsp;&nbsp;");*/
											 token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:12'>");
											}else if(token_value.equals("High")){
											test_result_content.append("<label style='color:red;font-size:12'>");
											}else if(prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("<label style='color:#9900ff;font-size:12'>");
											}

											if(!token_value.equals("A") && !token_value.equals("N"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");

											if(token_value.equals("Low") || token_value.equals("High") || prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("</label>");
											}
											prev_token =token_value;
											}
											test_result_content.append("<br><br>");
										}
										//test_result_content.append("</label>");
									  }
				//MMS-KH-CRF-0034.4 - end
									}

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(intr_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
											if(interaction_type.equals("F")){  
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
										}
										else if(interaction_type.equals("L")){  
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
										}else if(intr_option.equals("D")){

            _bw.write(_wl_block19Bytes, _wl_block19);

										}
										else{

            _bw.write(_wl_block20Bytes, _wl_block20);

										}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(intr_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_dosage_display));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(form_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

										if(severity_level.equals("H")){

            _bw.write(_wl_block25Bytes, _wl_block25);

										}
										else if(severity_level.equals("M")){

            _bw.write(_wl_block26Bytes, _wl_block26);

										}
										else if(severity_level.equals("L")){

            _bw.write(_wl_block27Bytes, _wl_block27);

										}

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(significant_level));
            _bw.write(_wl_block29Bytes, _wl_block29);
							                      
									

										if(probability.equals("E")){

            _bw.write(_wl_block30Bytes, _wl_block30);

										}
										else if(probability.equals("P")){

            _bw.write(_wl_block31Bytes, _wl_block31);

										}
										else if(probability.equals("S")){

            _bw.write(_wl_block32Bytes, _wl_block32);

										}
										else if(probability.equals("O")){

            _bw.write(_wl_block33Bytes, _wl_block33);

										}
										else if(probability.equals("U")){

            _bw.write(_wl_block34Bytes, _wl_block34);

										}

            _bw.write(_wl_block35Bytes, _wl_block35);

									if(restrict_transaction.equals("Y")){

            _bw.write(_wl_block36Bytes, _wl_block36);

									}
									else if(restrict_transaction.equals("N")){

            _bw.write(_wl_block37Bytes, _wl_block37);

									}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(interaction_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);

									if(interaction_type.equals("L")){
								
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(test_result_content.toString()));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);

							}
						}

            _bw.write(_wl_block43Bytes, _wl_block43);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugInteraction.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InteractionType.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FoodIngredient.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.LabOrderCatalog.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
