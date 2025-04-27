package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnoteschiefcomplaintcontrol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesChiefComplaintControl.jsp", 1740479673979L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n<script>\n\tvar text_blk_id = \"\", text_blk = \"\", block_id = \"\";\n\n\tvar returnArray\t\t= new Array();\n\tvar arrTextBlockID\t= new Array();\n\tvar arrTextBlock\t= new Array();\n\n\t/*if(parent.RecClinicalNotesCCSelectFrame.document.forms[0].select!=null)\n\t{\n\t\tvar clipBoardVal=parent.RecClinicalNotesCCSelectFrame.document.forms[0].select.createTextRange();\n\t\tclipBoardVal.select();\n\t\tclipBoardVal.execCommand(\"copy\",\"\",\"\");\n\t}*/\n\tif(parent.RecClinicalNotesCCSelectFrame.document.forms[0].select!=null)\n\t{\n\t\tvar range = document.createRange(parent.RecClinicalNotesCCSelectFrame.document.forms[0].select);\n\t    //range.selectNode(obj);;\n\t    const clipBoardVal = range.extractContents();\n\t\tdocument.execCommand(\"copy\");\n\t}\n\t\n\tvar selectIndex = 0;\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\ttext_block_id\t=\teval(\"parent.RecClinicalNotesCCFrame.document.forms[0].text_blk_id";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\").value;\n\t\t\t\ttext_block\t\t=\tparent.RecClinicalNotesCCFrame.document.getElementById(\'text_blk";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\').innerText;\n\t\t\t\tarrTextBlockID[selectIndex]\t=\ttext_block_id; \n\t\t\t\tarrTextBlock[selectIndex]\t=\ttext_block; \n\t\t\t\tselectIndex++;\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\treturnArray[0] = arrTextBlockID;\n\treturnArray[1] = arrTextBlock;\n\n\tparent.window.returnValue = returnArray;\n\tparent.window.close();\n</script>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

            _bw.write(_wl_block5Bytes, _wl_block5);

	String totalBlocks			= request.getParameter("totalBlocks")==null?"0":request.getParameter("totalBlocks");
	String sec_hdg_code			= (request.getParameter("sec_hdg_code")==null) ?""	:request.getParameter("sec_hdg_code");
	String child_sec_hdg_code	= (request.getParameter("child_sec_hdg_code")==null) ?""	:request.getParameter("child_sec_hdg_code");	 
	String patient_id	= (request.getParameter("patient_id")==null) ?""	:request.getParameter("patient_id");	 
	String encounter_id	= (request.getParameter("encounter_id")==null) ?""	:request.getParameter("encounter_id");	 

	String strKey	= patient_id + "~"+encounter_id;
	strKey = strKey.trim();

	sectionBean.getPatientSection(strKey);

	int total = Integer.parseInt(totalBlocks);
	
	boolean flag=false;
	boolean selectFlag = true;
	
	HashSet preSet = (HashSet) sectionBean.getSectionChiefComplaint(sec_hdg_code,child_sec_hdg_code);
	
	if(preSet != null )
		flag=true;
	else
	{
		flag = true;
		preSet = new HashSet(); 
	}

	//-------------------
	String blockId = "";
	String textBlockId = "";

	for(int i=0; i<total; i++)
	{
		blockId		=	request.getParameter("block_id"+i)==null?"":request.getParameter("block_id"+i);
		textBlockId	=	request.getParameter("text_blk_id"+i)==null?"":request.getParameter("text_blk_id"+i);	
		
		if(blockId.equals("Y"))
		{
			if(flag && preSet.contains(textBlockId))
				selectFlag = true; //'selectFlag' is changed to 'true' instead of 'false' by Archana Dhal on 7/26/2010 related to IN022802.
			else if(flag && !preSet.contains(textBlockId))
				preSet.add(textBlockId);
			
			if(selectFlag)
			{
				
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(i));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(i));
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
			
			selectFlag = true;
		}
		else
		{
			if(flag && preSet.contains(textBlockId))
				preSet.remove(textBlockId);
		}
	}
	
	if(flag)
	{
		sectionBean.setSectionChiefComplaint(sec_hdg_code,child_sec_hdg_code,preSet);
		putObjectInBean("sectionBean",sectionBean,session);
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
