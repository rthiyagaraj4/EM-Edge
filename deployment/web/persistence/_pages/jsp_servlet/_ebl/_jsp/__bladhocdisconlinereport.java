package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import ecis.utils.OnlineReports;
import ecis.utils.OnlineReport;
import java.util.*;

public final class __bladhocdisconlinereport extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAdhocDiscOnlineReport.jsp", 1729095282672L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);



try{

String calledForReceipt = request.getParameter("calledForReceipt");
if(calledForReceipt == null){
	calledForReceipt = "";
}

HashMap<String,String> asyncPrinterAttrib = null;

if("Y".equals(calledForReceipt)){
	System.err.println("Called For Receipt");
	asyncPrinterAttrib = (HashMap<String,String>)session.getAttribute("ASYNC_PRINTER_ATTRIB_RECEIPT");
}
else{
	System.err.println("Called For Original");
	asyncPrinterAttrib = (HashMap<String,String>)session.getAttribute("ASYNC_PRINTER_ATTRIB");
}

System.err.println("asyncPrinterAttrib->"+asyncPrinterAttrib);
Set<String> kSet=asyncPrinterAttrib.keySet();
Iterator<String> it=kSet.iterator();

while(it.hasNext()){
	String str_bill_prt_format_vals=it.next();
	String strBlrblprt=asyncPrinterAttrib.get(str_bill_prt_format_vals);
	String locale = (String)session.getAttribute("LOCALE"); 
	String str_facility_id = (String)session.getAttribute("facility_id"); 
	String pgm_id=null;
	String session_id=null;
	String pgm_date=null;
	String mpi_id_rep=null;						
		
	StringTokenizer st1 = new StringTokenizer(str_bill_prt_format_vals,"/");

		while(st1.hasMoreTokens())
		{
			pgm_id = st1.nextToken();
			System.err.println("pgm_id in Disc:"+pgm_id);
			session_id = st1.nextToken();
			System.err.println("session_id in Disc:"+session_id);
			pgm_date = st1.nextToken();
			System.err.println("pgm_date in Disc:"+pgm_date);
			mpi_id_rep = st1.nextToken();
			System.err.println("mpi_id_rep in Disc:"+mpi_id_rep);
			st1.nextToken();
		}

		//Modified by muthukumar against Arabic Language change on 31-5-2012
		OnlineReport onlinereportParam = null;
	boolean printRcptSiteSpec=false;
	
		if(locale.equals("ar"))
			{
			Connection conn=null;
				try{
					
					conn=ConnectionManager.getConnection();
					
					printRcptSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(conn,
						"BL", "ARABIC_REPORT_PRINT");
					System.err.println("ss "+printRcptSiteSpec);
				}catch(Exception e)
				{
					e.printStackTrace();
					System.err.println("Exception in getting Report Id " + e);
					
				}
				finally{
					if(conn!=null)
					{
						try{
							conn.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
							System.err.println("Exception in returning connection "+e);
						}
					}
				}
			
				if(printRcptSiteSpec)
				{
					 onlinereportParam = new OnlineReport(str_facility_id, "BL", strBlrblprt);
				}
			
				else
				{
				 onlinereportParam = new OnlineReport(str_facility_id, "BL", "BLRBLPRTAKAR");	
				}
			}
			else
			{
				//Modified by DhanasekarV against PH ST specific report
			 onlinereportParam = new OnlineReport(str_facility_id, "BL", strBlrblprt);
			}
		
		System.err.println("session_id in strBlrblprt:"+strBlrblprt);
		//Modified by muthukumar against Arabic Language change on 31-5-2012

		onlinereportParam.addParameter("p_facility_id",str_facility_id);
		onlinereportParam.addParameter("p_pgm_date",pgm_date);
		onlinereportParam.addParameter("p_pgm_id",pgm_id);
		onlinereportParam.addParameter("p_Session_id",session_id);
	//	System.err.println("Online Report onlinereportParam in Disc:"+onlinereportParam);
		OnlineReports onlinereports = new OnlineReports();
		onlinereports.add(onlinereportParam);
		//System.err.println("Online Report Added in Disc:"+onlinereports);
		String strResults =  onlinereports.execute(request,response);
	//	System.err.println("Online Report Executed in Disc");
		System.err.println("ASYNC_PRINTER_ATTRIB"+strResults);
		
		//session.setAttribute("ASYNC_PRINTER_ATTRIB",null);

		onlinereportParam = null;
		onlinereports = null;		

	}

if("Y".equals(calledForReceipt)){
	session.removeAttribute("ASYNC_PRINTER_ATTRIB_RECEIPT");
}
else{
	session.removeAttribute("ASYNC_PRINTER_ATTRIB");
}
}catch(Exception e){
	e.printStackTrace();
	System.err.println("Err Msg from BLAdhocDiscOnlineReport.jsp "+e);
} 


            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
