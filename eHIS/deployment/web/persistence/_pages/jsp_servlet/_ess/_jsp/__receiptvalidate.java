package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eSS.*;
import eSS.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __receiptvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/ReceiptValidate.jsp", 1732510788350L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n \n";
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
            java.util.ArrayList dispatchList= null;synchronized(session){
                dispatchList=(java.util.ArrayList)pageContext.getAttribute("dispatchList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(dispatchList==null){
                    dispatchList=new java.util.ArrayList();
                    pageContext.setAttribute("dispatchList",dispatchList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);

	
	ReceiptBean bean				=	(ReceiptBean)getBeanObject( "receiptBean","eSS.ReceiptBean", request  ) ;  
	Hashtable hash					= (Hashtable) XMLobj.parseXMLString(request);
	hash							= (Hashtable) hash.get ("SEARCH");
	
	String index					=	request.getParameter("index");
	String dispatch_date			=	request.getParameter("dispatch_date");
	String validate					=	request.getParameter("validate");
 	String records_to_modify 		=	request.getParameter("records_to_modify");
 	String doc_no					=	request.getParameter("doc_no");
 	String doc_type_code			=	request.getParameter("doc_type_code");
 	String facility_id				=	request.getParameter("facility_id");
	
	
	String message				=	"";
	String flag					=	"";
	boolean	result				=	false;
	String checked_yn			=	"";

	

	try{
		
		 if (validate.equals("ADD_TO_LIST")) {
			//comented by sakti against BRU-HIMS-CRF-372
			/* int i=0;
			
	for	(i	=0;	i<alDispatchRecords.size();i++){
			HashMap hmListItems	=	(HashMap)alDispatchRecords.get(i);
			System.out.println("hmListItems"+hmListItems.size());

					hmListItems.put("RECEIPT_DATE",		dispatch_date);
					//dispatchList.set(i,hmListItems);
					alDispatchRecords.set(i,hmListItems);
//				}
			result	=	true;
			message	=	"Done";
	}
	bean.setRecords_to_modify(records_to_modify);
	System.out.println("getRecords_to_modify"+bean.getRecords_to_modify());*/
	//Added by sakti against BRU-HIMS-CRF-372
			 try{	
					/*String do_no	=	request.getParameter("do_no");
					String tray_no	=	request.getParameter("tray_no");
					 dispatch_date =	request.getParameter("dispatch_date");
					 doc_type_code	=	request.getParameter("doc_type_code");
					String group_code	=	request.getParameter("group_code");*/
					
					int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
					//System.out.println("total_rec"+total_rec);
					for(int i=0;i<total_rec;i++){
						 checked_yn = (String)hash.get("checkbox_tray"+i);
						
						if(checked_yn.equals("Y")){
						bean.setalGroupRecords(doc_type_code+"-"+doc_no+"-"+(String)hash.get("tray_no_"+i)+"-"+(String)hash.get("group_code"+i),(String)hash.get("receipt_date"+i));
						}
					}
					
										
					bean.setnewalGroupRecords(doc_type_code+"-"+doc_no);
														
					result = true;
					flag="Done";
				}catch(Exception e){
						result		=	false;
						message		=	e.getMessage();
						e.printStackTrace();
				}
	
	
	
		}else if (validate.equals("REMOVE_KEY")) {
			
			int total_rec	=	Integer.parseInt((String)hash.get("total_checkboxes"));
			//System.out.println("total_rec"+total_rec);
			for(int i=0;i<total_rec;i++){
				 checked_yn = (String)hash.get("checkbox_tray"+i);
				//System.out.println("checked_yn"+checked_yn);
				if(checked_yn.equals("N")){
				bean.removenewalGroupRecords(doc_type_code+"-"+doc_no+"-"+(String)hash.get("tray_no_"+i)+"-"+(String)hash.get("group_code"+i));
				}
			}
			
		
		}else if(validate.equals("ASSIGN_VALUE")){
			bean.updateSelectedValues(hash);
			
			result = true;
			flag="";
	
	}
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		////System.err.println(alPackingDiscrepancyList);
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

putObjectInBean("receiptBean",bean,request);


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
