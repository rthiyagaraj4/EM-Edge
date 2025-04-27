package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __userforreportingresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/UserForReportingResult.jsp", 1719921356000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<!-- UserForReportingResult -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/UserForReportingOrderable.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<form name=\"formUserForReportingResult\" id=\"formUserForReportingResult\"> \n\t<table class=\'grid\' width=\'100%\'>\n\t<td class=\' COLUMNHEADER\' width=\'70%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\' COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n<tr id=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'> \n\n\t<td width=\'70%\' class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' name=\'catalog_desc\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="><font size=2>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n\t<input type=\'hidden\'  name=\'catalog_code";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'catalog_code";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></td> \n\n\t<td width=\'30%\' class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' align=\'center\'><input type=\'checkbox\'\tname=\'select_yn";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'select_yn";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" value=\'Y\' ></td>\n</tr>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\n\t\t  <!-- <tr>\n\t\t\t<td width=\'70%\' class=\'QRYODD\' name=\'all_val\'><font size=2>All\n\t\t\t <input type=\'hidden\'  name=\'all_value\' id=\'all_value\' value=\"*ALL\"></td></td>\n\t\t<td width=\'30%\' class=\'QRYODD\' align=\'center\'><input type=\'checkbox\' name=\'all\' id=\'all\' value=\'N\' ></td>\n\t\t</tr>   --> \n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" \n\t\t\t\n\t <!--  <tr id=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<td width=\'70%\' class=\'QRYODD\' name=\'all_val\'><font size=2>All\n\t\t <input type=\'hidden\'  name=\'all_value\' id=\'all_value\' value=\"*ALL\"></td>\n\t\t<td width=\'30%\' class=\'QRYODD\' align=\'center\'><input type=\'checkbox\' name=\'all\' id=\'all\' value=\'N\'  ></td>\n\t</tr>  -->\n\t\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\n\t<tr id=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<td width=\'70%\' class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'name=\'catalog_desc";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'><font size=2><b>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</b>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" \n\t\t<input type=\'hidden\'  name=\'catalog_code";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"> </td> \n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\n\t\t\t<td width=\'70%\' class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'><font size=2>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<td width=\'30%\' class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=\'Y\' ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" ></td>\n\t</tr>\n\t\t\t\n\t\t\t\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\n</table>\n\t\t<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\"hidden\" name=\'tabVal\' id=\'tabVal\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<input type=\"hidden\" name=\'bean_id\' id=\'bean_id\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<input type=\"hidden\" name=\'bean_name\' id=\'bean_name\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );
	
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

int row_count=0;int row_count1=0;

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
  
	//String classValue  = "",All="", key="",status="E",readOnly = "";
	String tblrow_id = "", checkValue="";
	String disabled = "",  valid="";
	String associate_yn="";
	String catalog_desc="";
	//boolean flag=false;
	//boolean temp=false;

	HashMap htListRecord= new HashMap();
	//HashMap tempRecordChk= new HashMap();
	
	HashMap select_All = new HashMap();
	boolean isAllPresent = false;
	Vector recList = new Vector();
	
	String   code="";
	//String status_db = "";
	//String mode="1";
	//String checkValue1="";
	
	boolean stats = false;
	String update_val = "";
	//boolean alteredRecord = false;
	//alteredDBRecord = false;

	String index= request.getParameter("index");
	String tabVal= request.getParameter("tabVal");
	String ord_category_value = request.getParameter("ord_category_value");
	String ord_type_value = request.getParameter("ord_type_value");

	if (index == null || index.equals("null")  ) index=""; else index = index.trim();
	if (tabVal == null || tabVal.equals("null")  ) tabVal=""; else tabVal = tabVal.trim();
	if (ord_category_value == null || ord_category_value.equals("null")  ) ord_category_value=""; else ord_category_value = ord_category_value.trim();
	if (ord_type_value == null || ord_type_value.equals("null")  ) ord_type_value=""; else ord_type_value = ord_type_value.trim();

	String bean_id = "Or_UserForReporting" ;
	String bean_name = "eOR.UserForReporting";
	String slClassValue = "";

	eOR.Common.MultiRecordBean MultiRecordSet= new eOR.Common.MultiRecordBean();

	UserForReporting bean = (UserForReporting)getBeanObject( bean_id, bean_name , request ) ;
	MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
	
	row_count			=  MultiRecordSet.getSize("DB");
//	out.println("<script>alert("+row_count+");</script>");
	if( row_count == 0 )
	{//out.println("<script>alert('hi');</script>");
		select_All.put("status","N");
		select_All.put("catalog_desc","All");
		select_All.put("valid","N");
		select_All.put("code","*All");
		select_All.put("associate_yn","N");
		MultiRecordSet.putObject(select_All);
	//	boolean ret = MultiRecordSet.putObject(select_All);
	//	System.err.println("Rec Inserted into MultiRecBean   " + ret );

		select_All = null;
	}
	else
	{
		for(int i=0;i<MultiRecordSet.getSize("DB");i++)
		{
			htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
			code	=	(String)	htListRecord.get("code");
			//	out.println("<script>alert(' Code :  "+code+"')</script>");
			if(!code.equalsIgnoreCase("*All"))
			{
				isAllPresent = false;
			
			}
			else
			{
				isAllPresent = true;
				break;
			}
		}
		if( isAllPresent == false)
		{
			for(int i=0;i<MultiRecordSet.getSize("DB");i++)
			{
				htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
				if(htListRecord != null)
				{
					recList.add(i,htListRecord);
				}
				//MultiRecordSet.removeObject(i);
			//	out.println("<script>alert(' htListRecord :  "+htListRecord+"')</script>");
			}
			//boolean x = MultiRecordSet.clearDBRec();
			MultiRecordSet.clearDBRec();
			
			select_All.put("status","N");
			select_All.put("catalog_desc","All");
			select_All.put("valid","N");
			select_All.put("code","*All");
			select_All.put("associate_yn","N");
			MultiRecordSet.putObject(select_All);
			//boolean ret = MultiRecordSet.putObject(select_All);
			//System.err.println("Rec Inserted into MultiRecBean   " + ret );
			select_All = null;
			//boolean ret1 = false;
			for(int i=0;i<recList.size();i++)
			{
				 MultiRecordSet.putObject((HashMap )recList.get(i));
				//ret1 = MultiRecordSet.putObject((HashMap )recList.get(i));
			}
		}else if(isAllPresent == true)
			{
			for(int i=0;i<MultiRecordSet.getSize("DB");i++)
			{
				htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
				if(htListRecord != null)
				{
					recList.add(i,htListRecord);
				}
				//MultiRecordSet.removeObject(i);
			}
			//boolean x = MultiRecordSet.clearDBRec();
			MultiRecordSet.clearDBRec();
								
			for(int i=0;i<recList.size();i++)
			{
				MultiRecordSet.putObject((HashMap )recList.get(i));
				//boolean	ret = MultiRecordSet.putObject((HashMap )recList.get(i));
			}	
		}row_count1			=  MultiRecordSet.getSize("DB");
	}
	
if(tabVal.equals("S")){
	MultiRecordSet	= (eOR.Common.MultiRecordBean)bean.getCatalogDesc(index,ord_category_value,ord_type_value);
		
	row_count			=	MultiRecordSet.getSize("SELECT");
//	out.println("<script>alert("+row_count+");</script>");
	if ( row_count	== 0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
	}
}else if(tabVal.equals("A")){
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
		row_count1			=  MultiRecordSet.getSize("DB");
//		out.println("<script>alert('row_count :"+row_count+"');</script>");
//		out.println("<script>alert('row_count1 :"+row_count1+"');</script>");
		
}				
/*ArrayList CatalogDesc = new ArrayList();
 CatalogDesc		=  bean.getCatalogDesc(index,ord_category_value,ord_type_value);

*/else{ 
MultiRecordSet	 =(eOR.Common.MultiRecordBean)bean.getBean();
		for(int j=0; j<row_count; j++){
				update_val = request.getParameter("select_yn"+j);
			if(update_val == null || update_val.equals("null")){
				update_val = "N";
			}
			if(tabVal.equals("S")){
				//alteredRecord = MultiRecordSet.setBeanValue(j,update_val);
				MultiRecordSet.setBeanValue(j,update_val);
			}else if(tabVal.equals("A")){
				//alteredDBRecord = MultiRecordSet.setDBBeanValue(j,update_val);
				MultiRecordSet.setDBBeanValue(j,update_val);
			}
		}
}

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	try{
		if(tabVal.equals("S")){

			String slClassValueTmp=null;
				
		for( int i=0 ; i< row_count ; i++ ) {
				if(i % 2 == 0){
					slClassValue = "gridData";
				}else{
					slClassValue = "gridData";
				}

		slClassValueTmp = slClassValue;
		htListRecord	=	(java.util.HashMap)	MultiRecordSet.getListObject(i);

		code				=	(String)	htListRecord.get("code");
		valid				=	(String)	htListRecord.get("valid");
		catalog_desc		=	(String)	htListRecord.get("catalog_desc");
		associate_yn		=	(String)	htListRecord.get("associate_yn");


		if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
		stats			=	MultiRecordSet.containsObject(code);
			if(stats){
				valid = MultiRecordSet.getValidKey(code);
			}

			if(valid.equals("Y")){
					checkValue="checked";
					disabled="disabled";
			}else{
				if(associate_yn.equals("Y")){
					checkValue="checked";
					disabled="";
				}else{
					if((stats)&&(associate_yn.equals("N"))){
						checkValue="checked";
						disabled="";
					}else{
						checkValue="";
						disabled="";
					}
				}
			}
			 tblrow_id	=	"tblrow_id"+i;
//if(!code.equals("*All")){		

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(((catalog_desc.equals(""))?"&nbsp;":catalog_desc)));
            _bw.write(_wl_block17Bytes, _wl_block17);

		slClassValue = slClassValueTmp;
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(checkValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
//	}
	row_count=row_count;	
	}else if(tabVal.equals("A")){
	
	//	if ( row_count	== 0 || isAllPresent == false){
            _bw.write(_wl_block27Bytes, _wl_block27);
//}
	for( int i=0 ; i< row_count ; i++ ) {
	/*	tempRecordChk =	(java.util.HashMap)MultiRecordSet.getObject(i);
		String code_all=(String)tempRecordChk.get("code");
		if(code_all.trim().equalsIgnoreCase("*All"))
			temp = true;*/
	}
		String slClassValueTmp=null;
	for( int i=0 ; i< row_count1 ; i++ ) {
		if(i % 2 == 0){
			slClassValue = "gridData";
		}else{
			slClassValue = "gridData";
		}
		slClassValueTmp = slClassValue;
				
		htListRecord=(java.util.HashMap)MultiRecordSet.getObject(i);
		code				=	(String)	htListRecord.get("code");
		valid				=	(String)	htListRecord.get("valid");
		associate_yn		=	(String)	htListRecord.get("associate_yn");
		catalog_desc		=	(String)	htListRecord.get("catalog_desc");
		//status_db			=	(String)	htListRecord.get("status");
		
//out.println("<script>alert('code:"+code+"-valid:"+valid+"-associate_yn:"+associate_yn+"-catalog_desc-"+catalog_desc+"--');</script>");
		tblrow_id	=	"tblrow_id"+i;
		if(valid.equals("N")){
			if(associate_yn.equals("Y"))
				checkValue="checked";
			else
				checkValue="";
		}
		else{
			if(associate_yn.equals("D"))
				checkValue="";
			else
				checkValue="checked";
		}
			
	//  if( flag == false && isAllPresent == false){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block29Bytes, _wl_block29);

	//		isAllPresent=true;
	//	} 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(valid.equals("Y")){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(((catalog_desc.equals(""))?"&nbsp;":catalog_desc)));
            _bw.write(_wl_block35Bytes, _wl_block35);

			slClassValue = slClassValueTmp;
		
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(code));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else {
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(((catalog_desc.equals(""))?"&nbsp;":catalog_desc)));
            _bw.write(_wl_block40Bytes, _wl_block40);

			slClassValue = slClassValueTmp;
		
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(code));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(checkValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
}//end of for
	row_count=row_count1;}//end of else if
		}catch(Exception e){
			System.out.println("Exception@2jsp: "+e);
		}
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(tabVal));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block49Bytes, _wl_block49);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
