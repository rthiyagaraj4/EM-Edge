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

public final class __specialitytasksforeeventremoverecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SpecialityTasksForEeventRemoveRecord.jsp", 1709116330481L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>\n\t\t\tparent.addTasksFrame.location.href = \"../../eCommon/html/blank.html\";\n\t\t\tparent.tasksFrame.location.href = \"../../eCommon/html/blank.html\";\n\t\t\tparent.headerFrame.document.specialityTasksForEeventForm.search.disabled = false;\n\t\t</script>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/SpecialityTasksForEvents.js\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n\t</head>\n\t<body onKeyDown=\'lockKey()\'>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<script>\n\t\t\t\tparent.tasksFrame.location.href = \'../../eCA/jsp/SpecialityTasksForEventsSelection.jsp?mode=modify&flag_for_list=false&module=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&code=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&event_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&no_of_trans=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\tparent.addTasksFrame.location.href = \"../../eCA/jsp/SpecialityTasksForEventsSearchAddTasks.jsp?mode=&searchText=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t//parent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.tasksFrame.location.href = \'../../eCA/jsp/SpecialityTasksForEventsSelection.jsp?mode=modify&flag_for_list=false&module=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\t\t//parent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<form name=\'remRecForm\' id=\'remRecForm\'>\t\t\t\n\t\t</form>\n\t</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
	
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
	eCA.SpecialityTasksForEventsBean taskBean = (eCA.SpecialityTasksForEventsBean)getObjectFromBean("taskBean","eCA.SpecialityTasksForEventsBean",session);
	
	String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
	String splty_task_desc = request.getParameter("splty_task_desc") == null ? "" : request.getParameter("splty_task_desc");
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String seachText = request.getParameter("seachText") == null ? "" : request.getParameter("seachText");
	String seq_num = request.getParameter("seq_num") == null ? "" : request.getParameter("seq_num");
	String noOfRows = request.getParameter("noOfRows") == null ? "" : request.getParameter("noOfRows");
	String index = request.getParameter("index") == null ? "0" : request.getParameter("index");
	//out.println("<script>alert('"+splty_task_code+"')</script>");
	
	String module = request.getParameter("module") == null ? "true" : request.getParameter("module");
	String code = request.getParameter("code") == null ? "" : request.getParameter("code");
	String event_id = request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
	String no_of_trans = request.getParameter("no_of_trans") == null ? "" : request.getParameter("no_of_trans");


	if(called_from.equals("sectionsPage"))
	{
		  // out.println("<script>alert(10);</script>");
		int indexInt = 0;
		if(!index.equals(""))
		{
			indexInt = Integer.parseInt(index);
		}
		taskBean.removeRec(splty_task_code);
		taskBean.removeElement(indexInt);
		putObjectInBean("taskBean",taskBean,session);
	}
	else if(called_from.equals("addPage"))
	{		 // out.println("<script>alert(8);</script>");
		//String chiefComp = request.getParameter("chiefComp") == null ? "N" : request.getParameter("chiefComp");
		String srlNo = request.getParameter("srlNo") == null ? "N" : request.getParameter("srlNo");
		//String beanval=splty_task_desc + "~" + srlNo ;

		if(taskBean.chkContainsKey(splty_task_code))
		{
			taskBean.removeRec(splty_task_code);
			taskBean.addRecords(splty_task_code,splty_task_desc + "~" + srlNo );
			putObjectInBean("taskBean",taskBean,session);
		}
		
		

	}
	else if(called_from.equals("addSearch"))
	{
		//out.println("<script>alert(2);</script>");
		int numberOfRecs = 0;
		int tempNum = 0;
		if(!noOfRows.equals(""))
		{
			tempNum = Integer.parseInt(noOfRows);
			numberOfRecs = Integer.parseInt(noOfRows) + 1;
		}
		if(!taskBean.chkContainsKey(splty_task_code))
		{
			//out.println("<script>alert('"+tempNum+"');</script>");
			taskBean.addRecords(splty_task_code,splty_task_desc + "~" + numberOfRecs );
			taskBean.addToList(tempNum,splty_task_code);
		}
		//taskBean.addFrameRecords(splty_task_code,splty_task_desc);
		putObjectInBean("taskBean",taskBean,session);
	}
	else if(called_from.equals("removeSearch"))
	{
		if(taskBean.chkContainsKey(splty_task_code))
		{
			taskBean.removeRec(splty_task_code);
		}
		putObjectInBean("taskBean",taskBean,session);
	}
	else if(called_from.equals("reloadFrames"))
	{
		//out.println("<script>alert(3);</script>");
		taskBean = new eCA.SpecialityTasksForEventsBean();
		//taskBean.clearBean();
		//cleanBeanObject("taskBean",taskBean,request);
		putObjectInBean("taskBean",taskBean,session);
	
            _bw.write(_wl_block5Bytes, _wl_block5);

	}
	else if(called_from.equals("onBlurFunc"))
	{
		//out.println("<script>alert(4);</script>");
		taskBean.addRecords(splty_task_code,splty_task_desc + "~" + seq_num );
		putObjectInBean("taskBean",taskBean,session);
	}	

            _bw.write(_wl_block6Bytes, _wl_block6);

			if(called_from.equals("sectionsPage"))
			{
				//out.println("<script>alert(5);</script>");
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(module));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(event_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(no_of_trans));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(seachText));
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
			else if(called_from.equals("addSearch"))
			{
				//out.println("<script>alert(6);</script>");
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(module));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(event_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(no_of_trans));
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
				else if(called_from.equals("removeSearch"))
				{

			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(module));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(event_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(no_of_trans));
            _bw.write(_wl_block14Bytes, _wl_block14);

				}	
			
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
