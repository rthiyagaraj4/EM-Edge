package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.lang.*;
import eST.Common.*;
import eST.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __srrconsumptionreportvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SRRConsumptionReportValidate.jsp", 1732511901764L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	String bean_id = request.getParameter("bean_id");
	//String bean_name = request.getParameter("bean_name");

	int functionType = Integer.parseInt(request.getParameter("function_type"));
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	String report_type = request.getParameter("report_type");
	switch (functionType) {
	case 1:
		{
			if(report_type.equals("C"))	
			{
			    out.println("clearListItems('document.formConsumptionReportQueryCriteria.p_report_idS'); ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCONS1"+ "\",\"" +"Item Consolidated"+ "\") ; ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCONS2"+ "\",\"" +"By Store"+ "\") ; ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCONS3"+ "\",\"" +"By Store-Item Class"+ "\") ; ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCONS4"+ "\",\"" +"By Item Class"+ "\") ; ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCONS5"+ "\",\"" +"By Item"+ "\") ; ");
			}else
					if(report_type.equals("CD"))	
			{
				out.println("clearListItems('document.formConsumptionReportQueryCriteria.p_report_idS'); ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCNDST"+ "\",\"" +"By Store"+ "\") ; ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCNDIC"+ "\",\"" +"Item Consolidated"+ "\") ; ");
			
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCNDIT"+ "\",\"" +"By Item"+ "\") ; ");
			
			}
		 	else if(report_type.equals("ATC"))
			{
			   out.println("clearListItems('document.formConsumptionReportQueryCriteria.p_report_idS'); ");
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"ATCS1"+ "\",\"" +"Anatomical Class"+ "\") ; ");
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"ATCS2"+ "\",\"" +"Therapeutic Main Class"+ "\") ; ");
			
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"ATCS3"+ "\",\"" +"Therapeutic Sub Class"+ "\") ; ");
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"ATCS4"+ "\",\"" +"Chemical Mian Class"+ "\") ; ");
			
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"ATCS5"+ "\",\"" +"Chemical Sub Class"+ "\") ; ");
			}else
			{

				 out.println("clearListItems('document.formConsumptionReportQueryCriteria.p_report_idS'); ");
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"1"+ "\",\"" +"Item Analysis 1"+ "\") ; ");
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"2"+ "\",\"" +"Item Analysis 2"+ "\") ; ");
			
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"3"+ "\",\"" +"Item Analysis 3"+ "\") ; ");
				



			 }
				
			
		}
		break;
		default :
		{
				out.println("alert(\'Invalid Function\');");
			return;
		}
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
