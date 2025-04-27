package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
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

public final class __estimatdepositajaxcall extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/Estimatdepositajaxcall.jsp", 1709114124802L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="    \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n    \n    ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n    \n   ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );
	
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

private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
  
    String beanId = "EstimateDepositBean";
	String beanName = "eBL.BLEstimateDepositBean";
	BLEstimateDepositBean depositbean = (BLEstimateDepositBean) getBeanObject(beanId, beanName, request); 
	List<BLEstimateDepositBean> depositlist = new ArrayList<BLEstimateDepositBean>();  
	BLEstimateDepositBean bean=null;
	BLEstimateDepositBean depositbean_test =null;
	
	System.out.println(" After Bean read");
	String strlastrow=request.getParameter("lrow");
	int lrow;
	if(strlastrow==null || ("").equals(strlastrow))
	{
	   	lrow=0;
	}
		
	else
	lrow=Integer.parseInt(strlastrow);
	
	
	if(lrow==0){
		System.out.println("beean cleared");
		depositbean.setDepositList(null);
	}
	
	
	System.out.println("lrow="+lrow);
	
String strbase_qty=request.getParameter("base_qty");
int base_qty=0;
if(strbase_qty==null || ("").equals(strbase_qty))
{
	base_qty=0;
}
	
else
base_qty=Integer.parseInt(strbase_qty);
System.out.println("base_qty="+base_qty);

String strbase_rate=request.getParameter("base_rate");
int base_rate=0;
if(strbase_rate==null || ("").equals(strbase_rate))
{
	base_rate=0;
}
	
else
{
base_rate=Integer.parseInt(strbase_rate);
}
System.out.println("base_rate="+base_rate);

String day_type_code=request.getParameter("day_type_code");
System.out.println("day_type_code="+day_type_code);

String time_type_code=request.getParameter("time_type_code");
System.out.println("time_type_code="+time_type_code);
System.out.println("lrow="+lrow);
for(int i=1; i<=lrow; i++)
	{
						
		
	/*	System.out.println("code="+request.getParameter("service_code"+i));
		System.out.println("qty="+request.getParameter("qty"+i));
		System.out.println("charges="+request.getParameter("charges_"+i));
		System.out.println("Rc="+request.getParameter("Rc"+i));*/
		
			System.out.println("inside for"+i);

			String service_code=request.getParameter("service_code"+i);
					if(service_code.equals("undefined"))
					{
						
					}
					System.out.println("service_code"+service_code);
				if(!"".equals(service_code) && !"null".equals(service_code) && !"undefined".equals(service_code))
				{
				bean=new BLEstimateDepositBean();
				System.out.println("inside if");
				bean.setService_code(request.getParameter("service_code"+i));
				bean.setRate_charge(request.getParameter("Rc"+i));
				bean.setCharges(request.getParameter("charges_"+i));
				bean.setQty(request.getParameter("qty"+i));
				bean.setDatetime(request.getParameter("datetime"+i));
				bean.setLine(request.getParameter("line"+i));
				bean.setService_desc(request.getParameter("service_desc"+i));
				bean.setService_indicator(request.getParameter("service_indicator"+i));
				bean.setEsttotal(request.getParameter("esttotal"));
				bean.setDay_type(day_type_code);
				bean.setTime_type(time_type_code);
				bean.setBase_rate(Integer.toString(base_rate));
				bean.setBase_qty(Integer.toString(base_qty));	
				
				
				depositlist.add(bean);		
				}
				
				
			/*	System.out.println("i value =" +i);
				code =request.getParameter("service_code"+i);
				desc = request.getParameter("service_desc"+i); 
				strcharges=request.getParameter("charges_"+i);
				qty=request.getParameter("qty"+i);
				ratecharge=request.getParameter("Rc"+i);	
				System.out.println("code"+code);
				System.out.println("desc"+desc);
				System.out.println("charges="+strcharges);
				System.out.println("qty="+qty); 
				System.out.println("ratecharge="+ratecharge);*/
				
		
	}
	
	depositbean.setDepositList(depositlist);	
	putObjectInBean(beanId,depositbean,request);
	
	
	depositbean_test = (BLEstimateDepositBean) getBeanObject(beanId, beanName, request);
	List<BLEstimateDepositBean> depositlist1 = depositbean_test.getDepositList();
	
 	//int size=depositlist1.size();
	
	
	System.out.println("Bean Add in ajax call page");
	for (Iterator iterator = depositlist1.iterator(); iterator.hasNext();)
	{

		System.out.println("inside for  in ajax call page");		
	depositbean = (BLEstimateDepositBean) iterator.next();
	System.out.println("service code="+depositbean.getService_code());
	System.out.println("charges="+depositbean.getCharges());
	System.out.println("qty="+depositbean.getQty());
	System.out.println("Rc="+depositbean.getRate_charge());
	System.out.println("base_qty="+depositbean.getBase_qty());
	System.out.println("base_rate="+depositbean.getBase_rate());
	System.out.println("day_type_code="+depositbean.getDay_type());
	System.out.println("time_type_code="+depositbean.getTime_type());
	
	}
	
	
    
    
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
