package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.SalesAndReturnHistoryBean;
import java.util.Hashtable;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __salesandsalesreturnreportvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SalesAndSalesReturnReportValidate.jsp", 1720013163685L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
13/04/2018								Soorya Prakash M 						  							KDAH-CRF-0380  Sale/Sale Return Report
--------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	SalesAndReturnHistoryBean bean = (SalesAndReturnHistoryBean)getBeanObject( "SalesAndReturnHistoryBean","eST.SalesAndReturnHistoryBean", request ) ;  
	String validate		=	request.getParameter("validate");
	String trn_type	=	request.getParameter("trn_type");
	System.out.println("trn_type--->" + trn_type);
	String start_date = request.getParameter("start_date");
	System.out.println("start_date--->" + start_date);
	String end_date = request.getParameter("end_date");
	System.out.println("end_date--->" + end_date);
	

	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String message			=	"";
	String flag				=	"";
	String patient_id				=	request.getParameter("patient_id");
	System.out.println("patient_id--->" + patient_id);


	
	boolean	result					=	false;
	try {
		 if (validate.equals("PATIENT_NAME")){


			if (patient_id.trim().equals("")) {
				out.println("setPatientName('','');");
				result			=	true;
				return ;
			}
			try{
				out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\",\""+bean.getPatientNationality(patient_id)+"\")");
			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
				out.println("setPatientName('','');");
			}
		}
		
		
		if (validate.equals("POPULATE_RETURN_DOC_TYPE_CODE")){
	
			out.println("clearListItems('document.formSalesAndSalesReturnReport.p_sal_doc_type'); ");
			
			ArrayList stParameters = new ArrayList();
			stParameters.add(bean.getLoginFacilityId());			
			stParameters.add(trn_type);
			stParameters.add(bean.getLanguageId());

			ArrayList alEncounterList = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),stParameters);
			for(int i=0; i< alEncounterList.size(); i++) {
				HashMap record	=	(HashMap)alEncounterList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String desc	=	(String)record.get("SHORT_DESC");
			    out.println("addListItem(\"document.formSalesAndSalesReturnReport.p_sal_doc_type\", \"" +listRecord+ "\",\"" +desc+ "\"); ");
			}

		}

		if (validate.equals("POPULATE_SALES_DOC_TYPE_CODE")){

			out.println("clearListItems('document.formSalesAndSalesReturnReport.p_sal_doc_type'); ");
			
			ArrayList stParameters = new ArrayList();
			stParameters.add(bean.getLoginFacilityId());			
			stParameters.add(trn_type);
			stParameters.add(bean.getLanguageId());
			ArrayList alEncounterList = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),stParameters);
			for(int i=0; i< alEncounterList.size(); i++) {
				HashMap record	=	(HashMap)alEncounterList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String desc	=	(String)record.get("SHORT_DESC");
			    out.println("addListItem(\"document.formSalesAndSalesReturnReport.p_sal_doc_type\", \"" +listRecord+ "\",\"" +desc+ "\"); ");
			}

		}
		if (validate.equals("POPULATE_BOTH_DOC_TYPE_CODE")){

			out.println("clearListItems('document.formSalesAndSalesReturnReport.p_sal_doc_type'); ");
			
			ArrayList stParameters = new ArrayList();
			stParameters.add(bean.getLoginFacilityId());			


			ArrayList alEncounterList = bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST8"),stParameters);
			for(int i=0; i< alEncounterList.size(); i++) {
				HashMap record	=	(HashMap)alEncounterList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String desc	=	(String)record.get("SHORT_DESC");
			    out.println("addListItem(\"document.formSalesAndSalesReturnReport.p_sal_doc_type\", \"" +listRecord+ "\",\"" +desc+ "\"); ");
			}

		}
		if (validate.equals("CHECK_DOC_DATE")){
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        	Date fdate=format.parse(start_date); 
   			 	Date tdate=format.parse(end_date);
      			long diffInDays =  tdate.getTime() - fdate.getTime();
				long differenceInDays =  (diffInDays / (24 * 60 * 60 * 1000));
      			System.out.println("differenceInDays---->" + differenceInDays);
				if(differenceInDays >90)
					result= false;
				else
				result=true;
      			}

	}

	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
	

            _bw.write(_wl_block3Bytes, _wl_block3);

//putObjectInBean("SalesAndHistoryBean",bean,request);

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
