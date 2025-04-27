package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import ePH.*;
import eST.*;
import eST.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tpnassessmentdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TPNAssessmentDetails.jsp", 1709117413463L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	try {	
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
	
	
		String bean_id				=	request.getParameter( "bean_id" ) ;
		String bean_name			=	request.getParameter( "bean_name" ) ;
		String selectedEnergyProvided	=	request.getParameter( "selectedEnergyProvided" ) ;
		String proteinVal			=	request.getParameter( "proteinVal" ) ;
		String lipidVal				=	request.getParameter( "lipidVal" ) ;
		String weight			=	request.getParameter( "weight" ) ;
		String proteinValueUnit				=	request.getParameter( "proteinValueUnit" ) ;
		String lipidValueUnit			=	request.getParameter( "lipidValueUnit" ) ;

		String carboPerc = request.getParameter("carboPerc");
		if(carboPerc == null || carboPerc.equals("null") ) carboPerc = "";
		String lipidPerc = request.getParameter("lipidPerc");
		if(lipidPerc == null || lipidPerc.equals("null") ) lipidPerc = "";
		String proteinPerc = request.getParameter("proteinPerc");
		if(proteinPerc == null || proteinPerc.equals("null") ) proteinPerc = "";
		String calcByHBF	 = request.getParameter("calcByHBF");
		if(calcByHBF == null || calcByHBF.equals("null") ) calcByHBF = "";

		Hashtable hash			= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash					= (Hashtable)hash.get( "SEARCH" ) ;
		TPNRegimenBean beanObj =null;
		beanObj		= (TPNRegimenBean)getBeanObject(bean_id,bean_name, request);
		String validate				=	request.getParameter( "validate" ) ;
		if(validate == null || validate.equals("null") ) validate = "";
		String encounter_id				=	request.getParameter( "encounter_id" ) ;
		String facility_id		= (String) session.getValue("facility_id");

		int iCalcByIndex = calcByHBF.equals("Y")?0:1;
		int iStressFactorIndex = request.getParameter("iStressFactorIndex")==null?0:Integer.parseInt(request.getParameter("iStressFactorIndex").toString());
		int iBodyWeightIndex =request.getParameter("iBodyWeightIndex")==null?0:Integer.parseInt(request.getParameter("iBodyWeightIndex").toString());
		String sEnergy =request.getParameter("sEnergy")==null?"":request.getParameter("sEnergy").toString();
		String sRecoEnergy =request.getParameter("sRecoEnergy")==null?"":request.getParameter("sRecoEnergy").toString();
		String sFluid =request.getParameter("sFluid")==null?"":request.getParameter("sFluid").toString();
		String sEnergyProvided =request.getParameter("sEnergyProvided")==null?"":request.getParameter("sEnergyProvided").toString();
		int iProteinSelIndex = request.getParameter("iProteinSelIndex")==null?1:Integer.parseInt(request.getParameter("iProteinSelIndex").toString());
		int iLipidSelIndex = request.getParameter("iLipidSelIndex")==null?1:Integer.parseInt(request.getParameter("iLipidSelIndex").toString());
		boolean bActFactor = Boolean.getBoolean(iLipidSelIndex+"");
		//boolean bActFactor = true;

		beanObj.setHmAssesValues(iCalcByIndex,iBodyWeightIndex,sEnergy,bActFactor,sRecoEnergy,carboPerc,lipidPerc,proteinPerc,sFluid,sEnergyProvided,iProteinSelIndex,iLipidSelIndex,iStressFactorIndex);

	   if (validate.equals("before")) {

			HashMap record2=new HashMap(); 
			String tpn_screening_type="";
			String note_type="";
			String accession_num="";
			
			record2=beanObj.ChkAdMixture();
			tpn_screening_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_TYPE"));
			note_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_FORM_ID"));
				   
			if(tpn_screening_type.equals("N")){
			HashMap record3=new HashMap();
			record3=beanObj.ChkScreeningDetails(facility_id,encounter_id,note_type);
			accession_num=CommonBean.checkForNull((String)record3.get("ACCESSION_NUM"));
			  }
			  out.println("beforAccessionNumber(\""+ accession_num + "\");");
			}
	if (validate.equals("Discrete")) {
			try{
			HashMap record2=new HashMap(); 
			String tpn_screening_type="";
			String note_type="";
			String test_observ_dt_tm="";
			
			record2=beanObj.ChkAdMixture();
			tpn_screening_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_TYPE"));
			note_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_FORM_ID"));
			encounter_id			=	request.getParameter( "encounter_id" ) ;
			
			if(tpn_screening_type.equals("D")){
			HashMap record3=new HashMap();
			record3=beanObj.ChkDiscrete(facility_id,encounter_id,note_type);
			test_observ_dt_tm=CommonBean.checkForNull((String)record3.get("TEST_OBSERV_DT_TM"));

			}
			out.println("beforDiscrete(\""+ test_observ_dt_tm + "\");");
			}catch(Exception ee)	{
			 
		        ee.printStackTrace();

			}
	}

	if(calcByHBF.equals("Y")) {  //Harris Benedict Formula
		beanObj.calculateMacroNutrients(selectedEnergyProvided, proteinVal, lipidVal,weight);
	} else {  //Body Weight Formula
		beanObj.calculateMacroNutrients(selectedEnergyProvided, proteinPerc, lipidPerc, carboPerc, weight);
	}
		
		//beanObj.calculateMacroNutrients(selectedEnergyProvided, proteinVal, lipidVal,weight);
		ArrayList energyValue =beanObj.getEnergyValue();
		if(energyValue.size() >0){
			String proteinEnergy = energyValue.get(0)==null?"":(String)energyValue.get(0);
			String lipidEnergy =  energyValue.get(1)==null?"":(String)energyValue.get(1); 
			String carboEnergy = energyValue.get(2)==null?"":(String)energyValue.get(2);
			String proteinEnergyUnit = energyValue.get(3)==null?"":(String)energyValue.get(3);
			String lipidEnergyUnit =  energyValue.get(4)==null?"":(String)energyValue.get(4);
			String carboEnergyUnit = energyValue.get(5)==null?"":(String)energyValue.get(5);
			String proteinStrengthVal = energyValue.get(6)==null?"":(String)energyValue.get(6);
			String lipidStrengthVal =energyValue.get(7)==null?"":(String)energyValue.get(7);
			String carboStrengthVal = energyValue.get(8)==null?"":(String)energyValue.get(8);
			String proteinOrderQuantityVal = energyValue.get(9)==null?"":(String)energyValue.get(9);
			String lipidOrderQuantityVal =energyValue.get(10)==null?"":(String)energyValue.get(10);
			String carboOrderQuantityVal = energyValue.get(11)==null?"":(String)energyValue.get(11);
			out.println("assignMacroNutrients('"+proteinEnergy+"','"+lipidEnergy+"','"+carboEnergy+"','"+proteinEnergyUnit+"','"+lipidEnergyUnit+"','"+carboEnergyUnit+"','"+proteinStrengthVal+"','"+lipidStrengthVal+"','"+carboStrengthVal+"','"+proteinOrderQuantityVal+"','"+lipidOrderQuantityVal+"','"+carboOrderQuantityVal+"','"+proteinValueUnit+"','"+lipidValueUnit+"');");
		}
	

	putObjectInBean(bean_id,beanObj,request);

}catch (Exception e) {
		e.printStackTrace();
	}



            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
