package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eSS.Common.*;
import eSS.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __rofentryvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/ROFEntryValidate.jsp", 1732510842909L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	String bean_id			=		request.getParameter("bean_id");
	String bean_name		=		request.getParameter("bean_name");

	int functionType		=		Integer.parseInt(request.getParameter("function_type"));



	if ((bean_id == null) || (bean_id.equals("")))
		return;

	ROFEntryBean bean		=		(ROFEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	Hashtable hash			=		(Hashtable) XMLobj.parseXMLString(request);
    hash					=		 (Hashtable) hash.get ("SEARCH");

	switch (functionType) {
	case 1:
		{
			String doc_type_code	=		(String) hash.get("doc_type_code");
			if (doc_type_code.trim().equals("")) {
				return;
			}
			if (!bean.isDocNoAutoGenYN(doc_type_code)) {
				out.println("enableDocNo();");
			}
			else {
				out.println("disableDocNo();");
			}
		}
		break;
	case 2: // case - 2 will be executed on focus lost of Tray No
		{
				String group_code		=		(String) hash.get("group_code");
				String tray_no			=		(String) hash.get("tray_no");
				String sterilize_yn		=		(String) hash.get("sterilize_yn");
				String wash_yn			=		(String) hash.get("wash_yn");
				String pack_yn			=		(String) hash.get("pack_yn");
				boolean isValidTrayNo  =		bean.trayNoExists(group_code,tray_no, sterilize_yn, wash_yn, pack_yn);
				//out.println("alert("+isValidTrayNo+",\"\", \"0\");");
				out.println("assignResult("+isValidTrayNo+",\"\", \"0\");");
		}
		break;
	case 3: // case - 3 will be executed on changing group_code
		{
				String group_code = (String) hash.get("group_code");
				String sql = bean.getSsRepositoryValue("SQL_SS_GROUP_ROF_ENTRY_SELECT_SINGLE");
				HashMap hmDefaultValues = bean.fetchRecord(sql,group_code);
				out.println("document.formROFEntryDetail.sterile_type.value = '"+bean.checkForNull((String) hmDefaultValues.get("DEF_STERILE_TYPE"),"")+"';");
				out.println("document.formROFEntryDetail.wash_type.value ='"+bean.checkForNull((String)hmDefaultValues.get("DEF_WASHING_TYPE"),"")+"';");
				out.println("document.formROFEntryDetail.pack_item_code.value ='"+hmDefaultValues.get("PACK_ITEM_CODE")+"';");
 				out.println("document.formROFEntryDetail.pack_item_qty.value ='"+hmDefaultValues.get("PACK_ITEM_QTY")+"';");

		}
		break;
		case 6:
			{
					java.util.HashMap hmResult = null;

					if (hash.size() > 0) {
						hmResult = bean.updateTrayDetails(hash);
					}
					

					boolean result = ((Boolean)hmResult.get("result")).booleanValue();
					String message = (String)hmResult.get("msgid");
					String flag = (String)hmResult.get("flag");
					
					out.println("assignResult(" + result + ", \"" + message + "\", \""+flag+"\" ) ; ") ;
			}
			break;
		case 7:
		{
			String key = (String) hash.get("selected_key");
			if (key == null || (key.trim().equals(""))) {
				return;
			}
			String[] detail = bean.getDetail(key);
			out.println("var arrayObject = new Array();");
			for (int index=0;index<detail.length;index++ ) {
				out.println("arrayObject["+index+"] = '"+bean.checkForNull(detail[index])+"';");
			}
			out.println("editDetail(arrayObject);");
		}
		break;
		case 8 : 
			{
				int isValidDocDate = -1;
				String errorCode = null;
				String doc_date = (String) hash.get("doc_date");
				if (doc_date.trim().equals("")) {
					out.println("errorDisplay();"); // To be replaced with proper message
					return;
				}
				isValidDocDate = bean.isValidDocDate(doc_date);
				if (isValidDocDate > 0) {
					if (isValidDocDate== 1) {
						errorCode = "DOC_DT_NOT_LT_PROC_MTH";
					}
					else if (isValidDocDate== 2) {
						errorCode = "DOC_DT_NOT_GR_SYSDATE";
					}
					out.println("requestDocDateFocus();");

					out.println("assignResult(false,getMessage(\""+errorCode+"\",\"SS\"), \"0\")");//modified dt:4/7/08
					return;
				} 
				else {
					out.println("assignResult(true,\"\", \"0\");");
				}
				bean.updateSelectedTrays(hash);
			}
			break;
	default :
		//To be replaced with proper message
		out.println("alert(\'Invalid Function\');");
		return;
	}
	putObjectInBean(bean_id,bean,request);

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
