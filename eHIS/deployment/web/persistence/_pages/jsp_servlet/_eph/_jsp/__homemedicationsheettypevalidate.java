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
import java.text.DecimalFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __homemedicationsheettypevalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/HomeMedicationSheetTypeValidate.jsp", 1732509411097L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	try {
		String identity		  = request.getParameter( "identity" );
		Hashtable hash		  = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash				  = (Hashtable)hash.get( "SEARCH" ) ;
		if(identity.equals("InsertMode")){
			String select_option	= (String) hash.get("select_option");
			String bean_id		  = hash.get( "bean_id" ).toString() ;
			String bean_name	  = hash.get( "bean_name" ).toString() ;
			HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);
			//bean.clear();//Commented for RUT-CRF-0061 [IN:45785]
			List<String> form_code_List = Arrays.asList(hash.get("selected_Array").toString()); 
			List<String> unchecked_formcode_List = Arrays.asList("");
			bean.setSelectedOption(select_option);
			bean.setFormCodeList(form_code_List,unchecked_formcode_List); 
			HashMap result=bean.insert();
			String message=result.get("message").toString();
			out.println("'"+message+"'");
			putObjectInBean(bean_id,bean,request);
		}
		else if(identity.equals("ModifyMode")){
			String select_option	= (String) hash.get("select_option");
			String bean_id		  = hash.get( "bean_id" ).toString() ;
			String bean_name	  = hash.get( "bean_name" ).toString() ;
			HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);
			bean.clear();//Commented for RUT-CRF-0061 [IN:45785]
			List<String> form_code_List = Arrays.asList(hash.get("selected_Array").toString()); 
			List<String> unchecked_formcode_List = Arrays.asList(hash.get("uncheck_data").toString());
			bean.setSelectedOption(select_option);
			bean.setFormCodeList(form_code_List,unchecked_formcode_List); // Commented for RUT-SCF-0358[IN:46704]
			bean.setUncheckedData(unchecked_formcode_List,form_code_List);// Commented for RUT-SCF-0358[IN:46704]
			ArrayList unchechdata=bean.getUncheckedData();
			HashMap result=bean.modify();
			String message=result.get("message").toString();
			out.println("'"+message+"'");
			putObjectInBean(bean_id,bean,request);
		}
		else if(identity.equals("Store_select")){//Added for RUT-CRF-0061 [IN:45785] - Start
			String bean_id		  = hash.get( "bean_id" ).toString() ;
			String bean_name	  = hash.get( "bean_name" ).toString() ;
			HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);
			List<String> check_associate_data=new ArrayList();
			List<String> uncheck_associate_data =new ArrayList();
			List<String> form_code_List = Arrays.asList(hash.get("selected_Array").toString());
			List<String> unchecked_formcode_List = Arrays.asList(hash.get("uncheck_data").toString());
			
			if(!hash.get("check_associate_data").toString().equals(""))
				check_associate_data = Arrays.asList(hash.get("check_associate_data").toString());
			
			if(!hash.get("uncheck_associate_data").toString().equals(""))
				uncheck_associate_data = Arrays.asList(hash.get("uncheck_associate_data").toString());
			
			bean.setFormCodeList(form_code_List,unchecked_formcode_List);
			bean.setUncheckedData(unchecked_formcode_List,form_code_List);
			bean.setFormAssociatedRecords(check_associate_data,uncheck_associate_data);
			putObjectInBean(bean_id,bean,request);
		}
		else if(identity.equals("Store_associate")){
			String bean_id		  = hash.get( "bean_id" ).toString() ;
			String bean_name	  = hash.get( "bean_name" ).toString() ;
			HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);
			List<String> form_code_List = Arrays.asList(hash.get("selected_Array").toString()); 
			List<String> unchecked_formcode_List = Arrays.asList(hash.get("uncheck_data").toString());
			bean.setFormCodeList(form_code_List,unchecked_formcode_List);
			bean.setUncheckedData(unchecked_formcode_List,form_code_List);
			putObjectInBean(bean_id,bean,request);
		}//Added for RUT-CRF-0061 [IN:45785] - End
		else if(identity.equals("Onchange_tab")){// Added for RUT-SCF-0358[IN:46704]
			String bean_id		  = hash.get( "bean_id" ).toString() ;
			String bean_name	  = hash.get( "bean_name" ).toString() ;
			HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);
			bean.setFormAssociatedRecords(new ArrayList(),new ArrayList());
			putObjectInBean(bean_id,bean,request);
		}
	}//Modified for RUT-SCF-0358[IN46714] - End
	catch(Exception e) {
		e.printStackTrace();
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
