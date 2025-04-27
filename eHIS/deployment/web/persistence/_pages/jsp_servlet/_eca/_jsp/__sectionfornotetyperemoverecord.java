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

public final class __sectionfornotetyperemoverecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SectionForNoteTypeRemoveRecord.jsp", 1709116301620L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>\n\t\t\tparent.addSectionsFrame.location.href = \"../../eCommon/html/blank.html\";\n\t\t\tparent.sectionsFrame.location.href = \"../../eCommon/html/blank.html\";\n\t\t\tparent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.search.disabled = false;\n\t\t</script>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/SectionForNoteType.js\'></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t</head>\n\t<body onKeyDown=\'lockKey()\'>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<script>\n\t\t\t\tparent.sectionsFrame.location.href = \'../../eCA/jsp/SectionForNoteTypeSections.jsp?mode=modify&flag_for_list=false\';\n\t\t\tvar seachText=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\t\t\t\n\t\t\tif(seachText==\"\"){\n\t\t\t\tparent.addSectionsFrame.location.href = \"../../eCA/jsp/SectionForNoteTypeSearchAddSections.jsp?mode=&searchText=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&note_type=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\tparent.addSectionsFrame.location.reload();\n\t\t\t}\n\t\t\t\t</script>\t\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t//parent.addSectionsFrame.location.reload();\n\t\t\t}\n\t\t\t\t</script>\t\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.sectionsFrame.location.href = \'../../eCA/jsp/SectionForNoteTypeSections.jsp?mode=modify&flag_for_list=false\';\n\t\t\t\t\t//parent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<form name=\'remRecForm\' id=\'remRecForm\'>\t\t\t\n\t\t</form>\n\t</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
	
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.SectionForNoteTypeRecBean noteBean = (eCA.SectionForNoteTypeRecBean)getObjectFromBean("noteBean","eCA.SectionForNoteTypeRecBean",session);
	
	String sec_heading_code = request.getParameter("sec_heading_code") == null ? "" : request.getParameter("sec_heading_code");
	String sec_heading_desc = request.getParameter("sec_heading_desc") == null ? "" : request.getParameter("sec_heading_desc");
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String seachText = request.getParameter("seachText") == null ? "" : request.getParameter("seachText");
	String chief_comp = request.getParameter("chief_comp") == null ? "" : request.getParameter("chief_comp");
	String seq_num = request.getParameter("seq_num") == null ? "" : request.getParameter("seq_num");
	//String firstPos = request.getParameter("firstPos") == null ? "" : request.getParameter("firstPos");
	//String secPos = request.getParameter("secPos") == null ? "" : request.getParameter("secPos");
	String noOfRows = request.getParameter("noOfRows") == null ? "" : request.getParameter("noOfRows");
	String index = request.getParameter("index") == null ? "0" : request.getParameter("index");
	String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");

	int indexof=noteBean.getIndexOfElement(sec_heading_code);	
	
	if(called_from.equals("sectionsPage"))	{
		
		int indexInt = 0;
		if(!index.equals(""))
		{
			indexInt = Integer.parseInt(index);
		}
		noteBean.removeRec(sec_heading_code);
		noteBean.removeElement(indexInt);
		putObjectInBean("noteBean",noteBean,session);
	}

	else if(called_from.equals("removeReco"))	{
		if(indexof !=-1){
		noteBean.removeRec(sec_heading_code);
		noteBean.removeElement(indexof);
		putObjectInBean("noteBean",noteBean,session);
		}
	}
	else if(called_from.equals("addPage"))
	{
		String chiefComp = request.getParameter("chiefComp") == null ? "N" : request.getParameter("chiefComp");
		String srlNo = request.getParameter("srlNo") == null ? "N" : request.getParameter("srlNo");
		
		if(chiefComp.equals("Y")){
			if(noteBean.chkContainsKey(sec_heading_code))
		{
			noteBean.removeRec(sec_heading_code);
			noteBean.addRecords(sec_heading_code,sec_heading_desc + "~" + srlNo + "~" +"N"+ "~" +chiefComp);
			putObjectInBean("noteBean",noteBean,session);
		}
		}
		else{
		if(noteBean.chkContainsKey(sec_heading_code))
		{
			noteBean.removeRec(sec_heading_code);
			noteBean.addRecords(sec_heading_code,sec_heading_desc + "~" + srlNo + "~" +chiefComp+ "~" +chiefComp);
			putObjectInBean("noteBean",noteBean,session);
		}
		}
		

	}
	else if(called_from.equals("addSearch"))
	{
		
		int numberOfRecs = 0;
		int tempNum = 0;
		if(!noOfRows.equals(""))
		{
			tempNum = Integer.parseInt(noOfRows);
			numberOfRecs = Integer.parseInt(noOfRows) + 1;
		}
		if(!noteBean.chkContainsKey(sec_heading_code))
		{
			noteBean.addRecords(sec_heading_code,sec_heading_desc + "~" + numberOfRecs + "~" + chief_comp+"~" + chief_comp);
			noteBean.addToList(tempNum,sec_heading_code);
		}
		//noteBean.addFrameRecords(sec_heading_code,sec_heading_desc);
		putObjectInBean("noteBean",noteBean,session);
	}
	else if(called_from.equals("removeSearch"))
	{
		if(noteBean.chkContainsKey(sec_heading_code))
		{
			noteBean.removeRec(sec_heading_code);
		}
		putObjectInBean("noteBean",noteBean,session);
	}
	else if(called_from.equals("reloadFrames"))
	{
		//out.println("<script>alert(3);</script>");
		noteBean = new eCA.SectionForNoteTypeRecBean();
		//noteBean.clearBean();
		//cleanBeanObject("noteBean",noteBean,request);
		putObjectInBean("noteBean",noteBean,session);
	
            _bw.write(_wl_block5Bytes, _wl_block5);

	}
	else if(called_from.equals("onBlurFunc"))
	{
		//out.println("<script>alert(4);</script>");
		noteBean.addRecords(sec_heading_code,sec_heading_desc + "~" + seq_num + "~" + chief_comp+ "~" + chief_comp);
		putObjectInBean("noteBean",noteBean,session);
	}	

            _bw.write(_wl_block6Bytes, _wl_block6);

			if(called_from.equals("sectionsPage"))
			{
				//out.println("<script>alert(5);</script>");
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(seachText));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(seachText));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block10Bytes, _wl_block10);

			}

			else if(called_from.equals("removeReco"))
			{
				//out.println("<script>alert(5);</script>");
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(seachText));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(seachText));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			else if(called_from.equals("addSearch"))
			{
				//out.println("<script>alert(6);</script>");
			
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
				else if(called_from.equals("removeSearch"))
				{

			
            _bw.write(_wl_block12Bytes, _wl_block12);

				}	
			
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
