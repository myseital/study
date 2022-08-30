package com.mao.log.record.starter.support.parse;

import com.google.common.base.Strings;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.expression.EvaluationContext;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解析需要存储的日志里面的SpeEL表达式
 */
public class LogRecordValueParser implements BeanFactoryAware {

    private static final Pattern pattern = Pattern.compile("\\{\\s*(\\w*)\\s*\\{(.*?)}}");
    public static final String COMMA = ",";
    private final LogRecordExpressionEvaluator expressionEvaluator = new LogRecordExpressionEvaluator();
    protected BeanFactory beanFactory;

    private LogFunctionParser logFunctionParser;
    /**
     * diff解析器
     */
//    private DiffParseFunction diffParseFunction;

    public static int strCount(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }

    public Map<String, String> processTemplate(Collection<String> templates, Object ret,
                                               Class<?> targetClass, Method method, Object[] args, String errorMsg,
                                               Map<String, String> beforeFunctionNameAndReturnMap) {
        Map<String, String> expressionValues = new HashMap<>();
        EvaluationContext evaluationContext = expressionEvaluator.createEvaluationContext(method, args, targetClass, ret, errorMsg, beanFactory);

        for (String expressionTemplate : templates) {
            if (expressionTemplate.contains("{")) {
                Matcher matcher = pattern.matcher(expressionTemplate);
                StringBuffer parsedStr = new StringBuffer();
                AnnotatedElementKey annotatedElementKey = new AnnotatedElementKey(method, targetClass);
                while (matcher.find()) {
                    String expression = matcher.group(2);
                    String functionName = matcher.group(1);
//                    if (DiffParseFunction.diffFunctionName.equals(functionName)) {
//                        expression = getDiffFunctionValue(evaluationContext, annotatedElementKey, expression);
//                    } else {
//                        Object value = expressionEvaluator.parseExpression(expression, annotatedElementKey, evaluationContext);
//                        expression = logFunctionParser.getFunctionReturnValue(beforeFunctionNameAndReturnMap, value, expression, functionName);
//                    }
                    Object value = expressionEvaluator.parseExpression(expression, annotatedElementKey, evaluationContext);
                    expression = logFunctionParser.getFunctionReturnValue(beforeFunctionNameAndReturnMap, value, expression, functionName);
                    matcher.appendReplacement(parsedStr, Matcher.quoteReplacement(Strings.nullToEmpty(expression)));
                }
                matcher.appendTail(parsedStr);
                expressionValues.put(expressionTemplate, parsedStr.toString());
            } else {
                expressionValues.put(expressionTemplate, expressionTemplate);
            }

        }
        return expressionValues;
    }

//    private String getDiffFunctionValue(EvaluationContext evaluationContext, AnnotatedElementKey annotatedElementKey, String expression) {
//        String[] params = parseDiffFunction(expression);
//        if (params.length == 1) {
//            Object targetObj = expressionEvaluator.parseExpression(params[0], annotatedElementKey, evaluationContext);
//            expression = diffParseFunction.diff(targetObj);
//        } else if (params.length == 2) {
//            Object sourceObj = expressionEvaluator.parseExpression(params[0], annotatedElementKey, evaluationContext);
//            Object targetObj = expressionEvaluator.parseExpression(params[1], annotatedElementKey, evaluationContext);
//            expression = diffParseFunction.diff(sourceObj, targetObj);
//        }
//        return expression;
//    }

    private String[] parseDiffFunction(String expression) {
        if (expression.contains(COMMA) && strCount(expression, COMMA) == 1) {
            return expression.split(COMMA);
        }
        return new String[]{expression};
    }

    public Map<String, String> processBeforeExecuteFunctionTemplate(Collection<String> templates, Class<?> targetClass, Method method, Object[] args) {
        Map<String, String> functionNameAndReturnValueMap = new HashMap<>();
        EvaluationContext evaluationContext = expressionEvaluator.createEvaluationContext(method, args, targetClass, null, null, beanFactory);

        for (String expressionTemplate : templates) {
            if (expressionTemplate.contains("{")) {
                Matcher matcher = pattern.matcher(expressionTemplate);
                while (matcher.find()) {
                    String expression = matcher.group(2);
                    if (expression.contains("#_ret") || expression.contains("#_errorMsg")) {
                        continue;
                    }
                    AnnotatedElementKey annotatedElementKey = new AnnotatedElementKey(method, targetClass);
                    String functionName = matcher.group(1);
                    if (logFunctionParser.beforeFunction(functionName)) {
                        Object value = expressionEvaluator.parseExpression(expression, annotatedElementKey, evaluationContext);
                        String functionReturnValue = logFunctionParser.getFunctionReturnValue(null, value, expression, functionName);
                        String functionCallInstanceKey = logFunctionParser.getFunctionCallInstanceKey(functionName, expression);
                        functionNameAndReturnValueMap.put(functionCallInstanceKey, functionReturnValue);
                    }
                }
            }
        }
        return functionNameAndReturnValueMap;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void setLogFunctionParser(LogFunctionParser logFunctionParser) {
        this.logFunctionParser = logFunctionParser;
    }

//    public void setDiffParseFunction(DiffParseFunction diffParseFunction) {
//        this.diffParseFunction = diffParseFunction;
//    }
}
