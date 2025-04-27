package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eXH.*;
import eXH.XHDBAdapter;
import webbeans.eCommon.ConnectionManager;

public final class __querybasedinboundvalidateqry extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/QueryBasedInboundValidateQry.jsp", 1709117586158L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);


		Connection connection	= null;
		CallableStatement ostmt = null;
		Hashtable hash = new Hashtable();
		HashMap hdrRslt = new HashMap();

		HashMap appl = new HashMap();
		HashMap faclty = new HashMap();
		HashMap evnt = new HashMap();
		HashMap sgmnt = new HashMap();
		HashMap inbndApi = new HashMap();

		HashMap colRslt = new HashMap();

		ArrayList tblNames = new ArrayList();
		ArrayList colNames = new ArrayList();
		ArrayList colTypes = new ArrayList();

try { 
		
//		Statement statement		= null;
//		ResultSet resultSet		= null;
		int errFlag				= 0;
		String exceptions		= "";
		String message_text2	= "";

		String func_mode			= request.getParameter("func_mode");
			//System.out.println("QueryBasedInboundValidateQry : "+func_mode);
		hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_name    = QueryBasedInboundBean.strBeanName;


			//System.out.println("QryBsdValidatQry bean_name : "+bean_name);
		QueryBasedInboundBean beanObj		= (QueryBasedInboundBean)QueryBasedInboundBean.getBean(bean_name,request,session);

		//System.out.println("QueryBasedInboundValidateQry beanObj: "+beanObj);

		if(func_mode!= null && func_mode.equals("getHeader")) {
			hdrRslt = beanObj.getHeaderData();
			//System.out.println("HshMap size : "+hdrRslt.size());

			for(int i=0; i<hdrRslt.size(); i+=1) {
				appl	= (HashMap)hdrRslt.get("Application");
				faclty	= (HashMap)hdrRslt.get("Facility");
				evnt	= (HashMap)hdrRslt.get("Event");
				sgmnt		= (HashMap)hdrRslt.get("Segment");
				inbndApi	= (HashMap)hdrRslt.get("InboundApi");
			}

				out.println("clearAppNames('App')");
	//			//System.out.println("App Id Size : "+app_id.size());
				 for (Iterator it = appl.keySet().iterator(); it.hasNext();) {
					String type = (String) it.next();
	//					//System.out.println("VldtQry App Id : "+type);
					String desc=	(String)appl.get(type);
	//					//System.out.println("VldtQry App Name : "+desc);

				out.println("addAppNames('App','"+type+"','"+desc+"')");
				}

				out.println("clearAppNames('Fac')");
				 for (Iterator it = faclty.keySet().iterator(); it.hasNext();) {
					String type = (String) it.next();
	//					//System.out.println("VldtQry Fac Id : "+type);
					String desc=	(String)faclty.get(type);
	//					//System.out.println("VldtQry Fac Name : "+desc);

				out.println("addAppNames('Fac','"+type+"','"+desc+"')");
				}

				out.println("clearAppNames('Evnt')");
				 for (Iterator it = evnt.keySet().iterator(); it.hasNext();) {
					String type = (String) it.next();
	//					//System.out.println("VldtQry evnt Id : "+type);
					String desc=	(String)evnt.get(type);
	//					//System.out.println("VldtQry evnt Name : "+desc);

				out.println("addAppNames('Evnt','"+type+"','"+desc+"')");
				}

				out.println("clearAppNames('Sgmnt')");
				 for (Iterator it = sgmnt.keySet().iterator(); it.hasNext();) {
					String type = (String) it.next();
					String desc=	(String)sgmnt.get(type);

				out.println("addAppNames('Sgmnt','"+type+"','"+desc+"')");
				}

				out.println("clearAppNames('InbApi')");
				 for (Iterator it = inbndApi.keySet().iterator(); it.hasNext();) {
					String type = (String) it.next();
					String desc=	(String)inbndApi.get(type);

				out.println("addAppNames('InbApi','"+type+"','"+desc+"')");
				}
		}
		
		if(func_mode!= null && func_mode.equals("setTables")) {
			String mod_name		 = (String) hash.get( "param" );

			tblNames	 = beanObj.getTables(mod_name);
	
			out.println("clearTables()");
			for(int i=0; i<tblNames.size(); i+=1) {
				String desc	=	(String)tblNames.get(i);
				out.println("addTable('"+desc+"','"+desc+"')");
			}
			
		}

		if(func_mode!= null && func_mode.equals("setCols")) {
			String tbl_name		 = (String) hash.get( "param" );
			colRslt	 = beanObj.getCols(tbl_name);
				colNames	=	(ArrayList)colRslt.get("colNames");
				colTypes	=	(ArrayList)colRslt.get("colTypes");
			
			out.println("clearCols()");
			for(int i=0,j=0; i<colNames.size(); i+=1,j+=1) {
				String desc	=	(String)colNames.get(i);
				String type =	(String)colTypes.get(j);
				out.println("addColumn('"+type+"','"+desc+"')");
			}
			//System.out.println("setCols 131");
		}

		if(func_mode!= null && func_mode.equals("validateQry")) {
			String qResult		 = (String) hash.get( "qResult" ); 
			//System.out.println("QuerybsdinbVldQry escqResult: "+qResult);
			qResult			     =	java.net.URLDecoder.decode(qResult);
			String tbl_name		 = (String) hash.get( "tbl_name" );
			String qryType		 = (String) hash.get( "qryType" ); 
			//System.out.println("QuerybsdinbVldQry unescqResult: "+qResult);
			//System.out.println("QueryBasedInboundValidateQry qryType: "+qryType);

	if(qryType.equals("insertquery")){			

		try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of QueryBasedInboundValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
		}
		try{		
			 ostmt = connection.prepareCall("{ call Xg_prc.check_null_stat_insert_sm(?,?,?) }" ); 

			 ostmt.setString(1,qResult);
		 	 ostmt.setString(2,tbl_name);
			
			 //System.out.println("QueryBasedInboundValidateQry tbl_name: "+tbl_name);

			 ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			 
		     ostmt.execute();
			 		
			 message_text2 = ostmt.getString(3);
	  		 //System.out.println("Call EJB message_text2 : "+message_text2);
		     ostmt.close();
		}
		catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of QueryBasedInboundValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
			exceptions = java.net.URLEncoder.encode(exceptions);
			qResult = java.net.URLEncoder.encode(qResult);			out.println("parent.setErrorTxt('"+errFlag+"','"+exceptions+"','"+message_text2+"','"+qryType+"','"+qResult+"')");
		}
	 }
	 else if(qryType.equals("updatequery")){				 	
		qResult = java.net.URLEncoder.encode(qResult);	out.println("parent.setErrorTxt('"+errFlag+"','"+exceptions+"','"+message_text2+"','"+qryType+"','"+qResult+"')");
	 }
	}

		if(func_mode!= null && func_mode.equals("chkNotNull")) {
			String tbl_name		 = (String) hash.get( "tbl_name" ); 
			String slctd_ColVal		 = (String) hash.get( "slctd_ColVal" );	
		try{		
			 ostmt = connection.prepareCall("{ call Xg_prc.check_null_status(?,?,?) }" ); 

			 ostmt.setString(1,slctd_ColVal);
		 	 ostmt.setString(2,tbl_name);
			
			 //System.out.println("QueryBasedInboundValidateQry tbl_name: "+tbl_name);

			 ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
			 
		     ostmt.execute();
		
			 message_text2 = ostmt.getString(3);
	  		 //System.out.println("Call EJB message_text2 : "+message_text2);
		     ostmt.close();
		}
		catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of QueryBasedInboundValidateQry  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
			exceptions = java.net.URLEncoder.encode(exceptions);	out.println("parent.setErrorTxt('"+errFlag+"','"+exceptions+"','"+message_text2+"')");
		}
		} // end of if
	}
	catch (Exception e) {
		e.printStackTrace() ;
	}

	finally{

		if(connection != null) ConnectionManager.returnConnection(connection);

		if(hdrRslt!=null) hdrRslt.clear();
		
		if(appl!=null) appl.clear();
		if(faclty!=null) faclty.clear();
		if(evnt!=null) evnt.clear();
		if(sgmnt!=null) sgmnt.clear();
		if(inbndApi!=null) inbndApi.clear();

		if(tblNames!=null) tblNames.clear();
		if(colRslt!=null) colRslt.clear();
		if(colNames!=null) colNames.clear();
		if(colTypes!=null) colTypes.clear();
	}


            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
