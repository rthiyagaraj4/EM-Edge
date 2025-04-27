package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import org.w3c.dom.*;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesstdcomplinking extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesStdCompLinking.jsp", 1743657888706L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\ttestVar = testVar.replace(\'`\',\'\\r\');\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\ttestVar = testVar.replace(\'`\',\'\\r\');\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t\t\t\t\t\ttestVar = testVar.replace(\'`\',\'\\r\');\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onScroll=\"scrollTitle1()\" class=\"message\">\n</body>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

private static String[] construct(String sqlQuery)
{
	StringBuffer temp = new StringBuffer(sqlQuery);
	String retVal[];
	int count = 0;
	if(temp.indexOf("$$") == temp.lastIndexOf("$$"))
		retVal = new String[2];
	else
	{
		int start_index = 0;
		while (true)
		{
			start_index = temp.indexOf("$$", start_index);
			if(start_index == -1)
				break;
			else
			{
				count++;
				start_index += 2;
			}
		}
		retVal = new String[count+1];
	}

	count = 1;
	while(temp.indexOf("$$") != -1)
	{
		int start_index = temp.indexOf("$$");
		int end_index = temp.indexOf("##");
		String paramValue = temp.substring(start_index+2, end_index);
		temp.replace(start_index, end_index+2, "?");

		retVal[count] = paramValue;
		count++;
	}
	retVal[0] = temp.toString();

	return retVal;
}

/*public static String encodeHexString(String sourceText) {

		byte[] rawData = sourceText.getBytes();
		StringBuffer hexText = new StringBuffer();
		String initialHex = null;
		int initHexLength = 0;

		for (int i = 0; i < rawData.length; i++) {
			int positiveValue = rawData[i] & 0x000000FF;
			initialHex = Integer.toHexString(positiveValue);
			initHexLength = initialHex.length();
			while (initHexLength++ < 2) {
				hexText.append("0");
			}
			hexText.append(initialHex);
		}
		return hexText.toString();
	}*/



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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
20/02/2013		IN038004		Nijitha			CRF-CA- CHL-CRF-0011/02- Social History Widget-> We get script error in some sections
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
15/12/2014	IN052359		Rames G		15/12/2014		Akbar S			The defined defaulted value does not auto populated when new row is added in grid component.
																		Refer to attached screen shots.
22/04/2018	IN065908		Sharanraj	03/05/2018		Ramesh G		GHL-CRF-0493	
09/05/2018  IN067580		Sharanraj	09/05/2018		Ramesh      	CA-GHL-CRF-0493/06-Record Clinical Note	
17/05/2018  IN067664		Sharanraj	09/05/2018		Ramesh      	CA-GHL-CRF-0493/09-Record Clinical Note	
22/10/2018  IN067855		Ramya Maddena   22/10/2018	Ramesh      	ML-MMOH-CRF-1202
30/01/2019  IN069676		Prakash C  	30/01/2019	Ramesh G 	ML-MMOH-CRF-1281.1
28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String std_component_information = request.getParameter("std_component_information")==null?"":request.getParameter("std_component_information");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
String facility_id = (String) session.getValue("facility_id");
String flag = request.getParameter("flag")==null?"":request.getParameter("flag");
String attending_practitioner = request.getParameter("attending_practitioner")==null?"":request.getParameter("attending_practitioner");//IN065908
String from_date=request.getParameter("from_date")==null?"":request.getParameter("from_date");//IN065908
String to_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");//IN065908
String rowIndex = request.getParameter("rowId")==null?"0":request.getParameter("rowId");
String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");//68801
String ord_typ_code=request.getParameter("ord_typ_code")==null?"":request.getParameter("ord_typ_code");//68801
String practitioner_type  	= (String) session.getValue("practitioner_type"); //68801
int rowId = Integer.parseInt(rowIndex);
rowId = rowId - 1;
String std_comp_id				=	"", look_up_type	=	"";
String std_comp_result_type	=	"",	compId			=	"";
std_component_information = java.net.URLDecoder.decode(std_component_information);
if (std_component_information==null) std_component_information="";


eCA.StandardCompRepository stdCompRep = new eCA.StandardCompRepository();
StringTokenizer st_comp_details = new StringTokenizer(std_component_information, "~");
String sqlQuery = "";
String chkSplChars = "";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
boolean isAllowMultiDesc=false;//IN069676
try
{
	con = ConnectionManager.getConnection(request);	
	 isAllowMultiDesc = CommonBean.isSiteSpecific(con, "MR","ALLOW_MULTI_DESC");//IN069676
	while(st_comp_details.hasMoreTokens())
	{

		//StringTokenizer temp = new StringTokenizer(st_comp_details.nextToken(), "|");
		String strs[] = st_comp_details.nextToken().split("\\|");
		
		//while(temp.hasMoreTokens())
		
		if(strs.length>0)
		{
		
			String retVal[] = null;
			//std_comp_id				= temp.nextToken();
			std_comp_id				= strs[0];
			if (std_comp_id==null) std_comp_id="";
			//look_up_type			= temp.nextToken();
			look_up_type			= strs[1];
			if (look_up_type==null) look_up_type="";
			//look_up_type=look_up_type;
			//std_comp_result_type	= temp.nextToken();		
			std_comp_result_type	= strs[2];		
			if (std_comp_result_type==null) std_comp_result_type="";

			//compId						= temp.nextToken();		
			compId						= strs[3];	
			if (compId==null) compId="";
			
			

			
		
			//if(!std_comp_result_type.equals("L"))
			//{
				sqlQuery = stdCompRep.getCAKeyValue(std_comp_id);
				
			if(!sqlQuery.equals(""))
			{
				if(sqlQuery.indexOf("$$") != -1)
				{
					retVal = construct(sqlQuery);
					//for(int i=0;i<retVal.length;i++)
					int setStringCount = 1;
					pstmt = con.prepareStatement(retVal[0]);

					for(int i=1;i<retVal.length;i++)
					{
						
						String param = retVal[i];

						if(param.equals("PATIENT_ID"))
							pstmt.setString(setStringCount++, patient_id);
						else if(param.equals("ENCOUNTER_ID"))
							pstmt.setString(setStringCount++, encounter_id);
						else if(param.equals("FACILITY_ID"))
							pstmt.setString(setStringCount++, facility_id);	
						else if(param.equals("SPECIALITY_CODE"))
							pstmt.setString(setStringCount++, speciality_code);	
						else if(param.equals("MAST_TYPE_REF"))
							pstmt.setString(setStringCount++, "");	
						else if(param.equals("LANGUAGE_ID"))
							pstmt.setString(setStringCount++, locale);
						/*IN065908 starts*/
						else if(param.equals("ATTENDING_PRACTITIONER"))
							pstmt.setString(setStringCount++, attending_practitioner);
						else if(param.equals("FROM_DATE"))
							pstmt.setString(setStringCount++, from_date);
						else if(param.equals("TO_DATE"))
							pstmt.setString(setStringCount++, to_date);
						/*IN065908 ends*/
						//68801 start
						else if(param.equals("ORDER_ID")) 
							pstmt.setString(setStringCount++, order_id); 
						else if(param.equals("ORD_TYP_CODE")) 
							pstmt.setString(setStringCount++, ord_typ_code); 
						else if(param.equals("PRACTITIONER_TYPE")) 
							pstmt.setString(setStringCount++, practitioner_type); 
						//68801 end
					}
				}
				else
				{

					pstmt = con.prepareStatement(sqlQuery);
				}

				
				rs = pstmt.executeQuery();
				//IN038004 Starts
				//out.println("var templateFormObj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm");
				out.println("if(null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame)");
				out.println("{");
					out.println("var templateFormObj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm");
				out.println("}");
				out.println("else");
				out.println("{");
					out.println("var templateFormObj = parent.document.RecClinicalNotesTemplateForm");	
				out.println("}");
				//IN038004 Ends
				/*IN065908 starts*/
				StringBuffer s1=new StringBuffer();
				StringBuffer s2=new StringBuffer();
				StringBuffer s3=new StringBuffer();
				StringBuffer s4=new StringBuffer(); //68801
				/*IN065908 ends*/
				while(rs.next()&&!std_comp_result_type.equals("L"))
				{
					
					if (rs.getString(1)!=null)
					{
						/*IN065908 starts*/
						//chkSplChars = rs.getString(1);
						if(std_comp_result_type.equals("F") && std_comp_id.equals("ACTIVE_DIAGONIS"))
						{/*IN067855 starts*/
							String active_desc="";
					//IN069327 starts	
						if(isAllowMultiDesc){
							active_desc=rs.getString(2);
						}else{//IN069327 ends
							if("*OTH".equals(rs.getString(1)))	
								active_desc=rs.getString(2);
							else
								active_desc=rs.getString(3);
						}//IN069327
							s1.append("CODE"+"                  "+"DESCRIPTION"+"\\r");
							s1.append(rs.getString(1)+"                  "+active_desc+"\\r");
							while(rs.next())
							{
							//IN069327 starts	
								if(isAllowMultiDesc){
									active_desc=rs.getString(2);
								}else{	//IN069327 ends
									if("*OTH".equals(rs.getString(1)))	
										active_desc=rs.getString(2);
									else
										active_desc=rs.getString(3);
								}//IN069327	
								s1.append(rs.getString(1)+"                  "+active_desc+"\\r");
							}/*IN067855 ends*/
						}
						
						else if(std_comp_result_type.equals("F") && std_comp_id.equals("DRUG_ORDERS"))
						{
							/*IN067664 starts*/
							
							s2.append("PRIORITY"+" "+"ORDER CATALOG"+"         "+"DOSE"+"       "+"FREQUENCY"+"     "+"ROUTE"+"\\r");
							/*IN067664 Ends*/
							/*IN067580 starts*/
							
							/*IN067664 starts*/
							
							
							s2.append(rs.getString("priority_desc")+"      "+rs.getString("order_detail")+"  "+rs.getString("DOSE")+"  "+rs.getString("FREQUENCY")+"  "+rs.getString("ROUTE_DESC")+"\\r");
							/*IN067664 Ends*/
							/*IN067580 ends*/
							while(rs.next())
							{
								/*IN067580 starts*/
								/*IN067664 starts*/
								s2.append(rs.getString("priority_desc")+"      "+rs.getString("order_detail")+"  "+rs.getString("DOSE")+"  "+rs.getString("FREQUENCY")+"  "+rs.getString("ROUTE_DESC")+"\\r");
								/*IN067664 ends*/
								/*IN067580 ends*/
							}
						}
						else if(std_comp_result_type.equals("F") && std_comp_id.equals("NON_DRUG_ORDERS"))
						{						
							s3.append("PRIORITY"+"              "+"ORDER CATALOG"+"\\r");
							s3.append(rs.getString(3)+"                  "+rs.getString(12)+"\\r");
							while(rs.next())
							{
								s3.append(rs.getString(3)+"                  "+rs.getString(12)+"\\r");
							}
						} //68801 start
						else if(std_comp_result_type.equals("H") && std_comp_id.equals("OR_ORDER_CATALOG_DES") && !order_id.equals(""))
						{						
							//s4.append("DESCRIPTION" + "\\r");
							do {
							    String currentRecord = rs.getString(1); 
							    currentRecord=currentRecord.substring(1, currentRecord.length()-1);
							    String[] parts = currentRecord.split("!~!<br />"); 
							    for (String part : parts){
							        s4.append(part.trim() + "\\r"); 
							    }
							} while (rs.next());
						}
						//68801 end
						else
						{
							chkSplChars = rs.getString(1);	
						}
						/*IN065908 ends*/
						//System.out.println("Long text--"+chkSplChars);
						
						/*IN065908 starts*/
						//chkSplChars = chkSplChars.replaceAll("\"","\\\\\"");
	 					//chkSplChars = chkSplChars.replaceAll("\\r","`");
						if(!(std_comp_result_type.equals("F") && (std_comp_id.equals("ACTIVE_DIAGONIS") || std_comp_id.equals("DRUG_ORDERS") || std_comp_id.equals("NON_DRUG_ORDERS"))))
						{
	 						chkSplChars = chkSplChars.replaceAll("\"","\\\\\"");
	 						chkSplChars = chkSplChars.replaceAll("\\r","`");
						}
						/*IN065908 ends*/
						if (std_comp_result_type.equals("D"))
						{
							chkSplChars = com.ehis.util.DateUtils.convertDate(chkSplChars,"DMY","en",locale);		
						}else if (std_comp_result_type.equals("E")){
							chkSplChars = com.ehis.util.DateUtils.convertDate(chkSplChars,"DMYHM","en",locale);
						}						
						if(flag.equals("addrow"))
						{
							out.println("if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document."+compId+"["+rowId+"]!=undefined){"); //IN052359
								out.println("if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document."+compId+"["+rowId+"].value == '')");
								out.println("{");
									 out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document."+compId+"["+rowId+"].value = \""+chkSplChars+"\";");
								out.println("}");
							 out.println("}");//IN052359
							 //IN052359 Start.
							out.println("for(var i=0;i<"+rowId+";i++){");
								out.println("if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document."+compId+"[i]!=undefined){"); //IN052359
									out.println("if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document."+compId+"[i].value == ''){");
										out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document."+compId+"[i].value = \""+chkSplChars+"\";");
									out.println("}");
								out.println("}");	
							out.println("}");
							//IN052359 End.
						}
						else
						{
						//out.println("if(templateFormObj."+compId+".value == '')");//IN038004
						/*IN065908 starts*/
						if(std_comp_result_type.equals("F") && std_comp_id.equals("ACTIVE_DIAGONIS"))
						{
							out.println("if(null!=templateFormObj && null!=templateFormObj."+compId+" && templateFormObj."+compId+".value == '')");//IN038004
							out.println("{");
							out.println("var testVar =  \""+s1.toString()+"\""); 
							//out.println("\n");
							
            _bw.write(_wl_block7Bytes, _wl_block7);
out.println("templateFormObj."+compId+".value = testVar");
							//out.println("\n");
							 out.println("}");
							
						}
						else if(std_comp_result_type.equals("F") && std_comp_id.equals("DRUG_ORDERS"))
						{
							out.println("if(null!=templateFormObj && null!=templateFormObj."+compId+" && templateFormObj."+compId+".value == '')");//IN038004
							out.println("{");
							out.println("var testVar =  \""+s2.toString()+"\""); 
							
            _bw.write(_wl_block8Bytes, _wl_block8);
out.println("templateFormObj."+compId+".value = testVar");
							//out.println("\n");
							 out.println("}");
						}
						else if(std_comp_result_type.equals("F") && std_comp_id.equals("NON_DRUG_ORDERS"))
						{
							out.println("if(null!=templateFormObj && null!=templateFormObj."+compId+" && templateFormObj."+compId+".value == '')");//IN038004
							out.println("{");
							out.println("var testVar =  \""+s3.toString()+"\""); 
							
            _bw.write(_wl_block8Bytes, _wl_block8);
out.println("templateFormObj."+compId+".value = testVar");
							//out.println("\n");
							 out.println("}");
						}
						//68801 start
						else if(std_comp_result_type.equals("H") && std_comp_id.equals("OR_ORDER_CATALOG_DES"))
						{
							out.println("if(null!=templateFormObj && null!=templateFormObj."+compId+" && templateFormObj."+compId+".value == '')");//IN038004
							out.println("{");
							out.println("var testVar =  \""+s4.toString()+"\""); 
							
            _bw.write(_wl_block8Bytes, _wl_block8);
out.println("templateFormObj."+compId+".value = testVar");
							//out.println("\n");
							 out.println("}");
						} // end 68801
						else
						{	
							out.println("if(null!=templateFormObj && null!=templateFormObj."+compId+" && templateFormObj."+compId+".value == '')");//IN038004
							out.println("{");
							
							out.println("var testVar =  \""+chkSplChars+"\""); 
            _bw.write(_wl_block9Bytes, _wl_block9);
out.println("templateFormObj."+compId+".value = testVar");
							
							 out.println("}");
							 
						}	
						/*IN065908 ends*/
						}
					}
				}
			
			}
			/*else
			{
				if (!std_comp_id.equals(""))
					
			}*/
			if(rs!=null)rs.close();
			if(pstmt!=null) pstmt.close();
			
			//}
		}
	}
}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception caught at RecClinicalNotesStdCompLinking.jsp-->" + e);//COMMON-ICN-0181
}
finally
{
	if(con!=null)	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
