/**
 * 
 */
package org.zhubao.model;

import java.util.List;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;

/**
 * @author Jason.Zhu
 * @date 2014-3-14
 * @email jasonzhu@augmentum.com.cn
 */
@TableBind(tableName = "z_game", pkName = "gameId")
public class Game extends Model<Game> {
	private static final long serialVersionUID = 1L;
	public static Game dao = new Game();
	/*private String tableName;

	public Game() {
		TableBind tb = Game.class.getAnnotation(TableBind.class);
		tableName = tb.tableName();
	}

	public Game findByAttr(String attr, String value) {
		Game game = Game.dao.findFirst("SELECT * FROM " + tableName + " WHERE "
				+ attr + " = ?", value);
		return game;
	}

	public List<Game> getGames() {
		List<Game> games = Game.dao.find("SELECT * FROM " + tableName);
		return games;
	}*/
	/* (non-Javadoc)
	 * @see org.zhubao.model.BaseModel#showAttrs()
	 */
}
