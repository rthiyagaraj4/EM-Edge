package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eBL.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;
import java.text.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetails6 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetails6.jsp", 1738301384655L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\n</head>\n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<iframe SRC=\"../../eBL/jsp/AddModifyPatFinDetailsInsMain.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" frameborder=0 name=\'InsuranceFrame\' id=\'InsuranceFrame\' style=\'height:70vh;width:100vw\' noresize scrolling=\'auto\' onload=\'disable();\' ></iframe>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<iframe SRC=\"../../eBL/jsp/AddModifyPatFinDetails2.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style=\'height:70vh;width:100vw\' name=\'Frame61\' id=\'Frame61 frameborder=0 scrolling=\'no\' noresize></iframe>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<iframe SRC=\'../../eCommon/html/blank.html\' frameborder=0 name=\'Frame62\' id=\'Frame62\' scrolling=\'no\' style=\'height:30vh;width:100vw\' noresize></iframe>\n<!--\n\t\t\t<FRAME SRC=\"AddModifyPatFinDetails7.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" frameborder=0 name=\'Frame62\' scrolling=\'YES\' noresize>\n-->\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<iframe SRC=\'../../eCommon/html/blank.html\' frameborder=0 name=\'Frame62\' id=\'Frame62\' style=\'height:30vh;width:100vw\' scrolling=\'auto\' noresize></iframe>\n<!--\n\t\t\t<FRAME SRC=\"AddModifyPatFinDetails4.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" frameborder=0 name=\'Frame62\' scrolling=\'no\' noresize>\n-->\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<iframe SRC=\'../../eCommon/html/blank.html\' frameborder=0 name=\'Frame62\' id=\'Frame62\' style=\'height:30vh;width:100vw\' scrolling=\'auto\' noresize></iframe>\n  \n<input type=hidden name=\"boolean_security\" id=\"boolean_security\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\n</html>\n\n\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String frame_size = "" ;
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	ResultSet rs = null, rs1 = null,rs2 = null,rs3 = null;;
	String sql="";
	String patient_id = request.getParameter("patient_id");
	if(patient_id == null) patient_id = "";	
//	String gl_holder_name = "", gl_rel = "", doc_start_date= "";
	String strdfltbgyn= "";
	String srtencdfltbgyn="";
	String bl_future_admn_YN="";
	String strModuleId = "";
	String strFunctionId = "";
	String nd_settlement_ind ="";
	String nd_adm_rec_flag ="";
	String nd_credit_doc_yn = "";
	String fin_class_flag_YN="N",autoFinChk="N",class_code = "",class_blng_grp_id="";

	try
  	{
		String bean_id		= "PkgApprovalBean" ;
		String bean_name	= "eBL.PkgApprovalBean";
		PkgApprovalBean bean			= null;
		try
		{
			bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
		}
		catch(Exception e)
		{
			System.err.println("Error while assigning PkgApprovalBean values:"+e);
			e.printStackTrace();
		}

		String billing_group= "";
		String bmode = request.getParameter("billing_mode");
		if(bmode==null) bmode = "";
		String oper = request.getParameter("operation");
		if(oper==null) oper = "Insert";

		fin_class_flag_YN = request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		autoFinChk = request.getParameter("autoFinChk");
		if(autoFinChk == null) autoFinChk="N";

		class_code = request.getParameter("class_code");
		if(class_code == null) class_code="N";

		class_blng_grp_id = request.getParameter("class_blng_grp_id");
		if(class_blng_grp_id == null) class_blng_grp_id="N";

		String rtn_non_ins_cust_code="";
		String rtn_non_ins_slmt_type_code="";
		String rtn_inst_ref="";
		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
			bmode="Add";
			oper="Insert";
			bean.clearBean();
		}

		if((bmode.equals("Modify")) || (oper.equals("Update")))
		{
			HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			if(!(bl_data==null || bl_data.isEmpty()))
			{
			billing_group=((String)bl_data.get("blng_grp")).trim();
			rtn_inst_ref=((String)bl_data.get("inst_ref")).trim();
			rtn_non_ins_slmt_type_code=((String)bl_data.get("non_ins_slmt_type_code")).trim();
			rtn_non_ins_cust_code=((String)bl_data.get("non_ins_cust_code")).trim();
			}
		}
		else
		{
			billing_group= request.getParameter("billing_group");	
			if( billing_group == null) billing_group="";
		}

		if(autoFinChk.equals("Y"))
		{
			billing_group = class_blng_grp_id;
		}

		strdfltbgyn = request.getParameter("dfltbgyn");
		if ( strdfltbgyn == null) strdfltbgyn = "N";

		srtencdfltbgyn = request.getParameter("encdfltbgyn");
		if ( srtencdfltbgyn == null) srtencdfltbgyn = "N";
	
/* Commented for PE and the values are passed from the Main.JSP
		String sql0 = "select nvl(dflt_pat_bg_for_encntr_regn_yn,'N') bg,nvl(DFLT_LAST_ENCTR_FIN_DTLS_YN,'N') last_enc_bg from bl_mp_param ";
		pstmt = con.prepareStatement(sql0);
		rs2 = pstmt.executeQuery() ;
		if( rs2 != null ) 
		{
			while( rs2.next() )
			{  
				strdfltbgyn = rs2.getString("bg");
				srtencdfltbgyn=rs2.getString("last_enc_bg");
			}
		}
		if(rs2 != null) rs2.close();
		pstmt.close();		

		if ( strdfltbgyn == null || strdfltbgyn.equals("")) strdfltbgyn = "N";
		if ( srtencdfltbgyn == null || srtencdfltbgyn.equals("")) srtencdfltbgyn="N";
*/
		if(srtencdfltbgyn.equals("Y") && strdfltbgyn.equals("N"))
		{
			strdfltbgyn="Y";
		}
		
		if (billing_group == null || billing_group.equals("")) strdfltbgyn = "N";

		bl_future_admn_YN=request.getParameter("bl_future_admn_YN");
		if(bl_future_admn_YN==null) bl_future_admn_YN="N";
/* Commented for PE as the variables are not used anymore
		String sql1 = "select gl_holder_name, pat_reln_with_gl_holder, to_char(credit_doc_ref_start_date,'dd/mm/yyyy') doc_start_date from bl_patient_fin_dtls where patient_id = '"+patient_id+"'";

		pstmt = con.prepareStatement(sql1);
		rs1 = pstmt.executeQuery() ;
		if( rs1 != null ) 
		{
			while( rs1.next() )
			{  
				gl_holder_name = rs1.getString("gl_holder_name");
				gl_rel = rs1.getString("pat_reln_with_gl_holder");
				doc_start_date = rs1.getString("doc_start_date");
				
			}
		}
		if(rs1 != null) rs1.close();
		pstmt.close();		

		if ( gl_holder_name == null ) gl_holder_name = "";
		if ( gl_rel == null ) gl_rel = "";
		if ( doc_start_date == null ) doc_start_date = "";
*/
		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");

		strModuleId = request.getParameter("calling_module_id");

		strFunctionId = request.getParameter("calling_function_id");

		if (strRepositoryYN == null)
		{
			strRepositoryYN = "N";
		}
	
		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}
		if (strModuleId ==null)
		{
			strModuleId = "";		
		}	
		if (strFunctionId ==null)
		{
			strFunctionId = "";		
		}	

		nd_settlement_ind = request.getParameter("setlmt_ind");
		if(nd_settlement_ind == null) nd_settlement_ind = "";

		nd_adm_rec_flag = request.getParameter("adm_rec_flag");
		if(nd_adm_rec_flag == null) nd_adm_rec_flag = "";

		nd_credit_doc_yn = request.getParameter("credit_doc_ref_reqd_yn");
		if(nd_credit_doc_yn == null) nd_credit_doc_yn = "";

		String package_enabled_yn = request.getParameter("package_enabled_yn");
		if(package_enabled_yn==null || !package_enabled_yn.equals("Y")) package_enabled_yn="N";

/*		
		if((bmode.equals("Modify")) || (oper.equals("Update")))
		{
		sql="select settlement_ind, adm_rec_flag, credit_doc_ref_reqd_yn  from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}
		else
		{
			sql="select settlement_ind, adm_rec_flag, credit_doc_ref_reqd_yn  from bl_blng_grp where blng_grp_id = '"+billing_group+"' ";
		}

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				nd_settlement_ind = rs.getString("settlement_ind");
				nd_adm_rec_flag = rs.getString("adm_rec_flag");
				nd_credit_doc_yn = rs.getString("credit_doc_ref_reqd_yn");
			}
		}
		if(rs != null) rs.close();
		pstmt.close();
*/
		if (nd_settlement_ind.equals("X")  && nd_adm_rec_flag.equals("2"))
		{
			frame_size = "74%,26%";
		}
		else  if(nd_settlement_ind.equals("C") && nd_adm_rec_flag.equals("0")) 
		{
			if(nd_credit_doc_yn.equals("Y") && package_enabled_yn.equals("Y"))
				frame_size = "22%,78%";
			else if(nd_credit_doc_yn.equals("N") && package_enabled_yn.equals("Y"))
				frame_size = "15%,85%";
			else if(nd_credit_doc_yn.equals("Y") && package_enabled_yn.equals("N"))
				frame_size = "22%,78%";
			else
				frame_size = "11%,88%";
		}
		else
		{
			frame_size = "80%,20%";
		}

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String billing_mode = request.getParameter("billing_mode");
	if(billing_mode==null) billing_mode = "";
	String operation = request.getParameter("operation");
	if(operation==null) operation = "Insert";
	boolean boolSecurity = false;	
	boolean boolPatientFoundMP = false;

//	String cust_4 = request.getParameter("cust_4");
	String cust_4 = rtn_non_ins_cust_code;
//	String cash_set_type2 = request.getParameter("cash_set_type2");
	String cash_set_type2 = rtn_non_ins_slmt_type_code;
//	String cash_insmt_ref1 = request.getParameter("cash_insmt_ref1");
	String cash_insmt_ref1 = rtn_inst_ref;

	if(cust_4 == null) cust_4="";
	if(cash_set_type2 == null) cash_set_type2="";
	if(cash_insmt_ref1 == null) cash_insmt_ref1="";
	
/*	String ins_auth_flag = request.getParameter("ins_auth_flag");
	if(ins_auth_flag==null) ins_auth_flag = "N";
	String clinic_code = request.getParameter("clinic_code");
	if(clinic_code==null) clinic_code = "";
	String visit_type_code = request.getParameter("visit_type_code");
	
	if(visit_type_code==null) visit_type_code = "";
*/

	if(bl_future_admn_YN.equals("Y") && ((strModuleId.equals("IP") || strModuleId.equals("DC")) && strFunctionId.equals("ADMISSION")))
	{
		strdfltbgyn="Y";
	}
	
	if(strdfltbgyn.equals("N"))
	{
		operation="Insert";	
	}
   if ( (strdfltbgyn.equals("Y") && (!(strModuleId.equals("MP")))) ||strModuleId.equals("MP") || operation.equals("Insert"))
   {
		if (nd_settlement_ind.equals("X")  && nd_adm_rec_flag.equals("2"))
		{		

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else
		{

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
   }

   if((billing_mode.equals("Modify")) || (operation.equals("Update")))
   {

		if( ((!(cust_4.equals("")) || !(cash_set_type2.equals(""))) && autoFinChk.equals("N")) || autoFinChk.equals("Y") )
		{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
	
		}
		if(!(cash_insmt_ref1.equals("")))
		{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
	}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(boolSecurity));
            _bw.write(_wl_block19Bytes, _wl_block19);


}
	catch(Exception e)
	{

		out.println("Exception in main try"+e);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
	}

            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
