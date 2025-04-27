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
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __autoclavewashunittestvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/AutoclaveWashUnitTestValidate.jsp", 1732661522000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
	String bean_id						=		request.getParameter("bean_id");
	String bean_name					=		request.getParameter("bean_name");
	int functionType					=		Integer.parseInt(request.getParameter("function_type"));

	if ((bean_id == null) || (bean_id.equals("")))
		return;

   	AutoclaveWashingUnitTestBean bean	=		 (AutoclaveWashingUnitTestBean) getBeanObject(bean_id , bean_name, request);
	Hashtable hash						=		(Hashtable) XMLobj.parseXMLString(request);
    hash								=		(Hashtable) hash.get ("SEARCH");
	

	switch (functionType) {
	case 1:
		{
                String unit_type		=		"" ; 
				unit_type				=		(String) hash.get("unit_type");
				
				if (unit_type.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}

				bean.setUnit_type(unit_type);
			out.println("clearListItems('parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code'); ");
				out.println("clearListItems('parent.frameAutoclaveWashingUnitTestDetail.formAutoclaveWashingUnitTestDetail.test_code'); ");

		        ArrayList alParameters	=	new ArrayList(3);
				alParameters.add(unit_type);
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLoginFacilityId()); //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014

			
				ArrayList alRecords		=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WASHING_UNIT_SELECT_LIST"),alParameters);
				
				for (int i=0; i<alRecords.size(); i++)
				{
					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					out.println(  "addListItem(\"parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code\",\""+hmRecord.get("AUTOCLAVE_WASH_UNIT_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
				}
				

				ArrayList alParameters1	=	new ArrayList(3);
				alParameters1.add(unit_type);
				alParameters1.add(bean.getLanguageId());
				alParameters1.add(bean.getLoginFacilityId());//Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
				
				ArrayList alRecords1	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WASHING_TEST_SELECT_LIST"),alParameters1);

				for (int i=0; i<alRecords1.size(); i++)
				{
					HashMap hmRecord1	=	(HashMap)alRecords1.get(i);
					out.println(  "addListItem(\"parent.frameAutoclaveWashingUnitTestDetail.document.formAutoclaveWashingUnitTestDetail.test_code\",\""+hmRecord1.get("TEST_CODE")+"\",\""+hmRecord1.get("SHORT_DESC")+"\");"  );
				}


				break;
		}
		case 2: //Added by Pankaj on 12/08/03 
			{
                String unit_type		=		 "" ; 
			    unit_type				=		(String) hash.get("unit_type");
				

				if (unit_type.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}

				bean.setUnit_type(unit_type);
				out.println("clearListItems('formAutoclaveWashingUnitTestQueryCriteria.autoclave_wash_unit_code'); ");
				
				ArrayList alParameters	=	new ArrayList(3);
				
				alParameters.add(unit_type);
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLoginFacilityId()); //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
				
				ArrayList alRecords1	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WASHING_UNIT_TEST_SELECT_LIST"),alParameters);
				for (int i=0; i<alRecords1.size(); i++)
				{
					HashMap hmRecord1	=	(HashMap)alRecords1.get(i);
					out.println(  "addListItem(\"parent.frameAutoclaveWashingUnitTestQueryCriteria.document.formAutoclaveWashingUnitTestQueryCriteria.autoclave_wash_unit_code\",\""+hmRecord1.get("AUTOCLAVE_WASH_UNIT_CODE")+"\",\""+hmRecord1.get("SHORT_DESC")+"\");"  );
				}
		break;
		}
		
		case 3:
		{
                String unit_type		=		"A" ; 
				bean.setUnit_type(unit_type);
			out.println("clearListItems('parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code'); ");
				out.println("clearListItems('parent.frameAutoclaveWashingUnitTestDetail.formAutoclaveWashingUnitTestDetail.test_code'); ");

		        ArrayList alParameters	=	new ArrayList(3);
				alParameters.add(unit_type);
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLoginFacilityId()); //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014

			
				ArrayList alRecords		=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WASHING_UNIT_SELECT_LIST"),alParameters);
				
				for (int i=0; i<alRecords.size(); i++)
				{
					HashMap hmRecord	=	(HashMap)alRecords.get(i);
					out.println(  "addListItem(\"parent.frameAutoclaveWashingUnitTestHeader.document.formAutoclaveWashingUnitTestHeader.autoclave_wash_unit_code\",\""+hmRecord.get("AUTOCLAVE_WASH_UNIT_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\");"  );
				}
				
				
				ArrayList alParameters1	=	new ArrayList(3);
				alParameters1.add(unit_type);
				alParameters1.add(bean.getLanguageId());
				alParameters1.add(bean.getLoginFacilityId()); //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
				ArrayList alRecords1	=	bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WASHING_TEST_SELECT_LIST"),alParameters1);

				for (int i=0; i<alRecords1.size(); i++)
				{
					HashMap hmRecord1	=	(HashMap)alRecords1.get(i);
					out.println(  "addListItem(\"parent.frameAutoclaveWashingUnitTestDetail.document.formAutoclaveWashingUnitTestDetail.test_code\",\""+hmRecord1.get("TEST_CODE")+"\",\""+hmRecord1.get("SHORT_DESC")+"\");"  );
				}


				break;
		}	
		default :
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
