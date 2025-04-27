package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eSS.VendorLoanAckBean;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __vendorloanackvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/VendorLoanAckValidate.jsp", 1729592067115L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block4Bytes, _wl_block4);
	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	VendorLoanAckBean bean = (VendorLoanAckBean)getBeanObject("VendorLoanAckBean","eSS.VendorLoanAckBean",request);  
	bean.setLanguageId(locale);
	String validate			=	request.getParameter("validate");
	Hashtable htFormValues  = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues			= (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	
	try {
		if(validate.equals("LOAD_DETAIL")){
			bean.clear();
			String doc_type_code		=	request.getParameter("doc_type_code");
			String doc_no				=	request.getParameter("doc_no");
			String req_from_date			=	request.getParameter("req_from_date");
			req_from_date					=	com.ehis.util.DateUtils.convertDate(req_from_date,"DMY",locale,"en");   
			String req_to_date			=	request.getParameter("req_to_date");
			req_to_date					=	com.ehis.util.DateUtils.convertDate(req_to_date,"DMY",locale,"en");
			String fm_vendor_code		=	CommonBean.checkForNull(request.getParameter("fm_vendor_code"),"%");
			String to_store_code		=	CommonBean.checkForNull(request.getParameter("to_store_code"),"%");
			String group_code			=	CommonBean.checkForNull(request.getParameter("group_code"),"%");
			String doc_ref				=	CommonBean.checkForNull(request.getParameter("doc_ref"),"%");
			
			bean.setDoc_type_code(doc_type_code);
			bean.setFm_vendor_code(fm_vendor_code); 
			bean.setToStore(to_store_code);
			bean.loadTFRDtlData(req_from_date,req_to_date,doc_no,group_code,doc_ref);
			result = true;
		}else if(validate.equals("LOAD_EXP_DETAIL")){
			result = true;
			String doc_no			=	request.getParameter("doc_no");
			ArrayList alExpRecords	=	new ArrayList();
			HashMap hmRecord		=	new HashMap();
			boolean resultTemp		=	false;
			String fm_vendor_code	=	request.getParameter("fm_vendor_code");
			String to_store_code	=	request.getParameter("to_store_code");
			int size = ((ArrayList)bean.getTFRExpRecords(doc_no)).size();
			
			if(!(size>0)){
				bean.loadTFRExpData(doc_no);
			}
	

		}else if(validate.equals("UPDATE_EXP_DETAIL")){
			String doc_no	=	request.getParameter("doc_no");
			HashMap hmTemp	=	new HashMap();
			ArrayList alExpRecords = new ArrayList();
			ArrayList alResult = (ArrayList)bean.getTFRExpRecords(doc_no);
			
			for(int i=0;i<alResult.size();i++){
				hmTemp = (HashMap)alResult.get(i);
				hmTemp.put("REMARKS",(String)htFormValues.get("remarks_"+i));
				alExpRecords.add(hmTemp);
				bean.setTFRExpRecords(doc_no,alExpRecords);
			}
			bean.setDoc_no(doc_no);
			result = true;
			flag="";
		}
		else if (validate.equals("ADD_TO_LIST")) {
			 try{	
					int total_rec	=	Integer.parseInt((String)htFormValues.get("total_records"));
					String checked_yn			=	"", remarks="";
					String doc_no					=	request.getParameter("doc_no");
				 	String doc_type_code			=	request.getParameter("doc_type_code");
					for(int i=0;i<total_rec;i++){
						checked_yn = (String)htFormValues.get("checkbox"+i);
						remarks = (String)htFormValues.get("remarks_"+i);
						if(checked_yn.equals("Y")){
							bean.setalGroupRecords(doc_no+"-"+(String)htFormValues.get("group_code_"+i),remarks);
						}
						else if(checked_yn.equals("N")){
							bean.removealGroupRecords(doc_no+"-"+(String)htFormValues.get("group_code_"+i));
						}
					}
					result = true;
					flag="";
				}catch(Exception e){
						result		=	false;
						message		=	e.getMessage();
						e.printStackTrace();
				}
		}
		else if (validate.equals("ADD_TO_LIST_DTL")) {
			 try{	
				String checked_yn		=	"", remarks="", group_code="";
				String doc_no			=	request.getParameter("doc_no");
				String doc_type_code	=	request.getParameter("doc_type_code");
				String i	=	request.getParameter("index");
				String groupCodes	=	request.getParameter("groupCodes");
				StringTokenizer stGroupCodes = new StringTokenizer(groupCodes.trim(),",");
				checked_yn = (String)htFormValues.get("checkbox"+i);
				while(stGroupCodes.hasMoreTokens()){
					group_code	=stGroupCodes.nextToken();
					remarks = (String)htFormValues.get("remarks_"+i);
					if(checked_yn.equals("Y")){
						bean.setalGroupRecords(doc_no+"-"+group_code,remarks);
					}
					else if(checked_yn.equals("N")){
						bean.removealGroupRecords(doc_no+"-"+group_code);
					}
				}
				result = true;
				flag="";
			}
			catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}
		}
		else if (validate.equals("CLEAR_GRP_SEL")) {
			bean.removealGroupRecords();
		}
	}catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println("assignResult(" + result + ",\"" + message + "\", \"" + flag + "\");") ;
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	putObjectInBean("VendorLoanAckBean",bean,request);

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
