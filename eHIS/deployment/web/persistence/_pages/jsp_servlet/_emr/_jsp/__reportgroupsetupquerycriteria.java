package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __reportgroupsetupquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ReportGroupSetupQueryCriteria.jsp", 1709119071848L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</html>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;

try 
{
	con=ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList secondItem1=new ArrayList();
		secondItem1.add("Text");  //Type of item
		secondItem1.add("Group Code ");  // label
		secondItem1.add("group_code");   //name of field
		secondItem1.add("15");	// SIZE
		secondItem1.add("15");	//LENGTH
	finAr.add(secondItem1); //add to ArrayList obj finAr

	ArrayList firstItem = new ArrayList();
		firstItem.add("Text"); //Type of item
        firstItem.add("Group Name");
		firstItem.add("group_name");	//name of field
		firstItem.add("26");	// SIZE
		firstItem.add("26");	//LENGTH 
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();
		secondItem.add("List");  //Type of item
		secondItem.add("Report	");  // label
		secondItem.add("report_id");   //name of field
		secondItem.add("Select report_id,REPORT_desc from sm_report where (module_id ='MR'or module_id ='IP' or module_id ='OP') And report_id IN('MROPRFLS','MROPCSAT','MRBRADEX','MRIPCSBD','MRIPCSMH','MRIPCSEG','MRBRH212','MROPANPO','MROPCSEG','MRBLABWL', 'MRBLABRG','MROPCSMB','MRIPCSMB','MROPCSMS','MRBSS203','OPBMTMOR','IPBMRMOT','IPBEXCDT','MRBPD207','IPBMCREF','MRBBAT3A','MRBBAT3B','MRBBAT3C','IPBMIPCS','IPBMCSBU','MRDCCSMB','MRIPCSOBD','MRDCPROD','MRDCPROS','MRBRH203') order by report_desc"); //Modified for this CRF PER-RH-206 and PER-PD-209A //MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1
		//secondItem.add("'',----- Select -----,MROPRFLS,PER PL-205,MROPCSAT,PER PL-203,MRBRADEX,PER SS-RA 201,MRIPCSBD,PER PD-209,MRIPCSMH,PER PD-205,MRIPCSEG,PER PD-202,MROPANPO,PER PL-209,MROPCSEG,PER PL-212,MRBLABWL,PER SS-RA 206,MRBLABRG,PER SS-RA 101");
	//out.println("<script>alert('start"+secondItem+"')</script>");
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList fifthItem=new ArrayList();
        fifthItem.add("List");
		fifthItem.add("Group Category");  // label
		fifthItem.add("Group_type");   //name of field
		fifthItem.add("'',Both,M,Level1 Group,S,Level2 Group");
	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem=new ArrayList();
        sixthItem.add("Text");
		sixthItem.add("Main Group Code");  // label
		sixthItem.add("Main_Group");   //name of field
		sixthItem.add("4");
		sixthItem.add("4");	//LENGTH
	finAr.add(sixthItem); //add to ArrayList obj finAr

	ArrayList thirdItem=new ArrayList();
        thirdItem.add("List");
		thirdItem.add("Master");  // label
		thirdItem.add("mast_table_name_reference");   //name of field
		thirdItem.add("'',-----------  Select  -----------,BT,Bed Type,BC,Billing Service Classification,CL,Clinic,CP, Clinic/Procedure Unit, DT,Delivery Type,HC,Healthcare Setting Type,IC,ICD Code,NU, Nursing Unit, OC,Order Catalog,RC,Race Group,SP,Specialty,TL,Tabulation List,BD,Bed Class,NS,Name Suffix,DP,Disposal,SC,Staff Clinic,DA,Delivery Attended By");
		//Staff Clinic Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340
		//Delivery Attended By Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341
		//thirdItem.add("'',-----------  Select  -----------,RC,Race Group,DT,Delivery Type,SP,Specialty,HC,Healthcare Setting Type,OC,Order Catalog");
	finAr.add(thirdItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[5];
	String orderByColVals[] = new String[5];

	orderByCols[0] = "Group Code";
	orderByCols[1] = "Group Name";
	orderByCols[2] = "Report";
	orderByCols[3] = "Master";
	orderByCols[4] = "Srl No";
	orderByColVals[0] = "GROUP_CODE";
	orderByColVals[1] = "GROUP_DESC";
	orderByColVals[2] = "REPORT_ID";
	orderByColVals[3] = "MAST_TABLE_NAME_REFERENCE";
	orderByColVals[4] = "ORDER_BY_SRL_NO";

	strbuff = qrypg.getQueryPage(con,finAr,"PD/PD Report Group","../jsp/ReportGroupSetupQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());

}  catch (Exception e) {}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
