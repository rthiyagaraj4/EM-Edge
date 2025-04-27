package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __assignprivilegegroupvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/AssignPrivilegeGroupValidate.jsp", 1724922460000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?				  100            ?				created
8/1/2014	  LICN_1		  Karthi			MMS Internal Issue.
--------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	try
	{
			Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
			hash = (Hashtable)hash.get( "SEARCH" ) ;
			String callFrom	= (String)hash.get("callFrom");
			String bean_id		= (String)hash.get("BEAN_ID");
			String bean_name	= (String)hash.get("BEAN_NAME");
			//String success	= "APP-SM0070 Operation Completed Successfully ...."; //LICN_1
			String source	= (String) (session.getAttribute("MstCodeToolbar")==null?"":session.getAttribute("MstCodeToolbar"));
			//String mandMsg = "Please select atleast one Privilege Group..."; // LICN_1
			if (bean_id == null || bean_id.equals( "" ))
			return ;
			
			AssignPrevilegeGroup beanObj = (AssignPrevilegeGroup)getBeanObject( bean_id, bean_name, request ) ;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
			{
				beanObj.setLocalEJB(true);
			}			
			
			if(callFrom.equals("populatePrevgroup"))
			{
				String grp_by_code	= (String)hash.get("GROUP_BY_CODE");
				String group_by	= (String)hash.get("GROUP_BY");
				
				//String templocale=(String) session.getAttribute("LOCALE") ;	
			   //ExternalOrdersBean beanObj = (ExternalOrdersBean)mh.getBeanObject( bean_id, request , "eOR.ExternalOrdersBean") ;
					
				//beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
					
				 ArrayList OrderTypeData = beanObj.getPrevcode(grp_by_code) ;
					if(OrderTypeData.size()==0)
						out.println("InvalidPrevcode(\""+group_by+"\");");
				 for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
					String[] record = (String[])OrderTypeData.get(i);
			
					out.println("addPrevcode(\""+record[0]+"\",\""+record[1]+"\");") ;
					
				}
				putObjectInBean(bean_id,beanObj,request);
			}
			else if(callFrom.equals("addPrevilege"))
			{
				String privilegeId = (String)hash.get("privilegeId");
				String mode = (String)hash.get("mode");
				if(mode != null && !mode.equals(""))
				{
					if(mode.equals("ADD"))
					{
						beanObj.setPrivilegeList(privilegeId);
					}
					else if(mode.equals("REMOVE"))
					{
						beanObj.removePrivilege(privilegeId);
					}
				}
			}
			else if(callFrom.equals("savePRGroupsForPractitioner"))
			{
				String user = (String)hash.get("user");
				String appLevel = (String)hash.get("appLevel");
				String groupBy = (String)hash.get("groupBy");
				String grp_by_code = (String)hash.get("grp_by_code");
				String function_id = (String)hash.get("function_id");
				String result = "";
				//String localeName = (String)hash.get("localeName");
				if(grp_by_code != null && !grp_by_code.equals(""))
				{
					beanObj.setPrivilegeList(grp_by_code);
				}
				// LICN_1 - Start
				List privilegeList = beanObj.getPrivilegeList();
				if(privilegeList != null) {
					if(privilegeList.size() != 0){
						result = beanObj.savePrevilegeGrpsForUser(appLevel, user, groupBy);
					}
					else {
						result = "MAND_CHECK";
					}
				}
				else {
					result = "MAND_CHECK";
				}
				//LICN_1 - End
				
				if(result != null && result.equals("SUCCESS"))
				{
					out.println("f_query_add_mod.location.href = '../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode=1&function_id="+function_id+" '");
					out.println("messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num="+(MessageManager.getMessage("en","RECORD_INSERTED","SM")).get("message")+"'");  //LICN_1           
					out.println("commontoolbarFrame.location.href = '"+source+"'");
				}
				else if(result != null && result.equals("MAND_CHECK")){ // LICN_1 - START
					out.println("messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num="+(MessageManager.getMessage("en","MAND_CHECK","OR")).get("message")+"'");
					out.println("commontoolbarFrame.location.href = '"+source+"'");
				} // END
				else
				{
					
					out.println("f_query_add_mod.location.href = '../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode=1&function_id="+function_id+" '");
					out.println("messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num="+(MessageManager.getMessage("en","OPERATION_FAILED","OR")).get("message")+"'");
					out.println("commontoolbarFrame.location.href ='"+source+"'");
				}
			}
			else if(callFrom.equals("removePRGroupsForAllUsers"))
			{
				String appLevel = (String)hash.get("appLevel");
				//String groupBy = (String)hash.get("groupBy");
				String grp_by_code = (String)hash.get("grp_by_code");
				String function_id = (String)hash.get("function_id");
				String localeName = (String)hash.get("localeName");
				String result = beanObj.removePrivilegeForAllusers(grp_by_code, appLevel);
				if(result != null && result.equals("SUCCESS"))
				{
					out.println("f_query_add_mod.location.href = '../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode=1&function_id="+function_id+" '");
					out.println("messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num="+(MessageManager.getMessage("en","RECORD_INSERTED","SM")).get("message")+"'");
					out.println("commontoolbarFrame.location.href = '"+source+"'");
				}
				else
				{
					
					out.println("f_query_add_mod.location.href = '../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode=1&function_id="+function_id+"s '");
					out.println("messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num="+MessageManager.getMessage(localeName,"OPERATION_FAILED","OR")+"'");
					out.println("commontoolbarFrame.location.href ='"+source+"'");
				}
				
			}

			else if(callFrom.equals("setUser"))
			{
				String user = (String)hash.get("user");

				if(user != null && !user.equals(""))
				{
					if(user.equals("RALL") || user.equals("P"))
					{
						beanObj.setDelinkSetup(true);
					}
					else
					{
						beanObj.setDelinkSetup(false);
					}
				}
				else
				{
					beanObj.setDelinkSetup(false);
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("eOR.AssingPrivilegeGroupValidate.jsp,163,message=>" +  e.getMessage());
			e.printStackTrace();
		}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
