package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.BatchSearchBean;
import eST.Common.*;
import eST.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __manufacturingreceiptsaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ManufacturingReceiptsAddModify.jsp", 1720156269147L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n<script language=\"javascript\" src=\"../../eST/js/ManufacturingReceipts.js\"></script>\n</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body >\n\t\t<form name=\'formListDetail\' id=\'formListDetail\'>\n\t\t\t<table border=\'1\' width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' align=center >\n \t\t\t<tr>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" nowrap  name=\"expiry_date_or_receipt_date_";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t\t\t\t\t\n\t\t\t\t\t<br><font class=\"DATAHIGHLIGHT\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font>\n\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" nowrap  name=\"batch_id_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t<!-- \t\t\t\t\t\n\t\t\t\t\t\t* @Name - Priya\n\t\t\t\t\t\t* @Date - 19/02/2010\n\t\t\t\t\t\t* @Inc# - IN019466\n\t\t\t\t\t\t* @Desc - To right align AVAIL_QTY.\t\t\t\t\n\t\t\t\t\t-->\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" nowrap style=\"TEXT-ALIGN:right\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" nowrap ><input type=\'text\'  name=\"item_qty_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"item_qty_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"  size=12 maxlength=11 class=\"NUMBER\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onKeyPress=\"allow_restrict_decimals1(this,event);\" onBlur=\"CheckQty(this,\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',available_qty_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =".value);\"></td>\n\t\t\t\t</tr>\n\t\t\t\t\t<input type=\"hidden\" name=\"available_qty_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"available_qty_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<input type=\"hidden\" name=\"item_qty_parent\" id=\"item_qty_parent\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t<input type=\"hidden\" name=\"total_checkboxes\" id=\"total_checkboxes\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t<input type=\"hidden\" name=\"index\" id=\"index\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t<input type=\'hidden\' name=\'preptype\' id=\'preptype\' >\n\t\t\t<input type=\'hidden\' name=\'prepmode\' id=\'prepmode\' >\n\t\t\t<input type=\"hidden\" name=\"expired_batch\" id=\"expired_batch\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t<input type=\"hidden\" name=\"ex_param_days\" id=\"ex_param_days\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t<input type=\"hidden\" name=\"allow_deci_yn\" id=\"allow_deci_yn\" \tvalue=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t        <input type=\"hidden\" name=\"no_deci\" id=\"no_deci\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t<input type=\"hidden\" name=\"dec_allowed_yn\" id=\"dec_allowed_yn\" value=\"Y\">\n\t\t\t<input type=\"hidden\" name=\"no_of_decimals\" id=\"no_of_decimals\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t<input type=\"hidden\" name=\"nod_expiry\" id=\"nod_expiry\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"> \n\t</form>\n\t<script language=\"JavaScript\">\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
		ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean) getBeanObject("ManufacturingReceiptsBean","eST.ManufacturingReceiptsBean",request);
		bean.setLanguageId(locale);
		int i	=0;
		String index=bean.checkForNull(request.getParameter("index"),"-1");
		//String doc_srl_no=bean.checkForNull(request.getParameter("doc_srl_no"),"-1");
		String function = bean.checkForNull(request.getParameter("function"));
		String item_code = bean.checkForNull(request.getParameter("item_code"));
		String store_code = bean.checkForNull(request.getParameter("store_code"));
		String item_qty = bean.checkForNull(request.getParameter("item_qty"));
	//	String function_id = bean.checkForNull(request.getParameter("function_id"));
		String expiry_yn = bean.checkForNull(request.getParameter("expiry_yn"));
	//	String stock_item_yn = bean.checkForNull(request.getParameter("stock_item_yn"));
		String short_desc = bean.checkForNull(request.getParameter("short_desc"));
		String mode = bean.checkForNull(request.getParameter("mode"));
	//	String addToList = request.getParameter("addToList");
		ArrayList alBatchRecords = new ArrayList();
		HashMap hmBatchRecord = null;
	
	//	String BatchKey = "";
		String className	=	"";
	//	String date_legend="Expiry Dt";
		String date_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels");
		String indicators="";
		String allow_deci_yn        =       "";
		int no_deci              =       0;
		allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN(item_code),"N");
            if(allow_deci_yn.equals("Y"))
			no_deci              =      bean.getNoOfDecimals();
			else
            no_deci   = 0;
	

		int EWDays = 0;
		int expired_batch = 0;
		int nod_expiry       = 0;
		try { 
			//out.println(function);

			EWDays = bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
			if(function.equals("modify"))	{
				ArrayList ALDtlData=bean.getExpDetailsList();
				int size = ALDtlData.size();
				for(int j=0;j<size;j++) {
					if(bean.getDoc_type_code().equals((String)(((HashMap)ALDtlData.get(j)).get("DOC_TYPE_CODE"))) &&  bean.getDoc_no().equals((String)(((HashMap)ALDtlData.get(j)).get("DOC_NO"))) && item_code.equals((String)(((HashMap)ALDtlData.get(j)).get("ITEM_CODE"))) ) {
						alBatchRecords.add(ALDtlData.get(j));
					}
				}
			}
			else if(function.equals("edit"))	{
				StUtilities bean1 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean1.setLanguageId(locale);
				HashMap hmParameters	=	new HashMap();
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",store_code);
				hmParameters.put("TRN_QTY",item_qty);
				HashMap hmReturn	=	bean1.getBatches(hmParameters);
				alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA");
				bean.setRefreshList(alBatchRecords);
				putObjectInBean("stUtilities",bean1,request);

			}
			else if(function.equals("default")){
      				//ArrayList alRecords1 =bean.getExpDetailsList();
					ArrayList alRecords=new ArrayList();
						 alRecords =bean.getExpDetailsList();
      			
				      			
				ArrayList al123Exptemp	=	new ArrayList();
				ArrayList al123	= null;
				HashMap  hashMap= null;
				for (int k=0;k<alRecords.size();k++){
			
					al123	=(ArrayList)	alRecords.get(k);
	
					for (int l=0;l<al123.size();l++){
							hashMap=(HashMap)al123.get(l);
						
							if(item_code.equals((String)(hashMap.get("ITEM_CODE"))) &&  
								store_code.equals((String)(hashMap.get("STORE_CODE")))) {
								al123Exptemp.add(al123.get(l));
							}
					}
				}
				alBatchRecords=al123Exptemp;

			}
			else
			{
				BatchSearchBean bean2 = (BatchSearchBean) getBeanObject("batchSearchBean","eST.BatchSearchBean",request );
				bean2.setLanguageId(locale);
				alBatchRecords = bean2.getSelectedList();
				bean.setRefreshList(alBatchRecords);
						if (alBatchRecords==null) {
							throw new Exception("No batch selected..");
						}
						if(alBatchRecords.size()==0)
		{
				ArrayList alRecords =bean.getExpDetailsList();

				ArrayList al123Exptemp	=	new ArrayList();
				ArrayList al123	= null;
				HashMap  hashMap= null;
				for (int k=0;k<alRecords.size();k++){
							al123	=(ArrayList)	alRecords.get(k);
							for (int l=0;l<al123.size();l++){
									hashMap=(HashMap)al123.get(l);
									if(item_code.equals((String)(hashMap.get("ITEM_CODE"))) &&  
										store_code.equals((String)(hashMap.get("STORE_CODE")))) {
										al123Exptemp.add(al123.get(l));
									}
							}
				}
				alBatchRecords=al123Exptemp;
			}
			putObjectInBean("batchSearchBean",bean2,request);

			}

			if(expiry_yn.equals("N")) {
				//date_legend="Receipt Dt";
				 date_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.receiptdate.label","common_labels");
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(date_legend));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		
				for(i=0;i<alBatchRecords.size();i++){

					hmBatchRecord=(HashMap)alBatchRecords.get(i);
					className	=	((i%2)==0)?"OAQRYODD":"OAQRYEVEN";

			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(className));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(DateUtils.convertDate((String)hmBatchRecord.get("EXPIRY_DATE"),"DMY","en",locale)));
            _bw.write(_wl_block14Bytes, _wl_block14);
//change made on 26/08 to include the nod to expire 
					indicators = "";
					if (((String)hmBatchRecord.get("EXPIRY_YN")).equals("Y") &&   Integer.parseInt((String)hmBatchRecord.get("NOD")) <= EWDays){
					      //Added by Rabbani #Inc no:29950 on 28/MAR/2013 Starts
					       if(Integer.parseInt((String)hmBatchRecord.get("NOD")) < nod_expiry){
						    nod_expiry = Integer.parseInt((String)hmBatchRecord.get("NOD"));
						   }
						expired_batch = expired_batch + 1;
						 if(Integer.parseInt((String)hmBatchRecord.get("NOD")) > 0){
							String exp_leg= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
							String days_leg= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
								indicators =	exp_leg+(String)hmBatchRecord.get("NOD")+days_leg ;
						}
						else{
							indicators = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
						}
					}
					
					if ( ((String)hmBatchRecord.get("BATCH_STATUS")) != null &&   ((String)hmBatchRecord.get("BATCH_STATUS")).equals("C") ) {
						indicators = indicators + " / "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Notified.label","st_labels");

						}
						//Added by Rabbani #Inc no:29950 on 01/MAR/2013 Starts
						if(nod_expiry == 0){
						  nod_expiry = Integer.parseInt((String)hmBatchRecord.get("NOD"));
						 }
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(indicators));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(className));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(hmBatchRecord.get("BATCH_ID")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(className));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(hmBatchRecord.get("TRADE_NAME")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(className));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(hmBatchRecord.get("BIN_DESC")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(className));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(hmBatchRecord.get("AVAIL_QTY")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(className));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean.checkForNull(bean.setNumber((String)hmBatchRecord.get("QTY"),no_deci))));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean.checkForNull((String)hmBatchRecord.get("QTY"))));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.setNumber((String)hmBatchRecord.get("AVAIL_QTY"),no_deci)));
            _bw.write(_wl_block30Bytes, _wl_block30);
	}
			
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(index));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(expired_batch));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(EWDays));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(allow_deci_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(no_deci));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nod_expiry));
            _bw.write(_wl_block42Bytes, _wl_block42);

		}
		catch (eST.Common.InsufficientBatchException insufficientBatchException) {
					out.println("<script>parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=APP-ST0040 Insufficient batch quantity for item: "+short_desc+"';parent.frames[0].location.href='../../eCommon/html/blank.html'</script>");
					insufficientBatchException.printStackTrace();
		}
		catch (Exception exception) {
			out.println(exception.getMessage());
			exception.printStackTrace();
		}

            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean("ManufacturingReceiptsBean",bean,request);

            _bw.write(_wl_block43Bytes, _wl_block43);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
