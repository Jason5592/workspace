package com.jason;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
/**
 * Generator
 * @author bxj
 * @date 2021/12/14
 */
public class Generator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/dict_center?zeroDateTimeBehavior=convertToNull", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("王政") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .dateType(DateType.ONLY_DATE)//指定日期格式
                            .outputDir("D:\\dev\\workspace\\asset_management_platform\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.anso.iam") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\dev\\workspace\\saas\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder
//                            .addInclude("oms_foo_config") // 设置需要生成的表名
                            .addTableSuffix("")//设置过滤掉表后缀
                            .addTablePrefix(""); // 设置过滤表前缀

                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
