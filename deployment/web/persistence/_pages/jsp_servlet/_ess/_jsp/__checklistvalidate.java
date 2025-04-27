package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eSS.*;
import eST.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __checklistvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/CheckListValidate.jsp", 1732510596563L ,"10.3.6.0","Asia/Calcutta")) return true;
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

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	CheckListBean bean = (CheckListBean)getBeanObject( "checkListBean","eSS.CheckListBean", request ) ;  
	bean.setLanguageId(locale);
	String validate		=	request.getParameter("validate");
	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	String index			=	request.getParameter("index");;
	boolean	result			=	false;
	//String facility_id=(String)session.getValue("facility_id");
	HashMap hashmapDtl=new HashMap();
	String item_code				=	request.getParameter("item_code");
	String item_desc				=	request.getParameter("item_desc");
	String qty						=	request.getParameter("qty");
	String mandatory_status					=	request.getParameter("mandatory_status");
	String seq_no					=	request.getParameter("seq_no");
	String eff_status				=	request.getParameter("eff_status");
	String db_action				=	request.getParameter("db_action")==null?"I":request.getParameter("db_action");
	try {
		if (validate.equals("ADD_TO_LIST")) {
			try{
				hashmapDtl.put("item_code",		item_code );
				hashmapDtl.put("item_desc",		item_desc );
				hashmapDtl.put("qty",			qty		  );
				//hashmapDtl.put("uom_code",		uom_code  );
                hashmapDtl.put("mandatory_status",	mandatory_status);
				hashmapDtl.put("seq_no",		seq_no	  );
				hashmapDtl.put("eff_status",	eff_status);
				hashmapDtl.put("db_action",     db_action );

				String[]  key1		=	{"seq_no"};
				String[] value1		=	{seq_no};
				String[] stNames	=	{"item_code"};
				String[] stValues	=	{item_code};
				if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index))) { 
					throw new Exception("RECORD_ALREADY_EXISTS");
				}
				else if(bean.isDuplicateInArrayList(bean.getDtlRecords(),key1,value1,Integer.parseInt(index))){
						//result	=	false;
						throw new Exception("SEQ_NO_ALREADY_EXIST");
						//message	=	"SEQ_NO_ALREADY_EXIST";
					}
				bean.updateDtlRecord(Integer.parseInt(index),hashmapDtl);
			}catch(Exception exception){
				if (exception.getMessage().equals("RECORD_ALREADY_EXISTS")) {
				throw exception;
				}
				else if (exception.getMessage().equals("SEQ_NO_ALREADY_EXIST")) {
				throw exception;
				}
			}
			result			=	true;
		}else if(validate.equals("GET_STATUS")) {
			try { 
			result		=	true;
			
			/*//code added for Issue UOM Details...
				String gen_uom_code			=	bean.getGenItemUOM(item_code);
				out.println("clearListItems('document.KitTemplateAddModifyform.uom_code'); ");
			 		ArrayList iss_results	= bean.getUom_code_List(item_code);
					HashMap record			=	null;
					for(int i=0; i< iss_results.size(); i++) 
					{
					record			=	(HashMap)iss_results.get(i);
					String listRecord1		=	(String)record.get("EQVL_UOM_CODE");
					String listRecord2		=	(String)record.get("SHORT_DESC");
					if(gen_uom_code !=null || gen_uom_code ==""){
						out.println("addListItem(\"document.KitTemplateAddModifyform.uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +gen_uom_code+"\") ; ");
					}else{
						out.println("addListItem(\"document.KitTemplateAddModifyform.uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\" ,\"" +gen_uom_code+"\") ; ");
					}
					}

			
			//code ended...*/
			}
			catch (Exception exception) {
				message = exception.getMessage();
			}
		}

	}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean("checkListBean",bean,request);

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
