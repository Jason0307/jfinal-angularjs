/**
 * 
 */
package org.zhubao.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.bee.tl.core.GroupTemplate;
import org.bee.tl.core.Template;

import com.jfinal.kit.PathKit;

/**
 * @author Jason.Zhu
 * @date 2014-3-19
 * @email jasonzhu@augmentum.com.cn
 */
public class GenerateBuilderUtil {

	public static void main(String[] args) throws Exception {
		GroupTemplate group = new GroupTemplate(new File(
				PathKit.getWebRootPath() + "/WEB-INF/templateroot"));
		Template template = group.getFileTemplate("/model.btl");
		BuilderModel builderModel = XMLUtil.readModelsFromXML();
		List<Model> models = builderModel.getModels();
		String database = builderModel.getDb();
		String packageName = builderModel.getPackageName();
		if (!models.isEmpty()) {
			for (Model model : models) {
				template.set("model", model);
				String content = template.getTextAsString();
				System.out.println(content);
				String filePath = PathUtil.getSrcPath() + "/src/"
						+ packageName.replace(".", "/");
				File directory = new File(filePath);
				if (!directory.exists()) {
					directory.mkdirs();
				}
				File modelFile = new File(filePath + "/" + model.getName()
						+ ".java");
				if (!modelFile.exists()) {
					modelFile.createNewFile();
					BufferedWriter bw = new BufferedWriter(new FileWriter(
							modelFile));
					bw.write(content);
					bw.close();
				}
			}
		}
		String sqlPath = PathUtil.getSrcPath() + "/sql";
		File sqlDirectory = new File(sqlPath);
		if (!sqlDirectory.exists()) {
			sqlDirectory.mkdirs();
		}

		File sqlFile = new File(sqlPath + "/init.sql");
		if (!sqlFile.exists()) {
			sqlFile.createNewFile();
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(sqlFile));
		String sql = XMLUtil.initTableSQL(models, database);
		bw.write(sql);
		bw.close();

	}
}
