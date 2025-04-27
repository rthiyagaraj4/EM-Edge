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

public final class __camainoptions2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainOptions2.jsp", 1709115556449L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\t\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n <html>\n    <head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\' />\n\t    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t    <script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n        <STYLE TYPE=\"text/css\">\n        A:link {\n            COLOR: white;\n        }\n\n        A:visited {\n            COLOR:white ;\n        }\n        A:active {\n            COLOR: white;\n        }\n        </STYLE>\n\n        ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n        <script>\n            var currClass = \'\';\n\n            function display(from)\n            {\n                cellref = document.getElementById(\"tab\").rows(0).cells\n                 if(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" == \"V\")\n                    cellref = document.getElementById(\"tab\").rows\n\n                for(i=0; i<cellref .length; i++)\n                {\n                    if(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" == \"H\")\n                        cellref[i].className = \'CAFIRSTSELECTHORZ\'\n                     else\n                      cellref[i].cells[0].className = \'CAFIRSTSELECTVERT\'\n                 }\n                  if(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" == \"H\")\n                 {\n                    from.className = \"CASECONDSELECTHORZ\"\n                    currClass =\"CASECONDSELECTHORZ\";\n                  }\n                  else\n                 {\n                    from.className = \"CASECONDSELECTVERT\";\n                    currClass =\"CASECONDSELECTVERT\";\n                 }\n            }\n\n            function callOnMouseOver(obj)\n            {\n                currClass = obj.className ;\n                 if(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" == \"H\")\n                    obj.className = \'CASECONDSELECTHORZ\';\n                 else\n                    obj.className = \'CASECONDSELECTVERT\';\n            }\n\n            function callOnMouseOut(obj)\n            {\n                obj.className = currClass;\n            }\n\n            function callNextLevel(option_type,executable_name, option_id,option_desc,menu_position)\n            {\n                //var params = \"&patient_id=TN06500992&episode_id=50103511&visit_id=1&episode_type=O&location_code=CARD&location_type=C\";\n                //top.messageframe.location.href = \'../../eCommon/jsp/error.jsp\';\n\n                if(top.content !=null)\n                    top.content.messageFrame.location.href = \'../../eCommon/jsp/error.jsp\';\n                else\n                    top.content.messageFrame.location.href = \'../../eCommon/jsp/error.jsp\';\n                var params = \"&";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"\n                if(option_type == \'M\')\n                {\n                    //top.frames[1].displayFunctionName(\"\")\n                    if(top.content !=null)\n\t                    setTimeout(\"return top.content.CommonToolbar.displayFunctionName(\\\"\"+option_desc+\"\\\");\",750);\n                     else\n\t                    setTimeout(\"return top.CommonToolbar.displayFunctionName(\\\"\"+option_desc+\"\\\");\",750);\n\n                    //parent.thirdframe.location.href=\'CAThirdFrame.jsp?fname=CAOptions3.jsp&option_id=\' +option_id+\'&menu_pos=\'+menu_position+params+\'&CA=Y\'\n\n\t\t\t\t\tparent.Options3.location.href=\'../../eCA/jsp/CAMainOptions3.jsp?option_id=\' +option_id+\'&menu_pos=\'+menu_position+params+\'&CA=Y\';\n                }\n                else\n                {\n                    if(top.content !=null)\n\t                    setTimeout(\"return top.content.CommonToolbar.displayFunctionName(\\\"\"+option_desc+\"\\\");\",750);\n                     else\n\t                    setTimeout(\"return top.CommonToolbar.displayFunctionName(\\\"\"+option_desc+\"\\\");\",750);\n\n                    var oper = \"&\"\n                    if(executable_name.indexOf(\"?\") == -1)\n                        oper = \"?\"\n                   \n\t\t\t\t\tchangeFramesOptions2();\tparent.workAreaFrame.location.href=executable_name+oper+\'cname=CASECONDWORKAREA&option_id=\'+option_id+params+\'&CA=Y\';\n\t\t\t\t\t//parent.thirdframe.location.href=executable_name+oper+\'cname=CASECONDWORKAREA&option_id=\'+option_id+params+\'&CA=Y\'\n                }\n            }\n        </script>\n    </head>\n\n    <body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n        <table id=\'tab\' cellspacing=0 cellpadding=\'3\' border=\'0\'>\n        ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n        </table>\n    </body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
	
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
            eCA._ca_license_rights keyGen= null;{
                keyGen=(eCA._ca_license_rights)pageContext.getAttribute("keyGen");
                if(keyGen==null){
                    keyGen=new eCA._ca_license_rights();
                    pageContext.setAttribute("keyGen",keyGen);

                }
            }
            _bw.write(_wl_block8Bytes, _wl_block8);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

            String queryString = request.getQueryString()== null?"":request.getQueryString() ;
            String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
            String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
           // String episode_type= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
            String menu_pos = request.getParameter("menu_pos")==null?"V":request.getParameter("menu_pos");
            String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
            String child_window = request.getParameter("child_window") ;

            boolean pat_sel = false ;

            if( !patient_id.equals("") || !episode_id.equals("") )
                pat_sel = true;
        
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(menu_pos));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(menu_pos));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(menu_pos));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(menu_pos));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block16Bytes, _wl_block16);

			//out.println("CaOptions==========="+CaOptions);
            String parent_option_id = request.getParameter("option_id");
            ArrayList secondlevellist = CaOptions.getSubHeaders("2",parent_option_id,patient_id,episode_id) ;
			//out.println(secondlevellist);
			//out.println(parent_option_id);
            String cname = "CAFIRSTSELECTVERT";

            if(menu_pos.equals("H"))
            {
                out.println("<tr>");
                cname = "CAFIRSTSELECTHORZ";
             }
            boolean bool  =false;
            boolean display = false;
            boolean first = true;
            String className = "";
            HashMap onsecondload = null;

            for (int i=0; i<secondlevellist.size(); i++)
            {
               if(menu_pos.equals("V"))
                    out.println("<tr>");
                HashMap secondhash = ( HashMap ) secondlevellist.get( i );
                String applicable_on_pat_yn = (String) secondhash.get("APPLICABLE_ON_PAT_YN");
                String applicable_on_enc_yn = (String) secondhash.get("APPLICABLE_ON_ENC_YN");
                //String applicable_category = (String) secondhash.get("APPLICABLE_CATEGORY");
                display = false;

                if( (!episode_id.equals(""))&& (applicable_on_pat_yn.equals("Y") || applicable_on_enc_yn.equals("Y")) )
                    bool = true;
                else
                    if( (!patient_id.equals(""))&& applicable_on_pat_yn.equals("Y") )
                        bool = true ;

                if(first)
                {
                    onsecondload = (HashMap) secondlevellist.get( 0 );
                    if(menu_pos.equals("H"))
                        className = "CASECONDSELECTHORZ";
                    else
                        className = "CASECONDSELECTVERT";
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
						 	out.println("<td nowrap class='"+className+"' onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);' onclick='display(this)'><a href=\"javascript:callNextLevel('"+(String) secondhash.get("OPTION_TYPE")+"','"+(String) secondhash.get("EXECUTABLE_NAME")+"','"+(String) secondhash.get("CA_OPTION_ID")+"','"+(String)secondhash.get("FUNCTION_NAME")+"','"+(String)secondhash.get("MENU_POSITION")+"')\">");
                        	out.println(secondhash.get("OPTION_DESC"));
                        	out.println("</a></td>");
				    }
                }
                else
                {
	                if( applicable_on_pat_yn.equals("N") && applicable_on_enc_yn.equals("N") && !pat_sel )
                    {
						if(child_window.equals("N")  && ((eCA._ca_license_rights.getKey()).equals("CACLDC")  || (eCA._ca_license_rights.getKey()).equals("CABASIC")))  // CA Clinical Documentation
							display = true;
						else if ((eCA._ca_license_rights.getKey()).equals("CAMINI") )  // CA Consultation
							display = true;
						if(display)
						{
                        	out.println("<td nowrap class='"+className+"' onMouseOver='callOnMouseOver(this);' onMouseOut='callOnMouseOut(this);' onclick='display(this)' nowrap><a href=\"javascript:callNextLevel('"+(String) secondhash.get("OPTION_TYPE")+"','"+(String) secondhash.get("EXECUTABLE_NAME")+"','"+(String) secondhash.get("CA_OPTION_ID")+"','"+(String)secondhash.get("FUNCTION_NAME")+"','"+(String)secondhash.get("MENU_POSITION")+"')\">");
                        	out.println(secondhash.get("OPTION_DESC"));
                        	out.println("</a></td>");
						}
                    }
                }

               if(menu_pos.equals("V"))
                    out.println("</tr>");

               first = false;
            }
             if(menu_pos.equals("H"))
                out.println("</tr>");

            // Enhancements
           	/*if (child_window.equals("N") && (eCA._ca_license_rights.getKey()).equals("CAMINI") )  // CA Consultation
			{
				out.println("<tr><td width='100%' class='DATA' COLSPAN='"+secondlevellist.size()+"')\">");
			   	out.println("Patient List ");
               	out.println("</td></tr>");
			}*/
			if(onsecondload!=null)
            out.println("<script>callNextLevel('"+(String) onsecondload.get("OPTION_TYPE")+"','"+(String) onsecondload.get("EXECUTABLE_NAME")+"','"+(String) onsecondload.get("CA_OPTION_ID")+"','"+(String)onsecondload.get("FUNCTION_NAME")+"','"+(String)onsecondload.get("MENU_POSITION")+"')</script>");
        
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
