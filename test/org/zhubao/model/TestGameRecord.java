/**
 * 
 */
package org.zhubao.model;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.zhubao.generate.model.GameRecord;

import com.jfinal.ext.render.excel.PoiKit;

/**
 * @author Jason.Zhu
 * @date 2014-4-24
 * @email jasonzhu@augmentum.com.cn
 */
public class TestGameRecord extends BaseTest<GameRecord>{

	@Test
	public void testGameRecord() throws Exception {
		GameRecord gameRecord = GameRecord.dao.findById(1);
		System.out.println(gameRecord);
		assertNotNull(gameRecord);
		
		HSSFWorkbook bok =  PoiKit.export("GameRecord", -5 , 1 , new String[]{"recordId", "userId", "gameId", "score", "date"},new String[]{"recordId", "userId", "gameId", "score", "date"},GameRecord.dao.findByList(),5,false);
	    bok.write(new FileOutputStream(new File("game.xls")));
	}
}
