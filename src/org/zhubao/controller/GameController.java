/**
 * 
 */
package org.zhubao.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.zhubao.generate.model.Game;
import org.zhubao.generate.model.GameRecord;
import org.zhubao.generate.model.Leaderboard;
import org.zhubao.util.ConstantsUtil;
import org.zhubao.util.JsonUtil;
import org.zhubao.vo.GameResultVo;

import com.jfinal.ext.route.ControllerBind;
import com.jfinal.upload.UploadFile;

/**
 * @author Jason.Zhu
 * @date 2014-3-14
 * @email jasonzhu@augmentum.com.cn
 */
@ControllerBind(controllerKey = "/game", viewPath = "/page/game/")
public class GameController extends BaseController<Game> {

	public void addGame() {
		render("addGame.jsp");
	}

	public void upload() {
		String saveDir = getRequest().getSession().getServletContext()
				.getRealPath("/upload");
		UploadFile uFile = getFile();
		File file = uFile.getFile();
		String filename = file.getName();
		String type = filename.substring(filename.lastIndexOf(".") + 1);
		String newName = System.currentTimeMillis() + "." + type;
		file.renameTo(new File(saveDir + "/" + newName));
		renderJson(ConstantsUtil.UPLOAD_DIR + "/" + newName);
	}

	public void json() {
		// System.out.println(JsonUtil.parseRequestJson(getRequest(),
		// Game.class));
		renderCustomJson(Game.dao.findByList());
	}

	public void save() {
		Game game = getModel(Game.class);
		game.set("createdDate", new Date()).save();
		renderJson("{\"success\":true}");
	}

	public void recordGameResult() throws Exception {
		int userId = getParaToInt("userId", 0);
		GameResultVo resultVo = JsonUtil.parseStringToVo(
				getPara("gameResultVo", ""), GameResultVo.class);
		assertUserExist(userId);
		if (null != resultVo) {
			assertGameExsit(resultVo.getGameId());
			GameRecord result = new GameRecord();
			result.set("userId", userId).set("gameId", resultVo.getGameId())
					.set("score", resultVo.getScore())
					.set("gainDate", new Date()).save();
		}
		List<GameRecord> userGameRecords = GameRecord.dao
				.getGameRecords(userId);
		renderCustomJson(userGameRecords);
	}

	public void leaderboard() {
		renderCustomJson(Leaderboard.dao.findByList());
	}
}
