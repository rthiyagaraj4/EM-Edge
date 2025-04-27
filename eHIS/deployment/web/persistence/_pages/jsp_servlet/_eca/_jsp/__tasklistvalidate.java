package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tasklistvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/TaskListValidate.jsp", 1732512445108L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\t ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t \n\t \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
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
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name         Description
--------------------------------------------------------------------------------------------------------------
?             	100           		?           	created
09/01/2014	    IN045571		  Nijitha S	   TTM-SCF-0060
---------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block0Bytes, _wl_block0);
 /*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
31/05/2021      IN017999         Chandrashekar a    AAKH-CRF-0132.1
--------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 			= request.getParameter( "bean_id" )==null?"":request.getParameter( "bean_id" );
	String validate 		= request.getParameter( "validate" )==null?"":request.getParameter( "validate" );
	String flag				= request.getParameter("flag")==null?"":request.getParameter( "flag" );
	

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

		
	//String isRDInstalled_yn="";
	//String isOTInstalled_yn="";


	//String practitioner_id	= (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	//String resp_id 			= (String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");	
	PatTaskListRepository beanObj = (PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);

	//beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	 if (flag == null || flag.equals("")) {
		  if ( validate.equals( "ord_cat" ) ) {
			 String order_cat = (String)hash.get("OrderCategory") ;			
			 if(order_cat==null || order_cat.equals("null") || order_cat.equals("") )
			  {
				 out.println( "clearOrderTValues('document');");
			  }
			  /* else if(order_cat.equalsIgnoreCase("OT"))
			  {					
					out.println( "clearOrderTValues('document');");
					String isOTInstalled_yn = (String) beanObj.isModuleInstalled(facility_id,"OT");
					out.println( "setOTvalue(\"" + isOTInstalled_yn+ "\") ; " ) ;
					if(isOTInstalled_yn.equalsIgnoreCase("Y"))
					{
						order_cat="";
					}
			  } */
			  else if(order_cat.equalsIgnoreCase("RD"))
			  {					
					out.println( "clearOrderTValues('document');");
					String isRDInstalled_yn = (String) beanObj.isModuleInstalled(facility_id,"RD");
					out.println( "setRDvalue(\"" + isRDInstalled_yn+ "\") ; " ) ;
					if(isRDInstalled_yn.equalsIgnoreCase("Y"))
					{
						order_cat="";
					}
			  }
			  else
			  {
					String c_OrderType = (String)hash.get("c_OrderType") ;
					
					ArrayList OrderTypeData = beanObj.getOrderType(property,order_cat) ;
					out.println( "clearOrderTValues('document');");
					for( int i=0 ; i< OrderTypeData.size() ; i++ ) 
					{

						String[] record = (String[])OrderTypeData.get(i);
						
						
						String selected = "false";
						if(c_OrderType.equals(record[1])) selected="selected";
							out.println( "addOrderTypeList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
					}
				}
	 }
	 else if ( validate.equals( "save" ) ) {
		 //beanObj.putHashvalues("c_locn_desc",(String)hash.get("c_locn_desc")) ;//Commented for IN045571	
		 beanObj.putHashvalues("c_locn_desc",java.net.URLDecoder.decode((String)hash.get("c_locn_desc"),"UTF-8")) ;//IN045571	
		 beanObj.putHashvalues("c_location_type",(String)hash.get("c_location_type")) ;
		 beanObj.putHashvalues("c_locn_code",(String)hash.get("c_locn_code")) ;
		 beanObj.putHashvalues("c_patient_id",(String)hash.get("c_patient_id")) ;
		 beanObj.putHashvalues("c_status_code",(String)hash.get("c_status_code")) ;
		 beanObj.putHashvalues("c_taskSelect",(String)hash.get("c_taskSelect")) ;
		 beanObj.putHashvalues("c_OrderCategory",(String)hash.get("c_OrderCategory")) ;
		 beanObj.putHashvalues("c_OrderType",(String)hash.get("c_OrderType")) ;
		 beanObj.putHashvalues("c_Groupby",(String)hash.get("c_Groupby")) ;
		 beanObj.putHashvalues("c_To_date",(String)hash.get("c_To_date")) ;
		 beanObj.putHashvalues("c_From_date",(String)hash.get("c_From_date")) ;
		 beanObj.putHashvalues("c_pat_discharge",(String)hash.get("c_pat_discharge")) ;
		 beanObj.putHashvalues("c_onclickS",(String)hash.get("c_onclickS")) ;
		 beanObj.putHashvalues("c_clickdate",(String)hash.get("c_clickdate")) ;
		 beanObj.putHashvalues("c_search",(String)hash.get("c_search")) ;
		 beanObj.putHashvalues("c_patientname",(String)hash.get("c_patientname")) ;
		 beanObj.putHashvalues("c_chkAll",(String)hash.get("c_chkAll")) ;
		 beanObj.putHashvalues("c_ckhDue",(String)hash.get("c_ckhDue")) ;
		 beanObj.putHashvalues("c_chkOverdue",(String)hash.get("c_chkOverdue")) ;
		 beanObj.putHashvalues("c_chkElapsed",(String)hash.get("c_chkElapsed")) ;
		 beanObj.putHashvalues("c_chkPerformed",(String)hash.get("c_chkPerformed")) ;
		 beanObj.putHashvalues("c_chkReg",(String)hash.get("c_chkReg")) ;
		 beanObj.putHashvalues("c_chkFuture",(String)hash.get("c_chkFuture")) ;
		 beanObj.putHashvalues("c_taskListFlag",(String)hash.get("c_taskListFlag")) ;
		 beanObj.putHashvalues("c_taskSelectAll",(String)hash.get("c_taskSelectAll")) ;
		 beanObj.putHashvalues("c_chkUnclassify",(String)hash.get("c_chkUnclassify")) ;
		 
	}
	else if(validate.equals("definition"))
	{
		String definition = (String)hash.get("definition");
		if(definition==null || definition.equals("null") || definition.equals("") )
		{
			out.println( "clearIntervention('document');");
		}
		else
		{
			ArrayList InterventionData = beanObj.getInterventionType(property,definition) ;
			
			out.println( "clearIntervention('document');");
			for( int i=0 ; i< InterventionData.size() ; i++ ) 
			{
				String[] record = (String[])InterventionData.get(i);
				out.println( "addInterventionType(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			}
		}

	}else if(validate.equals("encounter_list"))//Added function for IN017999
	{
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String sel_encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		
			ArrayList EncounterList = beanObj.getEncounterList(patient_id) ;
						//System.err.println("EncounterList @@@==="+EncounterList);
			
			out.println( "clearEncounterList('document');");
			for( int i=0 ; i< EncounterList.size() ; i++ ) 
			{
				String encounter_id = (String)EncounterList.get(i);
				out.println( "addEncounterList(\"" + encounter_id + "\",\""+sel_encounter_id+"\") ; " ) ;
			}
		

	}

	 }
            _bw.write(_wl_block3Bytes, _wl_block3);
putObjectInBean("patTask",beanObj,request);
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
