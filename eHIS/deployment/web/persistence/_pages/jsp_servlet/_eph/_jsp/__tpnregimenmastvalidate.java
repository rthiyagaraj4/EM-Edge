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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tpnregimenmastvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TPNRegimenMastValidate.jsp", 1721706131467L ,"10.3.6.0","Asia/Calcutta")) return true;
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

/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

22/11/2019      IN070800        PRATHYUSHA                          ML-MMOH-SCF-1303
-------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	Hashtable hash		= (Hashtable)xmlObj.parseXMLString(request);
	hash				= (Hashtable)hash.get("SEARCH");
	String bean_id		= (String) hash.get("bean_id");
	String bean_name	= (String) hash.get("bean_name");
	String func_mode	= request.getParameter("func_mode");

	
	TPNRegimenMastBean beanObj	= (TPNRegimenMastBean)getBeanObject(bean_id,bean_name,request);

/*
	if(func_mode!=null && func_mode.equals("")) {

		HashMap masterform	= new HashMap();
		String schedule_id			=	(hash.get("schedule_id")==null)?"":(String)hash.get("schedule_id");
		String prescribing_catg		=	(hash.get("prescribing_catg")==null)?"":(String)hash.get("prescribing_catg");
		String tpn_regimen_code				= (String) hash.get( "tpn_regimen_code" );
		String infuse_over			=	(hash.get("infuse_over")==null)?"":(String)hash.get("infuse_over");
		String infuse_over_list		=	(hash.get("infuse_over_list")==null)?"":(String)hash.get("infuse_over_list");
		String long_name	=	(hash.get("long_name")==null)?"":(String)hash.get("long_name");
		String single_emulsion	=	(hash.get("single_emulsion")==null)?"":(String)hash.get("single_emulsion");
		String pres_base_uom	=	(hash.get("pres_base_uom")==null)?"":(String)hash.get("pres_base_uom");
		
		masterform.put("schedule_id",schedule_id);
		masterform.put("prescribing_catg",prescribing_catg);
		masterform.put("tpn_regimen_code",tpn_regimen_code);
		masterform.put("infuse_over",infuse_over);
		masterform.put("infuse_over_list",infuse_over_list);
		masterform.put("long_name",long_name);
		masterform.put("single_emulsion",single_emulsion);
		masterform.put("pres_base_uom",pres_base_uom);


		beanObj.setMasterform(masterform);
	
	}
	else
*/		
		if(func_mode!=null && func_mode.equals("Constituents_tab")) {
		
		String key			= "";
		String value		= "";
	
		String total_energy = (String)hash.get("ttl_energy");
		String lipid_emulsion_type = (String)hash.get("lipid_emulsion_type");
		String npc_ratio = (String)hash.get("npc_ratio_val");
		ArrayList  constituents	= new ArrayList();
	
		HashMap	record1	= new HashMap();
		Enumeration keys		= hash.keys();
	
		float total_volume		=	0.0f;

		while(keys.hasMoreElements()) {
			HashMap	record	= new HashMap();
			
			key				= (String)keys.nextElement();
			value			= (String)hash.get(key);

			if(key.startsWith("des_"))
			{

			out.println("alert(\"key" + key + "\");") ;
			out.println("alert(\"val" + value + "\");") ;
			record1.put("const_generic_code",key);
			record1.put("const_weight",value);
			}



			if(!key.equals("bean_id") && !key.equals("bean_name") && !key.equals("mode") &&!key.endsWith("_unit") && !value.equals("") && !key.endsWith("_perc") && !key.endsWith("_vol")
			){

				record.put("const_generic_code",key);
				record.put("const_weight",value);
				if(hash.get(key+"_FL")!=null) {

					beanObj.setTotalVolume(value);
				}
				

				value = (String)hash.get(key+"_unit");

				record.put("const_weight_unit",value);


				if(hash.get(key+"_perc")!=null) {
					String const_perc	= (String)hash.get(key+"_perc");
					String const_vol	= (String)hash.get(key+"_vol");
					String const_uom	= (String)hash.get(key+"_actuom");//added for ml-mmoh-scf-1303

					record.put("const_perc", const_perc);
					record.put("const_vol", const_vol);
					record.put("const_uom", const_uom);//added for ml-mmoh-scf-1303

					total_volume	+=	Float.parseFloat(const_vol);

				}



				if(total_volume!=0)
					beanObj.setTotalVolume(total_volume+"");

				if(record.get("const_weight_unit")!=null || record.get("Percentage_cal")!=null)
				{
					constituents.add(record);
				}
			}

		}
		out.println("alert(\"" + constituents + "\");") ;


		beanObj.setConstituents(constituents);
		
		beanObj.setTotalEnergy(total_energy);
		beanObj.setLipidEmulsion(lipid_emulsion_type);
		beanObj.setNpcRatio(npc_ratio);
	}
	else if(func_mode!=null && func_mode.equals("OrderingDispensingRules_tab")) {


		HashMap ordering_dispensing	= new HashMap();

		String schedule_id			=	(hash.get("schedule_id")==null)?"":(String)hash.get("schedule_id");
		String prescribing_catg		=	(hash.get("prescribing_catg")==null)?"":(String)hash.get("prescribing_catg");
		String infuse_over			=	(hash.get("infuse_over")==null)?"":(String)hash.get("infuse_over");
		String infuse_over_list		=	(hash.get("infuse_over_list")==null)?"":(String)hash.get("infuse_over_list");
		String authorize_yn			=	(hash.get("authorize_yn")==null)?"":(String)hash.get("authorize_yn");
		String disp_via_pres		=	(hash.get("disp_via_pres")==null)?"":(String)hash.get("disp_via_pres");
		String disp_against_damage	=	(hash.get("disp_against_damage")==null)?"":(String)hash.get("disp_against_damage");
		String caution_label_1		=	(hash.get("caution_label_1")==null)?"":(String)hash.get("caution_label_1");
		String caution_label_2		=	(hash.get("caution_label_2")==null)?"":(String)hash.get("caution_label_2");
		String spl_instruction		=	(hash.get("spl_instruction")==null)?"":(String)hash.get("spl_instruction");
		String patient_direction	=	(hash.get("patient_direction")==null)?"":(String)hash.get("patient_direction");

		ordering_dispensing.put("schedule_id",schedule_id);
		ordering_dispensing.put("prescribing_catg",prescribing_catg);
		ordering_dispensing.put("infuse_over",infuse_over);
		ordering_dispensing.put("infuse_over_list",infuse_over_list);
		ordering_dispensing.put("authorize_yn",authorize_yn);
		ordering_dispensing.put("disp_via_pres",disp_via_pres);
		ordering_dispensing.put("disp_against_damage",disp_against_damage);
		ordering_dispensing.put("caution_label_1",caution_label_1);
		ordering_dispensing.put("caution_label_2",caution_label_2);
		ordering_dispensing.put("spl_instruction",spl_instruction);
		ordering_dispensing.put("patient_direction",patient_direction);

		beanObj.setOrdDispensing(ordering_dispensing);
	}
	else if(func_mode!=null && func_mode.equals("external_db")) {
		String external_drug = (hash.get("external_drug_id")==null)?"":(String)hash.get("external_drug_id");
		beanObj.setExternalDrug(external_drug);
	}
	else if(func_mode!=null && func_mode.equals("item_search")) {
		String base_unit = (String)hash.get("base_unit");
		String item_code = (String)hash.get("item_code");
		String item_desc = (String)hash.get("item_desc");
			
		if(beanObj.checkValidItem(base_unit,item_code))
			out.println("setItemCode('"+item_code+"','"+item_desc+"')");
		else
				out.println("invalidItemMessage();");
	}else if(func_mode!= null && func_mode.equals("tpn_regimen_code")){

		String tpn_regimen_code				= (String) hash.get( "tpn_regimen_code" );
		boolean result				= beanObj.validateRegimenCode(tpn_regimen_code);

		out.println("regimenCodeResult('"+result+"');");
	}
	putObjectInBean(bean_id,beanObj,request);

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
