package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.util.*;
import com.ehis.util.*;

public final class __rfidtagresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/RFIDTagResult.jsp", 1709118436712L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n\n\t<head>\n\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\t\t<script>\n\t\t function closeRFID(val){\t\t\t\t\t\t\n\t\tparent.window.returnValue = val\n\t\tparent.window.close();\n\t}\n\t\t</script>\n\t</head>\n \t\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<body onKeyDown = \'lockKey()\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<form name =\'RFIDTagForm\'>\n\t\t\t\t <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\t\t\t\t\t\n\t\t\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t  <tr width=\'100%\' >\n\t\t\t\t<td align=\'right\' class=\'white\'>\n\t\t\t\t\t<table align=\'right\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t   <td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t\t\t   <tr><td class=\'columnheader\' width=\'15%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td></tr>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script>\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\')); </script>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<script>document.getElementById(\"nextval\").innerHTML=\" \";</script>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\n</form>\n\t</body>\n\t</table>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			Connection	con			        = null;
			java.sql.Statement	stmt		= null;
			ResultSet	rs					= null;				
			PreparedStatement pstmt			= null;
		
			//String locale=(String)session.getAttribute("LOCALE"); 	
			String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			StringBuffer whereBuffer = new StringBuffer();
			StringBuffer sqlBuffer = new StringBuffer(); 
	try
	{
     	request.setCharacterEncoding("UTF-8");
		String rfid_tag_no			= checkForNull(request.getParameter("rfid_tag_no"));
		String patient_id			= checkForNull(request.getParameter("patient_id"));
		String search_criteria			= checkForNull(request.getParameter("search_criteria"));	
		con=ConnectionManager.getConnection(request);		
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;	
		String endOfRes="1";
		int start=0;
		int end=0;
		int i=1;
			if ( from == null )
            start = 1 ;
        else
            start = Integer.parseInt( from ) ;

        if ( to == null )
            end = 12 ;
        else
            end = Integer.parseInt( to ) ;
	
		if(!rfid_tag_no.equals("")){			  
			if(search_criteria.equals("S")){
				whereBuffer.append("and upper(rfid_tag_num) like upper('"+rfid_tag_no+"%') ");
			}else if(search_criteria.equals("E")){
				whereBuffer.append("and  upper(rfid_tag_num) like upper('%"+rfid_tag_no+"') ");
			}else  if(search_criteria.equals("C")){
				whereBuffer.append("and  upper(rfid_tag_num) like upper('%"+rfid_tag_no+"%') ");
			}		
		}
      
        String rfid_tag_num = "";       
        String rowclass = "";       
       //Maheshwaran k modified the Query for the Bru-HIMS-CRF-369 -IN039615 as on 29/08/2013
      	sqlBuffer.append( " select rfid_tag_num,occupying_patient_id from XT_RFID_TAG where occupying_patient_id is null ");
		if(!patient_id.equals("")){
			sqlBuffer.append("union  SELECT rfid_tag_num, occupying_patient_id FROM xt_rfid_tag where occupying_patient_id = '"+patient_id+"'   ");    
		}
		
		if(!whereBuffer.equals(""))
			sqlBuffer.append(whereBuffer);
			 
		 
		 
     			stmt = con.createStatement() ;				
				rs     = stmt.executeQuery(sqlBuffer.toString()) ;		

				if ( !(start== 1) )			
				for( int j=1; j<start; i++,j++ )   
				rs.next() ;  

				int count=0 ;
				
            _bw.write(_wl_block9Bytes, _wl_block9);
			
				
					while( i<=end && rs.next()){						
					   if ( count % 2 == 0 )
						  rowclass = "QRYEVEN" ;
					  else
						 rowclass = "QRYODD" ;
					  
            _bw.write(_wl_block10Bytes, _wl_block10);

					  if(count == 0){
            _bw.write(_wl_block11Bytes, _wl_block11);

							if ( !(start <= 1) )
							{
								out.println("<A HREF='../../eMO/jsp/RFIDTagResult.jsp?rfid_tag_no="+rfid_tag_no+"&search_criteria="+search_criteria+"&from="+(start-12)+"&to="+(end-12)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
							}

							if (endOfRes.equals("1"))
							 {
								out.println("<A id='nextval' HREF='../../eMO/jsp/RFIDTagResult.jsp?rfid_tag_no="+rfid_tag_no+"&search_criteria="+search_criteria+"&from="+(start+12)+"&to="+(end+12)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
							 }

							
							
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
					   count++;							
					    rfid_tag_num = rs.getString("rfid_tag_num");		
					    out.println("<tr style='background-color:'><td class='"+rowclass+"'><a href=javascript:closeRFID(\""+rfid_tag_num+"\")>");							
					    out.println(rfid_tag_num+"</a> ");
					    out.println("</td></tr>");
						i++;
     			      }
			       				
			
		
		if(count == 0){
            _bw.write(_wl_block14Bytes, _wl_block14);
}
		
		
		if (!rs.next() && count!=0 ){
		 endOfRes = "0";	
		 
            _bw.write(_wl_block15Bytes, _wl_block15);
 
		 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{		
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();			
				if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.RFIDTag.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
