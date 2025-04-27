package jsp_servlet._exb._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eXB.*;
import eXB.XBDBAdapter;
import webbeans.eCommon.ConnectionManager;

public final class __vieweventsbillexport extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exb/jsp/ViewEventsBillExport.jsp", 1709117562461L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection connection	= null;
	Statement statement		= null;
	ResultSet resultSet		= null;
	String eventtype		= "";
	String protocolLinkID	= "";
	ArrayList rec = null;
	try {										    
		int errFlag				   = 0;									      
		String exceptions	   = "";
		String func_mode	   = request.getParameter("func_mode");					 
		Hashtable hash		   = (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						   = (Hashtable)hash.get( "SEARCH" ) ;
		String sqlQry	       = "";  											  
		if(func_mode!= null && func_mode.equals("genExport")) {
		String whereClause   = java.net.URLDecoder.decode((String) hash.get("whereClause"));			   
	    eventtype					= (String) hash.get("eventtype");				  
		String msgIdsList		= (String) hash.get("msgIdsList");

		whereClause     =  java.net.URLDecoder.decode(whereClause);					   
		try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of ViewEventsBillExport  :"+exp.toString());
			exp.printStackTrace(System.err);
		}		
		request.setAttribute("action_attr","R");	   
		XHElectronicBillsControllerBean xhBean=XHElectronicBillsControllerBean.getBean(XHElectronicBillsControllerBean.strBeanName,request,session);
        xhBean.action(request,connection);	    
	//	String strData[][]= xhBean.getDatabaseData();
		TreeMap tm=xhBean.treempselect;   
		  ArrayList b1=new ArrayList();     
		Set set = tm.entrySet(); 
		Iterator i = set.iterator(); 
		while(i.hasNext()) { 
					Map.Entry me = (Map.Entry)i.next(); 		    
							  b1.add(me.getValue());
			}   											    

					  String mesglist="";

					for(int K=0;K<b1.size();K++)
					{
							rec = (ArrayList)b1.get(K); 


						mesglist=mesglist+"'"+rec.get(3)+"'"+",";	 
					}

				   mesglist=mesglist+msgIdsList;
				   mesglist=mesglist.substring(0,(mesglist.length()));

        sqlQry = "UPDATE  XB_APPLICATION_MESSAGE  SET MESSAGE_STATUS = '' WHERE EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)  "+whereClause+" AND MESSAGE_ID IN ("+mesglist+")";

		
		try{		
		    statement = connection.createStatement();
			System.out.println("sqlQry: "+sqlQry);
			int updtCnt = statement.executeUpdate(sqlQry);   
			System.out.println("updtCnt: "+updtCnt);			
            connection.commit();												  
			out.println("getGatewayServer()");
		}
		catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ViewEventsBillExport  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
				System.out.println(" ViewEventsBillExport errFlag : "+errFlag);		
				/*	if(connection!=null){
					ConnectionManager.returnConnection(connection);
				}*/
		}
		}
		else if(func_mode!= null && func_mode.equals("genAccessionNum")) {     
					  
		String accession_number		=  (String) hash.get("accession_number");	   
		String OptionYN	= (String) hash.get("OptionYN");
		if(OptionYN.equals(""))														   
		{
			OptionYN="N";
		}
		  
	/*	try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of ViewEventsBillExport  :"+exp.toString());
			exp.printStackTrace(System.err);
		} */
		request.setAttribute("action_attr","R");
		XHElectronicBillsControllerBean xhBean=XHElectronicBillsControllerBean.getBean(XHElectronicBillsControllerBean.strBeanName,request,session);
		 xhBean.setSelectedRecords(connection,OptionYN,accession_number); 
       // xhBean.action(request,connection);	    
		         
		
																			   		    
		try{		
		    										  
			out.println("funLoad()");
		}																		   
		catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ViewEventsBillExport  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
				System.out.println(" ViewEventsBillExport errFlag : "+errFlag);			 
		}
		} // end of genAccessionNum
	}
	catch (Exception e) {
		e.printStackTrace() ;
	}
		finally{
			try{
			     if(resultSet!=null) resultSet.close();
				 if(statement!=null) statement.close();
			}catch(Exception es){
				es.printStackTrace() ;
			}
				if(connection!=null){
					ConnectionManager.returnConnection(connection);
				}
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
