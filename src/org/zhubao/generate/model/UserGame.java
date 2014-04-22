package org.zhubao.generate.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zhubao.model.BaseModel;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

@TableBind(tableName = "z_usergame", pkName = "userGameId")
public class UserGame extends BaseModel<UserGame> {
	private static final long serialVersionUID = 1L;
	public static UserGame dao = new UserGame();
	private Integer userGameId;
	private Integer userId;
	private Integer gameId;
	private Date joinedDate;

	public void setUserGameId(Integer userGameId) {
		this.userGameId = userGameId;
	}

	public Integer getUserGameId() {
		return userGameId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	@Override
	public List<String> showAttrs() {
		List<String> showAttrs = new ArrayList<String>();
		showAttrs.add("userGameId");
		showAttrs.add("userId");
		showAttrs.add("gameId");
		showAttrs.add("joinedDate");
		return showAttrs;
	}

	public Record findByUserIdAndGameId(int userId, int gameId) {
		Record record = Db.findFirst(
				"SELECT * FROM z_usergame WHERE userId = ? AND gameId = ?",
				userId, gameId);
		return record;
	}
}