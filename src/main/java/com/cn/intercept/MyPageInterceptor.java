package com.cn.intercept;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * Created by dellpc on 2017/11/30.
 */

/*
* @Intercepts 说明是拦截器
* @Signature 拦截器的签名
* type 拦截的类型 四大对象（ Executor,ResultSetHandler,ParameterHandler,StatementHandler）
* */

@Intercepts({@Signature(type = StatementHandler.class,method = "prepare", args = {Connection.class,Integer.class})})
public class MyPageInterceptor implements Interceptor {

    private int pageSize;//每页显示的条目数
    private int currPage;//当前实现的页数
    private String dbType;


    public Object intercept(Invocation invocation) throws Throwable {

        //获取StatementHandler，默认是RoutingStatementHandler
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //获取StatementHandler包装类
        MetaObject MetaObjectHandler = SystemMetaObject.forObject(statementHandler);

//        //分离代理对象链
//        while (MetaObjectHandler.hasGetter("h")) {
//            Object obj = MetaObjectHandler.getValue("h");
//            MetaObjectHandler = SystemMetaObject.forObject(obj);
//        }
//
//        while (MetaObjectHandler.hasGetter("target")) {
//            Object obj = MetaObjectHandler.getValue("target");
//            MetaObjectHandler = SystemMetaObject.forObject(obj);
//        }

        //获取查询接口映射的相关信息
        MappedStatement mappedStatement = (MappedStatement) MetaObjectHandler.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();

        //拦截以.ByPage结尾的请求，分页功能的统一实现
        if (mapId.matches(".+ByPage$")) {
            //获取进行数据库操作时管理参数的handler
            ParameterHandler parameterHandler = (ParameterHandler) MetaObjectHandler.getValue("delegate.parameterHandler");
            //获取请求时的参数
            Map<String,Object> paraObject = (Map<String,Object>) parameterHandler.getParameterObject();
            //也可以这样获取
            //paraObject = (Map<String,Object>) statementHandler.getBoundSql().getParameterObject();

            //参数名称和在service中设置到map中的名称一致
            currPage =  Integer.getInteger(paraObject.get("currPage").toString());
            pageSize =  Integer.getInteger(paraObject.get("pageSize").toString());

            String sql = (String) MetaObjectHandler.getValue("delegate.boundSql.sql");
            //也可以通过statementHandler直接获取
            //sql = statementHandler.getBoundSql().getSql();

            //构建分页功能的sql语句
            String limitSql;
            sql = sql.trim();
            limitSql = sql + " limit " + (currPage - 1) * pageSize + "," +pageSize;

            System.out.println("limitSql:" + limitSql);
            //将构建完成的分页sql语句赋值个体‘delegate.boundSql.sql’
            MetaObjectHandler.setValue("delegate.boundle.sql",limitSql);

        }

        return invocation.proceed();
    }

    //获取代理对象
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    //设置代理对象
    public void setProperties(Properties properties) {
        //如果项目中分页的pageSize是统一的，也可以在这里统一配置和获取，这样就不用每次请求都传递pageSize参数了。
        // 参数是在配置拦截器时配置的。
        String limit1 = properties.getProperty("limit","10");
        this.pageSize = Integer.valueOf(limit1);
        this.dbType = properties.getProperty("dbType","mysql");

    }
}
