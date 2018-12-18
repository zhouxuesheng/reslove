package com.alemand.resolve.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * isbn转换
 * @author nielei
 *
 */
public class ConverIsbnUtil {

	/**
	 * 获取10位isbn
	 * @param isbn
	 * @return
	 */
	public static String getISBN10(String isbn){
		int index = 10;
		int total = 0;
		for (int i = 0; i <isbn.length() ; i++) {
			char a =  isbn.charAt(i);
			int d = Integer.parseInt(String.valueOf(a));
			total =total+ d * index;
			index = index - 1;
		}
		int m =  total%11;
		int n = 11 -  m;
		switch (n){
		case 10:
			isbn=isbn +"X";
			break;
		case 11:
			isbn=isbn +"0";
			break;
		default:
			isbn=isbn + n;
			break;
		}
		return isbn;
	}


	/**
	 * 10位ISBN装13位 7502055417 转  9787502055417
	 * @param isbn
	 * @return
	 */
	public static String getISBN13(String isbn) {
		
		if(StringUtils.isEmpty(isbn)){
			return null;
		}else{
			isbn = isbn.replace("-", "").replace("·", "").replace(".", "").replace("•", "").replaceAll(" ", "").trim();
			if (isbn.length() == 13) {
				return isbn;
			}else if(isbn.length()==9 && isNumeric(isbn)){
				return getISBN13(getISBN10(isbn));
			}else if(isbn.length()==10 && isNumeric(isbn.substring(0, isbn.length() - 1))){
				isbn = isbn.substring(0, isbn.length() - 1);
				isbn = "978" + isbn;
				int a = 0;
				int b = 0;
				int c = 0;
				int d = 0;
				for (int i = 0; i < isbn.length(); i++) {
					int x = Integer.parseInt(isbn.substring(i, i+1));
					if (i % 2 == 0) {
						a += x;
					} else {
						b += x;
					}
				}
				c = a + 3 * b;
				d = 10 - c % 10;
				if(d == 10){
					isbn = isbn + '0';
				}else{
					isbn = isbn + d;
				}
				return isbn;
			}
			return isbn;
		}

	}
	
	/**
	 * 批量返回转换之后的isbns
	 * @param isbnList
	 * @return
	 */
	public static List<String> batchGetISBN13(List<String> isbnList){
		
		List<String> isbns = new ArrayList<String>();
		for (String isbn : isbnList) {
			isbn = getISBN13(isbn);
			isbns.add(isbn);
		}
		return isbns;
	}


	/**
	 * 9787502055417 转 978-7-5020-5541-7
	 * @param strISBN
	 * @return
	 */
	public static String converIsbn(String strISBN) {
		try {
			if ((strISBN.length() != 10 && strISBN.length() != 13)
					|| (!strISBN.startsWith("7") && !strISBN.startsWith("9")) || strISBN.contains("-")) {
				return strISBN;
			}
			String s = "";
			if (strISBN.length() == 13) {
				s = "978-";
				strISBN = strISBN.substring(3);
			}
			switch (Integer.parseInt(strISBN.substring(1, 2))) {
			case 0:
				s += strISBN.substring(0, 1) + '-' + strISBN.substring(1, 3) + '-' + strISBN.substring(3, 9) + '-'
				+ strISBN.substring(9, 10);
				break;
			case 1:
			case 2:
			case 3:
				// 已完成
				s += strISBN.substring(0, 1) + '-' + strISBN.substring(1, 4) + '-' + strISBN.substring(4, 9) + '-'
				+ strISBN.substring(9, 10);
				break;
			case 5:
				s += strISBN.substring(0, 1) + '-' + strISBN.substring(1, 5) + '-' + strISBN.substring(5, 9) + '-'
				+ strISBN.substring(9, 10);
				break;
			case 8:
				s += strISBN.substring(0, 1) + '-' + strISBN.substring(1, 6) + '-' + strISBN.substring(6, 9) + '-'
				+ strISBN.substring(9, 10);
				break;
			case 9:
				s += strISBN.substring(0, 1) + '-' + strISBN.substring(1, 7) + '-' + strISBN.substring(7, 9) + '-'
				+ strISBN.substring(9, 10);
				break;
			default:
				s = "";
				break;
			}
			return s;
		} catch (NumberFormatException e) {
			return strISBN;
		}
	}


	/**
	 * 根据输入的ISBN号，检验ISBN的有效性。依据 GB/T 5795-2006 和 ISO 2108:2005 ISBN
	 * 10位标准和13位标准实现（13位标准自2007年1月1日开始实行，在此之前采用10位标准）。
	 * 
	 * @param String isbn：需要进行校验的ISBN字符串
	 * @return true：所输入的ISBN校验正确；<br/> false：所输入的ISBN校验错误
	 */
	public static boolean checkISBN(String isbn) {
		int count = 0;
		int checkBitInt = 0;
		// 将ISBN数据全取大写字母
		//isbn = isbn.toUpperCase();
		boolean flag =true;

		char[] cs = isbn.toCharArray();        
		switch (isbn.length()) {
		case 10:
			// ****************************************************************
			// 当ISBN为10位时，进行的校验，用于2007年1月1日前的出版物
			// 数据格式：从左至右前9位为ISBN数据，第10位为校验位
			// 校验方法：
			// (1) 从左至右将前9位数据从10开始至2进行编号，作为位权
			// (2) 将9位数据与各位位权进行加权，并求其9位和（称为加权和，记作M）
			// (3) 第10位校验位计算方法，校验位为C：
			//         M + C ≡ 0 (mod 11)
			//  C为10时，记作“X”
			// ****************************************************************
			// 取出前9位数字进行加权和计算            
			for (int i = 0; i < 9; i++) {
				// 若前9位数据中有非数字字符，则抛出异常
				if (cs[i] < '0' || cs[i] > '9') {
					flag= false;
				}

				int c = cs[i] - '0';
				// 求加权和
				count += c * (10 - i);
			}
			// 取出校验位数据0～9和X符合校验字符要求
			if (cs[9] >= '0' && cs[9] <= '9') {
				checkBitInt = cs[9] - '0';
			} else if (cs[9] == 'X' || cs[9] == 'x') {
				// 校验位中的“X”表示数据“10”
				checkBitInt = 10;
			} else {
				// 非0～9或X时抛出异常
				flag= false;
			}
			// 进行校验
			if ((count + checkBitInt) % 11 == 0) {
				flag= true; // 校验成功
			} else {
				flag= false; // 校验失败

			}
			break;  
		case 13:
			// ****************************************************************
			// 当ISBN为13位时，进行的校验，用于2007年1月1日后的出版物
			// 数据格式：从左至右前12位为ISBN数据，第13位为校验位
			// 校验方法：
			// (1) 从左至右将前12位数的取其奇位数和和偶位数和
			// (2) 将偶位数和乘3，并其与奇位数和的和，得加权和
			// (3) 第13位校验位计算方法，校验位为C：
			//         M + C ≡ 0 (mod 10)
			// ****************************************************************
			// ISBN为13位数据时，前3位目前只能是“978”（已实行）或“979”（暂未实行）
			if (!isbn.startsWith("978") && !isbn.startsWith("979")) {
				flag= false;
			}
			// 取出前12位数字进行加权和计算
			int countEven = 0;
			int countOdd = 0;
			for (int i = 0; i < 12; i++) {
				int c = cs[i] - '0';
				// 若前12位数据中有非数字字符，则抛出异常
				if (c < 0 || c > 9) {
					flag= false;
				}
				// 分别计算奇位数和偶位数的和
				if ((i & 0x1) == 0) {
					countOdd += c;
				} else {
					countEven += c;
				}
			}
			// 求加权和
			count = countOdd + (countEven * 3);
			// 取出校验位数据            
			if (cs[12] < '0' || cs[12] > '9') {
				// 校验位为非0~9字符时，抛出异常
				flag= false;
			}
			checkBitInt = cs[12] - '0';
			// 进行校验
			if ((count + checkBitInt) % 10 == 0) {
				return true; // 校验成功
			} else {
				return false; // 校验失败
			}

		default:
			// ISBN为非10位或13位时抛出异常
			flag= false;
		}
		return flag;
	}
	
	public static boolean isNumber(String str) { 
        Pattern pattern= Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        Matcher match=pattern.matcher(str);
        if(match.matches()==false) { 
           return false; 
        } else { 
           return true; 
        } 
    }



	public static void main(String[] args) {
//		 String orginal = "0.001"; 
//		 
//		 boolean matches = isNumber(orginal);
//		 System.out.println(matches);//0 : true	



		System.out.println(getISBN13("210103150033"));
		//		String isbn=null;
		//		String content="@a978-7-121-30201-5@dCNY58.00";
		////		String cData="@a7504451452@dCNY58.00";
		//		if(StringUtils.isNotNull(content)){
		//			if(content.indexOf("@a")!=-1){
		//				String[] zzd = content.split("@");
		//				zzd=ConverMarcUtil.removeArrayEmptyTextBackNewArray(zzd);
		//				isbn=zzd[0].substring(1).replace("-", "");
		//
		//			}
		//		}
		//		boolean flag=checkISBN(isbn);
		//		if(flag){
		//			//isbn转带-的isbn
		//			String strIsbn=converIsbn(isbn);
		//			String cbzh=null;
		//			if(strIsbn.startsWith("978")){
		//				strIsbn=strIsbn.replace("978-", "");
		//				int index=strIsbn.indexOf("-");
		//				int twoindex=strIsbn.indexOf("-", index+1);
		//				cbzh=strIsbn.substring(index+1, twoindex);
		//			}else if(strIsbn.startsWith("7")){
		//				int index=strIsbn.indexOf("-");
		//				int twoindex=strIsbn.indexOf("-", index+1);
		//				cbzh=strIsbn.substring(index+1, twoindex);
		//			}else{
		//				System.out.println("无设代码");
		//			}
		//			//1.根据设代码查询出版社，出版地
		//			System.out.println(cbzh);
		//		}else{
		//			System.out.println("isbn错误");
		//		}
	}
	
	public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
	}	
}
