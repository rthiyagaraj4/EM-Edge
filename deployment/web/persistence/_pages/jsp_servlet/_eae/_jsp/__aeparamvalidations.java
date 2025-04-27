package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __aeparamvalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEParamValidations.jsp", 1709113842413L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEParameter.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head> \n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code1.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_cat_code1.value=\"\";\t\t\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code1.focus();\n\t\t\t</script>\n        ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code6.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_cat_code6.value=\"\";\t\t\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code6.focus();\n\t\t\t</script>\n        ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script>\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code3.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_cat_code3.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code3.focus();\n\t\t\t</script>\n        ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code5.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_cat_code5.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code5.focus();\n\t\t\t</script>\n        ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code2.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_cat_code2.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code2.focus();\n\t\t\t</script>\n        ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code4.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_cat_code4.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.order_catalog_code4.focus();\n\t\t\t</script>\n        ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script>\n\t\t\tparent.f_query_add_mod.document.parameter_form.systolicBP.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.systolicBPhdd.value=\"\";\t\t\t\n\t\t\tparent.f_query_add_mod.document.parameter_form.systolicBP.focus();\n\t\t\t</script>\n        ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<script>\n\t\t\tparent.f_query_add_mod.document.parameter_form.respiratory.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.respiratoryhdd.value=\"\";\n\t\t\tparent.f_query_add_mod.document.parameter_form.respiratory.focus();\n\t\t\t</script>\n        ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<script>\n\t\t\tparent.f_query_add_mod.document.parameter_form.submit();\n\t</script> \n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<script>top.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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

	Connection connection			=	null;
	PreparedStatement pst	        =	null;
	ResultSet		rs				=	null;
	StringBuffer sql  			    =	new StringBuffer();
	String spo2 = "empty";
	String fbc = "empty";
	String bloodSugar = "empty";
	String ecg = "empty";
	String dressing = "empty";
	String systolicBP = "empty";
	String respiratory = "empty";
	String cbd = "empty";//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
	int flag = 0;
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String dataName = request.getParameter("dataName");
	String dataValue = request.getParameter("dataValue");
	MessageManager mm = new MessageManager();

	dataName = (dataName == null || dataName == "")?"empty":dataName;
	dataValue = (dataValue == null || dataValue == "")?"empty":dataValue;

     

    if(dataName.equals("empty")){
		spo2 = request.getParameter("spo2");
		fbc = request.getParameter("fbc");	
		bloodSugar = request.getParameter("bloodSugar");
		ecg = request.getParameter("ecg");
		dressing = request.getParameter("dressing");
		systolicBP = request.getParameter("systolicBP");	
		respiratory = request.getParameter("respiratory");
		cbd = request.getParameter("cbd");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
	}
	else{
		flag = 1;
		if(dataName.equals("order_catalog_code1"))
			spo2 = dataValue;
		if(dataName.equals("order_catalog_code2"))
			ecg = dataValue;
		if(dataName.equals("order_catalog_code3"))
			fbc = dataValue;
		if(dataName.equals("order_catalog_code4"))
			dressing = dataValue;
		if(dataName.equals("order_catalog_code5"))
			bloodSugar = dataValue;
		if(dataName.equals("systolicBP"))
			systolicBP = dataValue;
		if(dataName.equals("respiratory"))
			respiratory = dataValue;
	}
	int count = 0;
	try
	{
		 connection			= ConnectionManager.getConnection(request);
         
  		 // Checking for SPO2
		 if(!spo2.equals("empty")){ 
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code) AND upper(long_desc) like upper('"+spo2+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
		    count	=	rs.getInt("countValue");
	
			if(count == 0) {
				
					final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SpO2.label","ae_labels")); 
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;	       
		
            _bw.write(_wl_block8Bytes, _wl_block8);
 
			}
			sql.delete(0,sql.length());
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
		 }
  		 
		 /*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
		 // Checking for CBD
		 if(!cbd.equals("empty")){ 
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code) AND upper(long_desc) like upper('"+cbd+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
		    count	=	rs.getInt("countValue");

			if(count == 0) {
				
					final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.CBD.label","ae_labels")); 
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;	       
		
            _bw.write(_wl_block9Bytes, _wl_block9);
 
			}
			sql.delete(0,sql.length());
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
		 }
		 /*End*/

		// Checking FOR FBC
		if(!fbc.equals("empty")){
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code) AND upper(long_desc) like upper('"+fbc+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
			    count	=	rs.getInt("countValue");
		
			if(count == 0) {
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.FBC.label","ae_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
		
            _bw.write(_wl_block10Bytes, _wl_block10);
 
			}
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}
			
		
// Checking FOR BLOOD SUGAR
		if(!bloodSugar.equals("empty")) {
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code) AND upper(long_desc) like upper('"+bloodSugar+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
				count	=	rs.getInt("countValue");
	
			if(count == 0) {
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.CapillaryBloodSugar.label","ae_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
		
            _bw.write(_wl_block11Bytes, _wl_block11);
 
			}
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}

		// Checking FOR ECG
		if(!ecg.equals("empty")) {
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code)   AND upper(long_desc) like upper('"+ecg+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
			    count	=	rs.getInt("countValue");
			if(count == 0) {
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ecg.label","common_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
		
            _bw.write(_wl_block12Bytes, _wl_block12);
 
			}
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}

// Checking FOR DRESSING
		if(!dressing.equals("empty")) {
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code) AND upper(long_desc) like upper('"+dressing+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
				count	=	rs.getInt("countValue");
	
			if(count == 0) {
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Dressing.label","common_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
		
            _bw.write(_wl_block13Bytes, _wl_block13);
 
			}
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}
		
		 //Checking FOR SYSTOLIC BP
		if(!systolicBP.equals("empty")) {
			 sql.append("SELECT count(*) countValue FROM am_discr_msr WHERE upper(short_desc) like upper('"+systolicBP+"%')");
			
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
				count	=	rs.getInt("countValue");
			
			
			if(count == 0) {

				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SystolicBP.label","ae_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
			
            _bw.write(_wl_block14Bytes, _wl_block14);
 
			}
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}
		
		// Checking FOR RESPORIATORY
		if(!respiratory.equals("empty")) {
			sql.append("SELECT count(*) countValue FROM am_discr_msr WHERE upper(short_desc) like upper('"+respiratory+"%')");
			
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();			
			if ((rs != null) && (rs.next()))
			{
				count	=	rs.getInt("countValue");

			}
			if(count == 0) {
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.RespiratoryRate.label","ae_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
				
            _bw.write(_wl_block15Bytes, _wl_block15);
 
			}

			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}


		if(pst!=null) pst.close();
		if(rs!=null) rs.close();

		if(flag == 0)
	
            _bw.write(_wl_block16Bytes, _wl_block16);
}catch(Exception exception)
	{
		exception.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(connection, request);
	}

            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
