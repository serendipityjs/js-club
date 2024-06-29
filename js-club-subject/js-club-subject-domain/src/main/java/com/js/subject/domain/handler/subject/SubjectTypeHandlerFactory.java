package com.js.subject.domain.handler.subject;

import com.js.subject.comm.enums.SubjectInfoTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目类型工厂
 *
 * @author jiaoshuai
 * @date 2024/6/29 11:52
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {
    /**
     * 在Spring框架中，当SubjectTypeHandler是一个接口，并且有四个实现了该接口的类，并且这些实现类都标注了@Component注解时,
     * Spring容器会通过组件扫描（component scanning）自动检测到这些组件，并在应用上下文中注册它们。
     * 以下是subjectTypeHandlerList被赋予值的通常流程：
     * 1.组件扫描：Spring容器启动时，会扫描指定的包或类路径下的所有类，查找带有@Component注解的类。
     * 2.注册Bean：对于每个带有@Component注解的类，Spring容器会创建一个Bean，并将其注册到Spring应用上下文中。
     * 3.自动装配：如果类中存在符合自动装配条件的字段（如带有@Resource注解的字段），Spring容器会尝试自动注入相应的Bean。
     * 在这种情况下，subjectTypeHandlerList字段带有@Resource注解，Spring会查找所有实现了SubjectTypeHandler接口的Bean,
     * 并自动将它们注入到subjectTypeHandlerList字段中。
     * 4.初始化Bean：一旦所有的自动装配完成，Spring容器会调用实现了InitializingBean接口的Bean的afterPropertiesSet方法（如果存在）。
     * 在这个方法中，可以执行一些初始化逻辑，比如你提供的代码片段中的afterPropertiesSet方法，
     * 它将subjectTypeHandlerList中的每个SubjectTypeHandler添加到handlerMap映射中。
     * 因此，subjectTypeHandlerList的值是在Spring容器初始化过程中，通过自动装配机制赋予的。
     * 具体的时机是在Bean的属性被设置之后，afterPropertiesSet方法被调用之前。
     * 这样，当afterPropertiesSet方法执行时，subjectTypeHandlerList已经被填充了所有实现了SubjectTypeHandler接口的Bean的列表。
     */
    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();

    public SubjectTypeHandler getHandler(int subjectType) {
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getEnumByCode(subjectType);
        return handlerMap.get(subjectInfoTypeEnum);
    }


    /**
     * bean装载完成之后给handlerMap赋值
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList) {
            handlerMap.put(subjectTypeHandler.getHandlerType(), subjectTypeHandler);
        }
    }
}
