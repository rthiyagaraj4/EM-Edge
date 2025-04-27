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
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tpnregnonstdregshowdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TPNRegNonStdRegShowDetails.jsp", 1709121524545L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n<HTML>\n<HEAD>\n\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n<!-- \t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/messages.js\"></SCRIPT> -->\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PHReports.js\"></SCRIPT>\n\t<!-- <SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PHmessages.js\"></SCRIPT> -->\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/TPNNonStdRegimen.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</HEAD>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!-- <BODY> -->\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n<FORM name=\"TpnShowDetails\" id=\"TpnShowDetails\">\n<Table>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<TR><TH colspan=3>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</TH>\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<th><fmt:message key=\"ePH.Energy.label\" bundle=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/> </th></TR>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<TR>\n\t\t\t\t<TD width=\"15%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</TD>\n\t\t\t\t<TD width=\"8%\" align=\"right\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</TD>\n\t\t\t\t<!-- <TD width=\"10%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</TD> -->\n\t\t\t\t<TD width=\"8%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</TD>\n\t\t\t\t<TD width=\"10%\" align=\"right\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</TD>\n\t\t\t\t</TR>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</tr>\n\n</TABLE>\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n<input type=\"hidden\" name=\"carbohydrate_value\" id=\"carbohydrate_value\" value=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n\n</form>\n</BODY>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );
	
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


public String roundTwoDigits(String a)
{
	try
	{
		String bb = "";
			if (a.indexOf(".")==-1)
			{
				bb=a.substring(0,a.length());
			}
			else
			{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3)
				{
					bb=a.substring(0,a.indexOf(".")+3);
				}
				else
				{
					bb=a;
				}
			
			}
			return bb;
	}
	catch (Exception e)
	{
			return a;
			
	}
}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8 ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8 ");
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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//	String patient_id	= request.getParameter("patient_id");
//	String encounter_id	= request.getParameter("encounter_id");
	String patientid=request.getParameter("patient_id");
	String encounterid=request.getParameter("encounter_id");
	String facility_id  = (String) session.getValue("facility_id");
	String bean_id	= "@TPNNonStandardRegimenBean"+patientid+encounterid;
	String bean_name	 = "ePH.TPNNonStandardRegimenBean";
	//String gCode=request.getParameter("gCode");
	String code				  = "";
	String strength			  = "";
	String carbohydrate_value = "";
	String carbo_ener		  = "";
	String lipid_ener		  = "";
	String prot_ener		  = "";
    String display_unit       = "";
	String display_unit1       = "";
	String Ab_w_lit           ="";
	String per_kg_litre       ="";
	String Stremgth_unit	  ="";
	ArrayList Results         =new ArrayList();
	TPNNonStandardRegimenBean bean = (TPNNonStandardRegimenBean)getBeanObject(bean_id,bean_name, request);
	
	//get values for all groups and print it on the screen
	ArrayList groupcodes=new ArrayList();
	ArrayList groupdescs=new ArrayList();

	HashMap generics=new HashMap();

	groupcodes=bean.getStoredGroups();
	groupdescs=bean.getStoredGroupDescs();
	generics=bean.getGenerics();
 
	ArrayList MNEnergies = bean.getMNEnergies();

	if(MNEnergies.size()>0){
		carbo_ener = (String)MNEnergies.get(1);
		lipid_ener = (String)MNEnergies.get(3);
		prot_ener  = (String)MNEnergies.get(5);
	}
     ArrayList regmnDtls						    =   bean.getRegimenDetails();
	 String regimen_code                         =   (String)regmnDtls.get(0);
	 


            _bw.write(_wl_block6Bytes, _wl_block6);


for (int i=0;i<groupcodes.size();i++)
{
	int ispresent=0;
	ArrayList gns=(ArrayList)generics.get(groupcodes.get(i));
	
	if(groupcodes.get(i).equals("MN"))
	{
       Ab_w_lit="";
	   Stremgth_unit			             =bean.getenergyunit();
	}
	else
	{
    Results=(ArrayList)bean.getTPNGenerics((String)groupcodes.get(i),patientid,regimen_code);
	if(Results.size()>0)
      Ab_w_lit =(String)Results.get(3);
	 Stremgth_unit	  ="";
	}
	if(groupcodes.get(i).equals("MN"))
		per_kg_litre="";
	else{
	     if(Ab_w_lit.equals("P"))
		    per_kg_litre="/L";
	     else
		    per_kg_litre="/Kg";
	}

	for (int k=0;k<gns.size();k+=8)
		{
			if (!gns.get(k+2).equals("0"))
			{
					ispresent=1;
			}
		}
		if (ispresent==1)
		{
			String header="";
			if(groupcodes.get(i).equals("MN"))
				header="<th >per kg</th>";
			else
				header="<th >Strength</th>";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(groupdescs.get(i)));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(header));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);

		}

		for (int j=0;j<gns.size();j+=8)
		{
			code=(String)gns.get(j);
			strength="";
			if(code.equals("CHO")){
				strength=(Float.parseFloat((String)gns.get(j+2)) * Float.parseFloat(carbo_ener)) + "";
			}else if(code.equals("LIPID")){
				strength=(Float.parseFloat((String)gns.get(j+2)) * Float.parseFloat(lipid_ener)) + ""; 
			}else if(code.equals("PROTEIN")){ 
				strength=(Float.parseFloat((String)gns.get(j+2)) * Float.parseFloat(prot_ener)) + ""; 
			}

			if (!gns.get(j+2).equals("0"))
			{ 
				if(j==0 && code.equals("CHO")){
				carbohydrate_value=(String)gns.get(j+2);
				}
				display_unit	= (String)gns.get(j+3);
				if(display_unit.equals("tmp"))
				  display_unit1   =  "---";
				else
				  display_unit1   =  display_unit.substring((display_unit.indexOf("!"))+1,display_unit.length());
					 
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(gns.get(j+1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gns.get(j+2)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(((String)gns.get(j+3)).equals("tmp")?"---":(String)gns.get(j+3)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(display_unit1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(gns.get(j+4)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(per_kg_litre));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(roundTwoDigits(strength)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,Stremgth_unit))));
            _bw.write(_wl_block17Bytes, _wl_block17);

			}

		}
	
            _bw.write(_wl_block5Bytes, _wl_block5);

}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(carbohydrate_value));
            _bw.write(_wl_block20Bytes, _wl_block20);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
