package org.zhubao.generate.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zhubao.model.BaseModel;

import com.jfinal.ext.plugin.tablebind.TableBind;

@TableBind(tableName = "z_gamerecord", pkName = "recordId")
public class GameRecord extends BaseModel<GameRecord> {
	private static final long serialVersionUID = 1L;
	public static GameRecord dao = new GameRecord();
	private Long recordId;
	private Integer gameId;
	private Integer score;
	private Integer userId;
	private Date gainDate;

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return score;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getGainDate() {
		return gainDate;
	}

	public void setGainDate(Date gainDate) {
		this.gainDate = gainDate;
	}

	@Override
	public List<String> showAttrs() {
		List<String> showAttrs = new ArrayList<String>();
		showAttrs.add("recordId");
		showAttrs.add("gameId");
		showAttrs.add("score");
		showAttrs.add("userId");
		showAttrs.add("gainDate");
		return showAttrs;
	}

	/**
	 * @param userId
	 * @return
	 */
	public List<GameRecord> getGameRecords(int userId) {
		List<GameRecord> records = GameRecord.dao.find(
				"SELECT * FROM z_gamerecord WHERE userId = ?", userId);
		return records;
	}
	
	
}