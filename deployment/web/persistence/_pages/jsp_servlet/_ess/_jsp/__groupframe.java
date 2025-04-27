package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eSS.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __groupframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/GroupFrame.jsp", 1732590113343L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'javascript\' src=\'../../eSS/js/GroupMaster.js\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<iframe name=\'frameGroup\' src=\'../../eSS/jsp/GroupAddModify.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=0 scrolling=\'no\' noresize style=\"height:50vh;width:100vw\"></iframe>\n<!--  <frameset rows=\'*,55%,0%\' id=\'check\'>-->\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<!--  <frameset rows=\'*,40%,15%\' id=\'check\'>-->\n\t<iframe name=\'frameGroup\' src=\'../../eSS/jsp/GroupAddModify.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 scrolling=\'no\' noresize style=\"height:47vh;width:100vw\"></iframe>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\n\t\n\t<!--<frameset rows=\"15,*\" >\n\t\t<frame name=\'frameGroupListHeader\' frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eSS/html/GroupListHeader.html\"> -->\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<iframe name=\'frameGroupList\' frameborder=\"0\" scrolling=\"auto\" noresize style=\"height:35vh;width:100vw\" src=\"../../eSS/jsp/GroupList.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&checklist=Y&checklist_desc=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></iframe>\n\t\t\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<iframe name=\'frameGroupList\' frameborder=\"0\" scrolling=\"auto\" noresize style=\"height:43vh;width:100vw\" src=\"../../eSS/jsp/GroupList.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\t</iframe>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<!--</frameset>\t -->\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<iframe name=\'frameGroupDetail\' frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eSS/jsp/GroupDetail.jsp?";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" style=\"height:12vh;width:100vw\"> </iframe>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</frameset>\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            java.util.ArrayList alGroupList= null;synchronized(session){
                alGroupList=(java.util.ArrayList)pageContext.getAttribute("alGroupList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alGroupList==null){
                    alGroupList=new java.util.ArrayList();
                    pageContext.setAttribute("alGroupList",alGroupList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            java.util.ArrayList alCheckList= null;synchronized(session){
                alCheckList=(java.util.ArrayList)pageContext.getAttribute("alCheckList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alCheckList==null){
                    alCheckList=new java.util.ArrayList();
                    pageContext.setAttribute("alCheckList",alCheckList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

		request.setCharacterEncoding("UTF-8");
		String bean_id = "groupItemBean" ;
		String bean_name = "eSS.GroupItemBean";
		String checklist_code = "";
		alGroupList.clear();

	GroupItemBean bean = (GroupItemBean)getBeanObject( bean_id,  bean_name,request );

	String group_code				=	request.getParameter("group_code");
	ArrayList alItemForGroupRecords	=	null;
	
	if( group_code!=null )
	{
		try{
			
			 HashMap h1 = bean.fetchRecord("select nvl(CHECKLIST_CODE,'') CHECKLIST_CODE from ss_group where group_code = ?",group_code);
			checklist_code = bean.checkForNull((String)h1.get("CHECKLIST_CODE"),"");
	
			if(!(checklist_code.equals("")))
			{
			alItemForGroupRecords=bean.fetchRecords("SELECT s.item_code, s.item_qty, si.consumable_yn, si.chargeable_yn, m.short_desc, chd.madatory_item_yn madatory_item_yn,chd.quantity item_qty1 FROM mm_item m, ss_item si,       ss_item_for_group s, ss_checklist ch, ss_checklist_dtl chd,    ss_group sg WHERE sg.group_code = ?   AND s.group_code = sg.group_code AND ch.checklist_code = sg.checklist_code   AND ch.checklist_code = chd.checklist_code  AND chd.item_code = s.item_code  AND s.item_code = m.item_code  AND s.item_code = si.item_code order by chd.SEQ_NO",group_code);
			}
			if(checklist_code.equals(""))
			{
			alItemForGroupRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_DETAIL"),group_code);
			}

	
	         alGroupList.clear();
	         alCheckList.clear();
			for (int i=0;i<alItemForGroupRecords.size();i++){
				HashMap hmItemForGroupRecord=(HashMap)alItemForGroupRecords.get(i);
				hmItemForGroupRecord.put("ITEM_CODE",	(String)hmItemForGroupRecord.get("ITEM_CODE") );
				hmItemForGroupRecord.put("ITEM_QTY",	(String)hmItemForGroupRecord.get("ITEM_QTY")  );
				hmItemForGroupRecord.put("CONSUMABLE_YN",	(String)hmItemForGroupRecord.get("CONSUMABLE_YN")  );
				hmItemForGroupRecord.put("CHARGEABLE_YN",	(String)hmItemForGroupRecord.get("CHARGEABLE_YN")  );
				if(hmItemForGroupRecord.containsKey("MADATORY_ITEM_YN"))
				hmItemForGroupRecord.put("MADATORY_ITEM_YN",	bean.checkForNull((String)hmItemForGroupRecord.get("MADATORY_ITEM_YN") ,""));
				hmItemForGroupRecord.put("DESCRIPTION",	(String)hmItemForGroupRecord.get("SHORT_DESC"));
                 if(hmItemForGroupRecord.containsKey("ITEM_QTY1"))
				hmItemForGroupRecord.put("ITEM_QTY1",	bean.checkForNull((String)hmItemForGroupRecord.get("ITEM_QTY1") ,""));
				/*hmItemForGroupRecord.remove("ITEM_CODE") ;
				hmItemForGroupRecord.remove("ITEM_QTY")  ;
				hmItemForGroupRecord.remove("SHORT_DESC");
				hmItemForGroupRecord.remove("CONSUMABLE_YN");*/
				hmItemForGroupRecord.put("MODE",		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				alGroupList.add(hmItemForGroupRecord);
			    alCheckList.add(hmItemForGroupRecord);
			}
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}
   
   putObjectInBean( bean_id,  bean ,request);


            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	if(!(checklist_code.equals("")))
	{
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
} else {
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
 if(!(checklist_code.equals("")))
	{
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checklist_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
} else {	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
 if(checklist_code.equals(""))
	{
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getQueryString()));
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
