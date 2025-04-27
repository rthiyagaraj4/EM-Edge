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

public final class __orderentryformatsvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryFormatsValidate.jsp", 1719922382000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 
try
{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	//String form = request.getParameter( "form" ) ==null?"":request.getParameter( "form" );
	String default_val = "";
	String SequenceNumber = "";
	String format_id = "";
	try{
		default_val  = request.getParameter( "default_val" ) ;
		if ( default_val == null || default_val.equals( "" ) )
			default_val = "" ;
		SequenceNumber  = request.getParameter( "SequenceNumber" ) ;
		format_id  = request.getParameter( "format_id" ) ;

		if ( SequenceNumber == null || SequenceNumber.equals( "" ) )
			SequenceNumber = "" ;

		if ( format_id == null || format_id.equals( "" ) )
			format_id = "" ;
	}catch(Exception e){
		e.printStackTrace();
	}
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;


	OrderEntryFormats beanObj = (OrderEntryFormats)getBeanObject( bean_id , "eOR.OrderEntryFormats", request) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	String order_category = (String)hash.get("order_category") ;
	String getdefaultValue		= (String)hash.get("default_val") ;
	
	if ( validate.equals( "ord_cat" ) ) 
	{
		//String order_category = (String)hash.get("order_category") ;
//		- to check whether the selected combinationalready exists..
//		- gets triggereed while clicking the "field mnemonic button" in the create screen
			 if(hash.containsKey("dupchk"))
			 {
				String ord_category	= (String)hash.get("order_category") ;
				String level			= (String)hash.get("level") ;
				String order_type		= (String)hash.get("order_type") ;
				String ord_catalog		= (String)hash.get("ord_catalog") ;
				
				int count=  0;
				beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
				count = beanObj.checkForDuplicate(level, ord_category,order_type,ord_catalog );
				out.println( "recordCnt(\"" + count + "\") ; " ) ;
//		 - to populate the values of the defalut option in modal window in the case of LIST - Begin
			}
			else if(hash.containsKey("mnemonic"))
			{
				String mnemonic = (String)hash.get("mnemonic") ;
				if(mnemonic.equals("EXAM_VIEW_REQSTD") && order_category.equals("RD"))
				{
					ArrayList DefaultData = beanObj.getDefaultData() ;
					String[] record =null;
					for( int i=0 ; i< DefaultData.size() ; i++ ) 
					{

						record = (String[])DefaultData.get(i);
						out.println( "addListValues(\""+record[0]+"\",\""+record[1]+"\",\""+default_val+"\") ; " ) ;
					}
				}
				else
				{
					//ArrayList OrderTypeData = null;
					String OrderTypeDataCons ="";
					if((order_category!=""|| !order_category.equals("")) && (mnemonic!=""|| !mnemonic.equals(""))){
						if((SequenceNumber!=""|| !SequenceNumber.equals("")) && (format_id!=""|| !format_id.equals("")))
						{
							
							//OrderTypeData= beanObj.getListTypeData1(order_category,mnemonic,SequenceNumber,format_id) ;	
							OrderTypeDataCons = beanObj.getListTypeConstruct(order_category,mnemonic,SequenceNumber,format_id) ;
							//out.println("parent.list_bottom.document.getElementById("deflt_value2").innerHTML =\""+OrderTypeDataCons+"\"");
							out.println( "clearDefaultList('document') ; " ) ;
							out.println( "addList_Values(\" " +OrderTypeDataCons + "\") ; " ) ;
						}
						else
						{
							//OrderTypeData= beanObj.getListTypeData(order_category,mnemonic) ;
							OrderTypeDataCons = beanObj.getListTypeConstruct(order_category,mnemonic) ;
							out.println( "clearDefaultList('document') ; " ) ;
							out.println( "addList_Values(\" " +OrderTypeDataCons + "\") ; " ) ;
						}
						//String OrderTypeDataCons = beanObj.getListTypeConstruct(order_category,mnemonic) ;
						//if(order_category.equals("RX")&&mnemonic.equals("ABCD"))

						if(default_val!="" && default_val.equals("L"))
						{
							out.println( "clearDefaultList('document') ; " ) ;
							out.println( "addList_Values(\" " +OrderTypeDataCons + "\") ; " ) ;
						}
						/*else
						{
						for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
							String[] record = (String[])OrderTypeData.get(i);
							out.println( "addListValues(\" " +record[0] + "\",\"" + record[0] + "\",\""+default_val+"\") ; " ) ;
						}
						}*/
					}
				}
				
//		 - to populate the values of the defalut option in modal window in the case of LIST - End
			}
			else
			{
				String level = (String)hash.get("level") ;
				if ((!order_category.equals("PH")) && (level != null && level.equals("H")))
					out.println("clearList1('document');");
				else
					out.println( "clearL2List('document') ; " ) ;

				ArrayList OrderTypeData = beanObj.getOrderTypeData(order_category) ;
				for( int i=0 ; i< OrderTypeData.size() ; i++ ) 
				{
					String[] record = (String[])OrderTypeData.get(i);
					out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
			}
	}
	else if(validate.equals("Formatvalues"))
	{
				String key = beanObj.checkForNull(request.getParameter("key"),"") ;
				String value = beanObj.checkForNull(request.getParameter("value"),"") ;	
				beanObj.setFormatListValues(key,value);
	}
	else if ( validate.equals( "getdefValue" ) )
	{
				String defKeysValue=beanObj.getFormatListVal(getdefaultValue);
				out.println( defKeysValue) ;
				
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
