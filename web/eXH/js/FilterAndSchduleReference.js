function funAddctrl()
{
 
    

}  
  function funAdd()
{
//parent.frames[3].location.href='../../eXH/jsp/FilteringandschedulingApplicationLevel.jsp?Filter_group_code='+parent.frames[1].document.forms[0].Filter_group_desc_id.value;

parent.frames[3].location.href='../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?Filter_group_code='+parent.frames[1].document.forms[0].Filter_group_desc_id.value+'&rule=I';
  //parent.frames[4].location.href='../../eXH/jsp/FilteringandschedulingApplicationSearch1.jsp?Filter_group_code='+document.forms[0].filter_group_id.value;
parent.frames[5].location.href='../../eCommon/jsp/MstCodeError.jsp';
//	this.document.location.reload();
}
function  func1(Filter_groupcode,Filter_level1_type,Filter_level1_subtype,Filter_level1_code,Filter_level1_value,Filter_level2_type,Filter_level2_subtype,Filter_level2_code,Filter_level2_value,Filter_level3_type,Filter_level3_subtype,Filter_level3_code,Filter_level3_value,Filter_level4_type,Filter_level4_subtype,Filter_level4_code,Filter_level4_value,Filter_level5_type,Filter_level5_subtype,Filter_level5_code,Filter_level5_value,Filter_level6_type,Filter_level6_subtype,Filter_level6_code,Filter_level6_value,Filter_level7_type,Filter_level7_subtype,Filter_level7_code,Filter_level7_value,Filter_level8_type,Filter_level8_subtype,Filter_level8_code,Filter_level8_value,Filter_level9_type,Filter_level9_subtype,Filter_level9_code,Filter_level9_value,tx_no,levelcount)
{


	   	 var url='&Filter_group_code='+Filter_groupcode+'&Filter_level1_type='+Filter_level1_type+'&Filter_level1_subtype='+Filter_level1_subtype+  '&Filter_level1_code='+Filter_level1_code+'&Filter_level1_value='+Filter_level1_value+'&Filter_level2_type='+Filter_level2_type+'&Filter_level2_subtype='+Filter_level2_subtype+
      '&Filter_level2_code='+Filter_level2_code+'&Filter_level2_value='+Filter_level2_value+'&Filter_level3_type='+Filter_level3_type+'&Filter_level3_subtype='+Filter_level3_subtype+
      '&Filter_level3_code='+Filter_level3_code+'&Filter_level3_value='+Filter_level3_value+'&Filter_level4_type='+Filter_level4_type+'&Filter_level4_subtype='+Filter_level4_subtype+
      '&Filter_level4_code='+Filter_level4_code+'&Filter_level4_value='+Filter_level4_value+'&Filter_level5_type='+Filter_level5_type+'&Filter_level5_subtype='+Filter_level5_subtype+
      '&Filter_level5_code='+Filter_level5_code+'&Filter_level5_value='+Filter_level5_value+'&Filter_level6_type='+Filter_level6_type+'&Filter_level6_subtype='+Filter_level6_subtype+
      '&Filter_level6_code='+Filter_level6_code+'&Filter_level6_value='+Filter_level6_value+'&Filter_level7_type='+Filter_level7_type+'&Filter_level7_subtype='+Filter_level7_subtype+
      '&Filter_level7_code='+Filter_level7_code+'&Filter_level7_value='+Filter_level7_value+'&Filter_level8_type='+Filter_level8_type+'&Filter_level8_subtype='+Filter_level8_subtype+
      '&Filter_level8_code='+Filter_level8_code+'&Filter_level8_value='+Filter_level8_value+'&Filter_level9_type='+Filter_level9_type+'&Filter_level9_subtype='+Filter_level9_subtype+
      '&Filter_level9_code='+Filter_level9_code+'&Filter_level9_value='+Filter_level9_value+'&Transnumber='+tx_no+'&levelcount='+levelcount; 
	
	  
	 //var url='&Filter_group_code='+Filter_groupcode+'&Transnumber='+tx_no;

parent.frames[4].location.href='../../eXH/jsp/FilterAndSchdulingSearchUpdation.jsp?'+url;
parent.frames[5].location.href='../../eCommon/jsp/MstCodeError.jsp';

	  
} 
function searcheval()
{
//parent.frames[3].location.href='../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?Filter_group_code='+parent.frames[1].document.forms[0].Filter_group_desc_id.value;

//parent.frames[4].location.href='../../eXH/jsp/FilteringAndSchedulingApplicationSearchAdd.jsp?Filter_group_code='+parent.frames[1].document.forms[0].Filter_group_desc_id.value;

	this.document.forms[0].action='../../eXH/jsp/FilterLayerqueryNull.jsp?Filter_group_code='+parent.frames[1].document.forms[0].Filter_group_desc_id.value;

	this.document.forms[0].submit();
	parent.frames[5].location.href='../../eCommon/jsp/MstCodeError.jsp';
}
