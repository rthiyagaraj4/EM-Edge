package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eOT.StaffAssignmentBean;
import webbeans.eOT.StaffAssignmentTimeBean;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __staffassignmentvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/StaffAssignmentValidation.jsp", 1709117286000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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



	public String getRoleId(String roleID)
	{
		if(roleID != null && !roleID.equals("") && roleID.indexOf("~") > 0)
		{
			String [] roleIdArray = roleID.split("~");
			return roleIdArray[0];
		}
		
		return roleID;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);


	String bean_id = "ot_StaffAssignmentBean";
	String bean_name = "eOT.StaffAssignmentBean";
	StaffAssignmentBean staffAssignmentBean = (StaffAssignmentBean)getBeanObject( bean_id, bean_name, request ) ;



	try 
	{
		
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event")==null? "":request.getParameter("event"));
		
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		String mode = (String)hash.get("mode");	
		
		
		
		if(func_mode!= null && func_mode.equals("INSERT"))
		{
			String rowCount	= (String)hash.get("rowCount");
			List<StaffAssignmentTimeBean> timeBeanList = new ArrayList<StaffAssignmentTimeBean>();
			List<String> operRoomCodeList = new ArrayList<String>();
			StaffAssignmentTimeBean timeBean = null;
			
			int totalRec = Integer.parseInt(rowCount);
			
			
			String operRoomCodeStr = (String)hash.get("operRoomCode");
			String [] operRoomCodeArray = operRoomCodeStr.split("~");
			
			for(String operRoomCode : operRoomCodeArray)
			{
				operRoomCodeList.add(operRoomCode);
				int recFound = 0;
				for(int i=1; recFound<totalRec; i++)
				{
					timeBean = new StaffAssignmentTimeBean();
					
					timeBean.setAssignmentDate((String)hash.get("assignmentDate"));
					timeBean.setOperRoomCode(operRoomCode);
					
					timeBean.setStaffId((String)hash.get("practitionerId_"+i));
					
					if(timeBean.getStaffId() != null && !timeBean.getStaffId().trim().equals(""))
					{
						recFound++;
					}
					else
					{
						continue;
					}
					timeBean.setRoleId(getRoleId((String)hash.get("roleType_"+i)));
					timeBean.setStaffId((String)hash.get("practitionerId_"+i));
					timeBean.setFromTime((String)hash.get("fromTime_"+i));
					timeBean.setToTime((String)hash.get("toTime_"+i));
					timeBean.setShowWidgetYN((String)hash.get("showWidgetYN_"+i));
					
					timeBeanList.add(timeBean);
				}
			}
			staffAssignmentBean.setOperRoomCodeList(operRoomCodeList);
			staffAssignmentBean.setTimeList(timeBeanList);
		}
		else if(func_mode!= null && func_mode.equals("UPDATE"))
		{
			String dateCount	= (String)hash.get("dateCount");
			String indexSuffix = null;
			List<StaffAssignmentTimeBean> timeBeanList = new ArrayList<StaffAssignmentTimeBean>();
			List<StaffAssignmentTimeBean> insertTimeBeanList = new ArrayList<StaffAssignmentTimeBean>();
			StaffAssignmentTimeBean timeBean = null;
			
			int totalRec = Integer.parseInt(dateCount);
			
			boolean insert = false;
			for(int dateIndex=1; dateIndex<=totalRec; dateIndex++)
			{
				
				int timeRec = Integer.parseInt((String)hash.get("rowCount" + dateIndex));
				int recFound = 0;
				
				for(int i=1; recFound<timeRec-1; i++)
				{
					insert = false;
					timeBean = new StaffAssignmentTimeBean();
					indexSuffix =  dateIndex + "_" + i;
					timeBean.setAssignmentDate((String)hash.get("assignmentDate" + dateIndex));
					timeBean.setOperRoomCode((String)hash.get("operRoomCode" + dateIndex));
					
					
					timeBean.setStaffId((String)hash.get("practitionerId" + indexSuffix));
					
					if(timeBean.getStaffId() != null && !timeBean.getStaffId().trim().equals(""))
					{
						recFound++;
					}
					else
					{
						continue;
					}
					
					String staffAssigmentId = (String)hash.get("staffAssignmentId" + indexSuffix);
					
					if(staffAssigmentId != null && !staffAssigmentId.equals(""))
					{
						String rowModified = (String)hash.get("rowModified" + indexSuffix);
						
						// If row is not modified ignore
						
						if(rowModified == null || !rowModified.equals("Y"))
						{
							continue;
						}
						timeBean.setStaffAssginmentId(Integer.parseInt(staffAssigmentId));	
						
					}
					else
					{
						insert = true;
					}
						
					timeBean.setRoleId(getRoleId((String)hash.get("roleType"+ indexSuffix)));
					timeBean.setFromTime((String)hash.get("fromTime"+ indexSuffix));
					timeBean.setToTime((String)hash.get("toTime"+ indexSuffix));
					timeBean.setShowWidgetYN((String)hash.get("showWidgetYN"+ indexSuffix));
					
					if(insert)
					{
						insertTimeBeanList.add(timeBean);
					}
					else
					{
						timeBeanList.add(timeBean);
					}
				}
			}
			staffAssignmentBean.setUpdateTimeBeanList(timeBeanList);
			staffAssignmentBean.setTimeList(insertTimeBeanList);
			
			
			//Code to check deleted record
			
			String deleteId = (String)hash.get("deleteId");
			if(deleteId != null && !deleteId.equals(""))
			{
				List<Integer> deleteIdList = new ArrayList<Integer>();
				String [] deleteIdArray = deleteId.split("~");
				
				for(String assignId :  deleteIdArray)
				{
					deleteIdList.add(Integer.parseInt(assignId));
				}
				staffAssignmentBean.setStaffAssignmentIdDeleteList(deleteIdList);
			}
		}
	
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.out.println("Exception from StaffAssignmentBeanValidation :" + e);
	}

	putObjectInBean(bean_id,staffAssignmentBean,request);


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
