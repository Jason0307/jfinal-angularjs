/**
 * 
 */
package org.zhubao.controller;

import java.io.File;
import java.util.Date;

import org.zhubao.model.Game;
import org.zhubao.util.ConstantsUtil;
import org.zhubao.util.JsonUtil;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.upload.UploadFile;


/**
 * @author Jason.Zhu
 * @date   2014-3-14
 * @email jasonzhu@augmentum.com.cn
 */
@ControllerBind(controllerKey = "/game", viewPath = "/page/game/")
public class GameController extends Controller{

	public void index(){
		render("index.jsp");
	}
	public void addGame(){
		render("addGame.jsp");
	}
	public void upload(){
		String saveDir = getRequest().getSession().getServletContext().getRealPath("/upload");
		UploadFile uFile = getFile();
		File file = uFile.getFile();
		String filename = file.getName();
		String type = filename.substring(filename.lastIndexOf(".")+1);
		String newName = System.currentTimeMillis() + "." + type;
		file.renameTo(new File(saveDir + "/" + newName));
		renderJson(ConstantsUtil.UPLOAD_DIR +"/" +newName);
	}
	
	public void json(){
		System.out.println(JsonUtil.parseRequestJson(getRequest(), Game.class));
		renderJson("{\"success\":true}");
	}
	
	public void save(){
		Game game = getModel(Game.class);
				game.set("createdDate", new Date()).save();
		System.out.println(game.get("gameName"));
		System.out.println(game.get("description"));
		System.out.println(game.get("gameName"));
		renderJson("{\"success\":true}");
	}
	
}
