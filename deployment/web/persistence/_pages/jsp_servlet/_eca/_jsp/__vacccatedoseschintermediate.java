package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCA.*;
import webbeans.eCommon.MessageManager;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __vacccatedoseschintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/VaccCateDoseSchInterMediate.jsp", 1718796229090L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t \n\t \n";
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

/*
---------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date 		Rev.by 					Description
----------------------------------------------------------------------------------------------------------------------------------------
18/05/2023       41653             Twinkle Shah     18/05/2023     M.f.mohamed Ali           Commented for Non-Linked issue against MMS-JU-CRF-0015.3
------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	try 
	{
		request.setCharacterEncoding("UTF-8");		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;	
		String callFrom =(String) hash.get("CallFrom");
		Properties properties = (Properties) session.getAttribute("jdbc") ;
		String locale = (String) properties.getProperty("LOCALE");
		
		/*if(callFrom.equals("VaccineScheduleDose"))
		{
			
		}else{*/
			VaccineForCategoryBean vaccineBean = (VaccineForCategoryBean)getObjectFromBean("vaccinebean","eCA.VaccineForCategoryBean",session);		

			if(callFrom.equals("VaccineScheduleDose"))
			{		
				String vaccineId =(String) hash.get("vaccineId");
				String duplicateYN =(String) hash.get("duplicateYN");
				String duplicateDays =(String) hash.get("duplicateDays");
//				String duplicateAction =(String) hash.get("duplicateAction");
				String isAdhocAgeSpec =(String) hash.get("isAdhocAgeSpec");
				String categoryId =(String) hash.get("categoryId");
				int doseCnt = Integer.parseInt((String) hash.get("rowCount"));		
				
				
				hash.remove("vaccineId");
				hash.remove("rowCount");
				hash.remove("CallFrom");
				hash.remove("duplicateYN");
				hash.remove("duplicateDays");
				hash.remove("duplicateAction");
				hash.remove("isAdhocAgeSpec");
				hash.remove("categoryId");

				String retMsg = vaccineBean.setVaccnieSchedule(vaccineId, doseCnt, hash, duplicateYN, duplicateDays, isAdhocAgeSpec, categoryId);
				
				
				if(retMsg != null && retMsg.equals("DUPLICATE_CHECK"))
				{
					//out.println("alert(getMessage('VACCINE_ALLREADY_DEFINED','CA'))");
					vaccineBean.removeVaccineSchedule(vaccineId);
					out.println("DUPLICATE_CHECK");
					
				}
			}
			else if(callFrom.equals("clearScheduleVaccineDose"))
			{		
				//vaccineBean = new VaccineForCategoryBean();
				vaccineBean.clearVaccineBean();	

				
				out.println("var categoryId = document.vaccinesForCategoryHeaderForm.categoryCode.value;");			
				out.println("parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';");
				out.println("parent.VaccinesForCategoryMiddleFrame.location.href='../../eCA/jsp/VaccinesForCategoryList.jsp?categoryId='+categoryId");
				out.println("parent.VaccinesForCategorySearchFrame.location.href='../../eCA/jsp/VaccinesForCategorySearch.jsp'");
				out.println("parent.VaccinesForCategoryBottomFrame.location.href='../../eCA/jsp/VaccinesForCategoryDtl.jsp?categoryId='+categoryId");
			}
			else if(callFrom.equals("checkVacccineSchedules"))
			{
				
				String vaccineCnt =(String) hash.get("vaccineCnt")==null?"":(String) hash.get("vaccineCnt");
				String categoryId =(String) hash.get("categoryId")==null?"":(String) hash.get("categoryId");
				hash.remove("vaccineCnt");
				hash.remove("categoryId");
				hash.remove("checkVacccineSchedules");
				vaccineCnt = vaccineCnt.equals("")?"0":vaccineCnt;
				int vaccCnt = Integer.parseInt(vaccineCnt);
				
				
				
				vaccineBean.setSelectedVaccineList(hash, vaccCnt);	
				boolean isAdhoc =  vaccineBean.isAdhocCategory(categoryId);

				if(isAdhoc)
				{		
					String facilityId = (String) session.getAttribute("facility_id") ;
					vaccineBean.insertOrUpdate(categoryId, properties, facilityId);
					Hashtable tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
					String errorMsg = (String) tabdata.get("message");
					out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=1'");
				}else
				{
					List<String> notScheduleVaccLst = vaccineBean.checkAllSelectedVaccineAreScheduled(locale);

					if(notScheduleVaccLst == null)
					{
						String facilityId = (String) session.getAttribute("facility_id") ;						
						vaccineBean.insertOrUpdate(categoryId, properties, facilityId);
						Hashtable tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
						String errorMsg = (String) tabdata.get("message");
						out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=1'");
					}
					else if(notScheduleVaccLst != null)
					{
						String notSchVaccStr = "";
						for(String str : notScheduleVaccLst)
						{
							String []st = str.split("`~");
							String doseErr = "";
							if(st != null && st.length >1)
							{
								str = st[0].trim();
								doseErr = st[1]==null?"":st[1];

							}
							if(notSchVaccStr.equals(""))
							{
								notSchVaccStr = vaccineBean.getVaccineList().get(str) + doseErr;
							}
							else
							{
								notSchVaccStr = notSchVaccStr + ", "+vaccineBean.getVaccineList().get(str) + doseErr;
							}
							
						}
						Hashtable tabdata = MessageManager.getMessage(locale, "VACC_FREQ_NOT_EMPTY","CA");
						String errorMsg = (String) tabdata.get("message");
						errorMsg = errorMsg.replace("$$", notSchVaccStr);
						out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"'");
					}
				}	
			}
			else if(callFrom.equals("RemoveVaccineFormSchedule"))
			{
				String vaccineId =(String) hash.get("vaccineId");
				String categoryId =(String) hash.get("categoryId");
				vaccineBean.removeVaccineList(vaccineId);
				vaccineBean.removeSelectedVaccineList(vaccineId);				
				vaccineBean.deleteVaccineFromSchedule(categoryId, vaccineId);
				vaccineBean.removeVaccineSchedule(vaccineId); //41653	
			}
			else if(callFrom.equals("AddVaccineToSchedule"))
			{
				String vaccineId =(String) hash.get("vaccineId");
				String vaccDesc =(String) hash.get("vaccineDesc");
				vaccineBean.removeVaccineList(vaccineId);
				vaccineBean.setVaccine(vaccineId, vaccDesc);
			}
			else if(callFrom.equals("AddDoseNO"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				String doseNo =(String) hash.get("doseNo");
				vaccineBean.setDoseNo(vaccineId, doseNo);
			}  
			else if(callFrom.equals("AddDLFTSite"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				String DLFTSite =(String) hash.get("DLFTSite");
				vaccineBean.setDLFTSite(vaccineId, DLFTSite);
			}  
			else if(callFrom.equals("AddPrevAdminYN"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				String prevAdminYN =(String) hash.get("prevAdminYN");
				vaccineBean.setChkPrevAdmin(vaccineId, prevAdminYN);
			}  
			else if(callFrom.equals("AddPrevDays"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				String prevDays =(String) hash.get("prevDays");
				vaccineBean.setChkPrevDays(vaccineId, prevDays);
			}  
			else if(callFrom.equals("AddPrevAction"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				String prevAction =(String) hash.get("prevAction");				
				vaccineBean.setChkPrevAction(vaccineId, prevAction);
			}  
			else if(callFrom.equals("RemoveVaccineFromSchedule"))
		    {
				String vaccineId =(String) hash.get("vaccineId");
				vaccineBean.removeVaccineSchedule(vaccineId);
			}  

			putObjectInBean("vaccinebean",vaccineBean,session);
		//}
	}catch(Exception e){
		e.printStackTrace();	
	}

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
