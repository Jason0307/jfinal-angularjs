/**
 * 
 */
package org.zhubao.model;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.ParameterizedType;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * @author Jason.Zhu
 * @date 2014-4-24
 * @email jasonzhu@augmentum.com.cn
 */
public class BaseTest<T extends Model<T>> {
	private DruidPlugin druidPlugin;
	private ActiveRecordPlugin arp;
	private Class<T> modelClass;
    private static Logger logger = Logger.getLogger(BaseTest.class);
	@SuppressWarnings("unchecked")
	public BaseTest() {
		modelClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Before
	public void setUp() {
		String jdbcConfig = PathKit.getWebRootPath() + "/WEB-INF/jdbc.properties";
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(jdbcConfig)));
			druidPlugin = new DruidPlugin(
					properties.getProperty("jdbcUrl").toString(),properties.getProperty("user").toString(),
					properties.getProperty("password").toString());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		arp = new ActiveRecordPlugin(druidPlugin);
		TableBind tableBind = modelClass.getAnnotation(TableBind.class);
		String modelTable = tableBind.tableName();
		String modelPk = tableBind.pkName();
		arp.addMapping(modelTable, modelPk, modelClass);
		druidPlugin.start();
		arp.start();

	}

	@After
	public void setDown() {
		if (null != druidPlugin) {
			druidPlugin.stop();
		}
		if (null != arp) {
			arp.stop();
		}
	}
}
