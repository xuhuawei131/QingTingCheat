package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class BigDecimalDeserializer
  implements ObjectDeserializer
{
  public static final BigDecimalDeserializer instance = new BigDecimalDeserializer();

  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 2)
    {
      long l = localJSONLexer.longValue();
      localJSONLexer.nextToken(16);
      return new BigDecimal(l);
    }
    if (localJSONLexer.token() == 3)
    {
      BigDecimal localBigDecimal = localJSONLexer.decimalValue();
      localJSONLexer.nextToken(16);
      return localBigDecimal;
    }
    Object localObject = paramDefaultJSONParser.parse();
    if (localObject == null)
      return null;
    return TypeUtils.castToBigDecimal(localObject);
  }

  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return deserialze(paramDefaultJSONParser);
  }

  public int getFastMatchToken()
  {
    return 2;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.parser.deserializer.BigDecimalDeserializer
 * JD-Core Version:    0.6.2
 */