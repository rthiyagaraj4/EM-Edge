package eAM.resources;
import java.util.*;

public class Messages_ar extends ListResourceBundle implements java.io.Serializable
{
	public Object[][] getContents() 
	{
		return contents;
	}

	static final Object[][] contents = 
		{
{"TO_AGE_LESS_FM_AGE","APP-AM0001 لعمر لا يمكن أن يكون أقل من من العمر"},
{"FM_AGE_LESS_PREV_TO_AGE","APP-AM0002 لا يمكن أن يكون من العمر أقل من العمر السابق"},
{"TO_AGE_GR_NEXT_FM_AGE","APP-AM0003 حتى العمر لا يمكن أن يكون أكثر من من العمر التالي"},
{"INVALID_AGE_DAYS","APP-AM0004 يجب أن يتراوح النطاق العمري بين 1 و 90 للوحدة العمرية - اليوم"},
{"INVALID_AGE_MONTH","APP-AM0005 يجب أن يكون النطاق العمري بين 3 و 11 للوحدة العمرية - الشهر"},
{"INVALID_AGE_YEAR","APP-AM0006 يجب أن يتراوح النطاق العمري بين 1 و 150 للوحدة العمرية - السنة"},
{"OS_CANNOT_DELETED_LOCN_EXIST","APP-AM0007 المواقع مرفقة"},
{"OVERLAP_USER_OPER_STN","APP-AM0008 تتداخل التواريخ الفعالة مع الإعداد الحالي"},
{"DEPT_CANNOT_SPECIFIED","APP-AM0009  يمكن تخصيص قسم واحد فقط للإقامة / غرفة العمليات / غرفة الفحص"},
{"DUPLICATE_NATIONAL_ID","APP-AM0010 هوية الجنسية مكررة"},
{"DOC_TYPE_EXISTS","APP-AM0011 نوع المستند موجود بالفعل"},
{"NEXT_NUMBER_CHECK","APP-AM0012 يجب أن يكون الرقم التالي أكبر من الرقم الأصلي"},
{"VALID_YEAR_CHECK","APP-AM0013 أدخل سنة صالحة"},
{"YEAR_GR_CURR_YEAR_CHECK","APP-AM0014 يجب أن تكون السنة أكبر من أو تساوي السنة الحالية"},
{"OS_CANNOT_DELETED_USER_EXIST","APP-AM0015 المستخدمون مرفقون"},
{"OS_CANNOT_DELETED_RSTRN_EXIST","APP-AM0016 القيود مرفقة"},
{"EFF_DATE_LESS_SYSDATE","APP-AM0017 لا يمكن أن يكون تاريخ السريان أقل من التاريخ الحالي"},
{"DESCRIPTION_CHECK_200","APP-AM0018 لا يمكن أن يتجاوز الوصف 200 حرف"},
{"ONE_CHIEF_PER_TEAM","APP-AM0019 يمكن أن يوجد رئيس واحد فقط للفريق"},
{"ROLE_SELECT","APP-AM0020 يجب تحديد الدور"},
{"NEXT_REF_NUMBER_GR_ZERO","APP-AM0021 يجب أن يكون رقم الإحالة التالي أكبر من الصفر"},
{"LENGTH_NOT_EXCEED_60","APP-AM0022 لا يمكن أن يتجاوز الطول 60 حرفًا"},
{"NO_OF_AGE_RANGE","APP-AM0023 يجب أن تتراوح الفئة العمرية بين 1 و 25 عامًا"},
{"NO_OF_WEIGHT_RANGE","APP-AM0024 يجب أن يتراوح نطاق الوزن بين 1 و 25"},
{"TO_WEIGHT_LESS_THAN_FROM","APP-AM0025 لا يمكن أن يكون الوزن أقل من من الوزن"},
{"FR_WEIGHT_LESS_THAN_PR","APP-AM0026 لا يمكن أن يكون من الوزن أقل من السابق إلى الوزن"},
{"FUTURE_APPT_EXISTS","APP-AM0027 المواعيد المستقبلية موجودة للممارس. لا يمكن تعطيلها"},
{"NEXT_NUM_START","APP-AM0028 يجب أن يبدأ الرقم التالي من 10000000"},
{"INVALID_DEPT_CODE","APP-AM0029 يجب أن يكون أول حرفين من الرمز"},
{"INVALID_TIME_ENTRY_FORMAT","APP-AM0030 يجب إدخال قيمة الوقت بترتيب تصاعدي"},
{"INVALID_TIME_DAY_COMB","APP-AM0031 الحقول الزمنية التي تم إدخالها لا تتطابق مع عدد التكرارات"},
{"VALID_TIME_SLOTS","APP-AM0032 يجب أن يكون الإدخال الصحيح بين 00:00 و 00:59"},
{"MAND_TIME_CHK","APP-AM0033 لا يمكن أن يكون الوقت فارغًا"},
{"CANNOT_DISABLE_OPER_STN","APP-AM0034 وجود قيود محطة المشغل. لا يمكن إلغاء التحديد"},
{"PRACT_EXISTS_CLINIC_NU","APP-AM0035 ممارس مرتبط بالعيادة / وحدة التمريض. لا يمكن التعطيل"},
{"SAME_UOM_NOT_SEL","APP-AM0036 لا يمكن تحديد نفس القيمة لكل من وحدة قياس وحدة القياس ووحدة القياس المكافئة"},
{"REST_HCARE_SET","APP-AM0037 عدم إعداد القيد على إعداد الرعاية الصحية. لا يمكن المتابعة."},
{"TRNG_DTLS_MAX_CHAR","APP-AM0038 لا يمكن أن تكون تفاصيل التدريب أكثر من 100 حرف"},
{"NOT_LESS_THAN_2CHAR","APP-AM0039 يجب ألا يقل عن حرفين"},
{"ATLEAST_ENTER_ONE_VALUE","APP-AM0040 يجب إدخال # أو $ على الأقل"},
{"AM_CANNOT_GREATER","APP-AM0041   APP-AM0041 # لا يمكن أن يكون أكبر من $"},
{"AM_CANNOT_LESSER","APP-AM0042  APP-AM0042 # لا يمكن أن يكون أقل من $"},
{"CRITICAL_HIGH_GREATER_REF_HIGH","APP-AM0043 يجب أن تكون القيمة العالية الحرجة أكبر من المرجع العالي"},
{"CRITICAL_LOW_LESS_REF_LOW","APP-AM0044 يجب أن تكون القيمة المنخفضة الحرجة أقل من المرجع المنخفض"},
{"CRITICAL_LOW_NOT_GREATER_HIGH","APP-AM0045 لا يمكن أن تكون القيمة المنخفضة الحرجة أكبر من القمة الحرجة"},
{"REF_LOW_NOT_GREATER_HIGH","APP-AM0046 لا يمكن أن يكون المرجع المنخفض أكبر من مرجع مرتفع"},
{"AGE_RANGE_EXITS","APP-AM0047 سجل لهذا النطاق العمري موجود"},
{"START_AGE_GREATER_END_AGE","APP-AM0048 يجب أن يكون عمر الانتهاء أكبر من سن البداية"},
{"UNIQUE_SEQUENCE_NUM","APP-AM0049 يجب أن يكون رقم التسلسل فريدًا"},
{"MANDATORY_FIELDS","APP-AM0050 جميع الحقول بخلاف الافتراضي إلزامية"},
{"ONE_DEFAULT","APP-AM0051 يسمح فقط بقيمة افتراضية واحدة"},
{"UNIQUIE_SORT_ORDER","APP-AM0052 يجب أن يكون ترتيب الفرز فريدًا"},
{"INVALID_MAX_NUMBER","APP-AM0053 أدخل رقمًا صالحًا كحد أقصى"},
{"INVALID_MIN_VAL","APP-AM0054 يجب أن تكون القيمة الدنيا أقل من القيمة القصوى"},
{"COLSPAN_BTW_1_3","APP-AM0055 يجب أن يكون امتداد العمود بين 1 و 3"},
{"COLPOS_BTW_1_3","APP-AM0056 يجب أن يكون موضع العمود بين 1 و 3"},
{"COLSPAN_MORE_2","APP-AM0057 لا يمكن أن يكون امتداد العمود أكثر من 2"},
{"COLSPAN_MORE_1","APP-AM0058 لا يمكن أن يكون امتداد العمود أكثر من 1"},
{"SECTION_BLANK","APP-AM0059 لا يمكن أن يكون القسم فارغًا"},
{"INVALID_PRECISION","APP-AM0060 دقة غير صحيحة"},
{"LENGTH_CANNOT_4000","APP-AM0061 لا يمكن أن يكون الطول أكثر من 4000"},
{"SINGLE_DIGIT_FOR_NUM","APP-AM0062 يُسمح برقم واحد للعدد الصحيح الرقمي والعشري"},
{"INVALID_VAL_ENTERED","APP-AM0063 تم إدخال قيمة غير صالحة في"},
{"INVALID_DFLT_VAL","APP-AM0064 القيمة الافتراضية غير صحيحة"},
{"MAXIMUM_DIGITS","APP-AM0065 الحد الأقصى لعدد الأرقام التي يمكن أن تحتوي عليها القيمة"},
{"DEFAULT_VAL_LEN","APP-AM0066 يجب أن تكون القيمة الافتراضية أقل من الطول المحدد أو مساوية له"},
{"MIN_LESS_THAN_MAX","APP-AM0067 يجب أن يكون الحد الأدنى للأرقام أقل من الحد الأقصى للأرقام"},
{"INVALID_DEC_VAL","APP-AM0068 يجب أن تكون الأرقام العشرية أقل من أو تساوي الحد الأدنى من الأرقام"},
{"MAX_MIN_MANDATORY","APP-AM0069 يجب إدخال قيم الحد الأقصى والحد الأدنى"},
{"AM0100","APP-AM0070 التقديم ليس عملية صالحة هنا"},
{"AM0102","APP-AM0071 الرجاء إدخال معرف الشبكة والوصف المختصر قبل التحديد …"},
{"AM0103","APP-AM0072 الرجاء إدخال معرف المصفوفة والوصف المختصر قبل التعريف …"},
{"AM0104","APP-AM0073 قيم امتداد عمود مصفوفة غير صالحة …"},
{"AM0105","APP-AM0074 لا يمكن أن يكون الحرف الأخير رقمًا"},
{"AM0106","APP-AM0075 لا يمكن أن يكون الحرف الأول رقمًا"},
{"AM0107","APP-AM0076 يجب أن يكون معرف القائمة فريدًا"},
{"AM0108","APP-AM0077 الرجاء تحديد السجل المراد حذفه."},
{"AM0109","APP-AM0078 لا يمكن إدخال قيمة مدة الفاصل الزمني صفر …"},
{"AM0110","APP-AM0079 لا يمكن إدخال قيمة مدة التكرار صفر …"},
{"AM0111","APP-AM0080 في تكرار التكرار لا يمكن إدخال قيمة تكرار الفاصل الزمني وقيمة صفر ..."},
{"AM0112","APP-AM0081 هل تريد حذف الصيغة بأكملها"},
{"AM0113","APP-AM0082 حدد أي قيمة"},
{"AM0114","APP-AM0083 يجب ألا تتجاوز ساعات العمل الحد الأقصى لمدة العمل المستمر"},
{"AM0115","APP-AM0084 يجب أن تختلف أوقات التحول على الأقل دقيقة واحدة"},
{"AM0116","APP-AM0085 لا يمكن أن تكون أيام العمل من و إلى متساوية"},
{"AM0117","APP-AM0086 الحد الأدنى لعدد الأرقام التي يجب أن تحتوي عليها القيمة"},
{"AM0118","APP-AM0087 يجب أن تكون الدقة أقل من الطول"},
{"AM0119","APP-AM0088 يجب تحديد قابلية التطبيق على الأقل"},
{"AM0120","APP-AM0089 يجب ألا يكون المرجع الأعلى أكبر من القيمة القصوى"},
{"AM0121","APP-AM0090 يجب أن يكون المرجع المنخفض أكبر من الحد الأدنى للقيمة"},
{"AM0122","APP-AM0091 يجب أن تكون القمة الحرجة أقل من القيمة القصوى"},
{"AM0123","APP-AM0092 يجب أن تكون القيمة الدنيا الحرجة أكبر من القيمة الدنيا"},
{"AM0124","APP-AM0093 يمكن أن تتراوح دقائق التشغيل بين 0 و 59"},
{"AM0125","APP-AM0094 يجب أن تكون سنة النجاح أكبر من تاريخ الميلاد"},
{"AM0126","APP-AM0095 تم الوصول إلى أقصى قيمة صحيحة"},
{"AM0127","APP-AM0096 يجب اختيار رئيس واحد على الأقل."},
{"AM0128","APP-AM0097 التعبير غير صالح"},
{"AM0129","APP-AM0098 يجب أن تكون سنة النجاح أكبر من تاريخ الميلاد"},
{"AM0130","APP-AM0099 يجب أن يتراوح النطاق العمري بين 0 و 999 للوحدة العمرية - اليوم"},
{"AM0131","APP-AM0100 يجب أن يتراوح النطاق العمري بين 1 و 999 للوحدة العمرية - الشهر"},
{"AM0132","APP-AM0101 يجب أن يتراوح النطاق العمري بين 1 و 999 للوحدة العمرية - السنه"},
{"AM0133","APP-AM0102 يجب أن يتراوح النطاق العمري بين 1 و 999 للوحدة العمرية - ثانية"},
{"AM0134","APP-AM0103 يجب أن يتراوح النطاق العمري بين 1 و 999 للوحدة العمرية - دقيقة"},
{"AM0135","APP-AM0104 يجب أن يتراوح النطاق العمري بين 1 و 999 للوحدة العمرية - ساعة"},
{"AM0136","APP-AM0105 غير مسموح بوحدات عمرية مختلفة"},
{"AM0137","APP-AM0106 يجب أن يكون الحد الأقصى للعمر أكبر من الحد الأدنى للعمر"},
{"AM0138","APP-AM0107 جميع الحقول غير صفوف النص إلزامية"},
{"AM0139","APP-AM0108 يمكن أن تكون مكونات $ فقط جزءًا من الشبكة"},
{"AM0140","APP-AM0109 لا يوجد مكان بعد الآن للمكونات في هذه الشبكة"},
{"AM0141","APP-AM0110 الرجاء إدخال معرف فريد"},
{"AM0142","APP-AM0111 هذا المكون"},
{"AM0143","APP-AM0112 يتداخل مع المكون الموجود"},
{"AM0144","APP-AM0113 لا يمكن تكرار المعرف"},
{"AM0145","APP-AM0114 لم يتم إدخال كولسبان لموضع الأعمدة $"},
{"AM0146","APP-AM0115 يجب أن يكون إجمالي كولسبان أقل من أو يساوي $"},
{"AM0147","APP-AM0116 رقم الصف ... لم يتم تعريف جميع المكونات $"},
{"AM0148","APP-AM0117 رقم العمود ... لم يتم تعريف كافة المكونات $"},
{"AM0149","APP-AM0118 لم يتم تحديد رأس العمود $"},
{"AM0150","APP-AM0119 لم يتم تعريف رأس الصف $"},
{"AM0151","APP-AM0120 مكون مقوى - لا يمكن حفظ التعريف"},
{"AM0152","APP-AM0121 يجب أن يكون تنازلي أكبر من الصفر"},
{"AM0153","APP-AM0122 الرجاء إدخال الطول قبل إدخال الدقة"},
{"AM0154","APP-AM0123 ستؤدي هذه العملية إلى مسح كافة اقترانات الحقول التي تم إجراؤها / هل تريد المتابعة؟"},
{"AM0155","APP-AM0124 القيم السلبية غير مسموح بها"},
{"AM0156","APP-AM0125 لا يمكن حذف التسجيل في وضع الإنشاء"},
{"AM0157","APP-AM0126 يجب أن تكون هوية الجنسية من الأحرف $"},
{"AM0158","APP-AM0127 لا يمكن أن يتجاوز النص التوضيحي 4000 حرف"},
{"AM0159","APP-AM0128 يمكن أن تتراوح ساعات العمل بين 0 و 23"},
{"AM0160","APP-AM0129 يجب أن يكون الوقت بالساعات بين 0 و 23"},
{"AM0161","APP-AM0130 يجب أن يكون الوقت بالدقائق بين 0 و 59"},
{"AM0162","APP-AM0131 لا يمكن أن يتجاوز سرد المورد 300 حرف"},
{"AM0163","APP-AM0132 لا يمكن أن يتجاوز النص التوضيحي 4000 حرف"},
{"AM0164","APP-AM0133 لا يمكن أن تكون السنة المتجاوزه أكبر من السنة الحالية"},
{"AM0165","APP-AM0134 عدد الأسرة المسموح بها"},
{"AM0166","APP-AM0135 يجب تحديد الوحدة النمطية قبل تحديد نوع البرنامج"},
{"AM0167","APP-AM0136 يتداخل مع المكون الموجود"},
{"AM0168","APP-AM0137 لا يمكن أن يكون $ أكثر من #"},
{"AM0169","APP-AM0138 الرجاء إدخال جميع الحقول الإلزامية"},
{"AM0170","APP-AM0139 يجب أن يكون $ أكبر من 0"},
{"CANNOT_DISABLE_OPER_STN_LOCN","APP-AM0140 تم تحديد الحجز العالمي للمواقع"},
{"START_END_NOT_EQUAL","APP-AM0141 لا يمكن أن يكون وقت البدء ووقت الانتهاء متساويين"},
{"AM0173","APP-AM0142 لا يمكن أن يتساوى $ و #"},
{"INS_BET_1_AND_10","APP-AM0143 يجب أن يكون الرقم التسلسلي بين 1 إلى 10."},
{"REPEAT_DAY_TIME","APP-AM0144 تكرار إدخالات اليوم / الوقت"},
{"RECORD_ALREADY_EXISTS_IN_DIS","APP-AM0145 السجل موجود بالفعل في لوحة قياس منفصلة / لوحة قياس منفصلة"},
{"DISC_TYPE_IND_ALREADY_ASSOCIATED","APP-AM0146 نفس مؤشر النوع المنفصل مرتبط بالفعل بتدبير منفصل آخر"},
{"MAX_REPEATS_ALLOWED_FOR_MONTH","APP-AM0147 لا يجب أن يكون الحد الأقصى للدورة أكبر من 12 بالنسبة للتردد الدوري عند تحديد التكرارات بالشهر"},
{"MR_OPEN_REQ_AVAILABLE_CANNOT_PROCEED","APP-AM0148 طلب مفتوح متاح في التقرير الطبي. لا يمكن إلغاء تحديد التخصص للتقرير الطبي."},
{"PRACT_DUP_NAT_ID","APP-AM0149 تم العثور على سجل مكرر مع $. يرجى التحقق من صحة #"},
{"PRACT_DUP_NAT_ID_MULTIPLE","APP-AM0150 تم العثور على سجل مكرر متعدد. يرجى التحقق من صحة #"},
{"MAX_LENGHT_VALIDATE","APP-AM0151 يجب أن يكون $ من # حرف"},
{"EMPLOYEE_SERVICE_NO_ALREADY_EXISTS","APP-AM0184 رقم خدمة الموظف موجود بالفعل"},
{"EMPLOYEE_SERVICE_NO_DOESNOT_EXISTS","رقم خدمة الموظف غير موجود"}

};		
}
