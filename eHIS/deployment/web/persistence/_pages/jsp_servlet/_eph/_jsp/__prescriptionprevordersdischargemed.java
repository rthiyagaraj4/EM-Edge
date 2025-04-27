package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __prescriptionprevordersdischargemed extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionPrevOrdersDischargeMed.jsp", 1741325725623L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t\t<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/Prescription_1.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PrescriptionTest.js\"></script>\n\t\t<!-- <script language=\"Javascript\" src=\"../../eCommon/js/messages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n\t</head>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t\t<form name=\"frmdischPrescriptionPrevOrdersResult\" id=\"frmdischPrescriptionPrevOrdersResult\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<div id=\"HTab\" name=\"HTab\" style=\"width:100%;display: inline; overflow:hidden\" align=\'left\'>\n\t\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"left\" name=\"resultTable\" id=\"resultTable\">\n\t\t\t\t\t\t<tr>  \n\t\t\t\t\t\t\t<th  nowrap width=\"3%\" >&nbsp;</th>\n\t\t\t\t\t\t\t<th  nowrap width=\"7%\"  colspan=\'2\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t\t\t\t<th nowrap width=\"40%\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t\t\t\t<th nowrap  width=\"50%\"  >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<div id=\"DataTab\"  name=\"DataTab\"  style=\"height:310px; width:100%; display: inline; overflow:auto;\" onScroll=\"scrollit();\">\n\t\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td  width=\"3%\" class=\"CURRTEXT\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td  nowrap width=\"4%\" class=\"CURRTEXT\" id=\"ord_";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"><input type=\"checkbox\" name=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onClick=\" checkLinesDisc(this);\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="></td><!--Added hdrcheckedval for IN048127  -->\n\t\t\t\t\t\t\t\t\t\t<td  nowrap width=\"3%\" class=\"CURRTEXT\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td  nowrap  style=\"font-size:10;font-weight:bold\" class=\"CURRTEXT\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =":&nbsp;&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"CURRTEXT\" nowrap style=\"font-size:10;font-weight:bold\"> ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t <tr>\n\t\t\t\t\t\t\t\t\t<td  width=\"3%\" >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td width=\"4%\" class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"  id=\'drug_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' nowrap><input type=\"checkbox\" name=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onClick=\"checkheaderdisc(this); return storeCheckeddisc(this); \" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="></td> <!--Added linecheckedval for IN048127  -->\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t<td width=\"3%\" visibility=\"visible\" id=\"image";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" class=\"CURRENTRX\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td width=\"40%\" style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" nowrap >\n\t\t\t\t\t\t\t\t\t<a href=\"javascript:showDisccancel(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'\',\'\',\'buttons\',\'N\');\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a>\n\t\t\t\t\t\t\t\t\t</td>  \n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \n\t\t\t\t\t\t\t\t\t<td width=\"3%\" visibility=\"visible\" id=\"image";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td width=\"40%\" style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" nowrap >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t<td width=\"50%\" style=\"font-size:10\" class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" nowrap>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t\t\t <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" name=\"patient_id\">\n\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" name=\"encounter_id\">\n\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" name=\"pat_class\">\n\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" name=\"ord_status\">\n\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" name=\"order_from\">\n\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" name=\"pract_id\">\n\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" name=\"order_id\">\n\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" name=\"order_to\">\n\t\t\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" name=\"rx_type\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"fromdisc\" id=\"fromdisc\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"overrideflag\" id=\"overrideflag\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</form>\n\t\t\t<script>\n\t\t\t\tfunction scrollit() {\n\t\t\t\t  eldata=document.getElementById(\"DataTab\");\n\t\t\t\t  elheader=document.getElementById(\"HTab\");\n\t\t\t\t  //x=eldata.scrollLeft;\n\t\t\t\t  elheader.scrollLeft=eldata.scrollLeft;\n\t\t\t\t} \n\t\t\t</script>\n\t\t</body>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n</html>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

 		request.setCharacterEncoding("UTF-8"); 
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			try{
				String pat_class	=	request.getParameter("pat_class");
				String ord_status	=	request.getParameter("ord_status");
				String order_from	=	request.getParameter("order_from");
				String order_to		=	request.getParameter("order_to");
				String pract_id		=	request.getParameter("pract_id");
				String fromdisc		=	request.getParameter("fromdisc")==null?"N":request.getParameter("fromdisc");
				String start_date		=request.getParameter("start_date");
				String end_date		=	request.getParameter("end_date");
				String order_id		=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
				String called_from 	= request.getParameter("called_from")==null?"":request.getParameter("called_from");
				String ord_date="";
				String pres_no		=	"";
				String rx_type		=	request.getParameter("rx_type")==null?"":request.getParameter("rx_type");
				String patient_id		=request.getParameter("pat_id");
				String encounter_id		=request.getParameter("enc_id");
				ArrayList reqChecks = new ArrayList();
				String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
				String bean_name	= "ePH.PrescriptionBean_1";
				boolean dupflag=false;
				String drug_db_duptherapy_flag="";
				String rx_legend=  com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NormalRx.label", "ph_labels");
				PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
				String ext_beanid = "@ExternalProductLinkBean";
				String ext_beanname = "ePH.ExternalProductLinkBean";
				HashMap drugDosageResult = null;
				ArrayList exProd				= new ArrayList();
				ArrayList drugDesc				= new ArrayList();
				String dup_drug_det			    = "";
				ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
				bean.setLanguageId(locale);
				String params = request.getQueryString();
				String overrideflag="N";
				/*if(!locale.equals("en")){//Commented for IN048127--start
					order_from = DateUtils.convertDate(order_from, "DMYHM",locale,"en");
					order_to = DateUtils.convertDate(order_to, "DMYHM",locale,"en");
				}*///Commented for IN048127--end
				ArrayList extdbdetails = bean.checkdup();
				reqChecks.add("N"); //Dosage Check  
				reqChecks.add(extdbdetails.get(0)); //Duplicate Check
				reqChecks.add("N"); //DrugInteraction
				reqChecks.add("N"); //Contra Indication
				reqChecks.add("N"); //AllergyCheck
				HashMap drugDBCheckResult = new HashMap(); 
				int recCount		=	0;
				String classValue	=	"";
				String ducheck = "";
				//String expected_date = bean.getExcpectedDate(patient_id); //Commented for ML-BRU-SCF-1349 [IN:049402]
				String defDates[] = bean.getExcpectedDate(patient_id); //Added for ML-BRU-SCF-1349 [IN:049402]
				String expected_date = defDates[0]; //Added for ML-BRU-SCF-1349 [IN:049402]
				if(!locale.equals("en")){//Added for IN048127--start
					expected_date = DateUtils.convertDate(expected_date, "DMYHM","en",locale);
				}//Added for IN048127--end
				String commondatefrom="";
				String commondateto="";
				String qty ="";
				if(start_date!=null && start_date.trim().length()>0){//Added for IN048127--start
					if(!locale.equals("en")){
						start_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
						end_date = DateUtils.convertDate(end_date, "DMYHM","en",locale);
					}
				}//Added for IN048127--end
				if(called_from!=null && called_from.trim().length()>0 && called_from.equalsIgnoreCase("dateschange")){
					commondatefrom = start_date;
					commondateto  =  end_date;
				}
				else{
					commondatefrom = defDates[1];//changed from expected_date to defDates[1] for ML-BRU-SCF-1349 [IN:049402]
					commondateto   = defDates[2]; //changed from expected_date to defDates[2] for ML-BRU-SCF-1349 [IN:049402]
					if(!locale.equals("en")){ //if block Added for ML-BRU-SCF-1349 [IN:049402]
						commondatefrom = DateUtils.convertDate(commondatefrom, "DMYHM","en",locale);
						commondateto = DateUtils.convertDate(commondateto, "DMYHM","en",locale);
					}
				}
				ArrayList dischargepres	= bean.getPreviewOrders(pat_class,pract_id,patient_id,ord_status,order_from,order_to,order_id,rx_type,commondatefrom,commondateto);
				bean.setCurrentSelectedDrugs(dischargepres);
				for(int p=0; p<dischargepres.size(); p+=21) {
					exProd.add((String)dischargepres.get(p+19));
					drugDesc.add((String)dischargepres.get(p+4));
				}
				for(int k=0; k<dischargepres.size(); k+=21) {
					ducheck = (String)dischargepres.get(k+20);
					if(ducheck.equals("Y"))
						break;
			   }

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
						ArrayList discorders =  bean.getdiscPrescriptions();//Added for IN048127--start
						String tempid="";
						ArrayList orddiscorders = new ArrayList();
						ArrayList orgcorders = new ArrayList();
						for(int i=0;i<discorders.size();i=i+2){
							tempid = (String)discorders.get(i);
							int tempindex = tempid.indexOf(",");
							String tempval = tempid.substring(0,tempindex);
							orddiscorders.add(tempval);
						}
						for(int i=1; i<dischargepres.size(); i+=21){
							String orgtempid = (String)dischargepres.get(i);
							orgcorders.add(orgtempid);
							
						}
						String linecheckedval = "";
						HashMap hm = new HashMap();
						HashMap hm1 = new HashMap();
						Set<String> uniqueSet1 = new HashSet<String>(orgcorders);
						for (String temp : uniqueSet1) {
							hm.put(temp,Collections.frequency(orgcorders, temp));
						}
						Set<String> uniqueSet2 = new HashSet<String>(orddiscorders);
						for (String temp1 : uniqueSet2) {
							hm1.put(temp1,Collections.frequency(orddiscorders, temp1));
						}
						String hdrcheckedval = "checked";//Added for IN048127--end
						for(int i=0, j=0; i<dischargepres.size(); j++,i+=21){
							if(hm1.containsKey((String)dischargepres.get(i+1))){//Added for IN048127--start
								int newcount = (Integer)hm1.get((String)dischargepres.get(i+1));
								int newcount1 = (Integer)hm.get((String)dischargepres.get(i+1));
								if(newcount==newcount1)
									hdrcheckedval = "checked";
								else
									hdrcheckedval = "";
							}
							else
								hdrcheckedval = "";//Added for IN048127--end
							
							if(recCount%2==0)
								classValue="QRYEVENSMALL";
							else
								classValue="QRYODDSMALL";
							if(discorders.contains(dischargepres.get(i+1)+","+dischargepres.get(i+2))){//Added for IN048127--start
								linecheckedval = "checked";
							}
							else{
								linecheckedval="";
							}//Added for IN048127--end
									
							ord_date = (String)dischargepres.get(i+17);
							qty = (String)dischargepres.get(i+5);
							qty = qty.trim();
							if((extdbdetails.get(0)).equals("Y")){//if condition added for ML-BRU-SCF-1561 [IN:053781]
								for(int q=0; q<dischargepres.size(); q+=21){
								drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, (String)dischargepres.get(q+19), patient_id, "", exProd ,drugDesc, null, "Y",commondatefrom,commondateto); 
								if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
									 dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
									   if(dup_drug_det!=null && !dup_drug_det.equals("")){
											drug_db_duptherapy_flag="Y";
											break;
										}
									}
								}
							}
							ducheck = (String)dischargepres.get(i+20);
							if(ducheck!=null && ducheck.equals("Y")|| (drug_db_duptherapy_flag!=null && drug_db_duptherapy_flag.equalsIgnoreCase("Y"))){
								overrideflag = "Y";
							}
							if(!(pres_no.equals((String)dischargepres.get(i+1)))) {
								pres_no	=	(String)dischargepres.get(i+1);	


            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)dischargepres.get(i+1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)dischargepres.get(i+1)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)dischargepres.get(i+1)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(hdrcheckedval ));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ord_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rx_legend));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dischargepres.get(i+16)==null?"&nbsp;":dischargepres.get(i+16)));
            _bw.write(_wl_block20Bytes, _wl_block20);

								}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((String)dischargepres.get(i+1)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dischargepres.get(i+1)+","+dischargepres.get(i+2)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dischargepres.get(i+3)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(linecheckedval ));
            _bw.write(_wl_block26Bytes, _wl_block26);

								if(ducheck!=null && ducheck.equals("Y")){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((String)dischargepres.get(i+18) ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(commondatefrom ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(commondateto ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(j));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dischargepres.get(i+4)));
            _bw.write(_wl_block33Bytes, _wl_block33);
   
								}
								else{ 

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(dischargepres.get(i+4)));
            _bw.write(_wl_block38Bytes, _wl_block38);

								}

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(qty+"&nbsp;"+dischargepres.get(i+6)+"&nbsp;-&nbsp;"+dischargepres.get(i+8)+"&nbsp;for&nbsp;"+dischargepres.get(i+9)+" "+dischargepres.get(i+11)));
            _bw.write(_wl_block41Bytes, _wl_block41);

							recCount++;
						}

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( pat_class ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( ord_status ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( order_from ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( pract_id ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf( order_id ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( order_to ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( rx_type ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( params ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(fromdisc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( overrideflag ));
            _bw.write(_wl_block56Bytes, _wl_block56);

	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block57Bytes, _wl_block57);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DosageDetail.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDateTime.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderedLocation.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
