<%@page import="java.sql.*,java.util.*, eCA.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>

<%
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String index_value	= (String)hash.get("INDEX_VALUES");
	String fm_val		= (String)hash.get("FROM_VALUE");
	String to_val		= (String)hash.get("TO_VALUE");
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	String tab_value	= (String)hash.get("TAB_VALUE");
	String group_by		= (String)hash.get("GROUP_BY");
	String update_value	= "";
	String valid		= "N";
	String code			= "";
	boolean altDBRecord = false;
	boolean stats		= false;
	java.util.HashMap hash1 = new java.util.HashMap();

	CATranscriberSetupBean bean = (CATranscriberSetupBean)getObjectFromBean( bean_id,bean_name, session ) ; 
	eCA.CAMultiRecordBean multiRecSet	= (eCA.CAMultiRecordBean)bean.getBean();
	
	int fm_value = Integer.parseInt(fm_val);
	int to_value = Integer.parseInt(to_val);
	
	StringTokenizer stoken = new StringTokenizer(index_value,"~");

	for(int j=fm_value; j<=to_value; j++)
	{
		update_value = stoken.nextToken();
		if(!group_by.equals("PC"))
		{
			if(tab_value.equals("S"))
				multiRecSet.setBeanValue(j,update_value); 
			else if(tab_value.equals("A"))
				multiRecSet.setDBBeanValue(j,update_value); 
		}
		else
		{
			valid = "N";
			altDBRecord = false;
			stats = false;
			hash1 =	(java.util.HashMap)	multiRecSet.getListObject(j);
			code = (String)hash1.get("code");
			stats =	multiRecSet.containsObject(code);
			if(stats)
			{
				valid = multiRecSet.getValidKey(code);
			}

			if(valid.equals("Y"))
			{
				if(update_value.equals("N"))
				{
					hash1.put("valid", "Y");
					hash1.put("associate_yn", "D");
					altDBRecord = multiRecSet.setListObject(j,hash1);
				}
			}
			else
			{
				if(update_value.equals("Y"))
				{
					hash1.put("valid", "N");
					hash1.put("associate_yn", "Y");
					altDBRecord = multiRecSet.setListObject(j,hash1);
				}
			}
		}
	}

	putObjectInBean(bean_id,bean,session);

%>
