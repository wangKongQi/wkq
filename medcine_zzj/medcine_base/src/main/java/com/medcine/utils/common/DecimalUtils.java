package com.medcine.utils.common;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigDecimal工具类，提供 +,-,*,/ 运算支持
 * 
 * @author wkq
 * @since 2020.10.29
 */
public class DecimalUtils {

  public final static int BIT_DEFAULT = 6;

  public final static int BIT_8 = 8;

  public final static int BIT_16 = 16;

  public final static int ROUND_MODE_DEFAULT = BigDecimal.ROUND_HALF_UP;

  // add 加

  public static BigDecimal add(Number x, Number y) {
    return add(val(x), val(y));
  }

  public static BigDecimal add(Number x, Number y, int newScale) {
    return add(val(x), val(y), newScale);
  }

  public static BigDecimal add(Double x, Double y) {
    BigDecimal ret = add(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal add(Double... x) {
    if (x == null || x.length == 0) {
      return null;
    }
    BigDecimal ret = null;
    for (Double b : x) {
      if (b == null) {
        continue;
      } else if (ret == null) {
        ret = val(b);
      } else if (b.compareTo(0.0D) == 0) {
        continue;
      } else {
        ret = add(ret, b);
      }
    }
    return ret;
  }

  public static BigDecimal add(Number... x) {
    if (x == null || x.length == 0) {
      return null;
    }
    BigDecimal ret = null;
    for (Number b : x) {
      if (b == null) {
        continue;
      } else if (ret == null) {
        ret = val(b);
      } else if (BigDecimal.ZERO.compareTo(val(b)) == 0) {
        continue;
      } else {
        ret = add(ret, b);
      }
    }
    return ret;
  }

  public static BigDecimal add(BigDecimal... x) {
    return addScale(BIT_DEFAULT, x);
  }

  public static BigDecimal addScale(int newScale, BigDecimal... x) {
    if (x == null || x.length == 0) {
      return null;
    } else if (x.length == 1) {
      return x[0].setScale(newScale, ROUND_MODE_DEFAULT);
    } else {
      BigDecimal ret = null;
      for (BigDecimal b : x) {
        if (b == null) {
          continue;
        } else if (ret == null) {
          ret = b;
        } else if (BigDecimal.ZERO.compareTo(b) == 0) {
          continue;
        } else {
          ret = add(ret, b, newScale);
        }
      }
      return ret;
    }
  }

  public static BigDecimal add(BigDecimal x, Double y) {
    BigDecimal ret = add(x, new BigDecimal(y));
    return ret;
  }

  public static BigDecimal add(Integer x, BigDecimal y) {
    BigDecimal ret = add(new BigDecimal(x), y);
    return ret;
  }

  public static BigDecimal add(BigDecimal x, Integer y) {
    BigDecimal ret = add(x, new BigDecimal(y));
    return ret;
  }

  public static BigDecimal add(BigDecimal x, BigDecimal y) {
    BigDecimal ret = add(x, y, BIT_DEFAULT);
    return ret;
  }

  public static BigDecimal add(BigDecimal x, BigDecimal y, int newScale) {
    if (x == null) {
      if (y != null) {
        return y.setScale(newScale, ROUND_MODE_DEFAULT);
      } else {
        return null;
      }
    } else if (y == null) {
      return x.setScale(newScale, ROUND_MODE_DEFAULT);
    } else {
      BigDecimal ret = x.add(y).setScale(newScale, ROUND_MODE_DEFAULT);
      return ret;
    }
  }

  // subtract 减法

  public static BigDecimal subtract(Number x, Number y) {
    BigDecimal ret = subtract(val(x), val(y));
    return ret;
  }

  public static BigDecimal subtract(Number x, Number y, int newScale) {
    BigDecimal ret = subtract(val(x), val(y), newScale);
    return ret;
  }

  public static BigDecimal subtract(Double x, Double y) {
    BigDecimal ret = subtract(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal subtract(Double x, BigDecimal y) {
    BigDecimal ret = subtract(new BigDecimal(x), y);
    return ret;
  }

  public static BigDecimal subtract(BigDecimal x, Double y) {
    BigDecimal ret = subtract(x, new BigDecimal(y));
    return ret;
  }

  public static BigDecimal subtract(BigDecimal x, String y) {
    BigDecimal ret = subtract(x, new BigDecimal(y));
    return ret;
  }

  public static BigDecimal subtract(BigDecimal x, BigDecimal y) {
    BigDecimal ret = subtract(x, y, BIT_DEFAULT);
    return ret;
  }

  public static BigDecimal subtract(BigDecimal x, BigDecimal y, int newScale) {
    if (x == null) {
      if (y != null) {
        return y.setScale(newScale, ROUND_MODE_DEFAULT);
      } else {
        return null;
      }
    } else if (y == null) {
      return x.setScale(newScale, ROUND_MODE_DEFAULT);
    } else {
      BigDecimal ret = x.subtract(y).setScale(newScale, ROUND_MODE_DEFAULT);
      return ret;
    }
  }

  public static BigDecimal subtract(Integer x, Double y) {
    BigDecimal ret = subtract(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal subtract(Integer x, BigDecimal y) {
    BigDecimal ret = subtract(new BigDecimal(x), y);
    return ret;
  }

  public static BigDecimal subtract(BigDecimal... x) {
    return subtractScale(BIT_DEFAULT, x);
  }

  public static BigDecimal subtractScale(int newScale, BigDecimal... x) {
    if (x == null || x.length == 0) {
      return null;
    } else if (x.length == 1) {
      return x[0].setScale(newScale, ROUND_MODE_DEFAULT);
    } else {
      BigDecimal ret = null;
      for (BigDecimal b : x) {
        if (b == null) {
          continue;
        } else if (ret == null) {
          ret = b;
        } else if (BigDecimal.ZERO.compareTo(b) == 0) {
          continue;
        } else {
          ret = subtract(ret, b, newScale);
        }
      }
      return ret;
    }
  }

  public static BigDecimal subtract(Double... x) {
    if (x == null || x.length == 0) {
      return null;
    }
    BigDecimal ret = null;
    for (Double b : x) {
      if (b == null) {
        continue;
      } else if (ret == null) {
        ret = val(b);
      } else if (b.compareTo(0.0D) == 0) {
        continue;
      } else {
        ret = subtract(ret, b);
      }
    }
    return ret;
  }

  public static BigDecimal subtract(Number... x) {
    if (x == null || x.length == 0) {
      return null;
    }
    BigDecimal ret = null;
    for (Number b : x) {
      if (b == null) {
        continue;
      } else if (ret == null) {
        ret = val(b);
      } else if (BigDecimal.ZERO.compareTo(val(b)) == 0) {
        continue;
      } else {
        ret = subtract(ret, b);
      }
    }
    return ret;
  }

  // multiply  乘法

  public static BigDecimal multiply(Number x, Number y) {
    return multiply(val(x), val(y));
  }

  public static BigDecimal multiply(Number x, Number y, int newScale) {
    return multiply(val(x), val(y), newScale);
  }

  public static BigDecimal multiply(Integer x, Integer y) {
    return multiply(new BigDecimal(x), new BigDecimal(y));
  }

  public static BigDecimal multiply(Double x, String y) {
    BigDecimal ret = multiply(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal multiply(Double x, Integer y) {
    BigDecimal ret = multiply(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal multiply(Integer x, Double y) {
    BigDecimal ret = multiply(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal multiply(Double x, Double y) {
    BigDecimal ret = multiply(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal multiply(Integer x, BigDecimal y) {
    BigDecimal ret = multiply(new BigDecimal(x), y);
    return ret;
  }

  public static BigDecimal multiply(Integer x, BigDecimal y, int newScale) {
    BigDecimal ret = multiply(new BigDecimal(x), y, newScale);
    return ret;
  }

  public static BigDecimal multiply(Double x, BigDecimal y) {
    BigDecimal ret = multiply(new BigDecimal(x), y);
    return ret;
  }

  public static BigDecimal multiply(BigDecimal x, Integer y) {
    BigDecimal ret = multiply(x, new BigDecimal(y));
    return ret;
  }

  public static BigDecimal multiply(BigDecimal x, Double y) {
    BigDecimal ret = multiply(x, new BigDecimal(y));
    return ret;
  }

  public static BigDecimal multiply(BigDecimal x, Double y, int newScale) {
    BigDecimal ret = multiply(x, new BigDecimal(y), newScale);
    return ret;
  }

  public static BigDecimal multiply(BigDecimal x, Integer y, int newScale) {
    BigDecimal ret = multiply(x, new BigDecimal(y), newScale);
    return ret;
  }

  public static BigDecimal multiply(BigDecimal x, BigDecimal y) {
    BigDecimal ret = multiply(x, y, BIT_DEFAULT);
    return ret;
  }

  public static BigDecimal multiply(BigDecimal... x) {
    return multiplyScale(BIT_DEFAULT, x);
  }

  public static BigDecimal multiplyScale(int newScale, BigDecimal... x) {
    if (x == null || x.length == 0) {
      return null;
    } else if (x.length == 1) {
      return x[0].setScale(newScale, ROUND_MODE_DEFAULT);
    } else {
      BigDecimal ret = null;
      for (BigDecimal b : x) {
        if (b == null) {
          continue;
        } else if (BigDecimal.ZERO.compareTo(b) == 0) {
          ret = BigDecimal.ZERO;
          break;
        } else if (ret == null) {
          ret = b;
        } else {
          ret = multiply(ret, b, newScale);
        }
      }
      return ret;
    }
  }

  public static BigDecimal multiply(Double... x) {
    if (x == null || x.length == 0) {
      return null;
    }
    BigDecimal ret = null;
    for (Double b : x) {
      if (b == null) {
        continue;
      } else if (b.compareTo(0.0D) == 0) {
        ret = BigDecimal.ZERO;
        break;
      } else if (ret == null) {
        ret = val(b);
      } else {
        ret = multiply(ret, b);
      }
    }
    return ret;
  }

  public static BigDecimal multiply(Number... x) {
    if (x == null || x.length == 0) {
      return null;
    }
    BigDecimal ret = null;
    for (Number b : x) {
      if (b == null) {
        continue;
      } else if (BigDecimal.ZERO.compareTo(val(b)) == 0) {
        ret = BigDecimal.ZERO;
        break;
      } else if (ret == null) {
        ret = val(b);
      } else {
        ret = multiply(ret, b);
      }
    }
    return ret;
  }

  public static BigDecimal multiply(BigDecimal x, BigDecimal y, int newScale) {
    if (x == null) {
      return y.setScale(newScale, ROUND_MODE_DEFAULT);
    } else if (y == null) {
      return x.setScale(newScale, ROUND_MODE_DEFAULT);
    } else {
      BigDecimal ret = x.multiply(y).setScale(newScale, ROUND_MODE_DEFAULT);
      return ret;
    }
  }

  public static BigDecimal multiply(BigDecimal x, BigDecimal y, int newScale, int roundingMode) {
    if (x == null) {
      return y.setScale(newScale, roundingMode);
    } else if (y == null) {
      return x.setScale(newScale, roundingMode);
    } else {
      BigDecimal ret = x.multiply(y).setScale(newScale, roundingMode);
      return ret;
    }
  }

  // divide 除法

  public static BigDecimal divide(Number x, Number y) {
    return divide(val(x), val(y));
  }

  public static BigDecimal divide(Number x, Number y, int newScale) {
    return divide(val(x), val(y), newScale);
  }

  public static BigDecimal divide(Integer x, Integer y) {
    BigDecimal ret = divide(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal divide(Integer x, Double y) {
    BigDecimal ret = divide(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal divide(Double x, Double y) {
    BigDecimal ret = divide(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal divide(Double x, Integer y) {
    BigDecimal ret = divide(new BigDecimal(x), new BigDecimal(y));
    return ret;
  }

  public static BigDecimal divide(Double x, BigDecimal y) {
    BigDecimal ret = divide(new BigDecimal(x), y);
    return ret;
  }

  public static BigDecimal divide(BigDecimal x, Integer y) {
    BigDecimal ret = divide(x, new BigDecimal(y));
    return ret;
  }

  public static BigDecimal divide(BigDecimal... x) {
    return divideScale(BIT_DEFAULT, x);
  }

  public static BigDecimal divideScale(int newScale, BigDecimal... x) {
    if (x == null || x.length == 0) {
      return null;
    } else if (x.length == 1) {
      return x[0].setScale(newScale, ROUND_MODE_DEFAULT);
    } else {
      BigDecimal ret = null;
      for (BigDecimal b : x) {
        if (b == null) {
          continue;
        } else if (ret == null) {
          ret = b;
          //			} else if (b.compareTo(BigDecimal.ZERO)==0) {
          //				continue;
        } else {
          ret = divide(ret, b, newScale);
        }
      }
      return ret;
    }
  }

  public static BigDecimal divide(Double... x) {
    if (x == null || x.length == 0) {
      return null;
    }
    BigDecimal ret = null;
    for (Double b : x) {
      if (b == null) {
        continue;
      } else if (ret == null) {
        ret = val(b);
        //			} else if (b.compareTo(BigDecimal.ZERO)==0) {
        //				continue;
      } else {
        ret = divide(ret, b);
      }
    }
    return ret;
  }

  public static BigDecimal divide(Number... x) {
    if (x == null || x.length == 0) {
      return null;
    }
    BigDecimal ret = null;
    for (Number b : x) {
      if (b == null) {
        continue;
      } else if (ret == null) {
        ret = val(b);
        //			} else if (b.compareTo(BigDecimal.ZERO)==0) {
        //				continue;
      } else {
        ret = divide(ret, b);
      }
    }
    return ret;
  }

  public static BigDecimal divide(Integer x, BigDecimal y) {
    BigDecimal ret = divide(new BigDecimal(x), y);
    return ret;
  }

  public static BigDecimal divide(BigDecimal x, BigDecimal y) {
    BigDecimal ret = divide(x, y, BIT_DEFAULT);
    return ret;
  }

  public static BigDecimal divide(BigDecimal x, Integer y, int newScale) {
    BigDecimal ret = divide(x, new BigDecimal(y), newScale);
    return ret;
  }

  public static BigDecimal divide(BigDecimal x, BigDecimal y, int newScale) {
    if (x == null) {
      return BigDecimal.ZERO;
    } else if (y == null) {
      return BigDecimal.ZERO;
    } else {
      BigDecimal ret = x.divide(y, newScale, ROUND_MODE_DEFAULT);
      return ret;
    }
  }

  public static BigDecimal divide(BigDecimal x, BigDecimal y, int newScale, int roundingMode) {
    if (x == null) {
      return BigDecimal.ZERO;
    } else if (y == null) {
      return BigDecimal.ZERO;
    } else {
      BigDecimal ret = x.divide(y).setScale(newScale, roundingMode);
      return ret;
    }
  }

  public static BigDecimal one_divide(BigDecimal x, int newScale) {
    BigDecimal ret = divide(new BigDecimal(1), x, newScale);
    return ret;
  }

  public static BigDecimal one_divide(BigDecimal x) {
    BigDecimal ret = divide(new BigDecimal(1), x);
    return ret;
  }

  // format

  public static BigDecimal round(Double x) {
    return round(new BigDecimal(x));
  }

  public static BigDecimal round(Double x, int newScale) {
    return round(new BigDecimal(x), newScale);
  }

  public static BigDecimal round(BigDecimal x) {
    return round(x, 4);
  }

  public static BigDecimal round(BigDecimal x, int newScale) {
    if (x == null) {
      return BigDecimal.ZERO;
    } else {
      return x.setScale(newScale, ROUND_MODE_DEFAULT);
    }
  }

  public static BigDecimal round(BigDecimal x, int newScale, int roundingMode) {
    if (x == null) {
      return BigDecimal.ZERO;
    } else {
      return x.setScale(newScale, roundingMode);
    }
  }

  // new

  public static BigDecimal val(Double x) {
    return new BigDecimal(x);
  }

  public static BigDecimal val(String x) {
    return new BigDecimal(x);
  }

  public static BigDecimal val(Number x) {
    if (x == null) {
      return BigDecimal.ZERO;
    }
    if (x instanceof Double) {
      return new BigDecimal((Double) x);
    } else if (x instanceof Integer) {
      return new BigDecimal((Integer) x);
    } else if (x instanceof Long) {
      return new BigDecimal((Long) x);
    } else if (x instanceof BigDecimal) {
      return (BigDecimal) x;
    } else if (x instanceof Short) {
      return new BigDecimal((Short) x);
    } else if (x instanceof Byte) {
      return new BigDecimal((Byte) x);
    } else if (x instanceof BigInteger) {
      return new BigDecimal((BigInteger) x);
    } else if (x instanceof Float) {
      return new BigDecimal((Float) x);
    } else {
      return new BigDecimal(x.toString());
    }
  }

  public static BigDecimal val(Integer x) {
    return new BigDecimal(x);
  }

  public static BigDecimal val(Long x) {
    return new BigDecimal(x);
  }

  public static BigDecimal val(Short x) {
    return new BigDecimal(x);
  }

  public static boolean equalsZero(BigDecimal x) {
    return (BigDecimal.ZERO.compareTo(x) == 0) ? true : false;
  }

  public static boolean equalsZeroOrNull(BigDecimal x) {
    return (x == null || BigDecimal.ZERO.compareTo(x) == 0) ? true : false;
  }

  /**
   * 判断俩个数字是否相等
   * <p>
   * 相等返回true，否则false
   * </p>
   * 
   * @param x 参数必须不为null
   * @param y 参数必须不为null
   * @return
   * @author wkq
   * @since 2020.10.29
   */
  public static boolean isEquals(BigDecimal x, BigDecimal y) throws Exception {
    if (x == null || y == null) {
      throw new Exception("相比较的俩个金额必须不为空");
    }
    return (x.compareTo(y) == 0) ? true : false;
  }

  /**
   * 俩个数字相除，除数为null或0则返回0
   * 
   * <pre>
   * 默认保留俩位小数
   * </pre>
   * 
   * @param x 被除数
   * @param y 除数
   * @return
   * @throws Exception
   * @author wkq
   * @since 2020.10.29
   */
  public static BigDecimal divideIngoreNullZero(Number x, Number y) throws Exception {
    return divideIngoreNullZero(x, y, 2);
  }

  /**
   * 俩个数字相除，除数为null或0则返回0
   * 
   * @param x 被除数
   * @param y 除数
   * @param scale 保留小数位
   * @return
   * @throws Exception
   * @author wkq
   * @since 2020.10.29
   */
  public static BigDecimal divideIngoreNullZero(Number x, Number y, int scale) throws Exception {
    BigDecimal xx = DecimalUtils.val(x);
    BigDecimal yy = DecimalUtils.val(y);
    if (y == null || BigDecimal.ZERO.compareTo(yy) == 0) {
      return BigDecimal.ZERO;
    }
    return DecimalUtils.divide(xx, yy, scale);
  }
}
