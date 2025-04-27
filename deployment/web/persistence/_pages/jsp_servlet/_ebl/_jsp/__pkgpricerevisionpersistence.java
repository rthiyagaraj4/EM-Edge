package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.pkgpricerevision.bc.PkgPriceDisountBC;
import eBL.pkgpricerevision.request.PackagePriceBean;
import eBL.pkgpricerevision.request.BulkUpdateBean;
import eBL.pkgpricerevision.request.PkgPriceRevisionRequest;
import java.sql.*;
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

public final class __pkgpricerevisionpersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgPriceRevisionPersistence.jsp", 1709114138005L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n";
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


	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String params = request.getQueryString();
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "PkgPriceRevisionRequest" ;
	String beanName = "eBL.pkgpricerevision.request.PkgPriceRevisionRequest";
	PkgPriceRevisionRequest pkgPriceDiscount = null;
	


	try 
	{
		pkgPriceDiscount = (PkgPriceRevisionRequest) getObjectFromBean(beanId, beanName, session);
		if(pkgPriceDiscount.getBulkUpdateDiscount() == null){
			pkgPriceDiscount.setBulkUpdateDiscount(new ArrayList<BulkUpdateBean>());
		}
		
		if(pkgPriceDiscount.getBulkUpdatePrice() == null){
			pkgPriceDiscount.setBulkUpdatePrice(new ArrayList<BulkUpdateBean>());
		}
		
		if(pkgPriceDiscount.getPriceRevision() == null){
			pkgPriceDiscount.setPriceRevision(new ArrayList<PackagePriceBean>());
		}
		
		if(pkgPriceDiscount.getDiscountRevision() == null){
			pkgPriceDiscount.setDiscountRevision(new ArrayList<PackagePriceBean>());
		}
		
		List<BulkUpdateBean> bulkUpdatePrice = pkgPriceDiscount.getBulkUpdatePrice();
		List<BulkUpdateBean> bulkUpdateDiscount = pkgPriceDiscount.getBulkUpdateDiscount();
		List<PackagePriceBean> priceRevision = pkgPriceDiscount.getPriceRevision();
		List<PackagePriceBean> discountRevision = pkgPriceDiscount.getDiscountRevision();
		
		String facility_id = (String)session.getAttribute("facility_id");
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	    PackagePriceBean priceBean = null;
	    BulkUpdateBean bulkUpd = null;
	    
		if(func_mode!= null && "priceRevision".equals(func_mode)){	
			String chkPkgCode = "";
			priceRevision = new ArrayList<PackagePriceBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("lastRowIndex"));
			for(int i=0;i<=lastRowIndex;i++){
				chkPkgCode = (String)hash.get("pkgCode"+i);
				if(chkPkgCode != null && !"".equals(chkPkgCode)){
					priceBean = new PackagePriceBean();
					priceBean.setPkgCode((String)hash.get("pkgCode"+i));
					priceBean.setPkgDesc((String)hash.get("pkgDesc"+i));
					priceBean.setCustGroupCode((String)hash.get("custGrp"+i));
					priceBean.setCustCode((String)hash.get("cust"+i));
					priceBean.setBlngClassCode((String)hash.get("blngClass"+i));
					priceBean.setCurrentPriceValue((String)hash.get("currentPrice"+i));
					priceBean.setCurrentPriceType((String)hash.get("currentType"+i));
					priceBean.setRevisedPriceValue((String)hash.get("revisedPrice"+i));
					priceBean.setRevisedPriceType((String)hash.get("revisedType"+i));
					priceBean.setEffectiveFrom((String)hash.get("effFrom"+i));
					priceBean.setEffectiveTo((String)hash.get("effTo"+i));
					priceBean.setStatus((String)hash.get("status"+i));
					priceBean.setPackagePrice((String)hash.get("pkgPrice"+i)); //added against mms-dm-crf-118.9 starts
					priceBean.setVAT((String)hash.get("VAT"+i));
					priceBean.setVatApplicable((String)hash.get("VATapp"+i));
					priceBean.setVatRule((String)hash.get("VATpercent"+i));
					priceBean.setRuleCoverage((String)hash.get("RuleCoverage"+i));//added against mms-dm-crf-118.9 ends	
					priceRevision.add(priceBean);
				}
			}
			pkgPriceDiscount.setPriceRevision(priceRevision);
		}
		else if(func_mode!= null && "discountRevision".equals(func_mode)){			
			String chkPkgCode = "";
			discountRevision = new ArrayList<PackagePriceBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("lastRowIndex"));
			for(int i=1; i<=lastRowIndex; i++ ){
				chkPkgCode = (String)hash.get("pkgCode"+i);
				if(chkPkgCode != null && !"".equals(chkPkgCode)){
					priceBean = new PackagePriceBean();
					priceBean.setPkgCode((String)hash.get("pkgCode"+i));
					priceBean.setPkgDesc((String)hash.get("pkgDesc"+i));
					priceBean.setBlngGroupCode((String)hash.get("blngGroup"+i));
					priceBean.setBlngClassCode((String)hash.get("blngClass"+i));
					priceBean.setCustGroupCode((String)hash.get("custGrp"+i));
					priceBean.setCustCode((String)hash.get("cust"+i));
					
					priceBean.setCurrentPriceValue((String)hash.get("currentValue"+i));
					priceBean.setCurrentPriceType((String)hash.get("currentType"+i));
					priceBean.setRevisedPriceValue((String)hash.get("revisedValue"+i));
					priceBean.setRevisedPriceType((String)hash.get("revisedType"+i));
					priceBean.setEffectiveFrom((String)hash.get("effFrom"+i));
					priceBean.setEffectiveTo((String)hash.get("effTo"+i));
					priceBean.setStatus((String)hash.get("status"+i));
					discountRevision.add(priceBean);
				}
			}
			pkgPriceDiscount.setDiscountRevision(discountRevision);
		}
		else if(func_mode!= null && "priceBulk".equals(func_mode)){		
			String pkgPriceType = "";
			bulkUpdatePrice = new ArrayList<BulkUpdateBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("lastRowIndex"));
			for(int i=1; i<=lastRowIndex; i++ ){
				pkgPriceType = (String)hash.get("pkgPriceType"+i);
				//if(pkgPriceType != null && !"".equals(pkgPriceType)){ commented against mms-dm-crf-118.9
					bulkUpd = new BulkUpdateBean();
					bulkUpd.setPkgPriceDiscType((String)hash.get("pkgPriceType"+i));
					bulkUpd.setPkgPriceDiscValue((String)hash.get("pkgPriceOrAmt"+i));
					bulkUpd.setMarkUpDown((String)hash.get("priceMarkUpDown"+i));
					bulkUpd.setRoundOff((String)hash.get("priceRoundOff"+i));
					bulkUpd.setRndMarkUpDown((String)hash.get("priceRndMarkUpDown"+i));
					bulkUpd.setEffectiveFrom((String)hash.get("effFrom"+i));	
					bulkUpd.setEffectiveTo((String)hash.get("effTo"+i));
					bulkUpd.setPackagePrice((String)hash.get("pkgPrice"+i)); //added against mms-dm-crf-118.9 starts
					bulkUpd.setVAT((String)hash.get("VAT"+i));
					bulkUpd.setVatApplicable((String)hash.get("VATapp"+i));
					bulkUpd.setVatRule((String)hash.get("VATpercent"+i));
					bulkUpd.setRuleCoverage((String)hash.get("RuleCoverage"+i));//added against mms-dm-crf-118.9 ends					
					bulkUpdatePrice.add(bulkUpd);
				//}
				
			}
			//pkgPriceDiscount.setPriceBulkUpdateFlag((String)hash.get("packageRate"));
			pkgPriceDiscount.setBulkUpdatePrice(bulkUpdatePrice);
		}
		else if(func_mode!= null && "discountBulk".equals(func_mode)){		
			String pkgPriceType = "";
			bulkUpdateDiscount = new ArrayList<BulkUpdateBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("lastRowIndex"));
			for(int i=1; i<=lastRowIndex; i++ ){
				pkgPriceType = (String)hash.get("pkgDiscType"+i);
				if(pkgPriceType != null && !"".equals(pkgPriceType)){
					bulkUpd = new BulkUpdateBean();
					bulkUpd.setPkgPriceDiscType((String)hash.get("pkgDiscType"+i));
					bulkUpd.setPkgPriceDiscValue((String)hash.get("discPriceOrAmt"+i));
					bulkUpd.setMarkUpDown((String)hash.get("discMarkUpDown"+i));
					bulkUpd.setRoundOff((String)hash.get("discRoundOff"+i));
					bulkUpd.setRndMarkUpDown((String)hash.get("discRndMarkUpDown"+i));
					bulkUpd.setEffectiveFrom((String)hash.get("effFrom"+i));
					bulkUpd.setEffectiveTo((String)hash.get("effTo"+i));	
					bulkUpdateDiscount.add(bulkUpd);
				}
				
			}
			//pkgPriceDiscount.setDiscountBulkUpdateFlag((String)hash.get("discountRate"));
			pkgPriceDiscount.setBulkUpdateDiscount(bulkUpdateDiscount);
		}
		else if(func_mode!= null && "persistHeader".equals(func_mode)){		
			String priceType = (String)hash.get("priceType");
			String updateType = (String)hash.get("updateType");
			String pkgCode = (String)hash.get("pkgCode");
			String blngClassCode = (String)hash.get("blngClassCode");
			String custGrpCode = (String)hash.get("custGrpCode");
			String custCode = (String)hash.get("custCode");
			String blngGrpCode = (String)hash.get("blngGrpCode");			
			String policyCode = (String)hash.get("policyCode"); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
			
			if("C".equals(priceType)){
				if("".equals(custGrpCode)){
					custGrpCode = "**";
				}
				if("".equals(custCode)){
					custCode = "**";
				}
			}
			else if("S".equals(priceType)){
				custGrpCode = "";
				custCode = "";
			}
			if("".equals(blngClassCode)){
				blngClassCode = "ALL";
			}
			if("".equals(blngGrpCode)){
				blngGrpCode = "ALL";
			}
			//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 start
			if("".equals(policyCode)){
				policyCode = "ALL";
			}
			//MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020 end
			pkgPriceDiscount.setPriceType(priceType);
			pkgPriceDiscount.setUpdateType(updateType);
			pkgPriceDiscount.setCustGroupCode(custGrpCode);
			pkgPriceDiscount.setCustCode(custCode);
			pkgPriceDiscount.setPkgCode(pkgCode);
			pkgPriceDiscount.setBlngClassCode(blngClassCode);
			pkgPriceDiscount.setBlngGroupCode(blngGrpCode);
			pkgPriceDiscount.setPolicyCode(policyCode); //MMS-QH-CRF-0128.1 SHIKHA 29-Aug-2020
		}
		else if(func_mode!= null && "getPriceDiscMod".equals(func_mode)){
			String pageId = request.getParameter("pageId");
			String retVar = "";
			if("Bulk".equals(pageId)){
				if(bulkUpdatePrice.size()>0){
					retVar = "Y";
				}else{
					retVar = "N";
				}
				
				if(bulkUpdateDiscount.size()>0){
					retVar += ":::Y";
				}
				else{
					retVar += ":::N";
				}
				
			}
			else{
				if(priceRevision.size()>0){
					retVar = "Y";
				}else{
					retVar = "N";
				}
				
				if(discountRevision.size()>0){
					retVar += ":::Y";
				}
				else{
					retVar += ":::N";
				}
			}
			
			out.println(retVar);
		 }
		else if(func_mode!= null && "getPkgEffDates".equals(func_mode)){
			String pkgCode = request.getParameter("pkgCode");
			PkgPriceDisountBC priceDiscBC = new PkgPriceDisountBC();
			System.err.println("getPriceDiscMod"+pkgCode+","+facility_id);
			String retVal = priceDiscBC.getPkgEffectiveDates(pkgCode, facility_id);
			out.println(retVal);
		}
		
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from Pkg Price Revision :" + e);
	}
	finally
	{
		
	}

	putObjectInBean(beanId,pkgPriceDiscount,request);


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
