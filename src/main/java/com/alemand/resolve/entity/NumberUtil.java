package com.alemand.resolve.entity;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {
	//金额0
	public static BigDecimal ZERO = BigDecimal.ZERO;
	public static BigDecimal TEN = BigDecimal.TEN;

	/**
	 * 是否是金额
	 * @param obj
	 * @return
	 */
	public static BigDecimal isBigDecimal(String obj) {
		BigDecimal bigDecimal = null;

		try {
			bigDecimal = new BigDecimal(obj);
		} catch (Exception e) {
			bigDecimal = null;
		}
		return bigDecimal;
	}
	
	/**
	 * 转化为BigDecimal金额格式
	 * @param obj
	 * @return
	 */
	public static BigDecimal toBigDecimal(Object obj) {
		BigDecimal bigDecimal = ZERO;

		if (null != obj && !"".equals(obj)) {
			NumberFormat numberFormat = NumberFormat.getInstance();

			String str = obj.toString().trim();
			Number number = null;
			try {
				number = numberFormat.parse(str);
			} catch (ParseException e) {
				number = null;
			}

			if (null != number && !"".equals(number))
				try {
					str = number.toString();
					bigDecimal = new BigDecimal(str);
				} catch (Exception e) {
				}
		}
		return bigDecimal;
	}

	/**
	 * 转化为金额格式 
	 * @param obj
	 * @param scale
	 * @return
	 */
	public static BigDecimal toBigDecimal(Object obj, int scale) {
		return toBigDecimal(obj).setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 金额类相加
	 * @param dec1
	 * @param dec2
	 * @return
	 */
	public static BigDecimal add(Object dec1, Object dec2) {
		if ((dec1 == null) && (dec2 == null)) {
			return null;
		}
		return toBigDecimal(dec1).add(toBigDecimal(dec2));
	}

	/**
	 * 金额类相减
	 * @param dec1
	 * @param dec2
	 * @return
	 */
	public static BigDecimal subtract(Object dec1, Object dec2) {
		if ((dec1 == null) && (dec2 == null)) {
			return null;
		}
		return toBigDecimal(dec1).subtract(toBigDecimal(dec2));
	}

	/**
	 * 金额类相除
	 * @param dec1
	 * @param dec2
	 * @return
	 */
	public static BigDecimal divide(Object dec1, Object dec2) {
		return divide(dec1, dec2, 10, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 金额类相除
	 * @param dec1 被除数
	 * @param dec2 除数
	 * @param scale 精度
	 * @param roundingMode 舍入模式
	 * @return
	 */
	public static BigDecimal divide(Object dec1, Object dec2, int scale,
			int roundingMode) {
		if ((dec1 == null) && (dec2 == null)) {
			return null;
		}
		if (toBigDecimal(dec2).signum() == 0) {
			return null;
		}
		return toBigDecimal(dec1).divide(toBigDecimal(dec2), scale,
				roundingMode);
	}
	/**
	 * 金额类相乘
	 * @param dec1
	 * @param dec2
	 * @return
	 */
	public static BigDecimal multiply(Object dec1, Object dec2) {
		if ((dec1 == null) && (dec2 == null)) {
			return null;
		}
		return toBigDecimal(dec1).multiply(toBigDecimal(dec2));
	}

	//是否大于0
	public static boolean isPositiveBigDecimal(Object obj) {
		boolean isValid = false;
		if (toBigDecimal(obj).compareTo(ZERO) > 0) {
			isValid = true;
		}
		return isValid;
	}
	//是否为null或者0
	public static boolean isNullZero(BigDecimal bd) {
		boolean b = false;

		if (bd == null)
			b = true;

		if ((bd != null) && (bd.compareTo(ZERO) == 0)) {
			b = true;
		}
		return b;
	}
	/**
	 * 金额比较<br>
	 * obj1 > obj2 return 1 	<br>
	 * obj1 = obj2 return 0 	<br>
	 * obj1 < obj2 return -1	<br>
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static int compareValue(Object obj1, Object obj2) {
		return toBigDecimal(obj1).compareTo(toBigDecimal(obj2));
	}

	
	/**  
	 * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零  
     * 要用到正则表达式  
     */ 
	public static String digitUppercase(double n){  
    	String fraction[] = {"角", "分"};  
        String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };  
        String unit[][] = {{"元", "万", "亿"},  
        			{"", "拾", "佰", "仟"}};  
        String head = n < 0? "负": "";  
        n = Math.abs(n);  
        String s = "";  
        for (int i = 0; i < fraction.length; i++) {  
        	s += (digit[(int)(Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");  
        }  
        if(s.length()<1){  
        	s = "整";      
        }  
        int integerPart = (int)Math.floor(n);  
        for (int i = 0; i < unit[0].length && integerPart > 0; i++) {  
        	String p ="";  
            for (int j = 0; j < unit[1].length && n > 0; j++) {  
            	p = digit[integerPart%10]+unit[1][j] + p;  
                integerPart = integerPart/10;  
            }  
            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;  
        }  
        return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");  

    }
	/**
	 * 获取length长度的随机字符串
	 * @param length 字符串长度
	 * @return 输出随机字符串
	 */
	public static String getRandomNun(int length) { //length表示生成字符串的长度  
		String base = "0123456789";     
		Random random = new Random();     
		StringBuffer sb = new StringBuffer();     
		for (int i = 0; i < length; i++) {     
			int number = random.nextInt(base.length());     
			sb.append(base.charAt(number));     
		}     
		return sb.toString();     
	}
	
	/**
	 * 将数字格式化为中文
	 * @author luojian 20160921
	 * @param num
	 * @return
	 */
	public static String formatInteger(int num) {
		String[] units = { "", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿" };
		char[] numArray = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
		char[] val = String.valueOf(num).toCharArray();
		int len = val.length;
		//处理100这种直接转为 一百  后面不用  显示 零
		Pattern pattern = Pattern.compile("([0]*)$");
		Matcher matcher = pattern.matcher(num+"");
		int jumpLen = 0;
		if (matcher.find()) {
			jumpLen = matcher.group().length();
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			
			//跳过数字最后面的零 如100 跳过两个零
			if (len - i <= jumpLen) {
				break;
			}
			String m = val[i] + "";
			int n = Integer.valueOf(m);
			boolean isZero = n == 0;
			String unit = units[(len - 1) - i];
			if (isZero) {
				if ('0' == val[i - 1]) {
					continue;
				} else {
					sb.append(numArray[n]);
				}
			} else {
				// 10 显示 十 而不是 一十
				if (len == 2 && i == 0 && n == 1 ) {
					sb.append(unit);
				}else {
					sb.append(numArray[n]);
					sb.append(unit);
				}
				
			}
		}
		return sb.toString();
	}
	
	/**
	 * @author chengjun
	 * 数字为空时，返回 0
	 * 
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public final static Integer defaultIntVal(Integer val){
		return defaultIntVal(val, 0);
	}
	/**
	 * @author chengjun
	 * 数字为空时，返回给定的默认值 
	 * 
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public final static Integer defaultIntVal(Integer val, int defaultVal){
		if(val == null){
			return defaultVal;
		}
		return val;
	}
	/**
	 * @author chengjun
	 * 数字为空时，返回 0L 
	 * 
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public final static Long defaultLongVal(Long val){
		return defaultLongVal(val, 0L);
	}
	/**
	 * @author chengjun
	 * 数字为空时，返回给定的默认值 
	 * 
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public final static Long defaultLongVal(Long val, long defaultVal){
		if(val == null){
			return defaultVal;
		}
		return val;
	}
	/**
	 * @author chengjun
	 * 数字为空时，返回 0.00F
	 * 
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public final static Float defaultFloatVal(Float val){
		return defaultFloatVal(val, 0.00F);
	}
	/**
	 * @author chengjun
	 * 数字为空时，返回给定的默认值 
	 * 
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public final static Float defaultFloatVal(Float val, float defaultVal){
		if(val == null){
			return defaultVal;
		}
		return val;
	}
	/**
	 * @author chengjun
	 * 数字为空时，返回  0.00D
	 * 
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public final static Double defaultDoubleVal(Double val){
		return defaultDoubleVal(val, 0.00D);
	}
	/**
	 * @author chengjun
	 * 数字为空时，返回给定的默认值 
	 * 
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public final static Double defaultDoubleVal(Double val, double defaultVal){
		if(val == null){
			return defaultVal;
		}
		
		return val;

	}
	
	public static void main(String[] args) {
		System.out.println(NumberUtil.getRandomNun(16)); 
	}
}

