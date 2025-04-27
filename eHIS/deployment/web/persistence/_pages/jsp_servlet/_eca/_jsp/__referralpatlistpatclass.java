package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __referralpatlistpatclass extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ReferralPatListPatClass.jsp", 1709116233074L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../js/ReferralPatListResult.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</head>\n\n<STYLE TYPE=\"text/css\">\nA:link {\n\tCOLOR: white;\n}\n\nA:visited {\n\tCOLOR:white ;\n}\nA:active {\n\tCOLOR: white;\n}\n</STYLE>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script language=javascript>\n\n\t\t\tif(top.content.workAreaFrame.PatResultFr.LocnResult.location != null)\n\t\t\t{\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t}\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\n\tfunction callLevelTwo(obj)\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' == \"Y\")\n\t\t{\n\t\t\tvar url = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&pat_type=\'+obj;\n\t\t\tvar count = url.indexOf(\"&pat_type=\");\n\t\t\turl = url.substring(0,count);\n\t\t\turl = url+\'&pat_type=\'+obj;\n\n\t\t\ttop.content.workAreaFrame.PatResultFr.LocnResultLocation.location.href=\'../../eCA/jsp/ReferralPatListPatLocn.jsp?\'+url;\n\t\t}\n\t\telse if(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' == \"N\")\n\t\t{\n\t\t\tvar url = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&locn_type=\'+obj;\n\t\t\ttop.content.workAreaFrame.PatResultFr.LocnResult.location.href=\'../../eCA/jsp/ReferralPatListResult.jsp?\'+url;\n\t\t}\n\n\t\t//if(top.content.workAreaFrame.PatResultFr.LocnResultTitle.location.href.indexOf(\".jsp\") != -1)\n\t\t  // top.content.workAreaFrame.PatResultFr.LocnResultTitle.location.href=\'../../eCommon/html/blank.html\';\n\t}\n</script>\n\t<body class =\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n       <form name=\"formLocnResultPatClass\" id=\"formLocnResultPatClass\">\n           <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' class=\'\' id=\"tab\" width=\"50%\">\n           <tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'  align=\"center\" onMouseOver=\'callOnMouseOver(this);\' onMouseOut=\'callOnMouseOut(this);\'style=\'cursor:pointer;\' onclick=\"display(this);callLevelTwo(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\" >\n\t\t\t\t\t\t<a href=\"javascript:callLevelTwo(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\"> ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n                </tr>\n                </table>\n\t\t\t\t<input type=\"hidden\" name=\"queryString\" id=\"queryString\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"url\" id=\"url\" value=\"\">\n            </form>\n        </body>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<script>\n\t\t\t\t \ttop.content.workAreaFrame.PatResultFr.LocnResultLocation.location.href=\'../../eCA/jsp/ReferralPatListPatLocn.jsp?";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&pat_type=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\';\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
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


        String getPatientClassName(String code,PageContext pgContxt)
        {
            if(code!=null)
            {
                if(code.equals("IP"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.inpatient.label","common_labels");
                else if(code.equals("OP"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.Outpatient.label","common_labels");
                else if(code.equals("EM"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.emergency.label","common_labels");
                else if(code.equals("DC"))
				return com.ehis.util.BundleMessage.getBundleMessage(pgContxt,"Common.daycare.label","common_labels");
            }
            return null;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")? (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.PatSearch PatSearch = (eCA.PatSearch)getObjectFromBean("PatSearch","eCA.PatSearch",session);

	String queryString  = request.getQueryString();
	String allowSecondLevel = request.getParameter("allowSecondLevel");

	if(allowSecondLevel == null || allowSecondLevel.equals(""))
		allowSecondLevel="";

	String locationType  = request.getParameter("locationType");
	
	if(locationType == null || locationType =="") 
		locationType="";
	
	String classArray[] = new String[4];
	
	HashSet patClassSet = PatSearch.getFirstLevel();

	int j=0;
	
	if(patClassSet!=null && patClassSet.size()>0)
	{
		Iterator itr = patClassSet.iterator();

		while(itr.hasNext())
		{
			classArray[j] = (String)itr.next();
			j++;
		}
	}

	patClassSet = null;

	if(classArray[0]==null )
	{

            _bw.write(_wl_block8Bytes, _wl_block8);

	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(allowSecondLevel));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(allowSecondLevel));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block13Bytes, _wl_block13);

				String classValue="";
				for(int i=0;i<classArray.length;i++)
				{
					if(i==0)  classValue="FIRSTSELECTED";
					else classValue="FIRSTNORMAL";
			
					if(classArray[i]!=null)
					{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classArray[i]));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classArray[i]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(getPatientClassName(classArray[i],pageContext)));
            _bw.write(_wl_block18Bytes, _wl_block18);
                   }
                }

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block20Bytes, _wl_block20);

        String pat_type = "";
        if(classArray[0]!=null)
		{
            pat_type = classArray[0];
            if(!allowSecondLevel.equals(""))
			{

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pat_type));
            _bw.write(_wl_block23Bytes, _wl_block23);

            }
        }

            _bw.write(_wl_block24Bytes, _wl_block24);
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
