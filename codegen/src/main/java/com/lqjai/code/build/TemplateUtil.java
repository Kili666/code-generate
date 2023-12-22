package com.lqjai.code.build;

import com.lqjai.code.util.DateUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Map;

/****
 * @Author 千千科技
 * @Description 创建模板，以及输出生成的文件
 * @Date 2022/01/08 20:09
 *****/
public class TemplateUtil {

    /***
     * 创建模板对象
     * @param path
     * @param ftl
     * @return
     * @throws Exception
     */
    public static Template loadTemplate(String path, String ftl) throws Exception{
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(new File(path.replace("%20"," ")));
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate(ftl);
       return template;
    }


    /***
     * 输出文件
     */
    public static void writer(Template template,Map dataModel,String file) throws Exception{
        //包参数
        dataModel.put("package_utils",TemplateBuilder.PACKAGE_UTILS);
        dataModel.put("package_controller",TemplateBuilder.PACKAGE_CONTROLLER);
        dataModel.put("package_pojo",TemplateBuilder.PACKAGE_POJO);
        dataModel.put("package_dto",TemplateBuilder.PACKAGE_DTO);
        dataModel.put("package_vo",TemplateBuilder.PACKAGE_VO);
        dataModel.put("package_mapper",TemplateBuilder.PACKAGE_MAPPER);
        dataModel.put("package_mapper_xml",TemplateBuilder.PACKAGE_MAPPER_XML);
        dataModel.put("package_convert",TemplateBuilder.PACKAGE_CONVERT);
        dataModel.put("package_service",TemplateBuilder.PACKAGE_SERVICE_INTERFACE);
        dataModel.put("package_service_impl",TemplateBuilder.PACKAGE_SERVICE_INTERFACE_IMPL);
        dataModel.put("package_rpc",TemplateBuilder.PACKAGE_RPC_INTERFACE);
        dataModel.put("package_rpc_impl",TemplateBuilder.PACKAGE_RPC_INTERFACE_IMPL);
        dataModel.put("package_feign",TemplateBuilder.PACKAGE_FEIGN);
        //其他属性
        dataModel.put("author",TemplateBuilder.AUTHOR);
        dataModel.put("Tid","#{id}");//表的id
        dataModel.put("sharp_start","#{");
        dataModel.put("sharp_end","}");
        dataModel.put("Tablelogic",TemplateBuilder.TABLE_LOGIC);
        dataModel.put("create_time", DateUtils.ldtToStr(LocalDateTime.now()));

        // 创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer out = new FileWriter(new File(file));
        // 调用模板对象的process方法输出文件。
        template.process(dataModel, out);
        // 关闭流。
        out.close();
    }
}
