package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __medicationadministrationchart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationAdministrationChart.jsp", 1709120935595L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../ePH/js/MedicationAdministration.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\n\t</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<form name=\"MedicationAdministrationChartForm\" id=\"MedicationAdministrationChartForm\" >\n<br>\n<table cellpadding=\"0\" cellspacing=\"0\"  border=\"0\"  width=\"100%\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t \n<tr>\n\t<th  colspan=\"18\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n</tr>\n</table>\n<table cellpadding=\"0\" cellspacing=\"0\"  border=\"2%\"   id=\"drugTable\" name=\"drugTable\" id=\"drugTable\" width=\"100%\">\n<th class=\"HEADERTITLE\"  width=\"2\">&nbsp;</th>\n<th  class=\"HEADERTITLE\" width=\"300\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n<th  class=\"HEADERTITLE\" width=\"2\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\t\t\n\t ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<th  class=\"HEADERTITLE\" colspan=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t<tr><td class=\'TIMING\'>&nbsp;</td>\n\t\t<td class=\'TIMING\'width=\"300\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td class=\'TIMING\'  width=\"2\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<td class=\'TIMING\'><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></td>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t </tr>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<tr><td width=\"100%\" style=\" background-color:#515151;color=white;\" colspan=\"20\"><b";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</b></td></tr>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<tr><td width=\"100%\" style=\" background-color:#515151;color=white;\"  colspan=\"20\"><b";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n<tr>\n<td style=\"background-color=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" width=\'2%\'>&nbsp;&nbsp;&nbsp;</td>\t\t\t\t\t\t\t    \n<td   style=\" background-color:";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" ><font size=\'1\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font></td> \n\t\n\t\t\t\t\t\t\t     ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" \n<td   style=\" background-color:white\" ><font size=\'1\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font></td>\n                                  \n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<td  id =\"qid\"  style=\" background-color:white;\"><font  size=\'1\'>&nbsp</td>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<td  id =\"qid\"  style=\" background-color:white;\"><font  size=\'1\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td> \n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" \n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<td   style=\"background-color:white;color:blue;cursor:pointer;border-right:15px solid green;color:blue\" onclick=\"setframe(";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =");callAdminDetails(this,\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\')\" ><font size=\'1\' >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</font></td>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t<td    style=\"background-color:white;color:blue;cursor:pointer;border-right:15px solid black;color:blue\" onclick=\"setframe(";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</font></td>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n<td  style=\"background-color:white;color:blue;cursor:pointer;border-right:15px solid #CE00CE;color:blue\" onclick=\"setframe(";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\')\"><font  size=\'1\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="<td style=\"background-color:white;color:blue;cursor:pointer;border-right:15px solid #804040;color:blue\" onclick=\"setframe(";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</font></td> \n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<td style=\"background-color:white;color:blue;cursor:pointer;\" onclick=\"setframe(";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</font></td> \n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n<td  id =\"qid\" style=\" background-color:white;\"><font  size=\'1\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td> \n         ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t </tr> \n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n</TABLE>\n\n</SPAN>\n<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' name=\'encounter_id\'>\n<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" name=\"patient_id\">  \n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );
	
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
		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 try{
	String administration_status= request.getParameter("administration_status");
	String admin_from_date	    = request.getParameter("admin_from_date");
	String admin_to_date	    = request.getParameter("admin_to_date");
	String from_time			= request.getParameter("from_time");
	String to_time			    = request.getParameter("to_time");
	String mode					= request.getParameter("mode");
    String patient_id			= request.getParameter("patient_id");
	String encounter_id         = request.getParameter("encounter_id");
	String bean_id				= "MedicationAdministrationBean";
	String bean_name			= "ePH.MedicationAdministrationBean";
	MedicationAdministrationBean bean			= (MedicationAdministrationBean)getBeanObject( bean_id, bean_name , request);
	bean.setLanguageId(locale);

	String ft_bean_id			= "MedicationAdministrationFTBean";
	String ft_bean_name			= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean ft_bean	= (MedicationAdministrationFTBean)getBeanObject( ft_bean_id, ft_bean_name, request );	
	ft_bean.setLanguageId(locale);


            _bw.write(_wl_block8Bytes, _wl_block8);
	
	ArrayList al=new ArrayList();
	ArrayList al_times=new ArrayList();
	ArrayList al_drug_desc=new ArrayList();
	ArrayList al_qty=new ArrayList();
	HashMap drug_desc_qty_hm=new HashMap();
	String o_date="";									String drug_desc="";
	String drug_strength="";						    String te_qty="";
	String drug_code="";								String order_id="";
	String admin_recorded_yn="";						//String admin_recorded_date_time="";
	String administered_yn="";							//String admin_date_time="";
	//String admin_due_flag="n";						
	String iv_prep_yn="";
	HashMap hm_qty=null;								String drug_class="";
	String drug_class_ind="";							String order_line_num="";
	int srl_no=1;										String time="";
	String order_line_num1="";							String classvalue="";
	String freq_nature="";								String order_id1="";
	String order_line_status="";						int count=0;
	int t=0;											int c1=0;
	int c2=0;											int tep=0;
	int n=0;
				
		al=(ArrayList)bean.getRecord(encounter_id,from_time, to_time);
				for(int i=0;i<al.size();i++) { 
					HashMap record1=new HashMap();
				    record1=(HashMap)al.get(i);
					o_date=(String)record1.get("dates");
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(o_date));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
  count+=3;
		 al_times=(ArrayList)record1.get("times");
		 t=al_times.size();
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(t));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			c1=0;
		    c2=0;
			  for(int p=0;p<al_times.size();p++){ 
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(al_times.get(p) ));
            _bw.write(_wl_block18Bytes, _wl_block18);

			       } 
		
            _bw.write(_wl_block19Bytes, _wl_block19);
 
			 al_drug_desc=(ArrayList)record1.get("desc_qty");
			 tep=al_drug_desc.size();
							     for(int x=0;x<al_drug_desc.size();x++){
								 drug_desc_qty_hm=(HashMap)al_drug_desc.get(x);
								 drug_code=(String)drug_desc_qty_hm.get("drug_code");
								 drug_desc=(String)drug_desc_qty_hm.get("drug_desc"); 
								 order_id1=(String)drug_desc_qty_hm.get("order_id");
								 drug_class=(String)drug_desc_qty_hm.get("drug_class");
								 order_line_num1=(String)drug_desc_qty_hm.get("order_line_num");
								 iv_prep_yn=(String)bean.checkIVOrder(order_id1);
								 order_line_status=bean.gethold_discontinue(order_id1,order_line_num1);
								 //out.println("----"+order_line_num1);
								n=(count+x+1);
if(order_line_status.equals("DC")){classvalue = "red";}
else if(order_line_status.equals("HD")){classvalue = "yellow";}
if(iv_prep_yn.equals("")){c2++;}
if(!iv_prep_yn.equals(""))
	{ c1++;
     if(order_line_num1.equals("1")){drug_class_ind = "#FFBFBF";}
     else if(order_line_num1.equals("2")||order_line_num1.equals("3")||order_line_num1.equals("4")||order_line_num1.equals("5")){
	   drug_class_ind = "#FFDFDF";
	 }
 }
else if(drug_class!=null && drug_class.equals("N")){
					drug_class_ind = "#66FFFF";
}else if(drug_class!=null && drug_class.equals("C")){
					drug_class_ind = "#CCFFCC";
}else
	{ drug_class_ind ="white";}

 if( c1==1 ) { count++;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
}else if(c2==1 ) { count++;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
 } 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(drug_class_ind ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
drug_strength=(String)drug_desc_qty_hm.get("drug_strength"); 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(drug_strength ));
            _bw.write(_wl_block28Bytes, _wl_block28);
	
		al_qty=(ArrayList)drug_desc_qty_hm.get("qty");
			for(int k=0;k<al_qty.size();k++){ 
							hm_qty=new HashMap();
							hm_qty=(HashMap)al_qty.get(k);
							order_id=(String)hm_qty.get("order_id");
							//admin_due_flag=(String)hm_qty.get("admin_due_flag");
							admin_recorded_yn=(String)hm_qty.get("admin_recorded_yn");
					       // admin_recorded_date_time=(String)hm_qty.get("admin_recorded_date_time");
							administered_yn=(String)hm_qty.get("administered_yn");
					       // admin_date_time=(String)hm_qty.get("admin_date_time");
							te_qty=(String)hm_qty.get("f_qty");
							if(te_qty==null){te_qty="";}
							order_line_num=(String)hm_qty.get("order_line_num");
							time=(String)hm_qty.get("time");
							if(!iv_prep_yn.equals(""))
	{  mode="Y";} else {mode="N";}
	freq_nature  =bean.callfrequency(order_id,order_line_num);
	
            _bw.write(_wl_block1Bytes, _wl_block1);
 if(te_qty==""){ 
            _bw.write(_wl_block29Bytes, _wl_block29);
} else if(!order_line_num.equals("1")){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block31Bytes, _wl_block31);
} else if(freq_nature.equals("P") ||ft_bean.enableSelect(o_date+""+time,admin_from_date,admin_to_date)){ 
            _bw.write(_wl_block32Bytes, _wl_block32);
  if(!administered_yn.equals("") && administered_yn.equals("Y")){ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(n ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( drug_strength));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(o_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(admin_from_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(admin_to_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(to_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(administration_status));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block37Bytes, _wl_block37);
} else if(!admin_recorded_yn.equals("") && admin_recorded_yn.equals("Y")){
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(n ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( drug_strength));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(o_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(admin_from_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(admin_to_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(to_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(administration_status));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block39Bytes, _wl_block39);
} else if(freq_nature.equals("O")){ 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(n ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( drug_strength));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(o_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(admin_from_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(admin_to_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(to_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(administration_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block39Bytes, _wl_block39);
}else if(freq_nature.equals("P")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(n ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( drug_strength));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(o_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(admin_from_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(admin_to_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(to_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(administration_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block43Bytes, _wl_block43);
} else { 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(n ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( drug_strength));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(o_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(admin_from_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(admin_to_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(from_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(to_time));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(administration_status));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
} else  { 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(te_qty));
            _bw.write(_wl_block48Bytes, _wl_block48);
 } }
            _bw.write(_wl_block49Bytes, _wl_block49);
 }count=(count+tep+1); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 }
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);

putObjectInBean(bean_id,bean,request);
putObjectInBean(ft_bean_id,ft_bean,request);
}catch(Exception e){
out.println(e.toString());
e.printStackTrace();

}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdministrationDetailfor.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Timings/Dosage.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IVDrugs.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IVDrugs.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Non-IVDrugs.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Non-IVDrugs.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
