/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------
?             100            ?           created
20/01/2012	IN029143		Menaka V		<JD-CRF-0111 This option is available in HIS 2.x and KAUH needs to be in
											EM version. In the current workflow the option is being used frequently. When a physician selects the patient, system will ask to enter the PIN Code. Physician needs to authenticate in the Prescription screen using the PIN code. This will prevent from unauthorised access while the physician is on rounds>.	
31/01/2012	IN030711		Menaka V		When the User is not assigned any Pin No. and he enters any Pin
											No.,Wrong prompt message is displayed
09/11/2012	IN036069		Karthi L		New message added to confirm delete rows in dynamically added form
04/12/2012	IN035976		ChowminyaG		Include Dept_authorization validation for RD orders br appt schedule		
08/01/2014		LICN_1			Karthi						MMS Issue.
10/03/2014	  	IN024984		Chowminya										Duplicate order recording with reason - new mandatory option
26/08/2014    IN050607		Nijitha S										KDAH-SCF-0255
24/07/2015		IN054381			Karthi			MMS-QF-CRF-0211
06/10/2015		IN055737			Karthi L		IN055737 HSA-CRF-0250.1 - Dispatch Slip
29/06/2016		IN060516			Karthi L		MMS-MD-SCF-0017 
-------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name       Rev.Date   Rev.By    Description
--------------------------------------------------------------------------------------------------------------
22/08/2016		IN059646		Raja S								ML-BRU-SCF-1676
10/05/2017		IN064215		Krishna Gowtham J	10/05/2017		Ramesh G		PMG2017-SH-CRF-0001
09/06/2017	IN063816	Vijayakumar K										GHL-CRF-0445.1 [IN:063816]	
03/08/2017	IN062992	Dinesh T		07/08/2017	Ramesh G	ML-MMOH-CRF-0345.1
26/10/2017		IN061892			Prakash C			31/10/2017		Ramesh G		ML-MMOH-CRF-0544

15/12/2017	IN065942	Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the barcode 																		functionality at the time of Registration of order,required patient 															Id,patient name,age,sex,register date and name of study.
06/02/2018		IN065642		Prathyusha P				 		GHL-CRF-0487 [IN:065642]
08/10/2018	  IN063719		Kamalakannan 	08/10/2018	Ramesh G		GHL-CRF-0419
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
27/05/2019	IN069027	Ramesh G								MMS-DM-CRF-0150
--------------------------------------------------------------------------------------------------------------
*/
package eOR.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		{"DUPLICATE_VALUES","APP-0R0289 重复值已通过"},
		{"NO_SERVICE_AVAILABLE","APP-OR0001 服务不适用"},
		{"NEXT_NUMBER_GREATER_MAX","APP-OR0002 下一订单号不能大于最大订单号"},
		{"OVERLAPPING","APP-OR0003 此数字和已经存在的服务类型重叠"},
		{"VALIDNUMBER","APP-OR0004 输入有效号码必须大于0"},
		{"CODEISUSED","APP-OR0005本节代码是用于服务的订购格式科"},
		{"USERACCESS","APP-OR0006 用户授权使用此功能"},
		{"ALLAUTHORIZE","APP-OR0007 你可以授权本订单。现在授权"},
		{"UNSUCCESS","APP-OR0008 本订单须授权发布之前"},
		{"AUTHORIZE_ATLEAST_ONE","APP-OR0009 至少一个订单被授权"},
		{"RESULT_AUTH_ATLEAST_ONE","APP-OR0010 至少一个结果被授权"},
		{"NO_ORDER_FORMAT_AVAILABLE","APP-OR0011 没有适用的订单格式"},
		{"BLANK_RESULT_DATA","APP-OR0012 服务结果数据 &服务不能空白"},
		{"ATLEAST_ONE_RESULT","APP-OR0013 至少输入一个服务结果"},
		{"DUP_CHK","APP-OR0014 重复"},
		{"SERVICE_DATE_BLANK","APP-OR0015 服务日期不能为空"},
		{"INVALID_STATUS","APP-OR0016 &服务的服务状态无效"},
		{"INVALID_DECIMAL","APP-OR0017 小数精度超过"},
		{"CHECK_CODE_DESC","APP-OR0018 代码和描述不能为空"},
		{"CHK_DESC","APP-OR0019 描述必须提及"},
		{"CHK_ID","APP-OR0020 ID 应该提到"},
		{"CHK_CODE","APP-OR0021 代码应该提到"},
		{"ATLEAST_ONE_RECORD","APP-OR0022 至少一个纪录是强制性"},
		{"ORDER_CATEGORY","APP-OR0023 医嘱分类不能为空"},
		{"MAX_RECORDS","APP-OR0024 最大文本限制为 200 个字符"},
		{"UNPROCESS_INPROCESSED","APP-OR0026 已处理的或未处理的不能为空白"},
		{"VALID_DATA","APP-OR0027 必须为已处理和未处理的输入一个有效数字"},
		{"INVALID_NUMBER","APP-OR0028处理和未处理的都不能为０"},
		{"NOT_VALID","APP-OR0029 此处申请不是一个有效操作"},
		{"ONLY_PRACT_OR_RESP","APP-OR0030 需要选择医生或责任"},
		{"BLANK_RECORD","APP-OR0031 空白记录不能提交"},
		{"INVALID_ZERO","APP-OR0032 未处理的不能为０ +<br>"},
		{"INVALID_DESC","APP-OR0033 必须为输入的ID号提到描述"},
		{"INVALID_ID","APP-OR0034 必须为输入的IDS号提到描述"},
		{"CHK_SPEC_GEN","APP-OR0035如果生成标签被选中，向前字段不能空白"},
		{"EXPIRY_PERIOD","APP-OR0036 过期日期不能为空"},
		{"TIME_BASED_RULE","APP-OR0037 基础时间规则不能为空白"},
		{"MIN_LESS_THAN_MAX","APP-OR0038 最小值不能大于最大值"},
		{"ONLY_POSITIVE_NUM","APP-OR0039 只有正整数允许"},
		{"MAX_VAL_NOT_BLANK","APP-OR0040 最大值不能为空白"},
		{"MAX_VAL_NOT_ZERO","APP-OR0041 最大值不能为0"},
		{"MIN_VAL_NOT_BLANK","APP-OR0042 最小值不能为空白"},
		{"DISCRETE_MSR_NOT_NULL","APP-OR0043 离散测量不能空白"},
		{"DESC_NOT_BLANK","APP-OR0044 描述不能为空"},
		{"SEQ_NO_NOT_BLANK","APP-OR0045 序列号不能为空"},
		{"ONLY_NUMBERS","APP-OR0046 只能输入数字"},
		{"FIELD_CANNOT_BE_EMPTY","APP-OR0047 列表值不能为空.Click on Fields/button"},
		{"DUP_DESC","APP-OR0048 重复的描述"},
		{"DUP_SEQ_NUM","APP-OR0049 重复的序列号"},
		{"SEQ_NO_NOT_ZERO","APP-OR0050 序列号不能为0"},
		{"SELECT_TO_CLEAR","APP-OR0051 请选择一个记录清除"},
		{"DESC_NOT_SPACES","APP-OR0052 描述不能只是空格"},
		{"VAL_NOT_ZERO","APP-OR0053 值不能为0"},
		{"PRACT_NOT_BLANK","APP-OR0054 医生不能为空"},
		{"RESP_NOT_BLANK","APP-OR0055 责任不能为空白"},
		{"SELECT_RESP_OR_PRACT","APP-OR0056 选择医生或责任"},
		{"FREQ_NOT_BLANK","APP-OR0057 频率不能为空"},
		{"OTHER_LOC_PRINT","APP-OR0058 在其他位置打印，其他位置不能为空白"},
		{"DISCHARGE_LOC_PRINT","APP-OR0059 指定出院病人的打印位置，指定位置不能为空白"},
		{"INVALID_TIME_ENTRY","APP-OR0060 在增加订单时，时间应该输入"},
		{"INVALID_TIME_DAY_COMB","APP-OR0061 输入的时间字段和重复值不匹配"},
		{"INVALID_TIME_FMT","APP-OR0062 无效的时间格式"},
		{"FIELD_MNEMONIC_CANNOT_BE_EMPTY","APP-OR0063 助记符字段不能为空"},
		{"DESC_FORTEXT_NOT_BLANK","APP-OR0064 任何文本描述不能为空白"},
		{"ORDER_TYPE","APP-OR0065 医嘱类型不能为空"},
		{"PATIENT_CLASS","APP-OR0066 病人分类不能为空"},
		{"RECORD_EXISTS1","APP-OR0067 记录已建立，查询模式更新"},
		{"INVALID_TIME_FMT_HRS","APP-OR0068 有效输入在 00:00 ~ 00:59 之间"},
		{"MAX_LIMIT","APP-OR0069文本最大限制长度允许2000字符"},
		{"SYSTEM_USER_DEFINED","APP-OR0070不能更改系统定义值"},
		{"PRACT_RESP_NO_ACCESS","APP-OR0071医生／责任没有报告医嘱的权力"},
		{"CATALOG_AUTH_CHECK","APP-OR0072 允许级别必须大于等于安全级别"},
		{"ONE_ENTRY_MIN_AGE","APP-OR0073 至少有一个项目是最小年龄的强制性输入"},
		{"ONE_ENTRY_MAX_AGE","APP-OR0074 至少有一个项目是最高年龄的强制性输入"},
		{"MIN_MAX_AGE_CHECK","APP-OR0075 最大年龄应该大于最小年龄"},
		{"SEX_MAX_MIN_OVERLAP_CHK","APP-OR0076 同性不能有重叠的最小年龄和最大年龄"},
		{"ENTER_MONTH_CHK","APP-OR0077月必须在0~11之间"},
		{"ENTER_DAY_CHK","APP-OR0078 日必须在1~31之间"},
		{"INSTRN_BLANK_CHK","APP-OR0079 Instrn 不能为空白"},
		{"AUTH_REQD_CONFIRM","APP-OR0080您可以授权下这医嘱，现在授权？"},
		{"SINGLE_RECORD_CHK","APP-OR0081 此助记符只接受一个单个的记录"},
		{"INVALID_DATE_FMT","APP-OR0082 无效的日期格式，有效输入为 dd/mm/yyyy"},
		{"INVALID_DATE_TIME_FMT","APP-OR0083 无效的日期时间格式. 有效的输入格式为 dd/mm/yyyy hh:mi"},
		{"ENTER_RPT_PRACT","APP-OR0084 输入一个报告医生"},
		{"ALL_MAND_FIELDS","APP-OR0085 输入所有必填项目"},
		{"VARIABLE_DEC_DIGIT","APP-OR0086 只有 @ 小数位数允许"},
		{"RSLT_NOT_LESS_DIGIT","APP-OR0087 结果输入不能小于 @ 位数"},
		{"RSLT_NOT_MORE_DIGIT","APP-OR0088 结果输入不能大于 @ 位数"},
		{"AUTH_RESULT","APP-OR0089 您可以授权这一结果。 + 的N +授权现在 ?"},
		{"FUTURE_DATE_TIME","APP-OR0090 订单日期不能大于当前订单日期"},
		{"BACK_DATE_TIME","APP-OR0091 订单日期不能小于过去订单日期"},
		{"FILL_ORDER_FORMAT_FLDS","APP-OR0092 额外信息不能为空"},
		{"VALUE_BETWEEN_RANGE","APP-OR0093 输入值应该在 之间"},
		{"ADMDATE_LESS_DATE","APP-OR0094 医嘱日期不能小于就诊日期"},
		{"CANNOT_BE_BLANK","APP-OR0095 @ 不能为空"},
		{"SELECT_STATUS","APP-OR0096 状态不能为空"},
		{"ROUT_STATUS","APP-OR0097 Loc1 and Loc2 不能为空白"},
		{"URG_STATUS","APP-OR0098 Urg/Stat for Loc1 and Loc2 不能为空白"},
		{"SYSTEM_DEFINED_CANNOT_DELETE","APP-OR0099 不能删除系统定义值"},
		{"ORDER_SET_SELECTED","APP-OR0100 已选择医嘱设置"},
		{"ORDER_SET_BLANK","APP-OR0101 医嘱设置不能为空"},
		{"DUP_ORDER_SET_ENTRY","APP-OR0102 重复输入不允许"},
		{"PRACT_RESP_NOT_AUTHORISED","APP-OR0103 医生或责任没有获得医嘱的授权..."},
		{"IMAGE_PRE_SELECT_CATEGORY","APP-OR0104 此目录不能选择图像"},
		{"DURATION_CANNOT_BE_BLANK","APP-OR0105 持续时间值不能为空白"},
		{"LABEL_TEXT_CANNOT_BE_BLANK","APP-OR0106 标签文本不能为空"},
		{"INVALID_INTEGER_RANGE","APP-OR0107 无效的整数范围"},
		{"INVALID_DECIMAL_RANGE","APP-OR0108 无效的小数范围"},
		{"SEQ_ORDER_CAT_SECTION_CHK","APP-OR0109 序列号不能和不同的医嘱分类相同"},
		{"LAB_MODULE_INSTALLED","APP-OR0110 不能用此功能. 请使用检验模块"},
		{"PRACT_RESP_CANNOT_REGISTER","APP-OR0111 从业者/责任不具备获得注册医嘱。"},
		{"CLICK_ANY_ONE","APP-OR0112 检查至少一个医嘱"},
		{"MAX_DURN_MAND_CHK","APP-OR0113 最高值应大于 Durn 值"},
		{"NOT_VALID_DELETE","APP-OR0114 此处删除不是一个有效的操作"},
		{"SELECT_HOTSPOT","APP-OR0115 选择一个热点..."},
		{"COSIGN_REQD_CONFIRM","APP-OR0116 你被允许分配此医嘱，分配吗?"},
		{"SCHEDULE_CANNOT_BE_BLANK","APP-OR0117 附表频率不能空白"},
		{"SPECIAL_APPROVAL_REQD_CONFIRM","APP-OR0118 你被允许核批此医嘱，核批吗?"},
		{"DECIMAL_NOT_ALLOWED","APP-OR0119 不允许小数"},
		{"SCH_FREQ_BLANK","APP-OR0120 数量不能为空"},
		{"DOSE_LIMIT","APP-OR0121 超过剂量限制"},
		{"QTY_NOT_EQUAL","APP-OR0122 数量值不能相同"},
		{"QTY_VAL_NOT_SAME","APP-OR0123 所有的数量值不能相同"},
		{"START_DATE_TIME_VALIDATE","APP-OR0124 开始日期／时间应该在计划时间内"},
		{"PRACT_RESP_CANNOT_SPECIAL_APPRV","APP-OR0125 医生或责任没有获得特别批准"},
		{"INVALID_DECIMAL_NUMBER","APP-OR0126 无效的十进制数"},
		{"MAX_NO_DECIMAL","APP-OR0127允许3个字符的精度"},
		{"MAX_255_CHARS","APP-OR0128 文本最大限制255个字符"},
		{"REASON_CANNOT_BLANK","APP-OR0129 原因不能为空"},
		{"TO_LOCATION_GR_EQ_FROM_LOCATION","APP-OR0130 终止位置应该大于等于开始位置"},
		{"TO_ORDER_TYPE_GR_EQ_FROM_ORDER_TYPE","APP-OR0131 终止医嘱类型应该大于等于开始医嘱类型"},
		{"SHEDULE_FUTURE_DATE_TIME","APP-OR0132 开始日期不能大于未来医嘱日期"},
		{"SHEDULE_BACK_DATE_TIME","APP-OR0133 开始日期不能小于过去医嘱日期"},
		{"RADIOLOGY_MODULE_INSTALLED","APP-OR0134 不能使用此功能，请进入放射学模块"},
		{"START_ORDER_DATE_TIME","APP-OR0135 开始日期不能小于医嘱日期"},
		{"CLICK_ONE_ORDERABLE","APP-OR0136 选择至少一条医嘱"},
		{"CLICK_ONE_NEW_ORDERABLE","APP-OR0137 预览至少选择一个新的医嘱"},
		{"OR_MODULE_INSTALL","APP-OR0138 此调协中不能操作 OR 模块"},
		{"SPECIMEN_COLLECTION_DATE_BLANK","APP-OR0139 标本采集时间不能为空"},
		{"PERF_LOCN_CANNOT_BLANK","APP-OR0140 操作位置不能为空白"},
		{"CHECK_ATLEAST_ONE_EVENT","APP-OR0141 检查至少一个事件"},
		{"SPECIMEN_COLLECTION_ORDER_DATE","APP-OR0142 日期必须大于等于医嘱日期"},
		{"SPECIMEN_COLLECTION_PREV_COLLECTION_DATE","APP-OR0143 日期不能小于之前采集日期"},
		{"RESULT_REPORTING_LOCN_BLANK","APP-OR0144位置不能空白"},
		{"PRACT_RESP_AUTH_NO_ACCESS","APP-OR0145 医生／责任没有权限授权结果"},
		{"NEW_ORDER_CONFIRM","APP-OR0146 新医嘱已产生，继续吗？"},
		{"QTY_CANNOT_BE_BLANK","APP-OR0147 数量不能空可零"},
		{"RPT_SUBMIT_TO_PRINTER","APP-OR0148 报告已提交给打印机"},
			{"SUBMIT_TO_PRINTER"       ,				"APP-OR0148 # has been Submitted to the Printer" },//IN065942, Child of RPT_SUBMIT_TO_PRINTER
		{"RPT_CANNOT_BE_BLANK","APP-OR0149 报告不能为空白"},
		{"PRINT_AT_LOCN_CANNOT_BE_BLANK","APP-OR0150 打印位置不能为空白"},
		{"ORDERS_CANNOT_BE_PLACED","APP-OR0151 因为病人类型设置了医嘱规则，医嘱不能被搁置"},
		{"DIRECT_CARE_ANCILLARY_DEPT_ACTIVATE","APP-OR0153 未选择直接治疗／辅助部门.记录不被保存，激活吗？"},
		{"CLICK_RENEW_ORDER","APP-OR0154 医嘱已审查，不能选择新医嘱"},
		{"REFUSAL_LESS_VISIT_DATE_TIME","APP-OR0155 拒绝日期和时间不能低于就诊日期和时间"},
		{"REFUSAL_LESS_REGN_DATE_TIME","APP-OR0156 拒绝日期和时间不能低于注册日期和时间"},
		{"REFUSAL_LESS_SYS_DATE_TIME","APP-OR0157 拒绝日期和时间不能大于当前日期和时间"},
		{"AT_LEAST_ONE_PERFORMING_LOCATION","APP-OR0158 至少选择一个操作位置"},
		{"DUPLICATE_PERFORMING_LOCATION","APP-OR0159 不允许重复操作位置"},
		{"CLICK_ANY_ONE_PATIENT","APP-OR0160 至少检查一个病人"},
		{"CLICK_ANY_ONE_USER_DEFINED_TABS","APP-OR0161 至少选择一个用户定义的标签"},
		{"LOCN_TYPE_NOT_BLANK","APP-OR0174 位置类型不能为空白"},
		{"LOCN_NOT_BLANK","APP-OR0175位置不能空白"},
		{"SPECIMEN_COLLECTION_COLLECTION_DATE","APP-OR0176日期应该大于等于标本采集日期"},
		{"SPECIMEN_COLLECTION_DISPATCH_DATE_BLANK","APP-OR0177 调度日期时间不能空白"},
		{"SPECIMEN_COLLECTION_DISPATCH_MODE_BLANK","APP-OR0178 调度模式不能空白"},
		{"SPECIMEN_COLLECTION_DISPATCH_BY_BLANK","APP-OR0179 调度者不能空白"},
		{"SPECIMEN_COLLECTION_DISPATCH_REMARKS_BLANK","APP-OR0180 备注不能为空白"},
		{"SPECIMEN_COLLECTION_COLLECTION_BY_BLANK","APP-OR0181 收集者不能空白"},
		{"SPECIMEN_COLLECTION_DISPATCH_LOCN_BLANK","APP-OR0182 调度的位置不能空白"},
		{"ATLEAST_ONE_EXCEPTION_IDENTIFIER","APP-OR0183 至少有一个例外标识应选择"},
		{"PREFERRED_SURGERY_DATE_LESSER_SYSDATE","APP-OR0184 推荐手术日期不能低于当前的日期和时间"},
		{"SEQ_TICK_SHEET_SECTION_CHK","APP-OR0185 不同的章节中，序列号不能相同"},
		{"PERF_SURGEON_BLANK","APP-OR0186 操作团队/外科医生不能空白"},
		{"REVIEW_REMARKS_MAX_LENGTH","APP-OR0187 备注长度不能超过 2000 个字符"},
		{"REVIEW_RESULTS_PREVIOUS_ORDERS","APP-OR0188 多患者不能选择以前医嘱"},
		{"RENEW_ORDERS_SUCCESSFUL","APP-OR0189 审查成功..."},
		{"STAT_DURATION_TYPE_BLANK","APP-OR0190 开始时间类型不能为空白..."},
		{"URGENT_DURATION_TYPE_BLANK","APP-OR0191 时间紧迫类型不能空白…"},
		{"ROUTINE_DURATION_TYPE_BLANK","APP-OR0192 常规型的期限不能空白…"},
		{"STAT_DURATION_BLANK","APP-OR0193 开始周期不能为空白.."},
		{"URGENT_DURATION_BLANK","APP-OR0194 紧迫的时间不能空白…"},
		{"ROUTINE_DURATION_BLANK","APP-OR0195 常规时间不能空白..."},
		{"ATLEAST_ONE_PRIVILEGE","APP-OR0196 至少一个特权应选择"},
		{"ATLEAST_ONE_RECORD_ACTIVE","APP-OR0197 有效的必填项必须选择"},
		{"REFERRAL_RECEIVED_DATE_LESSER_REPORTING_DATE","APP-OR0198 推荐接收日期不能小于报告日期"},
		{"REFERRAL_RECEIVED_DATE_BLANK","APP-OR0199 推荐接收日期不能空白..."},
		{"RECEIVE_REPORTING_PRACTITIONER_BLANK","APP-OR0200 接收报告医生不能为空白..."},
		{"REPORTING_PRACTITIONER_BLANK","APP-OR0201 报告医生不能为空"},
		{"REFERRAL_FACILITY_BLANK","APP-OR0202 推荐设备不能为空白..."},
		{"REFERRAL_RECEIVED_DATE_LESSER_SYSDATE","APP-OR0203 推荐接收日期不能大于当前日期"},
		{"PERFORMING_LOCATION_BLANK","APP-OR0204 操作位置不能空白"},
		{"PERFORMING_FACILITY_BLANK","APP-OR0205 操作设备不能空白"},
		{"DUPLICATE_ORDERABLES","APP-OR0206 医嘱不能重复"},
		{"REPORTING_DATE_LESSER_ORDER_DATE","APP-OR0207 报告日期不能小于医嘱日期"},
		{"COL_SEQ_NO_NOT_BLANK","APP-OR0208 序列号栏不能空白"},
		{"COL_NO_CANNOT_REPEATED_SAME_ROW","APP-OR0209 同一行中，列不能重复"},
		{"CLINICAL_EVENT_BLANK","APP-OR0210 临床事件不能空白"},
		{"ATLEAST_ONE_PRIVILEGE_VALUE","APP-OR0211 至少一个特权应选择相应的特权类型"},
		{"ATLEAST_ONE_PRIVILEGE_TYPE","APP-OR0212 至少一个特权类型应选择相应的特权"},
		{"ATLEAST_ONE_PRIVILEGE_TYPE_VALUE","APP-OR0213 至少一个特权输入/特权价值应选择"},
		{"DUPLICATE_ORGANISM","APP-OR0214 @ 值不能重复"},
		{"DIAGNOSIS_EVENT_BLANK","APP-OR0215 疾病不能为空白"},
		{"MAX_ORDERABLES","APP-OR0216 不允许超过10个医嘱"},
		{"RESULT_TYPE_BLANK","APP-OR0217 结果矩阵不能空白..."},
		{"EXT_ORD_CAT_BLANK","APP-OR0218 如果选择订购，订单类型不能为空白"},
		{"PRACT_RESP_NOT_COSIGN","APP-OR0219 医生和责任不能有分配订单的权力.."},
		{"SOURCE_TYPE_BLANK","APP-OR0225 源类型不能为空白..."},
		{"MAX_LMT_PERIOD_MONTH","APP-OR0226 最大限制期只能为12个月"},
		{"SEQ_NO_EXISTS","APP-OR0227 不允许重复序列号"},
		{"PH_NOT_ALLOWED","APP-OR0228 药房不能更新"},
		{"ATLEAST_ONE_DISCR_MEASURE","APP-OR0229 其中至少应该有一个记录的离散措施。"},
		{"EXT_ORD_TYPE_BLANK","APP-OR0230 如果选择订购，订单类型不能为空白"},
		{"BOOK_APPT_CATALOG","APP-OR0231 你想预订一个预约？"},
		{"CLINICAL_COMMENTS_BLANK","APP-OR0232 诊所注释不能为空"},
		{"PH_SELECT_NOT","APP-OR0233 不能选择药房"},
		{"LB_ORDER_NOT_ALLOWED_SOURCE","APP-OR0234 推荐设备中，不允许检验医嘱"},
		{"RD_ORDER_NOT_ALLOWED_SOURCE","APP-OR0235 推荐设备中，不允许放射医嘱"},
		{"CP_START_DATE_TIME","APP-OR0236 改变开始日期时间？"},
		{"BOOK_OT_APPT","APP-OR0237 预订预约?"},
		{"FREQUENT_NOT_SELECT","APP-OR0238 不能选择频繁的医嘱"},
		{"ADMISSION_DATE_LESSER_SYSDATE","APP-OR0239 入院日期不能小于当前日期时间"},
		{"FORMAT_ITEM_CANNOT_BE_EMPTY","APP-OR0240 项目格式不能为空"},
		{"CHECK_ATLEAST_ONE_CATEGORY","APP-OR0241 检查至少一个目录"},
		{"ATLEAST_ONE_SERVICE","APP-OR0242 必须选择至少一个服务"},
		{"ATLEAST_ONE_PRACTITIONER","APP-OR0243 必须选择至少一个医生"},
		{"ATLEAST_ONE_NUR_UNIT","APP-OR0244 必须选择至少一个护理级别"},
		{"ATLEAST_ONE_CLINIC","APP-OR0245 必须选择至少一个诊所"},
		{"GREEN_TIME_IND_LESS","APP-OR0246 绿灯时间指标应总是小于黄色的时间指标"},
		{"YELLOW_TIME_IND_GREATER","APP-OR0247 黄灯时间指标应总是大于绿色的时间指标"},
		{"YELLOW_TIME_IND_LESS","APP-OR0248 黄灯时间指标应总是小于红色的时间指标"},
		{"RED_TIME_IND_SHUD_GREATER","APP-OR0249 红灯时间指标应总是大于黄色的时间指标"},
		{"CONSENT_TO_BE_OBTAINED","APP-OR0250同意事先订购登记"},
		{"ATLEAST_ONE_PROC_CODE","APP-OR0251 至少一个进程代码是强制性的"},
		{"MORE_CODES_NOT_SELECT","APP-OR0252 可以选择超过10个代码"},
		{"MULTI_PRESENTATION_CANNOT_BE_SELECTED","APP-OR0253 不允选多介绍选项"},
		{"REFERRAL_RECORD_NOT_FOUND","APP-OR0254 没有任何记录中找到推荐安装"},
		{"REFERRAL_MORE_THAN_ONE_RECORD","APP-OR0255 一个以上的记录中发现推荐安装"},
		{"NEW_ORDER_CATALOG_BLANK","APP-OR0256 新的医嘱分类不能为空白..."},
		{"NEW_CHARGE_TYPE_BLANK","APP-OR0257 新的费用类型不能为空白"},
		{"CHARGE_TYPE_NOT_SAME","APP-OR0258 存在的费用类型和新的费用类型不相同..."},
		{"CHANGE_CHARGE_TYPE_NO_ACCESS","APP-OR0259 访问权限不退出…"},
		{"COMPLETE_DATE_TIME_CANNOT_BLANK","APP-OR0260 医嘱完成日期不能为空白"},
		{"COMPLETE_DATE_TIME_START_DATE_TIME_CHK","APP-OR0261 医嘱完成日期应大于开始日期"},
		{"COMPLETE_DATE_TIME_SYSDATE_TIME_CHK","APP-OR0262 医嘱完成日期应大于系统日期"},
		{"FUTURE_ORDER_ACTIVATED_LINKED","APP-OR0263未来被激活的订单被链接到当前Encounter ?"},
		{"FUTURE_ORDER_ACTIVATED_CURRENT","APP-OR0264 订单不能激活当前 Encounter"},
		{"FUTURE_ORDER_NOTACTIVATED_CURRENT","APP-OR0265 订单不能激活当前 Encounter"},
		{"CONTINUE_RESULT_REPORT","APP-OR0267 想继续结果报告吗?"},
		{"PROCEDURE_LINK_MAND","APP-OR0268 链接程序是强制性的"},
		{"INVALID_DATE_TIME_FORMAT","APP-OR0269 无效的日期时间格式，有效格式为 dd/mm/yyyy hh:mi:ss"},
		{"OT_MODULE_INSTALLED","APP-OR0270 不能使用此功能，请允许外科手术模块"},
		{"OR_STATUS_CHANGED","APP-OR0271 因为医嘱状态已经被其他用户更改，不能操作此功能"},
		{"OR_REPORT_PRACT_CHANGE_TO_OTHER","APP-OR0272 继续相同的报告医生的其他结果"},
		{"OR_ORDER_TRACKING_MANDATORY","APP-OR0273 在病人的医嘱类型位置中，至少选择一个查询标准"},
		{"DUPLICATE_FIELD_MNEMONIC","APP-OR0274 助字符字段的重复值"},
		{"OPTION_SELECTED","APP-OR0276 操作不能再次选择...."},
		{"PRINT_LOC1_AND_LOC2","APP-OR0277 在目的路由打印的Loc1 and Loc2 不能空白"},
		{"PRINT_DEST_URG_START","APP-OR0278 Print at Destination Urg/Stat for Loc1 and Loc2 cannot be blank"},
		{"PRINT_DEPT_AT_LOC1_LOC2","APP-OR0279 Print at Department Routine for Loc1 and Loc2 cannot be blank"},
		{"PRINT_DEPT_URG_START","APP-OR0280 Print at Department Urg/Stat for Loc1 and Loc2 cannot be blank"},
		{"PRINT_AT_OTHER_LOC","APP-OR0281 Print at Other Location Routine for Loc1 and Loc2 cannot be blank"},
		{"PRINT_AT_OTHER_URG_START","APP-OR0282 Print at Other Location Urg/Stat for Loc1 and Loc2 cannot be blank"},
		{"START_TIME","APP-OR0283 开始时间不能为空"},
		{"START_DATE","APP-OR0284 开始日期不能为空"},
		{"IMAGE_LINK_ALREADY_EXISTS","APP-OR0285 图像链接已存在"},
		{"ORDER_ID_GENERATION_PATIENT","APP-OR0286 病人的医嘱号产生"},
		{"DUPLICATE_SEQ_NO","APP-OR0287 存在重复的序列号"},
		{"VERIFICATION_SUCCESS","APP-OR0288 验证成功"},
		{"NUM_CANT_BLANK","APP-OR0290 号码不能由零开始"},
		{"ONLY_POSITIVE_INTEGERS","APP-OR0291 除了0只有正数允许"},
		{"SEQUENCE_NUMBER_FOR_CHKBOX","APP-OR0292 序列不为复选框应该填补"},
		{"DELETE_CONFIRM","APP-OR0293 确定想删除记录？"},
		{"CONFIRM_ZOOM","APP-OR0294 你想查看编辑变焦模式 ?"},
		{"CONFIRM_COPY","APP-OR0295 不能复制此订单，想继续吗?"},
		{"FACILITY_BLANK","APP-OR0296 设备不能空白........."},
		{"SERVICE_BLANK","APP-OR0297 服务不能为空"},
		{"TRY_AFTER","APP-OR0298 一段时间后再试"},
		{"TIMENOTCORRECT","APP-OR0299 时间不正确"},
		{"VIEW_CONFIRM","APP-OR0300 你想查阅其他记录吗... 当前选择的数据将丢失"},
		{"CANNOT_SYNC","APP-OR0301 不能同步......"},
		{"NO_OF_CHARACTERS","APP-OR0302 字符数不能超过"},
		{"DO_WANT_VIEW","APP-OR0303 想查阅?"},
		{"NEW_ORDERS_SHOULD_BE_SELECTED","APP-OR0304 必须选择新医嘱"},
		{"PRIVILEGE_LEVEL_BLANK","APP-OR0305 权限级别不能空白"},
		{"CONFIRM_SEND","APP-OR0306 想发出?"},
		{"CONFIRM_RESULT","APP-OR0307 想要结果?"},
		{"DATE_MORE_THAN_SYS_DATE","APP-OR0308 日期必须大于等于当前日期"},
		{"REASON_CANT_BLANK","APP-OR0309 原因不能为空白..."},
		{"NUM_OF_CHARACTERS","APP-OR0310 不能超过255 字符.."},
		{"NAME_BLANK","APP-OR0311 名称不能为空白..."},
		{"CONSENT_NOTE_CANT_BLANK","APP-OR0312 同意备注不能空白..."},
		{"DATE_COMPARE","APP-OR0313 日期必须小于等于系统日期"},
		{"FIELD_MNEMONIC_START_WITH","APP-OR0314 助字符字段不能以数字或_开始"},
		{"WRONG_ACSSESS","APP-OR0315 非法进入....."},
		{"FROM_VISIT","APP-OR0316 从就诊"},
		{"COMMENT_CANT_EXCEED_255","APP-OR0317 备注不能超过255 个字符"},
		{"DATE_LESS_SYS_DATE","APP-OR0318 日期应该小于等于系统日期"},
		{"TEXT_CANT_EXCEED_255","APP-OR0319 文字不能超过255个字符。"},
		{"REMARK_CANT_EXCEED_255_CHAR","APP-OR0320 备注不能超过255个字符。"},
		{"NO_MORE_MNEMONICS_SELECTED","APP-OR0321 没有更多的助记符可以选择"},
		{"REPORTING_DATE_BLANK","APP-OR0322 报告日期不能空白…"},
		{"CHECK_ANY_ONE","APP-OR0323 任何一个检查"},
		{"TEXT_MAX","APP-OR0324 文字不能超过（ 1字符"},
		{"PRINT_CONFIRM","APP-OR0325 你想打印此报告"},
		{"CONFIRM_ABNORMAL_RESULT","APP-OR0326 你只想看到异常的结果？"},
		{"CONFIRM_COMPLETE_REVIEW","APP-OR0327你想完成审查？"},
		{"REFUSAL_TYPE","APP-OR0328 拒绝类型不能空白…"},
		{"MAX_LIMIT_TEXT","APP-OR0329 最高限额的文字是255个字符"},
		{"ATLEAST_ONE_DEFAULT","APP-OR0330 至少一个缺省值被选中"},
		{"NO_RECORDS_TO_RECORD","APP-OR0331 没有结果记录"},
		{"ATLEAST_ONE_CONSENT","APP-OR0332 至少一个同意应选择"},
		{"OR_ORDER_CATALOG_MULTICONSENT_MANDATORY","APP-OR0333请输入所有必要的强制性同意"},
		{"OR_ORDER_CATALOG_MULTICONSENT_CHECKBOX","APP-OR0334 请选择至少一个选择复选框输入同意"},
		{"OR_ORDER_CATALOG_MULTICONSENT","APP-OR0335 请选择一个有效同意"},
		{"NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_EXC_SPEC_COUNT","APP-OR0336 在医嘱发布超过指定计数前，没有记录同意号"},
		{"NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_EXC_SPEC_COUNT","APP-OR0337 在医嘱登记超过指定计数前，没有记录同意号"},
		{"ASSIGN_CONSENT_FORM_TO_RECORD","APP-OR0338 请指派同意书记录"},
		{"DUPLICATE_CONSENT_FORM_NOT_ALLOWED","APP-OR0339 不允许重复的同意书"},
		{"UNCHECK_CONSENT_FORM_CLEAR_ENTERED_CONSENT","APP-OR0340 取消同意书将清除输入内容"},
		{"CHANGING_CONSENT_FORM_CLEAR_ENTERED_CONSENT","APP-OR0341 必变同意书将清除输入内容"},
		{"NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_LESS_THAN_SPEC_COUNT","APP-OR0342 在订购释放少于指定计数前，记录同意号"},
		{"NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_LESS_THAN_SPEC_COUNT","APP-OR0343 在订购登记少于指定计数前，记录同意号"},
		{"NO_OF_CONSENT_RECORDED_BEFOR_BEFOR_ORDER_REALEASE_AND_ORDER_REGISTRATION_LESS_THAN_SPEC_COUNT","APP-OR0344 在订购释放和登记少于指定计数前，记录同意号"},
		{"ATLEAST_ONE_CONSENT_FORM_SHOULD_BE_SELECTED_OR_DEFINED","APP-OR0345至少一个同意书应选择或定义"},
		{"CONSENT_FORM_SELECTED_IS_ALREADY_RECORDED","APP-OR0346 选定的同意书形式已经记录"},
		{"YOU_ARE_NOT_ELIGIBLE_TO_RECORD_THIS_CONSENT","APP-OR0347 你是没有资格记录此同意"},
		{"CHECK_ATLEAST_ONE_CONSENT_FORM_TO_RECORD","APP-OR0348 至少检查一次同意书记录"},
		{"CHECK_DATE_ORDERID_PATIENTID","APP-OR0349 检查！要么日期范围应在一个月内或病人编号或医嘱编号应该输入。"},
		{"OR_ORDER_CATALOG_CONSENT_REQUIRED","APP-OR0350 总的要求同意的数目应该超过一个"},
		{"OR_PRIVILEGE_GROUP_COPY_FROM","APP-OR0351 没有用于复制的值"},
		{"OR_PRIVILEGE_GROUP_UNDO","APP-OR0352 无法执行撤消操作"},
		{"INVALID_BLOOD_TRANS_EXPECTED_DATE","APP-OR0353 无效输血预计日期"},
		{"FUTURE_ORDER_DURATION","APP-OR0354 未来医嘱时间不能空白"},
		{"CONSENT_FOR_BEFORE_REGISTERATION","APP-OR0355 同意之前，登记人数记录"},
		{"CONSENT_FOR_BEFORE_RELEASE","APP-OR0356同意释放前的记录"},
		{"BEFORE_ORDER_RELEASE_CANNOT_BE_MORE_THAN","APP-OR0357 在命令释放不能超过…"},
		{"BEFORE_ORDER_REGISTRATION_CANNOT_BE_MORE_THAN","APP-OR0358 在订单登记人数不能超过…"},
		{"CONSENTS_RECORD_MORE_THAN_COUNT","APP-OR0359 不同意予以记录超过了指定的计数"},
		{"CONSENTS_RECORD_LESS_THAN_COUNT","APP-OR0360 不同意予以记录少于规定的计数"},
		{"NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_MORE_THAN_SPEC_COUNT","APP-OR0361没有同意之前记录命令释放超过指定计数"},
		{"NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_MORE_THAN_SPEC_COUNT","APP-OR0362 没有同意之前记录登记订购以上指定计数"},
		{"DUPLICATE_CONSENTS_NOT_ALLOWED","APP-OR0363 重复的同意书不允许"},
		{"SPECAILTY_SHOULD_NOT_BLANK","APP-OR0364 科室不能为空"},
		{"BILLING_SERVICE_NOT_DEFINED","APP-OR0365 结算服务没有界定为（ 1 ，不能列入地方订购"},
		{"NO_OF_CONSENTS_TO_BE_RECORD_ARE_MORE_THAN_REQUIRED","APP-OR0366 同意数将被纪录超过法定"},
		{"NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_MORE_THAN_SPEC_COUNT","APP-OR0367没有同意之前记录命令释放超过指定计数"},
		{"NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_MORE_THAN_SPEC_COUNT","APP-OR0368 没有同意之前记录登记订购以上指定计数"},
		{"DELETE_NOT_ALLOWED","APP-OR0369 这份名单值标示为无法删除！ -从订购目录和尝试"},
		{"ORDERTRACKING_SEARCH_VALIDATE","APP-OR0370 至少以下条件为真. \n1. 输入的病人编号.\n2. 病态度.\n3. 一周的最大范围"},
		{"REGORDER_SEARCH_VALIDATE","APP-OR0371 至少以下条件为真. \n1. 输入的病人编号.\n2. 输入的医嘱号.\n3. 一周的最大范围\n4. 选择一医嘱分类和一个月的最大期间范围"},
		{"ORDER_SET_EXPLN_TEXT","APP-OR0372 查看订单详细规定"},
		{"ORDER_SET_ADMIN_ROUTE","APP-OR0373 Enter the Route for the Associated Record"},
		{"PAT_CLASS_ENC_ID_NOT_PASSED","APP-OR0374 Encounter ID 和病人级别不能通过."},
		{"ATLEAST_ONE_ALLOWED_TYPE","APP-OR0375 允许类型不能为空"},
		{"ATLEAST_ONE_PRACTITIONER","APP-OR0376 至少选择一个医生"},
		{"ATLEAST_ONE_PRACTITIONER_TYPE","APP-OR0377 至少选择一个医生类型"},
		{"ATLEAST_ONE_RESPONSIBILITY","APP-OR0378 选择至少一个责任"},
		{"SHD_NOT_BE_BLANK","APP-ORO162 病人字号不能为空"},
		{"INVALID_PATIENT","APP-ORO163 无效的病人字号"},
		{"ADDITIONAL_SEARCH_TABNAME_NOT_BLANK","APP-ORO164 用户定义的额外的搜寻的标签名称不能空白"},
		{"ADDITIONAL_SEARCH_SEQNO_NOT_BLANK","APP-ORO165 额外的搜寻的序列号不能空白"},
		{"TICK_SHEETS_TABNAME_NOT_BLANK","APP-ORO166 用户定义的序列号的报价单不能空白"},
		{"TICK_SHEETS_SEQNO_NOT_BLANK","APP-ORO167 序列号的报价单不能空白"},
		{"ORDER_SETS_TABNAME_NOT_BLANK","APP-ORO168 用户定义医嘱设置的序列号不能为空白"},
		{"ORDER_SETS_SEQNO_NOT_BLANK","APP-ORO169 医嘱设置的序列号不能为空白"},
		{"IMAGE_TABNAME_NOT_BLANK","APP-ORO170 用户定义的标签名称不能空白"},
		{"IMAGE_SEQNO_NOT_BLANK","APP-ORO171 图像序列号不能为空"},
		{"PLACE_ORDER_TABNAME_NOT_BLANK","APP-ORO172 用户定义的订购标签不能为空白"},
		{"PLACE_ORDER_SEQNO_NOT_BLANK","APP-ORO173 订单序列号不能为空白"},
		{"ATLEAST_ONE_TAB_SELECTED","APP-ORO220 必须选择一个存在的医嘱或新的医嘱"},
		{"EXISTING_ORDERS_TABNAME_NOT_BLANK","APP-ORO221 用户定义的已存在的订购单标签不能为空"},
		{"NEW_ORDERS_TABNAME_NOT_BLANK","APP-ORO222 用户定义的新订购单的标签名不能为空白"},
		{"EXISTING_ORDER_SEQNO_NOT_BLANK","APP-ORO223 已存在的医嘱序列号不能为空"},
		{"NEW_ORDER_SEQNO_NOT_BLANK","APP-ORO224 新医嘱的序列号不能为空"},//IN029143
		{"ENTER_PIN"			,	"APP-OR0442 Enter the PIN"},//IN029143
		{"INVALID_PIN"			,	"APP-OR0443 Invalid PIN"},//IN029143
		{"PIN_NOT"			,	"APP-OR0444 PIN not available.Please contact System Administrator."},//IN030711
		{"DUPLICATE_RECORDS",	"  Record combination already exists in setup..."}, //CRF 160
		{"DELETE ROWS", "APP-OR0446 Are you sure you want to remove selected rows"}, //IN036069
		{"AUTH_RAD_SCH", "APP-OR0447 Pending for Departmental Authorization, Cannot Proceed"}, //IN035976
		{"LESS_OR_EQUAL_VALIDATE",			 "APP-OR0447 From @ should be less than or equal to To @"}, //IN036491
		{"UPDATE_FUTDAT_CURRDAT_SPECIMEN","APP-OR0449 This action will update the Start Date/Time of the selected future order to Current Date/Time. Click on OK to confirm and RECORD to complete the action."}, //CRF 360 //IN041138
		{"ORDER_ALREADY_VERIFIED"         ,				"APP-OR0450 Order status changed, cannot proceed..." },//IN043143
		{"MAND_CHECK"         ,				"APP-OR0451 Please select atleast one Privilege Group..." },  // LICN_1
		{"DUP_REASON_REQD"         ,				"APP-OR0452 Duplicate Override reason is mandatory..." },  // IN024984
		{"OR_ORDERING_RULE_CHK"         ,		"APP-OR0454 Ordering rule setup exists, cannot proceed... " },  // IN050607
		{"PERIOD_SHOULD_LESS_THAN_YEAR", "APP-OR0455 The selected period should not be more than a Year" }, //IN054381
		{"SPECIMENNO_SELECTED", "APP-OR0456 Specimen no is selected..." }, // IN055737 HSA-CRF-0250.1
		{"SPECIMENNO_IS_NOT_AVAIL", "APP-OR0457 Selected Specimen no is not available in the list..." }, // IN055737 HSA-CRF-0250.1
		{"SPECIMENNO_ALREADY_SELECTED", "APP-OR0458 Selected Specimen no is already added in the list..." }, // IN055737 HSA-CRF-0250.1
		{"SPECIMEN_COLLECTION_ORDER_DATE_WARN",	"APP-OR0459 Date should be greater than or equal to Ordered Date for the Order $$. \n Please Uncheck and check the Auto-Update Collection Date and Time again to continue..."}, //MMS-MD-SCF-0017 [IN060516]
		{"UPDATE_FUTDAT_CURR_SPECIMEN_DATE","APP-OR0460 This action will update the Start Date/Time of the selected future order to Specimen Collection Date/Time. Click on OK to confirm and RECORD to complete the action."}, //IN059646
		{"NOT_AUTHORIZED_TO_VIEW_CONFIDENTIAL_RESULT","APP-OR0461 You are not authorized to view Confidential Result."} ,//IN064215
		{"BARCODE_RPT_SUBMIT_TO_PRINTER"       ,				"APP-OR0462 Barcode report has been Submitted to the Printer" }, //IN063816
		{"AGE_WISE_DATA_REQUIRED"       ,				"APP-OR0463 At least one age group must be included" },//IN062992 
		{"TIME_FRAME_EMPTY_ALERT","APP-OR0464 Time duration shall not be blank. Please enter the Numeric value" },//IN061892
	        {"RECORD_INSERTED","APP-OR0466 Operation Completed Successfully" },//IN065642
			{"OR_DATE_RANGE","APP-OR0467 Date range exceeds a month period." },//IN065642
			{"REPORINGFACILITYBLANK","APP-OR0467 Please select the Reporting facility." },//IN065642
			{"NO_RECORDS_HAVE_BEEN_SELECTED","APP-OR0468 No records have been selected!!!" },//IN065642
			{"ASSIGNEDPRACTATIONERBLANK","APP-OR0469 Please select the Assign radiologist." },//IN065642
				{"ORDER_RESTRICT_AE_AND_OP_ENCOUNTER","APP-OR0470 Patient has an active admission. Orders for Open AE encounter cannot be placed"},//IN063719
			{"OCC_NO_CANNOT_BLANK","APP-OR0471 Occurance no cannot be blank" },//IN68241
			{"DUPLICATE_OCC_NO","APP-OR0472 Contains duplicate Occurrance No" },//IN68241
			{"DUPLICATE_OCC_NO_SHLD_NOT_SELECT","APP-OR0473 Duplicate Occurrance No cannot be selected" },//IN68241
			{"MULTI_DOSAGE_TYPE_CONFIG","APP-OR0474 This catalog has multi Dosage Type configuration" },//IN68241
			{"ORDERSET_INCORRECT_CATALOG_COMB","APP-OR0475 Selected order catalogs not assigned to selected facilitty, so cannot create order set" },//IN068370,IN068373
			{"ATLEAST_ONE_FAC_SHLD_BE_MAPPED","APP-OR0476 Atleast one facility should be mapped" },//IN068370,IN068373
			{"ATLEAST_ONE_SPECIALTY_TO_BE_SELECTED","APP-OR0477 At least one Specialty to be selected" },//IN69021
			{"ATLEAST_ONE_ORDER_CATEGORY_TO_BE_SELECTED","APP-OR0478 At least one Order Category to be selected" },//IN69021
			{"ATLEAST_ONE_PATIENT_CLASS_TO_BE_SELECTED","APP-OR0479 At least one Patient Class to be selected" },//IN69021
			{"DIAG_NOT_RECORDED","APP-OR0480 Patient Diagnosis not recorded, please complete to proceed further." },//IN69027
			{"NO_VIDEO_FILES_TO_LINK","APP-OR0477 No Video Files to Link" }

	};
}			
