package org.zhubao.generate.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zhubao.model.BaseModel;

import com.jfinal.ext.plugin.tablebind.TableBind;

@TableBind(tableName = "z_game", pkName = "gameId")
public class Game extends BaseModel<Game>{
	private static final long serialVersionUID = 1L;
	public static Game dao = new Game();
	private Integer gameId;
    private String gameName;
    private String description;
    private Date createdDate;
    private String icon;
    public void setGameId(Integer gameId){
	    this.gameId = gameId;
    }

    public Integer getGameId(){
        return gameId;
    }
    public void setGameName(String gameName){
	    this.gameName = gameName;
    }

    public String getGameName(){
        return gameName;
    }
    public void setDescription(String description){
	    this.description = description;
    }

    public String getDescription(){
        return description;
    }
    public void setCreatedDate(Date createdDate){
	    this.createdDate = createdDate;
    }

    public Date getCreatedDate(){
        return createdDate;
    }
    public void setIcon(String icon){
	    this.icon = icon;
    }

    public String getIcon(){
        return icon;
    }

    @Override
	public List<String> showAttrs() {
	    List<String> showAttrs = new ArrayList<String>();
		showAttrs.add("gameId");
		showAttrs.add("gameName");
		showAttrs.add("description");
		showAttrs.add("createdDate");
		showAttrs.add("icon");
		return showAttrs;
	}
}