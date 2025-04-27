package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __encsummgroupcompremovecomp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncSummGroupCompRemoveComp.jsp", 1709115853622L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nCreated By: D. Sethuraman\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/EncSummGroupComp.js\'></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onKeyDown=\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>\t\t\t\n\t\t\tparent.selectedCompFrame.location.href = \"../../eCA/jsp/EncSummGroupCompAddedCompList.jsp?mode=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&groupFlag=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&groupType=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&groupCode=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&flag_for_list=false\";\t\t\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script>\n\t\t\tparent.selectedCompFrame.location.href = \"../../eCA/jsp/EncSummGroupCompAddedCompList.jsp?mode=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&flag_for_list=false\";\t\t\t\t\t\t\n\t\t</script>\t\t\t\t\n\t\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&flag_for_list=false\";\n\t\t\tvar searchText=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\t\t\t\n\t\t\tif(searchText==\"\"){\n\t\t\t\tparent.addCompFrame.location.href = \"../../eCA/jsp/EncSummGroupCompAddCompList.jsp?mode=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&gFlag=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&searchText=encodeURIComponent(";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")&searchGroupType=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&flag=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\tparent.addCompFrame.location.reload();\n\t\t\t}\n\t\t</script>\t\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&flag_for_list=false\";\t\t\t\t\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<form name=\'remRecForm\' id=\'remRecForm\'></form>\n\t</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.EncSummCompRecBean summRecCompBean = (eCA.EncSummCompRecBean)getObjectFromBean("summRecCompBean","eCA.EncSummCompRecBean",session);	
	
	String groupFlag = request.getParameter("groupFlag") == null ? "" : request.getParameter("groupFlag");
	String groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");	
	String groupCode = request.getParameter("groupCode") == null ? "" : request.getParameter("groupCode");	
	
	String comp_flag = request.getParameter("comp_flag") == null ? "" : request.getParameter("comp_flag");
	String comp_type = request.getParameter("comp_type") == null ? "" : request.getParameter("comp_type");	
	String comp_id = request.getParameter("comp_id") == null ? "" : request.getParameter("comp_id");
	String comp_desc = request.getParameter("comp_desc") == null ? "" : request.getParameter("comp_desc");
	
	String comp_temp = request.getParameter("comp_temp") == null ? "" : request.getParameter("comp_temp");
	String comp_col_count = request.getParameter("comp_col_count") == null ? "" : request.getParameter("comp_col_count");
	//String comp_column = request.getParameter("comp_column") == null ? "" : request.getParameter("comp_column");
	String comp_column = "";
	
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
	String searchGroupType = request.getParameter("searchGroupType") == null ? "" : request.getParameter("searchGroupType");
	String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String flag = request.getParameter("flag") == null ? "" : request.getParameter("flag");
	String gFlag = request.getParameter("gFlag") == null ? "" : request.getParameter("gFlag");	
	
	String seq_num = request.getParameter("seq_num") == null ? "" : request.getParameter("seq_num");
	
	String noOfRows = request.getParameter("noOfRows") == null ? "" : request.getParameter("noOfRows");
	
	String index = request.getParameter("index") == null ? "0" : request.getParameter("index");	
	
	String selected_flag = request.getParameter("selected_flag") == null ? "0" : request.getParameter("selected_flag");	
	
	int numberOfRecs = 0;
	int tempNum = 0;
	
	String beanCompKey = "";
	
	if (comp_temp.equals(""))
		comp_temp = "@";
	
	if (comp_col_count.equals(""))
		comp_col_count = "@";
	
	if (comp_column.equals(""))
		comp_column = "@";
	
	beanCompKey = comp_flag + "~" + comp_type + "~" + comp_id;
	
	int indexof = summRecCompBean.getIndexOfElement(beanCompKey);	
	
	ArrayList indexList = new ArrayList();		
	
	if(called_from.equals("addComp"))
	{			
		if(!noOfRows.equals(""))
		{
			tempNum = Integer.parseInt(noOfRows);
			numberOfRecs = Integer.parseInt(noOfRows) + 1;
		}
		if(!summRecCompBean.chkContainsKey(beanCompKey))
		{
			summRecCompBean.addRecords(beanCompKey,comp_flag + "~" + numberOfRecs + "~" + comp_type+"~" + comp_id + "~" + comp_desc + "~" +comp_temp+ "~" + comp_col_count + "~" +comp_column+"~" +selected_flag);
			summRecCompBean.addToList(tempNum,beanCompKey);
		}		
		putObjectInBean("summRecCompBean",summRecCompBean,session);
	}
	else if(called_from.equals("removeComp"))	{
		if(indexof !=-1){
			summRecCompBean.removeRec(beanCompKey);
			summRecCompBean.removeElement(indexof);
			putObjectInBean("summRecCompBean",summRecCompBean,session);
		}
	}	
	else if(called_from.equals("modComp"))	{
		if(indexof !=-1){
			summRecCompBean.addRecords(beanCompKey,comp_flag + "~" + numberOfRecs + "~" + comp_type+"~" + comp_id + "~" + comp_desc + "~" +comp_temp+ "~" + comp_col_count + "~" +comp_column+"~" +selected_flag);
			putObjectInBean("summRecCompBean",summRecCompBean,session);
		}
	}
	else if(called_from.equals("modCompAll"))	{	
		if(indexof !=-1){			
			summRecCompBean.addRecords(beanCompKey,comp_flag + "~" + numberOfRecs + "~" + comp_type+"~" + comp_id + "~" + comp_desc + "~" +comp_temp+ "~" + comp_col_count + "~" +comp_column+"~" +selected_flag);
			putObjectInBean("summRecCompBean",summRecCompBean,session);
		}
	}	
	else if(called_from.equals("resetBean"))	{		
		indexList = summRecCompBean.retrieveArrayList();		
		if(indexList.size() > 0 ){
			summRecCompBean.clearBean();
			putObjectInBean("summRecCompBean",summRecCompBean,session);
		}
	}	
	else if(called_from.equals("deleteComp"))	{
		if(!noOfRows.equals(""))
		{
			tempNum = Integer.parseInt(noOfRows);
			numberOfRecs = Integer.parseInt(noOfRows) + 1;
		}
		if(!summRecCompBean.chkContainsKey(beanCompKey))
		{
			summRecCompBean.addRecords(beanCompKey,comp_flag + "~" + numberOfRecs + "~" + comp_type+"~" + comp_id + "~" +selected_flag);
			summRecCompBean.addToList(tempNum,beanCompKey);
		}			
		putObjectInBean("summRecCompBean",summRecCompBean,session);	
	}	
	

            _bw.write(_wl_block5Bytes, _wl_block5);


	if(called_from.equals("addComp"))
	{	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(groupFlag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(groupType));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	else if(called_from.equals("removeComp"))
	{		
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(groupFlag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(groupType));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else if(called_from.equals("modComp"))
	{		
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(groupFlag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(groupType));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else if(called_from.equals("modCompAll"))
	{		
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(groupFlag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(groupType));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else if(called_from.equals("sectionsPage"))
	{
		//out.println("<script>alert("sectionsPage");</script>");
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(groupFlag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(groupType));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(searchText));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(groupFlag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(groupType));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(gFlag));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(searchText));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(searchGroupType));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}	
	else if(called_from.equals("removeSearch"))
	{
		//out.println("<script>alert("removeSearch");</script>");
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(groupFlag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(groupType));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(groupCode));
            _bw.write(_wl_block20Bytes, _wl_block20);

	}	
	
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
