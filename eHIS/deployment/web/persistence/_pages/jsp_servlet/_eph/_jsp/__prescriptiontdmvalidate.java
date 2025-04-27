package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import eST.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __prescriptiontdmvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionTDMValidate.jsp", 1732509676117L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

try 
{
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String identity		  = request.getParameter( "identity" );
	String order_id		  = request.getParameter( "order_id" );
	String order_line_num		  = request.getParameter( "order_line_num" );
	String bean_id		  = request.getParameter( "bean_id" ) ;
	String bean_name	  = request.getParameter( "bean_name" ) ; 
	String strSampType	  = request.getParameter( "samp_type" );
	String strDrugCode	  = request.getParameter("drug_code");
	String strLdObj		  = request.getParameter("ldObj");
	if(strLdObj == null){strLdObj="";}
	String strIdxNo		  = request.getParameter("IdxNo");
	

	PrescriptionTDMBean bean	= (PrescriptionTDMBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);

	Hashtable htLabTests = new Hashtable();
	ArrayList alDrugDur  = new ArrayList();

	if(identity != null && identity.equals("getLabTest") )
	{
		htLabTests	= bean.getLabTests2(strDrugCode,strSampType);
		if(htLabTests.size()==0){
          out.println("chkTdmAttributes();");
        }
		alDrugDur	= bean.getDrugDuration(strSampType);
		Enumeration enTemp = htLabTests.keys();
		
		String strcode ="";
		String strdesc = "";
		String dur_val=(String)alDrugDur.get(0);
		if(dur_val == null){dur_val="";}
		out.println("assignDurationValues('"+strIdxNo+"','"+dur_val+"');");
		out.println("assignDurationTypes('"+strIdxNo+"','"+(String)alDrugDur.get(1)+"');");

		out.println("clearData(document.formTDMAdminDetls."+strLdObj+");");
		
		while (enTemp.hasMoreElements() )
		{
			strcode = (String) enTemp.nextElement();
			strdesc = (String) htLabTests.get(strcode);
		 out.println("addOption('"+strcode+"','"+strdesc+"',document.formTDMAdminDetls."+strLdObj+");");

		}

	}
		if(identity != null && identity.equals("getLabTesttrough") )
	{
		htLabTests	= bean.getLabTests2(strDrugCode,strSampType);
		alDrugDur	= bean.getDrugDuration(strSampType);
		Enumeration enTemp = htLabTests.keys();
		
		String strcode ="";
		String strdesc = "";
		String dur_val=(String)alDrugDur.get(0);
		if(dur_val == null){dur_val="";}
		out.println("assignTroughDurationValues('"+strIdxNo+"','"+dur_val+"');");
		out.println("assignTroughDurationTypes('"+strIdxNo+"','"+(String)alDrugDur.get(1)+"');");

		out.println("clearData(document.formTDMAdminDetls."+strLdObj+");");
		while (enTemp.hasMoreElements() ){
			strcode = (String) enTemp.nextElement();
			strdesc = (String) htLabTests.get(strcode);
			out.println("addOption('"+strcode+"','"+strdesc+"',document.formTDMAdminDetls."+strLdObj+");");
		}
	}
	if(identity != null && identity.equals("getLabTestrandom") ){
		htLabTests	= bean.getLabTests2(strDrugCode,strSampType);

		alDrugDur	= bean.getDrugDuration(strSampType);

		Enumeration enTemp = htLabTests.keys();
		
		String strcode ="";
		String strdesc = "";
		String dur_val=(String)alDrugDur.get(0);
		if(dur_val == null){dur_val="";}
		out.println("assignRandomDurationValues('"+strIdxNo+"','"+dur_val+"');");
		out.println("assignRandomDurationTypes('"+strIdxNo+"','"+(String)alDrugDur.get(1)+"');");

		out.println("clearData(document.formTDMAdminDetls."+strLdObj+");");
		while (enTemp.hasMoreElements() )
		{
			strcode = (String) enTemp.nextElement();
			strdesc = (String) htLabTests.get(strcode);
			out.println("addOption('"+strcode+"','"+strdesc+"',document.formTDMAdminDetls."+strLdObj+");");

		}

	}
		if(identity != null && identity.equals("getLabTestextended") )
	{
		htLabTests	= bean.getLabTests2(strDrugCode,strSampType);

		alDrugDur	= bean.getDrugDuration(strSampType);

		Enumeration enTemp = htLabTests.keys();
		
		String strcode ="";
		String strdesc = "";
		String dur_val=(String)alDrugDur.get(0);
		if(dur_val == null){dur_val="";}
		out.println("assignExtendedDurationValues('"+strIdxNo+"','"+dur_val+"');");
		out.println("assignExtendedDurationTypes('"+strIdxNo+"','"+(String)alDrugDur.get(1)+"');");

		out.println("clearData(document.formTDMAdminDetls."+strLdObj+");");
		while (enTemp.hasMoreElements() )
		{
			strcode = (String) enTemp.nextElement();
			strdesc = (String) htLabTests.get(strcode);
			out.println("addOption('"+strcode+"','"+strdesc+"',document.formTDMAdminDetls."+strLdObj+");");

		}

	}
	if(identity != null && identity.equals("getUpdatedStatus") )
	{
		ArrayList record		= new ArrayList();
		HashMap order_details	= new HashMap();
		String sch_dose_date    = "";
	String sch_dose_time	= "";
	String order_catalog_code="";
	String order_catalog_desc="";
	String sampling_type	= "";
	String sampling_durn	= "";
	String sampling_durn_type="";
	String sampling_indicator="";
	String date				= "";
		ArrayList alOrdDetl		= new ArrayList();
		alOrdDetl = bean.getOrderDetails();
		int nAlSize = 0;
		nAlSize = alOrdDetl.size();
		record= bean.getOrderDetails(order_id,order_line_num);
		int nOrdCtr = 0;
		int nOrdCtr1 = 0;
		int nOrdCtr2 = 0;
		int nOrdCtr3 = 0;
		int nCtr = 0;
			//int nAlSize = 0;
	if(record != null)
	{
		for(nCtr = 0; nCtr < nAlSize; nCtr+=5)
			{
			 //String 	strOrdDate		= (String) alOrdDetl.get(nCtr);
			//String 	strOrdTime		= (String) alOrdDetl.get(nCtr+1);
				//String strOrdDose		= (String) alOrdDetl.get(nCtr+2);
				String sch_date_time	= (String) alOrdDetl.get(nCtr+3);
				  nOrdCtr++;
				  nOrdCtr1++;
				  nOrdCtr2++;
				  nOrdCtr3++;
		for(int i=0;i<record.size();i++){
			
			 order_details		=(HashMap)record.get(i);

			 date				=(String)order_details.get("SCH_DATE_TIME");
			sch_dose_date		=(String)order_details.get("SCH_DOSE_DATE");
			sch_dose_time		=(String)order_details.get("SCH_DOSE_TIME");
			order_catalog_code	=(String)order_details.get("ORDER_CATALOG_CODE");
			order_catalog_desc 	=(String)order_details.get("ORDER_CATALOG_DESC");
			sampling_type		=(String)order_details.get("SAMPLING_TYPE");
			sampling_durn=(String)order_details.get("SAMPLING_DURN");
			sampling_durn_type=(String)order_details.get("SAMPLING_DURN_TYPE");
			sampling_indicator=(String)order_details.get("SAMPLING_INDICATOR");
			
			
			if(date.equals(sch_date_time))
			{
			 if(sampling_type.equals("T")){
				//out.println("assignTroughvalue('"+nOrdCtr+"','"+sampling_durn+"','"+sampling_durn_type+"','"+order_catalog_code+"','"+order_catalog_desc+"');");
				out.println("assignTroughvalue('"+nOrdCtr+"','"+sampling_durn+"','"+sampling_durn_type+"','"+order_catalog_code+"','"+order_catalog_desc+"','"+sampling_indicator+"');");
				 //nOrdCtr++;
			 }
			if(sampling_type.equals("P")){
			out.println("assignPeakvalue('"+nOrdCtr1+"','"+sampling_durn+"','"+sampling_durn_type+"','"+order_catalog_code+"','"+order_catalog_desc+"','"+sampling_indicator+"');");
				 // nOrdCtr1++;
			 }
			 if(sampling_type.equals("R")){
				out.println("assignRandomvalue('"+nOrdCtr2+"','"+sampling_durn+"','"+sampling_durn_type+"','"+order_catalog_code+"','"+order_catalog_desc+"','"+sampling_indicator+"');");
				  //nOrdCtr2++;
			 }
			 if(sampling_type.equals("E")){
			out.println("assignExtendedvalue('"+nOrdCtr3+"','"+sampling_durn+"','"+sampling_durn_type+"','"+order_catalog_code+"','"+order_catalog_desc+"','"+sampling_indicator+"');");
				  //nOrdCtr3++;
			 }
			}
		}
	}}
	}
	putObjectInBean(bean_id,bean,request);

}
catch (Exception e)
{

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
}
