package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryformatsvalidate1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryFormatsValidate1.jsp", 1719922372000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block1Bytes, _wl_block1);

try
{    
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	boolean depend_flag = true;
	int seq=0;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( validate == null )validate="";
	String finalTest = request.getParameter("finalString");
	String seq1 = request.getParameter("seq");
	if(seq1 != null &&  !seq1.equals(""))
		seq=Integer.parseInt(seq1);
	String result = "";//String result1 = "";
	String from = "";//String result1 = "";
	result = finalTest;	
	OrderEntryFormats beanObj = (OrderEntryFormats)getBeanObject( bean_id , "eOR.OrderEntryFormats", request) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	if(hash.containsKey("from"))
		from = (String)hash.get("from");
	if(validate.equals("size"))
	{
		TreeMap formatFinalValues=beanObj.getFormatFinalValues();
		int size=formatFinalValues.size();
		out.println(size);
	}
	else if(validate.equals("createclear"))
	{
		TreeMap formatFinalValues=beanObj.getFormatFinalValues();
		formatFinalValues.clear();
	}
	else
	{
	if(depend_flag == true){
		if(hash.containsKey("seq_no"))
		{
			String seq_no = (String)hash.get("seq_no") ;		
			String level = request.getParameter("level");
			String order_category = request.getParameter("order_category");
			String order_catalog = request.getParameter("order_catalog");
			String order_type = request.getParameter("order_type");
			String mnemonic = request.getParameter("mnemonic");
			String dep_values="";
			//StringBuffer dep_values=new StringBuffer();
			ArrayList depend_values = new ArrayList();
			depend_values = beanObj.getDependency(level,order_category,order_type,order_catalog,seq_no,mnemonic);
			
			for(int k=0; k<depend_values.size(); k++){
				String[] record = (String [])depend_values.get(k);
				if(record[2] == null)
					record[2] = " ";
				if(record[3] == null)
					record[3] = " ";
				if(record[5] == null)
					record[5] = " ";
				if(record[7].equals("Y")){
					String value_seq_num = record[1];
					ArrayList mnemonic_values = new ArrayList();
					mnemonic_values = beanObj.getOthMnemonic(level,order_category,order_type,order_catalog,seq_no,mnemonic,value_seq_num);
					for(int i=0; i<mnemonic_values.size(); i++){
						String[] record1 = (String [])mnemonic_values.get(i);
						if(record1[4] == null)
							record1[4] = " ";
						if(record1[5] == null)
							record1[5] = " ";
						if(record1[6] == null)
							record1[6] = " ";
						if(record1[7] == null)
							record1[7] = "";
						if(record1[8] == null)
							record1[8] = "";
						record[7] = record1[0]+"^"+record1[1]+"^"+record1[2]+"^"+record1[3]+"^"+record1[4]+"^"+record1[5]+"^"+record1[6]+"^"+record1[7]+"^"+record1[8]+"!!";
					}
				}else if(record[7].equals("N"))
						record[7]=" ";
				dep_values =dep_values+ record[0]+","+record[1]+","+record[2]+","+record[3]+","+record[4]+","+record[5]+","+record[6]+","+record[7]+"||";
				//dep_values.append(record[0]+","+record[1]+","+record[2]+","+record[3]+","+record[4]+","+record[5]+","+record[6]+","+record[7]+"||");
				
			}out.println( "dependencyValues(\"" +dep_values+"\") ; " ) ;//out.println(dep_values);
		}if(hash.containsKey("value_seq_num"))
		{
			String value_seq_num = (String)hash.get("value_seq_num") ;
			String level = request.getParameter("level");
			String order_category = request.getParameter("order_category");
			String order_catalog = request.getParameter("order_catalog");
			String order_type = request.getParameter("order_type");
			String seq_no = request.getParameter("seq_no");
			String mnemonic = request.getParameter("mnemonic");
			String depend_finalString="";
			ArrayList mnemonic_values = new ArrayList();
			mnemonic_values = beanObj.getOthMnemonic(level,order_category,order_type,order_catalog,seq_no,mnemonic,value_seq_num);

			for(int i=0; i<mnemonic_values.size(); i++){
				String[] record = (String [])mnemonic_values.get(i);
				if(record[4] == null)
					record[4] = " ";
				if(record[5] == null)
					record[5] = " ";
				if(record[6] == null)
					record[6] = " ";
				if(record[7] == null)
					record[7] = "";
				if(record[8] == null)
					record[8] = "";
				depend_finalString = record[0]+"^"+record[1]+"^"+record[2]+"^"+record[3]+"^"+record[4]+"^"+record[5]+"^"+record[6]+"^"+record[7]+"^"+record[8]+"!!";
				
			}
			
			out.println( "othMnemonicValues(\"" + depend_finalString + "\") ; " ) ;
			//out.println(depend_finalString);
			
		}
		else{
		//beanObj.setFinalString(finalTest);
		if(from.equals("clear"))
		{
			beanObj.removeFormatFinalValues(seq);
		}
		else
		{
			beanObj.setFormatFinalValues(seq,finalTest);
		}
		//out.println(result);
		}
	}else
	{
		//beanObj.setFinalString(finalTest);
		beanObj.setFormatFinalValues(seq,finalTest);
		out.println(result);
	}
	}	

	putObjectInBean(bean_id,beanObj,request);
}
catch(Exception e ) { e.printStackTrace(); }


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
