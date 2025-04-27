<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>


<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu Start.
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	//String locale			= (String)session.getAttribute("LOCALE");
	

	Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id		= (String) hash.get( "bean_id" );
	String bean_name	= (String) hash.get( "bean_name" );
	ATCClassificationBean beanObj = (ATCClassificationBean)getBeanObject(bean_id,bean_name ,request);

	try {
		Vector all_values	=	new	Vector();
		Vector recs			=	null;
		int recno			=	0;
		int	colno			=	0;
		int begin			=   0;
		int max				=	0;
		int startVal		=	0;

		String level_no		= (String) hash.get("level_no");
		String start		= (String) hash.get("start");
		String recCount		= (String) hash.get("recCount");
		String resetStatus	= (String) hash.get("resetStatus");
		begin			= Integer.parseInt(start);
		max				= Integer.parseInt(recCount)-1;
		startVal	=	begin-1;

		//out.println("<script>alert(' startVal:"+startVal+" Begin:"+begin+"');</script>");
		if(resetStatus==null || resetStatus.equals("")){

			while(begin<=max){
				recs	=	new Vector();
				recs.add(colno++,	hash.get("code_"+begin));
				recs.add(colno++,	hash.get("desc_"+begin));
				recs.add(colno++,	hash.get("seqno_"+begin));
				recs.add(colno++,	hash.get("count_"+begin));
				recs.add(colno++,	hash.get("delete_"+begin));
				recs.add(colno++,   hash.get("del_all"));
				all_values.add(recno,recs);
				colno=0;
				recno++;
				begin++;
			}
			//out.println("<script>alert(' level_no:"+level_no+" all_values="+all_values+" startVal:"+startVal+"');</script>");

			beanObj.updateRecords(level_no,all_values,startVal);

		}
		else{
			beanObj.resetRecords(level_no,startVal,(max-1));

		}
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");");
		e.printStackTrace();
	}
	putObjectInBean(bean_id,beanObj,request);
%>
