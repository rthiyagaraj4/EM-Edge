package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __disdatachartingsubmit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DisDataChartingSubmit.jsp", 1709120685626L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  <!--This file is saved on 07/11/2005-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/DisDataCharting.js\"></script>\n\t<Script src=\"../../eCommon/js/locale.js\" language=\"JavaScript\"></Script>\n\t<SCRIPT LANGUAGE=\"Javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<!-- <body CLASS=\"MESSAGE\"> -->\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\" CLASS=\"MESSAGE\"> \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
 
	    String lStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(lStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	String bean_id					= "DisDataChartingBean"+(String)request.getParameter("episode_id");
	String bean_name				= "ePH.DisDataChartingBean";

	DisDataChartingBean beanObj = ( DisDataChartingBean )getBeanObject(bean_id,bean_name,request) ;
	beanObj.setLanguageId(locale);

	java.util.Properties p = (java.util.Properties) session.getValue("jdbc") ;
//	String locale		= (String) p.getProperty("LOCALE");
	String sStyle =	 "";	
	String operatingfacilityid = "";         
	String accessionnum = "";                  
	String episodetype = "";                   
	String episodeid = "";                     
	String visitid = "";                       
	String clinicianid = "";        
	String locncode = "";
	String patientid = "";
	String discrmsrid = ""; 
	String discrmsrresultnum = "";           
	String discrmsrresultnumuom = "";       
	String discrmsrresultstr = "";           
	String discrmsrresultdata = "";          
	String normallow = "";                     
	String normalhigh = "";                    
	String criticallow = "";                   
	String criticalhigh = "";   
	String discrmsrresulttype = "";
	String admdttime = "";
	String defdata = "";
	String normabnormind = "";
	String batteryid = "";
	String Sdate = "";
	String inError="";
	String inReplace="";
	String errorRemarks="";
	String client_ip_address="";
	String location_type ="";
	String module_id="";
	int rowcount=1;
	int noofrec = 0;
	int outrec = 0;
	int noofvals = 15;
	String temp_outrec=outrec+"";
	String temp_noofvals=noofvals+"";
			
	String finalvalues[][] = null ;

	sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	try
	{
		Sdate=request.getParameter("sys_date_time");
		patientid = request.getParameter("patient_id");	
		clinicianid = request.getParameter("clinician_id");
		locncode = request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
		episodetype = request.getParameter("patient_class");

		episodeid = request.getParameter("episode_id");    
		visitid = request.getParameter("visit_id")==null?"1":request.getParameter("visit_id");       
		operatingfacilityid = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		admdttime = request.getParameter("adm_dt_time")==null?"":request.getParameter("adm_dt_time");
		inError = request.getParameter("in_error")==null?"":request.getParameter("in_error");
		inReplace =request.getParameter("in_replace")==null?"":request.getParameter("in_replace");
		client_ip_address = p.getProperty("client_ip_address");
		location_type = (request.getParameter("location_type")==null)?"":request.getParameter("location_type");
		module_id =request.getParameter("module_id")==null?"":request.getParameter("module_id"); 	

		batteryid =request.getParameter("battery_id")==null?"":request.getParameter("battery_id"); 
		noofrec = Integer.parseInt(request.getParameter("no_of_rec")==null?"":request.getParameter("no_of_rec"));
		outrec = noofrec+1;
		temp_outrec=outrec+"";
		finalvalues =  new String[outrec][noofvals];
		String flag="";	

		for(rowcount=1; rowcount<=noofrec;rowcount++)
		{
			int colcount = 0;
			errorRemarks=request.getParameter("remarks"+String.valueOf(rowcount-1))==null?"":request.getParameter("remarks"+String.valueOf(rowcount-1));  
			discrmsrid = request.getParameter("item_id_"+String.valueOf(rowcount));
			discrmsrresulttype = request.getParameter("result_type_"+String.valueOf(rowcount))==null?"":request.getParameter("result_type_"+String.valueOf(rowcount));

			if(discrmsrresulttype.equals("N") || discrmsrresulttype.equals("I"))
			{
					discrmsrresultnum = request.getParameter("str_id_"+String.valueOf(rowcount))==null?"":request.getParameter("str_id_"+String.valueOf(rowcount));
					discrmsrresultnumuom = request.getParameter("uom_id_"+String.valueOf(rowcount))==null?"":request.getParameter("uom_id_"+String.valueOf(rowcount)); 
					normallow = request.getParameter("normal_low_"+String.valueOf(rowcount))==null?"":request.getParameter("normal_low_"+String.valueOf(rowcount));                        
					normalhigh = request.getParameter("normal_high_"+String.valueOf(rowcount))==null?"":request.getParameter("normal_high_"+String.valueOf(rowcount));                      
					criticallow = request.getParameter("num_crit_low_"+String.valueOf(rowcount))==null?"":request.getParameter("num_crit_low_"+String.valueOf(rowcount));                        
					criticalhigh = request.getParameter("num_crit_high_"+String.valueOf(rowcount))==null?"":request.getParameter("num_crit_high_"+String.valueOf(rowcount));                       
					if(normallow.equals("")) normallow = "0";
					if(normalhigh.equals("")) normalhigh = "0";
					if(criticallow.equals("")) criticallow = "0";
					if(criticalhigh.equals("")) criticalhigh = "0";
					discrmsrresultdata = "";
			}
			else if(discrmsrresulttype.equals("L") || discrmsrresulttype.equals("C"))
			{
					discrmsrresultstr = request.getParameter("str_id_"+String.valueOf(rowcount))==null?"":request.getParameter("str_id_"+String.valueOf(rowcount));           
					discrmsrresultnum = "";
					discrmsrresultnumuom = "";
					discrmsrresultdata = "";
			}
			else if(discrmsrresulttype.equals("F"))
			{
					discrmsrresultdata = request.getParameter("str_id_"+String.valueOf(rowcount))==null?"":request.getParameter("str_id_"+String.valueOf(rowcount));        
					discrmsrresultnum = "";
					discrmsrresultnumuom = "";
			}
			else
			{
					discrmsrresultstr = request.getParameter("str_id_"+String.valueOf(rowcount))==null?"":request.getParameter("str_id_"+String.valueOf(rowcount));           
					discrmsrresultnum = "";
					discrmsrresultnumuom = "";
					discrmsrresultdata = "";
			}
					
			accessionnum= request.getParameter("accession_num_"+String.valueOf(rowcount))==null?"":request.getParameter("accession_num_"+String.valueOf(rowcount));                        
			defdata = request.getParameter("def_data_"+String.valueOf(rowcount))==null?"":request.getParameter("def_data_"+String.valueOf(rowcount));
			normabnormind = "";

			if(discrmsrresulttype.equals("N") || discrmsrresulttype.equals("I")){
				discrmsrresultstr = "";
				if(!discrmsrresultnum.equals(""))	{
					double n = Double.parseDouble(discrmsrresultnum);
					if(!(normallow.equals("") && criticallow.equals(""))){
						double l = Double.parseDouble(normallow);
						double c = Double.parseDouble(criticallow);

						if(l!=0.0 && n<l) 	normabnormind = "L";
						if(c!=0.0 && n< c) normabnormind = "K";
					}
					if(!(normalhigh.equals("") && criticalhigh.equals(""))){
						double h = Double.parseDouble(normalhigh);
						double c = Double.parseDouble(criticalhigh);

						if(h!=0.0 && n > h) normabnormind = "H";
						//if(c!=0.0 && n>c) normabnormind = "I";
						if(c!=0.0 && n>c) normabnormind = "M";
					}
				}
			}
			discrmsrresultdata+=defdata;
			if(discrmsrresulttype.equals("L") && !discrmsrresultstr.equals(""))
					normabnormind = request.getParameter("norm_abnorm_ind_"+String.valueOf(rowcount))==null?"":request.getParameter("norm_abnorm_ind_"+String.valueOf(rowcount)); 
			if(discrmsrresulttype.equals("C"))
				if(discrmsrresultstr.equals("")) discrmsrresultstr = "N";

			String operation = request.getParameter("op_type_"+String.valueOf(rowcount));

			finalvalues[rowcount][colcount++] = accessionnum;                 
			finalvalues[rowcount][colcount++] = discrmsrid;   
			finalvalues[rowcount][colcount++] = discrmsrresulttype;
			finalvalues[rowcount][colcount++] = discrmsrresultnum;         
			finalvalues[rowcount][colcount++] = discrmsrresultnumuom; 
			finalvalues[rowcount][colcount++] = discrmsrresultstr;           
			finalvalues[rowcount][colcount++] = discrmsrresultdata;        
			finalvalues[rowcount][colcount++] = normallow;                        
			finalvalues[rowcount][colcount++] = normalhigh;                      
			finalvalues[rowcount][colcount++] = criticallow;                        
			finalvalues[rowcount][colcount++] = criticalhigh;                       
			finalvalues[rowcount][colcount++] = normabnormind;
			finalvalues[rowcount][colcount++] = operation;
			finalvalues[rowcount][colcount++] = errorRemarks;
		} 

		HashMap results = new HashMap();
		//(java.util.HashMap)(busObj.getClass().getMethod("operateDisDataCharting",paramArray)).invoke(busObj,argArray);
		//(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		//boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

		results = beanObj.operateDisDataCharting( p,operatingfacilityid,episodetype,episodeid,visitid,clinicianid,locncode,patientid,batteryid,Sdate,finalvalues,admdttime,temp_outrec,temp_noofvals,client_ip_address,location_type,module_id,inError,inReplace );

		boolean inserted = (Boolean)results.get("status");
		String error = (String)results.get("error") ;
		//out.println(error);
		//out.println(results);
		//results.clear();
		out.println("<script>alert('"+error+"');</script>");

		if(inserted)	
			out.println("<script>window.close();</script></BODY></html>");
	}
	catch ( Exception e ) {
		e.printStackTrace();
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
