package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOH.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __resultentry extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/ResultEntry.jsp", 1709117127598L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!-- <frameset rows=\'16%,10%,5%,*%,6%,0%\'> -->\n<frameset rows=\'16%,10%,*%,6%,0%\'>\n\t<frame name=\'ResultEntryTop\' src=\'ResultEntryTop.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0  noresize scrolling=auto>\n\t<frame name=\'ResultEntryReport\' src=\'ResultEntryReport.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' frameborder=0  noresize  scrolling=auto>\n\t<!-- <frame name=\'ResultEntryHeader\' src=\'ResultEntryHeader.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' frameborder=0 scrolling=auto noresize> -->\n\t<frame name=\'ResultEntryDtl\' src=\'ResultEntryDetail.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=0 scrolling=auto>\n\t<frame name=\'ResultEntryBtn\' src=\'ResultEntryBtn.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=0 scrolling=no>\n\t<frame name=\'messageFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=no>\n</frameset>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<frameset rows=\'15%,84%,6%\'>\n\t<frame name=\'ResultEntryTop\' src=\'ResultEntryTop.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' frameborder=0  noresize scrolling=auto>\n\t<frameset cols =\'14%,*%\'>\n\t\t<frame name=\'ResultEntryFrequency\' src=\'ResultEntryFrequency.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' frameborder=0  noresize >\n\t\t<!-- <frameset rows=\'12%,7%,*%\'> -->\n\t\t<frameset rows=\'12%,*%\'>\n\t\t\t<frame name=\'ResultEntryReport\' src=\'../../eCommon/html/blank.html\' frameborder=0  noresize  scrolling=auto>\n\t\t<!-- \t<frame name=\'ResultEntryHeader\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=auto noresize> -->\n\t\t\t<frame name=\'ResultEntryDtl\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=auto>\n\t\t</frameset>\n\t</frameset>\n\t<frame name=\'ResultEntryBtn\' src=\'ResultEntryBtn.jsp?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&freqExplApplies=Y&showRecordButton=N\' frameborder=0 scrolling=no>\n</frameset>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	/* Mandatory checks start */
	String mode	= "1";//request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String func_type	= request.getParameter("func_type");
	if (func_type == null) func_type = "";
	String bean_id = "Oh_ResultEntry" ;
	String bean_name = "eOH.ResultEntryBean";
	/* Mandatory checks end */
	/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.clearForRecord(); //Added by prasad on 2/5/2007

	bean.setFunc_type(func_type);
	/* Initialize Function specific end */

	 String task_type = request.getParameter("colval1");
	 String orderId = request.getParameter("orderId");
	 String order_line_num = request.getParameter("order_line_num");
	 String patient_id = request.getParameter("patient_id");
	 String patient_class = request.getParameter("patient_class");
	 String encounter_id = request.getParameter("encounter_id");
	
	 String colval = request.getParameter("colval");
	 if (colval==null||colval.equals("null")||colval=="")
	 {
		 colval="";
	 }
	 //colval = java.net.URLDecoder.decode(colval,"UTF-8");
	 String requestFrom = request.getParameter("requestFrom");
	 String report_srl_no = request.getParameter("report_srl_no");
	 String order_category = request.getParameter("order_category");
	 String sex = request.getParameter("sex");
	 String from = request.getParameter("from");
	 String header_values = request.getParameter("header_values");
	 String resultReportingURL = request.getQueryString();
	/********this two parameters will have values only when called from task list *****/
	 String child_order_index = request.getParameter("TLchild_order_index");
	 String child_reporting_date = request.getParameter("TLchild_reporting_date");
	 if(child_order_index==null)	child_order_index="";
	 if(child_reporting_date==null)	child_reporting_date="";
	 /*************/
	
	 if(requestFrom==null)	requestFrom="";
	 if(patient_id==null)	patient_id="";
	 if(encounter_id==null)	encounter_id="";
	 if(report_srl_no==null)	report_srl_no="";
	 if (order_category==null) order_category="";
		
	 StringBuffer qryStr=new StringBuffer(); 
	qryStr.append("orderId="+orderId+"&function_id="+function_id+"&order_line_num="+order_line_num+"&from="+from);

	 if(requestFrom.trim().equalsIgnoreCase("RA"))
		qryStr.append( "&task_type=ResultEntry"+"&report_srl_no="+report_srl_no+"&requestFrom="+requestFrom+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class);
	 else	qryStr.append( "&task_type="+task_type+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&TLchild_order_index="+child_order_index+"&TLchild_reporting_date="+ child_reporting_date);
	 
	 qryStr.append("&order_category="+order_category+"&sex="+sex+"&colval="+colval);

	boolean freqExplApplies = true;
	freqExplApplies = bean.checkFreqExplosion(orderId);

	//out.println("<script>alert('=freqExplApplies=="+freqExplApplies+"==requestFrom="+requestFrom+"====')</script>");
//out.println("<script>alert('=qryStr=="+qryStr+"=======')</script>");

	
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
if(!freqExplApplies || requestFrom.trim().equalsIgnoreCase("RA")){
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resultReportingURL));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(resultReportingURL));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(header_values));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resultReportingURL));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{ 

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(resultReportingURL));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(header_values));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(resultReportingURL));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(qryStr));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
	putObjectInBean(bean_id,bean,request);	

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ResultEntry.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
