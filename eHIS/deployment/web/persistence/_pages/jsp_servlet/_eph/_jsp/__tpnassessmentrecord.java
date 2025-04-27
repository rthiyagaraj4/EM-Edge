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
import eOR.Common.*;
import ePH.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tpnassessmentrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TPNAssessmentRecord.jsp", 1742370052962L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
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

	try{
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		
		String bean_id	= request.getParameter("bean_id");
		String bean_name	 = request.getParameter("bean_name");
		out.println(bean_id);
		String carbohydrate_Energy = request.getParameter("Carbohydrate_Energy");
		String cabohydrate_Order_Quantity = request.getParameter("Cabohydrate_Order_Quantity");
		String cabohydrate_Strength_Weight = request.getParameter("Cabohydrate_Strength_Weight");
		String protein_Energy = request.getParameter("Protein_Energy");
		String protein_Order_Quantity = request.getParameter("Protein_Order_Quantity");
		String protein_Strength_Weight = request.getParameter("Protein_Strength_Weight");
		String lipid_Energy = request.getParameter("Lipid_Energy");
		String lipid_Order_Quantity = request.getParameter("Lipid_Order_Quantity");
		String lipid_Strength_Weight = request.getParameter("Lipid_Strength_Weight");	/*out.println(bean_id+bean_name+Carbohydrate_Energy+Cabohydrate_Order_Quantity_GM+Cabohydrate_Strength_Weight+Protein_Energy+Protein_Order_Quantity_GM+Protein_Strength_Weight+Lipid_Energy+Lipid_Order_Quantity_GM+ Lipid_Strength_Weight);*/
		StringTokenizer stk;
		ArrayList carbohydrate_Energy_ValueUnit = new ArrayList();
		ArrayList carbohydrate_Order_Quantity_VaueUnit = new ArrayList();
		ArrayList carbohydrate_Strength_Weight_VaueUnit = new ArrayList();
		ArrayList protein_Energy_ValueUnit = new ArrayList();
		ArrayList protein_Order_Quantity_VaueUnit = new ArrayList();
		ArrayList protein_Strength_Weight_VaueUnit = new ArrayList();
		ArrayList lipid_Energy_ValueUnit = new ArrayList();
		ArrayList lipid_Order_Quantity_VaueUnit = new ArrayList();
		ArrayList lipid_Strength_Weight_VaueUnit = new ArrayList();
		stk = new StringTokenizer(carbohydrate_Energy," ");
		while(stk.hasMoreTokens()){
			
			carbohydrate_Energy_ValueUnit.add(stk.nextToken());
		}
	
		stk = new StringTokenizer(cabohydrate_Order_Quantity," ");
		
		while(stk.hasMoreTokens()){
			
			carbohydrate_Order_Quantity_VaueUnit.add(stk.nextToken());
			
		}
		

		stk = new StringTokenizer(cabohydrate_Strength_Weight," ");
		while(stk.hasMoreTokens()){
			carbohydrate_Strength_Weight_VaueUnit.add(stk.nextToken());
		}

		stk = new StringTokenizer(protein_Energy," ");
		while(stk.hasMoreTokens()){
			protein_Energy_ValueUnit.add(stk.nextToken());
		}
		
		stk = new StringTokenizer(protein_Order_Quantity," ");
		while(stk.hasMoreTokens()){
			protein_Order_Quantity_VaueUnit.add(stk.nextToken());
		}

		stk = new StringTokenizer(protein_Strength_Weight," ");
		while(stk.hasMoreTokens()){
			protein_Strength_Weight_VaueUnit.add(stk.nextToken());
		}

		stk = new StringTokenizer(lipid_Energy," ");
		while(stk.hasMoreTokens()){
			lipid_Energy_ValueUnit.add(stk.nextToken());
		}
		
		stk = new StringTokenizer(lipid_Order_Quantity," ");
		while(stk.hasMoreTokens()){
			lipid_Order_Quantity_VaueUnit.add(stk.nextToken());
		}

		stk = new StringTokenizer(lipid_Strength_Weight," ");
		while(stk.hasMoreTokens()){
			lipid_Strength_Weight_VaueUnit.add(stk.nextToken());
		}
		
		TPNRegimenBean bean = (TPNRegimenBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setCarbohydrateEnergy(carbohydrate_Energy_ValueUnit);
		bean.setCabohydrateOrderQuantity(carbohydrate_Order_Quantity_VaueUnit);
		bean.setCabohydrateStrengthWeight(carbohydrate_Strength_Weight_VaueUnit);
		bean.setProteinEnergy(protein_Energy_ValueUnit);
		bean.setProteinOrderQuantity(protein_Order_Quantity_VaueUnit);
		bean.setProteinStrengthWeight(protein_Strength_Weight_VaueUnit);
		bean.setLipidEnergy(lipid_Energy_ValueUnit);
		bean.setLipidOrderQuantity(lipid_Order_Quantity_VaueUnit);
		bean.setLipidStrengthWeight(lipid_Strength_Weight_VaueUnit);
		/*out.println(bean.getCarbohydrateEnergy());
		out.println(bean.getCabohydrateOrderQuantity());
		out.println(bean.getCabohydrateStrengthWeight());
		out.println(bean.getProteinEnergy());
		out.println(bean.getProteinOrderQuantity());
		out.println(bean.getProteinStrengthWeight());
		out.println(bean.getLipidEnergy());
		out.println(bean.getLipidOrderQuantity());
		out.println(bean.getLipidStrengthWeight());
		out.println(bean.getCarbohydrateEnergyUnit());
		out.println(bean.getCabohydrateOrderQuantityUnit());
		out.println(bean.getCabohydrateStrengthWeightUnit());
		out.println(bean.getProteinEnergyUnit());
		out.println(bean.getProteinOrderQuantityUnit());
		out.println(bean.getProteinStrengthWeightUnit());
		out.println(bean.getLipidEnergyUnit());
		out.println(bean.getLipidOrderQuantityUnit());
		out.println(bean.getLipidStrengthWeightUnit());*/
		putObjectInBean(bean_id,bean,request);
	}catch(Exception e){
		out.println("alert('"+e.toString()+"')");
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
