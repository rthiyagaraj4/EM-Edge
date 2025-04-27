package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ivprescriptiondetailsframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVPrescriptionDetailsFrame.jsp", 1732100012426L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<!-- ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<HTML>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<!-- <FRAMESET ROWS=\"50,23,27\" FRAMESPACING=\"0\"> -->\t\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<IFRAME name=\"f_iv_drug_details\" id=\"f_iv_drug_details\" FRAMEBORDER=\"0\" SCROLLING=\"no\" NORESIZE SRC=\"IVPrescriptionDrugDetailFrames.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" style=\'height:46vh;width:98vw\'></IFRAME>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<IFRAME name=\"f_iv_drug_details\" id=\"f_iv_drug_details\" FRAMEBORDER=\"0\" SCROLLING=\"no\" NORESIZE SRC=\"../../eCommon/html/blank.html\" style=\'height:46vh;width:98vw\'></IFRAME>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<IFRAME name=\"f_iv_fluid\" id=\"f_iv_fluid\" FRAMEBORDER=\"0\" SCROLLING=\"no\" NORESIZE SRC=\"IVPrescriptionFluidDetail.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" style=\'height:17vh;width:99vw\'></IFRAME>\n\t\t<IFRAME name=\"f_iv_admin\" id=\"f_iv_admin\" FRAMEBORDER=\"0\" SCROLLING=\"no\" NORESIZE SRC=\"IVPrescriptionAdminDetail.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" style=\'height:24vh;width:99vw\'></IFRAME>\n\t<!-- </FRAMESET> -->\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
	
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

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
11/08/2020      IN072753           Prabha		11/08/2020     Manickam					NMC-JD-CRF-0046
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block8Bytes, _wl_block8);
	
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String params			= request.getQueryString() ;
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String weight= request.getParameter("weight");//Added for IN:070451
	String bsa= request.getParameter("bsa");//Added for IN:070451
	String order_type_flag = request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String prev_order = request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String start_date_time = "";
	String iv_prep_yn			= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	String location_type		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	String priority				= request.getParameter("priority")==null?"":request.getParameter("priority");
	
	iv_prep_yn = iv_prep_yn.trim();
	
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request) ;
	bean.clear();	

	bean.setOrder_type_flag(order_type_flag);
	bean.setPatientClass(patient_class);
	//Added For NMC-JD-CRF-0046
  if(!order_type_flag.equals("Existing")){
 	ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added empty parameter for Bru-HIMS-CRF-347 [IN:037862] -- Begin ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
	if(ord_disp_location != null & ord_disp_location.size()>0){ 
		bean.setDisplocn((String)ord_disp_location.get(0));  
		bean.setDisp_locn_code((String)ord_disp_location.get(0)); 
	} 
	} 
//Added For NMC-JD-CRF-0046
	if(prev_order.equals("previous"))
		bean.setIS_COPY_ORDER(true);
	else
		bean.setIS_COPY_ORDER(false);
	
	if(order_type_flag.equals("Existing")){
		String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String answer = request.getParameter("answer")==null?"":request.getParameter("answer"); 
		ArrayList exstngIVorder = new ArrayList();
		HashMap record = null; 
		StringBuffer drugCodes = new StringBuffer();
		String act_pat_class = request.getParameter("act_pat_class")== null?"": request.getParameter("act_pat_class");  //RUT-CRF-0062 Added to get the Build MAR Rule
		exstngIVorder = (ArrayList)bean.getExistingIVRecords(order_id,answer,act_pat_class); //passed answer for IN24251 --16/12/2010-- priya  // RUT-CRF-0062
		for(int i=1;i<exstngIVorder.size();i++){
			record = new HashMap();
			record = (HashMap)exstngIVorder.get(i);
			drugCodes.append(record.get("ORDER_CATALOG_CODE"));
			drugCodes.append(",");
			start_date_time = (String)record.get("START_DATE_TIME");
		}

		bean.setPatId(patient_id);
		bean.setSTART_DATE_TIME(start_date_time);
		bean.setWeight(weight);//Added for IN:070451
		bean.setBSA(bsa);//Added for IN:070451
		bean.setDrugDetails(drugCodes.toString(),"","","","","","");  //CRF-0062 
		bean.setAllExistingIVOrders(exstngIVorder);
	}

	String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
	String search_bean_name		= "ePH.DrugSearchBean";
	DrugSearchBean searchbean	= (DrugSearchBean)getBeanObject(search_bean_id,search_bean_name,request);	
	searchbean.clear();	
	putObjectInBean(search_bean_id,searchbean,request);

            _bw.write(_wl_block9Bytes, _wl_block9);
		
		if(!order_type_flag.equals("Existing")){

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( params ));
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else{

            _bw.write(_wl_block12Bytes, _wl_block12);

		}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( params ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( params ));
            _bw.write(_wl_block15Bytes, _wl_block15);
 
	putObjectInBean(bean_id,bean,request); 

            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
