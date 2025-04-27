package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __camainoptions3 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainOptions3.jsp", 1709115556918L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n    <head>\n        ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t    <script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n        <STYLE TYPE=\"text/css\">\n        A:link {\n            COLOR: white;\n        }\n\n        A:visited {\n            COLOR:white ;\n        }\n        A:active {\n            COLOR: white;\n        }\n        </STYLE>\n\n        ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n        <script>\n\t\t\tvar currClass = \'\';\n\n            function display(from)\n            {\n                cellref = document.getElementById(\"tab\").rows(0).cells\n                 if(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" == \"V\")\n                    cellref = document.getElementById(\"tab\").rows[0]\n\n                for(i=0; i<cellref.length; i++)\n                {\n                    if(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" == \"H\")\n                       cellref[i].className = \'CASECONDSELECTHORZ\'\n                     else\n                      cellref[i].cells[0].className = \'CASECONDSELECTVERT\'\n                }\n                if(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" == \"H\")\n\t\t\t\t{\n                    from.className = \"CATHIRDSELECTHORZ\"\n\t\t\t\t\tcurrClass =\"CATHIRDSELECTHORZ\";\n\t\t\t\t}\n                else\n\t\t\t\t{\n                    from.className = \"CATHIRDSELECTVERT\"\n\t\t\t\t\tcurrClass =\"CATHIRDSELECTVERT\";\n\t\t\t\t}\n            }\n\n\t\t\tfunction callOnMouseOver(obj)\n            {\n\t\t\t\tcurrClass = obj.className ;\n\t\t\t\t if(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" == \"H\")\n\t\t\t\t\tobj.className = \'CATHIRDSELECTHORZ\';\n\t\t\t\t else\n\t\t\t\t\tobj.className = \'CATHIRDSELECTVERT\';\n            }\n\n            function callOnMouseOut(obj)\n            {\n\t\t\t\tobj.className = currClass;\n            }\n\n            function callNextLevel(option_type,executable_name, option_id,option_desc,menu_position)\n            {\n               if(top.content !=null)\n                    top.content.messageFrame.location.href = \'../../eCommon/jsp/error.jsp\';\n                else\n                    top.messageFrame.location.href = \'../../eCommon/jsp/error.jsp\';\n\t\t\t\ttop.frames[1].frames[0].displayFunctionName(option_desc);//commontoolbar\n                var params = \"&";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"\n                var oper = \"&\"\n               if(executable_name.indexOf(\"?\") == -1)\n                    oper = \"?\"\n                parent.Detail.location.href = executable_name+oper+\"cname=CATHIRDWORKAREA&option_id=\"//+option_id+\"&\"+params\n            }\n        </script>\n    </head>\n\n    <body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n        <table id=\'tab\' cellspacing=0 cellpadding=\'3\' border=\'0\'>\n        ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n        </table>\n    </body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCA.CAOptions CaOptions = (webbeans.eCA.CAOptions)getObjectFromBean("CaOptions","webbeans.eCA.CAOptions",session);

            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

            String queryString = request.getQueryString()== null?"":request.getQueryString() ;
            String patient_id = request.getParameter("patient_id");
            String episode_id = request.getParameter("episode_id");
			//String episode_type= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
			String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
			String child_window = request.getParameter("child_window") ;
            boolean pat_sel = false ;

            if( patient_id!=null || episode_id != null )
                pat_sel = true;

            String menu_pos = request.getParameter("menu_pos")==null?"V":request.getParameter("menu_pos");
        
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(menu_pos));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(menu_pos));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(menu_pos));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(menu_pos));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block15Bytes, _wl_block15);

            String parent_option_id = request.getParameter("option_id");
            ArrayList thirdlevellist = CaOptions.getHeaders("3",parent_option_id) ;
            boolean bool  =false;
			boolean display = false;
			boolean first = true;
			String className = "";
			HashMap onthirdload = null;

            String cname = "CASECONDSELECTVERT";

            if(menu_pos.equals("H"))
            {
                out.println("<tr>");
                cname = "CASECONDSELECTHORZ";
             }

            for (int i=0; i<thirdlevellist.size(); i++)
            {
                if(menu_pos.equals("V"))
                    out.println("<tr>");
                HashMap thirdhash = ( HashMap ) thirdlevellist.get( i );
                String applicable_on_pat_yn = (String) thirdhash.get("APPLICABLE_ON_PAT_YN");
                String applicable_on_enc_yn = (String) thirdhash.get("APPLICABLE_ON_ENC_YN");
				//String applicable_category = (String) thirdhash.get("APPLICABLE_CATEGORY");
				display = false;

				if( (episode_id != null)&& (applicable_on_pat_yn.equals("Y") || applicable_on_enc_yn.equals("Y")) )
					bool = true;
				else
					if( (patient_id != null)&& applicable_on_pat_yn.equals("Y") )
						bool = true ;

				if(first)
				{
					if(menu_pos.equals("H"))
						className = "CATHIRDSELECTHORZ";
					else
						className = "CATHIRDSELECTVERT";
				}
				else
					className = cname;

				if(bool)
				{
					if(child_window.equals("N"))
						display = true;
					else
					{
						if(mode.equals("R"))
						{
							if(applicable_on_enc_yn.equals("Y"))
								display = true;
						}
						else
						{
							if(applicable_on_enc_yn.equals("N") && applicable_on_pat_yn.equals("Y"))
								display = true;
						}
					}
					if(display)
					{
						out.println("<td class='"+className+"' onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);' onclick='display(this)'><a href=\"javascript:callNextLevel('"+(String) thirdhash.get("OPTION_TYPE")+"','"+(String) thirdhash.get("EXECUTABLE_NAME")+"','"+(String) thirdhash.get("CA_OPTION_ID")+"','"+(String)thirdhash.get("FUNCTION_NAME")+"','"+(String)thirdhash.get("MENU_POSITION")+"')\">");
						out.println(thirdhash.get("OPTION_DESC"));
						out.println("</a></td>");
					}
				}
				else
				{
					if( applicable_on_pat_yn.equals("N") && applicable_on_enc_yn.equals("N") && !pat_sel)
					{
						out.println("<td class='"+className+"' onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);' onclick='display(this)' nowrap><a href=\"javascript:callNextLevel('"+(String) thirdhash.get("OPTION_TYPE")+"','"+(String) thirdhash.get("EXECUTABLE_NAME")+"','"+(String) thirdhash.get("CA_OPTION_ID")+"','"+(String)thirdhash.get("FUNCTION_NAME")+"','"+(String)thirdhash.get("MENU_POSITION")+"')\">");
						out.println(thirdhash.get("OPTION_DESC"));
						out.println("</a></td>");
					}
				}
				if(menu_pos.equals("V"))
					out.println("</tr>");

				first = false;
            }
            if(menu_pos.equals("H"))
                out.println("</tr>");

			 onthirdload = ( HashMap ) thirdlevellist.get( 0 );
			out.println("<script>callNextLevel('"+(String) onthirdload.get("OPTION_TYPE")+"','"+(String) onthirdload.get("EXECUTABLE_NAME")+"','"+(String) onthirdload.get("CA_OPTION_ID")+"','"+(String)onthirdload.get("FUNCTION_NAME")+"','"+(String)onthirdload.get("MENU_POSITION")+"')</script>");
        
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
