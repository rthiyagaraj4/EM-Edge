package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __multipatientordersframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/MultiPatientOrdersFrameSet.jsp", 1709119742000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<Script>\n\tdocument.location.href = \"../../eOR/jsp/EnterOrder.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n</script>\n</html>\n\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
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
 
/*
-----------------------------------------------------------------------
Date       	Edit History   Name        Description
-----------------------------------------------------------------------
  ?             100            ?           created

28/01/2012	IN030566	Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.								  
-----------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block1Bytes, _wl_block1);


	String multi_bean_id 				= request.getParameter("bean_id");
	String multi_bean_name 				= request.getParameter("bean_name");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	//MultiPatientOrdersBean multi_bean		= (MultiPatientOrdersBean)mh.getBeanObject( multi_bean_id, request,  multi_bean_name ) ;
	MultiPatientOrdersBean multi_bean		 = (MultiPatientOrdersBean)getBeanObject( multi_bean_id, multi_bean_name, request ) ;
	//MultiPatientOrdersBean multi_bean = (MultiPatientOrdersBean)getObjectFromBean(multi_bean_id, multi_bean_name,session);
	multi_bean.setLanguageId(localeName);

	String qryString						= multi_bean.getQryString();
	    /* Till here*/
	// Set the Patient_ids here
	ArrayList arr_patient_id		 = new ArrayList();

	/****Fetching Values from MultiPatientOrdersHdrResult.jsp on Press of Select*****/
	//arrylist to retreive all the details and is pssd as a parameter to arr_patient_id
	//ArrayList arr_checked_pat=new ArrayList();

	String recCntStr = request.getParameter("recCount");
	if(recCntStr == null || recCntStr.equals("")) recCntStr = "0";

	String encounterId = request.getParameter("encounter_id");
	if(encounterId == null || encounterId.equals("")) encounterId = "0";

	String patient_class = request.getParameter("patient_class");
	if(patient_class == null || patient_class.equals("")) patient_class = "0";

	String location_type = request.getParameter("source_type");
	String location_code = request.getParameter("source_code");
	String locn_type = request.getParameter("locn_type");
	String locn_code = request.getParameter("locn_code");
	String patientId = request.getParameter("patientId");
	String speciality_code = request.getParameter("speciality_code");
	String include_checkout_patients = request.getParameter("include_checkout_patients");
	String patientIds = "";
	String episodeId= "";
	String episodevisit = "";
	String patClass = "";
	String encounterIds = "";
	String s_patient_id = "",s_encounter_id = "",	s_pat_class = "",s_episode_id = "",s_episode_visit_num = ""; 
	if(location_type == null || location_type.equals(""))location_type="";
	if(location_code == null || location_code.equals(""))location_code="";
	if(patientId == null || patientId.equals(""))patientId="";
	if(speciality_code == null || speciality_code.equals(""))speciality_code="";	
	if(include_checkout_patients == null || include_checkout_patients.equals(""))include_checkout_patients="";	
	int count	= 0;
	//qryString		+= "&p_option_function_name=EXTERNAL&p_function_name=MULTI_PATIENT_ORDERS&function_from=MULTI_PATIENT_ORDERS&location_type="+location_type+"&location_code="+location_code;
	//qryString		=qryString+ "&p_option_function_name=EXTERNAL&p_function_name=MULTI_PATIENT_ORDERS&function_from=MULTI_PATIENT_ORDERS&location_type="+location_type+"&location_code="+location_code;
	qryString		= "p_called_from_ca=Y&option_id=MULTIPATIENTORDER&p_option_function_name=EXTERNAL&p_function_name=MULTI_PATIENT_ORDERS&function_from=MULTI_PATIENT_ORDERS&location_type="+location_type+"&location_code="+location_code+"&speciality_code="+speciality_code+"&patientId="+patientId+"&locn_code="+locn_code+"&locn_type="+locn_type+"&include_checkout_patients="+include_checkout_patients;
	multi_bean.setQryString(qryString);
	String [] record = null;
	if(!recCntStr.equals("0")){
		String patient_id = "", selectStr ="",encounter_id="",pat_class="";
		String episode_id = "", episode_visit_num = "";
		int recCnt = Integer.parseInt(recCntStr);
		for(int i=0; i<recCnt; i++){
			selectStr = request.getParameter("chk"+i);
			if(selectStr == null || selectStr.equals("")) {
				selectStr="N";
			}else if(selectStr.equals("Y")){

				record = new String [5];

				patient_id = request.getParameter("patient_id"+i);
				//[IN030566] Starts
				try{			
					if((session.getAttribute("TEMP_PASS")!=null) && (session.getAttribute("TEMP_PASS")!="")){
						HashMap mHash = new HashMap();
						mHash = (HashMap) session.getAttribute("TEMP_PASS");
						if(mHash.containsKey(patient_id)){
							mHash.remove(patient_id);
						}
						session.setAttribute("TEMP_PASS",mHash);
					}
				}catch(Exception ee)
				{	
					out.println("Exception in MultiPatientOrdersFrameSet.jsp for TEMP_PASS Session-- "+ee.toString()+"--");
					ee.printStackTrace();
				}
				//[IN030566] Ends
				encounter_id=request.getParameter("encounter_id"+i);
				pat_class=request.getParameter("patient_class"+i);
				episode_id= request.getParameter("episode_id"+i);
				episode_visit_num=request.getParameter("episode_visit_num"+i);
				s_patient_id = patient_id;
				s_encounter_id = encounter_id;
				s_pat_class = pat_class;
				s_episode_id = episode_id;
				s_episode_visit_num = episode_visit_num;
				if(s_patient_id == null || s_patient_id.equals("null")) s_patient_id="";
				if(s_encounter_id == null || s_encounter_id.equals("null")) s_encounter_id="";
				if(s_pat_class == null || s_pat_class.equals("null")) s_pat_class="";
				if(s_episode_id == null || s_episode_id.equals("null")) s_episode_id="";
				if(s_episode_visit_num == null || s_episode_visit_num.equals("null")) s_episode_visit_num="";
				if(s_episode_id.equals(""))s_episode_id=s_encounter_id;	 
				if(patient_id == null || patient_id.equals("null")) patient_id="~";
				if(encounter_id == null || encounter_id.equals("null")) encounter_id="~";
				if(pat_class == null || pat_class.equals("null")) pat_class="~";
				if(episode_id == null || episode_id.equals("null")) episode_id="~";
				if(episode_visit_num == null || episode_visit_num.equals("null")) episode_visit_num="~";
				if(episode_id.equals(""))episode_id=encounter_id;
				record[0]		= s_patient_id;
				record[1]		= s_encounter_id;
				record[2]		= s_episode_id;
				record[3]		= s_episode_visit_num;
				record[4]		= s_pat_class;
				if(patientIds.equals(""))
				{
					patientIds = patient_id+"!$!";
					encounterIds = encounter_id+"!$!";
					episodeId = episode_id+"!$!";
					episodevisit = episode_visit_num+"!$!";
					patClass = pat_class+"!$!";
				}
				else
				{
					patientIds = patientIds+patient_id+"!$!";
					encounterIds = encounterIds+encounter_id+"!$!";
					episodeId = episodeId+episode_id+"!$!";
					episodevisit = episodevisit+episode_visit_num+"!$!";
					patClass = patClass+pat_class+"!$!";
				}
				multi_bean.setPatString(patientIds);
				multi_bean.setEncString(encounterIds);
				multi_bean.setEpiString(episodeId);
				multi_bean.setVisitString(episodevisit);
				multi_bean.setPatClassString(patClass);
				//out.println("<script>alert('here')</script>");
				if (count == 0) {
					//qryString += "&patient_id="+patient_id+"&encounter_id=" + encounter_id+"&patient_class=" + pat_class+"&episode_id=" + encounter_id ;
					qryString =qryString+ "&patient_id="+s_patient_id+"&encounter_id=" + s_encounter_id+"&patient_class=" + s_pat_class+"&episode_id=" + s_encounter_id ;
				}
				arr_patient_id.add(record);
				count++;
			}
		}
		multi_bean.setMultiPatientDetails(arr_patient_id);
	}
  
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(qryString));
            _bw.write(_wl_block11Bytes, _wl_block11);

 
		// set it back persistence
		putObjectInBean(multi_bean_id,multi_bean,request);
		//putObjectInBean(multi_bean_id,multi_bean,session);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderEntryMultiPatientOrders.label", java.lang.String .class,"key"));
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
