package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __disdatachartdateincrement extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/DisDataChartDateIncrement.jsp", 1741273667014L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script src=\'../../eCA/js/DisDataCharting.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></SCRIPT>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

			ResultSet rs=null;
			PreparedStatement  stmt=null;
		

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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

			Connection con =null;
			try{
				con = ConnectionManager.getConnection(request);
				String date = request.getParameter("date");
				String flag=request.getParameter("flag");
				String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
				String newDate="";
				String sql="";
				
				if(!flag.equals("go")){
					if(flag.equals("right")){
						//sql="SELECT to_char(to_date('"+date+"','dd/mm/yyyy')+1,'dd/mm/yyyy') from dual";//common-icn-0180
						sql="SELECT to_char(to_date(?,'dd/mm/yyyy')+1,'dd/mm/yyyy') from dual"; //common-icn-0180
					}
					else if(flag.equals("left")){
						//sql="SELECT to_char(to_date('"+date+"','dd/mm/yyyy')-1,'dd/mm/yyyy') from dual";//common-icn-0180
						sql="SELECT to_char(to_date(?,'dd/mm/yyyy')-1,'dd/mm/yyyy') from dual";//common-icn-0180
					}
					stmt = con.prepareStatement(sql);
					//common-icn-0180 starts
					if(flag.equals("right")){
					stmt.setString(1,date);
					}
					else if(flag.equals("left")){
					stmt.setString(2,date);
					}
					//common-icn-0180 ends
					rs = stmt.executeQuery();
					while(rs.next()){
						newDate = rs.getString(1);
					}
					String a1con="<script>top.content.workAreaFrame.titleFrame.document.forms[0].date.value='"+newDate+"';</script>";
					out.println(a1con);
				
				}else{
					
					sql="select distinct to_char(TEST_OBSERV_DT_TM,'hh24:mi:ss') from ca_encntr_discr_msr where patient_id=? and TEST_OBSERV_DT_TM  between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') +.9999";

					stmt = con.prepareStatement(sql);
					stmt.setString(1,patient_id);
					stmt.setString(2,date);
					stmt.setString(3,date);
					rs = stmt.executeQuery();
					
					String fill="<script> var str='Time Stamp <select name=time onchange=loadMainPage(\"Error\")>';";
		
					if(rs.next()){
						do{
							fill=fill + "str+='<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>';";
						}while(rs.next());
							if(rs !=null) rs.close();
							if(stmt !=null) stmt.close();
							fill=fill + "str+='</select>'; top.content.workAreaFrame.titleFrame.document.getElementById('idtime').innerHTML=str; top.content.workAreaFrame.titleFrame.loadMainPage(\"Error\");</script>";
						}else{
						         fill="<script>top.content.workAreaFrame.titleFrame.document.getElementById('idtime').innerHTML='';alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>";
					}
					out.println(fill);
				}
		
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
		}catch(Exception e){}
		finally{
					if(con!=null)ConnectionManager.returnConnection(con,request);
				}
	
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
