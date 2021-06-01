package com.hbsi.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @desc     验证码工具类
 * @author 齐云尧
 * @time     2020.12.14
 */
public class CodeUtils {

	public static String code(){
		String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }; 
		//1.将数据存入到容器中
		List<String> list = Arrays.asList(beforeShuffle);
		
		//2.自动洗牌
		Collections.shuffle(list);
		
		//StringBuilder 是通过append将字符串连接成一个字符串
		StringBuilder sBuilder= new StringBuilder();
		for (int i = 0; i < list.size(); i++)
		{ 
			sBuilder.append(list.get(i)); 
		} 
		
		//3.将sBuilder转换为String类型
		String afterShuffle = sBuilder.toString();
		String result = afterShuffle.substring(1,5);
		return result;
	
		
	}
	

}
