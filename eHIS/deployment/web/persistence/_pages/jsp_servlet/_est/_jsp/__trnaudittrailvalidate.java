package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.TrnAuditTrailBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __trnaudittrailvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/TrnAuditTrailValidate.jsp", 1718178912370L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
	
	String locale			= (String)session.getAttribute("LOCALE");
	TrnAuditTrailBean bean = (TrnAuditTrailBean)getBeanObject("trnAuditTrailBean","eST.TrnAuditTrailBean",request);  
	bean.setLanguageId(locale);
	String validate			=	request.getParameter("validate");
	Hashtable htFormValues  = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues			= (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	try {
		   if(validate.equals("TRNTYPE")){
			result = true;
			flag = "";
			String trn_type = request.getParameter("trn_type");
			bean.setTrn_type(trn_type);
			out.println("clearListItems('document.formTrnAuditTrail.doc_type_code'); ");
			ArrayList alDocTypeList = bean.getDocTypeArrayList();
			HashMap record	=	null;
	
			for(int i=0; i< alDocTypeList.size(); i++) {
				record	=	(HashMap)alDocTypeList.get(i);
				String listRecord	=	(String)record.get("DOC_TYPE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.formTrnAuditTrail.doc_type_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); ");
				
			}
		}else  if(validate.equals("TTORDER")){
			
			String TTorder = request.getParameter("TTorder");
			String header = request.getParameter("header");
			bean.getDeletedDocs(TTorder,header);
		/*	ArrayList deletedDocs = bean.getDeletedDocDetails();
			ArrayList trn_typedesc = new ArrayList();
			ArrayList trn_typedesc_dummy = new ArrayList();
			for(int i=0;i<deletedDocs.size();i++){
			HashMap hh=(HashMap)deletedDocs.get(i);
			if(!trn_typedesc.contains((String)hh.get(header)))
			trn_typedesc.add((String)hh.get(header));
			trn_typedesc_dummy.add((String)hh.get(header));
			}

			if(header.equals("DOC_NO")){
			trn_typedesc=new ArrayList();
			for(int u=0;u<trn_typedesc_dummy.size();u++){
			trn_typedesc.add(new Integer(Integer.parseInt((String)trn_typedesc_dummy.get(u))));

				}
			}

			Collections.sort(trn_typedesc);

			ArrayList sorted = new ArrayList();
			if(TTorder.equals("DESC") || TTorder.equals("")){
			for(int i=0;i<trn_typedesc.size();i++){
			for(int j=0;j<deletedDocs.size();j++){
			HashMap hh=(HashMap)deletedDocs.get(j);
			String trn_desc=(String)hh.get(header);
			String trn_desc1=(String)trn_typedesc.get(i);
			if(trn_desc.equals(trn_desc1))
			sorted.add(hh);
			}
			}
			}else{
			for(int i=trn_typedesc.size()-1;i>=0;i--){
			for(int j=0;j<deletedDocs.size();j++){
			HashMap hh=(HashMap)deletedDocs.get(j);
			String trn_desc=(String)hh.get(header);
			String trn_desc1=(String)trn_typedesc.get(i);
			if(trn_desc.equals(trn_desc1))
			sorted.add(hh);
			}
			}
			}
			bean.clear();

			bean.setDeletedDocDetails(sorted);*/
		}
	}catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
		flag=validate;
	}
	finally{
		out.println("assignResult(" + result + ",\"" + message + "\", \"" + flag + "\");") ;
	}

            _bw.write(_wl_block0Bytes, _wl_block0);

	putObjectInBean("trnAuditTrailBean",bean,request);

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
