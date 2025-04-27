package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __maintaintreathdrvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MaintainTreatHdrValidation.jsp", 1738127806830L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="   \n\n\n\n";
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


private String checkForNull(String input){
	
	if(input == null || "null".equals(input)){
		input = "null";
	}
	return input;
}

private Hashtable parseXMLString1(String var1) {
      Hashtable var2 = new Hashtable();
      try {
		 Reader inputString = new StringReader(var1);
		 BufferedReader var3 = new BufferedReader(inputString);
         // BufferedReader var3 = var1.getReader();
         SAXBuilder var4 = new SAXBuilder();
         Document var5 = var4.build(var3);
         Element var6 = var5.getRootElement();
         ListIterator var7 = var6.getChildren().listIterator();

         while(var7.hasNext()) {
            Element var8 = (Element)var7.next();
            Hashtable var9 = new Hashtable();
            List var10 = var8.getAttributes();
            Iterator var11 = var10.iterator();
            while(var11.hasNext()) {
               Attribute var12 = (Attribute)var11.next();
               String var13 = var12.getValue().replace('"', '\n');
               var9.put(var12.getName(), var13);
            }
            var2.put(var8.getName(), var9);
         }
      } catch (Exception var14) {
		  System.err.println("error in parseXMLSStirng 1  "+var14.toString());
         var2.put("error", var14.toString());
      }
      return var2;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);


Connection con = null;
try 
	{
		con = ConnectionManager.getConnection(request);
		System.err.println("MaintainTreatHdrValidation.jsp...........................................................");
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String xmlValues=checkForNull(request.getParameter("xmlStr"));
		System.err.println("Inside MaintainTreatValidation::::xmlValues  "+xmlValues);
		Hashtable hash				= (Hashtable)parseXMLString1( xmlValues ) ;
		System.err.println(" hash .... Inside MaintainTreathdrValidation:::: "+hash);
		hash = (Hashtable) hash.get("SEARCH");
		System.err.println(" hash .... Inside MaintainTreathdrValidation2:::: "+hash);
		
		
		String encounterhdrCombinationString="";
		
		ArrayList<String> pkghdrDetailsCombination = new ArrayList<String>();

		HashMap<String,ArrayList<String>>  pkghdrDetailsEncounters=new HashMap<String,ArrayList<String>>();
		
		String patientId=(String)hash.get("patid");
		/*
		String visit_id=(String)hash.get("visit_id");
		String episode_id=(String)hash.get("episode_id");
		String episode_type=(String)hash.get("episode_type");
		*/
		System.err.println("patientId............"+patientId);
		
		int totalRecords=Integer.parseInt((String)hash.get("totcount"));
	
		System.err.println("totalRecords..hdr.........."+totalRecords);
		
		for (int i = 1; i<=totalRecords; i++) 
		{
			 	 
			String package_code=(String) hash.get("package_code"+i);
			System.err.println("package_code "+package_code);

			if(package_code.equals("") || package_code.equals("null") || package_code == null)
			{
				package_code="null";
			}
			System.err.println("package_code............"+package_code);

			String package_seq_no=(String) hash.get("package_seq_no"+i);
			if(package_seq_no.equals("") || package_seq_no.equals("null") || package_seq_no == null)
			{
				package_seq_no="null";
			}
			System.err.println("package_seq_no............"+package_seq_no);

			String eff_from_date=(String) hash.get("eff_from_date"+i);
			if(eff_from_date.equals("") || eff_from_date.equals("null")|| eff_from_date == null)
			{
				eff_from_date="null";
			}
			
			String db_eff_from_date=(String) hash.get("db_eff_from_date"+i);
			if(db_eff_from_date.equals("") || db_eff_from_date.equals("null")|| db_eff_from_date == null)
			{
				db_eff_from_date="null";
			}

			String cust_group_code=(String) hash.get("cust_group_code"+i);
			//hdn_order_catalog_code=checkForNull(hdn_order_catalog_code);
			System.err.println("cust_group_code............"+cust_group_code);
			if(cust_group_code.equals("")|| cust_group_code.equals("null") || cust_group_code == null)
			{
				cust_group_code="null";
			}
			System.err.println("cust_group_code........125...."+cust_group_code);

			String cust_code=(String) hash.get("cust_code"+i);
			// hdn_factor_rate_ind=checkForNull(hdn_factor_rate_ind);
			if(cust_code.equals("") || cust_code.equals("null") || cust_code == null)
			{
				cust_code="null";
			}
			System.err.println("cust_code........125...."+cust_code);
			
			String deposit_amt=(String) hash.get("deposit_amt"+i);
			System.err.println("deposit_amt........125...."+deposit_amt);
			//	hdn_factor_rate=checkForNull(hdn_factor_rate);
			if(deposit_amt.equals("") ||deposit_amt.equals("null") || deposit_amt == null  )
			{
				deposit_amt="null";
			}
			System.err.println("deposit_amt........125...."+deposit_amt);

			String prac_code=(String) hash.get("prac_code"+i);
			//		hdn_qty_limit=checkForNull(hdn_qty_limit);
			System.err.println("prac_code 106 "+prac_code);
			if(prac_code.equals("") || prac_code.equals("null") || prac_code == null )
			{
				prac_code="null";
			}
			System.err.println("prac_code........125...."+prac_code);
			
			String userid=(String) hash.get("userid");
			//		hdn_amt_limit_ind=checkForNull(hdn_amt_limit_ind);
			if(userid.equals("")|| userid.equals("null") || userid == null)
			{
				userid="null";
			} 
			System.err.println("userid........125...."+userid);
			
			String ws_no=(String) hash.get("ws_no");
			//		ws_no=checkForNull(ws_no);
			if(ws_no.equals("") || ws_no.equals("null") || ws_no == null )
			{
				ws_no="null";
			}
			System.err.println("ws_no........125...."+ws_no);
			
			String visit_id=(String)hash.get("visit_id"+i);
			System.err.println("visit_id "+visit_id);
			if(visit_id.equals("") || visit_id.equals("null") || visit_id == null)
			{
				System.err.println("visit_id "+visit_id);
				visit_id="null";
			}
			
			String episode_id=(String)hash.get("episode_id"+i);
			if(episode_id.equals("") || episode_id.equals("null") || episode_id == null)
			{
				System.err.println("episode_id "+episode_id);
				episode_id="null";
			}
			
			String episode_type=(String)hash.get("episode_type"+i);
			if(episode_type.equals("") || episode_type.equals("null") || episode_type == null)
			{
				episode_type="null";
			}
			System.err.println("episode_type "+episode_type);

			String isAdhocDiscountMod = (String)hash.get("isAdhocDiscountMod_"+i);
			if(isAdhocDiscountMod.equals("") || isAdhocDiscountMod.equals("null") || isAdhocDiscountMod == null)
			{
				isAdhocDiscountMod="N";
			}
			System.err.println("isAdhocDiscountMod "+isAdhocDiscountMod);

			String adhocDiscString = (String)hash.get("delimAdhocDiscStr_"+i);
			if(adhocDiscString.equals("") || adhocDiscString.equals("null") || adhocDiscString == null)
			{
				adhocDiscString="null";
			}
			System.err.println("adhocDiscString "+adhocDiscString);

			String isPackageCancelYN = (String)hash.get("hid_cancel_pkg_YN_"+i);
			if(isPackageCancelYN.equals("") || isPackageCancelYN.equals("null") || isPackageCancelYN == null)
			{
				isPackageCancelYN="null";
			}
			System.err.println("isPackageCancelYN "+isPackageCancelYN);

			String cancelPkgReasonCode = (String)hash.get("cancel_code"+i);
			if(cancelPkgReasonCode.equals("") || cancelPkgReasonCode.equals("null") || cancelPkgReasonCode == null)
			{
				cancelPkgReasonCode="null";
			}
			System.err.println("cancelPkgReasonCode "+cancelPkgReasonCode);	
			
			String isEncounterAssYN = (String)hash.get("hid_enc_checkbox_dtl"+i);
			if(isEncounterAssYN.equals("") || isEncounterAssYN.equals("null") || isEncounterAssYN == null)
			{
				isEncounterAssYN="N";
			}
			System.err.println("isEncounterAssYN "+isEncounterAssYN);

			String encAssString = (String)hash.get("encAssString_"+i);
			if(encAssString.equals("") || encAssString.equals("null") || encAssString == null)
			{
				encAssString="null";
			}
			System.err.println("encAssString "+encAssString);
			
			String isEncounterDeAssYN = (String)hash.get("hid_enc_deass_chkb_"+i);
			if(isEncounterDeAssYN.equals("") || isEncounterDeAssYN.equals("null") || isEncounterDeAssYN == null)
			{
				isEncounterDeAssYN="N";
			}
			System.err.println("isEncounterDeAssYN "+isEncounterDeAssYN);	
			
			String isCancelUnProcessOrdersYN = (String)hash.get("hid_cncl_unprocess_ord_"+i);
			if(isCancelUnProcessOrdersYN.equals("") || isCancelUnProcessOrdersYN.equals("null") || isCancelUnProcessOrdersYN == null)
			{
				isCancelUnProcessOrdersYN="N";
			}
			System.err.println("isCancelUnProcessOrdersYN "+isCancelUnProcessOrdersYN);	

			String effDateAuthStr = (String)hash.get("effDateAuthStr");
			if(effDateAuthStr.equals("") || effDateAuthStr.equals("null") || effDateAuthStr == null)
			{
				effDateAuthStr="null";
			}
			System.err.println("effDateAuthStr "+effDateAuthStr);

			String adhocDiscAuthStr = (String)hash.get("adhocDiscAuthStr");
			if(adhocDiscAuthStr.equals("") || adhocDiscAuthStr.equals("null") || adhocDiscAuthStr == null)
			{
				adhocDiscAuthStr="null";
			}
			System.err.println("adhocDiscAuthStr "+adhocDiscAuthStr);

			String cnclPackAuthStr = (String)hash.get("cnclPackAuthStr");
			if(cnclPackAuthStr.equals("") || cnclPackAuthStr.equals("null") || cnclPackAuthStr == null)
			{
				cnclPackAuthStr="null";
			}
			System.err.println("cnclPackAuthStr "+cnclPackAuthStr);

			String assDeassAuthStr = (String)hash.get("assDeassAuthStr");
			if(assDeassAuthStr.equals("") || assDeassAuthStr.equals("null") || assDeassAuthStr == null)
			{
				assDeassAuthStr="null";
			}
			System.err.println("assDeassAuthStr "+assDeassAuthStr);

			String pkgServDtlsAuthStr = (String)hash.get("pkgServDtlsAuthStr");
			if(pkgServDtlsAuthStr.equals("") || pkgServDtlsAuthStr.equals("null") || pkgServDtlsAuthStr == null)
			{
				pkgServDtlsAuthStr="null";
			}
			System.err.println("pkgServDtlsAuthStr "+pkgServDtlsAuthStr);			
		
			encounterhdrCombinationString=package_code+"|"+
				package_seq_no+"|"+
				eff_from_date+"|"+
				cust_group_code+"|"+
				cust_code+"|"+
				deposit_amt+"|"+
				prac_code+"|"+
				userid+"|"+
				ws_no+"|"+
				visit_id+"|"+
				episode_id+"|"+
				episode_type + "|" +
				isAdhocDiscountMod + "|" +
				adhocDiscString + "|" +
				isPackageCancelYN + "|" +
				cancelPkgReasonCode + "|" +
				isEncounterAssYN  + "|" +
				encAssString + "|" +
				isEncounterDeAssYN + "|" +
				isCancelUnProcessOrdersYN + "|" +
				effDateAuthStr + "|" +
				adhocDiscAuthStr + "|" +
				cnclPackAuthStr + "|" +
				assDeassAuthStr + "|" +
				pkgServDtlsAuthStr + "|" +
				db_eff_from_date;
					
				System.err.println("encounterhdrCombinationString"+encounterhdrCombinationString);
				
				pkghdrDetailsCombination.add(encounterhdrCombinationString);
				
				System.err.println("pkghdrDetailsCombination : : "+pkghdrDetailsCombination);			
		}
		pkghdrDetailsEncounters.put(patientId,pkghdrDetailsCombination);

		session.setAttribute("PKGHDRDETAILSENCOUNTERS", pkghdrDetailsEncounters);
		//	session.setAttribute("dbcount",count);

		System.err.println("pkghdrDetailsEncounters"+pkghdrDetailsEncounters);
	}
	catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception from maintaintreathdrValidation.jsp :"+ e);
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
