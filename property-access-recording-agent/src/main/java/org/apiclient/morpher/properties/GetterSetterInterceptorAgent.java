package org.apiclient.morpher.properties;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.agent.builder.AgentBuilder.Transformer;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class GetterSetterInterceptorAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        new AgentBuilder.Default()
                .type(ElementMatchers.nameMatches("org\\.apiclient\\.morpher\\..*.model.*"))
                .transform(new Transformer.ForAdvice()
                        .advice(ElementMatchers.nameMatches("get.*").or(ElementMatchers.nameMatches("set.*")), GetterSetterInterceptorAdvice.class.getName()))
                .installOn(inst);
    }
}

class GetterSetterInterceptorAdvice {
    @Advice.OnMethodEnter
    static void enter(@Advice.Origin String methodName) {
        PropertyAccessReport.getInstance().addPropertyAccessed(methodName);
        // You can replace this with your desired logic for recording access.
    }
}
