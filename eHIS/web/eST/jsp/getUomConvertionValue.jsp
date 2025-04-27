<%@page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,javax.servlet.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	String locale			= (String)session.getAttribute("LOCALE");
	
	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	String gen_uom_code	= request.getParameter("item_gen_uom_code");
	String item_uom_code	=  request.getParameter("item_uom_code");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	ArrayList alParameters	=	new ArrayList();
	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	ItemBean bean = (ItemBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");	
	try
	{	
		String conv_factor=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConversionFactor.label","common_labels");
		String sale_uom = (String) hash.get("sale_uom");
		if(item_uom_code.equals(sale_uom))
		{	
			result	=	true;
			message	=	"Done";
			out.println("document.getElementById('td_sale_stk_uom_conv').innerText='"+conv_factor+" 1';");
			return;
		}
		else
		{
			String sql = bean.getStRepositoryValue("SQL_ST_AM_UOM_EQL_CONVERSION_SELECT");	
						alParameters.add(gen_uom_code);
			alParameters.add(sale_uom);
			
			HashMap hmDefaultValues = bean.fetchRecord(sql,alParameters);
			if(hmDefaultValues==null) return;
			
			out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML='"+conv_factor+" <b>"+bean.checkForNull((String)hmDefaultValues.get("EQVL_VALUE"),"")+"</b>';");
			result	=	true;
			message	=	"Done";
			return;
		} 	
	}
	catch (Exception exception){
		result	=	false;
		flag	=	"NO_CONV_FACTOR_FOR_UOM_CODE";

		out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML='&nbsp';");
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
