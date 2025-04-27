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

public final class __preparegroupvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/PrepareGroupValidate.jsp", 1731957129705L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n \n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
	String bean_id					= request.getParameter("bean_id");
	String bean_name				= request.getParameter("bean_name");
	String validate					= request.getParameter("validate");
	String bin_location_code		= request.getParameter("bin_location_code");
	int functionType				= Integer.parseInt(request.getParameter("function_type"));

	if ((bean_id == null) || (bean_id.equals("")))
		return;
	if ((validate == null) || (validate.equals(""))) 
		return;

	PrepareGroupBean bean			= (PrepareGroupBean) getBeanObject( bean_id, bean_name,request  );  
	Hashtable hash					= (Hashtable) XMLobj.parseXMLString(request);
    hash							= (Hashtable) hash.get ("SEARCH");

	switch (functionType) {
	case 1:
		{
			if (validate.equals("doc_type_code")) {
				String doc_type_code = (String) hash.get("doc_type_code");
				if (doc_type_code.trim().equals("")) {
					//To be replaced with proper error message
					out.println("errorDisplay();");
					return;
				}
				if (!bean.isDocNoAutoGenYN(doc_type_code)) {
					out.println("enableDocNo();");
				}
				else {
					out.println("disableDocNo();");
				}
			}
		}
		break;
	case 2: // case - 2 will be executed on focus lost of Store Code
		{
			/*if (validate.equals("store_code")) {
				String store_code = (String) hash.get("store_code");
				if (store_code.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}
				bean.setStore_code(store_code);
				out.println("clearListItems('formPrepareGroup.bin_location_code'); ");
				ArrayList binLocation = bean.getBinLocationData(store_code);
				for(int i=0; i< binLocation.size(); i++) {
					String[] record = (String[])binLocation.get(i);
					out.println("addListItem(\"formPrepareGroup.bin_location_code\", \"" + record[0] + "\",\"" + record[1] + "\",\""+bin_location_code+"\"); ");
				}
			}*/
		}
		break;
	case 3: // This case will be executed on Click of apply to calculate the total cost
		{
			if (validate.equals("prepare_qty")) {
				//String prepare_qty = (String) hash.get("prepare_qty");
				//String group_code  = (String) hash.get("group_code");
				String prepare_qty = request.getParameter("prepare_qty");
				String group_code = request.getParameter("group_code");
				String index = request.getParameter("index");
 				
				if (prepare_qty.trim().equals("") || group_code.trim().equals("") ) {
					out.println("errorDisplay();"); // To be replaced with proper message
					return;
				}
				//bean.setPrepare_qty(prepare_qty);
				//bean.setGroup_code(group_code);
				
				String totalCost = bean.getTotalCost(prepare_qty,group_code);
				out.println("setTotalCostValue("+totalCost+","+index+");");//Modified by sakti against BRU-HIMS-CRF-370
			}
		}
		break;
	case 4: // This case will be executed on focus lost of Prepared Quantity and Calculates the total cost
		{
System.err.println("==validate"+validate+"===hash"+hash);				
			if (validate.equals("doc_date")) {
				int isValidDocDate = -1;
				String doc_date = (String) hash.get("doc_date");
System.err.println("==doc_date"+doc_date);				
				if (doc_date.trim().equals("")) {
					out.println("errorDisplay();"); // To be replaced with proper message
					return;
				}
				isValidDocDate = bean.isValidDocDate(doc_date);
System.err.println("==isValidDocDate"+isValidDocDate);				
				String errorCode = null;
				if (isValidDocDate > 0) {
					if (isValidDocDate== 1) {
						errorCode = "DOC_DT_NOT_LT_PROC_MTH";
					}
					else if (isValidDocDate== 2) {
						errorCode = "DOC_DT_NOT_GR_SYSDATE";
					}
					out.println("requestDocDateFocus("+isValidDocDate+");");				
					out.println("assignResult(false,getMessage(\""+errorCode+"\",\"SS\"), \"0\")");
				} 
				else {
					out.println("assignResult(true,\"\", \"0\");");
					return;
				}
				
			}
			
		}
		break;
	case 5: // This case will be executed on apply added against BRU-HIMS-CRF-370
	{

		
		ArrayList	alRecords	=	new ArrayList();
		HashMap	hmDtlRecord	=	new HashMap();
		int total_rec	=	Integer.parseInt((String)hash.get("total_rec"));

		for(int i=0;i<total_rec;i++){
			hmDtlRecord.put("GROUP_CODE",(String)hash.get("group"+i));
			hmDtlRecord.put("TOTAL_VALUE",(String)hash.get("total_value_"+i));
			hmDtlRecord.put("BIN_LOC_CODE",(String)hash.get("bin_location_code_"+i));
			hmDtlRecord.put("PREPARE_QTY",(String)hash.get("prepare_qty_"+i));
			hmDtlRecord.put("mode",(String)hash.get("new_mode"+i));

			alRecords.add(hmDtlRecord);
			hmDtlRecord = new HashMap();
		}

		bean.setDataList(alRecords);
			
	}
	break;
	
	case 6: // This case will be executed on click of OK or next_previous added against BRU-HIMS-CRF-370
	{
		bean.selectedBatches(hash);
			
	}
	break;
	
	case 7: // This case will be executed on click of group search button added against BRU-HIMS-CRF-370
	{

		ArrayList	alRecords	=	new ArrayList();
		HashMap	hmDtlRecord	=	new HashMap();
		int total_rec	=	Integer.parseInt((String)hash.get("total_rec"));
       
		for(int i=0;i<total_rec;i++){
			hmDtlRecord.put("GROUP_CODE",(String)hash.get("group"+i));
			hmDtlRecord.put("GROUP_DESC",(String)hash.get("desc"+i));
			hmDtlRecord.put("TOTAL_VALUE",(String)hash.get("total_value_"+i));
			hmDtlRecord.put("BIN_LOCATION_CODE",(String)hash.get("bin_location_code_"+i));
			hmDtlRecord.put("PREPARE_QTY",(String)hash.get("prepare_qty_"+i));
			hmDtlRecord.put("mode",(String)hash.get("new_mode"+i));

			alRecords.add(hmDtlRecord);
			hmDtlRecord = new HashMap();

			bean.setAlSelectedTrayDetails((String)hash.get("group"+i));//Added against inc#42370
		}

		bean.setSelectedList(alRecords);
			
	}
	break;
	//Added against inc#42370
	case 8: // This case will be executed on click of OK or next_previous added against BRU-HIMS-CRF-370
	{
			ArrayList checkedrecord =  bean.getAlSelectedTrayDetails();
			checkedrecord.clear();
					
	}
	break;
	default :
		//To be replaced with proper message
		out.println("alert(\'Invalid Function\');");
		return;
	}



            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean(bean_id,bean,request);

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
