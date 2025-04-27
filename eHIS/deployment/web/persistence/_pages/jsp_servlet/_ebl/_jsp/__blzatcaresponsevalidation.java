package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blzatcaresponsevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLZatcaResponseValidation.jsp", 1709114118505L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="   \n\n\n";
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


private String checkForNull(String input){
	
	if(input == null || "null".equals(input)){
		input = "null";
	}
	return input;
}

private Hashtable parseXMLString1(String var1) {
      Hashtable var2 = new Hashtable();
      try {
		 Reader inputString = new StringReader(var1);
		 BufferedReader var3 = new BufferedReader(inputString);
         // BufferedReader var3 = var1.getReader();
         SAXBuilder var4 = new SAXBuilder();
         Document var5 = var4.build(var3);
         Element var6 = var5.getRootElement();
         ListIterator var7 = var6.getChildren().listIterator();

         while(var7.hasNext()) {
            Element var8 = (Element)var7.next();
            Hashtable var9 = new Hashtable();
            List var10 = var8.getAttributes();
            Iterator var11 = var10.iterator();
            while(var11.hasNext()) {
               Attribute var12 = (Attribute)var11.next();
               String var13 = var12.getValue().replace('"', '\n');
               var9.put(var12.getName(), var13);
            }
            var2.put(var8.getName(), var9);
         }
      } catch (Exception var14) {
		  System.err.println("error in parseXMLSStirng 1  "+var14.toString());
         var2.put("error", var14.toString());
      }
      return var2;
   }


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);


Connection con = null;
try 
	{
		con = ConnectionManager.getConnection(request);
		System.err.println("BLZatcaResponseValidation.jsp...........................................................");
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String xmlValues=checkForNull(request.getParameter("xmlStr"));
		System.err.println("Inside MaintainTreatValidation::::xmlValues  "+xmlValues);
		Hashtable hash				= (Hashtable)parseXMLString1( xmlValues ) ;
		System.err.println(" hash .... Inside BLZatcaResponseValidation:::: "+hash);
		hash = (Hashtable) hash.get("SEARCH");
		System.err.println(" hash .... Inside BLZatcaResponseValidation1:::: "+hash);
		
		
		String zatcaBillDtlsString="";
		
		ArrayList<String> zatcaResubmissionRecord = new ArrayList<String>();

		HashMap<String,ArrayList<String>>  zatcaResubmissionRecords=new HashMap<String,ArrayList<String>>();
		
		int totalRecords=Integer.parseInt((String)hash.get("totalRecords"));
	
		System.err.println("totalRecords..hdr.........."+totalRecords);
		
		for (int i = 1; i<=totalRecords; i++) 
		{
			 	 
			String selectedIndex=(String) hash.get("selectedIndex_"+i);
			if(selectedIndex.equals("") || selectedIndex.equals("null") || selectedIndex == null)
			{
				selectedIndex="N";
			}
			System.err.println("selectedIndex............"+selectedIndex);
			
			String doc_type_code = (String) hash.get("doc_type_code_"+i);
			if(doc_type_code.equals("") || doc_type_code.equals("null") || doc_type_code == null)
			{
				doc_type_code="null";
			}
			
			String doc_num = (String) hash.get("doc_num_"+i);
			if(doc_num.equals("") || doc_num.equals("null") || doc_num == null)
			{
				doc_num="null";
			}
			
			String oper_fac_id = (String) hash.get("oper_fac_id_"+i);
			if(oper_fac_id.equals("") || oper_fac_id.equals("null") || oper_fac_id == null)
			{
				oper_fac_id="null";
			}	
			
			String ACTIVE_FLAG_YN = (String) hash.get("ACTIVE_FLAG_YN_"+i);
			if(ACTIVE_FLAG_YN.equals("") || ACTIVE_FLAG_YN.equals("null") || ACTIVE_FLAG_YN == null)
			{
				oper_fac_id="Y";
			}			

			zatcaBillDtlsString=selectedIndex+"|"+doc_type_code+"|"+doc_num+"|"+oper_fac_id+"|"+ACTIVE_FLAG_YN;
					
			//System.err.println("zatcaBillDtlsString"+zatcaBillDtlsString);
				
			zatcaResubmissionRecord.add(zatcaBillDtlsString);
				
			//System.err.println("zatcaResubmissionRecord : : "+zatcaResubmissionRecord);			
		}
		zatcaResubmissionRecords.put("ZATCA",zatcaResubmissionRecord);

		session.setAttribute("ZATCARESUBMISSIONRECORDS", zatcaResubmissionRecords);

		System.err.println("zatcaResubmissionRecords"+zatcaResubmissionRecords);
	}
	catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception from BLZatcaResponseValidation.jsp :"+ e);
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
