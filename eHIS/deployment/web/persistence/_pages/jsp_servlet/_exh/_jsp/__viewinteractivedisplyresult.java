package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __viewinteractivedisplyresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewInteractiveDisplyResult.jsp", 1709122404006L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n<script language=\"JavaScript\">\nfunction refresh()\n{\n\t  this.document.forms[0].action=\'../eXH/jsp/ViewEventsInteractiveDtlTest1.jsp\';\n\t  this.document.forms[0].target=\'f_query_add_mod\';\n\t  this.document.forms[0].submit();\n}\n</script>\n</head>\n\n<BODY CLASS=\"MESSAGE\"   onLoad=\"refresh();\">\n<form name=\"\" id=\"\" method=\"\" action=\'\'  >\n<p align=\"left\">\n\n<br>\n<br>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<script language=\"JavaScript\">\n  alert(\'";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\');\n\t\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</p>\n     <input type=\'hidden\' name=\'msg_status\' id=\'msg_status\' value=";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" >\n\t<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'facility\' id=\'facility\' value=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =">\n\t<input type=\'hidden\' name=\'msg_id1\' id=\'msg_id1\' value=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =">\n\t<input type=\'hidden\' name=\'msg_dt1\' id=\'msg_dt1\' value=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =">\n\t<input type=\'hidden\' name=\'msg_id2\' id=\'msg_id2\' value=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =">\n\t<input type=\'hidden\' name=\'msg_dt2\' id=\'msg_dt2\' value=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =">\n\t<input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' value=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =">\n\t<input type=\'hidden\' name=\'order\' id=\'order\' value=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n\t<input type=\'hidden\' name=\'pat_id\' id=\'pat_id\' value=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">\n\t<input type=\'hidden\' name=\'merg_pat_id\' id=\'merg_pat_id\' value=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">\n\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n\t<input type=\'hidden\' name=\'action_typ\' id=\'action_typ\' value=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n\t<input type=\'hidden\' name=\'last_processed_date\' id=\'last_processed_date\' value=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t<input type=\'hidden\' name=\'not_req_rsn\' id=\'not_req_rsn\' value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n\t<input type=\'hidden\' name=\'addid\' id=\'addid\' value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\t<input type=\'hidden\' name=\'addeddate\' id=\'addeddate\' value=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n\t<input type=\'hidden\' name=\'addedwsno\' id=\'addedwsno\' value=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t<input type=\'hidden\' name=\'modfid\' id=\'modfid\' value=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">\n   <input type=\'hidden\' name=\'modifieddate\' id=\'modifieddate\' value=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\n   <input type=\'hidden\' name=\'modifiedwsno\' id=\'modifiedwsno\' value=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">\n   <input type=\'hidden\' name=\'msg_date\' id=\'msg_date\' value=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">\n    <input type=\'hidden\' name=\'applnname\' id=\'applnname\' value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\n   <input type=\'hidden\' name=\'eventtype\' id=\'eventtype\' value=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">\n   <input type=\'hidden\' name=\'purge_status\' id=\'purge_status\' value=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">\n   <input type=\'hidden\' name=\'comm_mode\' id=\'comm_mode\' value=\'Outbound\'>\n   <input type=\'hidden\' name=\'interface_module\' id=\'interface_module\' value=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n   <input type=\'hidden\' name=\'sub_module\' id=\'sub_module\' value=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">\n   <input type=\'hidden\' name=\'protocol_link_id\' id=\'protocol_link_id\' value=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">\n   <input type=\'hidden\' name=\'event_status\' id=\'event_status\' value=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">\n\n</form>\n</BODY>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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

		String  msg_id1,msg_dt1,msg_id2,msg_dt2,msg_status,facility,orderBy,order,reason,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,purge_status;
 			msg_id1=null;
			msg_dt1=null;
			msg_id2=null;
			msg_dt2=null;
			msg_status=null;
			facility=null;
			reason=null;
			pat_id=null;
			merg_pat_id=null;
			episode_type=null;
			episode_id=null;
			visit_id=null;
			action_typ=null;
			last_processed_date=null;
			not_req_rsn=null;
			addid=null;
			addeddate=null;
			addedwsno=null;
			modfid=null;
			modifieddate=null;
			modifiedwsno=null;
	 	    msg_date=null;
			applnname=null;
			eventtype=null;
			applnname=null;
			eventtype=null;
			purge_status=null;
			String interface_module = null;
			String sub_module = null;
			String protocol_link_id = null;
			String event_status = null;

			String   result=(String)request.getParameter( "message" );	
				orderBy =request.getParameter("orderBy");
			    order=request.getParameter("order");
		        msg_status=request.getParameter("msg_status");
				facility      =request.getParameter("facility"); 
                msg_id1 =request.getParameter("msg_id1"); 
 	   		    msg_id2 =request.getParameter("msg_id2");  
				msg_dt1 =request.getParameter("msg_dt1"); 
 			    msg_dt2 =request.getParameter("msg_dt2"); 
				pat_id=request.getParameter("pat_id");
				merg_pat_id=request.getParameter("merg_pat_id");
				episode_type=request.getParameter("episode_type");
				episode_id=request.getParameter("episode_id");
				visit_id=request.getParameter("visit_id");
				action_typ=request.getParameter("action_typ");
				last_processed_date=request.getParameter("last_processed_date");
				not_req_rsn=request.getParameter("not_req_rsn");
				addid=request.getParameter("addid");
				addeddate=request.getParameter("addeddate");
				addedwsno=request.getParameter("addedwsno");
				modfid=request.getParameter("modfid");
				modifieddate=request.getParameter("modifieddate");
				modifiedwsno=request.getParameter("modifiedwsno");
	 			msg_date=request.getParameter("msg_date");
				eventtype=request.getParameter("eventtype");
				applnname=request.getParameter("applnname");
				purge_status=request.getParameter("purge_status");
				interface_module=request.getParameter("interface_module");
				sub_module=request.getParameter("sub_module");
				protocol_link_id=request.getParameter("protocol_link_id");
				event_status = request.getParameter("event_status");
				
	
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(result));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf( msg_status ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(facility ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(msg_id1 ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(msg_dt1 ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(msg_id2 ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(msg_dt2 ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(orderBy ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(order ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pat_id ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(merg_pat_id ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(episode_id ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(visit_id ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(action_typ ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(last_processed_date ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(not_req_rsn ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(addid ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(addeddate ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(addedwsno ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(modfid ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(modifieddate ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(modifiedwsno ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(msg_date ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(applnname ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(eventtype ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(interface_module));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(protocol_link_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block32Bytes, _wl_block32);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
