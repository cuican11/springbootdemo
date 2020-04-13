package com.hwgif.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by lc.huang on 2019/4/11.
 * Description 提供精确的数字运算
 */
public class CalculateTool {

    private static final DecimalFormat DOUBLE_FORMAT_DEFAULT = new DecimalFormat("0.00");

    public static String format(double data, String pattern)
    {
           DecimalFormat formatter = new DecimalFormat(pattern);

           return formatter.format(data);
    }

    public static String format(double data)
    {
        /*  88 */     return DOUBLE_FORMAT_DEFAULT.format(data);
    }

    // 格式成 0.00 double
    public static double formatToDouble(double data, String pattern)
    {
        return Double.valueOf(format(data, pattern)).doubleValue();
    }



    /**
     *  Integer类型 加法运算
     * @param v1
     * @param v2
     * @return
     */
    public static Integer addInteger(Integer v1, Integer v2)
    {
        return new Integer(new BigDecimal(v1.intValue()).add(new BigDecimal(v2.intValue())).intValue());
    }
    /**
     *  两个double类型 加法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double add(double v1, double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    /**
     *  两个double类型 加法运算  指定精度 四舍五入
     * @param v1
     * @param v2
     * @return
     */
    public static double add(double v1, double v2, int scale)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**
     *  两个double类型 加法运算  指定精度  向下取整  精度以后直接去掉
     * @param v1
     * @param v2
     * @return
     */
    public static double addRoundDown(double v1, double v2, int scale)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_DOWN).doubleValue();
    }
    /**
     *  两个double类型 加法运算  指定精度  向上取整  精度位进1
     * @param v1
     * @param v2
     * @return
     */
    public static double addRoundUp(double v1, double v2, int scale)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_UP).doubleValue();
    }
    /**
     *  BigInteger类型加法运算
     * @param v1
     * @param v2
     * @return
     */
    public static BigInteger addBigInt(BigInteger v1, int v2)
    {
        return v1.add(BigInteger.valueOf(v2));
    }

    /**
     *  long类型 加法运算
     * @param v1
     * @param v2
     * @return
     */
    public static long add(long v1, long v2)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).longValue();
    }

    /**
     *  整形减法运算
     * @param v1
     * @param v2
     * @return
     */
    public static Integer subtractInteger(Integer v1, Integer v2)
    {
        return new Integer(new BigDecimal(v1.intValue()).subtract(new BigDecimal(v2.intValue())).intValue());
    }

    /**
     *  double类型 减法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double subtract(double v1, double v2)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }
    /**
     *  double类型 减法运算 指定精度 四舍五入
     * @param v1
     * @param v2
     * @return
     */
    public static double subtract(double v1, double v2, int scale)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     *  long类型 减法运算
     * @param v1 被减数
     * @param v2 减数
     * @return
     */
    public static long subtract(long v1, long v2)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).longValue();
    }

    /**
     *   乘法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double multiply(double v1, double v2)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }
    /**
     *   乘法运算 指定精度 四舍五入
     * @param v1
     * @param v2
     * @return
     */
    public static double multiply(double v1, double v2, int scale)
    {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }

        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     *   除法运算  四舍五入
     * @param v1 被除数
     * @param v2 除数
     * @return
     */
    public static double divide(double v1, double v2)
    {
        if (v2 == 0.0D) {
            throw new IllegalArgumentException("The divisor can not be zero");
        }
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, BigDecimal.ROUND_HALF_UP).doubleValue();

    }
    /**
     *   除法运算  指定精度 四舍五入
     * @param v1 被除数
     * @param v2 除数
     * @return
     */
    public static double divide(double v1, double v2, int scale)
    {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }


        if (v2 == 0.0D) {
            throw new IllegalArgumentException("The divisor can not be zero");
        }

        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     *  BigDecimal类型 除法运算  指定精度  精度模式自选
     * @param v1 被除数
     * @param v2 除数
     * @return
     */
    public static BigDecimal divide(double v1, double v2, int scale, RoundingMode roundingMode)
    {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }


        if (v2 == 0.0D) {
            throw new IllegalArgumentException("The divisor can not be zero");
        }

        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, scale, roundingMode);
    }

}
