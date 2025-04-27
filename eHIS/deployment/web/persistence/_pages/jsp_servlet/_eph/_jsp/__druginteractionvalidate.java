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
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __druginteractionvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DrugInteractionValidate.jsp", 1721117157831L ,"10.3.6.0","Asia/Calcutta")) return true;
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/11/2019	IN070606		Ramesh Goli											MMS-KH-CRF-0029							
23/08/2020	IN073641		Manickavasagam			MMS-KH-CRF-0034 
------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

	String locale			= (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

try{
	String func_mode			    =		request.getParameter( "func_mode" )==null?"":request.getParameter( "func_mode" ) ;
	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;
	String bean_id				=		(String)hash.get( "bean_id" ) ==null?"":(String)hash.get( "bean_id" ) ;
	String bean_name		    =		(String)hash.get( "bean_name" ) ==null?"":(String)hash.get( "bean_name" ) ;
	DrugInteractionBean bean = (DrugInteractionBean)getBeanObject( bean_id,bean_name,request) ;
	String intr_option,intr_name1,intr_name2,intr_code1,intr_code2, severity_level, significant_level, probability, interaction_desc, restrict_transaction, form_code1, form_code2, form_desc1, form_desc2,term_set_code;//term_set_code added for MMS-DM-CRF-0229
	String intr_Type=""; //IN070606
	if ( func_mode.equals( "checkForDuplicate" ) ){
		ArrayList DrugInteractionDtl=new ArrayList();
		HashMap hmDrugIntList=null;
		intr_option = (String)hash.get("intr_option");
		intr_code1 = (String)hash.get("intr_code1");
		intr_code2 =(String)hash.get("intr_code2"); 
		intr_name1 = (String)hash.get("intr_name1");
		intr_name2 = (String)hash.get("intr_name2"); 
		form_code1 = (String)hash.get("form_code1"); 
		form_code2 = (String)hash.get("form_code2"); 
		intr_Type	= (String)hash.get("intr_type");
		boolean dupFound = bean.checkForDuplicate( intr_option,  intr_code1,  intr_code2, form_code1, form_code2, intr_Type);  //intr_Type add for IN070606
		if(dupFound){
			out.println("alert(getMessage('CODE_ALREADY_EXISTS','Common'));");
		}
		else{
			String key = intr_option+"_"+intr_code1+"_"+form_code1+"_"+intr_code2+"_"+form_code2;
			String key2 = intr_option+"_"+intr_code2+"_"+form_code2+"_"+intr_code1+"_"+form_code1;
			hmDrugIntList = bean.getDrugIntrList();
			if(hmDrugIntList.containsKey(key) || hmDrugIntList.containsKey(key2)){
				out.println("confirm(getMessage('PH_INTERACTION_ALREADY_ADDED','PH'))");
			}
			else
				out.println("AddRecord()");
		}
	}
	else if ( func_mode.equals( "AddRecord" ) ){
		ArrayList DrugInteractionDtl=new ArrayList();
		String lab_ord_check_for_upto = ""; //MMS-KH-CRF-0034
 		HashMap hmDrugIntList=null;
		intr_Type	= (String)hash.get("intr_Type"); //IN070606
		intr_option = (String)hash.get("intr_option");
		intr_code1 = (String)hash.get("intr_code1");
		intr_code2 =(String)hash.get("intr_code2"); 
		intr_name1 = (String)hash.get("intr_name1");
		intr_name2 = (String)hash.get("intr_name2"); 
		severity_level = (String)hash.get("severity_level");
		significant_level = (String)hash.get("significant_level");
		probability = (String)hash.get("probability");
		restrict_transaction = (String)hash.get("restrict_transaction");
		interaction_desc = (String)hash.get("interaction_desc");
		form_code1 = (String)hash.get("form_code1"); 
		form_code2 = (String)hash.get("form_code2"); 
		form_desc1 = (String)hash.get("form_desc1"); 
		form_desc2 = (String)hash.get("form_desc2"); 
		lab_ord_check_for_upto = (String)hash.get("lab_ord_check_for_upto");  //MMS-KH-CRF-0034
		term_set_code = (String)hash.get("term_set_code");
		DrugInteractionDtl.add(intr_option); //0
		DrugInteractionDtl.add(intr_code1); //1
		DrugInteractionDtl.add(intr_code2);
		DrugInteractionDtl.add(java.net.URLDecoder.decode(intr_name1,"UTF-8"));
		DrugInteractionDtl.add(java.net.URLDecoder.decode(intr_name2,"UTF-8")); //4
		DrugInteractionDtl.add(severity_level); //5
		DrugInteractionDtl.add(significant_level); //6
		DrugInteractionDtl.add(probability);
		DrugInteractionDtl.add(restrict_transaction);
		DrugInteractionDtl.add(java.net.URLDecoder.decode(interaction_desc,"UTF-8")); //9
		DrugInteractionDtl.add("E"); //10
		DrugInteractionDtl.add(form_code1); //11
		DrugInteractionDtl.add(form_code2);
		DrugInteractionDtl.add(java.net.URLDecoder.decode(form_desc1,"UTF-8"));
		DrugInteractionDtl.add(java.net.URLDecoder.decode(form_desc2,"UTF-8")); //14
		DrugInteractionDtl.add(intr_Type); //15 //IN070606
		DrugInteractionDtl.add(lab_ord_check_for_upto);// 16 MMS-KH-CRF-0034
		DrugInteractionDtl.add(term_set_code);// 17 MMS-KH-CRF-0034
		hmDrugIntList = bean.getDrugIntrList();
		hmDrugIntList.put(intr_option+"_"+intr_code1+"_"+form_code1+"_"+intr_code2+"_"+form_code2,DrugInteractionDtl);
		out.println("LoadDrugIntrList();");	
	}
	else if ( func_mode.equals( "loadDosageForm" ) ){
		intr_option = (String)hash.get("intr_option");
		String intrCode = (String)hash.get("intrCode");
		String objNum = (String)hash.get("objNum");
		ArrayList dosageFormList =bean.getDosageForms(intr_option, intrCode);
		String dosageForm[] = null;
		out.println("clearDosageForm('"+ objNum+ "');");
		for (int i = 0; i < dosageFormList.size(); i++) {
			dosageForm =(String[]) dosageFormList.get(i);
			dosageForm[1]=dosageForm[1].replaceAll(" ","%20");
			dosageForm[1] = java.net.URLEncoder.encode(dosageForm[1],"UTF-8");
			dosageForm[1]=dosageForm[1].replaceAll("%2520","%20");
			out.println("addDosageForm('"+dosageForm[0]+ "','"+ dosageForm[1] + "','"+objNum+"');");
		}
	}
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e){
	e.printStackTrace();
}

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
