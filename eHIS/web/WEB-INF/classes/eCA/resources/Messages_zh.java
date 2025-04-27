/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------------------------------------------
?             100            ?           	created
04/03/2013	IN037676		Dinesh T		Signing the addendum is controlled by the note type parameter.
15/03/2013  IN038579		Nijitha         CRF-CA-CHL-CRF-0006/05-Redefine summary Component-> System is displaying error message 	even after entering data for User Defined description.
06/06/2014	IN037701		Chowminya		 SKR-CRF-0036
01/10/2014  IN051373		Chowminya       Patient List By PPR Relationship Issue 
12/04/2015	IN048704	 	Nijitha S		HSA-CRF-0175
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
03/07/2015	IN052940		Ramesh G								In Clinical note there should be an option to auto fetch/Copy data from same template 
																	if filled up earlier for same patient in template format.
21/12/2015	IN058155		Krishna Gowtham J 						 Limit on chart section - 99 rows only allowed
10/01/2017	IN062564		Raja S			12/01/2017	Ramesh G	MO-GN-5511
27/06/2017	IN064566		Raja S			27/06/2017	Ramesh G	PMG2017-GHL-CRF-0005
13/07/2016	IN061885		Krishna Gowtham	13/07/2017		Ramesh G				ML-MMOH-CRF-0537
27/07/2017	IN061891		Raja S			27/07/2017		Ramesh G		ML-MMOH-CRF-0543
06/11/2017	IN065070		Raja S			02/11/2017		Ramesh G		ML-MMOH-CRF-0623.1
23/11/2017	IN061897		Raja S			23/11/2017		Ramesh G		ML-MMOH-CRF-0549
05/12/2017	IN065683		Ramesh G										Vaccination Schedule getting automatically generated 																			on opening patient chart in CA
22/01/2018	IN063931		Prakash C	23/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)
22/01/2018  IN062606        Sharanraj       01/02/2018      Ramesh G        ML-MMOH-CRF-0726
12/02/2018  IN066647        Sharanraj       13/02/2018      Ramesh G        CA-ML-MMOH-CRF-0726/05
09/02/2018  IN065910        Sharanraj                       Ramesh G        GHL-CRF-0494
11/05/2018	IN063838		Ramesh G									ML-MMOH-CRF-0813
10/05/2018 IN065341             Sivabagyam M        10/05/2018  	Ramesh G        MMS-DM-CRF-0115
22/05/2018	IN067607		Raja S			22/05/2018	Ramesh G		ML-MMOH-CRF-1130.2
05/06/2018	IN67872			Dinesh T		05/06/2018	Ramesh G		GHL-CRF-0497.1	
07/08/2018	IN063818		Raja S			07/08/2018	Ramesh G		MMS-DM-CRF-0102
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
12/11/2018  IN059704        PRATHYUSHA   12/11/2018          Ramesh G      AAKH-CRF-0079.2	
06/04/2020	IN072674		Durga Natarajan		07/04/2020		Ramesh G		MMS-KH-CRF-0032
19/05/2020	IN070345		Ramesh Goli		19/05/2020		Ramesh G		MO-CRF-20147.1
--------------------------------------------------------------------------------------------------------------
*/
package eCA.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
			{"INVALID_DIAG_DATE","APP-CA0001 诊断日期必须在入院日期以�?�出院日期/系统日期之间"},
			{"CLOSED_CONSULTATION","APP-CA0002 这个病人咨询已�?结�?�"},
			{"UPDATION_PERIOD_EXPIRED","APP-CA0003 �?许期�?�，�?能更新细节"},
			{"AUTHORIZE","APP-CA0005 未�?授�?�添加�?感的诊断，需�?授�?�"},
			{"NOTEGROUP_NOTETYPE","APP-000005 Note Group/Note Type for the symbol group Cannot be Blank."}, //added for CA SYMBOL Group warning message IN041021
			{"INVALID_BLOCK_DATE","APP-CA0006 日期时间应大于或等于出院日期"},
			{"DEFINE_MR_PARAM","APP-CA0007 MR �?�数未定义. 定义继续"},
			{"ONDATE_GREATER_VISIT_DATE","APP-CA0008 回�?�日期 应该大于等于就诊日期"},
			{"DECEASED_ONLY","APP-CA0009 本说明�?�适用于死亡患者"},
			{"FITDATE_GREATER_VISIT_DATE","APP-CA0010 就�?�日期应该大于等于就诊日期"},
			{"OP_PARAM_NOT_FOUND","APP-CA0011 严�?错误! OP�?�数记录未找到 - 设置继续"},
			{"INVALID_FROM_PAST_VISIT_DATE","APP-CA0012过去就诊日期应该在�?许期�?中"},
			{"INVALID_FROM_DISCHARGE_DATE","APP-CA0013 开始日期应该在�?许期�?中"},
			{"EITHER_ONE_APPT_TYPE_MUST","APP-CA0014 查询时，至少选择一个预约类型"},
			{"DIS_ADV_NOT_EXISTS","APP-CA0015 此病人还未有出院通知"},
			{"ONE_DIS_SUMM_ONLY","APP-CA0016 此病人已有出院�?结"},
			{"ONE_EPSD_SUMM_ONLY","APP-CA0017 Episode总结已为这次就诊�?�准备"},
			{"FORWARD_NOT_NULL","APP-CA0018 �?��?�?�?许为空"},
			{"NO_DECIMAL","APP-CA0019 �?�?许�?数值"},
			{"INVALID_PRECISION","APP-CA0020 无效精度"},
			{"MINIMUM_DIGITS","APP-CA0021 $的最�?数值应该为"},
			{"MAXIMUM_DIGITS","APP-CA0022 最大值应该为"},
			{"INVALID_ON_DATE","APP-CA0023 日期应该大于等于系统日期"},
			{"INVALID_DATE_FMT","APP-CA0024 无效的日期格�?[日期格�?: DD/MM/YYYY]"},
			{"INVALID_TIME_FMT","APP-CA0025 无效的时间格�? [时间格�?: HH24:MI]"},
			{"INVALID_DATE_TIME","APP-CA0026 无效的时间格�? [格�?必须为: DD/MM/YYYY HH24:MI]"},
			{"MORE_THAN_ONE_NOT_ALLOWED","APP-CA0029此分类�?�?许超过一个以上的说明类型"},
			{"OP_NOTE_TYPE_NOT_EXISTS","APP-CA0030 缺�?�?结类型�?存在，�?�系系统管�?�员"},
			{"IP_NOTE_TYPE_NOT_EXISTS","APP-CA0031 缺�?出院�?结类型�?存在，�?�系系统管�?�员"},
			{"RL_NOTE_TYPE_NOT_EXISTS","APP-CA0032 推�??信中没有说明类型设置， �?�系系统管�?�员"},
			{"MORE_THAN_TWO_NOT_ALLOWED","APP-CA0033 此分类�?�?许超过２个以上的说明类型"},
			{"MORE_THAN_FOUR_NOT_ALLOWED","APP-CA0034 此分类�?�?许超过４个以上的说明类型"},
			{"DIAG_AUTH_REQD","APP-CA0035 对�?起，您没有�?�力选择�?感的诊断"},
			{"CA_HIGH_RISK_PREV","APP-CA0036 对�?起，您没有�?�力查看高风险状�?"},
			{"CA_DIAG_PROCEDURE","APP-CA0037 指定的ＩＰ�?ＯＰ�?�数中，你没有超过�?制的�?�力"},
			{"CA_SEC_FORMULA_VAL","APP-CA0038 输入一个值"},
			{"MORE_ROW_VALUE_NOT_ALLOWED","APP-CA0039 行的�?置应该在�?制范围内"},
			{"MORE_COL_VALUE_NOT_ALLOWED","APP-CA0040 列的�?置应该在�?制范围内"},
			{"MORE_ROW_SPAN_NOT_ALLOWED","APP-CA0041 行�?应该在�?制范围内"},
			{"MORE_COL_SPAN_NOT_ALLOWED","APP-CA0042 列�?应该在�?制范围内"},
			{"CANT_LOCATE_POSISTION","APP-CA0043 �?能定�?"},
			{"ROW_SPAN_NOT_BLANK","APP-CA0044 行�?�?能为空"},
			{"COL_SPAN_NOT_BLANK","APP-CA0045 列�?�?能为空"},
			{"COL_POS_NOT_BLANK","APP-CA0047 列�?置�?能为空"},
			{"SUMMARY_NOT_BLANK","APP-CA0048 汇总�??述�?能为焢"},
			{"WRONG_ROW_COLUMN_VALUES","APP-CA0049 行列�?置的错误值"},
			{"VALUE_NOT_GREATER_THAN_9","APP-CA0050 值�?应该大于9"},
			{"ROWCOL_POS_SPAN_NOT_BLANK","APP-CA0051 行列�?置值�?能为空"},
			{"DTL_DFN_INCOMP","APP-CA0052 详细定义�?完整"},
			{"HOME_PAGE_PRACT_TYPE","APP-CA0053 医生类型必须输入"},
			{"ROWS_COLUMS_EMPTY","APP-CA0054 行或列�?能为空或0"},
			{"NOTE_ALREADY_EXISTS","APP-CA0055 已�?选择主诉"},
			{"START_GR_EQ_VISIT","APP-CA0056 开始日期必须大于等于就诊日期"},
			{"SEQUENCE_NOT_ZERO","APP-CA0058 �?列�?��?能为0或负数或者空"},
			{"SECTION_NOT_BLANK","APP-CA0059 科�?能空白"},
			{"POSITIVE_NUMBER_ALLOWED","APP-CA0060 �?��?许输入正数"},
			{"PRACTITIONER_CANNOT_BE_BLANK","APP-CA0061 医生类型�?能为空"},
			{"RECORD_CANNOT_DELETE","APP-CA0062 记录�?能被删除"},
			{"BACKDATE_NOT_ZERO","APP-CA0063 返回日期�?能为0"},
			{"NO_SPECIAL_CHARACTER","APP-CA0065 返回日期�?能有特殊字符"},
			{"ROW_COL_NOT_DEF","APP-CA0066 行列值未正确定义"},
			{"ACTIVE_RELN_PRESENT","APP-CA0067 病人的积级关系"},
			{"IMAGE_ENTERED_WITH_EMPTY_NOTE","APP-CA0068 图�?内容已�?被编辑，清除内容，继续?"},
			{"CHART_CANNOT_BLANK","APP-CA0069 图表�?能为空"},
			{"DUPLICATE_SEQUENCE_NUMBER","APP-CA0070 �?�?的�?�?�"},
			{"INVALID_TIME_HOUR","APP-CA0072 时间输入无效，必须在0~23之间"},
			{"INVALID_TIME_MINUTE","APP-CA0073 分钟输入无效，必须在0~59之间"},
			{"CHART_COMPONENT_EXISTS","APP-CA0074 图表组件已存在，选择�?�一组件"},
			{"CHECK_SEQUENCE_NUMBER","APP-CA0075 点击�?选框�?��?�用的文字输入的命令�?列�?�"},
			{"SUMMARY_TYPE_NOT_BLANK","APP-CA0076 汇总类型�?能为空"},
			{"DISCRETE_MEASURE_NOT_BLANK","APP-CA0077 选定类型概�?的离散措施�?能空白"},
			{"SUMMARY_COLUMN_NOT_BLANK","APP-CA0078 汇总列�?能为空"},
			{"RECORD_TIME_EXISTS","APP-CA0080 记录已存在"},
			{"INVALID_DIAG_CODE_FOR_PATIENT","APP-CA0081 此病人�?适用于此诊断"},
			{"NO_GRAPH_SELECTED","APP-CA0082 没有选中图表事件"},
			{"RECORD_TIME_NOT_BLANK","APP-CA0083 日期时间记录�?能为空"},
			{"ATTEND_PRACT_NOT_ASSIGNED","APP-CA0084 主治医生未分�?，�?能�?作"},
			{"DUPLICATE_SUMMARY_COLUMN","APP-CA0085 �?�?的汇总列"},
			{"INVALID_TIME_HOUR_GR","APP-CA0086 时间输入大于当�?时间"},
			{"INPUT_GREATER_THAN_TABLE_TIME","APP-CA0087 输入时间�?于所有的记录时间"},
			{"CANCEL_CHARTING_TRANSACTION","APP-CA0088 请从列表中选择一个图表以继续完�?交易"},
			{"REVERSE_SUMMARY_SELECTION","APP-CA0089 此动作将会清除所有的总结值... 继续�?�?"},
			{"CHOOSE_AT_LEAST_ONE_ITEM","APP-CA0090 请从项目列表中至少选择一�?�项目"},
			{"VAL_NOT_BLANK","APP-CA0091 定值�?能为空"},
			{"FROM_DATE_GREATER_SYSDATE","APP-CA0093 开始时间�?能大于当�?时间"},
			{"SCOPE_NOT_ZERO","APP-CA0094 范围�?能为0或负数"},
			{"DATE_TIME_NOT_BLANK","APP-CA0095 日期字段�?能为空"},
			{"PERFORMED_NOT_BLANK","APP-CA0097 医生字段�?能为空"},
			{"REASON_NOT_BLANK","APP-CA0098 原因字段�?能为空"},
			{"DATE_TIME_GREATER_SYSDATE","APP-CA0099 日期时间�?能大于当�?日期"},
			{"TASK_NOT_BLANK","APP-CA0100 任务类型�?能为空"},
			{"TASK_TYPE_NOT_BLANK","APP-CA0101 任务�?能为空"},
			{"INVALID_TIME_HOUR_LESS","APP-CA0102 输入时间�?能�?于当�?时间"},
			{"SCOPE_GREATER_THAN_LIMIT","APP-CA0103 �?�?许输入的值超过�?制的范围.请更改最大�?制"},
			{"ENCOUNTER_ID_INVALID","APP-CA0104 无效的 Encounter Id"},
			{"LOCN_PATIENT_ENCTR_BLANK","APP-CA0106 必须至少输入一个�?置或病人编�?�或 Encounter Id 标准"},
			{"NUM_ALLOWED","APP-CA0107 �?�能输入数字"},
			{"ONSET_DATE_GREATER_SYSDATE","APP-CA0108 日期�?能大于系统日期"},
			{"DIAG_NOT_AVAILABLE","APP-CA0109 诊断代�?�?适用"},
			{"DUP_COMP_WITH_ANAL","APP-CA0111 你�?能有相�?�的包括�?�?分�?的组件"},
			{"PROC_ALREADY_EXISTS","APP-CA0112 进程已存在，继续�?�？"},
			{"ANAES_ALREADY_CHOSEN","APP-CA0113 麻醉师已选中"},
			{"CLEAR_HIST_VALS","APP-CA0114 这一动作将和历�?�内容脱节，继续�?�. ?"},
			{"CLIN_EVENT_BLANK","APP-CA0115 诊所事件�?能为空"},
			{"TIME_FRAME_VAL_BLANK","APP-CA0116 帧值�?能为空或0"},
			{"TIME_FRAME_UNIT_BLANK","APP-CA0117 时间帧�?能为空"},
			{"LINK_HIST_VAL_BLANK","APP-CA0118 链接历�?�元素�?能空白"},
			{"CLOSE_ALL_CHARTS","APP-CA0120 一个或多个病人图开放-请关闭"},
			{"NO_PATIENT_SELECTED","APP-CA0121 没有病人目�?开设图表切�?�"},
			{"NO_EVENTS_SELECTED","APP-CA0122 请选择一个事件"},
			{"NO_OF_EVENTS_MORE_THAN_10","APP-CA0123 �?�?许超过10个事情"},
			{"URL_CHECK","APP-CA0124 �?�系系统管�?�员.没有界定的网�?�中的应用"},
			{"INVALID_IMAGE","APP-CA0125 无效的文件�??"},
			{"STARTDT_LESS_ENDDT","APP-CA0126 开始日期应该�?于等于终止日期"},
			{"NO_DISCR_MSR","APP-CA0128 没有离散元素与记录"},
			{"NO_BATTERY","APP-CA0129 电池未定义"},
			{"SPECIALITY_NOT_BLANK","APP-CA0130 科别�?能为空"},
			{"ATLEAT_ONE_VITAL_DATA_REQ","APP-CA0131 至少输入一个�?�?数�?�"},
			{"VAL_NOT_ZERO","APP-CA0132 值�?能为0"},
			{"VAL_NOT_MODIFIED","APP-CA0133 值未修改"},
			{"ACTION_CLEARS_VALUES","APP-CA0134 此动作将会清除所有值，继续�?�?"},
			{"ATLEAST_ONE_VAL","APP-CA0135 至少输入一个值"},
			{"MIN_ROW_VAL","APP-CA0136 轮�?��?能超过最�?值"},
			{"MAX_ROW_VAL","APP-CA0137 轮�?��?能超过最大值"},
			{"ASS_DIAG_UNIQUE_CHK","APP-CA0138 请输入一个唯一的分�?代�?"},
			{"ASS_DIAG_IN_SUF_DATA","APP-CA0139 输入日期�?够"},
			{"CLEAR","APP-CA0140 费用将清空定义的公�?�"},
			{"FROM_TO_DATE_NOT_BLANK","APP-CA0141 起止日期�?能为空"},
			{"FROM_DATE_NOT_BLANK","APP-CA0142 开始日期�?能为空"},
			{"TO_DATE_NOT_BLANK","APP-CA0143 终止日期�?能为空"},
			{"NO_GRAPH_EVENTS_MORE","APP-CA0144 一组�?能超过10个图表"},
			{"NEWBORN_DISPLAY_CRITERIA","APP-CA0145 必须检查至少一个显示标准"},
			{"FUNC_NOT_APPLICABLE","APP-CA0146 �?适用此功能"},
			{"FILE_NOT_SUPPORTED","APP-CA0147 当�?版本�?支�?选择的文件类型，请试�?�选一个有效的类型"},
			{"FILE_SIZE_NOT_SUPPORTED","APP-CA0148 选择文件大�?超过�?制，请选一个�?的文件"},
			{"CONTRID","APP-CA0149 选择起作用的系统"},
			{"RECORD_INSERTED","APP-CA0150 �?作已完�?"},
			{"DELETE_NOTE","APP-CA0151 选择的注释被删除....确认?"},
			{"LESS_THAN_BDAY_DATE","APP-CA0152 开始日期�?能在出生日期�?"},
			{"PRACT_SAME","APP-CA0153 �?�样的医生�?能被选两次"},
			{"CHIEF_COMPL_NOT_ALLOWED","APP-CA0154 �?�有一节�?�标示为主诉"},
			{"INVALID_NOTES_DATE","APP-CA0155 注解日期必须在�?许回溯日期和当�?日期之间"},
			{"ATLEAST_ONE_CHILD_MENU","APP-CA0156 在�?应有任何�?��?�项下的�?�?��?�。请更正，并�?试一次"},
			{"ALRGY_ALREADY_SELECTED","APP-CA0157 已�?选择了一个过�?�??述"},
			{"MIN_ONE_ITEM_SEL_REQ","APP-CA0158 至少选择一个项目"},
			{"MIN_ONE_TASK_SEL_REQ","APP-CA0159 至少包括一个任务"},
			{"DET_DEF_INCOMPLETE","APP-CA0161 明细未完全定义"},
			{"END_DATE_VALIDATION","APP-CA0163 终止日期应该�?于等于当�?日期"},
			{"END_TIME_LESS_START_TIME","APP-CA0164终止时间�?应该�?于开始时间"},
			{"END_TIME_MORE_SYS_TIME","APP-CA0165 终止时间�?应该大于系统时间"},
			{"EVENT_CODE_NOT_BLANK","APP-CA0166 事件代�?�?能为空"},
			{"EVENT_END_DATE_VALID","APP-CA0167 事件终止日期应该大于等于事件开始日期"},
			{"EVENT_GROUP_NOT_BLANK","APP-CA0168 事件组�?能为空"},
			{"EXP_INVALID","APP-CA0169 表达�?无效"},
			{"FROM_DATE_GREAT_SYS","APP-CA0170 开始日期应该大于等于当�?日期"},
			{"FROM_DATE_GREAT_EFF","APP-CA0171 开始日期应该大于生效的终止日期"},
			{"FROM_DATE_MORE_BIRTH","APP-CA0172 开始日期应该大于出生日期"},
			{"INVALID_MATRIX_COLUMN_VALUES","APP-CA0176 无效的矩阵间隔值"},
			{"LAST_CHAR_NOT_NUMBER","APP-CA0177 最�?�一个字符�?能为数字"},
			{"MABP_LESS_ICP","APP-CA0178 MABP �?能�?于 ICP"},
			{"MONTHS_VALIDATION","APP-CA0179 月份�?能大于 11"},
			{"NO_USER_FOUND","APP-CA0182 用户未找到"},
			{"NO_USERS_FOR_GROUP","APP-CA0183 没有用户被�?许这个组"},
			{"ONLY_NUMBER_ALLOWED","APP-CA0184 �?�能输入数字"},
			{"GRIDID_DESC_VALID","APP-CA0187 定义�?请输入网络编�?�以�?�简短�??述"},
			{"MATRIXID_DESC_VALID","APP-CA0188 定义�?请输入一个矩阵代�?以�?�简短�??述"},
			{"ENSURE_SELECTION","APP-CA0189请�?�一个选择"},
			{"EVENTS_FOR_QUICKTEXT","APP-CA0190 请选择一个事件，输入文本"},
			{"SEL_RECORD_FOR_DELETION","APP-CA0191 请选择记录删除"},
			{"SELECT_PLEASE","APP-CA0192 请选择"},
			{"NO_TABLE_RETURN_RECORDS","APP-CA0193 在这个表格�?中�?�?许记录返回"},
			{"REMARKS_CANNOT_BLANK","APP-CA0194 备注�?能为空"},
			{"ROW_CANNON_BLANK","APP-CA0195 行�?置�?能为空"},
			{"SELECT_ANY_VALUE","APP-CA0196 选择任一值"},
			{"AJAX_ERROR","APP-CA0197 Sorry. 这是个错误"},
			{"STAR_DATE_LESS_END_DATE","APP-CA0198 开始时间�?能�?于终止时间"},
			{"START_TIME_LESS_END_TIME","APP-CA0199 开始时间�?能大于终止时间"},
			{"START_TIME_LESS_SYS_TIME","APP-CA0200 开始时间�?能大于系统时间"},
			{"PRACT_CHOSEN","APP-CA0203 医生已选择"},
			{"TO_DATE_LESS_EFF_DATE","APP-CA0204 终止日期应该�?于生效终止日期"},
			{"VERIFY_OK","APP-CA0206 确认�?功"},
			{"ONLY_ONE_DEFAULT_IMAGE","APP-CA0210 你被�?许�?�有一个缺�?图�?"},
			{"NO_AUTH_SENSITIVE_DIAGNOSIS","APP-CA0211 你没有被授�?�查看�?感诊断明细"},
			{"MAX_3LOOKUP","APP-CA0212 你�?�以有最多打开3个查询窗�?�"},
			{"MAX_2LOOKUP","APP-CA0213 你�?�以有最多打开2个查询窗�?�"},
			{"NO_DEFAULT_IMAGE","APP-CA0214 没有缺�?的任何图�?"},
			{"NO_IMAGE_ASSOCIATED","APP-CA0215 没有选择任何图�?链接"},
			{"IMAGE_DEFAULT_SELECTION","APP-CA0216 已�?选择缺�?的图�?"},
			{"ERR_IN_COMMITING","APP-CA0217 �??交失败"},
			{"NO_IND_NUR_RELATIONSHIP","APP-CA0219 未定义间接的护�?�关系，�?�系管�?�员"},
			{"RMRKS_MAX_LENGTH","APP-CA0220 备注列超过最大�?制"},
			{"INVALID_CLOSE_DATE","APP-CA0221 关闭日期必须在开始日期和当�?日期之彰"},
			{"INVALID_ONSET_DATE","APP-CA0222 开始日期必须�?于等于当�?日期"},
			{"GROUPBY_NOT_BLANK","APP-CA0223 排�?�?能为空"},
			{"FAILED_TRANSACTION","APP-CA0224 交易�?能完�?"},
			{"DTP_PAT_CHART_SEL","APP-CA0225 必须选择桌�?�或病人图表"},
			{"SEL_COMB_APPL_EXISTS","APP-CA0226 当�?指定的组�?�已链接到应用程�?"},
			{"ONLY_MAX_CHARS","APP-CA0227 �?�?许输入超过$$个字符"},
			{"LOCN_USER_SPEC_LOCN","APP-CA0228 用户已有指定的�?置设置"},
			{"CLINIC_USER_HIGHER_EXIST","APP-CA0229 用户存在指定的诊所�?特�?�"},
			{"NUNIT_USER_HIGHER_EXIST","APP-CA0230 用户存在指定的护�?��?��?�?特�?�"},
			{"LOCN_USER_SETTING_EXIST","APP-CA0231 用户设置已存在"},
			{"TO_DT_GR_EQ_FM_DT","APP-CA0232 终止日期必须大于等于开始日期"},
			{"NOTE_IN_USE","APP-CA0233 注释类型�?能删除"},
			{"RECORD_DELETED","APP-CA0234 记录删 除"},
			{"DUP_ENT_NOT_ALLOWED","APP-CA0235 �?�?许�?�?输入"},
			{"EXP_VALID","APP-CA0236 表达�?无效"},
			{"HIGH_PRI_EXIST","APP-CA0237 用户存在高级特�?�"},
			{"DELETE_FORMULA_YN","APP-CA0238 删除整个公�?？"},
			{"NOT_DFLT_CHECK_ITEM","APP-CA0239 �?能缺�?未检查项目"},
			{"CLEAR_ASS_FIELDS_CONF","APP-CA0240 �?作将会清空所有字段，继续�?�？"},
			{"MIN_MAX_VALUE_RANGE","APP-CA0241输入值必须在 (1)和 (2)之间"},
			{"EXIST_COMP_OVERLAP","APP-CA0242 组件存在�?�?�"},
			{"EXIST_GROUP_COMP","APP-CA0243 这部分已�?加入了网格�?矩阵控件"},
			{"ALREADY_CHILD_COMP","APP-CA0244 此组件已�?是一个�?组件， \n�?�一组件在模版中"},
			{"COMP_ALREADY_LINKED","APP-CA0245 组件已链接到�?�一个组件"},
			{"IMAGE_ALRDY_EXISTS","APP-CA0246 图�?已存在，继续添加图�?�?�？"},
			{"TRD_PTN_NO_PRACT","APP-CA0247 门急诊�?存在没有医生和病人分类的部分"},
			{"RVT_BAK_WITH_CMTS","APP-CA0248 带备注的回�?"},
			{"CONF_RDT_MAIN_PAGE","APP-CA0249 回到主页？"},
			{"SCHEDULE_BLOCK","APP-CA0250 预约表被�?定"},
			{"NO_SHORT_DESC","APP-CA0251 无简短�??述"},
			{"CL_DATE_NOT_LT_BDATE","APP-CA0252 关闭日期�?能�?于出生日期"},
			{"RELN_REQ_ENC_ID","APP-CA0253 关系�?求 Encounter Id"},
			{"RELN_NOT_ELGIBLE","APP-CA0254 没有建立任何关系的资格，�?�系管�?�员"},
			{"CA_ENC_RELN_NO","APP-CA0255 目�?�?�到的相关功能已�?�用"},
			{"PWD_MISMATCH","APP-CA0256 密�?�?匹�?"},
			{"LMP_DATE_GRT_SYSDATE","APP-CA0257 LMP 日期�?能大于系统日期"},
			{"EVENT_START_GREATER_DOB","APP-CA0258 事件开始日期必须大于病人出生日期"},
			{"EVENT_START_LESS_SYSDATE","APP-CA0259 事件开始日期必须�?于等于当�?日期"},
			{"IMG_TOOL_LD_FATAL_ERROR","APP-CA0260 在安装图�?编辑工具时存在致命错误"},
			{"NO_CHART_FOR_CLINIC","APP-CA0260 诊所未定义图表"},
			{"MAX_NOTES_LIMIT","APP-CA0261 �?许�?个�?�到的记录数已到达�?�?…你�?能�?建一个新注解"},
			{"INSUFFICIENT_PARAMS","APP-CA0262 此功能已�?记录足够的�?�数. �?�系系统管�?�员"},
			{"IMAGE_NOT_FOUND_INLIB","APP-CA0263 选择的图�?�?�?�适. �?�系系统管�?�员."},
			{"IMG_LD_FATAL_ERROR","APP-CA0264 在安装图�?编辑工具时�?�生致命错误，请�?�系管�?�员"},
			{"CONS_NOT_APPL","APP-CA0265 �?适用于此次就诊"},
			{"CANNOT_ASSIGN_ALL_COL","APP-CA0266 分�?的列�?能超过 $$"},
			{"CANNOT_ASSIGN_ALL_LIST","APP-CA0267 �?能分�?超过 $$ 个列表控件"},
			{"SELECT_RECEIPIENT","APP-CA0268 选择一张�?�票"},
			{"DEFINE_NOTE_PARAM","APP-CA0269 未定义说明�?�数"},
			{"NO_PATIENT_ID","APP-CA0270 未给出病人编�?�"},
			{"NOT_VALID_ENCTRD","APP-CA0271 无效设置/Encounter"},
			{"NOT_VALID_PATID","APP-CA0272 无效的病人编�?�"},
			{"INVALID_CA_USER","APP-CA0273 �?是一个有效的CA�?�数，�?�系管�?�员"},
			{"NO_RESP","APP-CA0274 登录用户没有�?�适的�?��?"},
			{"INVALID_USER_PWD","APP-CA0275 �?�法的用户�??�?密�?"},
			{"CONF_FWD","APP-CA0276 确认密�??"},
			{"CONF_SIGN","APP-CA0277 确认签�???"},
			{"CONF_ADDENDUM","APP-CA0278 确认追加?"},
			{"CONF_MARKERROR","APP-CA0279 确认标志一个错误?"},
			{"TEMP_MANDATORY","APP-CA0280 必填值未输入，此�?作将会清空当�?模�?�的修改内容"},
			{"CONF_MODIFY","APP-CA0281 确认修改?"},
			{"CONF_REVIEW","APP-CA0282 确认�?查?"},
			{"OPRN_NOT_PRESERVE_VALUE","APP-CA0283 此次�?作�?�?存当�?修改值"},
			{"IMAGE_WIPE","APP-CA0284 选择�?�外的图�?将会擦掉当�?�?，继续�?�？"},
			{"INVALID_MIN_VAL","APP-CA0285 最�?值必须�?于最大值"},
			{"SINGLE_DIGIT_FOR_NUM","APP-CA0286 �?�个数字�?许整数和�?数"},
			{"INVALID_VAL_ENTERED","APP-CA0287 无效值输入"},
			{"DUPLICATE_SRL_NO","APP-CA0288 �?�?�?列�?�"},
			{"COMBINATION_EXISTS","APP-CA0289 组�?�已存在"},
			{"SPEC_LOCN_OR_PATIENT","APP-CA0290 至少一个查询标准必须输入.\n1. 病人编�?\n2. 主治医生\n3. 科室\n4. $$"},
			{"NO_VITAL_SIGN_BATTERY","APP-CA0291 没有生命体�?电池"},
			{"MIN_ONE_EVENT_TYPE","APP-CA0292 �?院入院或门诊就诊是强制输入的"},
			{"NOTE_CONTENT_NOT_EXISTS","APP-CA0293 注释内容�?能为空"},
			{"LOCN_USER_HIGHER_EXIST","APP-CA0294 用户已设置高级�?��?"},
			{"FORWARD_CLINICIAN_REQUIRED","APP-CA0295 �?瞻性临床需�?"},
			{"CHART_LESS_PREV_REC","APP-CA0296 图表记录日期必须在上次记录日期和当�?日期之间"},
			{"REVIEW_REC_ALREDY_EXISTS","APP-CA0297 文档已�?绑定所选的资�?审查"},
			{"IMAGE_FILE_EXISTS","APP-CA0298 图�?已存在"},
			{"LIMIT_UPTO100_ONLY","APP-CA0299 �?制在100个关键字范围之间"},
			{"XAXIS_YAXIS_DIFFERENT","APP-CA0300 X轴和 Y轴之间必须有所区别"},
			{"NUMBER_NOT_IN_RANGE","APP-CA0301 数字�?在范围内"},
			{"VALUE_FOR_X_NOT_BLANK","APP-CA0302 X 轴值�?能为空"},
			{"VALUE_FOR_Y_NOT_BLANK","APP-CA0303 Y 轴值�?能为空"},
			{"NO_DATA_AVAILABLE","APP-CA0304 数字�?适用于分割图片"},
			{"ENDVAL_LESS_STARTVAL","APP-CA0305 终止值必须大于开始值"},
			{"STARTVALUE_NOT_EXIST","APP-CA0306 开始值�?存在"},
			{"KEYS_NOT_GENERATED","APP-CA0307 �?�值未产生"},
			{"DUP_ELE_TYPE","APP-CA0308 �?�?的无素类型."},
			{"XAXI_YAXI_NOT_SAME","APP-CA0309 X轴值和Y轴值�?�数�?应该相�?�"},
			{"ELE_TYPE_NA","APP-CA0310 元素类型的选择�?适用于此组件"},
			{"NOT_VALID","APP-CA0311 此处应用�?是一个有效的�?作"},
			{"PAT_UNASSIGN","APP-CA0312 病人未分�?医生，继续分�?�?�？"},
			{"NO_COMMON_RELN","APP-CA0313 没有共�?�存在的关系设置与分�?特�?�的登录用户和特�?�按�?选定的医生。�?�系系统管�?�员"},
			{"SEL_MAX_PROB_NA","APP-CA0314 �?�?许超过 $$ 个问题..."},
			{"MONTHS_SHOULD_NOT_EXCEED","APP-CA0315 自动关闭日期�?应该超过12个月 ..."},
			{"DAYS_SHOULD_NOT_EXCEED","APP-CA0315 自动关闭日期�?应该超过31天 ..."},
			{"WEEKS_SHOULD_NOT_EXCEED","APP-CA0315自动关闭日期�?应该超过52周 ..."},
			{"AUTO_CLOSE_PERIOD_NOT_BLANK","APP-CA0316 自动关闭日期�?应该为空..."},
			{"MAX_CHART_EVENTS","APP-CA0317 �?�?许超过 $$个图表事件被选中..."},
			{"MISSING_ENC_PARAM","APP-CA0318 定义 CA �?�数，继续�?作..."},
			{"NO_CHANGES_TO_UPDATE","APP-CA0319 未选择更新"},
			{"DATE_RANGE_FOR_NOTES","APP-CA0322 以下至少一个是正确的...\n 1.一个月的日期范围\n 2.输入的病人�?�"},
			{"COLOR_DESC_NOT_SYNC","APP-CA0323 $$ 和颜色�?�?�步. 你想改 $$颜色?"},
			{"DATE_RANGE_OR_PATID","APP-CA0324 请�??供病人编�?或一月内输入的日期范围."},
			{"DATE_RANGE_OR_PATIENTID","APP-CA0324请�??供病人编�?或一周内输入的日期范围."},
			{"CATEGORY_CANNOT_BLANK","APP-CA0325 目录�?能为空"},
			{"CREATE_SCHEDULE_NOT_BLANK","APP-CA0325 创建进度表�?能为空"},
			{"VACCINE_DUPLICATE_CHECK_DAYS","APP-CA0326 �?�?检查天�?能空白，�?�?检查所需的检查"},
			{"MULTIPLE_SCHEDULE_CHECK","APP-CA0326 选择的进度表中�?�有一个是被�?许的"},
			{"MAXIMUM_ICONS_ALLOWED","APP-CA0327 最大的图标被选中"},
			{"VACCINE_CANNOT_BLANK","APP-CA0327 疫苗编�?��?能为空"},
			{"DEFAULT_CHECK","APP-CA0328 �?能为疫苗选择更多�?置作为缺�?�?置"},
			{"LOCATION_CODE_NOTNULL","APP-CA0328 �?置代�?�?能为空..."},
			{"DATE_DOB_CHECK","APP-CA0329 $$ 必须大于出生日期"},
			{"PATIENT_ID_NOTNULL","APP-CA0329 当查询病人�?作被选中时，病人编�?�?能为空!"},
			{"COMP_TAMPERED","APP-CA0330 组件已被更更乞讨."},
			{"DURATION_CHECK","APP-CA0330 输入周期秘须选择周期类型"},
			{"RESET_DOC_REF_STR","APP-CA0331 回到当�?范围?"},
			{"PREVIOUS_ADM_CHECK","APP-CA0331 如果以�?的管�?�检查，检查�?几天�?能空"},
			{"DURATION_DUPLICATE_CHECK","APP-CA0332 两个记录周期�?�必须相�?�"},
			{"UNSYNCHORINIZED_IMAGE_EXISTS","APP-CA0332 有�?�步图�?�?�考。你想说明现在的网�?�?"},
			{"DO_WANT_VIEW","APP-CA0333 想查看?"},
			{"DURATION_CANNOT_BLANK","APP-CA0333 周期或周期类型�?能为空"},
			{"CHANGES_BANNER_CONTINUE","APP-CA0334 这一行动将�?��?更改。你�?继续�?�"},
			{"DISP_VAL_NOT_GREATER_MAX_VAL","APP-CA0335 显示长度�?能大于最大长度"},
			{"SEQUENCE_NOT_BLANK","APP-CA0336�?列�?��?能为0�?负数或空"},
			{"PAT_MED_RPT_NOT_BLANK","APP-CA0337 病人医疗报告�?能为焢"},
			{"PAT_CLASS_NOT_BLANK","APP-CA0338 请至少选择一个病人级别"},
			{"REPORT_CANT_BE_BLANK","APP-CA0339 报告�?能为空"},
			{"EMAIL_ID_BE_BLANK","APP-CA0340 邮件编�?�?能为空"},
			{"EVENTS_TO_EMAIL","APP-CA0341 请选择事件�?�邮件"},
			{"EVENTS_TO_MANAGE","APP-CA0342 请选择事件管�?�"},
			{"EVENTS_TO_PRINT","APP-CA0342 请选择事件打�?�"},
			{"SELECT_SPECIALITY","APP-CA0343 请选择科室�?�备注"},
			{"EFF_DATES_OVERLAP","APP-CA0344 生效日期和已存在的设置�?�?�"},
			{"REGISTERED_RECIPIENT_CANT_BE_BLANK","APP-CA0345 注册的电�?邮件收件人的细节�?能空白"},
			{"EMAIL_ID_CANT_BE_BLANK","APP-CA0346 邮件ID�?能为空"},
			{"MIN_DIGITS_COMP","APP-CA0347 $$值�?须�?于 ##�?数"},
			{"MIN_ONE_EMAILID_SEL_REQ","APP-CA0348 必须选择至少一件邮件编�?"},
			{"PAT_EMAIL_ID_NOT_NULL","APP-CA0349 病人电�?邮件标识为空，�?能�?�邮件，请更新病人的电�?邮件�?�?试。"},
			{"MAILING_NOT_ALLOWED","APP-CA0350 这份报告是�?�?许的�?�邮件的。检查安装的模�?�-模�?��??称和报告-报告中�??述的组�?�"},
			{"INVALID_EMAIL_ID","APP-CA0351 无效的电�?邮件标识"},
			{"REC_AND_CONTINUE","APP-CA0352 定义结果目录�?，申请明细"},
			{"DEFINE_RESULT_CATEG","APP-CA0353 确认分类结果�?�...?"},
			{"NO_ATTCHMENT_FOUND","APP-CA0354 未�?�现附件"},
			{"NO_MAIL_DATA_FOUND","APP-CA0355 未�?�现邮件数�?�."},
			{"INVALID_EMAIL_ID","APP-CA0356 无效的电�?邮件标识"},
			{"AUTHORIZATION_REQD","APP-CA0357 此邮件需�?授�?�。授 �?��?��?能�?�邮件。你�?继续�?�？"},
			{"ALREADY_ADMINISTERED","APP-CA0358 这�?疫苗以�?已�?管$$ 天. \n 必须有一个时间间隔 ## 天. 继续�?�？"},
			{"CANT_ADMINISTER","APP-CA0359 这�?疫苗以�?已�?管$$ 天. \n 必须有一个时间间隔 ## 天."},
			{"INVALID_OPERATION","APP-CA0360 $ �?是一个有效�?作"},
			{"INVALID_URL","APP-CA0361 无效的URL"},
			{"PAT__NOT_BLANK","APP-CA0362 请至少选择一个病人记录"},
			{"CONS_DESC_EXIST","APP-CA0363 咨询列表说明已�?存在"},
			{"NO_CONS_CATALOG","APP-CA0364 咨询目录是没有�?�系当�?的医生/当�?医生的主�?专业。�?�系管�?�员."},
			{"CONS_LT_CURRDATE","APP-CA0365 咨询日期从当�?日期开始�?能�?于 $天"},
			{"OUTCOME_CLOSE_CURR_CYCLE","APP-MC0320 这一结果将关闭当�?周期.\n想继续�?�?"},
			{"OUTCOME_CLOSE_CURR_EVENT","APP-MC0321 这一结果将关闭当�?事件，创建一个新的事件.\n继续�?�?"},
			{"SELECT_CHART_TYPE","APP-CA0372 Please select the Chart Type."},
			{"VISIT_CANCELLED","APP-CA0373 Visit has been cancelled for this patient, cannot proceed."},//IN032928
			{"CHECK_INSERT_ACCESS",  "APP-CA0375 Record access rights not available for this user."}, //IN030466
			{"CHECK_UPDATE_ACCESS", "APP-CA0376 Update access rights not available for this user."}, //IN030466
			{"CA_HIGH_RISK_PREV_RECORD","APP-CA0398 Sorry You don't have the previlege to record high risk condition"}, //IN037021
			{"CA_MAX_ENCOUNTER_WARNING","APP-CA0399 Number of encounters should not exceed 99."}, //added for CHL-CRF-018 IN035924
			{"CA_SIGN_OTH_ADDENDUM","APP-CA0400 Unsigned Addendum exists, cannot proceed"},//IN037676
			{"CA_SHORT_DESC_BLANK","APP-CA0401 Short Description Cannot Be Blank, cannot proceed"},//IN038579
			{"CA_DIAG_SET_RESET","Change of Diagnosis Set should reset all your entered data. \n Are you sure to change the Diagnosis Set?"},//CRF-028
			{"CA_ALPHA_NUMERIC_SYMBOL","APP-CA0402 Alphanumeric characters and Symbols ( ~ , $ , & , ^) are not allowed."},  //IN041021 
			{"CA_SELECT_MENU","APP-CA0403 Please Select Menu."},//IN043533
			{"CA_VACC_PRINT","APP-CA0404 Please select the events to print."},  //IN045400
				{"CA_ONE_ORDERABLE","APP-CA0405 Select atleast One "},//IN042552
	{"DUP_VITAL_CHK"		 ,	"APP-CA0408 Vital Component Already Exist... "},//IN037701
	{"PAT_DISCHARGED"		 ,	"APP-CA0409 Patient has been Discharged. "},//IN051373
	{"PAT_CHKD_OUT"		 ,	"APP-CA0410 Patient has been Checked Out. "},//IN051373
	{"PAT_ASSIGN_CONFIRM",	"APP-CA0411 Patient is Unassigned to a Physician. Would you like to ?"},//IN048704
	{"COPY_PREVIOUS_NOTE_CONFIRM",	"APP-CA0412 Copying from selected note will clear all filled details from current note. \n\nDo you want to continue ?"},//IN052940
	{"NOTE_FORMAT_CHANGED",	"APP-CA0413 Note Format Changed; Can't copy from past records"},//IN052940
	{"MAX_OF_999","More than 999 Sections are not allowed."},//IN058155
	{"CA_MIN_MAX_TIME_AUTO_REFRESH","APP-CA0414 Please enter the time between 1 min to 99 mins..."},//IN052053
	{"TO_DATE_GREATER_SYSDATE"	,	"APP-CA0415 To Date Should Not Be Greater than Current Date"},//IN062560
	{"FUNC_NOTAPP_RESP_RELN" ,"APP-CA0416 This function is not applicable for this Responsibility/Relationship"},//IN062564
	{"MANDATORY_VALUES" , "APP-CA0417 Current Section Mandatory Values are not entered.."}, //IN064566
	{"CA_MIN_MAX_DAYS_GRACE_PERIOD","APP-CA0418 Please enter the number of days between 1 day to 9 days..."},//IN061885
	{"SELECT_ATLEAST_ONE" ,"APP-CA0419 Select atleast one Record to Remove"},//IN061891	
	{"ADD_PAT_SUCCESS" ,"APP-CA0420 Added Patient to Personalized Patient List Successfully"},//IN061891
	{"SELECT_AEMANAGE_PATQUEUE" ,"APP-CA0421 Please select chart type for the Current Emergency Patients<br>"},//IN065070
	{"SELECT_CHARTTYPE_CA" ,"APP-CA0422 Please select chart type for AE Consultation in Clinician Access<br>"},//IN065070 //66156
	{"SELECT_DEFAULT_CHART" ,"APP-CA0423 Chart Type to be selected to add Default"},//IN061897
	{"CHOOSE_AT_LEAST_ONE_SCHEDULE"		,	"APP-CA0424 Please Select atleast One Schedule." },//IN065683
	{"COPY_PREVIOUS_SECTION_CONFIRM",	"APP-CA0425 Copying from selected section note will clear all filled details from current section. \n\nDo you want to continue ?"},//IN063931
	{"SECTION_FORMAT_CHANGED",	"APP-CA0426 Section Format Changed; Can't copy from past records"},//IN063931
	{"CA_MIN_MAX_HOURS_DURATION" ,"APP-CA0421 Please Enter the Duration Between 0 to 23 Hours"},//IN062606
	{"CA_DATE_RANGE_ONE_WEEK" ,"APP-CA0428 Please Enter Date Range Within One Week..."},//IN066647
	{"CA_DFLT_MIN_MAX_VAL_DAYS" ,"APP-CA0429 Default Values Allowed Shall be Within 1 to 30 Days"},//IN065910
	{"TENNER_STAGING_PENIS_PUBIC"			,	"APP-CA0429 Genital (Penis) Development & Pubic hair cannot be blank"}, //IN063838
	{"TENNER_STAGING_BREAST_PUBIC"			,	"APP-CA0430 Breast Development & Pubic hair cannot be blank"},//IN063838
	{"TENNER_STAGING_BREAST"			,	"APP-CA0431 Breast Development cannot be blank"},//IN063838
	{"TENNER_STAGING_PUBIC"			,	"APP-CA0431 Pubic hair cannot be blank"},//IN063838
	{"CA_CNETRALISED_DEFAULT_DAYS","APP-CA0432 Please enter the number of days between 1 to 999 days"},//IN065341
	{"MYHIX_ALERT" ,"APP-CA0433 Do you want to send Patient Discharge Summary info to MyHix ?"},//IN067607
	{"CONF_MARK_REJECT"				,	"APP-CA0434 Confirm to Mark as Reject?"},//IN67872
	{"CONF_UPDATE" ,"APP-CA0435 Confirm Update?"},//IN063818
	{"NUMBER_TO_BE_ENTERED" ,"APP-CA0436 Please enter the number between 40 to 96"},//IN068669
	{"INSURANCE_NOT_MATCHED" ,"APP-CA0437 No report is configured for this insurance."},//IN059704
	{"PATIENT_ID_CANNOT_BE_BLANK" ,"APP-CA0438 Patient ID cannot be blank."},//IN059704
	{"ENCOUNTER_ID_CANNOT_BE_BLANK" ,"APP-CA0439 Encounter ID cannot be blank."},//IN059704
	{"CA_THIRDPARTY_VITALS_TIME_DUR","APP-CA0440 Please enter the number of minutes between 1 to 999."},//IN072674
	{"SHARED_PATH_INCORRECT",". Shared path is either incorrect or is not Read-Write accessible."},//IN070345
	{"PATIENTIDMANDATE","APP-CA0441 Patient ID is mandatory without that user cannot proceed"},//6451
	{"VITAL_SIGN_BED_SEARCH" ,"Bed. No related interfaced vital sign observations shall be moved to respective patient ID: $ and Encounter ID: # Do want to proceed"},//IN017999
	{"VITAL_SIGN_ENCOUNTER_SEARCH" ,"Interfaced vital sign observations shall be moved to respective patient ID: $ and Encounter ID: # Do want to proceed"},//IN017999
	{"URL_NOT_INST_IN_USER_MACHINE" ,"APP-CA0442 URL shall not work, as it is not installed in user machine with applicable browser"} //IN27710
	
	};
}			
